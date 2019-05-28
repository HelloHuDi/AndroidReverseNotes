package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ee extends btd {
    public int enabled;
    public int kKI;
    public LinkedList<kl> vFR = new LinkedList();
    public boolean vFS;
    public int vFT;

    public ee() {
        AppMethodBeat.i(14687);
        AppMethodBeat.o(14687);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14688);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(14688);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.vFR);
            aVar.aO(3, this.vFS);
            aVar.iz(4, this.vFT);
            aVar.iz(5, this.enabled);
            aVar.iz(6, this.kKI);
            AppMethodBeat.o(14688);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int c = ((((ix + e.a.a.a.c(2, 8, this.vFR)) + (e.a.a.b.b.a.fv(3) + 1)) + e.a.a.b.b.a.bs(4, this.vFT)) + e.a.a.b.b.a.bs(5, this.enabled)) + e.a.a.b.b.a.bs(6, this.kKI);
            AppMethodBeat.o(14688);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vFR.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(14688);
                throw bVar;
            }
            AppMethodBeat.o(14688);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ee eeVar = (ee) objArr[1];
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
                        eeVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(14688);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        kl klVar = new kl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = klVar.populateBuilderWithField(aVar4, klVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        eeVar.vFR.add(klVar);
                    }
                    AppMethodBeat.o(14688);
                    return 0;
                case 3:
                    eeVar.vFS = aVar3.BTU.ehX();
                    AppMethodBeat.o(14688);
                    return 0;
                case 4:
                    eeVar.vFT = aVar3.BTU.vd();
                    AppMethodBeat.o(14688);
                    return 0;
                case 5:
                    eeVar.enabled = aVar3.BTU.vd();
                    AppMethodBeat.o(14688);
                    return 0;
                case 6:
                    eeVar.kKI = aVar3.BTU.vd();
                    AppMethodBeat.o(14688);
                    return 0;
                default:
                    AppMethodBeat.o(14688);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14688);
            return -1;
        }
    }
}
