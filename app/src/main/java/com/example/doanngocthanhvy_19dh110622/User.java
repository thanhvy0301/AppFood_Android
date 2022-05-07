package com.example.doanngocthanhvy_19dh110622;

import java.io.Serializable;

public class User implements Serializable {
    String id;
    String firstname, lastname, email, address, mobile;

    public User(){ }

    public User(String id,String firstname, String lastname, String email, String address, String latitude, String longitude, String mobile) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
//        this.latitude = latitude;
//        this.longitude = longitude;
        this.mobile = mobile;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    public String getLatitude() {
//        return latitude;
//    }
//
//    public void setLatitude(String latitude) {
//        this.latitude = latitude;
//    }
//
//    public String getLongitude() {
//        return longitude;
//    }
//
//    public void setLongitude(String longitude) {
//        this.longitude = longitude;
//    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstname + '\'' +
                ", lastName='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
//                ", latitude='" + latitude + '\'' +
//                ", longitude='" + longitude + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }

}
