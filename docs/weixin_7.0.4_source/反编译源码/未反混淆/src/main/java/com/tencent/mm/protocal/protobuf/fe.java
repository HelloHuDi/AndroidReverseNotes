package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class fe extends a {
    public int vHa;
    public int vHb;
    public int vHi;
    public ff vHj;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28316);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vHa);
            aVar.iz(2, this.vHb);
            aVar.iz(3, this.vHi);
            if (this.vHj != null) {
                aVar.iy(4, this.vHj.computeSize());
                this.vHj.writeFields(aVar);
            }
            AppMethodBeat.o(28316);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.vHa) + 0) + e.a.a.b.b.a.bs(2, this.vHb)) + e.a.a.b.b.a.bs(3, this.vHi);
            if (this.vHj != null) {
                bs += e.a.a.a.ix(4, this.vHj.computeSize());
            }
            AppMethodBeat.o(28316);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28316);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            fe feVar = (fe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    feVar.vHa = aVar3.BTU.vd();
                    AppMethodBeat.o(28316);
                    return 0;
                case 2:
                    feVar.vHb = aVar3.BTU.vd();
                    AppMethodBeat.o(28316);
                    return 0;
                case 3:
                    feVar.vHi = aVar3.BTU.vd();
                    AppMethodBeat.o(28316);
                    return 0;
                case 4:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        ff ffVar = new ff();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ffVar.populateBuilderWithField(aVar4, ffVar, a.getNextFieldNumber(aVar4))) {
                        }
                        feVar.vHj = ffVar;
                    }
                    AppMethodBeat.o(28316);
                    return 0;
                default:
                    AppMethodBeat.o(28316);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28316);
            return -1;
        }
    }
}
