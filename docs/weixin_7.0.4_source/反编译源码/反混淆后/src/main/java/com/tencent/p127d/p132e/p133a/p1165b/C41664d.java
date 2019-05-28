package com.tencent.p127d.p132e.p133a.p1165b;

import com.p123qq.taf.jce.JceInputStream;
import com.p123qq.taf.jce.JceOutputStream;
import com.p123qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.d.e.a.b.d */
public final class C41664d extends JceStruct {
    static C41662b Auj;
    public C41662b Aui = null;
    public int errorCode = 0;

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.m2504i(114580);
        jceOutputStream.write(this.errorCode, 0);
        if (this.Aui != null) {
            jceOutputStream.write(this.Aui, 1);
        }
        AppMethodBeat.m2505o(114580);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.m2504i(114581);
        this.errorCode = jceInputStream.read(this.errorCode, 0, true);
        if (Auj == null) {
            Auj = new C41662b();
        }
        this.Aui = (C41662b) jceInputStream.read(Auj, 1, false);
        AppMethodBeat.m2505o(114581);
    }
}
