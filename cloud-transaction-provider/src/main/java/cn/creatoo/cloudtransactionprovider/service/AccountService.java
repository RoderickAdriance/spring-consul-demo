package cn.creatoo.cloudtransactionprovider.service;

public interface AccountService {
    void increaseAmount(String accountId, double amount);
    void decreaseAmount(String accountId, double amount);
}
