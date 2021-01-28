package com.test.pojo;

/**
 * Created by abhinav.garg on 2021-01-28
 */
public class Branch extends BankInfo {

    private String ifscCode;

    private String address;


    public Branch(String name, String ifscCode, String address){
        super(name);
        this.ifscCode = ifscCode;
        this.address = address;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
