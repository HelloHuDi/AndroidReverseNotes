package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;
import java.util.LinkedList;

public final class azz extends a {
    public LinkedList<b> wDN = new LinkedList();

    public azz() {
        AppMethodBeat.i(102383);
        AppMethodBeat.o(102383);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(102384);
        int c;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).e(1, 6, this.wDN);
            AppMethodBeat.o(102384);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 6, this.wDN) + 0;
            AppMethodBeat.o(102384);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wDN.clear();
            e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar); c > 0; c = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, c)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(102384);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            azz azz = (azz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    azz.wDN.add(aVar2.BTU.emu());
                    AppMethodBeat.o(102384);
                    return 0;
                default:
                    AppMethodBeat.o(102384);
                    return -1;
            }
        } else {
            AppMethodBeat.o(102384);
            return -1;
        }
    }
}
