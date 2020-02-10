package com.example.Standards.Model;

import javax.persistence.*;

@Entity
public class Users {

    @Id
    @Column(name = "uid")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
    @SequenceGenerator(name = "my_seq", initialValue = 1001, allocationSize = 1, sequenceName = "user_seq")
    int uId;
    @Column(name = "uname")
    String uName;
    @Column(name = "uaddress")
    String uAddress;
    @Column(name = "uphone")
    String uPhone;

    @Column(name = "urole")
    int uRole;

    @Column(name = "umanager")
    String uManager;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "urole", insertable = false, updatable = false)
    Roles roles;

    public Users() {
    }

    public Users(String uName, String uAddress, String uPhone, int uRole, String uManager) {
        this.uName = uName;
        this.uAddress = uAddress;
        this.uPhone = uPhone;
        this.uRole = uRole;
        this.uManager = uManager;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public int getuRole() {
        return uRole;
    }

    public void setuRole(int uRole) {
        this.uRole = uRole;
    }

    public String getuManager() {
        return uManager;
    }

    public void setuManager(String uManager) {
        this.uManager = uManager;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uAddress='" + uAddress + '\'' +
                ", uPhone='" + uPhone + '\'' +
                ", uRole='" + uRole + '\'' +
                ", uManager='" + uManager + '\'' +
                '}';
    }
}
