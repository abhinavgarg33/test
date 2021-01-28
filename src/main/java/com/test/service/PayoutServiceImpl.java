package com.test.service;

import com.test.Handler.IMPSTransaction;
import com.test.Handler.NEFTTransaction;
import com.test.Handler.TransactionMode;
import com.test.pojo.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by abhinav.garg on 2021-01-28
 */
public class PayoutServiceImpl implements PayoutService {


    /**
     * Map will sit inside repositories where we will take lock
     */

    public static Map<TransactionType, TransactionMode> transactionTypeTransactionModeMap = new HashMap<>();

    static Map<TransactionType,Integer> typeToTransactionMap = new HashMap<>();

    static Map<String, Integer> accountNumberToTransactionMap = new HashMap<>();

    static {
        transactionTypeTransactionModeMap.put(TransactionType.IMPS, new IMPSTransaction());
        transactionTypeTransactionModeMap.put(TransactionType.NEFT, new NEFTTransaction());

        /**
         * We can set crons for refreshing limit daily
         */

        typeToTransactionMap.put(TransactionType.IMPS,1);
        typeToTransactionMap.put(TransactionType.NEFT,1);

        accountNumberToTransactionMap.put("1234",2);
    }

    public synchronized boolean transfer(Transaction transaction) {

        Account payee = transaction.getPayee();

        double amount = payee.getAmount();

        if(transaction.getAmount() > amount){
            throw new RuntimeException("ammount insufficient");
        }

        if(accountNumberToTransactionMap.get(payee.getAccountNumber())<0){
            throw new RuntimeException("reached max limit");
        }

        TransactionType transactionType = transaction.getTransactionType();

        if(typeToTransactionMap.get(transactionType)<0){
            throw new RuntimeException("reached max limit for type");
        }

        transactionTypeTransactionModeMap.get(transactionType).execute(transaction);

        payee.setAmount(transaction.getAmount());

        accountNumberToTransactionMap.put(payee.getAccountNumber(),accountNumberToTransactionMap.get(payee.getAccountNumber())-1);

        typeToTransactionMap.put(transactionType,typeToTransactionMap.get(transactionType)-1);

        return true;

    }

    public boolean transfer(List<Transaction> transaction) {

        transaction.parallelStream().forEach(t->{
            try {
                transfer(t);
            }catch (Exception ex){
                System.out.println("ex = " + ex);
            }
        });

        return true;
    }
}
