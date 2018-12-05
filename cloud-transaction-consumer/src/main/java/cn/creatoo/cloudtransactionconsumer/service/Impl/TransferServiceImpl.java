package cn.creatoo.cloudtransactionconsumer.service.Impl;

import cn.creatoo.cloudtransactionconsumer.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class TransferServiceImpl implements TransferService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void transfer(String sourceAcctId,String Id, double amount) {
        this.jdbcTemplate.update("update tb_account_two set amount = amount - ? where acct_id = ?", amount, Id);
        System.out.println("Cancel increase Success !!");
    }
}
