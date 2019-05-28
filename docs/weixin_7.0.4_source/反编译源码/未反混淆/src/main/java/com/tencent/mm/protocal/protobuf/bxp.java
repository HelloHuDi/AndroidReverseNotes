package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bxp extends bsr {
    public int mask;
    public int wmV;
    public km wmX;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11806);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wmX == null) {
                bVar = new b("Not all required fields were included: attr");
                AppMethodBeat.o(11806);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.wmV);
            aVar.iz(3, this.mask);
            if (this.wmX != null) {
                aVar.iy(4, this.wmX.computeSize());
                this.wmX.writeFields(aVar);
            }
            AppMethodBeat.o(11806);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.wmV)) + e.a.a.b.b.a.bs(3, this.mask);
            if (this.wmX != null) {
                ix += e.a.a.a.ix(4, this.wmX.computeSize());
            }
            AppMethodBeat.o(11806);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wmX == null) {
                bVar = new b("Not all required fields were included: attr");
                AppMethodBeat.o(11806);
                throw bVar;
            }
            AppMethodBeat.o(11806);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bxp bxp = (bxp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bxp.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(11806);
                    return 0;
                case 2:
                    bxp.wmV = aVar3.BTU.vd();
                    AppMethodBeat.o(11806);
                    return 0;
                case 3:
                    bxp.mask = aVar3.BTU.vd();
                    AppMethodBeat.o(11806);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        km kmVar = new km();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kmVar.populateBuilderWithField(aVar4, kmVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bxp.wmX = kmVar;
                    }
                    AppMethodBeat.o(11806);
                    return 0;
                default:
                    AppMethodBeat.o(11806);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11806);
            return -1;
        }
    }
}
