package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;
import e.a.a.c.a;
import java.util.LinkedList;

public final class agk extends btd {
    public String color;
    public String content;
    public String kbU;
    public String kcU;
    public String kcV;
    public String vBE;
    public String vBF;
    public String vBG;
    public String vBH;
    public String vBI;
    public String vBJ;
    public String vBK;
    public String vBL;
    public String vBM;
    public String vBN;
    public String vBO;
    public String vBP;
    public boolean vBQ = false;
    public int vBR;
    public int vBS;
    public int vBT;
    public String vBU;
    public String vBV;
    public int vBW;
    public String vBX;
    public String vBY;
    public String vBZ;
    public String vCa;
    public String vCb;
    public String vCc;
    public String vCd;
    public String vCe;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89076);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.vBE != null) {
                aVar.e(2, this.vBE);
            }
            if (this.vBF != null) {
                aVar.e(3, this.vBF);
            }
            if (this.vBG != null) {
                aVar.e(4, this.vBG);
            }
            if (this.content != null) {
                aVar.e(5, this.content);
            }
            if (this.vBH != null) {
                aVar.e(6, this.vBH);
            }
            if (this.vBI != null) {
                aVar.e(7, this.vBI);
            }
            if (this.vBJ != null) {
                aVar.e(8, this.vBJ);
            }
            if (this.vBK != null) {
                aVar.e(9, this.vBK);
            }
            if (this.vBL != null) {
                aVar.e(10, this.vBL);
            }
            if (this.vBM != null) {
                aVar.e(11, this.vBM);
            }
            if (this.vBN != null) {
                aVar.e(12, this.vBN);
            }
            if (this.vBO != null) {
                aVar.e(13, this.vBO);
            }
            if (this.kcU != null) {
                aVar.e(14, this.kcU);
            }
            if (this.kcV != null) {
                aVar.e(15, this.kcV);
            }
            if (this.vBP != null) {
                aVar.e(16, this.vBP);
            }
            aVar.aO(17, this.vBQ);
            aVar.iz(18, this.vBR);
            aVar.iz(19, this.vBS);
            aVar.iz(20, this.vBT);
            if (this.color != null) {
                aVar.e(21, this.color);
            }
            if (this.vBU != null) {
                aVar.e(22, this.vBU);
            }
            if (this.vBV != null) {
                aVar.e(23, this.vBV);
            }
            aVar.iz(24, this.vBW);
            if (this.vBX != null) {
                aVar.e(25, this.vBX);
            }
            if (this.vBY != null) {
                aVar.e(26, this.vBY);
            }
            if (this.vBZ != null) {
                aVar.e(27, this.vBZ);
            }
            if (this.vCa != null) {
                aVar.e(28, this.vCa);
            }
            if (this.vCb != null) {
                aVar.e(29, this.vCb);
            }
            if (this.vCc != null) {
                aVar.e(30, this.vCc);
            }
            if (this.vCd != null) {
                aVar.e(31, this.vCd);
            }
            if (this.kbU != null) {
                aVar.e(32, this.kbU);
            }
            if (this.vCe != null) {
                aVar.e(33, this.vCe);
            }
            AppMethodBeat.o(89076);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vBE != null) {
                ix += e.a.a.b.b.a.f(2, this.vBE);
            }
            if (this.vBF != null) {
                ix += e.a.a.b.b.a.f(3, this.vBF);
            }
            if (this.vBG != null) {
                ix += e.a.a.b.b.a.f(4, this.vBG);
            }
            if (this.content != null) {
                ix += e.a.a.b.b.a.f(5, this.content);
            }
            if (this.vBH != null) {
                ix += e.a.a.b.b.a.f(6, this.vBH);
            }
            if (this.vBI != null) {
                ix += e.a.a.b.b.a.f(7, this.vBI);
            }
            if (this.vBJ != null) {
                ix += e.a.a.b.b.a.f(8, this.vBJ);
            }
            if (this.vBK != null) {
                ix += e.a.a.b.b.a.f(9, this.vBK);
            }
            if (this.vBL != null) {
                ix += e.a.a.b.b.a.f(10, this.vBL);
            }
            if (this.vBM != null) {
                ix += e.a.a.b.b.a.f(11, this.vBM);
            }
            if (this.vBN != null) {
                ix += e.a.a.b.b.a.f(12, this.vBN);
            }
            if (this.vBO != null) {
                ix += e.a.a.b.b.a.f(13, this.vBO);
            }
            if (this.kcU != null) {
                ix += e.a.a.b.b.a.f(14, this.kcU);
            }
            if (this.kcV != null) {
                ix += e.a.a.b.b.a.f(15, this.kcV);
            }
            if (this.vBP != null) {
                ix += e.a.a.b.b.a.f(16, this.vBP);
            }
            ix = (((ix + (e.a.a.b.b.a.fv(17) + 1)) + e.a.a.b.b.a.bs(18, this.vBR)) + e.a.a.b.b.a.bs(19, this.vBS)) + e.a.a.b.b.a.bs(20, this.vBT);
            if (this.color != null) {
                ix += e.a.a.b.b.a.f(21, this.color);
            }
            if (this.vBU != null) {
                ix += e.a.a.b.b.a.f(22, this.vBU);
            }
            if (this.vBV != null) {
                ix += e.a.a.b.b.a.f(23, this.vBV);
            }
            ix += e.a.a.b.b.a.bs(24, this.vBW);
            if (this.vBX != null) {
                ix += e.a.a.b.b.a.f(25, this.vBX);
            }
            if (this.vBY != null) {
                ix += e.a.a.b.b.a.f(26, this.vBY);
            }
            if (this.vBZ != null) {
                ix += e.a.a.b.b.a.f(27, this.vBZ);
            }
            if (this.vCa != null) {
                ix += e.a.a.b.b.a.f(28, this.vCa);
            }
            if (this.vCb != null) {
                ix += e.a.a.b.b.a.f(29, this.vCb);
            }
            if (this.vCc != null) {
                ix += e.a.a.b.b.a.f(30, this.vCc);
            }
            if (this.vCd != null) {
                ix += e.a.a.b.b.a.f(31, this.vCd);
            }
            if (this.kbU != null) {
                ix += e.a.a.b.b.a.f(32, this.kbU);
            }
            if (this.vCe != null) {
                ix += e.a.a.b.b.a.f(33, this.vCe);
            }
            AppMethodBeat.o(89076);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89076);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            agk agk = (agk) objArr[1];
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
                        agk.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(89076);
                    return 0;
                case 2:
                    agk.vBE = aVar3.BTU.readString();
                    AppMethodBeat.o(89076);
                    return 0;
                case 3:
                    agk.vBF = aVar3.BTU.readString();
                    AppMethodBeat.o(89076);
                    return 0;
                case 4:
                    agk.vBG = aVar3.BTU.readString();
                    AppMethodBeat.o(89076);
                    return 0;
                case 5:
                    agk.content = aVar3.BTU.readString();
                    AppMethodBeat.o(89076);
                    return 0;
                case 6:
                    agk.vBH = aVar3.BTU.readString();
                    AppMethodBeat.o(89076);
                    return 0;
                case 7:
                    agk.vBI = aVar3.BTU.readString();
                    AppMethodBeat.o(89076);
                    return 0;
                case 8:
                    agk.vBJ = aVar3.BTU.readString();
                    AppMethodBeat.o(89076);
                    return 0;
                case 9:
                    agk.vBK = aVar3.BTU.readString();
                    AppMethodBeat.o(89076);
                    return 0;
                case 10:
                    agk.vBL = aVar3.BTU.readString();
                    AppMethodBeat.o(89076);
                    return 0;
                case 11:
                    agk.vBM = aVar3.BTU.readString();
                    AppMethodBeat.o(89076);
                    return 0;
                case 12:
                    agk.vBN = aVar3.BTU.readString();
                    AppMethodBeat.o(89076);
                    return 0;
                case 13:
                    agk.vBO = aVar3.BTU.readString();
                    AppMethodBeat.o(89076);
                    return 0;
                case 14:
                    agk.kcU = aVar3.BTU.readString();
                    AppMethodBeat.o(89076);
                    return 0;
                case 15:
                    agk.kcV = aVar3.BTU.readString();
                    AppMethodBeat.o(89076);
                    return 0;
                case 16:
                    agk.vBP = aVar3.BTU.readString();
                    AppMethodBeat.o(89076);
                    return 0;
                case 17:
                    agk.vBQ = aVar3.BTU.ehX();
                    AppMethodBeat.o(89076);
                    return 0;
                case 18:
                    agk.vBR = aVar3.BTU.vd();
                    AppMethodBeat.o(89076);
                    return 0;
                case 19:
                    agk.vBS = aVar3.BTU.vd();
                    AppMethodBeat.o(89076);
                    return 0;
                case 20:
                    agk.vBT = aVar3.BTU.vd();
                    AppMethodBeat.o(89076);
                    return 0;
                case 21:
                    agk.color = aVar3.BTU.readString();
                    AppMethodBeat.o(89076);
                    return 0;
                case 22:
                    agk.vBU = aVar3.BTU.readString();
                    AppMethodBeat.o(89076);
                    return 0;
                case 23:
                    agk.vBV = aVar3.BTU.readString();
                    AppMethodBeat.o(89076);
                    return 0;
                case 24:
                    agk.vBW = aVar3.BTU.vd();
                    AppMethodBeat.o(89076);
                    return 0;
                case 25:
                    agk.vBX = aVar3.BTU.readString();
                    AppMethodBeat.o(89076);
                    return 0;
                case 26:
                    agk.vBY = aVar3.BTU.readString();
                    AppMethodBeat.o(89076);
                    return 0;
                case 27:
                    agk.vBZ = aVar3.BTU.readString();
                    AppMethodBeat.o(89076);
                    return 0;
                case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    agk.vCa = aVar3.BTU.readString();
                    AppMethodBeat.o(89076);
                    return 0;
                case 29:
                    agk.vCb = aVar3.BTU.readString();
                    AppMethodBeat.o(89076);
                    return 0;
                case 30:
                    agk.vCc = aVar3.BTU.readString();
                    AppMethodBeat.o(89076);
                    return 0;
                case 31:
                    agk.vCd = aVar3.BTU.readString();
                    AppMethodBeat.o(89076);
                    return 0;
                case 32:
                    agk.kbU = aVar3.BTU.readString();
                    AppMethodBeat.o(89076);
                    return 0;
                case 33:
                    agk.vCe = aVar3.BTU.readString();
                    AppMethodBeat.o(89076);
                    return 0;
                default:
                    AppMethodBeat.o(89076);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89076);
            return -1;
        }
    }
}
