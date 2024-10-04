package org.github;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.github.zxx2008.User;


import java.io.InputStream;
import java.util.List;

public class MyBatisDemo {
    public static void main(String[] args) throws IOException {
        // 1. 加载mybatis核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = null;
        // 2. 获取SqlSession对象，用它来执行sql
        try {
            sqlSession = sqlSessionFactory.openSession(); // 打开 SqlSession

            // 使用 sqlSession 进行数据库操作
            List<User> users = sqlSession.selectList("test.selectAll");
            System.out.println(users);
        } catch (Exception e) {
            if (sqlSession != null) {
                sqlSession.rollback(); // 出现异常时回滚事务
            }
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close(); // 确保 SqlSession 被关闭
            }
        }
    }
}
