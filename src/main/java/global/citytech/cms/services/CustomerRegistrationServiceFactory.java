/*
 * User: RikeshLalShrestha
 * Created at: 9/3/20, 6:17 PM
 */

package global.citytech.cms.services;

public class CustomerRegistrationServiceFactory {
    private static CustomerRegistrationService normalRegistrationService = null;
    private static CustomerRegistrationService vipRegistrationService = null;

    /*
    Singleton : one application one class only once instance
            Why: multiple access work in single instance

     */
    private CustomerRegistrationServiceFactory() {

    }

    /*
    Factory : creating instances for your classes
    Why:
    Factory, as the name suggests,
    is a place to create some different products which are somehow similar in features yet divided into categories.
    Instantiates a customerRegistrationService after determining its type normal or vip
    */
    public static CustomerRegistrationService get(String type) {
        if (type.equalsIgnoreCase("normal")) {
            if (normalRegistrationService == null) {
                normalRegistrationService = new NormalCustomerRegistrationServiceImpl();
            }
            return normalRegistrationService;
        } else if (type.equalsIgnoreCase("vip")) {
            if (vipRegistrationService == null) {
                vipRegistrationService = new VipCustomerRegistrationServiceImpl();
            }
            return vipRegistrationService;
        } else {
            throw new IllegalArgumentException("Invalid type");
        }
    }
}
