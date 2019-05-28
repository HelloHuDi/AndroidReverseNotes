package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class rx extends bsr {
    public int Scene;
    public String vKt;
    public LinkedList<Integer> vZk = new LinkedList();
    public LinkedList<rw> vZl = new LinkedList();

    public rx() {
        AppMethodBeat.i(14719);
        AppMethodBeat.o(14719);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14720);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 2, this.vZk);
            aVar.iz(3, this.Scene);
            if (this.vKt != null) {
                aVar.e(4, this.vKt);
            }
            aVar.e(5, 8, this.vZl);
            AppMethodBeat.o(14720);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.a.c(2, 2, this.vZk)) + e.a.a.b.b.a.bs(3, this.Scene);
            if (this.vKt != null) {
                ix += e.a.a.b.b.a.f(4, this.vKt);
            }
            int c = ix + e.a.a.a.c(5, 8, this.vZl);
            AppMethodBeat.o(14720);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vZk.clear();
            this.vZl.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(14720);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            rx rxVar = (rx) objArr[1];
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
                        rxVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(14720);
                    return 0;
                case 2:
                    rxVar.vZk.add(Integer.valueOf(aVar3.BTU.vd()));
                    AppMethodBeat.o(14720);
                    return 0;
                case 3:
                    rxVar.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(14720);
                    return 0;
                case 4:
                    rxVar.vKt = aVar3.BTU.readString();
                    AppMethodBeat.o(14720);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        rw rwVar = new rw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = rwVar.populateBuilderWithField(aVar4, rwVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        rxVar.vZl.add(rwVar);
                    }
                    AppMethodBeat.o(14720);
                    return 0;
                default:
                    AppMethodBeat.o(14720);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14720);
            return -1;
        }
    }
}
