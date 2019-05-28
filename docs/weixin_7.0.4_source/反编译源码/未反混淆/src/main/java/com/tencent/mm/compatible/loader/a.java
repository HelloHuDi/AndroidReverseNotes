package com.tencent.mm.compatible.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static Object[] euk = new Object[0];
    private static Object[] eul = new Object[73];

    public static int idealIntArraySize(int i) {
        int i2 = i * 4;
        for (int i3 = 4; i3 < 32; i3++) {
            if (i2 <= (1 << i3) - 12) {
                i2 = (1 << i3) - 12;
                break;
            }
        }
        return i2 / 4;
    }

    public static <T> boolean contains(T[] tArr, T t) {
        AppMethodBeat.i(51923);
        for (Object obj : tArr) {
            if (obj == null) {
                if (t == null) {
                    AppMethodBeat.o(51923);
                    return true;
                }
            } else if (t != null && obj.equals(t)) {
                AppMethodBeat.o(51923);
                return true;
            }
        }
        AppMethodBeat.o(51923);
        return false;
    }

    public static boolean contains(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
