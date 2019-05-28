package com.tencent.p177mm.pluginsdk.location;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.pluginsdk.location.b */
public final class C14866b {
    public int cED;
    public float fBr;
    public float fBs;
    public long itemId;
    public int scene;

    public C14866b(long j, float f, float f2, int i, int i2) {
        this.fBr = f;
        this.fBs = f2;
        this.cED = i;
        this.scene = i2;
        this.itemId = j;
    }

    public final String toString() {
        AppMethodBeat.m2504i(79210);
        String format = String.format("%d-%d-%d", new Object[]{Integer.valueOf((int) (this.fBr * 1000000.0f)), Integer.valueOf((int) (this.fBs * 1000000.0f)), Integer.valueOf(this.cED)});
        AppMethodBeat.m2505o(79210);
        return format;
    }
}
