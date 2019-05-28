package com.google.b.d;

import com.google.b.a;
import com.google.b.b.b;
import com.google.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class f extends o {
    public final b a(String str, a aVar, int i, int i2, Map<c, ?> map) {
        AppMethodBeat.i(57225);
        if (aVar != a.CODE_39) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode CODE_39, but got ".concat(String.valueOf(aVar)));
            AppMethodBeat.o(57225);
            throw illegalArgumentException;
        }
        b a = super.a(str, aVar, i, i2, map);
        AppMethodBeat.o(57225);
        return a;
    }

    public final boolean[] bj(String str) {
        AppMethodBeat.i(57226);
        int length = str.length();
        IllegalArgumentException illegalArgumentException;
        if (length > 80) {
            illegalArgumentException = new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
            AppMethodBeat.o(57226);
            throw illegalArgumentException;
        }
        int indexOf;
        int[] iArr = new int[9];
        int i = length + 25;
        for (int i2 = 0; i2 < length; i2++) {
            indexOf = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i2));
            if (indexOf < 0) {
                illegalArgumentException = new IllegalArgumentException("Bad contents: ".concat(String.valueOf(str)));
                AppMethodBeat.o(57226);
                throw illegalArgumentException;
            }
            b(e.bAi[indexOf], iArr);
            for (indexOf = 0; indexOf < 9; indexOf++) {
                i += iArr[indexOf];
            }
        }
        boolean[] zArr = new boolean[i];
        b(e.bAu, iArr);
        indexOf = o.a(zArr, 0, iArr, true);
        int[] iArr2 = new int[]{1};
        indexOf += o.a(zArr, indexOf, iArr2, false);
        for (i = 0; i < length; i++) {
            b(e.bAi["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i))], iArr);
            indexOf += o.a(zArr, indexOf, iArr, true);
            indexOf += o.a(zArr, indexOf, iArr2, false);
        }
        b(e.bAu, iArr);
        o.a(zArr, indexOf, iArr, true);
        AppMethodBeat.o(57226);
        return zArr;
    }

    private static void b(int i, int[] iArr) {
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
