package com.tencent.p177mm.compatible.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.CharArrayWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.security.AccessController;
import java.util.BitSet;

/* renamed from: com.tencent.mm.compatible.util.q */
public final class C18178q {
    static BitSet evK = new BitSet(256);
    static String evL;

    static {
        int i;
        AppMethodBeat.m2504i(93112);
        evL = null;
        for (i = 97; i <= 122; i++) {
            evK.set(i);
        }
        for (i = 65; i <= 90; i++) {
            evK.set(i);
        }
        for (i = 48; i <= 57; i++) {
            evK.set(i);
        }
        evK.set(45);
        evK.set(95);
        evK.set(46);
        evK.set(42);
        evL = (String) AccessController.doPrivileged(new C26053i("file.encoding"));
        AppMethodBeat.m2505o(93112);
    }

    @Deprecated
    public static String encode(String str) {
        AppMethodBeat.m2504i(93110);
        String str2 = null;
        try {
            str2 = C18178q.encode(str, evL);
        } catch (UnsupportedEncodingException e) {
        }
        AppMethodBeat.m2505o(93110);
        return str2;
    }

    public static String encode(String str, String str2) {
        UnsupportedEncodingException unsupportedEncodingException;
        AppMethodBeat.m2504i(93111);
        StringBuffer stringBuffer = new StringBuffer(str.length());
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        if (str2 == null) {
            NullPointerException nullPointerException = new NullPointerException("charsetName");
            AppMethodBeat.m2505o(93111);
            throw nullPointerException;
        }
        try {
            Charset forName = Charset.forName(str2);
            Object obj = null;
            int i = 0;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if (evK.get(charAt)) {
                    if (charAt == ' ') {
                        obj = 1;
                    }
                    stringBuffer.append((char) charAt);
                    i++;
                } else {
                    int i2 = charAt;
                    BitSet bitSet;
                    do {
                        charArrayWriter.write(i2);
                        if (i2 >= 55296 && i2 <= 56319 && i + 1 < str.length()) {
                            char charAt2 = str.charAt(i + 1);
                            if (charAt2 >= 56320 && charAt2 <= 57343) {
                                charArrayWriter.write(charAt2);
                                i++;
                            }
                        }
                        i++;
                        if (i >= str.length()) {
                            break;
                        }
                        bitSet = evK;
                        i2 = str.charAt(i);
                    } while (!bitSet.get(i2));
                    charArrayWriter.flush();
                    String str3 = new String(charArrayWriter.toCharArray());
                    C18177p c18177p = new C18177p();
                    byte[] bytes = str3.getBytes(forName);
                    if (bytes == null) {
                        bytes = str3.getBytes();
                    }
                    for (int i3 = 0; i3 < bytes.length; i3++) {
                        stringBuffer.append('%');
                        charAt = Character.forDigit((bytes[i3] >> 4) & 15, 16);
                        if (Character.isLetter(charAt)) {
                            charAt = (char) (charAt - 32);
                        }
                        stringBuffer.append(charAt);
                        charAt = Character.forDigit(bytes[i3] & 15, 16);
                        if (Character.isLetter(charAt)) {
                            charAt = (char) (charAt - 32);
                        }
                        stringBuffer.append(charAt);
                    }
                    charArrayWriter.reset();
                    obj = 1;
                }
            }
            if (obj != null) {
                str = stringBuffer.toString();
                AppMethodBeat.m2505o(93111);
                return str;
            }
            AppMethodBeat.m2505o(93111);
            return str;
        } catch (IllegalCharsetNameException e) {
            unsupportedEncodingException = new UnsupportedEncodingException(str2);
            AppMethodBeat.m2505o(93111);
            throw unsupportedEncodingException;
        } catch (UnsupportedCharsetException e2) {
            unsupportedEncodingException = new UnsupportedEncodingException(str2);
            AppMethodBeat.m2505o(93111);
            throw unsupportedEncodingException;
        }
    }
}
