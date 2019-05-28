package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bmk extends btd {
    public int luT;
    public String luU;
    public int nwA;
    public String nwB;
    public int nwP;
    public int wPn;
    public int wPp;
    public int wPq;
    public int wem;
    public long wen;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28594);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28594);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(3, this.wem);
            aVar.ai(4, this.wen);
            aVar.iz(5, this.wPp);
            aVar.iz(6, this.wPn);
            aVar.iz(7, this.nwP);
            aVar.iz(8, this.wPq);
            aVar.iz(9, this.luT);
            if (this.luU != null) {
                aVar.e(10, this.luU);
            }
            aVar.iz(11, this.nwA);
            if (this.nwB != null) {
                aVar.e(12, this.nwB);
            }
            AppMethodBeat.o(28594);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((((((ix + e.a.a.b.b.a.bs(3, this.wem)) + e.a.a.b.b.a.o(4, this.wen)) + e.a.a.b.b.a.bs(5, this.wPp)) + e.a.a.b.b.a.bs(6, this.wPn)) + e.a.a.b.b.a.bs(7, this.nwP)) + e.a.a.b.b.a.bs(8, this.wPq)) + e.a.a.b.b.a.bs(9, this.luT);
            if (this.luU != null) {
                ix += e.a.a.b.b.a.f(10, this.luU);
            }
            ix += e.a.a.b.b.a.bs(11, this.nwA);
            if (this.nwB != null) {
                ix += e.a.a.b.b.a.f(12, this.nwB);
            }
            AppMethodBeat.o(28594);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28594);
                throw bVar;
            }
            AppMethodBeat.o(28594);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bmk bmk = (bmk) objArr[1];
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
                        bmk.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(28594);
                    return 0;
                case 3:
                    bmk.wem = aVar3.BTU.vd();
                    AppMethodBeat.o(28594);
                    return 0;
                case 4:
                    bmk.wen = aVar3.BTU.ve();
                    AppMethodBeat.o(28594);
                    return 0;
                case 5:
                    bmk.wPp = aVar3.BTU.vd();
                    AppMethodBeat.o(28594);
                    return 0;
                case 6:
                    bmk.wPn = aVar3.BTU.vd();
                    AppMethodBeat.o(28594);
                    return 0;
                case 7:
                    bmk.nwP = aVar3.BTU.vd();
                    AppMethodBeat.o(28594);
                    return 0;
                case 8:
                    bmk.wPq = aVar3.BTU.vd();
                    AppMethodBeat.o(28594);
                    return 0;
                case 9:
                    bmk.luT = aVar3.BTU.vd();
                    AppMethodBeat.o(28594);
                    return 0;
                case 10:
                    bmk.luU = aVar3.BTU.readString();
                    AppMethodBeat.o(28594);
                    return 0;
                case 11:
                    bmk.nwA = aVar3.BTU.vd();
                    AppMethodBeat.o(28594);
                    return 0;
                case 12:
                    bmk.nwB = aVar3.BTU.readString();
                    AppMethodBeat.o(28594);
                    return 0;
                default:
                    AppMethodBeat.o(28594);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28594);
            return -1;
        }
    }
}
