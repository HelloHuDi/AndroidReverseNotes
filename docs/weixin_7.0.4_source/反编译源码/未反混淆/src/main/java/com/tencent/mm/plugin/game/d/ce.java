package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class ce extends a {
    public String Title;
    public String mZm;
    public String mZs;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111640);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.mZs == null) {
                bVar = new b("Not all required fields were included: IconURL");
                AppMethodBeat.o(111640);
                throw bVar;
            }
            if (this.mZs != null) {
                aVar.e(1, this.mZs);
            }
            if (this.Title != null) {
                aVar.e(2, this.Title);
            }
            if (this.mZm != null) {
                aVar.e(3, this.mZm);
            }
            AppMethodBeat.o(111640);
            return 0;
        } else if (i == 1) {
            if (this.mZs != null) {
                f = e.a.a.b.b.a.f(1, this.mZs) + 0;
            } else {
                f = 0;
            }
            if (this.Title != null) {
                f += e.a.a.b.b.a.f(2, this.Title);
            }
            if (this.mZm != null) {
                f += e.a.a.b.b.a.f(3, this.mZm);
            }
            AppMethodBeat.o(111640);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.mZs == null) {
                bVar = new b("Not all required fields were included: IconURL");
                AppMethodBeat.o(111640);
                throw bVar;
            }
            AppMethodBeat.o(111640);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ce ceVar = (ce) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ceVar.mZs = aVar3.BTU.readString();
                    AppMethodBeat.o(111640);
                    return 0;
                case 2:
                    ceVar.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(111640);
                    return 0;
                case 3:
                    ceVar.mZm = aVar3.BTU.readString();
                    AppMethodBeat.o(111640);
                    return 0;
                default:
                    AppMethodBeat.o(111640);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111640);
            return -1;
        }
    }
}
