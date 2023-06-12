package com.bicycle.config;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

public class SendEmail {
    /**
     * 发送邮箱验证码
     * @param email
     * @return String 验证码
     */
    public static String sendEmail(String email) {
        // 随机码
        Random random = new Random();
        String code = String.valueOf(random.nextInt(9999) + 1000);

        // 收件人电子邮箱
        String to = email;

        // 发件人电子邮箱
        String from = "2605735186@qq.com";

        // 指定发送邮件的主机为 localhost
        String host = "smtp.qq.com";

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");

        // 获取默认session对象

        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("2605735186@qq.com", "tymkrmdtpyhkeabc"); //发件人邮件用户名、授权码
            }
        });

        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject("来自天府骑行验证码");

            // 设置消息体
            message.setText("验证码位：" + code + "，请在5分钟内完成验证！");

            // 发送消息
            Transport.send(message);
            System.out.println("成功！");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
        return code;
    }
}
