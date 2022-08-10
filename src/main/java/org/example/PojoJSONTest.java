package org.example;

import java.util.Arrays;

public class PojoJSONTest {

    private String firstname;
    private String lastname;
    private int age;
    private Address address;

    private String[] companylist;
    public String getFirstname()
    {
        return this.firstname;
    }
    public void setFirstname(String firstName)
    {
        this.firstname=firstName;
    }
    public String getLastname()
    {
        return lastname;
    }
    public void setLastname(String lastName)
    {
        this.lastname=lastName;
    }

    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age=age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String[] getCompanylist()
    {
        return companylist;
    }
    public void setCompanylist(String[] company)
    {
        this.companylist=company;
    }

    @Override
    public String toString() {
        return "{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", companylist=" + Arrays.toString(companylist) +
                '}';
    }
}
