package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class sm extends a {
    public String csB;
    public long jVD;
    public int jVE;
    public String path;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11736);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.jVD);
            aVar.iz(2, this.jVE);
            if (this.csB != null) {
                aVar.e(3, this.csB);
            }
            if (this.path != null) {
                aVar.e(4, this.path);
            }
            AppMethodBeat.o(11736);
            return 0;
        } else if (i == 1) {
            o = (e.a.a.b.b.a.o(1, this.jVD) + 0) + e.a.a.b.b.a.bs(2, this.jVE);
            if (this.csB != null) {
                o += e.a.a.b.b.a.f(3, this.csB);
            }
            if (this.path != null) {
                o += e.a.a.b.b.a.f(4, this.path);
            }
            AppMethodBeat.o(11736);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(11736);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            sm smVar = (sm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    smVar.jVD = aVar3.BTU.ve();
                    AppMethodBeat.o(11736);
                    return 0;
                case 2:
                    smVar.jVE = aVar3.BTU.vd();
                    AppMethodBeat.o(11736);
                    return 0;
                case 3:
                    smVar.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(11736);
                    return 0;
                case 4:
                    smVar.path = aVar3.BTU.readString();
                    AppMethodBeat.o(11736);
                    return 0;
                default:
                    AppMethodBeat.o(11736);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11736);
            return -1;
        }
    }
}
