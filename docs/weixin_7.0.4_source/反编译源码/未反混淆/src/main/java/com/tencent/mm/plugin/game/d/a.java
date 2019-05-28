package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class a extends com.tencent.mm.bt.a {
    public String Desc;
    public String Title;
    public String mZi;
    public String mZj;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111542);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(111542);
                throw bVar;
            }
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            if (this.Desc != null) {
                aVar.e(2, this.Desc);
            }
            if (this.mZi != null) {
                aVar.e(3, this.mZi);
            }
            if (this.mZj != null) {
                aVar.e(4, this.mZj);
            }
            AppMethodBeat.o(111542);
            return 0;
        } else if (i == 1) {
            if (this.Title != null) {
                f = e.a.a.b.b.a.f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            if (this.Desc != null) {
                f += e.a.a.b.b.a.f(2, this.Desc);
            }
            if (this.mZi != null) {
                f += e.a.a.b.b.a.f(3, this.mZi);
            }
            if (this.mZj != null) {
                f += e.a.a.b.b.a.f(4, this.mZj);
            }
            AppMethodBeat.o(111542);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); f > 0; f = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(111542);
                throw bVar;
            }
            AppMethodBeat.o(111542);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(111542);
                    return 0;
                case 2:
                    aVar4.Desc = aVar3.BTU.readString();
                    AppMethodBeat.o(111542);
                    return 0;
                case 3:
                    aVar4.mZi = aVar3.BTU.readString();
                    AppMethodBeat.o(111542);
                    return 0;
                case 4:
                    aVar4.mZj = aVar3.BTU.readString();
                    AppMethodBeat.o(111542);
                    return 0;
                default:
                    AppMethodBeat.o(111542);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111542);
            return -1;
        }
    }
}
