/*
 * User: RikeshLalShrestha
 * Created at: 9/3/20, 3:49 PM
 */

/*
 * User: RikeshLalShrestha
 * Created at: 9/3/20, 3:34 PM
 */

package global.citytech.view;

import global.citytech.model.Customer;
import global.citytech.model.NormalCustomer;
import global.citytech.model.VipCustomer;
import global.citytech.services.CustomerRegistrationServiceFactory;

import java.util.Scanner;

public class FrontDeskView {
    Scanner sc = new Scanner(System.in);

    private String readLine() {
        return sc.nextLine();
    }

    private int readIntLine() {
        return sc.nextInt();
    }

    public void start() {

        loop:
        while (true) {
            System.out.println("Write action (register, find, pay, exit):");
            String choice = readLine();

            switch (choice) {
                case "register":
                    customerRegistrationProcess();
                    break;
                case "find":
                    customerFindProcess();
                    break;
                case "pay":
                    customerPayProcess();
                    break;
                case "exit":
                    break loop;
                default:
                    System.out.println("Invalid input!");
            }
        }
    }

    private void customerPayProcess() {
        System.out.println("Customer ID:");
        String id = readLine();
        System.out.println("Category? 1 - Normal, 2 - VIP");
        String category = readLine();
        Customer foundCustomer;
        switch (category) {
            case "1":
                foundCustomer = CustomerRegistrationServiceFactory.get("normal").findCustomerByIdentifier(id);
                if (foundCustomer != null) {
                    packagePaymentProcess(foundCustomer, "normal");
                }
                break;
            case "2":
                foundCustomer = CustomerRegistrationServiceFactory.get("vip").findCustomerByIdentifier(id);
                if (foundCustomer != null) {
                    packagePaymentProcess(foundCustomer, "vip");
                }
                break;
            default:
                System.out.println("Invalid input!");
                break;
        }
    }

    private void packagePaymentProcess(Customer foundCustomer, String customerType) {
        System.out.println("Packages :");
        System.out.println("1 - Only Gym : Rs. 400");
        System.out.println("2 - Gym and Zumba : Rs. 500");
        System.out.println("3 - Quick Fix : Rs. 600");
        String selectPackage = readLine();
        switch (selectPackage) {
            case "1":
                System.out.println(CustomerRegistrationServiceFactory.get(customerType).payCustomerByPrice(foundCustomer, 400));
                break;
            case "2":
                System.out.println(CustomerRegistrationServiceFactory.get(customerType).payCustomerByPrice(foundCustomer, 500));
                break;
            case "3":
                System.out.println(CustomerRegistrationServiceFactory.get(customerType).payCustomerByPrice(foundCustomer, 600));
                break;
            default:
                System.out.println("Invalid input! Pay process terminated!");
                break;
        }
    }

    private void customerFindProcess() {
        System.out.println("Customer Name:");
        String name = readLine();
        System.out.println("Category? 1 - Normal, 2 - VIP");
        String category = readLine();
        switch (category) {
            case "1":
                CustomerRegistrationServiceFactory.get("normal").findCustomer(name);
                break;
            case "2":
                CustomerRegistrationServiceFactory.get("vip").findCustomer(name);
                break;
            default:
                System.out.println("Invalid input!");
                break;
        }
    }

    private void customerRegistrationProcess() {
        System.out.println("Enter name:");
        String name = readLine();
        System.out.println("Enter Address:");
        String address = readLine();
        System.out.println("Enter Email:");
        String email = readLine();
        System.out.println("Enter Join year:");
        String joinYear = readLine();
        System.out.println("Enter Age:");
        int age = readIntLine();
        readLine();  // Consume newline left-over
        while (true) {
            if (customerRegistrationSelectionProcess(name, address, email, joinYear, age)) break;
        }
    }

    private boolean customerRegistrationSelectionProcess(String name, String address, String email, String joinYear, int age) {
        System.out.println("Category? 1 - Normal, 2 - VIP, back - to main menu:");
        String category = readLine();
        switch (category) {
            case "1":
                registerNormalCustomer(name, address, email, joinYear, age);
                return true;
            case "2":
                registerVipCustomer(name, address, email, joinYear, age);
                return true;
            case "back":
                return true;
            default:
                System.out.println("Invalid input!");
                break;
        }
        return false;
    }

    private void registerNormalCustomer(String name, String address, String email, String joinYear, int age) {
        System.out.println("Enter Workout time:");
        String workoutTime = readLine();
        NormalCustomer normalCustomer = new NormalCustomer(
                name,
                address,
                email,
                joinYear,
                age,
                workoutTime
        );
        CustomerRegistrationServiceFactory.get("normal").register(normalCustomer);
    }

    private void registerVipCustomer(String name, String address, String email, String joinYear, int age) {
        System.out.println("Enter Personal Trainer:");
        String personalTrainer = readLine();
        System.out.println("Enter Discount:");
        double discount = sc.nextDouble();
        readLine();
        VipCustomer vipCustomer = new VipCustomer(
                name,
                address,
                email,
                joinYear,
                age,
                personalTrainer,
                discount
        );
        CustomerRegistrationServiceFactory.get("vip").register(vipCustomer);
    }


}
