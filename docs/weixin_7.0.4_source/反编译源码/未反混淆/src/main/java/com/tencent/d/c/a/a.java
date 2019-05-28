package com.tencent.d.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends JceStruct {
    public int ArN = 0;
    public int ArO = 0;

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(114479);
        jceOutputStream.write(this.ArN, 0);
        jceOutputStream.write(this.ArO, 1);
        AppMethodBeat.o(114479);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(114480);
        this.ArN = jceInputStream.read(this.ArN, 0, true);
        this.ArO = jceInputStream.read(this.ArO, 1, false);
        AppMethodBeat.o(114480);
    }
}
