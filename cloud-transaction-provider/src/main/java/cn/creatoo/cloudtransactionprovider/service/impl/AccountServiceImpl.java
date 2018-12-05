package cn.creatoo.cloudtransactionprovider.service.impl;

import cn.creatoo.cloudtransactionprovider.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("AA")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public void increaseAmount(String accountId, double amount) {
        this.jdbcTemplate.update("update tb_account_one set amount = amount - ? where acct_id = ?", amount, accountId);
        System.out.printf("undo increase: acct= %s, amount= %7.2f%n", accountId, amount);
    }

    @Override
    @Transactional
    public void decreaseAmount(String accountId, double amount) {
        this.jdbcTemplate.update("update tb_account_one set amount = amount + ? where acct_id = ?", amount, accountId);
        System.out.printf("undo decrease: acct= %s, amount= %7.2f%n", accountId, amount);
    }
}
