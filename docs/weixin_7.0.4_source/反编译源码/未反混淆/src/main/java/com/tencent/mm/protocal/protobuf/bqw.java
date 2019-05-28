package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bqw extends a {
    public String jCH;
    public String luP;
    public String wGk;
    public String wTj;
    public String wTk;
    public String wTl;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(123515);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.jCH != null) {
                aVar.e(1, this.jCH);
            }
            if (this.wTj != null) {
                aVar.e(2, this.wTj);
            }
            if (this.wGk != null) {
                aVar.e(3, this.wGk);
            }
            if (this.wTk != null) {
                aVar.e(4, this.wTk);
            }
            if (this.luP != null) {
                aVar.e(5, this.luP);
            }
            if (this.wTl != null) {
                aVar.e(6, this.wTl);
            }
            AppMethodBeat.o(123515);
            return 0;
        } else if (i == 1) {
            if (this.jCH != null) {
                f = e.a.a.b.b.a.f(1, this.jCH) + 0;
            } else {
                f = 0;
            }
            if (this.wTj != null) {
                f += e.a.a.b.b.a.f(2, this.wTj);
            }
            if (this.wGk != null) {
                f += e.a.a.b.b.a.f(3, this.wGk);
            }
            if (this.wTk != null) {
                f += e.a.a.b.b.a.f(4, this.wTk);
            }
            if (this.luP != null) {
                f += e.a.a.b.b.a.f(5, this.luP);
            }
            if (this.wTl != null) {
                f += e.a.a.b.b.a.f(6, this.wTl);
            }
            AppMethodBeat.o(123515);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(123515);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bqw bqw = (bqw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bqw.jCH = aVar3.BTU.readString();
                    AppMethodBeat.o(123515);
                    return 0;
                case 2:
                    bqw.wTj = aVar3.BTU.readString();
                    AppMethodBeat.o(123515);
                    return 0;
                case 3:
                    bqw.wGk = aVar3.BTU.readString();
                    AppMethodBeat.o(123515);
                    return 0;
                case 4:
                    bqw.wTk = aVar3.BTU.readString();
                    AppMethodBeat.o(123515);
                    return 0;
                case 5:
                    bqw.luP = aVar3.BTU.readString();
                    AppMethodBeat.o(123515);
                    return 0;
                case 6:
                    bqw.wTl = aVar3.BTU.readString();
                    AppMethodBeat.o(123515);
                    return 0;
                default:
                    AppMethodBeat.o(123515);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123515);
            return -1;
        }
    }
}
