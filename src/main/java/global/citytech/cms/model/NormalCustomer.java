/*
 * User: RikeshLalShrestha
 * Created at: 9/2/20, 3:39 PM
 */

package global.citytech.cms.model;

public class NormalCustomer extends AbstractCustomer {
    String workoutTime;

    public NormalCustomer(String name, String address, String email, String joinYear, int age, String workoutTime) {
        super(name, address, email, joinYear, age);
        this.workoutTime = workoutTime;
    }

//    public String getWorkoutTime() {
//        return workoutTime;
//    }
//
//    public void setWorkoutTime(String workoutTime) {
//        this.workoutTime = workoutTime;
//    }

    public void show() {
        System.out.println("Id='" + id + '\'' +
                ", Name='" + name + '\'' +
                ", Address='" + address + '\'' +
                ", Email='" + email + '\'' +
                ", Join Year='" + joinYear + '\'' +
                ", Age=" + age +
                ", Workout Time='" + workoutTime + '\'' +
                ", Paid ='" + (paidForMembership ? "YES" + '\'' + ", Package='" + joinPackage : "NO") + '\'');
    }
}
