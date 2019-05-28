package com.google.android.exoplayer2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.e */
public final class C25533e extends Exception {
    public final int aMM;
    public final int type;

    /* renamed from: b */
    public static C25533e m40358b(Exception exception, int i) {
        AppMethodBeat.m2504i(94771);
        C25533e c25533e = new C25533e(1, exception, i);
        AppMethodBeat.m2505o(94771);
        return c25533e;
    }

    /* renamed from: a */
    public static C25533e m40356a(IOException iOException) {
        AppMethodBeat.m2504i(94772);
        C25533e c25533e = new C25533e(0, iOException, -1);
        AppMethodBeat.m2505o(94772);
        return c25533e;
    }

    /* renamed from: a */
    static C25533e m40357a(RuntimeException runtimeException) {
        AppMethodBeat.m2504i(94773);
        C25533e c25533e = new C25533e(2, runtimeException, -1);
        AppMethodBeat.m2505o(94773);
        return c25533e;
    }

    private C25533e(int i, Throwable th, int i2) {
        super(null, th);
        this.type = i;
        this.aMM = i2;
    }
}
