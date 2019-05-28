package com.tencent.p127d.p128c.p129a;

import com.p123qq.taf.jce.JceInputStream;
import com.p123qq.taf.jce.JceOutputStream;
import com.p123qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.d.c.a.a */
public final class C0917a extends JceStruct {
    public int ArN = 0;
    public int ArO = 0;

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.m2504i(114479);
        jceOutputStream.write(this.ArN, 0);
        jceOutputStream.write(this.ArO, 1);
        AppMethodBeat.m2505o(114479);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.m2504i(114480);
        this.ArN = jceInputStream.read(this.ArN, 0, true);
        this.ArO = jceInputStream.read(this.ArO, 1, false);
        AppMethodBeat.m2505o(114480);
    }
}
