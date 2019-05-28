package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class l extends a {
    public String Name;
    public int mZU;
    public String mZm;
    public String mZs;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111552);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Name == null) {
                bVar = new b("Not all required fields were included: Name");
                AppMethodBeat.o(111552);
                throw bVar;
            } else if (this.mZs == null) {
                bVar = new b("Not all required fields were included: IconURL");
                AppMethodBeat.o(111552);
                throw bVar;
            } else {
                aVar.iz(1, this.mZU);
                if (this.Name != null) {
                    aVar.e(2, this.Name);
                }
                if (this.mZs != null) {
                    aVar.e(3, this.mZs);
                }
                if (this.mZm != null) {
                    aVar.e(4, this.mZm);
                }
                AppMethodBeat.o(111552);
                return 0;
            }
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.mZU) + 0;
            if (this.Name != null) {
                bs += e.a.a.b.b.a.f(2, this.Name);
            }
            if (this.mZs != null) {
                bs += e.a.a.b.b.a.f(3, this.mZs);
            }
            if (this.mZm != null) {
                bs += e.a.a.b.b.a.f(4, this.mZm);
            }
            AppMethodBeat.o(111552);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.Name == null) {
                bVar = new b("Not all required fields were included: Name");
                AppMethodBeat.o(111552);
                throw bVar;
            } else if (this.mZs == null) {
                bVar = new b("Not all required fields were included: IconURL");
                AppMethodBeat.o(111552);
                throw bVar;
            } else {
                AppMethodBeat.o(111552);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    lVar.mZU = aVar3.BTU.vd();
                    AppMethodBeat.o(111552);
                    return 0;
                case 2:
                    lVar.Name = aVar3.BTU.readString();
                    AppMethodBeat.o(111552);
                    return 0;
                case 3:
                    lVar.mZs = aVar3.BTU.readString();
                    AppMethodBeat.o(111552);
                    return 0;
                case 4:
                    lVar.mZm = aVar3.BTU.readString();
                    AppMethodBeat.o(111552);
                    return 0;
                default:
                    AppMethodBeat.o(111552);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111552);
            return -1;
        }
    }
}
