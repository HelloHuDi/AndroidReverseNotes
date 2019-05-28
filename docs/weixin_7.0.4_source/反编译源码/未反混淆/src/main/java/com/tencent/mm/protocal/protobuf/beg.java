package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.e.g;
import com.tencent.ttpic.wav.WavFileHeader;
import e.a.a.c.a;
import java.util.LinkedList;

public final class beg extends bsr {
    public String guS;
    public String jBB;
    public String jCH;
    public String luP;
    public String luQ;
    public int vCf;
    public String vCg;
    public String vCh;
    public int vIi;
    public String vIj;
    public SKBuiltinBuffer_t vIl;
    public xu vIr;
    public int vLC;
    public String vLD;
    public String vLJ;
    public int vLw;
    public SKBuiltinBuffer_t vLz;
    public String wDY;
    public int wHV;
    public int wHW;
    public int wHX;
    public String wHY;
    public String wHZ;
    public String wIa;
    public String wIb;
    public String wIc;
    public String wId;
    public int wIe;
    public String wIf;
    public String wIg;
    public String wdB;
    public String wdz;
    public String wfH;
    public String wlq;
    public String wsL;
    public String wsM;
    public int wsN;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58920);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.jBB != null) {
                aVar.e(2, this.jBB);
            }
            if (this.vLJ != null) {
                aVar.e(3, this.vLJ);
            }
            if (this.jCH != null) {
                aVar.e(4, this.jCH);
            }
            aVar.iz(5, this.vCf);
            if (this.vCg != null) {
                aVar.e(6, this.vCg);
            }
            if (this.vCh != null) {
                aVar.e(7, this.vCh);
            }
            if (this.wdB != null) {
                aVar.e(8, this.wdB);
            }
            aVar.iz(12, this.vIi);
            aVar.iz(13, this.wHV);
            aVar.iz(14, this.wsN);
            if (this.luP != null) {
                aVar.e(15, this.luP);
            }
            if (this.luQ != null) {
                aVar.e(16, this.luQ);
            }
            aVar.iz(17, this.vLw);
            if (this.wdz != null) {
                aVar.e(18, this.wdz);
            }
            if (this.vLz != null) {
                aVar.iy(19, this.vLz.computeSize());
                this.vLz.writeFields(aVar);
            }
            if (this.guS != null) {
                aVar.e(20, this.guS);
            }
            if (this.wsL != null) {
                aVar.e(21, this.wsL);
            }
            if (this.wsM != null) {
                aVar.e(22, this.wsM);
            }
            aVar.iz(23, this.wHW);
            aVar.iz(24, this.wHX);
            if (this.vIj != null) {
                aVar.e(31, this.vIj);
            }
            if (this.wDY != null) {
                aVar.e(32, this.wDY);
            }
            if (this.wHY != null) {
                aVar.e(33, this.wHY);
            }
            if (this.wfH != null) {
                aVar.e(34, this.wfH);
            }
            if (this.wHZ != null) {
                aVar.e(35, this.wHZ);
            }
            if (this.wIa != null) {
                aVar.e(36, this.wIa);
            }
            if (this.vIr != null) {
                aVar.iy(37, this.vIr.computeSize());
                this.vIr.writeFields(aVar);
            }
            if (this.wIb != null) {
                aVar.e(38, this.wIb);
            }
            if (this.wlq != null) {
                aVar.e(39, this.wlq);
            }
            if (this.wIc != null) {
                aVar.e(40, this.wIc);
            }
            if (this.wId != null) {
                aVar.e(41, this.wId);
            }
            aVar.iz(42, this.wIe);
            if (this.vIl != null) {
                aVar.iy(43, this.vIl.computeSize());
                this.vIl.writeFields(aVar);
            }
            aVar.iz(44, this.vLC);
            if (this.vLD != null) {
                aVar.e(45, this.vLD);
            }
            if (this.wIf != null) {
                aVar.e(46, this.wIf);
            }
            if (this.wIg != null) {
                aVar.e(47, this.wIg);
            }
            AppMethodBeat.o(58920);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.jBB != null) {
                ix += e.a.a.b.b.a.f(2, this.jBB);
            }
            if (this.vLJ != null) {
                ix += e.a.a.b.b.a.f(3, this.vLJ);
            }
            if (this.jCH != null) {
                ix += e.a.a.b.b.a.f(4, this.jCH);
            }
            ix += e.a.a.b.b.a.bs(5, this.vCf);
            if (this.vCg != null) {
                ix += e.a.a.b.b.a.f(6, this.vCg);
            }
            if (this.vCh != null) {
                ix += e.a.a.b.b.a.f(7, this.vCh);
            }
            if (this.wdB != null) {
                ix += e.a.a.b.b.a.f(8, this.wdB);
            }
            ix = ((ix + e.a.a.b.b.a.bs(12, this.vIi)) + e.a.a.b.b.a.bs(13, this.wHV)) + e.a.a.b.b.a.bs(14, this.wsN);
            if (this.luP != null) {
                ix += e.a.a.b.b.a.f(15, this.luP);
            }
            if (this.luQ != null) {
                ix += e.a.a.b.b.a.f(16, this.luQ);
            }
            ix += e.a.a.b.b.a.bs(17, this.vLw);
            if (this.wdz != null) {
                ix += e.a.a.b.b.a.f(18, this.wdz);
            }
            if (this.vLz != null) {
                ix += e.a.a.a.ix(19, this.vLz.computeSize());
            }
            if (this.guS != null) {
                ix += e.a.a.b.b.a.f(20, this.guS);
            }
            if (this.wsL != null) {
                ix += e.a.a.b.b.a.f(21, this.wsL);
            }
            if (this.wsM != null) {
                ix += e.a.a.b.b.a.f(22, this.wsM);
            }
            ix = (ix + e.a.a.b.b.a.bs(23, this.wHW)) + e.a.a.b.b.a.bs(24, this.wHX);
            if (this.vIj != null) {
                ix += e.a.a.b.b.a.f(31, this.vIj);
            }
            if (this.wDY != null) {
                ix += e.a.a.b.b.a.f(32, this.wDY);
            }
            if (this.wHY != null) {
                ix += e.a.a.b.b.a.f(33, this.wHY);
            }
            if (this.wfH != null) {
                ix += e.a.a.b.b.a.f(34, this.wfH);
            }
            if (this.wHZ != null) {
                ix += e.a.a.b.b.a.f(35, this.wHZ);
            }
            if (this.wIa != null) {
                ix += e.a.a.b.b.a.f(36, this.wIa);
            }
            if (this.vIr != null) {
                ix += e.a.a.a.ix(37, this.vIr.computeSize());
            }
            if (this.wIb != null) {
                ix += e.a.a.b.b.a.f(38, this.wIb);
            }
            if (this.wlq != null) {
                ix += e.a.a.b.b.a.f(39, this.wlq);
            }
            if (this.wIc != null) {
                ix += e.a.a.b.b.a.f(40, this.wIc);
            }
            if (this.wId != null) {
                ix += e.a.a.b.b.a.f(41, this.wId);
            }
            ix += e.a.a.b.b.a.bs(42, this.wIe);
            if (this.vIl != null) {
                ix += e.a.a.a.ix(43, this.vIl.computeSize());
            }
            ix += e.a.a.b.b.a.bs(44, this.vLC);
            if (this.vLD != null) {
                ix += e.a.a.b.b.a.f(45, this.vLD);
            }
            if (this.wIf != null) {
                ix += e.a.a.b.b.a.f(46, this.wIf);
            }
            if (this.wIg != null) {
                ix += e.a.a.b.b.a.f(47, this.wIg);
            }
            AppMethodBeat.o(58920);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(58920);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            beg beg = (beg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        beg.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(58920);
                    return 0;
                case 2:
                    beg.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(58920);
                    return 0;
                case 3:
                    beg.vLJ = aVar3.BTU.readString();
                    AppMethodBeat.o(58920);
                    return 0;
                case 4:
                    beg.jCH = aVar3.BTU.readString();
                    AppMethodBeat.o(58920);
                    return 0;
                case 5:
                    beg.vCf = aVar3.BTU.vd();
                    AppMethodBeat.o(58920);
                    return 0;
                case 6:
                    beg.vCg = aVar3.BTU.readString();
                    AppMethodBeat.o(58920);
                    return 0;
                case 7:
                    beg.vCh = aVar3.BTU.readString();
                    AppMethodBeat.o(58920);
                    return 0;
                case 8:
                    beg.wdB = aVar3.BTU.readString();
                    AppMethodBeat.o(58920);
                    return 0;
                case 12:
                    beg.vIi = aVar3.BTU.vd();
                    AppMethodBeat.o(58920);
                    return 0;
                case 13:
                    beg.wHV = aVar3.BTU.vd();
                    AppMethodBeat.o(58920);
                    return 0;
                case 14:
                    beg.wsN = aVar3.BTU.vd();
                    AppMethodBeat.o(58920);
                    return 0;
                case 15:
                    beg.luP = aVar3.BTU.readString();
                    AppMethodBeat.o(58920);
                    return 0;
                case 16:
                    beg.luQ = aVar3.BTU.readString();
                    AppMethodBeat.o(58920);
                    return 0;
                case 17:
                    beg.vLw = aVar3.BTU.vd();
                    AppMethodBeat.o(58920);
                    return 0;
                case 18:
                    beg.wdz = aVar3.BTU.readString();
                    AppMethodBeat.o(58920);
                    return 0;
                case 19:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        beg.vLz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58920);
                    return 0;
                case 20:
                    beg.guS = aVar3.BTU.readString();
                    AppMethodBeat.o(58920);
                    return 0;
                case 21:
                    beg.wsL = aVar3.BTU.readString();
                    AppMethodBeat.o(58920);
                    return 0;
                case 22:
                    beg.wsM = aVar3.BTU.readString();
                    AppMethodBeat.o(58920);
                    return 0;
                case 23:
                    beg.wHW = aVar3.BTU.vd();
                    AppMethodBeat.o(58920);
                    return 0;
                case 24:
                    beg.wHX = aVar3.BTU.vd();
                    AppMethodBeat.o(58920);
                    return 0;
                case 31:
                    beg.vIj = aVar3.BTU.readString();
                    AppMethodBeat.o(58920);
                    return 0;
                case 32:
                    beg.wDY = aVar3.BTU.readString();
                    AppMethodBeat.o(58920);
                    return 0;
                case 33:
                    beg.wHY = aVar3.BTU.readString();
                    AppMethodBeat.o(58920);
                    return 0;
                case 34:
                    beg.wfH = aVar3.BTU.readString();
                    AppMethodBeat.o(58920);
                    return 0;
                case 35:
                    beg.wHZ = aVar3.BTU.readString();
                    AppMethodBeat.o(58920);
                    return 0;
                case 36:
                    beg.wIa = aVar3.BTU.readString();
                    AppMethodBeat.o(58920);
                    return 0;
                case g.CTRL_INDEX /*37*/:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        xu xuVar = new xu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xuVar.populateBuilderWithField(aVar4, xuVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        beg.vIr = xuVar;
                    }
                    AppMethodBeat.o(58920);
                    return 0;
                case 38:
                    beg.wIb = aVar3.BTU.readString();
                    AppMethodBeat.o(58920);
                    return 0;
                case 39:
                    beg.wlq = aVar3.BTU.readString();
                    AppMethodBeat.o(58920);
                    return 0;
                case 40:
                    beg.wIc = aVar3.BTU.readString();
                    AppMethodBeat.o(58920);
                    return 0;
                case 41:
                    beg.wId = aVar3.BTU.readString();
                    AppMethodBeat.o(58920);
                    return 0;
                case 42:
                    beg.wIe = aVar3.BTU.vd();
                    AppMethodBeat.o(58920);
                    return 0;
                case 43:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        beg.vIl = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58920);
                    return 0;
                case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                    beg.vLC = aVar3.BTU.vd();
                    AppMethodBeat.o(58920);
                    return 0;
                case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                    beg.vLD = aVar3.BTU.readString();
                    AppMethodBeat.o(58920);
                    return 0;
                case 46:
                    beg.wIf = aVar3.BTU.readString();
                    AppMethodBeat.o(58920);
                    return 0;
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    beg.wIg = aVar3.BTU.readString();
                    AppMethodBeat.o(58920);
                    return 0;
                default:
                    AppMethodBeat.o(58920);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58920);
            return -1;
        }
    }
}
