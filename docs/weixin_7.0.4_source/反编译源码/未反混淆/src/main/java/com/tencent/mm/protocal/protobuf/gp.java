package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class gp extends a {
    public LinkedList<go> vIM = new LinkedList();

    public gp() {
        AppMethodBeat.i(28325);
        AppMethodBeat.o(28325);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28326);
        int c;
        byte[] bArr;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).e(1, 8, this.vIM);
            AppMethodBeat.o(28326);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.vIM) + 0;
            AppMethodBeat.o(28326);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vIM.clear();
            e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar); c > 0; c = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, c)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(28326);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            gp gpVar = (gp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar2.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        go goVar = new go();
                        e.a.a.a.a aVar3 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = goVar.populateBuilderWithField(aVar3, goVar, a.getNextFieldNumber(aVar3))) {
                        }
                        gpVar.vIM.add(goVar);
                    }
                    AppMethodBeat.o(28326);
                    return 0;
                default:
                    AppMethodBeat.o(28326);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28326);
            return -1;
        }
    }
}
