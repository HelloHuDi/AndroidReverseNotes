package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.C24273c;
import java.util.UnknownFormatConversionException;

/* renamed from: com.tencent.smtt.sdk.g */
public class C30949g {
    /* renamed from: a */
    static int f13914a = 5;
    /* renamed from: b */
    static int f13915b = 16;
    /* renamed from: c */
    static char[] f13916c = new char[16];
    /* renamed from: d */
    static String f13917d = "dex2oat-cmdline";
    /* renamed from: e */
    static long f13918e = 4096;

    /* renamed from: a */
    public static String m49541a(Context context, String str) {
        boolean z = true;
        AppMethodBeat.m2504i(63982);
        C24273c c24273c = new C24273c(str);
        c24273c.mo40362a(f13916c);
        if (f13916c[f13914a] != 1) {
            z = false;
        }
        c24273c.mo40365a(z);
        c24273c.mo40364a(f13918e);
        String a = C30949g.m49542a(new String(C30949g.m49543a(c24273c)));
        AppMethodBeat.m2505o(63982);
        return a;
    }

    /* renamed from: a */
    private static String m49542a(String str) {
        AppMethodBeat.m2504i(63983);
        String[] split = str.split(new String("\u0000"));
        int i = 0;
        while (i < split.length) {
            int i2 = i + 1;
            String str2 = split[i];
            i = i2 + 1;
            String str3 = split[i2];
            if (str2.equals(f13917d)) {
                AppMethodBeat.m2505o(63983);
                return str3;
            }
        }
        String str4 = "";
        AppMethodBeat.m2505o(63983);
        return str4;
    }

    /* renamed from: a */
    public static char[] m49543a(C24273c c24273c) {
        AppMethodBeat.m2504i(63984);
        char[] cArr = new char[4];
        char[] cArr2 = new char[4];
        c24273c.mo40362a(cArr);
        if (cArr[0] == 'o' && cArr[1] == 'a' && cArr[2] == 't') {
            c24273c.mo40362a(cArr2);
            c24273c.mo40366b();
            c24273c.mo40366b();
            c24273c.mo40366b();
            c24273c.mo40366b();
            c24273c.mo40366b();
            c24273c.mo40366b();
            c24273c.mo40366b();
            c24273c.mo40366b();
            if (cArr2[1] <= '4') {
                c24273c.mo40366b();
                c24273c.mo40366b();
                c24273c.mo40366b();
            }
            c24273c.mo40366b();
            c24273c.mo40366b();
            c24273c.mo40366b();
            c24273c.mo40366b();
            c24273c.mo40366b();
            c24273c.mo40366b();
            c24273c.mo40366b();
            cArr = new char[c24273c.mo40366b()];
            c24273c.mo40362a(cArr);
            AppMethodBeat.m2505o(63984);
            return cArr;
        }
        UnknownFormatConversionException unknownFormatConversionException = new UnknownFormatConversionException(String.format("Invalid art magic %c%c%c", new Object[]{Character.valueOf(cArr[0]), Character.valueOf(cArr[1]), Character.valueOf(cArr[2])}));
        AppMethodBeat.m2505o(63984);
        throw unknownFormatConversionException;
    }
}
