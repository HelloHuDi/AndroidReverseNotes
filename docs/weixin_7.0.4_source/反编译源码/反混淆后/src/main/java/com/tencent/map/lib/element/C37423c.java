package com.tencent.map.lib.element;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.map.lib.element.c */
public class C37423c {
    /* renamed from: a */
    public final String f16072a;
    /* renamed from: b */
    public final String f16073b;
    /* renamed from: c */
    public final int f16074c;
    /* renamed from: d */
    public final String[] f16075d;

    public C37423c(String str, String str2, String[] strArr, int i) {
        AppMethodBeat.m2504i(97861);
        this.f16072a = str;
        this.f16073b = str2;
        this.f16075d = m63053a(strArr);
        this.f16074c = i;
        AppMethodBeat.m2505o(97861);
    }

    /* renamed from: a */
    private String[] m63053a(String[] strArr) {
        AppMethodBeat.m2504i(97862);
        if (strArr == null) {
            AppMethodBeat.m2505o(97862);
            return null;
        }
        String[] strArr2 = new String[strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr2.length);
        AppMethodBeat.m2505o(97862);
        return strArr2;
    }
}
