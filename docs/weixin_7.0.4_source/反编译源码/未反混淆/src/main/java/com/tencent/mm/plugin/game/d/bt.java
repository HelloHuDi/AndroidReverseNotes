package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class bt extends a {
    public String Title;
    public String mZm;
    public String naq;
    public String ncC;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111626);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ncC == null) {
                bVar = new b("Not all required fields were included: LogoURL");
                AppMethodBeat.o(111626);
                throw bVar;
            } else if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(111626);
                throw bVar;
            } else if (this.naq == null) {
                bVar = new b("Not all required fields were included: Detail");
                AppMethodBeat.o(111626);
                throw bVar;
            } else if (this.mZm == null) {
                bVar = new b("Not all required fields were included: WebURL");
                AppMethodBeat.o(111626);
                throw bVar;
            } else {
                if (this.ncC != null) {
                    aVar.e(1, this.ncC);
                }
                if (this.Title != null) {
                    aVar.e(2, this.Title);
                }
                if (this.naq != null) {
                    aVar.e(3, this.naq);
                }
                if (this.mZm != null) {
                    aVar.e(4, this.mZm);
                }
                AppMethodBeat.o(111626);
                return 0;
            }
        } else if (i == 1) {
            if (this.ncC != null) {
                f = e.a.a.b.b.a.f(1, this.ncC) + 0;
            } else {
                f = 0;
            }
            if (this.Title != null) {
                f += e.a.a.b.b.a.f(2, this.Title);
            }
            if (this.naq != null) {
                f += e.a.a.b.b.a.f(3, this.naq);
            }
            if (this.mZm != null) {
                f += e.a.a.b.b.a.f(4, this.mZm);
            }
            AppMethodBeat.o(111626);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.ncC == null) {
                bVar = new b("Not all required fields were included: LogoURL");
                AppMethodBeat.o(111626);
                throw bVar;
            } else if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(111626);
                throw bVar;
            } else if (this.naq == null) {
                bVar = new b("Not all required fields were included: Detail");
                AppMethodBeat.o(111626);
                throw bVar;
            } else if (this.mZm == null) {
                bVar = new b("Not all required fields were included: WebURL");
                AppMethodBeat.o(111626);
                throw bVar;
            } else {
                AppMethodBeat.o(111626);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bt btVar = (bt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    btVar.ncC = aVar3.BTU.readString();
                    AppMethodBeat.o(111626);
                    return 0;
                case 2:
                    btVar.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(111626);
                    return 0;
                case 3:
                    btVar.naq = aVar3.BTU.readString();
                    AppMethodBeat.o(111626);
                    return 0;
                case 4:
                    btVar.mZm = aVar3.BTU.readString();
                    AppMethodBeat.o(111626);
                    return 0;
                default:
                    AppMethodBeat.o(111626);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111626);
            return -1;
        }
    }
}
