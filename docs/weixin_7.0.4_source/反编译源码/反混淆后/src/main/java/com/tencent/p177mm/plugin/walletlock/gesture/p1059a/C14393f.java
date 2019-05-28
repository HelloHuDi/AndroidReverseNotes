package com.tencent.p177mm.plugin.walletlock.gesture.p1059a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

/* renamed from: com.tencent.mm.plugin.walletlock.gesture.a.f */
public final class C14393f {
    private static C14393f[][] tVC = ((C14393f[][]) Array.newInstance(C14393f.class, new int[]{3, 3}));
    public int tVA = 0;
    public int tVB = 0;

    static {
        AppMethodBeat.m2504i(51583);
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                tVC[i][i2] = new C14393f(i, i2);
            }
        }
        AppMethodBeat.m2505o(51583);
    }

    private C14393f(int i, int i2) {
        this.tVA = i;
        this.tVB = i2;
    }

    public final String toString() {
        AppMethodBeat.m2504i(51582);
        String format = String.format("{row: %d, col: %d}", new Object[]{Integer.valueOf(this.tVA), Integer.valueOf(this.tVB)});
        AppMethodBeat.m2505o(51582);
        return format;
    }

    /* renamed from: gk */
    public static synchronized C14393f m22618gk(int i, int i2) {
        C14393f c14393f;
        synchronized (C14393f.class) {
            AppMethodBeat.m2504i(51581);
            IllegalArgumentException illegalArgumentException;
            if (i < 0 || i > 2) {
                illegalArgumentException = new IllegalArgumentException("row id should be in range [0..2]");
                AppMethodBeat.m2505o(51581);
                throw illegalArgumentException;
            } else if (i2 < 0 || i2 > 2) {
                illegalArgumentException = new IllegalArgumentException("col id should be in range [0..2]");
                AppMethodBeat.m2505o(51581);
                throw illegalArgumentException;
            } else {
                c14393f = tVC[i][i2];
                AppMethodBeat.m2505o(51581);
            }
        }
        return c14393f;
    }
}
