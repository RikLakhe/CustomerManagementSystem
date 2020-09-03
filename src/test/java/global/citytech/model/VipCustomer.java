/*
 * User: RikeshLalShrestha
 * Created at: 9/2/20, 3:39 PM
 */

package global.citytech.model;

public class VipCustomer extends AbstractCustomer {
    String personalTrainer;
    double discount;

    public VipCustomer(String name, String address, String email, String joinYear, int age, String personalTrainer, double discount) {
        super(name, address, email, joinYear, age);
        this.personalTrainer = personalTrainer;
        this.discount = discount;
    }

    public String getPersonalTrainer() {
        return personalTrainer;
    }

    public void setPersonalTrainer(String personalTrainer) {
        this.personalTrainer = personalTrainer;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void show() {
        System.out.println("Id='" + id + '\'' +
                ", Name='" + name + '\'' +
                ", Address='" + address + '\'' +
                ", Email='" + email + '\'' +
                ", Join Year='" + joinYear + '\'' +
                ", Age=" + age +
                ", Personal Trainer='" + personalTrainer + '\'' +
                ", Paid =" + (paidForMembership ? "YES" : "NO"));
    }
}
