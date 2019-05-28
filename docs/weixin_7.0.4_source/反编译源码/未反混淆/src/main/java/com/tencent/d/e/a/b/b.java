package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b extends JceStruct {
    public int Aug = 0;
    public float Auh = 0.0f;
    public String ceI = "";
    public String few = "";

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(114576);
        jceOutputStream.write(this.few, 0);
        jceOutputStream.write(this.Aug, 1);
        jceOutputStream.write(this.Auh, 2);
        if (this.ceI != null) {
            jceOutputStream.write(this.ceI, 3);
        }
        AppMethodBeat.o(114576);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(114577);
        this.few = jceInputStream.readString(0, true);
        this.Aug = jceInputStream.read(this.Aug, 1, true);
        this.Auh = jceInputStream.read(this.Auh, 2, true);
        this.ceI = jceInputStream.readString(3, false);
        AppMethodBeat.o(114577);
    }
}
