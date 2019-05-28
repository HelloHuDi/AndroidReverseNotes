package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bvo extends a {
    public int guN;
    public String guO;
    public String guP;
    public String guQ;
    public int guR;
    public String guS;
    public String guW;
    public String vXm;
    public String vXn;
    public int wBT;
    public String wBU;
    public String wBV;
    public String wBW;
    public int wBX;
    public uz wWC;
    public bts wcB;
    public bts wyX;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124359);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wcB == null) {
                bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(124359);
                throw bVar;
            } else if (this.wyX == null) {
                bVar = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(124359);
                throw bVar;
            } else {
                if (this.wcB != null) {
                    aVar.iy(1, this.wcB.computeSize());
                    this.wcB.writeFields(aVar);
                }
                if (this.wyX != null) {
                    aVar.iy(2, this.wyX.computeSize());
                    this.wyX.writeFields(aVar);
                }
                aVar.iz(3, this.guN);
                if (this.guO != null) {
                    aVar.e(4, this.guO);
                }
                if (this.guP != null) {
                    aVar.e(5, this.guP);
                }
                if (this.guQ != null) {
                    aVar.e(6, this.guQ);
                }
                aVar.iz(7, this.guR);
                aVar.iz(8, this.wBT);
                if (this.wBU != null) {
                    aVar.e(9, this.wBU);
                }
                if (this.wBV != null) {
                    aVar.e(10, this.wBV);
                }
                if (this.guS != null) {
                    aVar.e(11, this.guS);
                }
                if (this.wBW != null) {
                    aVar.e(12, this.wBW);
                }
                aVar.iz(13, this.wBX);
                if (this.guW != null) {
                    aVar.e(14, this.guW);
                }
                if (this.wWC != null) {
                    aVar.iy(15, this.wWC.computeSize());
                    this.wWC.writeFields(aVar);
                }
                if (this.vXm != null) {
                    aVar.e(16, this.vXm);
                }
                if (this.vXn != null) {
                    aVar.e(17, this.vXn);
                }
                AppMethodBeat.o(124359);
                return 0;
            }
        } else if (i == 1) {
            if (this.wcB != null) {
                ix = e.a.a.a.ix(1, this.wcB.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wyX != null) {
                ix += e.a.a.a.ix(2, this.wyX.computeSize());
            }
            ix += e.a.a.b.b.a.bs(3, this.guN);
            if (this.guO != null) {
                ix += e.a.a.b.b.a.f(4, this.guO);
            }
            if (this.guP != null) {
                ix += e.a.a.b.b.a.f(5, this.guP);
            }
            if (this.guQ != null) {
                ix += e.a.a.b.b.a.f(6, this.guQ);
            }
            ix = (ix + e.a.a.b.b.a.bs(7, this.guR)) + e.a.a.b.b.a.bs(8, this.wBT);
            if (this.wBU != null) {
                ix += e.a.a.b.b.a.f(9, this.wBU);
            }
            if (this.wBV != null) {
                ix += e.a.a.b.b.a.f(10, this.wBV);
            }
            if (this.guS != null) {
                ix += e.a.a.b.b.a.f(11, this.guS);
            }
            if (this.wBW != null) {
                ix += e.a.a.b.b.a.f(12, this.wBW);
            }
            ix += e.a.a.b.b.a.bs(13, this.wBX);
            if (this.guW != null) {
                ix += e.a.a.b.b.a.f(14, this.guW);
            }
            if (this.wWC != null) {
                ix += e.a.a.a.ix(15, this.wWC.computeSize());
            }
            if (this.vXm != null) {
                ix += e.a.a.b.b.a.f(16, this.vXm);
            }
            if (this.vXn != null) {
                ix += e.a.a.b.b.a.f(17, this.vXn);
            }
            AppMethodBeat.o(124359);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wcB == null) {
                bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(124359);
                throw bVar;
            } else if (this.wyX == null) {
                bVar = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(124359);
                throw bVar;
            } else {
                AppMethodBeat.o(124359);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bvo bvo = (bvo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            bts bts;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        bvo.wcB = bts;
                    }
                    AppMethodBeat.o(124359);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        bvo.wyX = bts;
                    }
                    AppMethodBeat.o(124359);
                    return 0;
                case 3:
                    bvo.guN = aVar3.BTU.vd();
                    AppMethodBeat.o(124359);
                    return 0;
                case 4:
                    bvo.guO = aVar3.BTU.readString();
                    AppMethodBeat.o(124359);
                    return 0;
                case 5:
                    bvo.guP = aVar3.BTU.readString();
                    AppMethodBeat.o(124359);
                    return 0;
                case 6:
                    bvo.guQ = aVar3.BTU.readString();
                    AppMethodBeat.o(124359);
                    return 0;
                case 7:
                    bvo.guR = aVar3.BTU.vd();
                    AppMethodBeat.o(124359);
                    return 0;
                case 8:
                    bvo.wBT = aVar3.BTU.vd();
                    AppMethodBeat.o(124359);
                    return 0;
                case 9:
                    bvo.wBU = aVar3.BTU.readString();
                    AppMethodBeat.o(124359);
                    return 0;
                case 10:
                    bvo.wBV = aVar3.BTU.readString();
                    AppMethodBeat.o(124359);
                    return 0;
                case 11:
                    bvo.guS = aVar3.BTU.readString();
                    AppMethodBeat.o(124359);
                    return 0;
                case 12:
                    bvo.wBW = aVar3.BTU.readString();
                    AppMethodBeat.o(124359);
                    return 0;
                case 13:
                    bvo.wBX = aVar3.BTU.vd();
                    AppMethodBeat.o(124359);
                    return 0;
                case 14:
                    bvo.guW = aVar3.BTU.readString();
                    AppMethodBeat.o(124359);
                    return 0;
                case 15:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        uz uzVar = new uz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = uzVar.populateBuilderWithField(aVar4, uzVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bvo.wWC = uzVar;
                    }
                    AppMethodBeat.o(124359);
                    return 0;
                case 16:
                    bvo.vXm = aVar3.BTU.readString();
                    AppMethodBeat.o(124359);
                    return 0;
                case 17:
                    bvo.vXn = aVar3.BTU.readString();
                    AppMethodBeat.o(124359);
                    return 0;
                default:
                    AppMethodBeat.o(124359);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124359);
            return -1;
        }
    }
}
