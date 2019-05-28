package com.tencent.map.lib.element;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class c {
    public final String a;
    public final String b;
    public final int c;
    public final String[] d;

    public c(String str, String str2, String[] strArr, int i) {
        AppMethodBeat.i(97861);
        this.a = str;
        this.b = str2;
        this.d = a(strArr);
        this.c = i;
        AppMethodBeat.o(97861);
    }

    private String[] a(String[] strArr) {
        AppMethodBeat.i(97862);
        if (strArr == null) {
            AppMethodBeat.o(97862);
            return null;
        }
        String[] strArr2 = new String[strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr2.length);
        AppMethodBeat.o(97862);
        return strArr2;
    }
}
