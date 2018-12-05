package cn.creatoo.cloudtransactionconsumer.controller;

import cn.creatoo.cloudtransactionconsumer.service.AccountService;
import cn.creatoo.cloudtransactionconsumer.service.TransferService;
import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Compensable(interfaceClass = TransferService.class)
@Controller
@RestController
public class ConsumerController implements TransferService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/simplified/transfer")
    @Transactional
    @Override
    public void transfer(String sourceAcctId, String targetAcctId, double amount) {
        this.increaseAmount(targetAcctId, amount);
        this.accountService.decreaseAmount(sourceAcctId, amount);
        throw new IllegalStateException("error");
    }

    private void increaseAmount(String acctId, double amount) {
        this.jdbcTemplate.update("update tb_account_two set amount = amount + ? where acct_id = ?", amount, acctId);
        System.out.println("Increase Amount Success!!!");
    }


}
