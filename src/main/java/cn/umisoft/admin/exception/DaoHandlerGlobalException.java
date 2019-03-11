package cn.umisoft.admin.exception;

/**
 * @description: Dao数据访问过程中主动检测到相关问题时，可选择抛出该异常，配合全局异常捕获使用
 * @author: hujie@umisoft.cn
 * @date: 2019/1/14 11:30 AM
 */
public class DaoHandlerGlobalException extends RuntimeException {
    public DaoHandlerGlobalException() {
        super();
    }

    public DaoHandlerGlobalException(String message) {
        super(message);
    }

    public DaoHandlerGlobalException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoHandlerGlobalException(Throwable cause) {
        super(cause);
    }

    protected DaoHandlerGlobalException(String message, Throwable cause,
                                               boolean enableSuppression,
                                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
