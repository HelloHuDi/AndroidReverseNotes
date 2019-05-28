package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class ai extends a {
    public String Desc;
    public String mZj;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111575);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Desc == null) {
                bVar = new b("Not all required fields were included: Desc");
                AppMethodBeat.o(111575);
                throw bVar;
            }
            if (this.Desc != null) {
                aVar.e(1, this.Desc);
            }
            if (this.mZj != null) {
                aVar.e(2, this.mZj);
            }
            AppMethodBeat.o(111575);
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
            AppMethodBeat.o(111575);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.Desc == null) {
                bVar = new b("Not all required fields were included: Desc");
                AppMethodBeat.o(111575);
                throw bVar;
            }
            AppMethodBeat.o(111575);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ai aiVar = (ai) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aiVar.Desc = aVar3.BTU.readString();
                    AppMethodBeat.o(111575);
                    return 0;
                case 2:
                    aiVar.mZj = aVar3.BTU.readString();
                    AppMethodBeat.o(111575);
                    return 0;
                default:
                    AppMethodBeat.o(111575);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111575);
            return -1;
        }
    }
}
