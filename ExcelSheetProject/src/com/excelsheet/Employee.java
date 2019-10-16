package com.company;

import java.util.Objects;

public class Employee implements Comparable {

    private Double srNo;
    private String userName;
    private String email;
    private Double mobile;
    private String isDefault;
    private String gender;
    private String state;
    private String action;

    public Double getSrNo() {
        return srNo;
    }

    public void setSrNo(Double srNo) {
        this.srNo = srNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getMobile() {
        return mobile;
    }

    public void setMobile(Double mobile) {
        this.mobile = mobile;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return isDefault == employee.isDefault &&
                Objects.equals(srNo, employee.srNo) &&
                Objects.equals(userName, employee.userName) &&
                Objects.equals(email, employee.email) &&
                Objects.equals(mobile, employee.mobile) &&
                Objects.equals(gender, employee.gender) &&
                Objects.equals(state, employee.state) &&
                Objects.equals(action, employee.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(srNo, userName, email, mobile, isDefault, gender, state, action);
    }


    @Override
    public int compareTo(Object o) {
        Employee employee = (Employee)o;
      return  this.userName.compareTo(employee.userName);
    }


}
