package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class cml extends a {
    public String key;
    public long waD;
    public String waE;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(93800);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.key == null) {
                bVar = new b("Not all required fields were included: key");
                AppMethodBeat.o(93800);
                throw bVar;
            }
            if (this.key != null) {
                aVar.e(1, this.key);
            }
            aVar.ai(2, this.waD);
            if (this.waE != null) {
                aVar.e(3, this.waE);
            }
            AppMethodBeat.o(93800);
            return 0;
        } else if (i == 1) {
            if (this.key != null) {
                f = e.a.a.b.b.a.f(1, this.key) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.o(2, this.waD);
            if (this.waE != null) {
                f += e.a.a.b.b.a.f(3, this.waE);
            }
            AppMethodBeat.o(93800);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.key == null) {
                bVar = new b("Not all required fields were included: key");
                AppMethodBeat.o(93800);
                throw bVar;
            }
            AppMethodBeat.o(93800);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cml cml = (cml) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cml.key = aVar3.BTU.readString();
                    AppMethodBeat.o(93800);
                    return 0;
                case 2:
                    cml.waD = aVar3.BTU.ve();
                    AppMethodBeat.o(93800);
                    return 0;
                case 3:
                    cml.waE = aVar3.BTU.readString();
                    AppMethodBeat.o(93800);
                    return 0;
                default:
                    AppMethodBeat.o(93800);
                    return -1;
            }
        } else {
            AppMethodBeat.o(93800);
            return -1;
        }
    }
}
