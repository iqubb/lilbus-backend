package com.qubb.lilbus.model;

import com.qubb.lilbus.enumeration.PaymentMethod;
import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "User")
@Table(name = "client")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;

    @Column(
            name = "phone_number",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true,
            length = 13
    )
    private String phoneNumber;


    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;


    @Column(name = "order_time")
    private LocalDate orderTime;

    public User() {

    }

    public User(Long id, String phoneNumber, PaymentMethod paymentMethod, LocalDate orderTime) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.paymentMethod = paymentMethod;
        this.orderTime = orderTime;
    }

    public User(String phoneNumber, PaymentMethod paymentMethod, LocalDate orderTime) {
        this.phoneNumber = phoneNumber;
        this.paymentMethod = paymentMethod;
        this.orderTime = orderTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDate orderTime) {
        this.orderTime = orderTime;
    }
}
