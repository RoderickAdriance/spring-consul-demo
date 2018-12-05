package cn.creatoo.cloudtransactionconsumer.service;

public interface TransferService {
    void transfer(String sourceAcctId,String Id, double amount);
}
