/*
 * User: RikeshLalShrestha
 * Created at: 9/2/20, 3:39 PM
 */

package global.citytech.model;

import java.util.UUID;

abstract class AbstractCustomer implements Customer {
    String id;
    String name;
    String address;
    String email;
    String joinYear;
    String joinPackage;
    int age;
    boolean paidForMembership;

    AbstractCustomer(String name, String address, String email, String joinYear, int age) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
        this.email = email;
        this.joinYear = joinYear;
        this.age = age;
        this.paidForMembership = false;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getJoinYear() {
        return joinYear;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJoinYear(String joinYear) {
        this.joinYear = joinYear;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isPaidForMembership() {
        return paidForMembership;
    }

    public void setPaidForMembership(boolean paidForMembership) {
        this.paidForMembership = paidForMembership;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJoinPackage() {
        return joinPackage;
    }

    public void setJoinPackage(String joinPackage) {
        this.joinPackage = joinPackage;
    }
}
