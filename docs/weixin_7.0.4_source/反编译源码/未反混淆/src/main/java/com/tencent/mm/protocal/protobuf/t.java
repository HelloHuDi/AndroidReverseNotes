package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class t extends a {
    public String vAh;
    public long vAi;
    public int vAj;
    public long vzU;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56688);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vAh != null) {
                aVar.e(1, this.vAh);
            }
            aVar.ai(2, this.vzU);
            aVar.ai(3, this.vAi);
            aVar.iz(4, this.vAj);
            AppMethodBeat.o(56688);
            return 0;
        } else if (i == 1) {
            if (this.vAh != null) {
                f = e.a.a.b.b.a.f(1, this.vAh) + 0;
            } else {
                f = 0;
            }
            int o = ((f + e.a.a.b.b.a.o(2, this.vzU)) + e.a.a.b.b.a.o(3, this.vAi)) + e.a.a.b.b.a.bs(4, this.vAj);
            AppMethodBeat.o(56688);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56688);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            t tVar = (t) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tVar.vAh = aVar3.BTU.readString();
                    AppMethodBeat.o(56688);
                    return 0;
                case 2:
                    tVar.vzU = aVar3.BTU.ve();
                    AppMethodBeat.o(56688);
                    return 0;
                case 3:
                    tVar.vAi = aVar3.BTU.ve();
                    AppMethodBeat.o(56688);
                    return 0;
                case 4:
                    tVar.vAj = aVar3.BTU.vd();
                    AppMethodBeat.o(56688);
                    return 0;
                default:
                    AppMethodBeat.o(56688);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56688);
            return -1;
        }
    }
}
