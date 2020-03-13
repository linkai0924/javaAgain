package ioc;

public class TestIOC {

 public static void main(String[] args) throws Exception {
        MyApplicationContext myApplicationContext=new MyApplicationContext();
         UserService userService =(UserService)myApplicationContext.getBean("userService");
        userService.findUser("张三");
}

}