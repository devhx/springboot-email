package cn.h.mail;

import cn.h.MailApplicationTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author hux
 * @datetime 2019-07-10 13:42
 * @description
 */
public class SendMailTest extends MailApplicationTest {

    @Resource
    private SendMail sendMail;

    @Test
    public void sendTextTest() {
        //测试发送文本邮件
        sendMail.sendText("569414230@QQ.com", "这是邮件标题", "这是邮件内容");
    }

    @Test
    public void sendHtmlTest() {
        //测试发送Html邮件
        sendMail.sendHtml("569414230@QQ.com", "这是邮件标题", "<h1>这是邮件内容</h1>");
    }

}
