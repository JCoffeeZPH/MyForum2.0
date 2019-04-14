import com.dao.ChatsDao;
import com.dao.CommentsDao;
import com.pojo.Chats;
import com.pojo.Comments;
import com.service.ChatsService;
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
 * 16:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class TestCommentInsert {
    @Autowired
    private ChatsService chatsService;

    @Test
    public void insert(){
       Chats chats = chatsService.getChatById("8a22ad5a698a2ca301698a2d2e9f0000");
        System.out.println(chats.getContent());
    }
}
