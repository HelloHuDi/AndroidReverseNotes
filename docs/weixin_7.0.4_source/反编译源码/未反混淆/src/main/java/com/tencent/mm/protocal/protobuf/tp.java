package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class tp extends a {
    public String content;
    public String vGs;
    public int vGu;
    public int vNm;
    public int waH;
    public String waI;
    public int waJ;
    public int waK;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14724);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.content != null) {
                aVar.e(1, this.content);
            }
            if (this.vGs != null) {
                aVar.e(3, this.vGs);
            }
            aVar.iz(4, this.vNm);
            aVar.iz(5, this.vGu);
            aVar.iz(6, this.waH);
            if (this.waI != null) {
                aVar.e(7, this.waI);
            }
            aVar.iz(8, this.waJ);
            aVar.iz(9, this.waK);
            AppMethodBeat.o(14724);
            return 0;
        } else if (i == 1) {
            if (this.content != null) {
                f = e.a.a.b.b.a.f(1, this.content) + 0;
            } else {
                f = 0;
            }
            if (this.vGs != null) {
                f += e.a.a.b.b.a.f(3, this.vGs);
            }
            f = ((f + e.a.a.b.b.a.bs(4, this.vNm)) + e.a.a.b.b.a.bs(5, this.vGu)) + e.a.a.b.b.a.bs(6, this.waH);
            if (this.waI != null) {
                f += e.a.a.b.b.a.f(7, this.waI);
            }
            int bs = (f + e.a.a.b.b.a.bs(8, this.waJ)) + e.a.a.b.b.a.bs(9, this.waK);
            AppMethodBeat.o(14724);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(14724);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            tp tpVar = (tp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tpVar.content = aVar3.BTU.readString();
                    AppMethodBeat.o(14724);
                    return 0;
                case 3:
                    tpVar.vGs = aVar3.BTU.readString();
                    AppMethodBeat.o(14724);
                    return 0;
                case 4:
                    tpVar.vNm = aVar3.BTU.vd();
                    AppMethodBeat.o(14724);
                    return 0;
                case 5:
                    tpVar.vGu = aVar3.BTU.vd();
                    AppMethodBeat.o(14724);
                    return 0;
                case 6:
                    tpVar.waH = aVar3.BTU.vd();
                    AppMethodBeat.o(14724);
                    return 0;
                case 7:
                    tpVar.waI = aVar3.BTU.readString();
                    AppMethodBeat.o(14724);
                    return 0;
                case 8:
                    tpVar.waJ = aVar3.BTU.vd();
                    AppMethodBeat.o(14724);
                    return 0;
                case 9:
                    tpVar.waK = aVar3.BTU.vd();
                    AppMethodBeat.o(14724);
                    return 0;
                default:
                    AppMethodBeat.o(14724);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14724);
            return -1;
        }
    }
}
