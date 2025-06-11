package com.springboot.application.entities;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Data
@Table(name = "orders")
public class Order {


    @Id
    @Column(name = "o_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oId;

    @OneToOne(orphanRemoval = false)
    @JoinColumn(name = "p_id")
    private Product product;


    @Column(name = "c_id")
    private int cId;

    @Column(name = "p_qty")
    private int qty;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "o_date")
    private Date oDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "d_date")
    private Date ddate;

    @Column(name = "status")
    private String status;


    @Column(name="staff_id")
    private int staffId;

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    @Column(name = "paymentmode")
    private String paymentmode;

    public Order(int oId, Product product, int cId, int qty, Date oDate, Date ddate, String status, int staffId,
                 String paymentmode) {

        this.oId = oId;
        this.product = product;
        this.cId = cId;
        this.qty = qty;
        this.oDate = oDate;
        this.ddate = ddate;
        this.status = status;
        this.staffId = staffId;
        this.paymentmode = paymentmode;
    }


    public Order() {
    }

    public Order(int oId, int cId, int qty, Date oDate, Date ddate, String status, int staffId) {
        this.oId = oId;

        this.cId = cId;
        this.qty = qty;
        this.oDate = oDate;
        this.ddate = ddate;
        this.status = status;
        this.staffId=staffId;
    }



    public Order(int oId, Product product, int cId, int qty, Date oDate, Date ddate, String status) {
        this.oId = oId;
        this.product = product;
        this.cId = cId;
        this.qty = qty;
        this.oDate = oDate;
        this.ddate = ddate;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order [oId=" + oId + ", product=" + product + ", cId=" + cId + ", qty=" + qty + ", oDate=" + oDate
                + ", ddate=" + ddate + ", status=" + status + ", staffId=" + staffId + "]";
    }




}
