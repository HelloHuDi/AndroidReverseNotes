package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class afg extends btd {
    public int luT;
    public String luU;
    public LinkedList<aua> wmG = new LinkedList();

    public afg() {
        AppMethodBeat.i(10170);
        AppMethodBeat.o(10170);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10171);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(10171);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.luT);
            if (this.luU != null) {
                aVar.e(3, this.luU);
            }
            aVar.e(4, 8, this.wmG);
            AppMethodBeat.o(10171);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.luT);
            if (this.luU != null) {
                ix += e.a.a.b.b.a.f(3, this.luU);
            }
            int c = ix + e.a.a.a.c(4, 8, this.wmG);
            AppMethodBeat.o(10171);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wmG.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(10171);
                throw bVar;
            }
            AppMethodBeat.o(10171);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            afg afg = (afg) objArr[1];
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
                        afg.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(10171);
                    return 0;
                case 2:
                    afg.luT = aVar3.BTU.vd();
                    AppMethodBeat.o(10171);
                    return 0;
                case 3:
                    afg.luU = aVar3.BTU.readString();
                    AppMethodBeat.o(10171);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aua aua = new aua();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aua.populateBuilderWithField(aVar4, aua, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        afg.wmG.add(aua);
                    }
                    AppMethodBeat.o(10171);
                    return 0;
                default:
                    AppMethodBeat.o(10171);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10171);
            return -1;
        }
    }
}
