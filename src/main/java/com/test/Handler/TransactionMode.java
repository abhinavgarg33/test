package com.test.Handler;

import com.test.pojo.Transaction;

/**
 * Created by abhinav.garg on 2021-01-28
 */
public abstract class TransactionMode {

    public abstract boolean execute(Transaction transaction);

}
