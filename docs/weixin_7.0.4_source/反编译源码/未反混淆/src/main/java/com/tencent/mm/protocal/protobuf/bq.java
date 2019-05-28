package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bq extends a {
    public axb vDV;
    public LinkedList<axc> vDW = new LinkedList();

    public bq() {
        AppMethodBeat.i(70471);
        AppMethodBeat.o(70471);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(70472);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vDV == null) {
                bVar = new b("Not all required fields were included: LogHead");
                AppMethodBeat.o(70472);
                throw bVar;
            }
            if (this.vDV != null) {
                aVar.iy(1, this.vDV.computeSize());
                this.vDV.writeFields(aVar);
            }
            aVar.e(2, 8, this.vDW);
            AppMethodBeat.o(70472);
            return 0;
        } else if (i == 1) {
            if (this.vDV != null) {
                ix = e.a.a.a.ix(1, this.vDV.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int c = ix + e.a.a.a.c(2, 8, this.vDW);
            AppMethodBeat.o(70472);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vDW.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.vDV == null) {
                bVar = new b("Not all required fields were included: LogHead");
                AppMethodBeat.o(70472);
                throw bVar;
            }
            AppMethodBeat.o(70472);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bq bqVar = (bq) objArr[1];
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
                        axb axb = new axb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = axb.populateBuilderWithField(aVar4, axb, a.getNextFieldNumber(aVar4))) {
                        }
                        bqVar.vDV = axb;
                    }
                    AppMethodBeat.o(70472);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axc axc = new axc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = axc.populateBuilderWithField(aVar4, axc, a.getNextFieldNumber(aVar4))) {
                        }
                        bqVar.vDW.add(axc);
                    }
                    AppMethodBeat.o(70472);
                    return 0;
                default:
                    AppMethodBeat.o(70472);
                    return -1;
            }
        } else {
            AppMethodBeat.o(70472);
            return -1;
        }
    }
}
