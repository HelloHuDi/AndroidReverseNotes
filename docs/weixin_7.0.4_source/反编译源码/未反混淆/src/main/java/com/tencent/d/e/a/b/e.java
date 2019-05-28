package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class e extends JceStruct {
    static ArrayList<g> Aun;
    public int Atn = 0;
    public long Auk = 0;
    public ArrayList<g> Aul = null;
    public double Aum = 0.0d;
    public int action = 0;
    public double lat = 0.0d;

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(114582);
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
        AppMethodBeat.o(114582);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(114583);
        this.Auk = jceInputStream.read(this.Auk, 0, true);
        if (Aun == null) {
            Aun = new ArrayList();
            Aun.add(new g());
        }
        this.Aul = (ArrayList) jceInputStream.read(Aun, 1, true);
        this.Atn = jceInputStream.read(this.Atn, 2, false);
        this.action = jceInputStream.read(this.action, 3, false);
        this.lat = jceInputStream.read(this.lat, 4, false);
        this.Aum = jceInputStream.read(this.Aum, 5, false);
        AppMethodBeat.o(114583);
    }
}
