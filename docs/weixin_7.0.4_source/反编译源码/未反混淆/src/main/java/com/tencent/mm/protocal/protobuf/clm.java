package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class clm extends a {
    public int OpCode;
    public LinkedList<String> xjj = new LinkedList();

    public clm() {
        AppMethodBeat.i(62587);
        AppMethodBeat.o(62587);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62588);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.OpCode);
            aVar.e(2, 1, this.xjj);
            AppMethodBeat.o(62588);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.OpCode) + 0) + e.a.a.a.c(2, 1, this.xjj);
            AppMethodBeat.o(62588);
            return bs;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.xjj.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(62588);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            clm clm = (clm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    clm.OpCode = aVar3.BTU.vd();
                    AppMethodBeat.o(62588);
                    return 0;
                case 2:
                    clm.xjj.add(aVar3.BTU.readString());
                    AppMethodBeat.o(62588);
                    return 0;
                default:
                    AppMethodBeat.o(62588);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62588);
            return -1;
        }
    }
}
