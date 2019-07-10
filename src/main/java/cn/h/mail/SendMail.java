package cn.h.mail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author hux
 * @datetime 2019-07-10 12:22
 * @description 发送邮件
 */
@Component
public class SendMail {

    @Resource
    private JavaMailSender mailSender;

    /**
     * 发件人（一般都是自己的开通smtp服务的username）
     */
    @Value("${spring.mail.username}")
    private String from;

    /**
     * 发送文本邮件
     *
     * @param to      收件人的邮箱
     * @param subject 邮件主题
     * @param content 邮件内容
     */
    public void sendText(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom(from);
        message.setText(content);
        message.setSubject(subject);
        //发送
        mailSender.send(message);
    }

    /**
     * 发送html邮件
     */
    public void sendHtml(String to, String subject, String content) {
        mailSender.send(mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
            messageHelper.setTo(to);
            messageHelper.setFrom(from);
            messageHelper.setSubject(subject);
            //这里的第二个参数就是设置是否发送html，不写或者写false的话发的就是文本邮件
            messageHelper.setText(content, true);
        });
    }


}
