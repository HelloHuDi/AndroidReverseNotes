package com.tencent.p177mm.pluginsdk.p592g.p593a.p595b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

/* renamed from: com.tencent.mm.pluginsdk.g.a.b.b */
public final class C4714b extends IOException {
    private final long aHW;
    private final long veU;

    public C4714b() {
        this(0, 0);
    }

    public C4714b(long j, long j2) {
        super(String.format("contentLength: %d, requestRange:%d", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
        AppMethodBeat.m2504i(79564);
        this.aHW = j;
        this.veU = j2;
        AppMethodBeat.m2505o(79564);
    }

    public final String toString() {
        AppMethodBeat.m2504i(79565);
        String str = "FileSizeOutOfRangeException{contentLength=" + this.aHW + ", requestRange=" + this.veU + '}';
        AppMethodBeat.m2505o(79565);
        return str;
    }
}
