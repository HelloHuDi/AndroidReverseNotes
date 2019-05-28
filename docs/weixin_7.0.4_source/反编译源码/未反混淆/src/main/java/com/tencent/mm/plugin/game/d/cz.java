package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cz extends a {
    public String IconUrl;
    public String mZj;
    public String ndw;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111667);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ndw != null) {
                aVar.e(1, this.ndw);
            }
            if (this.IconUrl != null) {
                aVar.e(2, this.IconUrl);
            }
            if (this.mZj != null) {
                aVar.e(3, this.mZj);
            }
            AppMethodBeat.o(111667);
            return 0;
        } else if (i == 1) {
            if (this.ndw != null) {
                f = e.a.a.b.b.a.f(1, this.ndw) + 0;
            } else {
                f = 0;
            }
            if (this.IconUrl != null) {
                f += e.a.a.b.b.a.f(2, this.IconUrl);
            }
            if (this.mZj != null) {
                f += e.a.a.b.b.a.f(3, this.mZj);
            }
            AppMethodBeat.o(111667);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111667);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cz czVar = (cz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    czVar.ndw = aVar3.BTU.readString();
                    AppMethodBeat.o(111667);
                    return 0;
                case 2:
                    czVar.IconUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(111667);
                    return 0;
                case 3:
                    czVar.mZj = aVar3.BTU.readString();
                    AppMethodBeat.o(111667);
                    return 0;
                default:
                    AppMethodBeat.o(111667);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111667);
            return -1;
        }
    }
}
