package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class cuy extends a {
    public int vAS;
    public String wdK;
    public String wyw;
    public boolean xqZ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28766);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wyw == null) {
                bVar = new b("Not all required fields were included: Talker");
                AppMethodBeat.o(28766);
                throw bVar;
            } else if (this.wdK == null) {
                bVar = new b("Not all required fields were included: Text");
                AppMethodBeat.o(28766);
                throw bVar;
            } else {
                if (this.wyw != null) {
                    aVar.e(1, this.wyw);
                }
                if (this.wdK != null) {
                    aVar.e(2, this.wdK);
                }
                aVar.aO(3, this.xqZ);
                aVar.iz(4, this.vAS);
                AppMethodBeat.o(28766);
                return 0;
            }
        } else if (i == 1) {
            if (this.wyw != null) {
                f = e.a.a.b.b.a.f(1, this.wyw) + 0;
            } else {
                f = 0;
            }
            if (this.wdK != null) {
                f += e.a.a.b.b.a.f(2, this.wdK);
            }
            int fv = (f + (e.a.a.b.b.a.fv(3) + 1)) + e.a.a.b.b.a.bs(4, this.vAS);
            AppMethodBeat.o(28766);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.wyw == null) {
                bVar = new b("Not all required fields were included: Talker");
                AppMethodBeat.o(28766);
                throw bVar;
            } else if (this.wdK == null) {
                bVar = new b("Not all required fields were included: Text");
                AppMethodBeat.o(28766);
                throw bVar;
            } else {
                AppMethodBeat.o(28766);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cuy cuy = (cuy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cuy.wyw = aVar3.BTU.readString();
                    AppMethodBeat.o(28766);
                    return 0;
                case 2:
                    cuy.wdK = aVar3.BTU.readString();
                    AppMethodBeat.o(28766);
                    return 0;
                case 3:
                    cuy.xqZ = aVar3.BTU.ehX();
                    AppMethodBeat.o(28766);
                    return 0;
                case 4:
                    cuy.vAS = aVar3.BTU.vd();
                    AppMethodBeat.o(28766);
                    return 0;
                default:
                    AppMethodBeat.o(28766);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28766);
            return -1;
        }
    }
}
