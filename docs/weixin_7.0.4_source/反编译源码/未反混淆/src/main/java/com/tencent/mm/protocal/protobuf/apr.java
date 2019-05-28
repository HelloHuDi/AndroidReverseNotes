package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class apr extends btd {
    public int lCg;
    public boolean lvH;
    public String lvw;
    public String lvy;
    public String source;
    public LinkedList<ach> vEx = new LinkedList();
    public LinkedList<cdo> vFi = new LinkedList();
    public String wtC;
    public cyk wtD;
    public LinkedList<cym> wtE = new LinkedList();
    public LinkedList<cyl> wtF = new LinkedList();
    public LinkedList<String> wtG = new LinkedList();
    public String wtH;
    public String wtI;
    public LinkedList<mq> wtJ = new LinkedList();
    public boolean wtK;

    public apr() {
        AppMethodBeat.i(28479);
        AppMethodBeat.o(28479);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28480);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28480);
                throw bVar;
            } else if (this.wtC == null) {
                bVar = new b("Not all required fields were included: coverurl");
                AppMethodBeat.o(28480);
                throw bVar;
            } else if (this.lvy == null) {
                bVar = new b("Not all required fields were included: motto");
                AppMethodBeat.o(28480);
                throw bVar;
            } else if (this.wtD == null) {
                bVar = new b("Not all required fields were included: rankdesc");
                AppMethodBeat.o(28480);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.wtC != null) {
                    aVar.e(2, this.wtC);
                }
                if (this.lvy != null) {
                    aVar.e(3, this.lvy);
                }
                if (this.wtD != null) {
                    aVar.iy(4, this.wtD.computeSize());
                    this.wtD.writeFields(aVar);
                }
                aVar.e(5, 8, this.wtE);
                aVar.e(6, 8, this.wtF);
                if (this.source != null) {
                    aVar.e(7, this.source);
                }
                aVar.e(8, 1, this.wtG);
                if (this.wtH != null) {
                    aVar.e(9, this.wtH);
                }
                if (this.wtI != null) {
                    aVar.e(10, this.wtI);
                }
                aVar.e(14, 8, this.vFi);
                aVar.e(15, 8, this.vEx);
                aVar.aO(16, this.lvH);
                aVar.e(17, 8, this.wtJ);
                aVar.aO(18, this.wtK);
                aVar.iz(19, this.lCg);
                if (this.lvw != null) {
                    aVar.e(20, this.lvw);
                }
                AppMethodBeat.o(28480);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wtC != null) {
                ix += e.a.a.b.b.a.f(2, this.wtC);
            }
            if (this.lvy != null) {
                ix += e.a.a.b.b.a.f(3, this.lvy);
            }
            if (this.wtD != null) {
                ix += e.a.a.a.ix(4, this.wtD.computeSize());
            }
            ix = (ix + e.a.a.a.c(5, 8, this.wtE)) + e.a.a.a.c(6, 8, this.wtF);
            if (this.source != null) {
                ix += e.a.a.b.b.a.f(7, this.source);
            }
            ix += e.a.a.a.c(8, 1, this.wtG);
            if (this.wtH != null) {
                ix += e.a.a.b.b.a.f(9, this.wtH);
            }
            if (this.wtI != null) {
                ix += e.a.a.b.b.a.f(10, this.wtI);
            }
            ix = (((((ix + e.a.a.a.c(14, 8, this.vFi)) + e.a.a.a.c(15, 8, this.vEx)) + (e.a.a.b.b.a.fv(16) + 1)) + e.a.a.a.c(17, 8, this.wtJ)) + (e.a.a.b.b.a.fv(18) + 1)) + e.a.a.b.b.a.bs(19, this.lCg);
            if (this.lvw != null) {
                ix += e.a.a.b.b.a.f(20, this.lvw);
            }
            AppMethodBeat.o(28480);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wtE.clear();
            this.wtF.clear();
            this.wtG.clear();
            this.vFi.clear();
            this.vEx.clear();
            this.wtJ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28480);
                throw bVar;
            } else if (this.wtC == null) {
                bVar = new b("Not all required fields were included: coverurl");
                AppMethodBeat.o(28480);
                throw bVar;
            } else if (this.lvy == null) {
                bVar = new b("Not all required fields were included: motto");
                AppMethodBeat.o(28480);
                throw bVar;
            } else if (this.wtD == null) {
                bVar = new b("Not all required fields were included: rankdesc");
                AppMethodBeat.o(28480);
                throw bVar;
            } else {
                AppMethodBeat.o(28480);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            apr apr = (apr) objArr[1];
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
                        apr.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(28480);
                    return 0;
                case 2:
                    apr.wtC = aVar3.BTU.readString();
                    AppMethodBeat.o(28480);
                    return 0;
                case 3:
                    apr.lvy = aVar3.BTU.readString();
                    AppMethodBeat.o(28480);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cyk cyk = new cyk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cyk.populateBuilderWithField(aVar4, cyk, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        apr.wtD = cyk;
                    }
                    AppMethodBeat.o(28480);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cym cym = new cym();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cym.populateBuilderWithField(aVar4, cym, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        apr.wtE.add(cym);
                    }
                    AppMethodBeat.o(28480);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cyl cyl = new cyl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cyl.populateBuilderWithField(aVar4, cyl, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        apr.wtF.add(cyl);
                    }
                    AppMethodBeat.o(28480);
                    return 0;
                case 7:
                    apr.source = aVar3.BTU.readString();
                    AppMethodBeat.o(28480);
                    return 0;
                case 8:
                    apr.wtG.add(aVar3.BTU.readString());
                    AppMethodBeat.o(28480);
                    return 0;
                case 9:
                    apr.wtH = aVar3.BTU.readString();
                    AppMethodBeat.o(28480);
                    return 0;
                case 10:
                    apr.wtI = aVar3.BTU.readString();
                    AppMethodBeat.o(28480);
                    return 0;
                case 14:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdo cdo = new cdo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdo.populateBuilderWithField(aVar4, cdo, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        apr.vFi.add(cdo);
                    }
                    AppMethodBeat.o(28480);
                    return 0;
                case 15:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ach ach = new ach();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ach.populateBuilderWithField(aVar4, ach, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        apr.vEx.add(ach);
                    }
                    AppMethodBeat.o(28480);
                    return 0;
                case 16:
                    apr.lvH = aVar3.BTU.ehX();
                    AppMethodBeat.o(28480);
                    return 0;
                case 17:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mq mqVar = new mq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mqVar.populateBuilderWithField(aVar4, mqVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        apr.wtJ.add(mqVar);
                    }
                    AppMethodBeat.o(28480);
                    return 0;
                case 18:
                    apr.wtK = aVar3.BTU.ehX();
                    AppMethodBeat.o(28480);
                    return 0;
                case 19:
                    apr.lCg = aVar3.BTU.vd();
                    AppMethodBeat.o(28480);
                    return 0;
                case 20:
                    apr.lvw = aVar3.BTU.readString();
                    AppMethodBeat.o(28480);
                    return 0;
                default:
                    AppMethodBeat.o(28480);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28480);
            return -1;
        }
    }
}
