package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.a.c;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class lx extends btd {
    public int kdT;
    public String kdU;
    public c tBw;
    public long tBy;
    public long vPQ;
    public LinkedList<String> vPR = new LinkedList();
    public int vPS;
    public int vPT;
    public String vPU;

    public lx() {
        AppMethodBeat.i(56727);
        AppMethodBeat.o(56727);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56728);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56728);
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
            aVar.ai(4, this.tBy);
            if (this.tBw != null) {
                aVar.iy(5, this.tBw.computeSize());
                this.tBw.writeFields(aVar);
            }
            aVar.ai(6, this.vPQ);
            aVar.e(7, 1, this.vPR);
            aVar.iz(8, this.vPS);
            aVar.iz(9, this.vPT);
            if (this.vPU != null) {
                aVar.e(10, this.vPU);
            }
            AppMethodBeat.o(56728);
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
            ix += e.a.a.b.b.a.o(4, this.tBy);
            if (this.tBw != null) {
                ix += e.a.a.a.ix(5, this.tBw.computeSize());
            }
            ix = (((ix + e.a.a.b.b.a.o(6, this.vPQ)) + e.a.a.a.c(7, 1, this.vPR)) + e.a.a.b.b.a.bs(8, this.vPS)) + e.a.a.b.b.a.bs(9, this.vPT);
            if (this.vPU != null) {
                ix += e.a.a.b.b.a.f(10, this.vPU);
            }
            AppMethodBeat.o(56728);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vPR.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56728);
                throw bVar;
            }
            AppMethodBeat.o(56728);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            lx lxVar = (lx) objArr[1];
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
                        lxVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56728);
                    return 0;
                case 2:
                    lxVar.kdT = aVar3.BTU.vd();
                    AppMethodBeat.o(56728);
                    return 0;
                case 3:
                    lxVar.kdU = aVar3.BTU.readString();
                    AppMethodBeat.o(56728);
                    return 0;
                case 4:
                    lxVar.tBy = aVar3.BTU.ve();
                    AppMethodBeat.o(56728);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c cVar = new c();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cVar.populateBuilderWithField(aVar4, cVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        lxVar.tBw = cVar;
                    }
                    AppMethodBeat.o(56728);
                    return 0;
                case 6:
                    lxVar.vPQ = aVar3.BTU.ve();
                    AppMethodBeat.o(56728);
                    return 0;
                case 7:
                    lxVar.vPR.add(aVar3.BTU.readString());
                    AppMethodBeat.o(56728);
                    return 0;
                case 8:
                    lxVar.vPS = aVar3.BTU.vd();
                    AppMethodBeat.o(56728);
                    return 0;
                case 9:
                    lxVar.vPT = aVar3.BTU.vd();
                    AppMethodBeat.o(56728);
                    return 0;
                case 10:
                    lxVar.vPU = aVar3.BTU.readString();
                    AppMethodBeat.o(56728);
                    return 0;
                default:
                    AppMethodBeat.o(56728);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56728);
            return -1;
        }
    }
}
