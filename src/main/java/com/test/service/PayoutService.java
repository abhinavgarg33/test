package com.test.service;

import com.test.pojo.Account;
import com.test.pojo.Transaction;

import java.util.List;

/**
 * Created by abhinav.garg on 2021-01-28
 */
public interface PayoutService {


    boolean transfer(Transaction transaction);

    boolean transfer(List<Transaction> transaction);



}
