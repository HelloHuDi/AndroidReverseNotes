package com.google.p114b.p117d;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.b.d.a */
public final class C37298a extends C8732n {
    static final char[] bAh = "0123456789-$:/.+ABCD".toCharArray();
    static final int[] bAi = new int[]{3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    private static final char[] bAj = new char[]{'A', 'B', 'C', 'D'};

    static {
        AppMethodBeat.m2504i(57325);
        AppMethodBeat.m2505o(57325);
    }

    /* renamed from: a */
    static boolean m62702a(char[] cArr, char c) {
        if (cArr == null) {
            return false;
        }
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }
}
