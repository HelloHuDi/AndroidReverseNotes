package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.bts;
import java.util.LinkedList;

public final class a {
    public String Title;
    public int dtW;
    public int jCt;
    public String nQA;
    public String nQB;
    public String oQU = "NotCheckIn";
    public float oQV;
    public int oQW;
    public LinkedList<Integer> oQX = new LinkedList();
    public int oQY;
    public LinkedList<bts> oQZ = new LinkedList();
    public float oRa;
    public String oRb;
    public SKBuiltinBuffer_t oRc;
    public axw oRd;

    public a(String str, axw axw) {
        AppMethodBeat.i(22923);
        this.nQA = str;
        this.oQU = axw.oQU;
        this.Title = axw.Title;
        this.oQV = axw.oQV;
        this.oQW = axw.oQW;
        this.oQX = axw.oQX;
        this.oQY = axw.oQY;
        this.oQZ = axw.oQZ;
        this.oRa = axw.oRa;
        this.oRb = axw.oRb;
        this.jCt = axw.jCt;
        this.oRc = axw.oRc;
        this.dtW = axw.wCe;
        this.oRd = axw;
        AppMethodBeat.o(22923);
    }
}
