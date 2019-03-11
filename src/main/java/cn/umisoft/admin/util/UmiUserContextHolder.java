package cn.umisoft.admin.util;

/**
 * @description: <p>将当前用户USER_ID以ThreadLocal变量保存</p>
 * @author: hujie@umisoft.cn
 * @date: 2019/1/27 11:20 AM
 */
public class UmiUserContextHolder {
    private static ThreadLocal<String> context = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            // TODO Auto-generated method stub
            throw new RuntimeException("CurrentUserContextHolder缺失用户信息");
        }
        @Override
        public String get() {
            // TODO Auto-generated method stub
            return super.get();
        }
        @Override
        public void set(String userId) {
            // TODO Auto-generated method stub
            super.set(userId);
        }
        @Override
        public void remove() {
            // TODO Auto-generated method stub
            super.remove();
        }
    };

    public static String getContext() {
        return context.get();
    }

    public static void setContext(String userId) {
        context.set(userId);
    }
}
