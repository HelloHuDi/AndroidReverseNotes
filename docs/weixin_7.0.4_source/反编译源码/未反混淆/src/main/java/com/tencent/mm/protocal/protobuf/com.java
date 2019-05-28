package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class com extends btd {
    public int vIN;
    public LinkedList<coj> vIO = new LinkedList();
    public int wem;
    public long wen;
    public int xlS;
    public cpr xlT;
    public int xlU;
    public int xlV;
    public int xlW;
    public int xlX;
    public SKBuiltinBuffer_t xlY;
    public int xmd;
    public LinkedList<cpt> xme = new LinkedList();
    public int xmf;
    public int xmg;
    public int xmh;
    public int xmi;
    public int xmj;
    public int xmk;
    public int xml;
    public int xmm;
    public int xmn;
    public int xmo;
    public int xmp;
    public int xmq;
    public int xmr;
    public int xms;

    public com() {
        AppMethodBeat.i(5231);
        AppMethodBeat.o(5231);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5232);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(5232);
                throw bVar;
            } else if (this.xlT == null) {
                bVar = new b("Not all required fields were included: RelayData");
                AppMethodBeat.o(5232);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                aVar.iz(2, this.vIN);
                aVar.e(3, 8, this.vIO);
                aVar.iz(4, this.wem);
                aVar.ai(5, this.wen);
                aVar.iz(6, this.xlS);
                if (this.xlT != null) {
                    aVar.iy(7, this.xlT.computeSize());
                    this.xlT.writeFields(aVar);
                }
                aVar.iz(8, this.xmd);
                aVar.e(9, 8, this.xme);
                aVar.iz(10, this.xmf);
                aVar.iz(11, this.xmg);
                aVar.iz(12, this.xmh);
                aVar.iz(13, this.xmi);
                aVar.iz(14, this.xmj);
                aVar.iz(15, this.xmk);
                aVar.iz(16, this.xlU);
                aVar.iz(17, this.xml);
                aVar.iz(18, this.xmm);
                aVar.iz(19, this.xlV);
                aVar.iz(20, this.xmn);
                aVar.iz(21, this.xmo);
                aVar.iz(22, this.xmp);
                aVar.iz(23, this.xmq);
                aVar.iz(24, this.xlW);
                aVar.iz(25, this.xlX);
                aVar.iz(26, this.xmr);
                aVar.iz(27, this.xms);
                if (this.xlY != null) {
                    aVar.iy(28, this.xlY.computeSize());
                    this.xlY.writeFields(aVar);
                }
                AppMethodBeat.o(5232);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((((ix + e.a.a.b.b.a.bs(2, this.vIN)) + e.a.a.a.c(3, 8, this.vIO)) + e.a.a.b.b.a.bs(4, this.wem)) + e.a.a.b.b.a.o(5, this.wen)) + e.a.a.b.b.a.bs(6, this.xlS);
            if (this.xlT != null) {
                ix += e.a.a.a.ix(7, this.xlT.computeSize());
            }
            ix = (((((((((((((((((((ix + e.a.a.b.b.a.bs(8, this.xmd)) + e.a.a.a.c(9, 8, this.xme)) + e.a.a.b.b.a.bs(10, this.xmf)) + e.a.a.b.b.a.bs(11, this.xmg)) + e.a.a.b.b.a.bs(12, this.xmh)) + e.a.a.b.b.a.bs(13, this.xmi)) + e.a.a.b.b.a.bs(14, this.xmj)) + e.a.a.b.b.a.bs(15, this.xmk)) + e.a.a.b.b.a.bs(16, this.xlU)) + e.a.a.b.b.a.bs(17, this.xml)) + e.a.a.b.b.a.bs(18, this.xmm)) + e.a.a.b.b.a.bs(19, this.xlV)) + e.a.a.b.b.a.bs(20, this.xmn)) + e.a.a.b.b.a.bs(21, this.xmo)) + e.a.a.b.b.a.bs(22, this.xmp)) + e.a.a.b.b.a.bs(23, this.xmq)) + e.a.a.b.b.a.bs(24, this.xlW)) + e.a.a.b.b.a.bs(25, this.xlX)) + e.a.a.b.b.a.bs(26, this.xmr)) + e.a.a.b.b.a.bs(27, this.xms);
            if (this.xlY != null) {
                ix += e.a.a.a.ix(28, this.xlY.computeSize());
            }
            AppMethodBeat.o(5232);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vIO.clear();
            this.xme.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(5232);
                throw bVar;
            } else if (this.xlT == null) {
                bVar = new b("Not all required fields were included: RelayData");
                AppMethodBeat.o(5232);
                throw bVar;
            } else {
                AppMethodBeat.o(5232);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            com com = (com) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        com.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(5232);
                    return 0;
                case 2:
                    com.vIN = aVar3.BTU.vd();
                    AppMethodBeat.o(5232);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        coj coj = new coj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = coj.populateBuilderWithField(aVar4, coj, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        com.vIO.add(coj);
                    }
                    AppMethodBeat.o(5232);
                    return 0;
                case 4:
                    com.wem = aVar3.BTU.vd();
                    AppMethodBeat.o(5232);
                    return 0;
                case 5:
                    com.wen = aVar3.BTU.ve();
                    AppMethodBeat.o(5232);
                    return 0;
                case 6:
                    com.xlS = aVar3.BTU.vd();
                    AppMethodBeat.o(5232);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cpr cpr = new cpr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpr.populateBuilderWithField(aVar4, cpr, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        com.xlT = cpr;
                    }
                    AppMethodBeat.o(5232);
                    return 0;
                case 8:
                    com.xmd = aVar3.BTU.vd();
                    AppMethodBeat.o(5232);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cpt cpt = new cpt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpt.populateBuilderWithField(aVar4, cpt, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        com.xme.add(cpt);
                    }
                    AppMethodBeat.o(5232);
                    return 0;
                case 10:
                    com.xmf = aVar3.BTU.vd();
                    AppMethodBeat.o(5232);
                    return 0;
                case 11:
                    com.xmg = aVar3.BTU.vd();
                    AppMethodBeat.o(5232);
                    return 0;
                case 12:
                    com.xmh = aVar3.BTU.vd();
                    AppMethodBeat.o(5232);
                    return 0;
                case 13:
                    com.xmi = aVar3.BTU.vd();
                    AppMethodBeat.o(5232);
                    return 0;
                case 14:
                    com.xmj = aVar3.BTU.vd();
                    AppMethodBeat.o(5232);
                    return 0;
                case 15:
                    com.xmk = aVar3.BTU.vd();
                    AppMethodBeat.o(5232);
                    return 0;
                case 16:
                    com.xlU = aVar3.BTU.vd();
                    AppMethodBeat.o(5232);
                    return 0;
                case 17:
                    com.xml = aVar3.BTU.vd();
                    AppMethodBeat.o(5232);
                    return 0;
                case 18:
                    com.xmm = aVar3.BTU.vd();
                    AppMethodBeat.o(5232);
                    return 0;
                case 19:
                    com.xlV = aVar3.BTU.vd();
                    AppMethodBeat.o(5232);
                    return 0;
                case 20:
                    com.xmn = aVar3.BTU.vd();
                    AppMethodBeat.o(5232);
                    return 0;
                case 21:
                    com.xmo = aVar3.BTU.vd();
                    AppMethodBeat.o(5232);
                    return 0;
                case 22:
                    com.xmp = aVar3.BTU.vd();
                    AppMethodBeat.o(5232);
                    return 0;
                case 23:
                    com.xmq = aVar3.BTU.vd();
                    AppMethodBeat.o(5232);
                    return 0;
                case 24:
                    com.xlW = aVar3.BTU.vd();
                    AppMethodBeat.o(5232);
                    return 0;
                case 25:
                    com.xlX = aVar3.BTU.vd();
                    AppMethodBeat.o(5232);
                    return 0;
                case 26:
                    com.xmr = aVar3.BTU.vd();
                    AppMethodBeat.o(5232);
                    return 0;
                case 27:
                    com.xms = aVar3.BTU.vd();
                    AppMethodBeat.o(5232);
                    return 0;
                case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        com.xlY = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(5232);
                    return 0;
                default:
                    AppMethodBeat.o(5232);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5232);
            return -1;
        }
    }
}
