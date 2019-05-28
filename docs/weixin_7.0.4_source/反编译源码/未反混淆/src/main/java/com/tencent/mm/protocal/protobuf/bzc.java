package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bzc extends a {
    public String Title;
    public String URL;
    public String ndb;
    public String vEA;
    public String wdO;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28653);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.URL != null) {
                aVar.e(1, this.URL);
            }
            if (this.Title != null) {
                aVar.e(2, this.Title);
            }
            if (this.vEA != null) {
                aVar.e(3, this.vEA);
            }
            if (this.ndb != null) {
                aVar.e(4, this.ndb);
            }
            if (this.wdO != null) {
                aVar.e(5, this.wdO);
            }
            AppMethodBeat.o(28653);
            return 0;
        } else if (i == 1) {
            if (this.URL != null) {
                f = e.a.a.b.b.a.f(1, this.URL) + 0;
            } else {
                f = 0;
            }
            if (this.Title != null) {
                f += e.a.a.b.b.a.f(2, this.Title);
            }
            if (this.vEA != null) {
                f += e.a.a.b.b.a.f(3, this.vEA);
            }
            if (this.ndb != null) {
                f += e.a.a.b.b.a.f(4, this.ndb);
            }
            if (this.wdO != null) {
                f += e.a.a.b.b.a.f(5, this.wdO);
            }
            AppMethodBeat.o(28653);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28653);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bzc bzc = (bzc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bzc.URL = aVar3.BTU.readString();
                    AppMethodBeat.o(28653);
                    return 0;
                case 2:
                    bzc.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(28653);
                    return 0;
                case 3:
                    bzc.vEA = aVar3.BTU.readString();
                    AppMethodBeat.o(28653);
                    return 0;
                case 4:
                    bzc.ndb = aVar3.BTU.readString();
                    AppMethodBeat.o(28653);
                    return 0;
                case 5:
                    bzc.wdO = aVar3.BTU.readString();
                    AppMethodBeat.o(28653);
                    return 0;
                default:
                    AppMethodBeat.o(28653);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28653);
            return -1;
        }
    }
}
