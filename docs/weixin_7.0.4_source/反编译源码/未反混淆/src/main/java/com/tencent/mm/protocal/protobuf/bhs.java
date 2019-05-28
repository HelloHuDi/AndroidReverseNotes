package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bhs extends a {
    public int jBv;
    public LinkedList<bhp> wKT = new LinkedList();
    public LinkedList<Integer> wof = new LinkedList();

    public bhs() {
        AppMethodBeat.i(60059);
        AppMethodBeat.o(60059);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(60060);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.jBv);
            aVar.f(2, 2, this.wof);
            aVar.e(3, 8, this.wKT);
            AppMethodBeat.o(60060);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.jBv) + 0) + e.a.a.a.d(2, 2, this.wof)) + e.a.a.a.c(3, 8, this.wKT);
            AppMethodBeat.o(60060);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wof.clear();
            this.wKT.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(60060);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bhs bhs = (bhs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bhs.jBv = aVar3.BTU.vd();
                    AppMethodBeat.o(60060);
                    return 0;
                case 2:
                    bhs.wof = new e.a.a.a.a(aVar3.BTU.emu().wR, unknownTagHandler).BTU.emt();
                    AppMethodBeat.o(60060);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bhp bhp = new bhp();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bhp.populateBuilderWithField(aVar4, bhp, a.getNextFieldNumber(aVar4))) {
                        }
                        bhs.wKT.add(bhp);
                    }
                    AppMethodBeat.o(60060);
                    return 0;
                default:
                    AppMethodBeat.o(60060);
                    return -1;
            }
        } else {
            AppMethodBeat.o(60060);
            return -1;
        }
    }
}
