/*
 * User: RikeshLalShrestha
 * Created at: 9/3/20, 6:16 PM
 */

package global.citytech.services;

import global.citytech.model.Customer;
import global.citytech.model.NormalCustomer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

class NormalCustomerRegistrationServiceImpl implements CustomerRegistrationService {
    private List<NormalCustomer> normalCustomers;
    private static final Logger LOGGER = Logger.getLogger(NormalCustomerRegistrationServiceImpl.class.getName());

    public NormalCustomerRegistrationServiceImpl() {
        this.normalCustomers = new ArrayList<>();
    }

    @Override
    public String register(Customer customer) {
        NormalCustomer normalCustomer = (NormalCustomer) customer;
        LOGGER.info("===> before size ====>" + this.normalCustomers.size());
        this.normalCustomers.add(normalCustomer);
        LOGGER.info("===> after size ====>" + this.normalCustomers.size());
        return "got it";
    }

    @Override
    public void findCustomer(String customerName) {
        if (this.normalCustomers.size() == 0) {
            System.out.println("No data entered!");
        } else {
            boolean found = false;
            for (NormalCustomer customer : this.normalCustomers) {
                if (customer.getName().matches(".*" + customerName + ".*")) {
                    customer.show();
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No record found");
            }
        }
    }

    @Override
    public Customer findCustomerByIdentifier(String customerId) {
        if (this.normalCustomers.size() == 0) {
            System.out.println("No data entered!");
        } else {
            for (NormalCustomer customer : this.normalCustomers) {
                if (customer.getId().equals(customerId)) {
                    return customer;
                }
            }
            System.out.println("No record found");
        }
        return null;
    }

    @Override
    public String payCustomerByPrice(Customer customer, int packagePrice) {
        NormalCustomer normalCustomer = (NormalCustomer) customer;
        normalCustomer.setPaidForMembership(true);
        return "Paid";
    }
}
