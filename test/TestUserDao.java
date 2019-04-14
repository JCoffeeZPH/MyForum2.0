//import com.dao.UserDao;
//import com.pojo.User;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.List;
//
///**
// * Created by ForMe
// * 2019/3/27
// * 12:21
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:spring-mybatis.xml"})
//public class TestUserDao {
//    @Autowired
//    private UserDao userDao;
//
//    @Test
//    public void testUserDao(){
//        List<User> list = userDao.getAllUser();
//        for(User user : list){
//            System.out.println(user.getUsername() + " " + user.getPassword());
//        }
//    }
//}
