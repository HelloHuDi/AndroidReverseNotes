package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class cg extends a {
    public String Name;
    public String ncT;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111643);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Name == null) {
                bVar = new b("Not all required fields were included: Name");
                AppMethodBeat.o(111643);
                throw bVar;
            } else if (this.ncT == null) {
                bVar = new b("Not all required fields were included: Color");
                AppMethodBeat.o(111643);
                throw bVar;
            } else {
                if (this.Name != null) {
                    aVar.e(1, this.Name);
                }
                if (this.ncT != null) {
                    aVar.e(2, this.ncT);
                }
                AppMethodBeat.o(111643);
                return 0;
            }
        } else if (i == 1) {
            if (this.Name != null) {
                f = e.a.a.b.b.a.f(1, this.Name) + 0;
            } else {
                f = 0;
            }
            if (this.ncT != null) {
                f += e.a.a.b.b.a.f(2, this.ncT);
            }
            AppMethodBeat.o(111643);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.Name == null) {
                bVar = new b("Not all required fields were included: Name");
                AppMethodBeat.o(111643);
                throw bVar;
            } else if (this.ncT == null) {
                bVar = new b("Not all required fields were included: Color");
                AppMethodBeat.o(111643);
                throw bVar;
            } else {
                AppMethodBeat.o(111643);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cg cgVar = (cg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cgVar.Name = aVar3.BTU.readString();
                    AppMethodBeat.o(111643);
                    return 0;
                case 2:
                    cgVar.ncT = aVar3.BTU.readString();
                    AppMethodBeat.o(111643);
                    return 0;
                default:
                    AppMethodBeat.o(111643);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111643);
            return -1;
        }
    }
}
