package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class x extends a {
    public String Name;
    public String mZW;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111561);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.mZW != null) {
                aVar.e(1, this.mZW);
            }
            if (this.Name != null) {
                aVar.e(2, this.Name);
            }
            AppMethodBeat.o(111561);
            return 0;
        } else if (i == 1) {
            if (this.mZW != null) {
                f = e.a.a.b.b.a.f(1, this.mZW) + 0;
            } else {
                f = 0;
            }
            if (this.Name != null) {
                f += e.a.a.b.b.a.f(2, this.Name);
            }
            AppMethodBeat.o(111561);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111561);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            x xVar = (x) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    xVar.mZW = aVar3.BTU.readString();
                    AppMethodBeat.o(111561);
                    return 0;
                case 2:
                    xVar.Name = aVar3.BTU.readString();
                    AppMethodBeat.o(111561);
                    return 0;
                default:
                    AppMethodBeat.o(111561);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111561);
            return -1;
        }
    }
}
