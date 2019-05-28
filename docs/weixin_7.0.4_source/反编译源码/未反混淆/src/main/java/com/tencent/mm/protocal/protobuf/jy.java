package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class jy extends a {
    public long jVD;
    public int jVE;
    public String url;
    public String vGE;
    public long vGH;
    public long vMM;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11695);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vGE != null) {
                aVar.e(1, this.vGE);
            }
            aVar.ai(2, this.jVD);
            aVar.ai(3, this.vGH);
            aVar.ai(4, this.vMM);
            aVar.iz(5, this.jVE);
            if (this.url != null) {
                aVar.e(6, this.url);
            }
            AppMethodBeat.o(11695);
            return 0;
        } else if (i == 1) {
            if (this.vGE != null) {
                f = e.a.a.b.b.a.f(1, this.vGE) + 0;
            } else {
                f = 0;
            }
            f = (((f + e.a.a.b.b.a.o(2, this.jVD)) + e.a.a.b.b.a.o(3, this.vGH)) + e.a.a.b.b.a.o(4, this.vMM)) + e.a.a.b.b.a.bs(5, this.jVE);
            if (this.url != null) {
                f += e.a.a.b.b.a.f(6, this.url);
            }
            AppMethodBeat.o(11695);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(11695);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            jy jyVar = (jy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jyVar.vGE = aVar3.BTU.readString();
                    AppMethodBeat.o(11695);
                    return 0;
                case 2:
                    jyVar.jVD = aVar3.BTU.ve();
                    AppMethodBeat.o(11695);
                    return 0;
                case 3:
                    jyVar.vGH = aVar3.BTU.ve();
                    AppMethodBeat.o(11695);
                    return 0;
                case 4:
                    jyVar.vMM = aVar3.BTU.ve();
                    AppMethodBeat.o(11695);
                    return 0;
                case 5:
                    jyVar.jVE = aVar3.BTU.vd();
                    AppMethodBeat.o(11695);
                    return 0;
                case 6:
                    jyVar.url = aVar3.BTU.readString();
                    AppMethodBeat.o(11695);
                    return 0;
                default:
                    AppMethodBeat.o(11695);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11695);
            return -1;
        }
    }
}
