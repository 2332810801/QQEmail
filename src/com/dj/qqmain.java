package com.dj;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.util.Scanner;

/**
 * @author joker_dj
 * @create 2020-04-13日 18:49
 */
public class qqmain {
    public static void main(String[] args) throws MessagingException {
        Email qq=new Email();
        Scanner input=new Scanner(System.in);
        System.out.println("请输入QQ号");
        String QQmail=input.next()+"@qq.com";
        System.out.println("请输入要发送的标题");
        String head=input.next();
        System.out.println("请输入要发送的文本");
        String body=input.next();
        qq.qqmai(QQmail, head, body);
    }
}
