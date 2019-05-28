package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f extends JceStruct {
    public long Auo = 0;
    public float x = 0.0f;
    public float y = 0.0f;
    public float z = 0.0f;

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(114584);
        jceOutputStream.write(this.Auo, 0);
        jceOutputStream.write(this.x, 1);
        jceOutputStream.write(this.y, 2);
        jceOutputStream.write(this.z, 3);
        AppMethodBeat.o(114584);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(114585);
        this.Auo = jceInputStream.read(this.Auo, 0, true);
        this.x = jceInputStream.read(this.x, 1, true);
        this.y = jceInputStream.read(this.y, 2, true);
        this.z = jceInputStream.read(this.z, 3, true);
        AppMethodBeat.o(114585);
    }
}
