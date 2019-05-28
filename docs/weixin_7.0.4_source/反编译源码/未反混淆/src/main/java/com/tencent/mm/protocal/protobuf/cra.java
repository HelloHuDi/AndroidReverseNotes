package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cra extends a {
    public String xou;
    public LinkedList<String> xov = new LinkedList();

    public cra() {
        AppMethodBeat.i(102409);
        AppMethodBeat.o(102409);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(102410);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xou != null) {
                aVar.e(1, this.xou);
            }
            aVar.e(2, 1, this.xov);
            AppMethodBeat.o(102410);
            return 0;
        } else if (i == 1) {
            if (this.xou != null) {
                f = e.a.a.b.b.a.f(1, this.xou) + 0;
            } else {
                f = 0;
            }
            int c = f + e.a.a.a.c(2, 1, this.xov);
            AppMethodBeat.o(102410);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.xov.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(102410);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cra cra = (cra) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cra.xou = aVar3.BTU.readString();
                    AppMethodBeat.o(102410);
                    return 0;
                case 2:
                    cra.xov.add(aVar3.BTU.readString());
                    AppMethodBeat.o(102410);
                    return 0;
                default:
                    AppMethodBeat.o(102410);
                    return -1;
            }
        } else {
            AppMethodBeat.o(102410);
            return -1;
        }
    }
}
