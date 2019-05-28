package com.tencent.p127d.p132e.p133a.p1165b;

import com.p123qq.taf.jce.JceInputStream;
import com.p123qq.taf.jce.JceOutputStream;
import com.p123qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.d.e.a.b.b */
public final class C41662b extends JceStruct {
    public int Aug = 0;
    public float Auh = 0.0f;
    public String ceI = "";
    public String few = "";

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.m2504i(114576);
        jceOutputStream.write(this.few, 0);
        jceOutputStream.write(this.Aug, 1);
        jceOutputStream.write(this.Auh, 2);
        if (this.ceI != null) {
            jceOutputStream.write(this.ceI, 3);
        }
        AppMethodBeat.m2505o(114576);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.m2504i(114577);
        this.few = jceInputStream.readString(0, true);
        this.Aug = jceInputStream.read(this.Aug, 1, true);
        this.Auh = jceInputStream.read(this.Auh, 2, true);
        this.ceI = jceInputStream.readString(3, false);
        AppMethodBeat.m2505o(114577);
    }
}
