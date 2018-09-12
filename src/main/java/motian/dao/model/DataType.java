package motian.dao.model;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/12 16:41
 */

public class DataType {
    public interface IDataType {
    }

    public enum identityType implements IDataType {
        ADMINISTRATORS(1),          // 管理员
        ORDINARY(2),                //普通员工

        ;

        private final int code;

        identityType(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

    public enum departmentType implements IDataType {
        TECHNOLOGY(1),              // 技术部
        HUMAN_RESOURCES(2),         //人力资源部

        ;

        private final int code;

        departmentType(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }
}