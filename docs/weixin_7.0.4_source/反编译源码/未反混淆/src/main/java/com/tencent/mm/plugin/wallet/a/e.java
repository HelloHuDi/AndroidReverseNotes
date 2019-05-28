package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class e extends a {
    public String fjD;
    public String name;
    public String tmN;
    public String url;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56646);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.url != null) {
                aVar.e(1, this.url);
            }
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            if (this.tmN != null) {
                aVar.e(3, this.tmN);
            }
            if (this.fjD != null) {
                aVar.e(4, this.fjD);
            }
            AppMethodBeat.o(56646);
            return 0;
        } else if (i == 1) {
            if (this.url != null) {
                f = e.a.a.b.b.a.f(1, this.url) + 0;
            } else {
                f = 0;
            }
            if (this.name != null) {
                f += e.a.a.b.b.a.f(2, this.name);
            }
            if (this.tmN != null) {
                f += e.a.a.b.b.a.f(3, this.tmN);
            }
            if (this.fjD != null) {
                f += e.a.a.b.b.a.f(4, this.fjD);
            }
            AppMethodBeat.o(56646);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56646);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eVar.url = aVar3.BTU.readString();
                    AppMethodBeat.o(56646);
                    return 0;
                case 2:
                    eVar.name = aVar3.BTU.readString();
                    AppMethodBeat.o(56646);
                    return 0;
                case 3:
                    eVar.tmN = aVar3.BTU.readString();
                    AppMethodBeat.o(56646);
                    return 0;
                case 4:
                    eVar.fjD = aVar3.BTU.readString();
                    AppMethodBeat.o(56646);
                    return 0;
                default:
                    AppMethodBeat.o(56646);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56646);
            return -1;
        }
    }
}
