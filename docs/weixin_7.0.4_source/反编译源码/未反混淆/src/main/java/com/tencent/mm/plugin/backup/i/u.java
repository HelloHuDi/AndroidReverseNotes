package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class u extends a {
    public String cHr;
    public String dJC;
    public int jCp;
    public int jCq;
    public long jCr;
    public String path;
    public int type;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(18069);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.jCp);
            if (this.dJC != null) {
                aVar.e(2, this.dJC);
            }
            if (this.cHr != null) {
                aVar.e(3, this.cHr);
            }
            if (this.path != null) {
                aVar.e(4, this.path);
            }
            aVar.iz(5, this.type);
            aVar.iz(6, this.jCq);
            aVar.ai(7, this.jCr);
            AppMethodBeat.o(18069);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.jCp) + 0;
            if (this.dJC != null) {
                bs += e.a.a.b.b.a.f(2, this.dJC);
            }
            if (this.cHr != null) {
                bs += e.a.a.b.b.a.f(3, this.cHr);
            }
            if (this.path != null) {
                bs += e.a.a.b.b.a.f(4, this.path);
            }
            bs = ((bs + e.a.a.b.b.a.bs(5, this.type)) + e.a.a.b.b.a.bs(6, this.jCq)) + e.a.a.b.b.a.o(7, this.jCr);
            AppMethodBeat.o(18069);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(18069);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            u uVar = (u) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    uVar.jCp = aVar3.BTU.vd();
                    AppMethodBeat.o(18069);
                    return 0;
                case 2:
                    uVar.dJC = aVar3.BTU.readString();
                    AppMethodBeat.o(18069);
                    return 0;
                case 3:
                    uVar.cHr = aVar3.BTU.readString();
                    AppMethodBeat.o(18069);
                    return 0;
                case 4:
                    uVar.path = aVar3.BTU.readString();
                    AppMethodBeat.o(18069);
                    return 0;
                case 5:
                    uVar.type = aVar3.BTU.vd();
                    AppMethodBeat.o(18069);
                    return 0;
                case 6:
                    uVar.jCq = aVar3.BTU.vd();
                    AppMethodBeat.o(18069);
                    return 0;
                case 7:
                    uVar.jCr = aVar3.BTU.ve();
                    AppMethodBeat.o(18069);
                    return 0;
                default:
                    AppMethodBeat.o(18069);
                    return -1;
            }
        } else {
            AppMethodBeat.o(18069);
            return -1;
        }
    }
}
