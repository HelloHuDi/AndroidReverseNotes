package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class hw extends bsr {
    public LinkedList<biu> vKm = new LinkedList();
    public int vKn;
    public int vKo;

    public hw() {
        AppMethodBeat.i(56713);
        AppMethodBeat.o(56713);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56714);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 8, this.vKm);
            aVar.iz(3, this.vKn);
            aVar.iz(4, this.vKo);
            AppMethodBeat.o(56714);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int c = ((ix + e.a.a.a.c(2, 8, this.vKm)) + e.a.a.b.b.a.bs(3, this.vKn)) + e.a.a.b.b.a.bs(4, this.vKo);
            AppMethodBeat.o(56714);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vKm.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56714);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            hw hwVar = (hw) objArr[1];
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
                        hl hlVar = new hl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        hwVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56714);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        biu biu = new biu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = biu.populateBuilderWithField(aVar4, biu, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        hwVar.vKm.add(biu);
                    }
                    AppMethodBeat.o(56714);
                    return 0;
                case 3:
                    hwVar.vKn = aVar3.BTU.vd();
                    AppMethodBeat.o(56714);
                    return 0;
                case 4:
                    hwVar.vKo = aVar3.BTU.vd();
                    AppMethodBeat.o(56714);
                    return 0;
                default:
                    AppMethodBeat.o(56714);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56714);
            return -1;
        }
    }
}
