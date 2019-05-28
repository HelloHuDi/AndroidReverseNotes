package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import com.tencent.view.d;
import e.a.a.c.a;
import java.util.LinkedList;

public final class lv extends btd {
    public String cBT;
    public int kdT;
    public String kdU;
    public int pPG = 0;
    public String pPH;
    public String pPI;
    public String pPJ;
    public String pPK;
    public String vFb;
    public String vFc;
    public String vFd;
    public String vPA;
    public bzp vPB;
    public String vPC;
    public String vPD;
    public int vPE;
    public int vPF;
    public int vPG;
    public chl vPH;
    public String vPI;
    public int vPJ;
    public int vPK;
    public int vPL;
    public b vPM;
    public int vPN;
    public int vPO;
    public int vPP;
    public String vPo;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56725);
        e.a.a.b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56725);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.kdT);
            if (this.kdU != null) {
                aVar.e(3, this.kdU);
            }
            if (this.cBT != null) {
                aVar.e(4, this.cBT);
            }
            if (this.vPA != null) {
                aVar.e(5, this.vPA);
            }
            if (this.vPB != null) {
                aVar.iy(6, this.vPB.computeSize());
                this.vPB.writeFields(aVar);
            }
            if (this.vFb != null) {
                aVar.e(7, this.vFb);
            }
            if (this.vFd != null) {
                aVar.e(8, this.vFd);
            }
            if (this.vPC != null) {
                aVar.e(9, this.vPC);
            }
            if (this.vPD != null) {
                aVar.e(10, this.vPD);
            }
            aVar.iz(11, this.vPE);
            if (this.vFc != null) {
                aVar.e(12, this.vFc);
            }
            if (this.vPo != null) {
                aVar.e(13, this.vPo);
            }
            aVar.iz(14, this.vPF);
            aVar.iz(15, this.vPG);
            if (this.vPH != null) {
                aVar.iy(16, this.vPH.computeSize());
                this.vPH.writeFields(aVar);
            }
            if (this.vPI != null) {
                aVar.e(17, this.vPI);
            }
            aVar.iz(18, this.vPJ);
            aVar.iz(19, this.vPK);
            aVar.iz(20, this.vPL);
            if (this.vPM != null) {
                aVar.c(21, this.vPM);
            }
            aVar.iz(22, this.vPN);
            aVar.iz(23, this.pPG);
            if (this.pPH != null) {
                aVar.e(24, this.pPH);
            }
            if (this.pPI != null) {
                aVar.e(25, this.pPI);
            }
            aVar.iz(26, this.vPO);
            if (this.pPJ != null) {
                aVar.e(27, this.pPJ);
            }
            if (this.pPK != null) {
                aVar.e(28, this.pPK);
            }
            aVar.iz(29, this.vPP);
            AppMethodBeat.o(56725);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.kdT);
            if (this.kdU != null) {
                ix += e.a.a.b.b.a.f(3, this.kdU);
            }
            if (this.cBT != null) {
                ix += e.a.a.b.b.a.f(4, this.cBT);
            }
            if (this.vPA != null) {
                ix += e.a.a.b.b.a.f(5, this.vPA);
            }
            if (this.vPB != null) {
                ix += e.a.a.a.ix(6, this.vPB.computeSize());
            }
            if (this.vFb != null) {
                ix += e.a.a.b.b.a.f(7, this.vFb);
            }
            if (this.vFd != null) {
                ix += e.a.a.b.b.a.f(8, this.vFd);
            }
            if (this.vPC != null) {
                ix += e.a.a.b.b.a.f(9, this.vPC);
            }
            if (this.vPD != null) {
                ix += e.a.a.b.b.a.f(10, this.vPD);
            }
            ix += e.a.a.b.b.a.bs(11, this.vPE);
            if (this.vFc != null) {
                ix += e.a.a.b.b.a.f(12, this.vFc);
            }
            if (this.vPo != null) {
                ix += e.a.a.b.b.a.f(13, this.vPo);
            }
            ix = (ix + e.a.a.b.b.a.bs(14, this.vPF)) + e.a.a.b.b.a.bs(15, this.vPG);
            if (this.vPH != null) {
                ix += e.a.a.a.ix(16, this.vPH.computeSize());
            }
            if (this.vPI != null) {
                ix += e.a.a.b.b.a.f(17, this.vPI);
            }
            ix = ((ix + e.a.a.b.b.a.bs(18, this.vPJ)) + e.a.a.b.b.a.bs(19, this.vPK)) + e.a.a.b.b.a.bs(20, this.vPL);
            if (this.vPM != null) {
                ix += e.a.a.b.b.a.b(21, this.vPM);
            }
            ix = (ix + e.a.a.b.b.a.bs(22, this.vPN)) + e.a.a.b.b.a.bs(23, this.pPG);
            if (this.pPH != null) {
                ix += e.a.a.b.b.a.f(24, this.pPH);
            }
            if (this.pPI != null) {
                ix += e.a.a.b.b.a.f(25, this.pPI);
            }
            ix += e.a.a.b.b.a.bs(26, this.vPO);
            if (this.pPJ != null) {
                ix += e.a.a.b.b.a.f(27, this.pPJ);
            }
            if (this.pPK != null) {
                ix += e.a.a.b.b.a.f(28, this.pPK);
            }
            int bs = ix + e.a.a.b.b.a.bs(29, this.vPP);
            AppMethodBeat.o(56725);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56725);
                throw bVar;
            }
            AppMethodBeat.o(56725);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            lv lvVar = (lv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
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
                        lvVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56725);
                    return 0;
                case 2:
                    lvVar.kdT = aVar3.BTU.vd();
                    AppMethodBeat.o(56725);
                    return 0;
                case 3:
                    lvVar.kdU = aVar3.BTU.readString();
                    AppMethodBeat.o(56725);
                    return 0;
                case 4:
                    lvVar.cBT = aVar3.BTU.readString();
                    AppMethodBeat.o(56725);
                    return 0;
                case 5:
                    lvVar.vPA = aVar3.BTU.readString();
                    AppMethodBeat.o(56725);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzp bzp = new bzp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzp.populateBuilderWithField(aVar4, bzp, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        lvVar.vPB = bzp;
                    }
                    AppMethodBeat.o(56725);
                    return 0;
                case 7:
                    lvVar.vFb = aVar3.BTU.readString();
                    AppMethodBeat.o(56725);
                    return 0;
                case 8:
                    lvVar.vFd = aVar3.BTU.readString();
                    AppMethodBeat.o(56725);
                    return 0;
                case 9:
                    lvVar.vPC = aVar3.BTU.readString();
                    AppMethodBeat.o(56725);
                    return 0;
                case 10:
                    lvVar.vPD = aVar3.BTU.readString();
                    AppMethodBeat.o(56725);
                    return 0;
                case 11:
                    lvVar.vPE = aVar3.BTU.vd();
                    AppMethodBeat.o(56725);
                    return 0;
                case 12:
                    lvVar.vFc = aVar3.BTU.readString();
                    AppMethodBeat.o(56725);
                    return 0;
                case 13:
                    lvVar.vPo = aVar3.BTU.readString();
                    AppMethodBeat.o(56725);
                    return 0;
                case 14:
                    lvVar.vPF = aVar3.BTU.vd();
                    AppMethodBeat.o(56725);
                    return 0;
                case 15:
                    lvVar.vPG = aVar3.BTU.vd();
                    AppMethodBeat.o(56725);
                    return 0;
                case 16:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        chl chl = new chl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = chl.populateBuilderWithField(aVar4, chl, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        lvVar.vPH = chl;
                    }
                    AppMethodBeat.o(56725);
                    return 0;
                case 17:
                    lvVar.vPI = aVar3.BTU.readString();
                    AppMethodBeat.o(56725);
                    return 0;
                case 18:
                    lvVar.vPJ = aVar3.BTU.vd();
                    AppMethodBeat.o(56725);
                    return 0;
                case 19:
                    lvVar.vPK = aVar3.BTU.vd();
                    AppMethodBeat.o(56725);
                    return 0;
                case 20:
                    lvVar.vPL = aVar3.BTU.vd();
                    AppMethodBeat.o(56725);
                    return 0;
                case 21:
                    lvVar.vPM = aVar3.BTU.emu();
                    AppMethodBeat.o(56725);
                    return 0;
                case 22:
                    lvVar.vPN = aVar3.BTU.vd();
                    AppMethodBeat.o(56725);
                    return 0;
                case 23:
                    lvVar.pPG = aVar3.BTU.vd();
                    AppMethodBeat.o(56725);
                    return 0;
                case 24:
                    lvVar.pPH = aVar3.BTU.readString();
                    AppMethodBeat.o(56725);
                    return 0;
                case 25:
                    lvVar.pPI = aVar3.BTU.readString();
                    AppMethodBeat.o(56725);
                    return 0;
                case 26:
                    lvVar.vPO = aVar3.BTU.vd();
                    AppMethodBeat.o(56725);
                    return 0;
                case 27:
                    lvVar.pPJ = aVar3.BTU.readString();
                    AppMethodBeat.o(56725);
                    return 0;
                case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    lvVar.pPK = aVar3.BTU.readString();
                    AppMethodBeat.o(56725);
                    return 0;
                case 29:
                    lvVar.vPP = aVar3.BTU.vd();
                    AppMethodBeat.o(56725);
                    return 0;
                default:
                    AppMethodBeat.o(56725);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56725);
            return -1;
        }
    }
}
