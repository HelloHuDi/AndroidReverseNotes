package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bqe extends a {
    public long bHi;
    public sq wsi;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(134440);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.bHi);
            if (this.wsi != null) {
                aVar.iy(2, this.wsi.computeSize());
                this.wsi.writeFields(aVar);
            }
            AppMethodBeat.o(134440);
            return 0;
        } else if (i == 1) {
            o = e.a.a.b.b.a.o(1, this.bHi) + 0;
            if (this.wsi != null) {
                o += e.a.a.a.ix(2, this.wsi.computeSize());
            }
            AppMethodBeat.o(134440);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(134440);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bqe bqe = (bqe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bqe.bHi = aVar3.BTU.ve();
                    AppMethodBeat.o(134440);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        sq sqVar = new sq();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = sqVar.populateBuilderWithField(aVar4, sqVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bqe.wsi = sqVar;
                    }
                    AppMethodBeat.o(134440);
                    return 0;
                default:
                    AppMethodBeat.o(134440);
                    return -1;
            }
        } else {
            AppMethodBeat.o(134440);
            return -1;
        }
    }
}
