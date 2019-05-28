package com.tencent.d.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c extends JceStruct {
    static b Asi = new b();
    public String ArS = "";
    public String ArT = "";
    public String ArU = "";
    public int ArV = 0;
    public int ArW = 0;
    public b ArX = null;
    public int ArY = 0;
    public int ArZ = 0;
    public int Asa = 0;
    public int Asb = 0;
    public short Asc = (short) 0;
    public String Asd = "";
    public int Ase = 0;
    public String Asf = "";
    public String Asg = "";
    public String Ash = "";
    public String eCq = "";
    public String fgd = "";
    public String guid = "";
    public String gxL = "";
    public String imei = "";
    public String imsi = "";
    public String ip = "";
    public String kck = "";
    public double latitude = 0.0d;
    public double longitude = 0.0d;
    public String qTL = "";

    public final JceStruct newInit() {
        AppMethodBeat.i(114483);
        c cVar = new c();
        AppMethodBeat.o(114483);
        return cVar;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(114484);
        jceOutputStream.write(this.imei, 0);
        if (this.gxL != null) {
            jceOutputStream.write(this.gxL, 1);
        }
        if (this.kck != null) {
            jceOutputStream.write(this.kck, 2);
        }
        if (this.ip != null) {
            jceOutputStream.write(this.ip, 3);
        }
        if (this.ArS != null) {
            jceOutputStream.write(this.ArS, 4);
        }
        if (this.ArT != null) {
            jceOutputStream.write(this.ArT, 5);
        }
        if (this.ArU != null) {
            jceOutputStream.write(this.ArU, 6);
        }
        if (this.ArV != 0) {
            jceOutputStream.write(this.ArV, 7);
        }
        if (this.ArW != 0) {
            jceOutputStream.write(this.ArW, 8);
        }
        if (this.ArX != null) {
            jceOutputStream.write(this.ArX, 9);
        }
        if (this.guid != null) {
            jceOutputStream.write(this.guid, 10);
        }
        if (this.imsi != null) {
            jceOutputStream.write(this.imsi, 11);
        }
        if (this.ArY != 0) {
            jceOutputStream.write(this.ArY, 12);
        }
        if (this.ArZ != 0) {
            jceOutputStream.write(this.ArZ, 13);
        }
        if (this.Asa != 0) {
            jceOutputStream.write(this.Asa, 14);
        }
        if (this.Asb != 0) {
            jceOutputStream.write(this.Asb, 15);
        }
        if (this.eCq != null) {
            jceOutputStream.write(this.eCq, 16);
        }
        if (this.Asc != (short) 0) {
            jceOutputStream.write(this.Asc, 17);
        }
        if (this.longitude != 0.0d) {
            jceOutputStream.write(this.longitude, 18);
        }
        if (this.latitude != 0.0d) {
            jceOutputStream.write(this.latitude, 19);
        }
        if (this.Asd != null) {
            jceOutputStream.write(this.Asd, 20);
        }
        if (this.Ase != 0) {
            jceOutputStream.write(this.Ase, 21);
        }
        if (this.Asf != null) {
            jceOutputStream.write(this.Asf, 22);
        }
        if (this.fgd != null) {
            jceOutputStream.write(this.fgd, 23);
        }
        if (this.qTL != null) {
            jceOutputStream.write(this.qTL, 24);
        }
        if (this.Asg != null) {
            jceOutputStream.write(this.Asg, 25);
        }
        if (this.Ash != null) {
            jceOutputStream.write(this.Ash, 26);
        }
        AppMethodBeat.o(114484);
    }

    static {
        AppMethodBeat.i(114486);
        AppMethodBeat.o(114486);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(114485);
        this.imei = jceInputStream.readString(0, true);
        this.gxL = jceInputStream.readString(1, false);
        this.kck = jceInputStream.readString(2, false);
        this.ip = jceInputStream.readString(3, false);
        this.ArS = jceInputStream.readString(4, false);
        this.ArT = jceInputStream.readString(5, false);
        this.ArU = jceInputStream.readString(6, false);
        this.ArV = jceInputStream.read(this.ArV, 7, false);
        this.ArW = jceInputStream.read(this.ArW, 8, false);
        this.ArX = (b) jceInputStream.read(Asi, 9, false);
        this.guid = jceInputStream.readString(10, false);
        this.imsi = jceInputStream.readString(11, false);
        this.ArY = jceInputStream.read(this.ArY, 12, false);
        this.ArZ = jceInputStream.read(this.ArZ, 13, false);
        this.Asa = jceInputStream.read(this.Asa, 14, false);
        this.Asb = jceInputStream.read(this.Asb, 15, false);
        this.eCq = jceInputStream.readString(16, false);
        this.Asc = jceInputStream.read(this.Asc, 17, false);
        this.longitude = jceInputStream.read(this.longitude, 18, false);
        this.latitude = jceInputStream.read(this.latitude, 19, false);
        this.Asd = jceInputStream.readString(20, false);
        this.Ase = jceInputStream.read(this.Ase, 21, false);
        this.Asf = jceInputStream.readString(22, false);
        this.fgd = jceInputStream.readString(23, false);
        this.qTL = jceInputStream.readString(24, false);
        this.Asg = jceInputStream.readString(25, false);
        this.Ash = jceInputStream.readString(26, false);
        AppMethodBeat.o(114485);
    }
}
