package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class cx extends a {
    public String Desc;
    public String Title;
    public String fKh;
    public String mZL;
    public String mZi;
    public String mZj;
    public String ncH;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111664);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ncH == null) {
                bVar = new b("Not all required fields were included: AppName");
                AppMethodBeat.o(111664);
                throw bVar;
            }
            if (this.ncH != null) {
                aVar.e(1, this.ncH);
            }
            if (this.mZi != null) {
                aVar.e(2, this.mZi);
            }
            if (this.Title != null) {
                aVar.e(3, this.Title);
            }
            if (this.Desc != null) {
                aVar.e(4, this.Desc);
            }
            if (this.mZL != null) {
                aVar.e(5, this.mZL);
            }
            if (this.mZj != null) {
                aVar.e(6, this.mZj);
            }
            if (this.fKh != null) {
                aVar.e(7, this.fKh);
            }
            AppMethodBeat.o(111664);
            return 0;
        } else if (i == 1) {
            if (this.ncH != null) {
                f = e.a.a.b.b.a.f(1, this.ncH) + 0;
            } else {
                f = 0;
            }
            if (this.mZi != null) {
                f += e.a.a.b.b.a.f(2, this.mZi);
            }
            if (this.Title != null) {
                f += e.a.a.b.b.a.f(3, this.Title);
            }
            if (this.Desc != null) {
                f += e.a.a.b.b.a.f(4, this.Desc);
            }
            if (this.mZL != null) {
                f += e.a.a.b.b.a.f(5, this.mZL);
            }
            if (this.mZj != null) {
                f += e.a.a.b.b.a.f(6, this.mZj);
            }
            if (this.fKh != null) {
                f += e.a.a.b.b.a.f(7, this.fKh);
            }
            AppMethodBeat.o(111664);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.ncH == null) {
                bVar = new b("Not all required fields were included: AppName");
                AppMethodBeat.o(111664);
                throw bVar;
            }
            AppMethodBeat.o(111664);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cx cxVar = (cx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cxVar.ncH = aVar3.BTU.readString();
                    AppMethodBeat.o(111664);
                    return 0;
                case 2:
                    cxVar.mZi = aVar3.BTU.readString();
                    AppMethodBeat.o(111664);
                    return 0;
                case 3:
                    cxVar.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(111664);
                    return 0;
                case 4:
                    cxVar.Desc = aVar3.BTU.readString();
                    AppMethodBeat.o(111664);
                    return 0;
                case 5:
                    cxVar.mZL = aVar3.BTU.readString();
                    AppMethodBeat.o(111664);
                    return 0;
                case 6:
                    cxVar.mZj = aVar3.BTU.readString();
                    AppMethodBeat.o(111664);
                    return 0;
                case 7:
                    cxVar.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(111664);
                    return 0;
                default:
                    AppMethodBeat.o(111664);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111664);
            return -1;
        }
    }
}
