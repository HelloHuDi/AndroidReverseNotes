package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cqo extends a {
    public String xot;
    public String xou;
    public LinkedList<String> xov = new LinkedList();
    public int xow;

    public cqo() {
        AppMethodBeat.i(102395);
        AppMethodBeat.o(102395);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(102396);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xot != null) {
                aVar.e(1, this.xot);
            }
            if (this.xou != null) {
                aVar.e(2, this.xou);
            }
            aVar.e(3, 1, this.xov);
            aVar.iz(4, this.xow);
            AppMethodBeat.o(102396);
            return 0;
        } else if (i == 1) {
            if (this.xot != null) {
                f = e.a.a.b.b.a.f(1, this.xot) + 0;
            } else {
                f = 0;
            }
            if (this.xou != null) {
                f += e.a.a.b.b.a.f(2, this.xou);
            }
            int c = (f + e.a.a.a.c(3, 1, this.xov)) + e.a.a.b.b.a.bs(4, this.xow);
            AppMethodBeat.o(102396);
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
            AppMethodBeat.o(102396);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cqo cqo = (cqo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cqo.xot = aVar3.BTU.readString();
                    AppMethodBeat.o(102396);
                    return 0;
                case 2:
                    cqo.xou = aVar3.BTU.readString();
                    AppMethodBeat.o(102396);
                    return 0;
                case 3:
                    cqo.xov.add(aVar3.BTU.readString());
                    AppMethodBeat.o(102396);
                    return 0;
                case 4:
                    cqo.xow = aVar3.BTU.vd();
                    AppMethodBeat.o(102396);
                    return 0;
                default:
                    AppMethodBeat.o(102396);
                    return -1;
            }
        } else {
            AppMethodBeat.o(102396);
            return -1;
        }
    }
}
