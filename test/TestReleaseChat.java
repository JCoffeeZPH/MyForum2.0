import com.dao.ChatsDao;
import com.pojo.Chats;
import com.service.ChatsService;
import com.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

/**
 * PACKAGE_NAME
 * Created by ForMe
 * 2019/4/1
 * 13:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class TestReleaseChat {

    @Autowired
    private ChatsDao chatsDao;

    @Test
    public void test(){
        Chats chats = new Chats();
        chats.setChatid(UUID.randomUUID().toString().replaceAll("-","_"));
        chats.setUserid(2);
        chats.setUsername("admin1");
        chats.setContent("Java简单易学吗？");
        chats.setReleasetime(new Timestamp(new Date().getTime()));
        chatsDao.release(chats);
    }
}
