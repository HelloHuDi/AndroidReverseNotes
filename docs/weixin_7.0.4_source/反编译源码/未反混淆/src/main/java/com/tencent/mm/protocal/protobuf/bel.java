package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bel extends a {
    public long lastUpdateTime;
    public int version;
    public LinkedList<nn> wbW = new LinkedList();
    public int wbX;
    public int wbY;

    public bel() {
        AppMethodBeat.i(28560);
        AppMethodBeat.o(28560);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28561);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.wbW);
            aVar.iz(2, this.version);
            aVar.iz(3, this.wbX);
            aVar.iz(4, this.wbY);
            aVar.ai(5, this.lastUpdateTime);
            AppMethodBeat.o(28561);
            return 0;
        } else if (i == 1) {
            c = ((((e.a.a.a.c(1, 8, this.wbW) + 0) + e.a.a.b.b.a.bs(2, this.version)) + e.a.a.b.b.a.bs(3, this.wbX)) + e.a.a.b.b.a.bs(4, this.wbY)) + e.a.a.b.b.a.o(5, this.lastUpdateTime);
            AppMethodBeat.o(28561);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wbW.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28561);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bel bel = (bel) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        nn nnVar = new nn();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = nnVar.populateBuilderWithField(aVar4, nnVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bel.wbW.add(nnVar);
                    }
                    AppMethodBeat.o(28561);
                    return 0;
                case 2:
                    bel.version = aVar3.BTU.vd();
                    AppMethodBeat.o(28561);
                    return 0;
                case 3:
                    bel.wbX = aVar3.BTU.vd();
                    AppMethodBeat.o(28561);
                    return 0;
                case 4:
                    bel.wbY = aVar3.BTU.vd();
                    AppMethodBeat.o(28561);
                    return 0;
                case 5:
                    bel.lastUpdateTime = aVar3.BTU.ve();
                    AppMethodBeat.o(28561);
                    return 0;
                default:
                    AppMethodBeat.o(28561);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28561);
            return -1;
        }
    }
}
