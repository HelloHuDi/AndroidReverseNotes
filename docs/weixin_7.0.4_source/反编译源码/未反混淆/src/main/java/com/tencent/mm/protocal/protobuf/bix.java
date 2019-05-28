package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bix extends a {
    public String csB;
    public String kbV;
    public String vTT;
    public int wMn;
    public String wMo;
    public String wMp;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56884);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.csB != null) {
                aVar.e(1, this.csB);
            }
            aVar.iz(2, this.wMn);
            if (this.wMo != null) {
                aVar.e(3, this.wMo);
            }
            if (this.wMp != null) {
                aVar.e(4, this.wMp);
            }
            if (this.vTT != null) {
                aVar.e(5, this.vTT);
            }
            if (this.kbV != null) {
                aVar.e(6, this.kbV);
            }
            AppMethodBeat.o(56884);
            return 0;
        } else if (i == 1) {
            if (this.csB != null) {
                f = e.a.a.b.b.a.f(1, this.csB) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.wMn);
            if (this.wMo != null) {
                f += e.a.a.b.b.a.f(3, this.wMo);
            }
            if (this.wMp != null) {
                f += e.a.a.b.b.a.f(4, this.wMp);
            }
            if (this.vTT != null) {
                f += e.a.a.b.b.a.f(5, this.vTT);
            }
            if (this.kbV != null) {
                f += e.a.a.b.b.a.f(6, this.kbV);
            }
            AppMethodBeat.o(56884);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56884);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bix bix = (bix) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bix.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(56884);
                    return 0;
                case 2:
                    bix.wMn = aVar3.BTU.vd();
                    AppMethodBeat.o(56884);
                    return 0;
                case 3:
                    bix.wMo = aVar3.BTU.readString();
                    AppMethodBeat.o(56884);
                    return 0;
                case 4:
                    bix.wMp = aVar3.BTU.readString();
                    AppMethodBeat.o(56884);
                    return 0;
                case 5:
                    bix.vTT = aVar3.BTU.readString();
                    AppMethodBeat.o(56884);
                    return 0;
                case 6:
                    bix.kbV = aVar3.BTU.readString();
                    AppMethodBeat.o(56884);
                    return 0;
                default:
                    AppMethodBeat.o(56884);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56884);
            return -1;
        }
    }
}
