package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class acc extends a {
    public int jCo;
    public String wjQ;
    public long wjR;
    public String wjS;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(63689);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wjQ == null) {
                bVar = new b("Not all required fields were included: Rid");
                AppMethodBeat.o(63689);
                throw bVar;
            } else if (this.wjS == null) {
                bVar = new b("Not all required fields were included: MimeType");
                AppMethodBeat.o(63689);
                throw bVar;
            } else {
                if (this.wjQ != null) {
                    aVar.e(1, this.wjQ);
                }
                aVar.ai(2, this.wjR);
                aVar.iz(3, this.jCo);
                if (this.wjS != null) {
                    aVar.e(4, this.wjS);
                }
                AppMethodBeat.o(63689);
                return 0;
            }
        } else if (i == 1) {
            if (this.wjQ != null) {
                f = e.a.a.b.b.a.f(1, this.wjQ) + 0;
            } else {
                f = 0;
            }
            f = (f + e.a.a.b.b.a.o(2, this.wjR)) + e.a.a.b.b.a.bs(3, this.jCo);
            if (this.wjS != null) {
                f += e.a.a.b.b.a.f(4, this.wjS);
            }
            AppMethodBeat.o(63689);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.wjQ == null) {
                bVar = new b("Not all required fields were included: Rid");
                AppMethodBeat.o(63689);
                throw bVar;
            } else if (this.wjS == null) {
                bVar = new b("Not all required fields were included: MimeType");
                AppMethodBeat.o(63689);
                throw bVar;
            } else {
                AppMethodBeat.o(63689);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            acc acc = (acc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    acc.wjQ = aVar3.BTU.readString();
                    AppMethodBeat.o(63689);
                    return 0;
                case 2:
                    acc.wjR = aVar3.BTU.ve();
                    AppMethodBeat.o(63689);
                    return 0;
                case 3:
                    acc.jCo = aVar3.BTU.vd();
                    AppMethodBeat.o(63689);
                    return 0;
                case 4:
                    acc.wjS = aVar3.BTU.readString();
                    AppMethodBeat.o(63689);
                    return 0;
                default:
                    AppMethodBeat.o(63689);
                    return -1;
            }
        } else {
            AppMethodBeat.o(63689);
            return -1;
        }
    }
}
