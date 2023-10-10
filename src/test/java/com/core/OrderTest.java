package com.core;

import java.util.Random;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {
 
    @Test
    @DisplayName("랜덤 테스트")
    void creatOrder(){
        Random random = new Random();
        int a = random.nextInt(45)+1;
        
        Assertions.assertThat(a).isBetween(1,45);
    }
}
