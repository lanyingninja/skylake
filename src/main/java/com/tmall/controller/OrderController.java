
package com.tmall.controller;


import com.tmall.dto.Result;
import com.tmall.pojo.Order;
import com.tmall.service.OrderItemService;
import com.tmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;

@RestController
public class OrderController {
	@Autowired
    OrderService orderService;
	@Autowired
    OrderItemService orderItemService;

    @GetMapping("/orders")
    public Page<Order> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
    	start = start<0?0:start;
    	Page<Order> page =orderService.list(start, size, 5);
    	orderItemService.fill(page.getContent());
        orderService.removeOrderFromOrderItem(page.getContent());
        return page;
    }
    @PutMapping("deliveryOrder/{oid}")
    public Object deliveryOrder(@PathVariable int oid) throws IOException {
        Order o = orderService.get(oid);
        o.setDeliveryDate(new Date());
        o.setStatus(OrderService.waitConfirm);
        orderService.update(o);
        return Result.success();
    }
}


