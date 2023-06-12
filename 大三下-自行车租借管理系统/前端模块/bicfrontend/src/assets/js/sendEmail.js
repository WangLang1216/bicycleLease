import nodemailer from 'nodemailer'
import smtpTransport from 'nodemailer-smtp-transport'

let emailConfig = {
    service: 'QQ',
    user: '2605735186@qq.com',
    pass: 'eixdkimgmuuaebia'
}

// let nodemailer = require('nodemailer');

// 配置
let transport = nodemailer.createTransport(smtpTransport({
    service: emailConfig.service,
    auth: {
        user: emailConfig.user,
        pass: emailConfig.pass
    }
}));

// 发送邮件
function sendEmail(to, subject, html) {
    console.log("传递的阐参数：" + to + subject + html);
    transport.sendMail({
        from: emailConfig.user,
        to,
        subject,
        html
    }, error => {
        error ? console.log(error) : console.log('发送成功')
    })
}

// export default {
//     sendEmail
// };

sendEmail('3547839266@qq.com', '测试', '<h1>3628</h1>');