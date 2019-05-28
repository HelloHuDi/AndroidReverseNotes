package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cgh extends bsr {
    public int Scene;
    public int vEr;
    public int wem;
    public long wen;
    public int wkB;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28663);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.wem);
            aVar.ai(3, this.wen);
            aVar.iz(4, this.wkB);
            aVar.iz(5, this.vEr);
            aVar.iz(6, this.Scene);
            AppMethodBeat.o(28663);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = ((((ix + e.a.a.b.b.a.bs(2, this.wem)) + e.a.a.b.b.a.o(3, this.wen)) + e.a.a.b.b.a.bs(4, this.wkB)) + e.a.a.b.b.a.bs(5, this.vEr)) + e.a.a.b.b.a.bs(6, this.Scene);
            AppMethodBeat.o(28663);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28663);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cgh cgh = (cgh) objArr[1];
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
                        cgh.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28663);
                    return 0;
                case 2:
                    cgh.wem = aVar3.BTU.vd();
                    AppMethodBeat.o(28663);
                    return 0;
                case 3:
                    cgh.wen = aVar3.BTU.ve();
                    AppMethodBeat.o(28663);
                    return 0;
                case 4:
                    cgh.wkB = aVar3.BTU.vd();
                    AppMethodBeat.o(28663);
                    return 0;
                case 5:
                    cgh.vEr = aVar3.BTU.vd();
                    AppMethodBeat.o(28663);
                    return 0;
                case 6:
                    cgh.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(28663);
                    return 0;
                default:
                    AppMethodBeat.o(28663);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28663);
            return -1;
        }
    }
}
