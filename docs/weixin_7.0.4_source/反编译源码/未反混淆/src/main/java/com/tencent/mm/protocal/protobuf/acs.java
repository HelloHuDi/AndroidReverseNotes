package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class acs extends a {
    public LinkedList<aao> wkv = new LinkedList();

    public acs() {
        AppMethodBeat.i(94524);
        AppMethodBeat.o(94524);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94525);
        int c;
        byte[] bArr;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).e(1, 8, this.wkv);
            AppMethodBeat.o(94525);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.wkv) + 0;
            AppMethodBeat.o(94525);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wkv.clear();
            e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar); c > 0; c = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, c)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(94525);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            acs acs = (acs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar2.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aao aao = new aao();
                        e.a.a.a.a aVar3 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = aao.populateBuilderWithField(aVar3, aao, a.getNextFieldNumber(aVar3))) {
                        }
                        acs.wkv.add(aao);
                    }
                    AppMethodBeat.o(94525);
                    return 0;
                default:
                    AppMethodBeat.o(94525);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94525);
            return -1;
        }
    }
}
