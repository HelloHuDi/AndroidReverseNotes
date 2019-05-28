package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class crr extends a {
    public LinkedList<cqt> xoJ = new LinkedList();
    public cqm xoW;
    public int xpj;

    public crr() {
        AppMethodBeat.i(102429);
        AppMethodBeat.o(102429);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(102430);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xoW == null) {
                bVar = new b("Not all required fields were included: base_response");
                AppMethodBeat.o(102430);
                throw bVar;
            }
            if (this.xoW != null) {
                aVar.iy(1, this.xoW.computeSize());
                this.xoW.writeFields(aVar);
            }
            aVar.e(2, 8, this.xoJ);
            aVar.iz(3, this.xpj);
            AppMethodBeat.o(102430);
            return 0;
        } else if (i == 1) {
            if (this.xoW != null) {
                ix = e.a.a.a.ix(1, this.xoW.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int c = (ix + e.a.a.a.c(2, 8, this.xoJ)) + e.a.a.b.b.a.bs(3, this.xpj);
            AppMethodBeat.o(102430);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xoJ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.xoW == null) {
                bVar = new b("Not all required fields were included: base_response");
                AppMethodBeat.o(102430);
                throw bVar;
            }
            AppMethodBeat.o(102430);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            crr crr = (crr) objArr[1];
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
                        cqm cqm = new cqm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cqm.populateBuilderWithField(aVar4, cqm, a.getNextFieldNumber(aVar4))) {
                        }
                        crr.xoW = cqm;
                    }
                    AppMethodBeat.o(102430);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cqt cqt = new cqt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cqt.populateBuilderWithField(aVar4, cqt, a.getNextFieldNumber(aVar4))) {
                        }
                        crr.xoJ.add(cqt);
                    }
                    AppMethodBeat.o(102430);
                    return 0;
                case 3:
                    crr.xpj = aVar3.BTU.vd();
                    AppMethodBeat.o(102430);
                    return 0;
                default:
                    AppMethodBeat.o(102430);
                    return -1;
            }
        } else {
            AppMethodBeat.o(102430);
            return -1;
        }
    }
}
