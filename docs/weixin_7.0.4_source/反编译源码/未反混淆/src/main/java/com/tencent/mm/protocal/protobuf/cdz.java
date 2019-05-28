package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class cdz extends a {
    public String qQm;
    public int qQn;
    public String qQo;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56506);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.qQm == null) {
                bVar = new b("Not all required fields were included: clientID");
                AppMethodBeat.o(56506);
                throw bVar;
            }
            if (this.qQm != null) {
                aVar.e(1, this.qQm);
            }
            aVar.iz(2, this.qQn);
            if (this.qQo != null) {
                aVar.e(3, this.qQo);
            }
            AppMethodBeat.o(56506);
            return 0;
        } else if (i == 1) {
            if (this.qQm != null) {
                f = e.a.a.b.b.a.f(1, this.qQm) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.qQn);
            if (this.qQo != null) {
                f += e.a.a.b.b.a.f(3, this.qQo);
            }
            AppMethodBeat.o(56506);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.qQm == null) {
                bVar = new b("Not all required fields were included: clientID");
                AppMethodBeat.o(56506);
                throw bVar;
            }
            AppMethodBeat.o(56506);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cdz cdz = (cdz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cdz.qQm = aVar3.BTU.readString();
                    AppMethodBeat.o(56506);
                    return 0;
                case 2:
                    cdz.qQn = aVar3.BTU.vd();
                    AppMethodBeat.o(56506);
                    return 0;
                case 3:
                    cdz.qQo = aVar3.BTU.readString();
                    AppMethodBeat.o(56506);
                    return 0;
                default:
                    AppMethodBeat.o(56506);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56506);
            return -1;
        }
    }
}
