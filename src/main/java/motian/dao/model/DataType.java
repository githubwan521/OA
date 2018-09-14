package motian.dao.model;

/**
 * @Author: gongzhanjing
 * @Email: gongzhanjing@xiyoulinux.org
 * @Date: 2018/9/12 16:41
 */

public class DataType {
    interface IDataType {
    }

    public enum UserType implements IDataType {
        ALL(1),                 //所有员工
        IN_SERVICE(2),          //在职
        DIMISSION(3),           //离职

        ;

        private final int code;

        UserType(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

    public enum SundryType implements IDataType {
        IDENTITY(1),           //角色身份
        DEPARTMENT(2),         //角色部门


        UNKNOWN(100),         //未知
        ;

        private final int code;

        SundryType(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

    }


    public enum IdentityType implements IDataType {
        ADMINISTRATORS(1),          // 管理员
        ORDINARY(2),                //普通员工

        ;

        private final int code;

        IdentityType(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

    public enum DepartmentType implements IDataType {
        TECHNOLOGY(1),              // 技术部
        HUMAN_RESOURCES(2),         //人力资源部

        ;

        private final int code;

        DepartmentType(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

}