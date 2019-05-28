package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class blj extends btd {
    public int vKp;
    public String vKq;
    public String vRN;
    public LinkedList<ze> wOp = new LinkedList();
    public LinkedList<au> wOq = new LinkedList();
    public int wOr;
    public int wpD;

    public blj() {
        AppMethodBeat.i(56929);
        AppMethodBeat.o(56929);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56930);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.wpD);
            aVar.e(3, 8, this.wOp);
            if (this.vRN != null) {
                aVar.e(4, this.vRN);
            }
            aVar.iz(5, this.vKp);
            if (this.vKq != null) {
                aVar.e(6, this.vKq);
            }
            aVar.e(7, 8, this.wOq);
            aVar.iz(8, this.wOr);
            AppMethodBeat.o(56930);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.wpD)) + e.a.a.a.c(3, 8, this.wOp);
            if (this.vRN != null) {
                ix += e.a.a.b.b.a.f(4, this.vRN);
            }
            ix += e.a.a.b.b.a.bs(5, this.vKp);
            if (this.vKq != null) {
                ix += e.a.a.b.b.a.f(6, this.vKq);
            }
            int c = (ix + e.a.a.a.c(7, 8, this.wOq)) + e.a.a.b.b.a.bs(8, this.wOr);
            AppMethodBeat.o(56930);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wOp.clear();
            this.wOq.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56930);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            blj blj = (blj) objArr[1];
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
                        blj.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56930);
                    return 0;
                case 2:
                    blj.wpD = aVar3.BTU.vd();
                    AppMethodBeat.o(56930);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ze zeVar = new ze();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = zeVar.populateBuilderWithField(aVar4, zeVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        blj.wOp.add(zeVar);
                    }
                    AppMethodBeat.o(56930);
                    return 0;
                case 4:
                    blj.vRN = aVar3.BTU.readString();
                    AppMethodBeat.o(56930);
                    return 0;
                case 5:
                    blj.vKp = aVar3.BTU.vd();
                    AppMethodBeat.o(56930);
                    return 0;
                case 6:
                    blj.vKq = aVar3.BTU.readString();
                    AppMethodBeat.o(56930);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        au auVar = new au();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = auVar.populateBuilderWithField(aVar4, auVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        blj.wOq.add(auVar);
                    }
                    AppMethodBeat.o(56930);
                    return 0;
                case 8:
                    blj.wOr = aVar3.BTU.vd();
                    AppMethodBeat.o(56930);
                    return 0;
                default:
                    AppMethodBeat.o(56930);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56930);
            return -1;
        }
    }
}
