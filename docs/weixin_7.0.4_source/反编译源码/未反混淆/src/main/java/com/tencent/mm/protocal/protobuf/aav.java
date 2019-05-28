package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class aav extends a {
    public LinkedList<bca> mgt = new LinkedList();
    public LinkedList<bcd> wie = new LinkedList();

    public aav() {
        AppMethodBeat.i(51394);
        AppMethodBeat.o(51394);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51395);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.mgt);
            aVar.e(2, 8, this.wie);
            AppMethodBeat.o(51395);
            return 0;
        } else if (i == 1) {
            c = (e.a.a.a.c(1, 8, this.mgt) + 0) + e.a.a.a.c(2, 8, this.wie);
            AppMethodBeat.o(51395);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.mgt.clear();
            this.wie.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(51395);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aav aav = (aav) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bca bca = new bca();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bca.populateBuilderWithField(aVar4, bca, a.getNextFieldNumber(aVar4))) {
                        }
                        aav.mgt.add(bca);
                    }
                    AppMethodBeat.o(51395);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bcd bcd = new bcd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bcd.populateBuilderWithField(aVar4, bcd, a.getNextFieldNumber(aVar4))) {
                        }
                        aav.wie.add(bcd);
                    }
                    AppMethodBeat.o(51395);
                    return 0;
                default:
                    AppMethodBeat.o(51395);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51395);
            return -1;
        }
    }
}
