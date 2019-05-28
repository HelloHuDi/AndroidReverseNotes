package com.tencent.d.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class a extends JceStruct {
    static ArrayList<e> Auf;
    public String ArS = "";
    public long Aua = 0;
    public ArrayList<e> Aub = null;
    public String Auc = "";
    public String Aud = "";
    public int Aue = 0;
    public int cIb = 0;
    public String ceI = "";
    public String few = "";
    public String fwM = "";
    public String imei = "";
    public String imsi = "";
    public String model = "";
    public int platform = 0;
    public int requestType = 0;
    public int sdkVer = 0;
    public int uaV = 0;

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(114574);
        jceOutputStream.write(this.Aua, 0);
        jceOutputStream.write(this.few, 1);
        jceOutputStream.write(this.Aub, 2);
        jceOutputStream.write(this.uaV, 3);
        jceOutputStream.write(this.ArS, 4);
        jceOutputStream.write(this.cIb, 5);
        jceOutputStream.write(this.requestType, 6);
        jceOutputStream.write(this.Auc, 7);
        if (this.imei != null) {
            jceOutputStream.write(this.imei, 8);
        }
        if (this.imsi != null) {
            jceOutputStream.write(this.imsi, 9);
        }
        if (this.fwM != null) {
            jceOutputStream.write(this.fwM, 10);
        }
        if (this.model != null) {
            jceOutputStream.write(this.model, 11);
        }
        if (this.Aud != null) {
            jceOutputStream.write(this.Aud, 12);
        }
        if (this.Aue != 0) {
            jceOutputStream.write(this.Aue, 13);
        }
        if (this.sdkVer != 0) {
            jceOutputStream.write(this.sdkVer, 14);
        }
        if (this.ceI != null) {
            jceOutputStream.write(this.ceI, 15);
        }
        jceOutputStream.write(this.platform, 16);
        AppMethodBeat.o(114574);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(114575);
        this.Aua = jceInputStream.read(this.Aua, 0, true);
        this.few = jceInputStream.readString(1, true);
        if (Auf == null) {
            Auf = new ArrayList();
            Auf.add(new e());
        }
        this.Aub = (ArrayList) jceInputStream.read(Auf, 2, true);
        this.uaV = jceInputStream.read(this.uaV, 3, true);
        this.ArS = jceInputStream.readString(4, true);
        this.cIb = jceInputStream.read(this.cIb, 5, true);
        this.requestType = jceInputStream.read(this.requestType, 6, true);
        this.Auc = jceInputStream.readString(7, true);
        this.imei = jceInputStream.readString(8, false);
        this.imsi = jceInputStream.readString(9, false);
        this.fwM = jceInputStream.readString(10, false);
        this.model = jceInputStream.readString(11, false);
        this.Aud = jceInputStream.readString(12, false);
        this.Aue = jceInputStream.read(this.Aue, 13, false);
        this.sdkVer = jceInputStream.read(this.sdkVer, 14, false);
        this.ceI = jceInputStream.readString(15, false);
        this.platform = jceInputStream.read(this.platform, 16, false);
        AppMethodBeat.o(114575);
    }
}
