package com.google.android.exoplayer2.p111i;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.i.a */
public final class C45039a {
    public static void checkArgument(boolean z) {
        AppMethodBeat.m2504i(95858);
        if (z) {
            AppMethodBeat.m2505o(95858);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        AppMethodBeat.m2505o(95858);
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean z, Object obj) {
        AppMethodBeat.m2504i(95859);
        if (z) {
            AppMethodBeat.m2505o(95859);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.valueOf(obj));
        AppMethodBeat.m2505o(95859);
        throw illegalArgumentException;
    }

    /* renamed from: bh */
    public static int m82573bh(int i, int i2) {
        AppMethodBeat.m2504i(95860);
        if (i < 0 || i >= i2) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            AppMethodBeat.m2505o(95860);
            throw indexOutOfBoundsException;
        }
        AppMethodBeat.m2505o(95860);
        return i;
    }

    public static void checkState(boolean z) {
        AppMethodBeat.m2504i(95861);
        if (z) {
            AppMethodBeat.m2505o(95861);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        AppMethodBeat.m2505o(95861);
        throw illegalStateException;
    }

    public static void checkState(boolean z, Object obj) {
        AppMethodBeat.m2504i(95862);
        if (z) {
            AppMethodBeat.m2505o(95862);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(String.valueOf(obj));
        AppMethodBeat.m2505o(95862);
        throw illegalStateException;
    }

    public static <T> T checkNotNull(T t) {
        AppMethodBeat.m2504i(95863);
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.m2505o(95863);
            throw nullPointerException;
        }
        AppMethodBeat.m2505o(95863);
        return t;
    }
}
