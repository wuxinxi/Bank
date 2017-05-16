package com.wxx.bank;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.content.ContentValues.TAG;

/**
 * 作者：Tangren_ on 2017/4/28 0028.
 * 邮箱：wu_tangren@163.com
 * TODO:工具类
 */


public class Util {


    public static final SimpleDateFormat format_6 = new SimpleDateFormat("HHmmss");
    public static final SimpleDateFormat format_4 = new SimpleDateFormat("MMdd");
    public static final SimpleDateFormat format = new SimpleDateFormat("yyMM");


    /**
     * 转BCD
     *
     * @param s
     * @return
     */
    public static byte[] str2cbcd(String s) {
        if (s.length() % 2 != 0) {
            s = "0" + s;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i += 2) {
            int high = cs[i] - 48;
            int low = cs[i + 1] - 48;
            baos.write(high << 4 | low);
        }
        return baos.toByteArray();
    }

    /**
     * 填充空格
     *
     * @param msg
     * @param length
     * @return
     */
    public static String getSpace(String msg, int length) {
        StringBuilder sb = new StringBuilder(msg);
        int msgLength = sb.toString().length();
        int countLength = length - msgLength;
        if (countLength > 0) {
            for (int i = 0; i < countLength; i++) {
                sb.append(" ");
            }
        }
        Log.d(TAG, sb.toString());
        return sb.toString();
    }

    /**
     * 填充0
     *
     * @param msg
     * @param length
     * @return
     */
    public static String getZero(String msg, int length) {
        StringBuilder sb = new StringBuilder(msg);
        int msgLength = sb.toString().length();
        int countLength = length - msgLength;
        if (countLength > 0) {
            for (int i = 0; i < countLength; i++) {
                sb.insert(0, "0");
            }
        }
        Log.d(TAG, sb.toString());
        return sb.toString();
    }


    public static byte[] readStream(InputStream inStream) throws Exception {
        int count = 0;
        while (count == 0) {
            count = inStream.available();
        }
        byte[] b = new byte[count];
        inStream.read(b);
        return b;
    }

    public static String getTime_6() {
        return format_6.format(new Date());
    }

    public static String getTime_4() {
        return format_4.format(new Date());
    }

    public static String getTime() {
        return format.format(new Date());
    }


    /**
     * 随机数
     *
     * @param len
     * @return
     */
    public static String buidRandom(int len) {
        int num = 0;
        double random = Math.random();
        if (random < 0.1) {
            random = random + 0.1;
        }
        for (int i = 0; i < len; i++) {
            num = num * 10;
        }
        return String.valueOf((int) (random * num));
    }

    public static String buildRandomStr(int length) {
        RandomAlphaNumericGenerator random = new RandomAlphaNumericGenerator(length);
        String result = null;
        for (int i = 0; i < length - 1; i++) {
            do {
                result = random.nextString();
            } while (!result.matches(".*(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%]).*"));
        }
        Log.d(TAG, length+"位随机数：" + result);
        return result;
    }

}
