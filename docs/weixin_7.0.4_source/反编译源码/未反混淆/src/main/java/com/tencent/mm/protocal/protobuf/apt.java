package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class apt extends btd {
    public String fha;
    public boolean lvU;
    public LinkedList<ach> vEx = new LinkedList();
    public LinkedList<String> wtG = new LinkedList();
    public String wtH;
    public String wtI;
    public boolean wtK;
    public LinkedList<cyi> wtN = new LinkedList();
    public LinkedList<cyj> wtO = new LinkedList();
    public String wtP;
    public String wtQ;
    public String wtR;
    public String wtS;
    public boolean wtT;
    public int wtU;
    public String wtV;

    public apt() {
        AppMethodBeat.i(28482);
        AppMethodBeat.o(28482);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28483);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28483);
                throw bVar;
            } else if (this.wtP == null) {
                bVar = new b("Not all required fields were included: championcoverurl");
                AppMethodBeat.o(28483);
                throw bVar;
            } else if (this.wtQ == null) {
                bVar = new b("Not all required fields were included: championmotto");
                AppMethodBeat.o(28483);
                throw bVar;
            } else if (this.fha == null) {
                bVar = new b("Not all required fields were included: rankid");
                AppMethodBeat.o(28483);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                aVar.e(2, 8, this.wtN);
                aVar.e(3, 8, this.wtO);
                aVar.e(4, 1, this.wtG);
                if (this.wtP != null) {
                    aVar.e(5, this.wtP);
                }
                if (this.wtQ != null) {
                    aVar.e(6, this.wtQ);
                }
                if (this.fha != null) {
                    aVar.e(7, this.fha);
                }
                if (this.wtR != null) {
                    aVar.e(8, this.wtR);
                }
                if (this.wtH != null) {
                    aVar.e(9, this.wtH);
                }
                aVar.aO(10, this.lvU);
                if (this.wtI != null) {
                    aVar.e(11, this.wtI);
                }
                aVar.e(12, 8, this.vEx);
                aVar.aO(13, this.wtK);
                if (this.wtS != null) {
                    aVar.e(14, this.wtS);
                }
                aVar.aO(15, this.wtT);
                aVar.iz(16, this.wtU);
                if (this.wtV != null) {
                    aVar.e(17, this.wtV);
                }
                AppMethodBeat.o(28483);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((ix + e.a.a.a.c(2, 8, this.wtN)) + e.a.a.a.c(3, 8, this.wtO)) + e.a.a.a.c(4, 1, this.wtG);
            if (this.wtP != null) {
                ix += e.a.a.b.b.a.f(5, this.wtP);
            }
            if (this.wtQ != null) {
                ix += e.a.a.b.b.a.f(6, this.wtQ);
            }
            if (this.fha != null) {
                ix += e.a.a.b.b.a.f(7, this.fha);
            }
            if (this.wtR != null) {
                ix += e.a.a.b.b.a.f(8, this.wtR);
            }
            if (this.wtH != null) {
                ix += e.a.a.b.b.a.f(9, this.wtH);
            }
            ix += e.a.a.b.b.a.fv(10) + 1;
            if (this.wtI != null) {
                ix += e.a.a.b.b.a.f(11, this.wtI);
            }
            ix = (ix + e.a.a.a.c(12, 8, this.vEx)) + (e.a.a.b.b.a.fv(13) + 1);
            if (this.wtS != null) {
                ix += e.a.a.b.b.a.f(14, this.wtS);
            }
            ix = (ix + (e.a.a.b.b.a.fv(15) + 1)) + e.a.a.b.b.a.bs(16, this.wtU);
            if (this.wtV != null) {
                ix += e.a.a.b.b.a.f(17, this.wtV);
            }
            AppMethodBeat.o(28483);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wtN.clear();
            this.wtO.clear();
            this.wtG.clear();
            this.vEx.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28483);
                throw bVar;
            } else if (this.wtP == null) {
                bVar = new b("Not all required fields were included: championcoverurl");
                AppMethodBeat.o(28483);
                throw bVar;
            } else if (this.wtQ == null) {
                bVar = new b("Not all required fields were included: championmotto");
                AppMethodBeat.o(28483);
                throw bVar;
            } else if (this.fha == null) {
                bVar = new b("Not all required fields were included: rankid");
                AppMethodBeat.o(28483);
                throw bVar;
            } else {
                AppMethodBeat.o(28483);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            apt apt = (apt) objArr[1];
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
                        apt.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(28483);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cyi cyi = new cyi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cyi.populateBuilderWithField(aVar4, cyi, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        apt.wtN.add(cyi);
                    }
                    AppMethodBeat.o(28483);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cyj cyj = new cyj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cyj.populateBuilderWithField(aVar4, cyj, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        apt.wtO.add(cyj);
                    }
                    AppMethodBeat.o(28483);
                    return 0;
                case 4:
                    apt.wtG.add(aVar3.BTU.readString());
                    AppMethodBeat.o(28483);
                    return 0;
                case 5:
                    apt.wtP = aVar3.BTU.readString();
                    AppMethodBeat.o(28483);
                    return 0;
                case 6:
                    apt.wtQ = aVar3.BTU.readString();
                    AppMethodBeat.o(28483);
                    return 0;
                case 7:
                    apt.fha = aVar3.BTU.readString();
                    AppMethodBeat.o(28483);
                    return 0;
                case 8:
                    apt.wtR = aVar3.BTU.readString();
                    AppMethodBeat.o(28483);
                    return 0;
                case 9:
                    apt.wtH = aVar3.BTU.readString();
                    AppMethodBeat.o(28483);
                    return 0;
                case 10:
                    apt.lvU = aVar3.BTU.ehX();
                    AppMethodBeat.o(28483);
                    return 0;
                case 11:
                    apt.wtI = aVar3.BTU.readString();
                    AppMethodBeat.o(28483);
                    return 0;
                case 12:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ach ach = new ach();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ach.populateBuilderWithField(aVar4, ach, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        apt.vEx.add(ach);
                    }
                    AppMethodBeat.o(28483);
                    return 0;
                case 13:
                    apt.wtK = aVar3.BTU.ehX();
                    AppMethodBeat.o(28483);
                    return 0;
                case 14:
                    apt.wtS = aVar3.BTU.readString();
                    AppMethodBeat.o(28483);
                    return 0;
                case 15:
                    apt.wtT = aVar3.BTU.ehX();
                    AppMethodBeat.o(28483);
                    return 0;
                case 16:
                    apt.wtU = aVar3.BTU.vd();
                    AppMethodBeat.o(28483);
                    return 0;
                case 17:
                    apt.wtV = aVar3.BTU.readString();
                    AppMethodBeat.o(28483);
                    return 0;
                default:
                    AppMethodBeat.o(28483);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28483);
            return -1;
        }
    }
}
