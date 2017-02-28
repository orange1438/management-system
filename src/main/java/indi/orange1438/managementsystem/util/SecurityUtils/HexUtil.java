package indi.orange1438.managementsystem.util.SecurityUtils;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;

/**
 * 十六进制
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/02/28 23:28
 */
public class HexUtil {

    /**
     * Hex解密
     */
    public static String decode(String plainText) {
        try {
            return new String((byte[]) (new Hex().decode(plainText)));
        } catch (DecoderException e) {
            e.printStackTrace();
        }
        return "error";

    }

    /**
     * Hex加密
     */
    public static String encode(String plainText) {
        try {
            return Hex.encodeHexString(plainText.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "error";
    }
}
