package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class k extends a {
    public String Url;
    public String mZR;
    public String mZS;
    public String mZT;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111551);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.mZR == null) {
                bVar = new b("Not all required fields were included: Message");
                AppMethodBeat.o(111551);
                throw bVar;
            } else if (this.mZS == null) {
                bVar = new b("Not all required fields were included: GotoBtn");
                AppMethodBeat.o(111551);
                throw bVar;
            } else if (this.mZT == null) {
                bVar = new b("Not all required fields were included: CancelBtn");
                AppMethodBeat.o(111551);
                throw bVar;
            } else if (this.Url == null) {
                bVar = new b("Not all required fields were included: Url");
                AppMethodBeat.o(111551);
                throw bVar;
            } else {
                if (this.mZR != null) {
                    aVar.e(1, this.mZR);
                }
                if (this.mZS != null) {
                    aVar.e(2, this.mZS);
                }
                if (this.mZT != null) {
                    aVar.e(3, this.mZT);
                }
                if (this.Url != null) {
                    aVar.e(4, this.Url);
                }
                AppMethodBeat.o(111551);
                return 0;
            }
        } else if (i == 1) {
            if (this.mZR != null) {
                f = e.a.a.b.b.a.f(1, this.mZR) + 0;
            } else {
                f = 0;
            }
            if (this.mZS != null) {
                f += e.a.a.b.b.a.f(2, this.mZS);
            }
            if (this.mZT != null) {
                f += e.a.a.b.b.a.f(3, this.mZT);
            }
            if (this.Url != null) {
                f += e.a.a.b.b.a.f(4, this.Url);
            }
            AppMethodBeat.o(111551);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.mZR == null) {
                bVar = new b("Not all required fields were included: Message");
                AppMethodBeat.o(111551);
                throw bVar;
            } else if (this.mZS == null) {
                bVar = new b("Not all required fields were included: GotoBtn");
                AppMethodBeat.o(111551);
                throw bVar;
            } else if (this.mZT == null) {
                bVar = new b("Not all required fields were included: CancelBtn");
                AppMethodBeat.o(111551);
                throw bVar;
            } else if (this.Url == null) {
                bVar = new b("Not all required fields were included: Url");
                AppMethodBeat.o(111551);
                throw bVar;
            } else {
                AppMethodBeat.o(111551);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            k kVar = (k) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kVar.mZR = aVar3.BTU.readString();
                    AppMethodBeat.o(111551);
                    return 0;
                case 2:
                    kVar.mZS = aVar3.BTU.readString();
                    AppMethodBeat.o(111551);
                    return 0;
                case 3:
                    kVar.mZT = aVar3.BTU.readString();
                    AppMethodBeat.o(111551);
                    return 0;
                case 4:
                    kVar.Url = aVar3.BTU.readString();
                    AppMethodBeat.o(111551);
                    return 0;
                default:
                    AppMethodBeat.o(111551);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111551);
            return -1;
        }
    }
}
