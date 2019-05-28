package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cn extends a {
    public String Desc;
    public String mZj;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111651);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Desc != null) {
                aVar.e(1, this.Desc);
            }
            if (this.mZj != null) {
                aVar.e(2, this.mZj);
            }
            AppMethodBeat.o(111651);
            return 0;
        } else if (i == 1) {
            if (this.Desc != null) {
                f = e.a.a.b.b.a.f(1, this.Desc) + 0;
            } else {
                f = 0;
            }
            if (this.mZj != null) {
                f += e.a.a.b.b.a.f(2, this.mZj);
            }
            AppMethodBeat.o(111651);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111651);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cn cnVar = (cn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cnVar.Desc = aVar3.BTU.readString();
                    AppMethodBeat.o(111651);
                    return 0;
                case 2:
                    cnVar.mZj = aVar3.BTU.readString();
                    AppMethodBeat.o(111651);
                    return 0;
                default:
                    AppMethodBeat.o(111651);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111651);
            return -1;
        }
    }
}
