package com.tencent.d.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class a extends JceStruct {
    static c Asm = new c();
    static ArrayList<b> Asn = new ArrayList();
    static d Aso = new d();
    public c Asj = null;
    public ArrayList<b> Ask = null;
    public d Asl = null;

    public final JceStruct newInit() {
        AppMethodBeat.i(114487);
        a aVar = new a();
        AppMethodBeat.o(114487);
        return aVar;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(114488);
        if (this.Asj != null) {
            jceOutputStream.write(this.Asj, 0);
        }
        if (this.Ask != null) {
            jceOutputStream.write(this.Ask, 1);
        }
        if (this.Asl != null) {
            jceOutputStream.write(this.Asl, 2);
        }
        AppMethodBeat.o(114488);
    }

    static {
        AppMethodBeat.i(114490);
        Asn.add(new b());
        AppMethodBeat.o(114490);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(114489);
        this.Asj = (c) jceInputStream.read(Asm, 0, false);
        this.Ask = (ArrayList) jceInputStream.read(Asn, 1, false);
        this.Asl = (d) jceInputStream.read(Aso, 2, false);
        AppMethodBeat.o(114489);
    }
}
