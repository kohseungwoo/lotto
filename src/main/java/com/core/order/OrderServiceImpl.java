package com.core.order;

import com.core.call.CallRepository;

public class OrderServiceImpl implements OrderService{

    private final CallRepository callRepository;

    public OrderServiceImpl(CallRepository callRepository){
        this.callRepository = callRepository;
    }

    @Override
    public void createOrder(int size){
        callRepository.findNumber(size);
    }
}
