package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bdt extends a {
    public String path;
    public int type;
    public String username;
    public int vOP;
    public String wHu;
    public String wHv;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96278);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            if (this.wHu != null) {
                aVar.e(2, this.wHu);
            }
            if (this.wHv != null) {
                aVar.e(3, this.wHv);
            }
            if (this.path != null) {
                aVar.e(4, this.path);
            }
            aVar.iz(5, this.vOP);
            aVar.iz(6, this.type);
            AppMethodBeat.o(96278);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                f = e.a.a.b.b.a.f(1, this.username) + 0;
            } else {
                f = 0;
            }
            if (this.wHu != null) {
                f += e.a.a.b.b.a.f(2, this.wHu);
            }
            if (this.wHv != null) {
                f += e.a.a.b.b.a.f(3, this.wHv);
            }
            if (this.path != null) {
                f += e.a.a.b.b.a.f(4, this.path);
            }
            int bs = (f + e.a.a.b.b.a.bs(5, this.vOP)) + e.a.a.b.b.a.bs(6, this.type);
            AppMethodBeat.o(96278);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96278);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bdt bdt = (bdt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bdt.username = aVar3.BTU.readString();
                    AppMethodBeat.o(96278);
                    return 0;
                case 2:
                    bdt.wHu = aVar3.BTU.readString();
                    AppMethodBeat.o(96278);
                    return 0;
                case 3:
                    bdt.wHv = aVar3.BTU.readString();
                    AppMethodBeat.o(96278);
                    return 0;
                case 4:
                    bdt.path = aVar3.BTU.readString();
                    AppMethodBeat.o(96278);
                    return 0;
                case 5:
                    bdt.vOP = aVar3.BTU.vd();
                    AppMethodBeat.o(96278);
                    return 0;
                case 6:
                    bdt.type = aVar3.BTU.vd();
                    AppMethodBeat.o(96278);
                    return 0;
                default:
                    AppMethodBeat.o(96278);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96278);
            return -1;
        }
    }
}
