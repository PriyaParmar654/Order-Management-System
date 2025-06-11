package com.springboot.application.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.application.dta.OrderDto;
// import com.project.etities.Customer;
import com.springboot.application.entities.Order;
import com.springboot.application.entities.Product;
// import com.project.etities.Review;
import com.springboot.application.services.CustomerServices;
import com.springboot.application.services.OrderServices;
import com.springboot.application.services.ProductServices;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

    @Autowired
    private OrderServices orderServices;

    @Autowired
    private ProductServices productServices;

    @Autowired
    private CustomerServices custServices;

    //customer view order
    @CrossOrigin(origins = "http://localhost:3001")
    @GetMapping("/{cid}")
    public ResponseEntity<HashMap<String, Object>> getOrders(@PathVariable("cid") int cid){
        HashMap<String, Object> orders = custServices.getOrders(cid);
        return ResponseEntity.ok(orders);
    }

    //employee page get request
    @GetMapping("/stafforders/{id}")
    public ResponseEntity<List<Order>> getStaffOrders(@PathVariable("id") int id){
        System.out.print("get method called"+id);
        List<Order> orders = orderServices.findByStaff(id);
        System.out.print(orders);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/custid/{cid}")
    public ResponseEntity<List<Product>> findOrdersForCustomer(@PathVariable("cid") int cid)
    {
        List<Product> productList=new ArrayList<>();
        List<Order> orderList=orderServices.findAll();
        for(Order order:orderList)
        {
            if(order.getCId()==cid)
            {
                Product p=order.getProduct();
                productList.add(p);
            }
        }
        return ResponseEntity.ok(productList);
    }

    @GetMapping("")
    public ResponseEntity<List<Order>> findAll(){
        List<Order> orderList = orderServices.findAll();
        if(orderList ==  null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(orderList);
    }
    //order placed by the customer

    @PostMapping("/putorder")
    public ResponseEntity<Order> putorder(@RequestBody OrderDto order){
        System.out.println(order);
        Order newOrder = new Order();
        newOrder.setCId(order.getcId());
        newOrder.setProduct(productServices.findById(order.getpId()));
        newOrder.setDdate(order.getDdate());
        newOrder.setQty(order.getQty());
        newOrder.setODate(order.getoDate());
        newOrder.setStatus(order.getStatus());
        newOrder.setPaymentmode(order.getPaymentmode());
        Order placedOrder = orderServices.save(newOrder);
        return ResponseEntity.ok(placedOrder);
    }


    @PutMapping("/cancel/{oid}")
    public ResponseEntity<Order> cancelorder(@PathVariable("oid") int oid ){
        Order order = orderServices.cancelOrder(oid);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/product-customer")
    public ResponseEntity<HashMap<String, Object>> getOrders() {
        HashMap<String, Object> ht = new HashMap<String, Object>();
        List<Order> orderList = orderServices.findAll();

        for(Order order:orderList)
        {
            ht.put("product", order.getProduct());
            ht.put("customer",custServices.findById( order.getCId()) ) ;

        }

        return ResponseEntity.ok(ht);
    }


    @GetMapping("/changestatus/{oid}/{status}")

    public ResponseEntity<Order> changeStatus(@PathVariable("oid") int oid,@PathVariable("status") String status)
    {
        System.out.println("inside chnage status");
        Order order=orderServices.findById(oid);
        order.setStatus(status);
        orderServices.save(order);
        return null;

    }

    @PutMapping("/assignstaff/{cId}")
    public ResponseEntity<Order> assignStaff(@PathVariable("cId") int cId ,@RequestBody Order order)
    {

        Order order1=orderServices.findById(cId);
        System.out.println("customer id is........... "+order1.getStaffId());
        order1.setStaffId(cId);
        orderServices.save(order);
        //System.out.println(orderServices.toString());
        return ResponseEntity.ok(order);
    }

}

