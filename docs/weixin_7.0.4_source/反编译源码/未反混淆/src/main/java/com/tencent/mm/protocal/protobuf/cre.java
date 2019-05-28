package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cre extends a {
    public LinkedList<cra> xoN = new LinkedList();
    public String xot;

    public cre() {
        AppMethodBeat.i(102414);
        AppMethodBeat.o(102414);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(102415);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xot != null) {
                aVar.e(1, this.xot);
            }
            aVar.e(2, 8, this.xoN);
            AppMethodBeat.o(102415);
            return 0;
        } else if (i == 1) {
            if (this.xot != null) {
                f = e.a.a.b.b.a.f(1, this.xot) + 0;
            } else {
                f = 0;
            }
            int c = f + e.a.a.a.c(2, 8, this.xoN);
            AppMethodBeat.o(102415);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xoN.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(102415);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cre cre = (cre) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cre.xot = aVar3.BTU.readString();
                    AppMethodBeat.o(102415);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cra cra = new cra();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cra.populateBuilderWithField(aVar4, cra, a.getNextFieldNumber(aVar4))) {
                        }
                        cre.xoN.add(cra);
                    }
                    AppMethodBeat.o(102415);
                    return 0;
                default:
                    AppMethodBeat.o(102415);
                    return -1;
            }
        } else {
            AppMethodBeat.o(102415);
            return -1;
        }
    }
}
