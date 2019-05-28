package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cfe extends btd {
    public int vAR;
    public String wZT;
    public int xbC;
    public long xdM;
    public int xeG;
    public LinkedList<cer> xeH = new LinkedList();
    public int xeI;
    public int xeJ;

    public cfe() {
        AppMethodBeat.i(56549);
        AppMethodBeat.o(56549);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56550);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56550);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wZT != null) {
                aVar.e(2, this.wZT);
            }
            aVar.iz(3, this.xeG);
            aVar.e(4, 8, this.xeH);
            aVar.iz(5, this.xeI);
            aVar.iz(6, this.xeJ);
            aVar.iz(7, this.xbC);
            aVar.ai(8, this.xdM);
            aVar.iz(9, this.vAR);
            AppMethodBeat.o(56550);
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
            int bs = ((((((ix + e.a.a.b.b.a.bs(3, this.xeG)) + e.a.a.a.c(4, 8, this.xeH)) + e.a.a.b.b.a.bs(5, this.xeI)) + e.a.a.b.b.a.bs(6, this.xeJ)) + e.a.a.b.b.a.bs(7, this.xbC)) + e.a.a.b.b.a.o(8, this.xdM)) + e.a.a.b.b.a.bs(9, this.vAR);
            AppMethodBeat.o(56550);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xeH.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56550);
                throw bVar;
            }
            AppMethodBeat.o(56550);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cfe cfe = (cfe) objArr[1];
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
                        cfe.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56550);
                    return 0;
                case 2:
                    cfe.wZT = aVar3.BTU.readString();
                    AppMethodBeat.o(56550);
                    return 0;
                case 3:
                    cfe.xeG = aVar3.BTU.vd();
                    AppMethodBeat.o(56550);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cer cer = new cer();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cer.populateBuilderWithField(aVar4, cer, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cfe.xeH.add(cer);
                    }
                    AppMethodBeat.o(56550);
                    return 0;
                case 5:
                    cfe.xeI = aVar3.BTU.vd();
                    AppMethodBeat.o(56550);
                    return 0;
                case 6:
                    cfe.xeJ = aVar3.BTU.vd();
                    AppMethodBeat.o(56550);
                    return 0;
                case 7:
                    cfe.xbC = aVar3.BTU.vd();
                    AppMethodBeat.o(56550);
                    return 0;
                case 8:
                    cfe.xdM = aVar3.BTU.ve();
                    AppMethodBeat.o(56550);
                    return 0;
                case 9:
                    cfe.vAR = aVar3.BTU.vd();
                    AppMethodBeat.o(56550);
                    return 0;
                default:
                    AppMethodBeat.o(56550);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56550);
            return -1;
        }
    }
}
