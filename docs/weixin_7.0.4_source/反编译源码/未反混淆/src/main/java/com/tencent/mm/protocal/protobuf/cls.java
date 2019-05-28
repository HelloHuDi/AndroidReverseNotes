package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e.g;
import com.tencent.view.d;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cls extends bsr {
    public String ndF;
    public String ndG;
    public String vEG;
    public String vFF;
    public int vFH;
    public String vRw;
    public int vRx;
    public int vRy;
    public int vRz;
    public int wEs;
    public int wEt;
    public SKBuiltinBuffer_t wEu;
    public int wEv;
    public int wWT;
    public int wYj;
    public int wdW;
    public int wdl;
    public String wxU;
    public String wxW;
    public String xjA;
    public String xjB;
    public String xjC;
    public String xjD;
    public String xjE;
    public int xjg;
    public int xjh;
    public int xji;
    public int xjo;
    public int xjp;
    public SKBuiltinBuffer_t xjq;
    public int xjr;
    public String xjs;
    public int xjt;
    public String xju;
    public String xjv;
    public int xjw;
    public String xjx;
    public String xjy;
    public String xjz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51008);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wEu == null) {
                bVar = new b("Not all required fields were included: ThumbData");
                AppMethodBeat.o(51008);
                throw bVar;
            } else if (this.xjq == null) {
                bVar = new b("Not all required fields were included: VideoData");
                AppMethodBeat.o(51008);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.vFF != null) {
                    aVar.e(2, this.vFF);
                }
                if (this.ndG != null) {
                    aVar.e(3, this.ndG);
                }
                if (this.ndF != null) {
                    aVar.e(4, this.ndF);
                }
                aVar.iz(5, this.wEs);
                aVar.iz(6, this.wEt);
                if (this.wEu != null) {
                    aVar.iy(7, this.wEu.computeSize());
                    this.wEu.writeFields(aVar);
                }
                aVar.iz(8, this.xjo);
                aVar.iz(9, this.xjp);
                if (this.xjq != null) {
                    aVar.iy(10, this.xjq.computeSize());
                    this.xjq.writeFields(aVar);
                }
                aVar.iz(11, this.wYj);
                aVar.iz(12, this.wdl);
                aVar.iz(13, this.wEv);
                aVar.iz(14, this.xjr);
                if (this.vEG != null) {
                    aVar.e(15, this.vEG);
                }
                if (this.xjs != null) {
                    aVar.e(16, this.xjs);
                }
                if (this.vRw != null) {
                    aVar.e(17, this.vRw);
                }
                aVar.iz(18, this.vRx);
                if (this.wxU != null) {
                    aVar.e(19, this.wxU);
                }
                aVar.iz(20, this.xjg);
                aVar.iz(21, this.xjh);
                aVar.iz(22, this.xji);
                if (this.wxW != null) {
                    aVar.e(23, this.wxW);
                }
                aVar.iz(24, this.xjt);
                aVar.iz(25, this.wdW);
                if (this.xju != null) {
                    aVar.e(26, this.xju);
                }
                if (this.xjv != null) {
                    aVar.e(27, this.xjv);
                }
                aVar.iz(28, this.xjw);
                if (this.xjx != null) {
                    aVar.e(29, this.xjx);
                }
                if (this.xjy != null) {
                    aVar.e(30, this.xjy);
                }
                if (this.xjz != null) {
                    aVar.e(31, this.xjz);
                }
                if (this.xjA != null) {
                    aVar.e(32, this.xjA);
                }
                if (this.xjB != null) {
                    aVar.e(33, this.xjB);
                }
                if (this.xjC != null) {
                    aVar.e(34, this.xjC);
                }
                if (this.xjD != null) {
                    aVar.e(35, this.xjD);
                }
                aVar.iz(36, this.wWT);
                if (this.xjE != null) {
                    aVar.e(37, this.xjE);
                }
                aVar.iz(38, this.vRy);
                aVar.iz(39, this.vRz);
                aVar.iz(40, this.vFH);
                AppMethodBeat.o(51008);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vFF != null) {
                ix += e.a.a.b.b.a.f(2, this.vFF);
            }
            if (this.ndG != null) {
                ix += e.a.a.b.b.a.f(3, this.ndG);
            }
            if (this.ndF != null) {
                ix += e.a.a.b.b.a.f(4, this.ndF);
            }
            ix = (ix + e.a.a.b.b.a.bs(5, this.wEs)) + e.a.a.b.b.a.bs(6, this.wEt);
            if (this.wEu != null) {
                ix += e.a.a.a.ix(7, this.wEu.computeSize());
            }
            ix = (ix + e.a.a.b.b.a.bs(8, this.xjo)) + e.a.a.b.b.a.bs(9, this.xjp);
            if (this.xjq != null) {
                ix += e.a.a.a.ix(10, this.xjq.computeSize());
            }
            ix = (((ix + e.a.a.b.b.a.bs(11, this.wYj)) + e.a.a.b.b.a.bs(12, this.wdl)) + e.a.a.b.b.a.bs(13, this.wEv)) + e.a.a.b.b.a.bs(14, this.xjr);
            if (this.vEG != null) {
                ix += e.a.a.b.b.a.f(15, this.vEG);
            }
            if (this.xjs != null) {
                ix += e.a.a.b.b.a.f(16, this.xjs);
            }
            if (this.vRw != null) {
                ix += e.a.a.b.b.a.f(17, this.vRw);
            }
            ix += e.a.a.b.b.a.bs(18, this.vRx);
            if (this.wxU != null) {
                ix += e.a.a.b.b.a.f(19, this.wxU);
            }
            ix = ((ix + e.a.a.b.b.a.bs(20, this.xjg)) + e.a.a.b.b.a.bs(21, this.xjh)) + e.a.a.b.b.a.bs(22, this.xji);
            if (this.wxW != null) {
                ix += e.a.a.b.b.a.f(23, this.wxW);
            }
            ix = (ix + e.a.a.b.b.a.bs(24, this.xjt)) + e.a.a.b.b.a.bs(25, this.wdW);
            if (this.xju != null) {
                ix += e.a.a.b.b.a.f(26, this.xju);
            }
            if (this.xjv != null) {
                ix += e.a.a.b.b.a.f(27, this.xjv);
            }
            ix += e.a.a.b.b.a.bs(28, this.xjw);
            if (this.xjx != null) {
                ix += e.a.a.b.b.a.f(29, this.xjx);
            }
            if (this.xjy != null) {
                ix += e.a.a.b.b.a.f(30, this.xjy);
            }
            if (this.xjz != null) {
                ix += e.a.a.b.b.a.f(31, this.xjz);
            }
            if (this.xjA != null) {
                ix += e.a.a.b.b.a.f(32, this.xjA);
            }
            if (this.xjB != null) {
                ix += e.a.a.b.b.a.f(33, this.xjB);
            }
            if (this.xjC != null) {
                ix += e.a.a.b.b.a.f(34, this.xjC);
            }
            if (this.xjD != null) {
                ix += e.a.a.b.b.a.f(35, this.xjD);
            }
            ix += e.a.a.b.b.a.bs(36, this.wWT);
            if (this.xjE != null) {
                ix += e.a.a.b.b.a.f(37, this.xjE);
            }
            int bs = ((ix + e.a.a.b.b.a.bs(38, this.vRy)) + e.a.a.b.b.a.bs(39, this.vRz)) + e.a.a.b.b.a.bs(40, this.vFH);
            AppMethodBeat.o(51008);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wEu == null) {
                bVar = new b("Not all required fields were included: ThumbData");
                AppMethodBeat.o(51008);
                throw bVar;
            } else if (this.xjq == null) {
                bVar = new b("Not all required fields were included: VideoData");
                AppMethodBeat.o(51008);
                throw bVar;
            } else {
                AppMethodBeat.o(51008);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cls cls = (cls) objArr[1];
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
                        cls.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(51008);
                    return 0;
                case 2:
                    cls.vFF = aVar3.BTU.readString();
                    AppMethodBeat.o(51008);
                    return 0;
                case 3:
                    cls.ndG = aVar3.BTU.readString();
                    AppMethodBeat.o(51008);
                    return 0;
                case 4:
                    cls.ndF = aVar3.BTU.readString();
                    AppMethodBeat.o(51008);
                    return 0;
                case 5:
                    cls.wEs = aVar3.BTU.vd();
                    AppMethodBeat.o(51008);
                    return 0;
                case 6:
                    cls.wEt = aVar3.BTU.vd();
                    AppMethodBeat.o(51008);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cls.wEu = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(51008);
                    return 0;
                case 8:
                    cls.xjo = aVar3.BTU.vd();
                    AppMethodBeat.o(51008);
                    return 0;
                case 9:
                    cls.xjp = aVar3.BTU.vd();
                    AppMethodBeat.o(51008);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cls.xjq = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(51008);
                    return 0;
                case 11:
                    cls.wYj = aVar3.BTU.vd();
                    AppMethodBeat.o(51008);
                    return 0;
                case 12:
                    cls.wdl = aVar3.BTU.vd();
                    AppMethodBeat.o(51008);
                    return 0;
                case 13:
                    cls.wEv = aVar3.BTU.vd();
                    AppMethodBeat.o(51008);
                    return 0;
                case 14:
                    cls.xjr = aVar3.BTU.vd();
                    AppMethodBeat.o(51008);
                    return 0;
                case 15:
                    cls.vEG = aVar3.BTU.readString();
                    AppMethodBeat.o(51008);
                    return 0;
                case 16:
                    cls.xjs = aVar3.BTU.readString();
                    AppMethodBeat.o(51008);
                    return 0;
                case 17:
                    cls.vRw = aVar3.BTU.readString();
                    AppMethodBeat.o(51008);
                    return 0;
                case 18:
                    cls.vRx = aVar3.BTU.vd();
                    AppMethodBeat.o(51008);
                    return 0;
                case 19:
                    cls.wxU = aVar3.BTU.readString();
                    AppMethodBeat.o(51008);
                    return 0;
                case 20:
                    cls.xjg = aVar3.BTU.vd();
                    AppMethodBeat.o(51008);
                    return 0;
                case 21:
                    cls.xjh = aVar3.BTU.vd();
                    AppMethodBeat.o(51008);
                    return 0;
                case 22:
                    cls.xji = aVar3.BTU.vd();
                    AppMethodBeat.o(51008);
                    return 0;
                case 23:
                    cls.wxW = aVar3.BTU.readString();
                    AppMethodBeat.o(51008);
                    return 0;
                case 24:
                    cls.xjt = aVar3.BTU.vd();
                    AppMethodBeat.o(51008);
                    return 0;
                case 25:
                    cls.wdW = aVar3.BTU.vd();
                    AppMethodBeat.o(51008);
                    return 0;
                case 26:
                    cls.xju = aVar3.BTU.readString();
                    AppMethodBeat.o(51008);
                    return 0;
                case 27:
                    cls.xjv = aVar3.BTU.readString();
                    AppMethodBeat.o(51008);
                    return 0;
                case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    cls.xjw = aVar3.BTU.vd();
                    AppMethodBeat.o(51008);
                    return 0;
                case 29:
                    cls.xjx = aVar3.BTU.readString();
                    AppMethodBeat.o(51008);
                    return 0;
                case 30:
                    cls.xjy = aVar3.BTU.readString();
                    AppMethodBeat.o(51008);
                    return 0;
                case 31:
                    cls.xjz = aVar3.BTU.readString();
                    AppMethodBeat.o(51008);
                    return 0;
                case 32:
                    cls.xjA = aVar3.BTU.readString();
                    AppMethodBeat.o(51008);
                    return 0;
                case 33:
                    cls.xjB = aVar3.BTU.readString();
                    AppMethodBeat.o(51008);
                    return 0;
                case 34:
                    cls.xjC = aVar3.BTU.readString();
                    AppMethodBeat.o(51008);
                    return 0;
                case 35:
                    cls.xjD = aVar3.BTU.readString();
                    AppMethodBeat.o(51008);
                    return 0;
                case 36:
                    cls.wWT = aVar3.BTU.vd();
                    AppMethodBeat.o(51008);
                    return 0;
                case g.CTRL_INDEX /*37*/:
                    cls.xjE = aVar3.BTU.readString();
                    AppMethodBeat.o(51008);
                    return 0;
                case 38:
                    cls.vRy = aVar3.BTU.vd();
                    AppMethodBeat.o(51008);
                    return 0;
                case 39:
                    cls.vRz = aVar3.BTU.vd();
                    AppMethodBeat.o(51008);
                    return 0;
                case 40:
                    cls.vFH = aVar3.BTU.vd();
                    AppMethodBeat.o(51008);
                    return 0;
                default:
                    AppMethodBeat.o(51008);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51008);
            return -1;
        }
    }
}
