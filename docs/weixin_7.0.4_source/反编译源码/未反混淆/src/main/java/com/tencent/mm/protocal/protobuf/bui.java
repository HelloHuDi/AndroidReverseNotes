package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bui extends a {
    public LinkedList<buh> vKy = new LinkedList();

    public bui() {
        AppMethodBeat.i(14747);
        AppMethodBeat.o(14747);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14748);
        int c;
        byte[] bArr;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).e(1, 8, this.vKy);
            AppMethodBeat.o(14748);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.vKy) + 0;
            AppMethodBeat.o(14748);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vKy.clear();
            e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar); c > 0; c = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, c)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(14748);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            bui bui = (bui) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar2.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        buh buh = new buh();
                        e.a.a.a.a aVar3 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = buh.populateBuilderWithField(aVar3, buh, a.getNextFieldNumber(aVar3))) {
                        }
                        bui.vKy.add(buh);
                    }
                    AppMethodBeat.o(14748);
                    return 0;
                default:
                    AppMethodBeat.o(14748);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14748);
            return -1;
        }
    }
}
