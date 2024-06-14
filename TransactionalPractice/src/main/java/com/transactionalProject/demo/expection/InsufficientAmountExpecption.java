package com.transactionalProject.demo.expection;

public class InsufficientAmountExpecption extends RuntimeException{
    public InsufficientAmountExpecption(String msg){
        super(msg);
    }
}
