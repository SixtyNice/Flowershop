package com.accenture.flowershop.entity;

import com.accenture.flowershop.Enum.Role;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "USERS")
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserEntity {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlElement(name = "idUser")
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<CartEntity> cart;

    @Column(unique = true, nullable = false)
    @XmlElement(name = "login")
    private String login;

    @Column(nullable = false)
    @XmlElement(name = "password")
    private String password;

    @Column(nullable = false)
    @XmlElement(name = "name")
    private String name;

    @Column(name = "last_name", nullable = false)
    @XmlElement(name = "lastName")
    private String lastName;

    @Column(name = "middle_name")
    @XmlElement(name = "middleName")
    private String middleName;

    @Column(nullable = false)
    @XmlElement(name = "address")
    private String address;

    @Column(nullable = false)
    @XmlElement(name = "balance")
    private BigDecimal balance;

    @Column(nullable = false)
    @XmlElement(name = "discount")
    private Double discount = 0.0;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @XmlElement(name = "role")
    private Role role = Role.USER;


    protected UserEntity() {
    }


    public UserEntity(String login, String name, String lastName, String middleName, String address) {
        this.login = login;
        this.name = name;
        this.lastName = lastName;
        this.middleName = middleName;
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", address='" + address + '\'' +
                ", balance=" + balance +
                ", discount=" + discount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
