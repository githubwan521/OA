package MyBatis.Demo;

import MyBatis.Mapper.StudentMapper;
import MyBatis.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;


public class MybatisDemo {

    public static void main(String[] args) throws Exception {
        // 获得主配置文件的流数据
        String resource = "/MyBatis/conf/jdbc.properties";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 通过主配置文件创建 会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过会话工厂获得会话
        SqlSession session = sqlSessionFactory.openSession();

        // 通过会话获得映射器接口
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        // 使用映射器接口操作数据
        Student student = mapper.get("motian", "pass");

        System.out.println(student);

    }

}
