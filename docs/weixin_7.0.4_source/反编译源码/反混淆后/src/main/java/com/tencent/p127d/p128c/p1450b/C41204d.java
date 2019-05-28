package com.tencent.p127d.p128c.p1450b;

import com.p123qq.taf.jce.JceInputStream;
import com.p123qq.taf.jce.JceOutputStream;
import com.p123qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.d.c.b.d */
public final class C41204d extends JceStruct {
    public String AsX = "";
    public String AsY = "";
    public int AsZ = 0;
    public String Ata = "";
    public int Atb = 0;
    public String fwM = "";
    public String model = "";
    public String platform = "";

    public final JceStruct newInit() {
        AppMethodBeat.m2504i(114498);
        C41204d c41204d = new C41204d();
        AppMethodBeat.m2505o(114498);
        return c41204d;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.m2504i(114499);
        if (this.AsX != null) {
            jceOutputStream.write(this.AsX, 0);
        }
        if (this.AsY != null) {
            jceOutputStream.write(this.AsY, 1);
        }
        if (this.fwM != null) {
            jceOutputStream.write(this.fwM, 2);
        }
        if (this.model != null) {
            jceOutputStream.write(this.model, 3);
        }
        if (this.AsZ != 0) {
            jceOutputStream.write(this.AsZ, 4);
        }
        if (this.Ata != null) {
            jceOutputStream.write(this.Ata, 5);
        }
        if (this.platform != null) {
            jceOutputStream.write(this.platform, 6);
        }
        if (this.Atb != 0) {
            jceOutputStream.write(this.Atb, 7);
        }
        AppMethodBeat.m2505o(114499);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.m2504i(114500);
        this.AsX = jceInputStream.readString(0, false);
        this.AsY = jceInputStream.readString(1, false);
        this.fwM = jceInputStream.readString(2, false);
        this.model = jceInputStream.readString(3, false);
        this.AsZ = jceInputStream.read(this.AsZ, 4, false);
        this.Ata = jceInputStream.readString(5, false);
        this.platform = jceInputStream.readString(6, false);
        this.Atb = jceInputStream.read(this.Atb, 7, false);
        AppMethodBeat.m2505o(114500);
    }
}
