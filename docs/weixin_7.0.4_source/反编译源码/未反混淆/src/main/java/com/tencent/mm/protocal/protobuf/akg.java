package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class akg extends btd {
    public String cMD;
    public String color;
    public String kbU;
    public String kbV;
    public String kbW;
    public String kbX;
    public int kbZ;
    public String kdg;
    public int qsq;
    public String qsr;
    public String qss;
    public String qst;
    public String qsv;
    public boolean qsw;
    public String title;
    public boolean wpH;
    public boolean wpI;
    public String wpJ;
    public String wpK;
    public int wpL;
    public String wpM;
    public int wpN;
    public String wpO;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28444);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28444);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aO(2, this.wpH);
            aVar.aO(3, this.wpI);
            if (this.wpJ != null) {
                aVar.e(4, this.wpJ);
            }
            if (this.wpK != null) {
                aVar.e(5, this.wpK);
            }
            aVar.iz(6, this.wpL);
            if (this.wpM != null) {
                aVar.e(7, this.wpM);
            }
            aVar.iz(8, this.wpN);
            if (this.kbU != null) {
                aVar.e(9, this.kbU);
            }
            if (this.cMD != null) {
                aVar.e(10, this.cMD);
            }
            if (this.title != null) {
                aVar.e(11, this.title);
            }
            if (this.kbW != null) {
                aVar.e(12, this.kbW);
            }
            if (this.kbX != null) {
                aVar.e(13, this.kbX);
            }
            if (this.kdg != null) {
                aVar.e(14, this.kdg);
            }
            if (this.kbV != null) {
                aVar.e(15, this.kbV);
            }
            if (this.color != null) {
                aVar.e(16, this.color);
            }
            aVar.iz(17, this.qsq);
            if (this.qsr != null) {
                aVar.e(18, this.qsr);
            }
            if (this.qss != null) {
                aVar.e(19, this.qss);
            }
            if (this.qst != null) {
                aVar.e(20, this.qst);
            }
            aVar.iz(21, this.kbZ);
            if (this.qsv != null) {
                aVar.e(22, this.qsv);
            }
            if (this.wpO != null) {
                aVar.e(23, this.wpO);
            }
            aVar.aO(24, this.qsw);
            AppMethodBeat.o(28444);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + (e.a.a.b.b.a.fv(2) + 1)) + (e.a.a.b.b.a.fv(3) + 1);
            if (this.wpJ != null) {
                ix += e.a.a.b.b.a.f(4, this.wpJ);
            }
            if (this.wpK != null) {
                ix += e.a.a.b.b.a.f(5, this.wpK);
            }
            ix += e.a.a.b.b.a.bs(6, this.wpL);
            if (this.wpM != null) {
                ix += e.a.a.b.b.a.f(7, this.wpM);
            }
            ix += e.a.a.b.b.a.bs(8, this.wpN);
            if (this.kbU != null) {
                ix += e.a.a.b.b.a.f(9, this.kbU);
            }
            if (this.cMD != null) {
                ix += e.a.a.b.b.a.f(10, this.cMD);
            }
            if (this.title != null) {
                ix += e.a.a.b.b.a.f(11, this.title);
            }
            if (this.kbW != null) {
                ix += e.a.a.b.b.a.f(12, this.kbW);
            }
            if (this.kbX != null) {
                ix += e.a.a.b.b.a.f(13, this.kbX);
            }
            if (this.kdg != null) {
                ix += e.a.a.b.b.a.f(14, this.kdg);
            }
            if (this.kbV != null) {
                ix += e.a.a.b.b.a.f(15, this.kbV);
            }
            if (this.color != null) {
                ix += e.a.a.b.b.a.f(16, this.color);
            }
            ix += e.a.a.b.b.a.bs(17, this.qsq);
            if (this.qsr != null) {
                ix += e.a.a.b.b.a.f(18, this.qsr);
            }
            if (this.qss != null) {
                ix += e.a.a.b.b.a.f(19, this.qss);
            }
            if (this.qst != null) {
                ix += e.a.a.b.b.a.f(20, this.qst);
            }
            ix += e.a.a.b.b.a.bs(21, this.kbZ);
            if (this.qsv != null) {
                ix += e.a.a.b.b.a.f(22, this.qsv);
            }
            if (this.wpO != null) {
                ix += e.a.a.b.b.a.f(23, this.wpO);
            }
            int fv = ix + (e.a.a.b.b.a.fv(24) + 1);
            AppMethodBeat.o(28444);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28444);
                throw bVar;
            }
            AppMethodBeat.o(28444);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            akg akg = (akg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        akg.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(28444);
                    return 0;
                case 2:
                    akg.wpH = aVar3.BTU.ehX();
                    AppMethodBeat.o(28444);
                    return 0;
                case 3:
                    akg.wpI = aVar3.BTU.ehX();
                    AppMethodBeat.o(28444);
                    return 0;
                case 4:
                    akg.wpJ = aVar3.BTU.readString();
                    AppMethodBeat.o(28444);
                    return 0;
                case 5:
                    akg.wpK = aVar3.BTU.readString();
                    AppMethodBeat.o(28444);
                    return 0;
                case 6:
                    akg.wpL = aVar3.BTU.vd();
                    AppMethodBeat.o(28444);
                    return 0;
                case 7:
                    akg.wpM = aVar3.BTU.readString();
                    AppMethodBeat.o(28444);
                    return 0;
                case 8:
                    akg.wpN = aVar3.BTU.vd();
                    AppMethodBeat.o(28444);
                    return 0;
                case 9:
                    akg.kbU = aVar3.BTU.readString();
                    AppMethodBeat.o(28444);
                    return 0;
                case 10:
                    akg.cMD = aVar3.BTU.readString();
                    AppMethodBeat.o(28444);
                    return 0;
                case 11:
                    akg.title = aVar3.BTU.readString();
                    AppMethodBeat.o(28444);
                    return 0;
                case 12:
                    akg.kbW = aVar3.BTU.readString();
                    AppMethodBeat.o(28444);
                    return 0;
                case 13:
                    akg.kbX = aVar3.BTU.readString();
                    AppMethodBeat.o(28444);
                    return 0;
                case 14:
                    akg.kdg = aVar3.BTU.readString();
                    AppMethodBeat.o(28444);
                    return 0;
                case 15:
                    akg.kbV = aVar3.BTU.readString();
                    AppMethodBeat.o(28444);
                    return 0;
                case 16:
                    akg.color = aVar3.BTU.readString();
                    AppMethodBeat.o(28444);
                    return 0;
                case 17:
                    akg.qsq = aVar3.BTU.vd();
                    AppMethodBeat.o(28444);
                    return 0;
                case 18:
                    akg.qsr = aVar3.BTU.readString();
                    AppMethodBeat.o(28444);
                    return 0;
                case 19:
                    akg.qss = aVar3.BTU.readString();
                    AppMethodBeat.o(28444);
                    return 0;
                case 20:
                    akg.qst = aVar3.BTU.readString();
                    AppMethodBeat.o(28444);
                    return 0;
                case 21:
                    akg.kbZ = aVar3.BTU.vd();
                    AppMethodBeat.o(28444);
                    return 0;
                case 22:
                    akg.qsv = aVar3.BTU.readString();
                    AppMethodBeat.o(28444);
                    return 0;
                case 23:
                    akg.wpO = aVar3.BTU.readString();
                    AppMethodBeat.o(28444);
                    return 0;
                case 24:
                    akg.qsw = aVar3.BTU.ehX();
                    AppMethodBeat.o(28444);
                    return 0;
                default:
                    AppMethodBeat.o(28444);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28444);
            return -1;
        }
    }
}
