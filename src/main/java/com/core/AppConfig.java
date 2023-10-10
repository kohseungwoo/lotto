package com.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.core.call.IncludeRepository;
import com.core.order.OrderService;
import com.core.order.OrderServiceImpl;


/* OCP, DIP를 수행 */
/* IoC,DI 컨테이너 (AppConfig처럼 객체를 생성하고 관리하면서 의존관계를 연결해주는 것) 또는 어샘블러, 오브젝트 팩토리라 불림*/
/* 의존관계 주입이란, 실행시점(런타임)에 외부에서 실제 구현 객체를 생성하고 클라이언트에 전달해서 클라이언트와 서버의 실제 의존관계가 연결되는 것 */

@Configuration //application 설정정보에 configuration 을 넣어준다.
public class AppConfig {
    
    /* 생성자 주입 */
    // configuration 설정정보 메서드들에 bean을 등록해주면 spring container에 등록된다.
    // @Bean("memberService") // 이와 같이 이름을 지정할수있다.
    
    @Bean
    public OrderService orderService(){
        /** 기본 랜덤번호 추출 */
        // return new OrderServiceImpl(new DefaultRepository()); 

        /** 고정번호 + 랜덤번호 추출 */
        // return new OrderServiceImpl(new PixRepository()); 

        /** 제거번호 + 랜덤번호 추출 */
        // return new OrderServiceImpl(new RemoveRepository()); 

        /** 포함번호만 추출 */
        return new OrderServiceImpl(new IncludeRepository()); 
    }
}
