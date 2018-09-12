package MyBatis.Mapper;

import MyBatis.model.Student;
import org.apache.ibatis.annotations.Param;

/**
 * 映射器接口
 */
public interface StudentMapper {

    /**
     * 获取用户信息
     *
     * @param name
     * @param pass
     * @return
     */
    Student get(@Param("name") String name, @Param("pass") String pass);

}
