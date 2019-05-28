package com.tencent.p127d.p128c.p129a;

import com.p123qq.taf.jce.JceInputStream;
import com.p123qq.taf.jce.JceOutputStream;
import com.p123qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.d.c.a.b */
public final class C0918b extends JceStruct {
    public int ArP = 0;
    public int ArQ = 0;
    public int ArR = 0;

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.m2504i(114481);
        jceOutputStream.write(this.ArP, 1);
        jceOutputStream.write(this.ArQ, 2);
        jceOutputStream.write(this.ArR, 3);
        AppMethodBeat.m2505o(114481);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.m2504i(114482);
        this.ArP = jceInputStream.read(this.ArP, 1, true);
        this.ArQ = jceInputStream.read(this.ArQ, 2, true);
        this.ArR = jceInputStream.read(this.ArR, 3, true);
        AppMethodBeat.m2505o(114482);
    }
}
