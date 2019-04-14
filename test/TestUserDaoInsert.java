//import com.dao.UserDao;
//import com.pojo.User;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.Date;
//import java.sql.Timestamp;
//
///**
// * PACKAGE_NAME
// * Created by ForMe
// * 2019/3/27
// * 13:02
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:spring-mybatis.xml"})
//public class TestUserDaoInsert {
//    @Autowired
//    private UserDao userDao;
//
//    @Test
//    public void testInsert(){
//        User user = new User();
//        user.setPassword("123456");
//        user.setUsername("admin3");
//        user.setSex("female");
//        user.setQqnum("1787932750");
//        user.setEmail("1787932750@qq.com");
//        user.setSelfIntroduction("我是一个好学生");
//        user.setRegistertime(new Timestamp(new Date().getTime()));
//        userDao.addUser(user);
//    }
//}
