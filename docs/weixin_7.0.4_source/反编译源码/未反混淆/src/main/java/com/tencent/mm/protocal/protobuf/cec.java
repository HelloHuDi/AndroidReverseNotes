package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cec extends btd {
    public int vAR;
    public int vQe;
    public LinkedList<cer> xdL = new LinkedList();
    public long xdM;
    public int xds;

    public cec() {
        AppMethodBeat.i(56510);
        AppMethodBeat.o(56510);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56511);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56511);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.xds);
            aVar.e(3, 8, this.xdL);
            aVar.ai(4, this.xdM);
            aVar.iz(5, this.vQe);
            aVar.iz(6, this.vAR);
            AppMethodBeat.o(56511);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = ((((ix + e.a.a.b.b.a.bs(2, this.xds)) + e.a.a.a.c(3, 8, this.xdL)) + e.a.a.b.b.a.o(4, this.xdM)) + e.a.a.b.b.a.bs(5, this.vQe)) + e.a.a.b.b.a.bs(6, this.vAR);
            AppMethodBeat.o(56511);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xdL.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56511);
                throw bVar;
            }
            AppMethodBeat.o(56511);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cec cec = (cec) objArr[1];
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
                        cec.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56511);
                    return 0;
                case 2:
                    cec.xds = aVar3.BTU.vd();
                    AppMethodBeat.o(56511);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cer cer = new cer();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cer.populateBuilderWithField(aVar4, cer, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cec.xdL.add(cer);
                    }
                    AppMethodBeat.o(56511);
                    return 0;
                case 4:
                    cec.xdM = aVar3.BTU.ve();
                    AppMethodBeat.o(56511);
                    return 0;
                case 5:
                    cec.vQe = aVar3.BTU.vd();
                    AppMethodBeat.o(56511);
                    return 0;
                case 6:
                    cec.vAR = aVar3.BTU.vd();
                    AppMethodBeat.o(56511);
                    return 0;
                default:
                    AppMethodBeat.o(56511);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56511);
            return -1;
        }
    }
}
