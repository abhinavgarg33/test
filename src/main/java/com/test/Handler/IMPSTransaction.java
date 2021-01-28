package com.test.Handler;

import com.test.Handler.TransactionMode;
import com.test.pojo.Transaction;

/**
 * Created by abhinav.garg on 2021-01-28
 */
public class IMPSTransaction extends TransactionMode {


    public boolean execute(Transaction transaction) {
        return true;
    }

}
