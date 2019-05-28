package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cto extends a {
    public LinkedList<String> vII = new LinkedList();

    public cto() {
        AppMethodBeat.i(28722);
        AppMethodBeat.o(28722);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28723);
        int c;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).e(1, 1, this.vII);
            AppMethodBeat.o(28723);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 1, this.vII) + 0;
            AppMethodBeat.o(28723);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.vII.clear();
            e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar); c > 0; c = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, c)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(28723);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            cto cto = (cto) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cto.vII.add(aVar2.BTU.readString());
                    AppMethodBeat.o(28723);
                    return 0;
                default:
                    AppMethodBeat.o(28723);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28723);
            return -1;
        }
    }
}
