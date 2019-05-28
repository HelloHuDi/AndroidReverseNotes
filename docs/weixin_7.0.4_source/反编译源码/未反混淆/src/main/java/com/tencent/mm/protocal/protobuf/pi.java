package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class pi extends bsr {
    public String kCK;
    public int nUf;
    public b vWg;
    public b vWh;
    public int vWi = 4;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56756);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.nUf);
            if (this.vWg != null) {
                aVar.c(3, this.vWg);
            }
            if (this.vWh != null) {
                aVar.c(4, this.vWh);
            }
            if (this.kCK != null) {
                aVar.e(5, this.kCK);
            }
            aVar.iz(6, this.vWi);
            AppMethodBeat.o(56756);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.nUf);
            if (this.vWg != null) {
                ix += e.a.a.b.b.a.b(3, this.vWg);
            }
            if (this.vWh != null) {
                ix += e.a.a.b.b.a.b(4, this.vWh);
            }
            if (this.kCK != null) {
                ix += e.a.a.b.b.a.f(5, this.kCK);
            }
            int bs = ix + e.a.a.b.b.a.bs(6, this.vWi);
            AppMethodBeat.o(56756);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56756);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            pi piVar = (pi) objArr[1];
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
                        piVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56756);
                    return 0;
                case 2:
                    piVar.nUf = aVar3.BTU.vd();
                    AppMethodBeat.o(56756);
                    return 0;
                case 3:
                    piVar.vWg = aVar3.BTU.emu();
                    AppMethodBeat.o(56756);
                    return 0;
                case 4:
                    piVar.vWh = aVar3.BTU.emu();
                    AppMethodBeat.o(56756);
                    return 0;
                case 5:
                    piVar.kCK = aVar3.BTU.readString();
                    AppMethodBeat.o(56756);
                    return 0;
                case 6:
                    piVar.vWi = aVar3.BTU.vd();
                    AppMethodBeat.o(56756);
                    return 0;
                default:
                    AppMethodBeat.o(56756);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56756);
            return -1;
        }
    }
}
