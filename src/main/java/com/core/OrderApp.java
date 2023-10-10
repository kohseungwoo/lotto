package com.core;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.core.order.OrderService;

public class OrderApp {
    
    public static void main(String[] args) {

        // 스프링 사용 전
        // AppConfig config = new AppConfig();
        // OrderService orderService = config.orderService();

        
        // 스프링 사용 후
        // 스프링 컨테이너 ApplicationContext 를 스프링 컨테이너라 한다.
        // 기존에는 개발자가 AppConfig를 사용해서 직접 객체를 생성하고 DI를 했지만, 이제부터는 스프링 컨테이너를 통해서 사용한다.
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = context.getBean("orderService", OrderService.class);

        System.out.println("몇 장을 구매할 것인지 입력해주세요.");
        int size = new Scanner(System.in).nextInt();
        if(size == 0) size = 1;
        orderService.createOrder(size);
    }
}
