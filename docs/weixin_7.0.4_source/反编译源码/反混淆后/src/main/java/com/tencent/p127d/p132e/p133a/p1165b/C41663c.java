package com.tencent.p127d.p132e.p133a.p1165b;

import com.p123qq.taf.jce.JceInputStream;
import com.p123qq.taf.jce.JceOutputStream;
import com.p123qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.d.e.a.b.c */
public final class C41663c extends JceStruct {
    public int errCode = 0;

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.m2504i(114578);
        if (this.errCode != 0) {
            jceOutputStream.write(this.errCode, 0);
        }
        AppMethodBeat.m2505o(114578);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.m2504i(114579);
        this.errCode = jceInputStream.read(this.errCode, 0, false);
        AppMethodBeat.m2505o(114579);
    }
}
