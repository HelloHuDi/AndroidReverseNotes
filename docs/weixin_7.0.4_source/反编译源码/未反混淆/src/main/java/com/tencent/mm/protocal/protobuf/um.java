package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class um extends a {
    public String tCl;
    public String twd;
    public String wca;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56768);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.twd != null) {
                aVar.e(1, this.twd);
            }
            if (this.tCl != null) {
                aVar.e(2, this.tCl);
            }
            if (this.wca != null) {
                aVar.e(3, this.wca);
            }
            AppMethodBeat.o(56768);
            return 0;
        } else if (i == 1) {
            if (this.twd != null) {
                f = e.a.a.b.b.a.f(1, this.twd) + 0;
            } else {
                f = 0;
            }
            if (this.tCl != null) {
                f += e.a.a.b.b.a.f(2, this.tCl);
            }
            if (this.wca != null) {
                f += e.a.a.b.b.a.f(3, this.wca);
            }
            AppMethodBeat.o(56768);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56768);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            um umVar = (um) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    umVar.twd = aVar3.BTU.readString();
                    AppMethodBeat.o(56768);
                    return 0;
                case 2:
                    umVar.tCl = aVar3.BTU.readString();
                    AppMethodBeat.o(56768);
                    return 0;
                case 3:
                    umVar.wca = aVar3.BTU.readString();
                    AppMethodBeat.o(56768);
                    return 0;
                default:
                    AppMethodBeat.o(56768);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56768);
            return -1;
        }
    }
}
