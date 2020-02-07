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
    String uRole;
    @Column(name = "umanager")
    String uManager;

    public Users() {
    }

    public Users(String uName, String uAddress, String uPhone, String uRole, String uManager) {
        this.uName = uName;
        this.uAddress = uAddress;
        this.uPhone = uPhone;
        this.uRole = uRole;
        this.uManager = uManager;
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
