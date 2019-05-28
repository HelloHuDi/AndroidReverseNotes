package com.tencent.p127d.p132e.p133a.p1165b;

import com.p123qq.taf.jce.JceInputStream;
import com.p123qq.taf.jce.JceOutputStream;
import com.p123qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.d.e.a.b.f */
public final class C41666f extends JceStruct {
    public long Auo = 0;
    /* renamed from: x */
    public float f16883x = 0.0f;
    /* renamed from: y */
    public float f16884y = 0.0f;
    /* renamed from: z */
    public float f16885z = 0.0f;

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.m2504i(114584);
        jceOutputStream.write(this.Auo, 0);
        jceOutputStream.write(this.f16883x, 1);
        jceOutputStream.write(this.f16884y, 2);
        jceOutputStream.write(this.f16885z, 3);
        AppMethodBeat.m2505o(114584);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.m2504i(114585);
        this.Auo = jceInputStream.read(this.Auo, 0, true);
        this.f16883x = jceInputStream.read(this.f16883x, 1, true);
        this.f16884y = jceInputStream.read(this.f16884y, 2, true);
        this.f16885z = jceInputStream.read(this.f16885z, 3, true);
        AppMethodBeat.m2505o(114585);
    }
}
