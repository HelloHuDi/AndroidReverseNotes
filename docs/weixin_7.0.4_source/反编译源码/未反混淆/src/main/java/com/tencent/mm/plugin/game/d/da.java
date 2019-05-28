package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class da extends a {
    public String mZm;
    public String mZs;
    public boolean ndA;
    public boolean ndB;
    public String ndx;
    public String ndy;
    public String ndz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111668);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.mZs != null) {
                aVar.e(1, this.mZs);
            }
            if (this.ndx != null) {
                aVar.e(2, this.ndx);
            }
            if (this.ndy != null) {
                aVar.e(3, this.ndy);
            }
            if (this.ndz != null) {
                aVar.e(4, this.ndz);
            }
            if (this.mZm != null) {
                aVar.e(5, this.mZm);
            }
            aVar.aO(6, this.ndA);
            aVar.aO(7, this.ndB);
            AppMethodBeat.o(111668);
            return 0;
        } else if (i == 1) {
            if (this.mZs != null) {
                f = e.a.a.b.b.a.f(1, this.mZs) + 0;
            } else {
                f = 0;
            }
            if (this.ndx != null) {
                f += e.a.a.b.b.a.f(2, this.ndx);
            }
            if (this.ndy != null) {
                f += e.a.a.b.b.a.f(3, this.ndy);
            }
            if (this.ndz != null) {
                f += e.a.a.b.b.a.f(4, this.ndz);
            }
            if (this.mZm != null) {
                f += e.a.a.b.b.a.f(5, this.mZm);
            }
            int fv = (f + (e.a.a.b.b.a.fv(6) + 1)) + (e.a.a.b.b.a.fv(7) + 1);
            AppMethodBeat.o(111668);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111668);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            da daVar = (da) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    daVar.mZs = aVar3.BTU.readString();
                    AppMethodBeat.o(111668);
                    return 0;
                case 2:
                    daVar.ndx = aVar3.BTU.readString();
                    AppMethodBeat.o(111668);
                    return 0;
                case 3:
                    daVar.ndy = aVar3.BTU.readString();
                    AppMethodBeat.o(111668);
                    return 0;
                case 4:
                    daVar.ndz = aVar3.BTU.readString();
                    AppMethodBeat.o(111668);
                    return 0;
                case 5:
                    daVar.mZm = aVar3.BTU.readString();
                    AppMethodBeat.o(111668);
                    return 0;
                case 6:
                    daVar.ndA = aVar3.BTU.ehX();
                    AppMethodBeat.o(111668);
                    return 0;
                case 7:
                    daVar.ndB = aVar3.BTU.ehX();
                    AppMethodBeat.o(111668);
                    return 0;
                default:
                    AppMethodBeat.o(111668);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111668);
            return -1;
        }
    }
}
