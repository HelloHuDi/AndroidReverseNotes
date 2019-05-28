package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cj extends bsr {
    public LinkedList<String> fLd = new LinkedList();

    public cj() {
        AppMethodBeat.i(28304);
        AppMethodBeat.o(28304);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28305);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 1, this.fLd);
            AppMethodBeat.o(28305);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int c = ix + e.a.a.a.c(2, 1, this.fLd);
            AppMethodBeat.o(28305);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.fLd.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28305);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cj cjVar = (cj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cjVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28305);
                    return 0;
                case 2:
                    cjVar.fLd.add(aVar3.BTU.readString());
                    AppMethodBeat.o(28305);
                    return 0;
                default:
                    AppMethodBeat.o(28305);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28305);
            return -1;
        }
    }
}
