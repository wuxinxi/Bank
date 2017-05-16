package com.wxx.bank;

import java.util.Random;

/**
 * 作者：Tangren_ on 2017/5/2 0002.
 * 邮箱：wu_tangren@163.com
 * TODO:用一句话概括
 */


public class RandomAlphaNumericGenerator {
    private static final char[] symbols;

    static {
        StringBuilder tmp = new StringBuilder();
        for (char ch = '0'; ch <= '9'; ++ch)
            tmp.append(ch);
        for (char ch = 'a'; ch <= 'z'; ++ch)
            tmp.append(ch);
        for (char ch = 'A'; ch <= 'Z'; ++ch)
            tmp.append(ch);

        // 添加一些特殊字符
        tmp.append("!@#$%");
        symbols = tmp.toString().toCharArray();
    }

    private final Random random = new Random();

    private final char[] buf;

    public RandomAlphaNumericGenerator(int length) {
        if (length < 1)
            throw new IllegalArgumentException("length < 1: " + length);
        buf = new char[length];
    }

    public String nextString() {
        for (int idx = 0; idx < buf.length; ++idx)
            buf[idx] = symbols[random.nextInt(symbols.length)];
        return new String(buf);
    }
}
