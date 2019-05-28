package com.tencent.d.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b extends JceStruct {
    public int ArP = 0;
    public int ArQ = 0;
    public int ArR = 0;

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(114481);
        jceOutputStream.write(this.ArP, 1);
        jceOutputStream.write(this.ArQ, 2);
        jceOutputStream.write(this.ArR, 3);
        AppMethodBeat.o(114481);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(114482);
        this.ArP = jceInputStream.read(this.ArP, 1, true);
        this.ArQ = jceInputStream.read(this.ArQ, 2, true);
        this.ArR = jceInputStream.read(this.ArR, 3, true);
        AppMethodBeat.o(114482);
    }
}
