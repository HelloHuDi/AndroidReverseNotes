package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class akc extends btd {
    public int vKp;
    public String vKq;
    public LinkedList<ze> wpC = new LinkedList();
    public int wpD;

    public akc() {
        AppMethodBeat.i(56812);
        AppMethodBeat.o(56812);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56813);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56813);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.wpC);
            aVar.iz(3, this.wpD);
            aVar.iz(4, this.vKp);
            if (this.vKq != null) {
                aVar.e(5, this.vKq);
            }
            AppMethodBeat.o(56813);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((ix + e.a.a.a.c(2, 8, this.wpC)) + e.a.a.b.b.a.bs(3, this.wpD)) + e.a.a.b.b.a.bs(4, this.vKp);
            if (this.vKq != null) {
                ix += e.a.a.b.b.a.f(5, this.vKq);
            }
            AppMethodBeat.o(56813);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wpC.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56813);
                throw bVar;
            }
            AppMethodBeat.o(56813);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            akc akc = (akc) objArr[1];
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
                        akc.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56813);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ze zeVar = new ze();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = zeVar.populateBuilderWithField(aVar4, zeVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        akc.wpC.add(zeVar);
                    }
                    AppMethodBeat.o(56813);
                    return 0;
                case 3:
                    akc.wpD = aVar3.BTU.vd();
                    AppMethodBeat.o(56813);
                    return 0;
                case 4:
                    akc.vKp = aVar3.BTU.vd();
                    AppMethodBeat.o(56813);
                    return 0;
                case 5:
                    akc.vKq = aVar3.BTU.readString();
                    AppMethodBeat.o(56813);
                    return 0;
                default:
                    AppMethodBeat.o(56813);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56813);
            return -1;
        }
    }
}
