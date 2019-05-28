package com.tencent.mm.sdk.platformtools;

import android.util.Base64;
import com.tencent.mm.a.l;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

public final class ac {
    private static final Pattern xyR;
    private byte[] key;
    private final ae<String, String> xyS = new ae(256);
    public final bl xyT;

    static {
        String str = "⍆[0-9]+@";
        xyR = Pattern.compile(((char) (str.charAt(0) ^ 56506)) + str.substring(1));
    }

    public ac(String str) {
        try {
            this.key = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            this.key = str.getBytes();
        }
        this.xyT = new bl(str);
    }

    public final String ef(String str, int i) {
        String substring = str.substring(0, i);
        if (this.xyS.ak(substring)) {
            return (String) this.xyS.get(substring);
        }
        int indexOf = str.indexOf(64, 1);
        int i2 = indexOf + 1;
        try {
            String str2 = new String(l.c(Base64.decode(str.substring(i2, Integer.parseInt(str.substring(1, indexOf)) + i2), 0), this.key), "UTF-8");
            this.xyS.put(substring, str2);
            return str2;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.LogDecryptor", e, "", new Object[0]);
            return "[TD]".concat(String.valueOf(substring));
        }
    }
}
