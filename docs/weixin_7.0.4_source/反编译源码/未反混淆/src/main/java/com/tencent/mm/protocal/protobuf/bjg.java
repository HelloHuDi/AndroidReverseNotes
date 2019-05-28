package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bjg extends btd {
    public int cyE;
    public String cyF;
    public int okT;
    public String tCM;
    public csl wMA;
    public boolean wMB;
    public LinkedList<String> wMC = new LinkedList();
    public csi wMD;
    public csn wMx;
    public csk wMy;
    public csg wMz;

    public bjg() {
        AppMethodBeat.i(56893);
        AppMethodBeat.o(56893);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56894);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56894);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.cyE);
            if (this.cyF != null) {
                aVar.e(3, this.cyF);
            }
            if (this.wMx != null) {
                aVar.iy(4, this.wMx.computeSize());
                this.wMx.writeFields(aVar);
            }
            if (this.wMy != null) {
                aVar.iy(5, this.wMy.computeSize());
                this.wMy.writeFields(aVar);
            }
            if (this.wMz != null) {
                aVar.iy(6, this.wMz.computeSize());
                this.wMz.writeFields(aVar);
            }
            if (this.wMA != null) {
                aVar.iy(7, this.wMA.computeSize());
                this.wMA.writeFields(aVar);
            }
            aVar.iz(8, this.okT);
            aVar.aO(9, this.wMB);
            if (this.tCM != null) {
                aVar.e(10, this.tCM);
            }
            aVar.e(11, 1, this.wMC);
            if (this.wMD != null) {
                aVar.iy(12, this.wMD.computeSize());
                this.wMD.writeFields(aVar);
            }
            AppMethodBeat.o(56894);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.cyE);
            if (this.cyF != null) {
                ix += e.a.a.b.b.a.f(3, this.cyF);
            }
            if (this.wMx != null) {
                ix += e.a.a.a.ix(4, this.wMx.computeSize());
            }
            if (this.wMy != null) {
                ix += e.a.a.a.ix(5, this.wMy.computeSize());
            }
            if (this.wMz != null) {
                ix += e.a.a.a.ix(6, this.wMz.computeSize());
            }
            if (this.wMA != null) {
                ix += e.a.a.a.ix(7, this.wMA.computeSize());
            }
            ix = (ix + e.a.a.b.b.a.bs(8, this.okT)) + (e.a.a.b.b.a.fv(9) + 1);
            if (this.tCM != null) {
                ix += e.a.a.b.b.a.f(10, this.tCM);
            }
            ix += e.a.a.a.c(11, 1, this.wMC);
            if (this.wMD != null) {
                ix += e.a.a.a.ix(12, this.wMD.computeSize());
            }
            AppMethodBeat.o(56894);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wMC.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56894);
                throw bVar;
            }
            AppMethodBeat.o(56894);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bjg bjg = (bjg) objArr[1];
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
                        bjg.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56894);
                    return 0;
                case 2:
                    bjg.cyE = aVar3.BTU.vd();
                    AppMethodBeat.o(56894);
                    return 0;
                case 3:
                    bjg.cyF = aVar3.BTU.readString();
                    AppMethodBeat.o(56894);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        csn csn = new csn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = csn.populateBuilderWithField(aVar4, csn, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bjg.wMx = csn;
                    }
                    AppMethodBeat.o(56894);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        csk csk = new csk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = csk.populateBuilderWithField(aVar4, csk, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bjg.wMy = csk;
                    }
                    AppMethodBeat.o(56894);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        csg csg = new csg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = csg.populateBuilderWithField(aVar4, csg, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bjg.wMz = csg;
                    }
                    AppMethodBeat.o(56894);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        csl csl = new csl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = csl.populateBuilderWithField(aVar4, csl, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bjg.wMA = csl;
                    }
                    AppMethodBeat.o(56894);
                    return 0;
                case 8:
                    bjg.okT = aVar3.BTU.vd();
                    AppMethodBeat.o(56894);
                    return 0;
                case 9:
                    bjg.wMB = aVar3.BTU.ehX();
                    AppMethodBeat.o(56894);
                    return 0;
                case 10:
                    bjg.tCM = aVar3.BTU.readString();
                    AppMethodBeat.o(56894);
                    return 0;
                case 11:
                    bjg.wMC.add(aVar3.BTU.readString());
                    AppMethodBeat.o(56894);
                    return 0;
                case 12:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        csi csi = new csi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = csi.populateBuilderWithField(aVar4, csi, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bjg.wMD = csi;
                    }
                    AppMethodBeat.o(56894);
                    return 0;
                default:
                    AppMethodBeat.o(56894);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56894);
            return -1;
        }
    }
}
