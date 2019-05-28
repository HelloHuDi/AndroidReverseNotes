package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class bkf extends a {
    public String wNt;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(60061);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wNt == null) {
                bVar = new b("Not all required fields were included: PhoneNum");
                AppMethodBeat.o(60061);
                throw bVar;
            }
            if (this.wNt != null) {
                aVar.e(1, this.wNt);
            }
            AppMethodBeat.o(60061);
            return 0;
        } else if (i == 1) {
            if (this.wNt != null) {
                f = e.a.a.b.b.a.f(1, this.wNt) + 0;
            } else {
                f = 0;
            }
            AppMethodBeat.o(60061);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.wNt == null) {
                bVar = new b("Not all required fields were included: PhoneNum");
                AppMethodBeat.o(60061);
                throw bVar;
            }
            AppMethodBeat.o(60061);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bkf bkf = (bkf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bkf.wNt = aVar3.BTU.readString();
                    AppMethodBeat.o(60061);
                    return 0;
                default:
                    AppMethodBeat.o(60061);
                    return -1;
            }
        } else {
            AppMethodBeat.o(60061);
            return -1;
        }
    }
}
