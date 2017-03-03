package indi.orange1438.managementsystem.util.SecurityUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.net.URLEncoder;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

/**
 * 编码器
 * base64、url、md5、sha-1、des
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/03/03 23:24
 */
public class EncodeUtils {

    /**
     * 标准Base64编码
     */
    public static String base64Encode(String plainText) {
        try {
            return Base64.getEncoder().encodeToString(plainText.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
            return plainText;
        }
    }

    /**
     * 标准Base64编码
     */
    public static String base64Encode(byte[] plainText) {
        try {
            return Base64.getEncoder().encodeToString(plainText);
        } catch (Exception e) {
            e.printStackTrace();
            return new String(plainText);
        }
    }

    /**
     * URL编码
     */
    public static String urlEncode(String plainText) {
        try {
            return URLEncoder.encode(plainText, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return plainText;
        }
    }

    /**
     * MD5加密
     */
    public static String md5Encode(String plainText) {
        return encode(plainText, "MD5");
    }

    /**
     * sha-1加密
     */
    public static String sha1Encode(String plainText) {
        return encode(plainText, "SHA-1");
    }

    /**
     * DES算法，加密
     *
     * @param data 待加密字符串
     * @param key  加密私钥，长度不能够小于8位
     * @return 加密后的字节数组，一般结合Base64编码使用
     * @throws Exception
     */
    public static String desEncode(String key, String data) {
        if (data == null) {
            return null;
        }
        try {
            DESKeySpec dks = new DESKeySpec(key.getBytes("ASCII"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            //key的长度不能够小于8位字节
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec("orange".getBytes("ASCII"));
            AlgorithmParameterSpec paramSpec = iv;
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec);
            byte[] bytes = cipher.doFinal(data.getBytes("UTF-8"));
            return base64Encode(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            return data;
        }
    }

    /**
     * 单向信息加密(信息摘要)
     * 支持MD5、MD2、SHA(SHA-1，SHA1)、SHA-256、SHA-384、SHA-512
     *
     * @param plainText
     * @param code
     * @return
     */
    private static String encode(String plainText, String code) {
        try {
            MessageDigest md = MessageDigest.getInstance(code);
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            StringBuffer buf = new StringBuffer("");
            int i;
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return plainText;
        }
    }
}
