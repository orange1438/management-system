package indi.orange1438.managementsystem.util.SecurityUtils;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * base64
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/02/28 23:18
 */
public class Base64Util {

    /**
     * Base64解密
     */
    public static String decode(String plainText) {
        return new String(new Base64().decodeBase64(plainText));
    }

    /**
     * Base64加密
     */
    public static String encode(String plainText) {
        try {
            return new Base64().encodeToString(plainText.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "error";
    }
}
