package com.bicycle.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.bicycle.common.R;
import com.bicycle.config.SendEmail;
import com.bicycle.entity.CustAccount;
import com.bicycle.entity.Customer;
import com.bicycle.entity.dto.RegisterAccountDto;
import com.bicycle.service.CustAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bicycle.service.CustomerService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/user")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustAccountService custAccountService;

    /**
     * 发送邮箱验证码
     * @param email
     * @return String
     */
    @GetMapping("/sendEmail/{email}")
    public R<String> sendEmail(@PathVariable String email) {
        String emailCode = SendEmail.sendEmail(email);
        return emailCode.equals("") ? R.error("获取失败！") : R.success(emailCode);
    }

    /**
     * 更新用户信息
     * @param customer
     * @return Integer
     */
    @PostMapping("/updateUser")
    public R<Integer> updateUser(@RequestBody Customer customer) {
        int r = customerService.updateCustomer(customer);
        return r == 0 ? R.error("更新失败！") : R.success(r);
    }

    /**
     * 修改密码
     * @param map
     * @return Integer
     */
    @PostMapping("/resettingAccount")
    public R<Integer> resettingAccount(@RequestBody Map<String, String> map){
        String email = map.get("email");
        String password = map.get("password");
        int r = custAccountService.resettingAccount(email, password);
        return r == 0 ? R.error("重置密码失败！") : R.success(r);
    }

    /**
     * 登录
     * @param ca
     * @param request
     * @return CustAccount
     */
    @PostMapping("/loginAccount")
    public R<CustAccount> loginAccount(@RequestBody CustAccount ca, HttpServletRequest request){
        String accountcustId = ca.getAccountcustId();
        String cPassword = ca.getcPassword();
        //查询账号
        LambdaQueryWrapper<CustAccount> lqw = new LambdaQueryWrapper<>();
        lqw.eq(CustAccount::getAccountcustId, accountcustId);
        CustAccount custAccount = custAccountService.getOne(lqw);
        if (custAccount == null) return R.error("手机号不存在，请先注册！");
        if (!custAccount.getcPassword().equals(cPassword)) return R.error("密码有误，请检查后输入");
        if (custAccount.getcStatus() == 1) return R.error("账号已禁用，请联系商家处理！");
        //登录成功，将id存入Session, 并返回登录成功结果
        request.getSession().setAttribute("accountcustId",custAccount.getAccountcustId());
        return R.success(custAccount);
    }


    /**
     * 注册
     * @param registerAccountDto
     * @return Integer
     */
    @PostMapping("/registerAccount")
    public R<Integer> registerAccount(@RequestBody RegisterAccountDto registerAccountDto){
        int r = custAccountService.registerAccount(registerAccountDto);
        if (r == 0) return R.error("账号不能为空!");
        if (r == -1) return R.error("密码不能为空!");
        if (r == -2) return R.error("身份账号不能为空!");
        if (r == -3) return R.error("电子邮箱不能为空!");
        if (r == -4) return R.error("该账号已存在，初始密码为身份证后六位！");
        return R.success(r);
    }


    /**
     * 根据id查询用户信息
     * @param custaccountId
     * @return CustAccount
     */
    @GetMapping("/queryCustomerById/{custaccountId}")
    public R<Customer> queryCustomerById(@PathVariable String custaccountId){
        Customer customer = customerService.queryCustomerById(custaccountId);
        return customer == null ? R.error("查询失败！") : R.success(customer);
    }
}
