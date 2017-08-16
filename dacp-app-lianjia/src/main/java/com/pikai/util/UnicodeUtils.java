package com.pikai.util;

/**
 * 项目名称：dacp
 * 包名： com.pikai.util
 * 类名称：UnicodeUtils
 * 类描述： Unicode 编码转换工具
 * 创建人:   沃特
 * 创建时间：2017/05/2017/5/9 09:35
 */
public class UnicodeUtils {
    /**
     * 中文转Unicode
     *
     * @param gbString 中文字符串
     * @return Unicode字符串
     */
    public static String GBK2Unicode(String gbString) {   //gbString = "测试"
        char[] utfBytes = gbString.toCharArray();   //utfBytes = [测, 试]
        String unicodeBytes = "";
        for (int byteIndex = 0; byteIndex < utfBytes.length; byteIndex++) {
            String hexB = Integer.toHexString(utfBytes[byteIndex]);   //转换为16进制整型字符串
            if (hexB.length() <= 2) {
                hexB = "00" + hexB;
            }
            unicodeBytes = unicodeBytes + "\\u" + hexB;
        }
//        System.out.println("unicodeBytes is: " + unicodeBytes);
        return unicodeBytes;
    }

    /**
     * Unicode转中文
     *
     * @param unicodeStr Unicode字符串
     * @return 中文字符串
     */
    public static String Unicode2GBK(String unicodeStr) {
        int start = 0;
        int end = 0;
        StringBuffer buffer = new StringBuffer();
        while (start > -1) {
            end = unicodeStr.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = unicodeStr.substring(start + 2, unicodeStr.length());
            } else {
                charStr = unicodeStr.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
            buffer.append(new Character(letter).toString());
            start = end;
        }
        return buffer.toString();
    }
    public static void main(String[] args){
        System.out.println(UnicodeUtils.GBK2Unicode("测试"));
        System.out.println(UnicodeUtils.Unicode2GBK("\\u6d4b\\u8bd5"));
    }
}
