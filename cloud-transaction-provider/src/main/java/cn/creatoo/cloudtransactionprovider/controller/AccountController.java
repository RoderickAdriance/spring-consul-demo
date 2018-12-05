package cn.creatoo.cloudtransactionprovider.controller;

import cn.creatoo.cloudtransactionprovider.service.AccountService;
import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Compensable(interfaceClass = AccountService.class,cancellableKey = "AA")
@RestController
public class AccountController implements AccountService{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @RequestMapping("/increase")
    @Transactional
    public void increaseAmount(String accountId, double amount) {
        this.jdbcTemplate.update("update tb_account_one set amount = amount + ? where acct_id = ?", amount, accountId);
        System.out.printf("exec increase Success: acct= %s, amount= %7.2f%n", accountId, amount);
    }

    @Override
    @RequestMapping("/decrease")
    @Transactional
    public void decreaseAmount(String accountId, double amount) {
        this.jdbcTemplate.update("update tb_account_one set amount = amount - ? where acct_id = ?", amount, accountId);
        System.out.printf("exec decrease Success: acct= %s, amount= %7.2f%n", accountId, amount);
//        throw new IllegalStateException("error");
    }
}
