
import com.russionbear.notesapp.backend.userinfo.UserInfoApplication;
import com.russionbear.notesapp.backend.userinfo.mapper.UserInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserInfoApplication.class)
class UserInfoTest {

    @Resource
    UserInfoMapper userInfoMapper;

    @Test
    void contextLoads() {
        System.out.println(userInfoMapper.getAll(0));
    }

}
