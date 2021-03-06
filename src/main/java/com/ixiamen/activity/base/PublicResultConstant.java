package com.ixiamen.activity.base;

/**
 * @author luoyongbin
 * @since 2018-05-03
 */
public class PublicResultConstant {

    public static final String FAILED = "系统错误";

    public static final String SUCCEED = "操作成功";

    public static final String UNAUTHORIZED = "获取登录用户信息失败";

    public static final String ERROR = "操作失败";


    public static final String BUSINESSEXCEPTION_ERROR = "数据操作失败：";

    public static final String DATA_ERROR = "数据操作错误";

    public static final String PARAM_ERROR = "参数错误";

    public static final String INVALID_USERNAME_PASSWORD = "用户名或密码错误";

    public static final String INVALID_RE_PASSWORD = "两次输入密码不一致";

    public static final String INVALID_USER = "用户不存在";

    public static final String DISABLE_MYSELF = "不能冻结自己的账户";

    public static final String INVALID_USER_EXIST = "用户已存在";

    public static final String INVALID_USER_ROLE_EXIST = "用户已存在角色";

    public static final String INVALID_ROLE = "角色不存在";

    public static final String INVALID_ROLE_EXIST = "角色已存在";

    public static final String ROLE_USER_USED = "角色使用中，不可删除";

    public static final String ROLE_BUILT_IN = "系统内置角色，不可删除";


    public static final String USER_NO_PERMITION = "当前用户无该接口权限";

    public static final String VERIFY_PARAM_ERROR = "校验码错误";

    public static final String VERIFY_PARAM_PASS = "校验码过期";

    public static final String MOBILE_ERROR = "手机号格式错误";

    public static final String UPDATE_ROLEINFO_ERROR = "更新角色信息失败";

    public static final String UPDATE_SYSADMIN_INFO_ERROR = "不能修改管理员信息!";

    public static final String EMAIL_ERROR = "邮箱格式错误";

    //角色管理
    public static class RoleResult {

        public static final String NULL_ROLE_CODE = "角色编码不能为空";

        public static final String NULL_ROLE_NAME = "角色名称不能为空";

        public static final String NULL_ROLE_POWER = "角色类型不能为空";


        public static final String NULL_RMENU_CODES = "菜单编码不能为空";

        public static final String NULL_ROLE_CONF_USERNO = "请选择要分配的用户";
    }

    //用户管理
    public static class UserResult {

        public static final String NULL_USER_USERNO = "用户编码不能为空";

        public static final String NULL_USER_ROLECODE = "角色编码不能为空";

        public static final String NULL_USER_USERNAME = "角色名不能为空";

        public static final String INVALID_USER_SELF = "用户名不是当前登录账号的用户名";

    }


}
