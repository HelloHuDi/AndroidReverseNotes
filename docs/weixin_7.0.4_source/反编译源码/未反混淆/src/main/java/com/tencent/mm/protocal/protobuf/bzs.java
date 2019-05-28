package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bzs extends a {
    public int actionType;
    public String cEh;
    public String cIY;
    public String id;
    public String jcF;
    public String title;
    public String url;
    public long wYN;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(55701);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.id != null) {
                aVar.e(1, this.id);
            }
            if (this.cEh != null) {
                aVar.e(2, this.cEh);
            }
            aVar.ai(3, this.wYN);
            aVar.iz(4, this.actionType);
            if (this.url != null) {
                aVar.e(5, this.url);
            }
            if (this.title != null) {
                aVar.e(6, this.title);
            }
            if (this.jcF != null) {
                aVar.e(7, this.jcF);
            }
            if (this.cIY != null) {
                aVar.e(8, this.cIY);
            }
            AppMethodBeat.o(55701);
            return 0;
        } else if (i == 1) {
            if (this.id != null) {
                f = e.a.a.b.b.a.f(1, this.id) + 0;
            } else {
                f = 0;
            }
            if (this.cEh != null) {
                f += e.a.a.b.b.a.f(2, this.cEh);
            }
            f = (f + e.a.a.b.b.a.o(3, this.wYN)) + e.a.a.b.b.a.bs(4, this.actionType);
            if (this.url != null) {
                f += e.a.a.b.b.a.f(5, this.url);
            }
            if (this.title != null) {
                f += e.a.a.b.b.a.f(6, this.title);
            }
            if (this.jcF != null) {
                f += e.a.a.b.b.a.f(7, this.jcF);
            }
            if (this.cIY != null) {
                f += e.a.a.b.b.a.f(8, this.cIY);
            }
            AppMethodBeat.o(55701);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(55701);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bzs bzs = (bzs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bzs.id = aVar3.BTU.readString();
                    AppMethodBeat.o(55701);
                    return 0;
                case 2:
                    bzs.cEh = aVar3.BTU.readString();
                    AppMethodBeat.o(55701);
                    return 0;
                case 3:
                    bzs.wYN = aVar3.BTU.ve();
                    AppMethodBeat.o(55701);
                    return 0;
                case 4:
                    bzs.actionType = aVar3.BTU.vd();
                    AppMethodBeat.o(55701);
                    return 0;
                case 5:
                    bzs.url = aVar3.BTU.readString();
                    AppMethodBeat.o(55701);
                    return 0;
                case 6:
                    bzs.title = aVar3.BTU.readString();
                    AppMethodBeat.o(55701);
                    return 0;
                case 7:
                    bzs.jcF = aVar3.BTU.readString();
                    AppMethodBeat.o(55701);
                    return 0;
                case 8:
                    bzs.cIY = aVar3.BTU.readString();
                    AppMethodBeat.o(55701);
                    return 0;
                default:
                    AppMethodBeat.o(55701);
                    return -1;
            }
        } else {
            AppMethodBeat.o(55701);
            return -1;
        }
    }
}
