package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cuj extends a {
    public LinkedList<cuc> wtc = new LinkedList();
    public boolean xqq;

    public cuj() {
        AppMethodBeat.i(28749);
        AppMethodBeat.o(28749);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28750);
        int fv;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.aO(1, this.xqq);
            aVar.e(2, 8, this.wtc);
            AppMethodBeat.o(28750);
            return 0;
        } else if (i == 1) {
            fv = ((e.a.a.b.b.a.fv(1) + 1) + 0) + e.a.a.a.c(2, 8, this.wtc);
            AppMethodBeat.o(28750);
            return fv;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wtc.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28750);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cuj cuj = (cuj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cuj.xqq = aVar3.BTU.ehX();
                    AppMethodBeat.o(28750);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cuc cuc = new cuc();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cuc.populateBuilderWithField(aVar4, cuc, a.getNextFieldNumber(aVar4))) {
                        }
                        cuj.wtc.add(cuc);
                    }
                    AppMethodBeat.o(28750);
                    return 0;
                default:
                    AppMethodBeat.o(28750);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28750);
            return -1;
        }
    }
}
