package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cnw extends a {
    public LinkedList<Float> xls = new LinkedList();

    public cnw() {
        AppMethodBeat.i(2534);
        AppMethodBeat.o(2534);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(2535);
        int c;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).e(1, 5, this.xls);
            AppMethodBeat.o(2535);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 5, this.xls) + 0;
            AppMethodBeat.o(2535);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.xls.clear();
            e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar); c > 0; c = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, c)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(2535);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            cnw cnw = (cnw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cnw.xls.add(Float.valueOf(Float.intBitsToFloat(aVar2.BTU.eia())));
                    AppMethodBeat.o(2535);
                    return 0;
                default:
                    AppMethodBeat.o(2535);
                    return -1;
            }
        } else {
            AppMethodBeat.o(2535);
            return -1;
        }
    }
}
