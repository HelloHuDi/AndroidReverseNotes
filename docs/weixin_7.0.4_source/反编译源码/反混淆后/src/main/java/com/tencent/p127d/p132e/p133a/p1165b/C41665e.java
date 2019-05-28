package com.tencent.p127d.p132e.p133a.p1165b;

import com.p123qq.taf.jce.JceInputStream;
import com.p123qq.taf.jce.JceOutputStream;
import com.p123qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

/* renamed from: com.tencent.d.e.a.b.e */
public final class C41665e extends JceStruct {
    static ArrayList<C17730g> Aun;
    public int Atn = 0;
    public long Auk = 0;
    public ArrayList<C17730g> Aul = null;
    public double Aum = 0.0d;
    public int action = 0;
    public double lat = 0.0d;

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.m2504i(114582);
        jceOutputStream.write(this.Auk, 0);
        jceOutputStream.write(this.Aul, 1);
        if (this.Atn != 0) {
            jceOutputStream.write(this.Atn, 2);
        }
        if (this.action != 0) {
            jceOutputStream.write(this.action, 3);
        }
        if (this.lat != 0.0d) {
            jceOutputStream.write(this.lat, 4);
        }
        if (this.Aum != 0.0d) {
            jceOutputStream.write(this.Aum, 5);
        }
        AppMethodBeat.m2505o(114582);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.m2504i(114583);
        this.Auk = jceInputStream.read(this.Auk, 0, true);
        if (Aun == null) {
            Aun = new ArrayList();
            Aun.add(new C17730g());
        }
        this.Aul = (ArrayList) jceInputStream.read(Aun, 1, true);
        this.Atn = jceInputStream.read(this.Atn, 2, false);
        this.action = jceInputStream.read(this.action, 3, false);
        this.lat = jceInputStream.read(this.lat, 4, false);
        this.Aum = jceInputStream.read(this.Aum, 5, false);
        AppMethodBeat.m2505o(114583);
    }
}
