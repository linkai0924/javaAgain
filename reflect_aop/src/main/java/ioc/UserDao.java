package ioc;

@MyComponent
public class UserDao {

 public void findUser(String userName) {
        System.out.println("找到了一个用户名字叫:"+userName);
    }
}