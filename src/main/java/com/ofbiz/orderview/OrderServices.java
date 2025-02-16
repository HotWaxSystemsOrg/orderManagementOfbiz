package com.ofbiz.orderview;

import org.apache.ofbiz.base.util.Debug;
import org.apache.ofbiz.base.util.UtilValidate;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.entity.condition.EntityCondition;
import org.apache.ofbiz.entity.condition.EntityOperator;
import org.apache.ofbiz.entity.util.EntityQuery;
import org.apache.ofbiz.service.DispatchContext;
import org.apache.ofbiz.service.ServiceUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderServices {
    public static final String module = OrderServices.class.getName();

    /**
     * Finds orders based on search parameters
     */
    public static Map<String, Object> findOrder(DispatchContext dctx, Map<String, ?> context) {
        Delegator delegator = dctx.getDelegator();
        List<EntityCondition> conditions = new ArrayList<>();

        // Add filtering conditions based on provided context
        addCondition(conditions, "orderId", context.get("orderId"));
        addCondition(conditions, "orderStatusId", context.get("orderStatusId"));
        addCondition(conditions, "paymentMethodTypeId", context.get("paymentMethodTypeId"));

        // Handle Customer Name (first name, last name)
        addConditionLike(conditions, "firstName", context.get("firstName"));
        addConditionLike(conditions, "lastName", context.get("lastName"));

        // Handle Order Date Range (fromDate, toDate)
        addDateRangeCondition(conditions, context);

        // Handle Shipping Address (address1, address2, city, postalCode, etc.)
        addConditionLike(conditions, "address1", context.get("address1"));
        addConditionLike(conditions, "address2", context.get("address2"));
        addConditionLike(conditions, "city", context.get("city"));
        addConditionLike(conditions, "postalCode", context.get("postalCode"));
        addCondition(conditions, "stateProvinceGeoId", context.get("stateProvinceGeoId"));
        addCondition(conditions, "countryGeoId", context.get("countryGeoId"));

        List<GenericValue> orderList = new ArrayList<>();
        try {
            // Construct query using conditions and fetch the result
            orderList = EntityQuery.use(delegator)
                    .from("FindOrderView")
                    .where(EntityCondition.makeCondition(conditions, EntityOperator.AND))
                    .orderBy("orderDate") // You can modify this to order by other fields
                    .queryList();
        } catch (GenericEntityException e) {
            Debug.logError(e, "Error finding orders", module);
            return ServiceUtil.returnError("Error retrieving orders: " + e.getMessage());
        }

        // For pagination, return metadata along with order list
        int totalResults = orderList.size(); // For pagination (you can use a more advanced pagination method)
        int startIndex = (Integer) context.get("startIndex") != null ? (Integer) context.get("startIndex") : 0;
        int pageSize = (Integer) context.get("pageSize") != null ? (Integer) context.get("pageSize") : 20;

        List<GenericValue> pagedOrders = orderList.subList(startIndex, Math.min(startIndex + pageSize, totalResults));

        // Return results with metadata
        Map<String, Object> result = ServiceUtil.returnSuccess();
        result.put("orderList", pagedOrders);
        result.put("totalResults", totalResults);
        return result;
    }

    // Helper method to add a condition for exact matches
    private static void addCondition(List<EntityCondition> conditions, String fieldName, Object value) {
        if (UtilValidate.isNotEmpty(value)) {
            conditions.add(EntityCondition.makeCondition(fieldName, EntityOperator.EQUALS, value));
        }
    }

    // Helper method to add a condition for partial matches (case-insensitive LIKE)
    private static void addConditionLike(List<EntityCondition> conditions, String fieldName, Object value) {
        if (UtilValidate.isNotEmpty(value)) {
            conditions.add(EntityCondition.makeCondition(fieldName, EntityOperator.LIKE, "%" + value.toString().toLowerCase() + "%"));
        }
    }

    // Helper method to handle date range conditions
    private static void addDateRangeCondition(List<EntityCondition> conditions, Map<String, ?> context) {
        Object fromDate = context.get("fromDate");
        Object toDate = context.get("toDate");

        if (UtilValidate.isNotEmpty(fromDate)) {
            conditions.add(EntityCondition.makeCondition("orderDate", EntityOperator.GREATER_THAN_EQUAL_TO, fromDate));
        }

        if (UtilValidate.isNotEmpty(toDate)) {
            conditions.add(EntityCondition.makeCondition("orderDate", EntityOperator.LESS_THAN_EQUAL_TO, toDate));
        }
    }
}
