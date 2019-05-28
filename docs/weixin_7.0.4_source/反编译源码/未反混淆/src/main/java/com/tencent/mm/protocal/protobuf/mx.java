package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class mx extends a {
    public int vRj;
    public LinkedList<Integer> vRk = new LinkedList();

    public mx() {
        AppMethodBeat.i(58900);
        AppMethodBeat.o(58900);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58901);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vRj);
            aVar.f(2, 2, this.vRk);
            AppMethodBeat.o(58901);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.vRj) + 0) + e.a.a.a.d(2, 2, this.vRk);
            AppMethodBeat.o(58901);
            return bs;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.vRk.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(58901);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            mx mxVar = (mx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mxVar.vRj = aVar3.BTU.vd();
                    AppMethodBeat.o(58901);
                    return 0;
                case 2:
                    mxVar.vRk = new e.a.a.a.a(aVar3.BTU.emu().wR, unknownTagHandler).BTU.emt();
                    AppMethodBeat.o(58901);
                    return 0;
                default:
                    AppMethodBeat.o(58901);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58901);
            return -1;
        }
    }
}
