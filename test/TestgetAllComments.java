//import com.dao.CommentsDao;
//import com.pojo.Comments;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.List;
//
///**
// * PACKAGE_NAME
// * Created by ForMe
// * 2019/4/1
// * 17:18
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:applicationContext.xml"})
//public class TestgetAllComments {
//    @Autowired
//    private CommentsDao commentsDao;
//
//    @Test
//    public void test(){
//        List<Comments> list = commentsDao.getAllComments("8a22ad5a698a2ca301698a2d2e9f0000");
//        for(Comments comments : list)
//            System.out.println(comments.getComment());
//    }
//}
