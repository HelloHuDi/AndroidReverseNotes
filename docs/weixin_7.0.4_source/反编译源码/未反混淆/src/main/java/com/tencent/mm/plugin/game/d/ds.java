package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ds extends a {
    public String nac;
    public String ndR;
    public String ndS;
    public String ndT;
    public String ndU;
    public int ndV;
    public String ndW;
    public String ndX;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111683);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.nac != null) {
                aVar.e(1, this.nac);
            }
            if (this.ndR != null) {
                aVar.e(2, this.ndR);
            }
            if (this.ndS != null) {
                aVar.e(3, this.ndS);
            }
            if (this.ndT != null) {
                aVar.e(4, this.ndT);
            }
            if (this.ndU != null) {
                aVar.e(5, this.ndU);
            }
            aVar.iz(6, this.ndV);
            if (this.ndW != null) {
                aVar.e(7, this.ndW);
            }
            if (this.ndX != null) {
                aVar.e(8, this.ndX);
            }
            AppMethodBeat.o(111683);
            return 0;
        } else if (i == 1) {
            if (this.nac != null) {
                f = e.a.a.b.b.a.f(1, this.nac) + 0;
            } else {
                f = 0;
            }
            if (this.ndR != null) {
                f += e.a.a.b.b.a.f(2, this.ndR);
            }
            if (this.ndS != null) {
                f += e.a.a.b.b.a.f(3, this.ndS);
            }
            if (this.ndT != null) {
                f += e.a.a.b.b.a.f(4, this.ndT);
            }
            if (this.ndU != null) {
                f += e.a.a.b.b.a.f(5, this.ndU);
            }
            f += e.a.a.b.b.a.bs(6, this.ndV);
            if (this.ndW != null) {
                f += e.a.a.b.b.a.f(7, this.ndW);
            }
            if (this.ndX != null) {
                f += e.a.a.b.b.a.f(8, this.ndX);
            }
            AppMethodBeat.o(111683);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111683);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ds dsVar = (ds) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dsVar.nac = aVar3.BTU.readString();
                    AppMethodBeat.o(111683);
                    return 0;
                case 2:
                    dsVar.ndR = aVar3.BTU.readString();
                    AppMethodBeat.o(111683);
                    return 0;
                case 3:
                    dsVar.ndS = aVar3.BTU.readString();
                    AppMethodBeat.o(111683);
                    return 0;
                case 4:
                    dsVar.ndT = aVar3.BTU.readString();
                    AppMethodBeat.o(111683);
                    return 0;
                case 5:
                    dsVar.ndU = aVar3.BTU.readString();
                    AppMethodBeat.o(111683);
                    return 0;
                case 6:
                    dsVar.ndV = aVar3.BTU.vd();
                    AppMethodBeat.o(111683);
                    return 0;
                case 7:
                    dsVar.ndW = aVar3.BTU.readString();
                    AppMethodBeat.o(111683);
                    return 0;
                case 8:
                    dsVar.ndX = aVar3.BTU.readString();
                    AppMethodBeat.o(111683);
                    return 0;
                default:
                    AppMethodBeat.o(111683);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111683);
            return -1;
        }
    }
}
