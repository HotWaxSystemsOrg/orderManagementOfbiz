<form name='findOrders' method="post" action="<@ofbizUrl>SearchOrders</@ofbizUrl>">
    <table cellspacing='0'>
        <tr>
            <td>${uiLabelMap.OrderOrderId}</td>
            <td><input type='text' name='orderId'/></td>
        </tr>
        <tr>
            <td>${uiLabelMap.OrderStatusId}</td>
            <td><input type='text' name='statusId'/></td>
        </tr>
        <tr>
            <td>${uiLabelMap.OrderOrderDate}</td>
            <td><input type='text' name='orderDate'/></td>
        </tr>
        <tr>
            <td>${uiLabelMap.OrderFirstName}</td>
            <td><input type='text' name='firstName'/></td>
        </tr>
        <tr>
            <td>${uiLabelMap.OrderLastName}</td>
            <td><input type='text' name='lastName'/></td>
        </tr>
        <tr>
            <td>${uiLabelMap.OrderPaymentStatus}</td>
            <td><input type='text' name='paymentStatusId'/></td>
        </tr>
        <tr>
            <td>${uiLabelMap.OrderAddress1}</td>
            <td><input type='text' name='address1'/></td>
        </tr>
        <tr>
            <td>${uiLabelMap.OrderAddress2}</td>
            <td><input type='text' name='address2'/></td>
        </tr>
        <tr>
            <td>${uiLabelMap.OrderOrderCity}</td>
            <td><input type='text' name='city'/></td>
        </tr>
        <tr>
            <td>${uiLabelMap.OrderPostalCode}</td>
            <td><input type='text' name='postalCode'/></td>
        </tr>
        <tr>
            <td>${uiLabelMap.OrderOrderState}</td>
            <td><input type='text' name='stateProvinceGeoId'/></td>
        </tr>
        <tr>
            <td>${uiLabelMap.OrderOrderCountry}</td>
            <td><input type='text' name='countryGeoId'/></td>
        </tr>
        <tr><td colspan="3"><hr /></td></tr>
        <tr>
            <td/>
            <td>
                <input type="hidden" name="showAll" value="Y"/>
                <input type='submit' value='${uiLabelMap.CommonFind}'/>
            </td>
        </tr>
    </table>
</form>
