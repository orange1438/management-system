package indi.orange1438.managementsystem.util.SecurityUtils;


import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.net.URLDecoder;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

/**
 * 解码器
 * base64、url、des
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/03/03 23:28
 */
public class DecodeUtils {

    /**
     * 标准Base64解密
     */
    public static String base64DecodeString(String plainText) {
        try {
            return new String(base64Decode(plainText), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return plainText;
        }
    }

    /**
     * 标准Base64解密
     */
    public static byte[] base64Decode(String plainText) {
        try {
            return Base64.getDecoder().decode(plainText);
        } catch (Exception e) {
            e.printStackTrace();
            return plainText.getBytes();
        }
    }

    /**
     * URL解密
     */
    public static String urlDecode(String plainText) {
        try {
            return URLDecoder.decode(plainText, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return plainText;
        }
    }

    /**
     * DES算法，解密
     *
     * @param data 待解密字符串
     * @param key  解密私钥，长度不能够小于8位
     * @return 解密后的字节数组
     */
    public static String decode(String key, String data) {
        if (data == null)
            return null;
        try {
            DESKeySpec dks = new DESKeySpec(key.getBytes("ASCII"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            //key的长度不能够小于8位字节
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec("orange".getBytes("ASCII"));
            AlgorithmParameterSpec paramSpec = iv;
            cipher.init(Cipher.DECRYPT_MODE, secretKey, paramSpec);

            byte[] bytes = base64Decode(data);
            byte[] decryptedData = cipher.doFinal(bytes);
            return new String(decryptedData);
        } catch (Exception e) {
            e.printStackTrace();
            return data;
        }
    }
}
