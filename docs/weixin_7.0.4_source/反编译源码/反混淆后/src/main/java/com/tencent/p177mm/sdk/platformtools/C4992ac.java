package com.tencent.p177mm.sdk.platformtools;

import android.util.Base64;
import com.tencent.p177mm.p178a.C1182l;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.sdk.platformtools.ac */
public final class C4992ac {
    private static final Pattern xyR;
    private byte[] key;
    private final C4993ae<String, String> xyS = new C4993ae(256);
    public final C5041bl xyT;

    static {
        String str = "⍆[0-9]+@";
        xyR = Pattern.compile(((char) (str.charAt(0) ^ 56506)) + str.substring(1));
    }

    public C4992ac(String str) {
        try {
            this.key = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            this.key = str.getBytes();
        }
        this.xyT = new C5041bl(str);
    }

    /* renamed from: ef */
    public final String mo10273ef(String str, int i) {
        String substring = str.substring(0, i);
        if (this.xyS.mo10275ak(substring)) {
            return (String) this.xyS.get(substring);
        }
        int indexOf = str.indexOf(64, 1);
        int i2 = indexOf + 1;
        try {
            String str2 = new String(C1182l.m2607c(Base64.decode(str.substring(i2, Integer.parseInt(str.substring(1, indexOf)) + i2), 0), this.key), "UTF-8");
            this.xyS.put(substring, str2);
            return str2;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.LogDecryptor", e, "", new Object[0]);
            return "[TD]".concat(String.valueOf(substring));
        }
    }
}
