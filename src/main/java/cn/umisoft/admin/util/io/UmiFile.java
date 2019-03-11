package cn.umisoft.admin.util.io;

import java.io.File;

/**
 * @Description:
 * @Author: hujie@umisoft.cn
 * @Date: 2019/3/10 9:20 PM
 */
public class UmiFile {
    public static String addSeparator(String path) {
        if (path.endsWith(File.separator)) {
            return path;
        }
        return path + File.separator;
    }
}
