package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class cu extends a {
    public String mZV;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(117001);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.mZV == null) {
                bVar = new b("Not all required fields were included: PkgId");
                AppMethodBeat.o(117001);
                throw bVar;
            }
            if (this.mZV != null) {
                aVar.e(1, this.mZV);
            }
            AppMethodBeat.o(117001);
            return 0;
        } else if (i == 1) {
            if (this.mZV != null) {
                f = e.a.a.b.b.a.f(1, this.mZV) + 0;
            } else {
                f = 0;
            }
            AppMethodBeat.o(117001);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.mZV == null) {
                bVar = new b("Not all required fields were included: PkgId");
                AppMethodBeat.o(117001);
                throw bVar;
            }
            AppMethodBeat.o(117001);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cu cuVar = (cu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cuVar.mZV = aVar3.BTU.readString();
                    AppMethodBeat.o(117001);
                    return 0;
                default:
                    AppMethodBeat.o(117001);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117001);
            return -1;
        }
    }
}
