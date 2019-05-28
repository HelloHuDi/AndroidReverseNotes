package com.tencent.mm.plugin.walletlock.gesture.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

public final class f {
    private static f[][] tVC = ((f[][]) Array.newInstance(f.class, new int[]{3, 3}));
    public int tVA = 0;
    public int tVB = 0;

    static {
        AppMethodBeat.i(51583);
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                tVC[i][i2] = new f(i, i2);
            }
        }
        AppMethodBeat.o(51583);
    }

    private f(int i, int i2) {
        this.tVA = i;
        this.tVB = i2;
    }

    public final String toString() {
        AppMethodBeat.i(51582);
        String format = String.format("{row: %d, col: %d}", new Object[]{Integer.valueOf(this.tVA), Integer.valueOf(this.tVB)});
        AppMethodBeat.o(51582);
        return format;
    }

    public static synchronized f gk(int i, int i2) {
        f fVar;
        synchronized (f.class) {
            AppMethodBeat.i(51581);
            IllegalArgumentException illegalArgumentException;
            if (i < 0 || i > 2) {
                illegalArgumentException = new IllegalArgumentException("row id should be in range [0..2]");
                AppMethodBeat.o(51581);
                throw illegalArgumentException;
            } else if (i2 < 0 || i2 > 2) {
                illegalArgumentException = new IllegalArgumentException("col id should be in range [0..2]");
                AppMethodBeat.o(51581);
                throw illegalArgumentException;
            } else {
                fVar = tVC[i][i2];
                AppMethodBeat.o(51581);
            }
        }
        return fVar;
    }
}
