package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class hs extends a {
    public LinkedList<String> vII = new LinkedList();

    public hs() {
        AppMethodBeat.i(62515);
        AppMethodBeat.o(62515);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62516);
        int c;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).e(1, 1, this.vII);
            AppMethodBeat.o(62516);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 1, this.vII) + 0;
            AppMethodBeat.o(62516);
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
            AppMethodBeat.o(62516);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            hs hsVar = (hs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hsVar.vII.add(aVar2.BTU.readString());
                    AppMethodBeat.o(62516);
                    return 0;
                default:
                    AppMethodBeat.o(62516);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62516);
            return -1;
        }
    }
}
