package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class cux extends a {
    public b vHn;
    public int wdn;
    public String wyw;
    public boolean xqX;
    public boolean xqY;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28765);
        e.a.a.b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wyw == null) {
                bVar = new e.a.a.b("Not all required fields were included: Talker");
                AppMethodBeat.o(28765);
                throw bVar;
            }
            if (this.wyw != null) {
                aVar.e(1, this.wyw);
            }
            aVar.iz(2, this.wdn);
            if (this.vHn != null) {
                aVar.c(3, this.vHn);
            }
            aVar.aO(4, this.xqX);
            aVar.aO(5, this.xqY);
            AppMethodBeat.o(28765);
            return 0;
        } else if (i == 1) {
            if (this.wyw != null) {
                f = e.a.a.b.b.a.f(1, this.wyw) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.wdn);
            if (this.vHn != null) {
                f += e.a.a.b.b.a.b(3, this.vHn);
            }
            int fv = (f + (e.a.a.b.b.a.fv(4) + 1)) + (e.a.a.b.b.a.fv(5) + 1);
            AppMethodBeat.o(28765);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.wyw == null) {
                bVar = new e.a.a.b("Not all required fields were included: Talker");
                AppMethodBeat.o(28765);
                throw bVar;
            }
            AppMethodBeat.o(28765);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cux cux = (cux) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cux.wyw = aVar3.BTU.readString();
                    AppMethodBeat.o(28765);
                    return 0;
                case 2:
                    cux.wdn = aVar3.BTU.vd();
                    AppMethodBeat.o(28765);
                    return 0;
                case 3:
                    cux.vHn = aVar3.BTU.emu();
                    AppMethodBeat.o(28765);
                    return 0;
                case 4:
                    cux.xqX = aVar3.BTU.ehX();
                    AppMethodBeat.o(28765);
                    return 0;
                case 5:
                    cux.xqY = aVar3.BTU.ehX();
                    AppMethodBeat.o(28765);
                    return 0;
                default:
                    AppMethodBeat.o(28765);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28765);
            return -1;
        }
    }
}
