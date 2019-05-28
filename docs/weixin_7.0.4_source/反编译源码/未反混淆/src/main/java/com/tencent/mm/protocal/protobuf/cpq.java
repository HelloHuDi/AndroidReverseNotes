package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cpq extends btd {
    public int vIN;
    public LinkedList<coj> vIO = new LinkedList();
    public int wPb;
    public int wem;
    public long wen;
    public cpr xlT;
    public int xlU;
    public int xlV;
    public int xlW;
    public int xlX;
    public SKBuiltinBuffer_t xlY;
    public int xmZ;
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
    public int xna;
    public int xnb;

    public cpq() {
        AppMethodBeat.i(5251);
        AppMethodBeat.o(5251);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5252);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(5252);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.wem);
            aVar.iz(3, this.vIN);
            aVar.e(4, 8, this.vIO);
            aVar.ai(5, this.wen);
            aVar.iz(6, this.wPb);
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
            aVar.iz(14, this.xmZ);
            aVar.iz(15, this.xmj);
            aVar.iz(16, this.xmk);
            aVar.iz(17, this.xlU);
            aVar.iz(18, this.xml);
            aVar.iz(19, this.xmm);
            aVar.iz(20, this.xlV);
            aVar.iz(21, this.xmn);
            aVar.iz(22, this.xmo);
            aVar.iz(23, this.xmp);
            aVar.iz(24, this.xna);
            aVar.iz(25, this.xmq);
            aVar.iz(26, this.xnb);
            aVar.iz(27, this.xlW);
            aVar.iz(28, this.xlX);
            aVar.iz(29, this.xmr);
            aVar.iz(30, this.xms);
            if (this.xlY != null) {
                aVar.iy(31, this.xlY.computeSize());
                this.xlY.writeFields(aVar);
            }
            AppMethodBeat.o(5252);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((((ix + e.a.a.b.b.a.bs(2, this.wem)) + e.a.a.b.b.a.bs(3, this.vIN)) + e.a.a.a.c(4, 8, this.vIO)) + e.a.a.b.b.a.o(5, this.wen)) + e.a.a.b.b.a.bs(6, this.wPb);
            if (this.xlT != null) {
                ix += e.a.a.a.ix(7, this.xlT.computeSize());
            }
            ix = ((((((((((((((((((((((ix + e.a.a.b.b.a.bs(8, this.xmd)) + e.a.a.a.c(9, 8, this.xme)) + e.a.a.b.b.a.bs(10, this.xmf)) + e.a.a.b.b.a.bs(11, this.xmg)) + e.a.a.b.b.a.bs(12, this.xmh)) + e.a.a.b.b.a.bs(13, this.xmi)) + e.a.a.b.b.a.bs(14, this.xmZ)) + e.a.a.b.b.a.bs(15, this.xmj)) + e.a.a.b.b.a.bs(16, this.xmk)) + e.a.a.b.b.a.bs(17, this.xlU)) + e.a.a.b.b.a.bs(18, this.xml)) + e.a.a.b.b.a.bs(19, this.xmm)) + e.a.a.b.b.a.bs(20, this.xlV)) + e.a.a.b.b.a.bs(21, this.xmn)) + e.a.a.b.b.a.bs(22, this.xmo)) + e.a.a.b.b.a.bs(23, this.xmp)) + e.a.a.b.b.a.bs(24, this.xna)) + e.a.a.b.b.a.bs(25, this.xmq)) + e.a.a.b.b.a.bs(26, this.xnb)) + e.a.a.b.b.a.bs(27, this.xlW)) + e.a.a.b.b.a.bs(28, this.xlX)) + e.a.a.b.b.a.bs(29, this.xmr)) + e.a.a.b.b.a.bs(30, this.xms);
            if (this.xlY != null) {
                ix += e.a.a.a.ix(31, this.xlY.computeSize());
            }
            AppMethodBeat.o(5252);
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
                AppMethodBeat.o(5252);
                throw bVar;
            }
            AppMethodBeat.o(5252);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cpq cpq = (cpq) objArr[1];
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
                        cpq.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(5252);
                    return 0;
                case 2:
                    cpq.wem = aVar3.BTU.vd();
                    AppMethodBeat.o(5252);
                    return 0;
                case 3:
                    cpq.vIN = aVar3.BTU.vd();
                    AppMethodBeat.o(5252);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        coj coj = new coj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = coj.populateBuilderWithField(aVar4, coj, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cpq.vIO.add(coj);
                    }
                    AppMethodBeat.o(5252);
                    return 0;
                case 5:
                    cpq.wen = aVar3.BTU.ve();
                    AppMethodBeat.o(5252);
                    return 0;
                case 6:
                    cpq.wPb = aVar3.BTU.vd();
                    AppMethodBeat.o(5252);
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
                        cpq.xlT = cpr;
                    }
                    AppMethodBeat.o(5252);
                    return 0;
                case 8:
                    cpq.xmd = aVar3.BTU.vd();
                    AppMethodBeat.o(5252);
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
                        cpq.xme.add(cpt);
                    }
                    AppMethodBeat.o(5252);
                    return 0;
                case 10:
                    cpq.xmf = aVar3.BTU.vd();
                    AppMethodBeat.o(5252);
                    return 0;
                case 11:
                    cpq.xmg = aVar3.BTU.vd();
                    AppMethodBeat.o(5252);
                    return 0;
                case 12:
                    cpq.xmh = aVar3.BTU.vd();
                    AppMethodBeat.o(5252);
                    return 0;
                case 13:
                    cpq.xmi = aVar3.BTU.vd();
                    AppMethodBeat.o(5252);
                    return 0;
                case 14:
                    cpq.xmZ = aVar3.BTU.vd();
                    AppMethodBeat.o(5252);
                    return 0;
                case 15:
                    cpq.xmj = aVar3.BTU.vd();
                    AppMethodBeat.o(5252);
                    return 0;
                case 16:
                    cpq.xmk = aVar3.BTU.vd();
                    AppMethodBeat.o(5252);
                    return 0;
                case 17:
                    cpq.xlU = aVar3.BTU.vd();
                    AppMethodBeat.o(5252);
                    return 0;
                case 18:
                    cpq.xml = aVar3.BTU.vd();
                    AppMethodBeat.o(5252);
                    return 0;
                case 19:
                    cpq.xmm = aVar3.BTU.vd();
                    AppMethodBeat.o(5252);
                    return 0;
                case 20:
                    cpq.xlV = aVar3.BTU.vd();
                    AppMethodBeat.o(5252);
                    return 0;
                case 21:
                    cpq.xmn = aVar3.BTU.vd();
                    AppMethodBeat.o(5252);
                    return 0;
                case 22:
                    cpq.xmo = aVar3.BTU.vd();
                    AppMethodBeat.o(5252);
                    return 0;
                case 23:
                    cpq.xmp = aVar3.BTU.vd();
                    AppMethodBeat.o(5252);
                    return 0;
                case 24:
                    cpq.xna = aVar3.BTU.vd();
                    AppMethodBeat.o(5252);
                    return 0;
                case 25:
                    cpq.xmq = aVar3.BTU.vd();
                    AppMethodBeat.o(5252);
                    return 0;
                case 26:
                    cpq.xnb = aVar3.BTU.vd();
                    AppMethodBeat.o(5252);
                    return 0;
                case 27:
                    cpq.xlW = aVar3.BTU.vd();
                    AppMethodBeat.o(5252);
                    return 0;
                case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    cpq.xlX = aVar3.BTU.vd();
                    AppMethodBeat.o(5252);
                    return 0;
                case 29:
                    cpq.xmr = aVar3.BTU.vd();
                    AppMethodBeat.o(5252);
                    return 0;
                case 30:
                    cpq.xms = aVar3.BTU.vd();
                    AppMethodBeat.o(5252);
                    return 0;
                case 31:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cpq.xlY = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(5252);
                    return 0;
                default:
                    AppMethodBeat.o(5252);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5252);
            return -1;
        }
    }
}
