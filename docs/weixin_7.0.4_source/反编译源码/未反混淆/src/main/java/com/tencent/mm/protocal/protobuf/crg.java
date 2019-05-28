package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class crg extends a {
    public LinkedList<cqt> xoJ = new LinkedList();
    public cql xoU;
    public int xoV;

    public crg() {
        AppMethodBeat.i(102417);
        AppMethodBeat.o(102417);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(102418);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xoU == null) {
                bVar = new b("Not all required fields were included: base_request");
                AppMethodBeat.o(102418);
                throw bVar;
            }
            if (this.xoU != null) {
                aVar.iy(1, this.xoU.computeSize());
                this.xoU.writeFields(aVar);
            }
            aVar.e(2, 8, this.xoJ);
            aVar.iz(3, this.xoV);
            AppMethodBeat.o(102418);
            return 0;
        } else if (i == 1) {
            if (this.xoU != null) {
                ix = e.a.a.a.ix(1, this.xoU.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int c = (ix + e.a.a.a.c(2, 8, this.xoJ)) + e.a.a.b.b.a.bs(3, this.xoV);
            AppMethodBeat.o(102418);
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
            if (this.xoU == null) {
                bVar = new b("Not all required fields were included: base_request");
                AppMethodBeat.o(102418);
                throw bVar;
            }
            AppMethodBeat.o(102418);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            crg crg = (crg) objArr[1];
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
                        cql cql = new cql();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cql.populateBuilderWithField(aVar4, cql, a.getNextFieldNumber(aVar4))) {
                        }
                        crg.xoU = cql;
                    }
                    AppMethodBeat.o(102418);
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
                        crg.xoJ.add(cqt);
                    }
                    AppMethodBeat.o(102418);
                    return 0;
                case 3:
                    crg.xoV = aVar3.BTU.vd();
                    AppMethodBeat.o(102418);
                    return 0;
                default:
                    AppMethodBeat.o(102418);
                    return -1;
            }
        } else {
            AppMethodBeat.o(102418);
            return -1;
        }
    }
}
