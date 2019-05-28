package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d extends JceStruct {
    static b Auj;
    public b Aui = null;
    public int errorCode = 0;

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(114580);
        jceOutputStream.write(this.errorCode, 0);
        if (this.Aui != null) {
            jceOutputStream.write(this.Aui, 1);
        }
        AppMethodBeat.o(114580);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(114581);
        this.errorCode = jceInputStream.read(this.errorCode, 0, true);
        if (Auj == null) {
            Auj = new b();
        }
        this.Aui = (b) jceInputStream.read(Auj, 1, false);
        AppMethodBeat.o(114581);
    }
}
