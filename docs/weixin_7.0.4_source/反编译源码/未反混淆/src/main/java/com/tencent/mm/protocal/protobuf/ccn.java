package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ccn extends btd {
    public LinkedList<cbf> vKB = new LinkedList();
    public ccl wBZ;
    public int wGG;
    public String wZT;
    public int wZX;
    public cbw wZZ;
    public int xbC;
    public int xbS;
    public long xbT;
    public long xbU;
    public String xbV;

    public ccn() {
        AppMethodBeat.i(94624);
        AppMethodBeat.o(94624);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94625);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(94625);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wZT != null) {
                aVar.e(2, this.wZT);
            }
            aVar.iz(3, this.wGG);
            aVar.e(4, 8, this.vKB);
            aVar.iz(5, this.xbS);
            if (this.wBZ != null) {
                aVar.iy(6, this.wBZ.computeSize());
                this.wBZ.writeFields(aVar);
            }
            aVar.iz(7, this.xbC);
            aVar.iz(8, this.wZX);
            if (this.wZZ != null) {
                aVar.iy(9, this.wZZ.computeSize());
                this.wZZ.writeFields(aVar);
            }
            aVar.ai(10, this.xbT);
            aVar.ai(11, this.xbU);
            if (this.xbV != null) {
                aVar.e(12, this.xbV);
            }
            AppMethodBeat.o(94625);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wZT != null) {
                ix += e.a.a.b.b.a.f(2, this.wZT);
            }
            ix = ((ix + e.a.a.b.b.a.bs(3, this.wGG)) + e.a.a.a.c(4, 8, this.vKB)) + e.a.a.b.b.a.bs(5, this.xbS);
            if (this.wBZ != null) {
                ix += e.a.a.a.ix(6, this.wBZ.computeSize());
            }
            ix = (ix + e.a.a.b.b.a.bs(7, this.xbC)) + e.a.a.b.b.a.bs(8, this.wZX);
            if (this.wZZ != null) {
                ix += e.a.a.a.ix(9, this.wZZ.computeSize());
            }
            ix = (ix + e.a.a.b.b.a.o(10, this.xbT)) + e.a.a.b.b.a.o(11, this.xbU);
            if (this.xbV != null) {
                ix += e.a.a.b.b.a.f(12, this.xbV);
            }
            AppMethodBeat.o(94625);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vKB.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(94625);
                throw bVar;
            }
            AppMethodBeat.o(94625);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ccn ccn = (ccn) objArr[1];
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
                        ccn.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(94625);
                    return 0;
                case 2:
                    ccn.wZT = aVar3.BTU.readString();
                    AppMethodBeat.o(94625);
                    return 0;
                case 3:
                    ccn.wGG = aVar3.BTU.vd();
                    AppMethodBeat.o(94625);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbf cbf = new cbf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbf.populateBuilderWithField(aVar4, cbf, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ccn.vKB.add(cbf);
                    }
                    AppMethodBeat.o(94625);
                    return 0;
                case 5:
                    ccn.xbS = aVar3.BTU.vd();
                    AppMethodBeat.o(94625);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ccl ccl = new ccl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccl.populateBuilderWithField(aVar4, ccl, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ccn.wBZ = ccl;
                    }
                    AppMethodBeat.o(94625);
                    return 0;
                case 7:
                    ccn.xbC = aVar3.BTU.vd();
                    AppMethodBeat.o(94625);
                    return 0;
                case 8:
                    ccn.wZX = aVar3.BTU.vd();
                    AppMethodBeat.o(94625);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbw cbw = new cbw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbw.populateBuilderWithField(aVar4, cbw, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ccn.wZZ = cbw;
                    }
                    AppMethodBeat.o(94625);
                    return 0;
                case 10:
                    ccn.xbT = aVar3.BTU.ve();
                    AppMethodBeat.o(94625);
                    return 0;
                case 11:
                    ccn.xbU = aVar3.BTU.ve();
                    AppMethodBeat.o(94625);
                    return 0;
                case 12:
                    ccn.xbV = aVar3.BTU.readString();
                    AppMethodBeat.o(94625);
                    return 0;
                default:
                    AppMethodBeat.o(94625);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94625);
            return -1;
        }
    }
}
