package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public static void checkArgument(boolean z) {
        AppMethodBeat.i(95858);
        if (z) {
            AppMethodBeat.o(95858);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        AppMethodBeat.o(95858);
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean z, Object obj) {
        AppMethodBeat.i(95859);
        if (z) {
            AppMethodBeat.o(95859);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.valueOf(obj));
        AppMethodBeat.o(95859);
        throw illegalArgumentException;
    }

    public static int bh(int i, int i2) {
        AppMethodBeat.i(95860);
        if (i < 0 || i >= i2) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            AppMethodBeat.o(95860);
            throw indexOutOfBoundsException;
        }
        AppMethodBeat.o(95860);
        return i;
    }

    public static void checkState(boolean z) {
        AppMethodBeat.i(95861);
        if (z) {
            AppMethodBeat.o(95861);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        AppMethodBeat.o(95861);
        throw illegalStateException;
    }

    public static void checkState(boolean z, Object obj) {
        AppMethodBeat.i(95862);
        if (z) {
            AppMethodBeat.o(95862);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(String.valueOf(obj));
        AppMethodBeat.o(95862);
        throw illegalStateException;
    }

    public static <T> T checkNotNull(T t) {
        AppMethodBeat.i(95863);
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(95863);
            throw nullPointerException;
        }
        AppMethodBeat.o(95863);
        return t;
    }
}
