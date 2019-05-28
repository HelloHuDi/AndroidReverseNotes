package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bks extends a {
    public String tod;
    public String wNN;
    public String wNO;
    public String wdd;
    public int wvn;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48925);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wNN != null) {
                aVar.e(1, this.wNN);
            }
            if (this.wNO != null) {
                aVar.e(2, this.wNO);
            }
            if (this.tod != null) {
                aVar.e(3, this.tod);
            }
            if (this.wdd != null) {
                aVar.e(4, this.wdd);
            }
            aVar.iz(5, this.wvn);
            AppMethodBeat.o(48925);
            return 0;
        } else if (i == 1) {
            if (this.wNN != null) {
                f = e.a.a.b.b.a.f(1, this.wNN) + 0;
            } else {
                f = 0;
            }
            if (this.wNO != null) {
                f += e.a.a.b.b.a.f(2, this.wNO);
            }
            if (this.tod != null) {
                f += e.a.a.b.b.a.f(3, this.tod);
            }
            if (this.wdd != null) {
                f += e.a.a.b.b.a.f(4, this.wdd);
            }
            int bs = f + e.a.a.b.b.a.bs(5, this.wvn);
            AppMethodBeat.o(48925);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48925);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bks bks = (bks) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bks.wNN = aVar3.BTU.readString();
                    AppMethodBeat.o(48925);
                    return 0;
                case 2:
                    bks.wNO = aVar3.BTU.readString();
                    AppMethodBeat.o(48925);
                    return 0;
                case 3:
                    bks.tod = aVar3.BTU.readString();
                    AppMethodBeat.o(48925);
                    return 0;
                case 4:
                    bks.wdd = aVar3.BTU.readString();
                    AppMethodBeat.o(48925);
                    return 0;
                case 5:
                    bks.wvn = aVar3.BTU.vd();
                    AppMethodBeat.o(48925);
                    return 0;
                default:
                    AppMethodBeat.o(48925);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48925);
            return -1;
        }
    }
}
