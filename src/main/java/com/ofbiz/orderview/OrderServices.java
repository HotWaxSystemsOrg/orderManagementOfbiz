package com.ofbiz.orderview;

import org.apache.ofbiz.base.util.Debug;
import org.apache.ofbiz.base.util.UtilValidate;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.entity.condition.EntityCondition;
import org.apache.ofbiz.entity.condition.EntityOperator;
import org.apache.ofbiz.entity.util.EntityQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderServices {
    public static final String module = OrderServices.class.getName();

    public static Map<String, Object> findOrders(DispatchContext dctx, Map<String, ?> context) {
        Delegator delegator = dctx.getDelegator();
        List<EntityCondition> conditions = new ArrayList<>();

        // Utility method to add condition to the list
        addCondition(conditions, "orderId", context.get("orderId"));
        addCondition(conditions, "statusId", context.get("statusId"));
        addCondition(conditions, "orderDate", context.get("orderDate"));
        addConditionLike(conditions, "firstName", context.get("firstName"));
        addConditionLike(conditions, "lastName", context.get("lastName"));
        addCondition(conditions, "paymentStatusId", context.get("paymentStatusId"));
        addConditionLike(conditions, "address1", context.get("address1"));
        addConditionLike(conditions, "address2", context.get("address2"));
        addConditionLike(conditions, "city", context.get("city"));
        addCondition(conditions, "postalCode", context.get("postalCode"));
        addCondition(conditions, "stateProvinceGeoId", context.get("stateProvinceGeoId"));
        addCondition(conditions, "countryGeoId", context.get("countryGeoId"));

        List<GenericValue> orderList = new ArrayList<>();
        try {
            // Query orders based on constructed conditions
            orderList = EntityQuery.use(delegator)
                    .from("FindOrderView")
                    .where(EntityCondition.makeCondition(conditions, EntityOperator.AND))
                    .queryList();
        } catch (GenericEntityException e) {
            Debug.logError(e, "Error finding orders", module);
            return ServiceUtil.returnError("Error retrieving orders: " + e.getMessage());
        }

        // Log and return results
        Debug.logInfo("Found orders: " + orderList.size(), module);
        Map<String, Object> result = ServiceUtil.returnSuccess();
        result.put("orderList", orderList);
        return result;
    }

    private static void addCondition(List<EntityCondition> conditions, String fieldName, Object value) {
        if (UtilValidate.isNotEmpty(value)) {
            conditions.add(EntityCondition.makeCondition(fieldName, EntityOperator.EQUALS, value));
        }
    }

    private static void addConditionLike(List<EntityCondition> conditions, String fieldName, Object value) {
        if (UtilValidate.isNotEmpty(value)) {
            conditions.add(EntityCondition.makeCondition(fieldName, EntityOperator.LIKE, "%" + value + "%"));
        }
    }
}
