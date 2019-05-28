package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aiq extends btd {
    public LinkedList<dq> vHk = new LinkedList();
    public int woD;
    public int woE;
    public LinkedList<Integer> woF = new LinkedList();
    public LinkedList<zf> woG = new LinkedList();
    public int woH;

    public aiq() {
        AppMethodBeat.i(73653);
        AppMethodBeat.o(73653);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73654);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(73654);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.woD);
            aVar.iz(3, this.woE);
            aVar.e(4, 2, this.woF);
            aVar.e(5, 8, this.woG);
            aVar.iz(6, this.woH);
            aVar.e(7, 8, this.vHk);
            AppMethodBeat.o(73654);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = (((((ix + e.a.a.b.b.a.bs(2, this.woD)) + e.a.a.b.b.a.bs(3, this.woE)) + e.a.a.a.c(4, 2, this.woF)) + e.a.a.a.c(5, 8, this.woG)) + e.a.a.b.b.a.bs(6, this.woH)) + e.a.a.a.c(7, 8, this.vHk);
            AppMethodBeat.o(73654);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.woF.clear();
            this.woG.clear();
            this.vHk.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(73654);
                throw bVar;
            }
            AppMethodBeat.o(73654);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aiq aiq = (aiq) objArr[1];
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
                        aiq.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(73654);
                    return 0;
                case 2:
                    aiq.woD = aVar3.BTU.vd();
                    AppMethodBeat.o(73654);
                    return 0;
                case 3:
                    aiq.woE = aVar3.BTU.vd();
                    AppMethodBeat.o(73654);
                    return 0;
                case 4:
                    aiq.woF.add(Integer.valueOf(aVar3.BTU.vd()));
                    AppMethodBeat.o(73654);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        zf zfVar = new zf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = zfVar.populateBuilderWithField(aVar4, zfVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aiq.woG.add(zfVar);
                    }
                    AppMethodBeat.o(73654);
                    return 0;
                case 6:
                    aiq.woH = aVar3.BTU.vd();
                    AppMethodBeat.o(73654);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        dq dqVar = new dq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dqVar.populateBuilderWithField(aVar4, dqVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aiq.vHk.add(dqVar);
                    }
                    AppMethodBeat.o(73654);
                    return 0;
                default:
                    AppMethodBeat.o(73654);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73654);
            return -1;
        }
    }
}
