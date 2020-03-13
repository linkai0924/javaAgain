package ioc;

@MyComponent
public class UserService {

    @MyAutowired
 private UserDao userDao;

 public void findUser(String userName) {
        userDao.findUser(userName);
    }


}