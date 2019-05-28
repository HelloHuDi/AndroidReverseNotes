package com.p123qq.taf.jce;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;

/* renamed from: com.qq.taf.jce.HexUtil */
public class HexUtil {
    private static final char[] digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final byte[] emptybytes = new byte[0];

    public static String byte2HexStr(byte b) {
        AppMethodBeat.m2504i(117183);
        char[] cArr = new char[2];
        cArr[1] = digits[b & 15];
        cArr[0] = digits[((byte) (b >>> 4)) & 15];
        String str = new String(cArr);
        AppMethodBeat.m2505o(117183);
        return str;
    }

    public static String bytes2HexStr(byte[] bArr) {
        AppMethodBeat.m2504i(117184);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.m2505o(117184);
            return null;
        }
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            cArr[(i * 2) + 1] = digits[b & 15];
            cArr[(i * 2) + 0] = digits[((byte) (b >>> 4)) & 15];
        }
        String str = new String(cArr);
        AppMethodBeat.m2505o(117184);
        return str;
    }

    public static byte hexStr2Byte(String str) {
        AppMethodBeat.m2504i(117185);
        if (str == null || str.length() != 1) {
            AppMethodBeat.m2505o(117185);
            return (byte) 0;
        }
        byte char2Byte = HexUtil.char2Byte(str.charAt(0));
        AppMethodBeat.m2505o(117185);
        return char2Byte;
    }

    public static byte char2Byte(char c) {
        if (c >= '0' && c <= '9') {
            return (byte) (c - 48);
        }
        if (c >= 'a' && c <= 'f') {
            return (byte) ((c - 97) + 10);
        }
        if (c < 'A' || c > 'F') {
            return (byte) 0;
        }
        return (byte) ((c - 65) + 10);
    }

    public static byte[] hexStr2Bytes(String str) {
        AppMethodBeat.m2504i(117186);
        if (str == null || str.equals("")) {
            byte[] bArr = emptybytes;
            AppMethodBeat.m2505o(117186);
            return bArr;
        }
        byte[] bArr2 = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr2.length; i++) {
            bArr2[i] = (byte) ((HexUtil.char2Byte(str.charAt(i * 2)) * 16) + HexUtil.char2Byte(str.charAt((i * 2) + 1)));
        }
        AppMethodBeat.m2505o(117186);
        return bArr2;
    }

    public static void main(String[] strArr) {
        AppMethodBeat.m2504i(117187);
        try {
            System.out.println(HexUtil.bytes2HexStr("Hello WebSocket World?".getBytes("gbk")));
            AppMethodBeat.m2505o(117187);
        } catch (UnsupportedEncodingException e) {
            AppMethodBeat.m2505o(117187);
        }
    }
}
