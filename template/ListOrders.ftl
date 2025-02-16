<table class="table table-bordered table-striped table-hover">
    <thead>
    <tr>
        <th>${uiLabelMap.OrderOrderId}</th>
        <th>${uiLabelMap.OrderStatusId}</th>
        <th>${uiLabelMap.OrderOrderDate}</th>
        <th>${uiLabelMap.OrderFirstName}</th>
        <th>${uiLabelMap.OrderLastName}</th>
        <th>${uiLabelMap.OrderPaymentStatus}</th>
        <th>${uiLabelMap.OrderAddress1}</th>
        <th>${uiLabelMap.OrderAddress2}</th>
        <th>${uiLabelMap.OrderOrderCity}</th>
        <th>${uiLabelMap.OrderPostalCode}</th>
        <th>${uiLabelMap.OrderOrderState}</th>
        <th>${uiLabelMap.OrderOrderCountry}</th>
    </tr>
    </thead>
    <#if orderList?has_content>
        <tbody>
        <#list orderList as result>
            <tr>
                <td>${result.get("orderId")!""}</td>
                <td>${result.get("orderStatusId")!""}</td>
                <td>${result.get("orderDate")!""}</td>
                <td>${result.get("firstName")!""}</td>
                <td>${result.get("lastName")!""}</td>
                <td>${result.get("paymentStatusId")!""}</td>
                <td>${result.get("address1")!""}</td>
                <td>${result.get("address2")!""}</td>
                <td>${result.get("city")!""}</td>
                <td>${result.get("postalCode")!""}</td>
                <td>${result.get("stateProvinceGeoId")!""}</td>
                <td>${result.get("countryGeoId")!""}</td>
            </tr>
        </#list>
        </tbody>
    <#else>
        <tbody>
        <tr><td colspan="12"> </td></tr>
        </tbody>
    </#if>
</table>