
# 准备工作
 开启PO3/SMTP服务
 打开qq邮箱>账户
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200413183532101.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2pva2VyZGoyMzM=,size_16,color_FFFFFF,t_70)
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200413183612859.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2pva2VyZGoyMzM=,size_16,color_FFFFFF,t_70)
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200413183720901.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2pva2VyZGoyMzM=,size_16,color_FFFFFF,t_70)
==记住这串授权码 会用到==

# java发送qq邮箱实现步骤
1. 创建一个javase的工程
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020041318393529.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2pva2VyZGoyMzM=,size_16,color_FFFFFF,t_70)
2. 新建一个lib文件夹 放邮件发送所需要的架包 
架包链接：链接：https://pan.baidu.com/s/17m0nA7UDjgHoi9mbFDSrag 
提取码：2faa 

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200413184116831.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2pva2VyZGoyMzM=,size_16,color_FFFFFF,t_70)
3. 编写核心代码 我这里封装了 也可以不封装
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200413184907692.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2pva2VyZGoyMzM=,size_16,color_FFFFFF,t_70)

```java
/**
 * @author joker_dj
 * @create 2020-04-13日 18:43
 */
public class Email {

    public void qqemai(String QQmail,String head,String body) throws AddressException, MessagingException {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");// 连接协议
        properties.put("mail.smtp.host", "smtp.qq.com");// 主机名
        properties.put("mail.smtp.port", 465);// 端口号
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
        properties.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
        // 得到回话对象
        Session session = Session.getInstance(properties);
        // 获取邮件对象
        Message message = new MimeMessage(session);
        // 设置发件人邮箱地址
        message.setFrom(new InternetAddress("****@qq.com"));
        // 设置收件人邮箱地址
        message.setRecipients(Message.RecipientType.TO,
                new InternetAddress[] { new InternetAddress(QQmail) });
        //new InternetAddress();设置同时发送多个好友
        // 设置邮件标题
        message.setSubject(head);
        // 设置邮件内容
        message.setText(body);
        // 得到邮差对象
        Transport transport = session.getTransport();
        // 连接自己的邮箱账户
        transport.connect("****@qq.com", "*****授权码");// 密码为QQ邮箱开通的stmp服务后得到的客户端授权码
        // 发送邮件
        int i=0;
        transport.sendMessage(message, message.getAllRecipients());
        System.out.println("成功！");
        transport.close();
    }
}

```
4. 编写main方法
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200413185101988.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2pva2VyZGoyMzM=,size_16,color_FFFFFF,t_70)

```java
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
        qq.qqemai(QQmail, head, body);
    }
}
```
5. 运行测试
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200413185612456.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2pva2VyZGoyMzM=,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200413185554280.png)
测试成功

