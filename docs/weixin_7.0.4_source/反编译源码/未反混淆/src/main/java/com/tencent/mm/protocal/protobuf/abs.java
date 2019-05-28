package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class abs extends a {
    public LinkedList<String> wiI = new LinkedList();
    public LinkedList<String> wiJ = new LinkedList();

    public abs() {
        AppMethodBeat.i(51421);
        AppMethodBeat.o(51421);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51422);
        int c;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 1, this.wiI);
            aVar.e(2, 1, this.wiJ);
            AppMethodBeat.o(51422);
            return 0;
        } else if (i == 1) {
            c = (e.a.a.a.c(1, 1, this.wiI) + 0) + e.a.a.a.c(2, 1, this.wiJ);
            AppMethodBeat.o(51422);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wiI.clear();
            this.wiJ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(51422);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            abs abs = (abs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abs.wiI.add(aVar3.BTU.readString());
                    AppMethodBeat.o(51422);
                    return 0;
                case 2:
                    abs.wiJ.add(aVar3.BTU.readString());
                    AppMethodBeat.o(51422);
                    return 0;
                default:
                    AppMethodBeat.o(51422);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51422);
            return -1;
        }
    }
}
