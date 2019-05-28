package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class dk extends a {
    public LinkedList<cdb> eow = new LinkedList();

    public dk() {
        AppMethodBeat.i(134420);
        AppMethodBeat.o(134420);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(134421);
        int c;
        byte[] bArr;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).e(1, 8, this.eow);
            AppMethodBeat.o(134421);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.eow) + 0;
            AppMethodBeat.o(134421);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.eow.clear();
            e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar); c > 0; c = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, c)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(134421);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            dk dkVar = (dk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar2.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdb cdb = new cdb();
                        e.a.a.a.a aVar3 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cdb.populateBuilderWithField(aVar3, cdb, a.getNextFieldNumber(aVar3))) {
                        }
                        dkVar.eow.add(cdb);
                    }
                    AppMethodBeat.o(134421);
                    return 0;
                default:
                    AppMethodBeat.o(134421);
                    return -1;
            }
        } else {
            AppMethodBeat.o(134421);
            return -1;
        }
    }
}
