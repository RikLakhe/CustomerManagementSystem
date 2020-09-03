/*
 * User: RikeshLalShrestha
 * Created at: 9/3/20, 6:17 PM
 */

package global.citytech.services;

import global.citytech.model.Customer;
import global.citytech.model.VipCustomer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

class VipCustomerRegistrationServiceImpl implements CustomerRegistrationService {
    //    List to save all the new created vip customers
    private List<VipCustomer> vipCustomers;
    private static final Logger LOGGER = Logger.getLogger(VipCustomerRegistrationServiceImpl.class.getName());

    //    construction; when called in CustomerRegistrationServiceFactory to create a instance of this class
    public VipCustomerRegistrationServiceImpl() {
        this.vipCustomers = new ArrayList<>();
    }

    //    Overrides the registration service in CustomerRegistrationService
    @Override
    public String register(Customer customer) {
        VipCustomer vipCustomer = (VipCustomer) customer;
        LOGGER.info("===> before size ====>" + this.vipCustomers.size());
        this.vipCustomers.add(vipCustomer);
        LOGGER.info("===> after size ====>" + this.vipCustomers.size());
        return "got it";
    }

    @Override
    public void findCustomer(String customerName) {
        if (this.vipCustomers.size() == 0) {
            System.out.println("No data entered!");
        } else {
            boolean found = false;
            for (VipCustomer customer : this.vipCustomers) {
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
        if (this.vipCustomers.size() == 0) {
            System.out.println("No data entered!");
        } else {
            for (VipCustomer customer : this.vipCustomers) {
                if (customer.getId().equals(customerId)) {
                    return customer;
                }
            }
            System.out.println("No record found");
        }
        return null;
    }

    @Override
    public String payCustomerByPrice(Customer customer, int packagePrice, String packageName) {
        VipCustomer vipCustomer = (VipCustomer) customer;
        double discount = vipCustomer.getDiscount();
        double actualPrice = packagePrice - packagePrice * (discount / 100);
        System.out.println("Actual price : Rs. " + actualPrice);
        vipCustomer.setPaidForMembership(true);
        vipCustomer.setJoinPackage(packageName);
        return "Paid";
    }
}
