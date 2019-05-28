package com.google.p114b.p117d;

import com.google.p114b.C37292a;
import com.google.p114b.C41638c;
import com.google.p114b.p801b.C45061b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

/* renamed from: com.google.b.d.f */
public final class C46872f extends C45065o {
    /* renamed from: a */
    public final C45061b mo3688a(String str, C37292a c37292a, int i, int i2, Map<C41638c, ?> map) {
        AppMethodBeat.m2504i(57225);
        if (c37292a != C37292a.CODE_39) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode CODE_39, but got ".concat(String.valueOf(c37292a)));
            AppMethodBeat.m2505o(57225);
            throw illegalArgumentException;
        }
        C45061b a = super.mo3688a(str, c37292a, i, i2, map);
        AppMethodBeat.m2505o(57225);
        return a;
    }

    /* renamed from: bj */
    public final boolean[] mo3687bj(String str) {
        AppMethodBeat.m2504i(57226);
        int length = str.length();
        IllegalArgumentException illegalArgumentException;
        if (length > 80) {
            illegalArgumentException = new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
            AppMethodBeat.m2505o(57226);
            throw illegalArgumentException;
        }
        int indexOf;
        int[] iArr = new int[9];
        int i = length + 25;
        for (int i2 = 0; i2 < length; i2++) {
            indexOf = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i2));
            if (indexOf < 0) {
                illegalArgumentException = new IllegalArgumentException("Bad contents: ".concat(String.valueOf(str)));
                AppMethodBeat.m2505o(57226);
                throw illegalArgumentException;
            }
            C46872f.m89114b(C17701e.bAi[indexOf], iArr);
            for (indexOf = 0; indexOf < 9; indexOf++) {
                i += iArr[indexOf];
            }
        }
        boolean[] zArr = new boolean[i];
        C46872f.m89114b(C17701e.bAu, iArr);
        indexOf = C45065o.m82688a(zArr, 0, iArr, true);
        int[] iArr2 = new int[]{1};
        indexOf += C45065o.m82688a(zArr, indexOf, iArr2, false);
        for (i = 0; i < length; i++) {
            C46872f.m89114b(C17701e.bAi["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i))], iArr);
            indexOf += C45065o.m82688a(zArr, indexOf, iArr, true);
            indexOf += C45065o.m82688a(zArr, indexOf, iArr2, false);
        }
        C46872f.m89114b(C17701e.bAu, iArr);
        C45065o.m82688a(zArr, indexOf, iArr, true);
        AppMethodBeat.m2505o(57226);
        return zArr;
    }

    /* renamed from: b */
    private static void m89114b(int i, int[] iArr) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < 9) {
                iArr[i3] = ((1 << (8 - i3)) & i) == 0 ? 1 : 2;
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }
}
