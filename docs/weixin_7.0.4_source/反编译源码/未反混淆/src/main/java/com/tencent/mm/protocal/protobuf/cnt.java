package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cnt extends a {
    public LinkedList<cnu> vHk = new LinkedList();

    public cnt() {
        AppMethodBeat.i(124374);
        AppMethodBeat.o(124374);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124375);
        int c;
        byte[] bArr;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).e(1, 8, this.vHk);
            AppMethodBeat.o(124375);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.vHk) + 0;
            AppMethodBeat.o(124375);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vHk.clear();
            e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar); c > 0; c = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, c)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(124375);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            cnt cnt = (cnt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar2.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cnu cnu = new cnu();
                        e.a.a.a.a aVar3 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cnu.populateBuilderWithField(aVar3, cnu, a.getNextFieldNumber(aVar3))) {
                        }
                        cnt.vHk.add(cnu);
                    }
                    AppMethodBeat.o(124375);
                    return 0;
                default:
                    AppMethodBeat.o(124375);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124375);
            return -1;
        }
    }
}
