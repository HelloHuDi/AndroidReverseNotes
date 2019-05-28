package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class ss extends a {
    public int Scene;
    public String jCh;
    public String mZV;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(63688);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.mZV == null) {
                bVar = new b("Not all required fields were included: PkgId");
                AppMethodBeat.o(63688);
                throw bVar;
            }
            if (this.mZV != null) {
                aVar.e(1, this.mZV);
            }
            if (this.jCh != null) {
                aVar.e(2, this.jCh);
            }
            aVar.iz(3, this.Scene);
            AppMethodBeat.o(63688);
            return 0;
        } else if (i == 1) {
            if (this.mZV != null) {
                f = e.a.a.b.b.a.f(1, this.mZV) + 0;
            } else {
                f = 0;
            }
            if (this.jCh != null) {
                f += e.a.a.b.b.a.f(2, this.jCh);
            }
            int bs = f + e.a.a.b.b.a.bs(3, this.Scene);
            AppMethodBeat.o(63688);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.mZV == null) {
                bVar = new b("Not all required fields were included: PkgId");
                AppMethodBeat.o(63688);
                throw bVar;
            }
            AppMethodBeat.o(63688);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ss ssVar = (ss) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ssVar.mZV = aVar3.BTU.readString();
                    AppMethodBeat.o(63688);
                    return 0;
                case 2:
                    ssVar.jCh = aVar3.BTU.readString();
                    AppMethodBeat.o(63688);
                    return 0;
                case 3:
                    ssVar.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(63688);
                    return 0;
                default:
                    AppMethodBeat.o(63688);
                    return -1;
            }
        } else {
            AppMethodBeat.o(63688);
            return -1;
        }
    }
}
