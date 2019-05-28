package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bdy extends a {
    public String desc;
    public String title;
    public String vTT;
    public int wHD;
    public int wHE;
    public String wdd;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56863);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            if (this.wdd != null) {
                aVar.e(3, this.wdd);
            }
            aVar.iz(4, this.wHD);
            aVar.iz(5, this.wHE);
            if (this.vTT != null) {
                aVar.e(6, this.vTT);
            }
            AppMethodBeat.o(56863);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = e.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.desc != null) {
                f += e.a.a.b.b.a.f(2, this.desc);
            }
            if (this.wdd != null) {
                f += e.a.a.b.b.a.f(3, this.wdd);
            }
            f = (f + e.a.a.b.b.a.bs(4, this.wHD)) + e.a.a.b.b.a.bs(5, this.wHE);
            if (this.vTT != null) {
                f += e.a.a.b.b.a.f(6, this.vTT);
            }
            AppMethodBeat.o(56863);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56863);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bdy bdy = (bdy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bdy.title = aVar3.BTU.readString();
                    AppMethodBeat.o(56863);
                    return 0;
                case 2:
                    bdy.desc = aVar3.BTU.readString();
                    AppMethodBeat.o(56863);
                    return 0;
                case 3:
                    bdy.wdd = aVar3.BTU.readString();
                    AppMethodBeat.o(56863);
                    return 0;
                case 4:
                    bdy.wHD = aVar3.BTU.vd();
                    AppMethodBeat.o(56863);
                    return 0;
                case 5:
                    bdy.wHE = aVar3.BTU.vd();
                    AppMethodBeat.o(56863);
                    return 0;
                case 6:
                    bdy.vTT = aVar3.BTU.readString();
                    AppMethodBeat.o(56863);
                    return 0;
                default:
                    AppMethodBeat.o(56863);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56863);
            return -1;
        }
    }
}
