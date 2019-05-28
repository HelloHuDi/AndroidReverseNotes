package com.google.p114b.p117d;

import com.google.p114b.C37292a;
import com.google.p114b.C41638c;
import com.google.p114b.p801b.C45061b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

/* renamed from: com.google.b.d.m */
public final class C25574m extends C45065o {
    private static final int[] bAA = new int[]{3, 1, 1};
    private static final int[] bAx = new int[]{1, 1, 1, 1};

    /* renamed from: a */
    public final C45061b mo3688a(String str, C37292a c37292a, int i, int i2, Map<C41638c, ?> map) {
        AppMethodBeat.m2504i(57317);
        if (c37292a != C37292a.ITF) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode ITF, but got ".concat(String.valueOf(c37292a)));
            AppMethodBeat.m2505o(57317);
            throw illegalArgumentException;
        }
        C45061b a = super.mo3688a(str, c37292a, i, i2, map);
        AppMethodBeat.m2505o(57317);
        return a;
    }

    /* renamed from: bj */
    public final boolean[] mo3687bj(String str) {
        AppMethodBeat.m2504i(57318);
        int length = str.length();
        IllegalArgumentException illegalArgumentException;
        if (length % 2 != 0) {
            illegalArgumentException = new IllegalArgumentException("The length of the input should be even");
            AppMethodBeat.m2505o(57318);
            throw illegalArgumentException;
        } else if (length > 80) {
            illegalArgumentException = new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
            AppMethodBeat.m2505o(57318);
            throw illegalArgumentException;
        } else {
            boolean[] zArr = new boolean[((length * 9) + 9)];
            int a = C45065o.m82688a(zArr, 0, bAx, true);
            for (int i = 0; i < length; i += 2) {
                int digit = Character.digit(str.charAt(i), 10);
                int digit2 = Character.digit(str.charAt(i + 1), 10);
                int[] iArr = new int[18];
                for (int i2 = 0; i2 < 5; i2++) {
                    iArr[i2 * 2] = C16515l.bAz[digit][i2];
                    iArr[(i2 * 2) + 1] = C16515l.bAz[digit2][i2];
                }
                a += C45065o.m82688a(zArr, a, iArr, true);
            }
            C45065o.m82688a(zArr, a, bAA, true);
            AppMethodBeat.m2505o(57318);
            return zArr;
        }
    }
}
