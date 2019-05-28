package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class j extends a {
    public String Desc;
    public String IconUrl;
    public String Title;
    public String mZL;
    public int mZN;
    public String mZj;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111550);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.IconUrl == null) {
                bVar = new b("Not all required fields were included: IconUrl");
                AppMethodBeat.o(111550);
                throw bVar;
            } else if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(111550);
                throw bVar;
            } else if (this.mZj == null) {
                bVar = new b("Not all required fields were included: JumpUrl");
                AppMethodBeat.o(111550);
                throw bVar;
            } else {
                if (this.IconUrl != null) {
                    aVar.e(1, this.IconUrl);
                }
                if (this.Title != null) {
                    aVar.e(2, this.Title);
                }
                if (this.Desc != null) {
                    aVar.e(3, this.Desc);
                }
                if (this.mZj != null) {
                    aVar.e(4, this.mZj);
                }
                aVar.iz(5, this.mZN);
                if (this.mZL != null) {
                    aVar.e(6, this.mZL);
                }
                AppMethodBeat.o(111550);
                return 0;
            }
        } else if (i == 1) {
            if (this.IconUrl != null) {
                f = e.a.a.b.b.a.f(1, this.IconUrl) + 0;
            } else {
                f = 0;
            }
            if (this.Title != null) {
                f += e.a.a.b.b.a.f(2, this.Title);
            }
            if (this.Desc != null) {
                f += e.a.a.b.b.a.f(3, this.Desc);
            }
            if (this.mZj != null) {
                f += e.a.a.b.b.a.f(4, this.mZj);
            }
            f += e.a.a.b.b.a.bs(5, this.mZN);
            if (this.mZL != null) {
                f += e.a.a.b.b.a.f(6, this.mZL);
            }
            AppMethodBeat.o(111550);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.IconUrl == null) {
                bVar = new b("Not all required fields were included: IconUrl");
                AppMethodBeat.o(111550);
                throw bVar;
            } else if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(111550);
                throw bVar;
            } else if (this.mZj == null) {
                bVar = new b("Not all required fields were included: JumpUrl");
                AppMethodBeat.o(111550);
                throw bVar;
            } else {
                AppMethodBeat.o(111550);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            j jVar = (j) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jVar.IconUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(111550);
                    return 0;
                case 2:
                    jVar.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(111550);
                    return 0;
                case 3:
                    jVar.Desc = aVar3.BTU.readString();
                    AppMethodBeat.o(111550);
                    return 0;
                case 4:
                    jVar.mZj = aVar3.BTU.readString();
                    AppMethodBeat.o(111550);
                    return 0;
                case 5:
                    jVar.mZN = aVar3.BTU.vd();
                    AppMethodBeat.o(111550);
                    return 0;
                case 6:
                    jVar.mZL = aVar3.BTU.readString();
                    AppMethodBeat.o(111550);
                    return 0;
                default:
                    AppMethodBeat.o(111550);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111550);
            return -1;
        }
    }
}
