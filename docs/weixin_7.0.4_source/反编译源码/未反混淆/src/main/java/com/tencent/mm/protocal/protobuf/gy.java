package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class gy extends a {
    public String title;
    public int ttd;
    public String tte;
    public String ttg;
    public String tzW;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56707);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            aVar.iz(2, this.ttd);
            if (this.tte != null) {
                aVar.e(3, this.tte);
            }
            if (this.tzW != null) {
                aVar.e(4, this.tzW);
            }
            if (this.ttg != null) {
                aVar.e(5, this.ttg);
            }
            AppMethodBeat.o(56707);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = e.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.ttd);
            if (this.tte != null) {
                f += e.a.a.b.b.a.f(3, this.tte);
            }
            if (this.tzW != null) {
                f += e.a.a.b.b.a.f(4, this.tzW);
            }
            if (this.ttg != null) {
                f += e.a.a.b.b.a.f(5, this.ttg);
            }
            AppMethodBeat.o(56707);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56707);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            gy gyVar = (gy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gyVar.title = aVar3.BTU.readString();
                    AppMethodBeat.o(56707);
                    return 0;
                case 2:
                    gyVar.ttd = aVar3.BTU.vd();
                    AppMethodBeat.o(56707);
                    return 0;
                case 3:
                    gyVar.tte = aVar3.BTU.readString();
                    AppMethodBeat.o(56707);
                    return 0;
                case 4:
                    gyVar.tzW = aVar3.BTU.readString();
                    AppMethodBeat.o(56707);
                    return 0;
                case 5:
                    gyVar.ttg = aVar3.BTU.readString();
                    AppMethodBeat.o(56707);
                    return 0;
                default:
                    AppMethodBeat.o(56707);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56707);
            return -1;
        }
    }
}
