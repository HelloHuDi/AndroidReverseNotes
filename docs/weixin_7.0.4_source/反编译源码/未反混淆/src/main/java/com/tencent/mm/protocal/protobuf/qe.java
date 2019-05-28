package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class qe extends a {
    public int ehB;
    public LinkedList<qf> vXi = new LinkedList();
    public int vXj;
    public bts vXk;

    public qe() {
        AppMethodBeat.i(60025);
        AppMethodBeat.o(60025);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(60026);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.ehB);
            aVar.e(2, 8, this.vXi);
            aVar.iz(3, this.vXj);
            if (this.vXk != null) {
                aVar.iy(4, this.vXk.computeSize());
                this.vXk.writeFields(aVar);
            }
            AppMethodBeat.o(60026);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.ehB) + 0) + e.a.a.a.c(2, 8, this.vXi)) + e.a.a.b.b.a.bs(3, this.vXj);
            if (this.vXk != null) {
                bs += e.a.a.a.ix(4, this.vXk.computeSize());
            }
            AppMethodBeat.o(60026);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vXi.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(60026);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            qe qeVar = (qe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    qeVar.ehB = aVar3.BTU.vd();
                    AppMethodBeat.o(60026);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        qf qfVar = new qf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qfVar.populateBuilderWithField(aVar4, qfVar, a.getNextFieldNumber(aVar4))) {
                        }
                        qeVar.vXi.add(qfVar);
                    }
                    AppMethodBeat.o(60026);
                    return 0;
                case 3:
                    qeVar.vXj = aVar3.BTU.vd();
                    AppMethodBeat.o(60026);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        qeVar.vXk = bts;
                    }
                    AppMethodBeat.o(60026);
                    return 0;
                default:
                    AppMethodBeat.o(60026);
                    return -1;
            }
        } else {
            AppMethodBeat.o(60026);
            return -1;
        }
    }
}
