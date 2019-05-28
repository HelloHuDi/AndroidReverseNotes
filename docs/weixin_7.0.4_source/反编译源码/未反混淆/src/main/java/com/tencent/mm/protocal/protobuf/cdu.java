package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cdu extends a {
    public LinkedList<cdw> xdx = new LinkedList();

    public cdu() {
        AppMethodBeat.i(108905);
        AppMethodBeat.o(108905);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(108906);
        int c;
        byte[] bArr;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).e(1, 8, this.xdx);
            AppMethodBeat.o(108906);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.xdx) + 0;
            AppMethodBeat.o(108906);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xdx.clear();
            e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar); c > 0; c = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, c)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(108906);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            cdu cdu = (cdu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar2.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdw cdw = new cdw();
                        e.a.a.a.a aVar3 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cdw.populateBuilderWithField(aVar3, cdw, a.getNextFieldNumber(aVar3))) {
                        }
                        cdu.xdx.add(cdw);
                    }
                    AppMethodBeat.o(108906);
                    return 0;
                default:
                    AppMethodBeat.o(108906);
                    return -1;
            }
        } else {
            AppMethodBeat.o(108906);
            return -1;
        }
    }
}
