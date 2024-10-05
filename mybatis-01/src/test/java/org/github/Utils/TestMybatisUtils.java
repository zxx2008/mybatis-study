package org.github.Utils;

import org.apache.ibatis.session.SqlSession;
import org.github.zxx2008.User;

import java.util.List;

public class TestMybatisUtils {
    public static void main(String[] args) {
        TestMybatisUtils.testMybatisUtils();
    }
    public static void testMybatisUtils() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            List<User> userList = sqlSession.selectList("test.selectAll");
            for (User user : userList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
