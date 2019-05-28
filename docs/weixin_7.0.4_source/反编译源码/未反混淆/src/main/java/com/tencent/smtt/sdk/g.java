package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.c;
import java.util.UnknownFormatConversionException;

public class g {
    static int a = 5;
    static int b = 16;
    static char[] c = new char[16];
    static String d = "dex2oat-cmdline";
    static long e = 4096;

    public static String a(Context context, String str) {
        boolean z = true;
        AppMethodBeat.i(63982);
        c cVar = new c(str);
        cVar.a(c);
        if (c[a] != 1) {
            z = false;
        }
        cVar.a(z);
        cVar.a(e);
        String a = a(new String(a(cVar)));
        AppMethodBeat.o(63982);
        return a;
    }

    private static String a(String str) {
        AppMethodBeat.i(63983);
        String[] split = str.split(new String("\u0000"));
        int i = 0;
        while (i < split.length) {
            int i2 = i + 1;
            String str2 = split[i];
            i = i2 + 1;
            String str3 = split[i2];
            if (str2.equals(d)) {
                AppMethodBeat.o(63983);
                return str3;
            }
        }
        String str4 = "";
        AppMethodBeat.o(63983);
        return str4;
    }

    public static char[] a(c cVar) {
        AppMethodBeat.i(63984);
        char[] cArr = new char[4];
        char[] cArr2 = new char[4];
        cVar.a(cArr);
        if (cArr[0] == 'o' && cArr[1] == 'a' && cArr[2] == 't') {
            cVar.a(cArr2);
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            if (cArr2[1] <= '4') {
                cVar.b();
                cVar.b();
                cVar.b();
            }
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cVar.b();
            cArr = new char[cVar.b()];
            cVar.a(cArr);
            AppMethodBeat.o(63984);
            return cArr;
        }
        UnknownFormatConversionException unknownFormatConversionException = new UnknownFormatConversionException(String.format("Invalid art magic %c%c%c", new Object[]{Character.valueOf(cArr[0]), Character.valueOf(cArr[1]), Character.valueOf(cArr[2])}));
        AppMethodBeat.o(63984);
        throw unknownFormatConversionException;
    }
}
