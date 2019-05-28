package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cpc extends btd {
    public long wen;
    public long xeF;
    public int xmD;
    public int xmE;
    public int xmF;
    public int xmG;
    public b xmH;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(135459);
        e.a.a.b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(135459);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.ai(2, this.xeF);
            aVar.ai(3, this.wen);
            aVar.iz(4, this.xmD);
            aVar.iz(5, this.xmE);
            aVar.iz(6, this.xmF);
            aVar.iz(7, this.xmG);
            if (this.xmH != null) {
                aVar.c(8, this.xmH);
            }
            AppMethodBeat.o(135459);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (((((ix + e.a.a.b.b.a.o(2, this.xeF)) + e.a.a.b.b.a.o(3, this.wen)) + e.a.a.b.b.a.bs(4, this.xmD)) + e.a.a.b.b.a.bs(5, this.xmE)) + e.a.a.b.b.a.bs(6, this.xmF)) + e.a.a.b.b.a.bs(7, this.xmG);
            if (this.xmH != null) {
                ix += e.a.a.b.b.a.b(8, this.xmH);
            }
            AppMethodBeat.o(135459);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(135459);
                throw bVar;
            }
            AppMethodBeat.o(135459);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cpc cpc = (cpc) objArr[1];
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
                        cpc.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(135459);
                    return 0;
                case 2:
                    cpc.xeF = aVar3.BTU.ve();
                    AppMethodBeat.o(135459);
                    return 0;
                case 3:
                    cpc.wen = aVar3.BTU.ve();
                    AppMethodBeat.o(135459);
                    return 0;
                case 4:
                    cpc.xmD = aVar3.BTU.vd();
                    AppMethodBeat.o(135459);
                    return 0;
                case 5:
                    cpc.xmE = aVar3.BTU.vd();
                    AppMethodBeat.o(135459);
                    return 0;
                case 6:
                    cpc.xmF = aVar3.BTU.vd();
                    AppMethodBeat.o(135459);
                    return 0;
                case 7:
                    cpc.xmG = aVar3.BTU.vd();
                    AppMethodBeat.o(135459);
                    return 0;
                case 8:
                    cpc.xmH = aVar3.BTU.emu();
                    AppMethodBeat.o(135459);
                    return 0;
                default:
                    AppMethodBeat.o(135459);
                    return -1;
            }
        } else {
            AppMethodBeat.o(135459);
            return -1;
        }
    }
}
