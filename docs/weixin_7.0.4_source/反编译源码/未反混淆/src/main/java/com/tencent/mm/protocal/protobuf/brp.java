package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class brp extends bsr {
    public b wTP;
    public int wTQ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58928);
        e.a.a.b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wTP == null) {
                bVar = new e.a.a.b("Not all required fields were included: clientCheckData");
                AppMethodBeat.o(58928);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wTP != null) {
                aVar.c(2, this.wTP);
            }
            aVar.iz(3, this.wTQ);
            AppMethodBeat.o(58928);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wTP != null) {
                ix += e.a.a.b.b.a.b(2, this.wTP);
            }
            int bs = ix + e.a.a.b.b.a.bs(3, this.wTQ);
            AppMethodBeat.o(58928);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wTP == null) {
                bVar = new e.a.a.b("Not all required fields were included: clientCheckData");
                AppMethodBeat.o(58928);
                throw bVar;
            }
            AppMethodBeat.o(58928);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            brp brp = (brp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        brp.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(58928);
                    return 0;
                case 2:
                    brp.wTP = aVar3.BTU.emu();
                    AppMethodBeat.o(58928);
                    return 0;
                case 3:
                    brp.wTQ = aVar3.BTU.vd();
                    AppMethodBeat.o(58928);
                    return 0;
                default:
                    AppMethodBeat.o(58928);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58928);
            return -1;
        }
    }
}
