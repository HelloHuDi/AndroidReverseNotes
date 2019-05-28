package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cuf extends a {
    public LinkedList<Integer> xqG = new LinkedList();
    public boolean xqH;

    public cuf() {
        AppMethodBeat.i(28744);
        AppMethodBeat.o(28744);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28745);
        int c;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 2, this.xqG);
            aVar.aO(2, this.xqH);
            AppMethodBeat.o(28745);
            return 0;
        } else if (i == 1) {
            c = (e.a.a.a.c(1, 2, this.xqG) + 0) + (e.a.a.b.b.a.fv(2) + 1);
            AppMethodBeat.o(28745);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.xqG.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28745);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cuf cuf = (cuf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cuf.xqG.add(Integer.valueOf(aVar3.BTU.vd()));
                    AppMethodBeat.o(28745);
                    return 0;
                case 2:
                    cuf.xqH = aVar3.BTU.ehX();
                    AppMethodBeat.o(28745);
                    return 0;
                default:
                    AppMethodBeat.o(28745);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28745);
            return -1;
        }
    }
}
