package com.PhoneShop.service;

import com.PhoneShop.component.EmailUtils;
import com.PhoneShop.entity.OrderDetailEntity;
import com.PhoneShop.entity.OrdersEntity;
import com.PhoneShop.entity.UserEntity;
import com.PhoneShop.model.*;
import com.PhoneShop.repository.OrderDetailRepository;
import com.PhoneShop.repository.OrderRepository;
import com.PhoneShop.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private EmailUtils emailUtils;

    public boolean createOrder(BillingOrder billingOrder) {
        ModelMapper modelMapper = new ModelMapper();
        //try {
            // Get user from order and save to DB
            User user = billingOrder.getUser();
            Integer userId = user.getId();
            if(userId == null) {
                UserEntity userEntity = modelMapper.map(user, UserEntity.class);
                userEntity.setUsername("");
                userEntity.setPassword("");
                UserEntity newUserEntity = userRepository.save(userEntity);
                userId = newUserEntity.getId();
            }

            // Get order and save to DB
            Order order = billingOrder.getOrder();
            order.setUserId(userId);
            OrdersEntity ordersEntity = modelMapper.map(order, OrdersEntity.class);
            ordersEntity.setOrderDate(new Date());
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.add(Calendar.DATE, 1);
            ordersEntity.setShipDate(cal.getTime());
            OrdersEntity newOrdersEntity = orderRepository.save(ordersEntity);

            List<OrderDetail> orderDetailList = order.getOrderDetailList();
            List<OrderDetailEntity> orderDetailEntityList = modelMapper.map(orderDetailList, new TypeToken<List<OrderDetailEntity>>() {}.getType());
            for(OrderDetailEntity item: orderDetailEntityList) {
                item.setOrderId(newOrdersEntity.getId());
            }
            orderDetailRepository.saveAll(orderDetailEntityList);
            sendMail(user.getEmail());
            return true;
//        } catch (Exception e) {
//            return false;
//        }

    }

    private void sendMail(String email) {
        String content = "<p>Đặt hàng thành công</p>";
        emailUtils.sendMail("Đặt hàng thành công", content, Arrays.asList(email), null, null);
    }
}
