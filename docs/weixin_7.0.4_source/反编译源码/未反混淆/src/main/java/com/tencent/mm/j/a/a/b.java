package com.tencent.mm.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class b extends a {
    public int eoA;
    public String eoB;
    public String eoz;
    public String userName;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(59616);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.userName != null) {
                aVar.e(1, this.userName);
            }
            if (this.eoz != null) {
                aVar.e(2, this.eoz);
            }
            aVar.iz(3, this.eoA);
            if (this.eoB != null) {
                aVar.e(4, this.eoB);
            }
            AppMethodBeat.o(59616);
            return 0;
        } else if (i == 1) {
            if (this.userName != null) {
                f = e.a.a.b.b.a.f(1, this.userName) + 0;
            } else {
                f = 0;
            }
            if (this.eoz != null) {
                f += e.a.a.b.b.a.f(2, this.eoz);
            }
            f += e.a.a.b.b.a.bs(3, this.eoA);
            if (this.eoB != null) {
                f += e.a.a.b.b.a.f(4, this.eoB);
            }
            AppMethodBeat.o(59616);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(59616);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.userName = aVar3.BTU.readString();
                    AppMethodBeat.o(59616);
                    return 0;
                case 2:
                    bVar.eoz = aVar3.BTU.readString();
                    AppMethodBeat.o(59616);
                    return 0;
                case 3:
                    bVar.eoA = aVar3.BTU.vd();
                    AppMethodBeat.o(59616);
                    return 0;
                case 4:
                    bVar.eoB = aVar3.BTU.readString();
                    AppMethodBeat.o(59616);
                    return 0;
                default:
                    AppMethodBeat.o(59616);
                    return -1;
            }
        } else {
            AppMethodBeat.o(59616);
            return -1;
        }
    }
}
