// Core java Listing 12.4
package Synch;

import java.util.*;
import java.util.concurrent.locks.*; // java获取锁的一个库

public class Bank {
    private final double[] accounts;
    private Lock bankLock; // 新建Lock类
    private Condition sufficientFunds;

    public Bank(int n, double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        bankLock = new ReentrantLock(); // ReentrantLock 可以创建一个新锁 ReentrantLock是extends了上家的锁的。
        sufficientFunds = bankLock.newCondition(); // condition object
    }

    /**
     * Transfers money from one account to another
     * @param from the account to transfer from
     * @param to the accont to transfer to
     * @param amount the amount to transfer
     * */
    public void transfer(int from, int to, double amount) throws InterruptedException{
        bankLock.lock(); // 获取锁
        try{
            while (accounts[from] < amount)
                sufficientFunds.await(); // .await方法：sufficient funds are not available
            System.out.print(Thread.currentThread()); // 获取当前线程
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            sufficientFunds.signalAll(); // This call reactives all threads waiting for the condition.
        }finally{ bankLock.unlock(); }
    }

    /**
    * Gets the sum of all account balances
    * @return the total balance
    * */
    public double getTotalBalance(){
        bankLock.lock();
        try{
            double sum = 0;
            for(double a : accounts){
                sum += a;
            }
            return sum;
        }finally{
            bankLock.unlock();
        }
    }

    /**
     * Gets the number of accounts in the bank
     * @return the number of accounts
     * */
    public int size(){
        return accounts.length;
    }
}
