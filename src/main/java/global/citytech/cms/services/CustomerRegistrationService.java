/*
 * User: RikeshLalShrestha
 * Created at: 9/2/20, 3:44 PM
 */

package global.citytech.cms.services;

import global.citytech.cms.model.Customer;

public interface CustomerRegistrationService {
    String register(Customer customer);
    void findCustomer(String customerName);
    Customer findCustomerByIdentifier(String customerId);
    String payCustomerByPrice(Customer customer,int packagePrice, String packageName);
}
