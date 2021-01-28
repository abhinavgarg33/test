package com.test;

import com.test.pojo.*;
import com.test.service.PayoutServiceImpl;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    private Account payeeAccount;
    private Account payeerAccount;
    @Before
    public void onStartup(){

        Branch branch = new Branch("HDFC", "IFSC123", "HSR");
        payeeAccount = new Account(branch, "1234",100, new Client());
        payeerAccount = new Account(branch, "123",100, new Client());

    }

    @Test
    public void test(){

        PayoutServiceImpl payoutService = new PayoutServiceImpl();

        Transaction transaction = new Transaction(payeeAccount, 10, payeerAccount, TransactionType.IMPS);
        payoutService.transfer(transaction);

    }


    @Test
    public void testAmountInsufficient(){

        PayoutServiceImpl payoutService = new PayoutServiceImpl();

        Transaction transaction = new Transaction(payeeAccount, 1000, payeerAccount, TransactionType.IMPS);
        payoutService.transfer(transaction);

    }


    @Test
    public void testMoreThanLimit(){

        PayoutServiceImpl payoutService = new PayoutServiceImpl();

        Transaction transaction = new Transaction(payeeAccount, 10, payeerAccount, TransactionType.IMPS);
        payoutService.transfer(transaction);
        payoutService.transfer(transaction);
        payoutService.transfer(transaction);



    }

    @Test
    public void testForBatches(){

        PayoutServiceImpl payoutService = new PayoutServiceImpl();

        Transaction transaction = new Transaction(payeeAccount, 10, payeerAccount, TransactionType.IMPS);

        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction);
        transactionList.add(transaction);
        transactionList.add(transaction);
        transactionList.add(transaction);

        payoutService.transfer(transactionList);



    }





}
