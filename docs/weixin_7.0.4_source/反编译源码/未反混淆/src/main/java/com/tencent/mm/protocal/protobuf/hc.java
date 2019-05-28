package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class hc extends a {
    public String vJF;
    public LinkedList<bqr> vJL = new LinkedList();

    public hc() {
        AppMethodBeat.i(56710);
        AppMethodBeat.o(56710);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56711);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vJF != null) {
                aVar.e(1, this.vJF);
            }
            aVar.e(2, 8, this.vJL);
            AppMethodBeat.o(56711);
            return 0;
        } else if (i == 1) {
            if (this.vJF != null) {
                f = e.a.a.b.b.a.f(1, this.vJF) + 0;
            } else {
                f = 0;
            }
            int c = f + e.a.a.a.c(2, 8, this.vJL);
            AppMethodBeat.o(56711);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vJL.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56711);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            hc hcVar = (hc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    hcVar.vJF = aVar3.BTU.readString();
                    AppMethodBeat.o(56711);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bqr bqr = new bqr();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bqr.populateBuilderWithField(aVar4, bqr, a.getNextFieldNumber(aVar4))) {
                        }
                        hcVar.vJL.add(bqr);
                    }
                    AppMethodBeat.o(56711);
                    return 0;
                default:
                    AppMethodBeat.o(56711);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56711);
            return -1;
        }
    }
}
