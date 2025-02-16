<form name='findOrders' method="post" action="<@ofbizUrl>SearchOrders</@ofbizUrl>">
    <div id="findOrders" class="screenlet">
        <div class="screenlet-body">
            <table class="basic-table" cellspacing='0'>
                <tr>
                    <td class='label'>${uiLabelMap.OrderOrderId}</td>
                    <td><input type='text' name='orderId'/></td>
                </tr>
                <tr>
                    <td class='label'>${uiLabelMap.OrderStatusId}</td>
                    <td ><input type='text' name='statusId'/></td>
                </tr>
                <tr>
                    <td class='label'>${uiLabelMap.OrderOrderDate}</td>
                    <td ><input type='text' name='orderDate'/></td>
                </tr>
                <tr>
                    <td  class='label'>${uiLabelMap.OrderFirstName}</td>
                    <td ><input type='text' name='firstName'/></td>
                </tr>
                <tr>
                    <td  class='label'>${uiLabelMap.OrderLastName}</td>
                    <td ><input type='text' name='lastName'/></td>
                </tr>
                <tr>
                    <td  class='label'>${uiLabelMap.OrderPaymentStatus}</td>
                    <td ><input type='text' name='paymentStatusId'/></td>
                </tr>
                <tr>
                    <td  class='label'>${uiLabelMap.OrderAddress1}</td>
                    <td ><input type='text' name='address1'/></td>
                </tr>
                <tr>
                    <td  class='label'>${uiLabelMap.OrderAddress2}</td>
                    <td ><input type='text' name='address2'/></td>
                </tr>

                <tr>
                    <td class='label'>${uiLabelMap.OrderOrderCity}</td>
                    <td ><input type='text' name='city' /></td>
                </tr>
                <tr>
                    <td  class='label'>${uiLabelMap.OrderPostalCode}</td>
                    <td ><input type='text' name='postalCode'/></td>
                </tr>
                <tr>
                    <td  class='label'>${uiLabelMap.OrderOrderState}</td>
                    <td ><input type='text' name='stateProvinceGeoId'/></td>
                </tr>
                <tr>
                    <td  class='label'>${uiLabelMap.OrderOrderCountry}</td>
                    <td ><input type='text' name='countryGeoId'/></td>
                </tr>
                <tr><td colspan="3"><hr /></td></tr>
                <tr>
                    <td class="label"/>
                    <td>
                        <input type="hidden" name="showAll" value="Y"/>
                        <input type='submit' value='${uiLabelMap.CommonFind}'/>
                    </td>
                </tr>
            </table>
            </td>
            </tr>
            </table>
        </div>
    </div>
</form>