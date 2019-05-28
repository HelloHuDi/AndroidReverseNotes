package com.google.p114b.p117d;

import com.google.p114b.C37292a;
import com.google.p114b.C41638c;
import com.google.p114b.p801b.C45061b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

/* renamed from: com.google.b.d.h */
public final class C32083h extends C45065o {
    /* renamed from: a */
    public final C45061b mo3688a(String str, C37292a c37292a, int i, int i2, Map<C41638c, ?> map) {
        AppMethodBeat.m2504i(57173);
        if (c37292a != C37292a.CODE_93) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode CODE_93, but got ".concat(String.valueOf(c37292a)));
            AppMethodBeat.m2505o(57173);
            throw illegalArgumentException;
        }
        C45061b a = super.mo3688a(str, c37292a, i, i2, map);
        AppMethodBeat.m2505o(57173);
        return a;
    }

    /* renamed from: bj */
    public final boolean[] mo3687bj(String str) {
        int i = 0;
        AppMethodBeat.m2504i(57174);
        int length = str.length();
        if (length > 80) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
            AppMethodBeat.m2505o(57174);
            throw illegalArgumentException;
        }
        int[] iArr = new int[9];
        boolean[] zArr = new boolean[((((str.length() + 2) + 2) * 9) + 1)];
        C32083h.m52199b(C32082g.bAi[47], iArr);
        int a = C32083h.m52198a(zArr, 0, iArr);
        while (i < length) {
            C32083h.m52199b(C32082g.bAi["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i))], iArr);
            a += C32083h.m52198a(zArr, a, iArr);
            i++;
        }
        i = C32083h.m52200l(str, 20);
        C32083h.m52199b(C32082g.bAi[i], iArr);
        a += C32083h.m52198a(zArr, a, iArr);
        C32083h.m52199b(C32082g.bAi[C32083h.m52200l(str + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(i), 15)], iArr);
        i = C32083h.m52198a(zArr, a, iArr) + a;
        C32083h.m52199b(C32082g.bAi[47], iArr);
        zArr[i + C32083h.m52198a(zArr, i, iArr)] = true;
        AppMethodBeat.m2505o(57174);
        return zArr;
    }

    /* renamed from: b */
    private static void m52199b(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3;
            if (((1 << (8 - i2)) & i) == 0) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            iArr[i2] = i3;
        }
    }

    /* renamed from: a */
    private static int m52198a(boolean[] zArr, int i, int[] iArr) {
        int i2 = 0;
        while (i2 < 9) {
            boolean z;
            int i3 = i + 1;
            if (iArr[i2] != 0) {
                z = true;
            } else {
                z = false;
            }
            zArr[i] = z;
            i2++;
            i = i3;
        }
        return 9;
    }

    /* renamed from: l */
    private static int m52200l(String str, int i) {
        int i2;
        AppMethodBeat.m2504i(57175);
        int i3 = 0;
        int length = str.length() - 1;
        int i4 = 1;
        while (length >= 0) {
            i3 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i4;
            i2 = i4 + 1;
            if (i2 > i) {
                i2 = 1;
            }
            length--;
            i4 = i2;
        }
        i2 = i3 % 47;
        AppMethodBeat.m2505o(57175);
        return i2;
    }
}
