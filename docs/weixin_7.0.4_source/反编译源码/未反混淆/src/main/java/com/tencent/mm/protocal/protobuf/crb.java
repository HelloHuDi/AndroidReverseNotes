package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class crb extends a {
    public String cso;
    public String csp;
    public long timestamp;
    public String xoK;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(102411);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.cso != null) {
                aVar.e(1, this.cso);
            }
            if (this.csp != null) {
                aVar.e(2, this.csp);
            }
            if (this.xoK != null) {
                aVar.e(3, this.xoK);
            }
            aVar.ai(4, this.timestamp);
            AppMethodBeat.o(102411);
            return 0;
        } else if (i == 1) {
            if (this.cso != null) {
                f = e.a.a.b.b.a.f(1, this.cso) + 0;
            } else {
                f = 0;
            }
            if (this.csp != null) {
                f += e.a.a.b.b.a.f(2, this.csp);
            }
            if (this.xoK != null) {
                f += e.a.a.b.b.a.f(3, this.xoK);
            }
            int o = f + e.a.a.b.b.a.o(4, this.timestamp);
            AppMethodBeat.o(102411);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(102411);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            crb crb = (crb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    crb.cso = aVar3.BTU.readString();
                    AppMethodBeat.o(102411);
                    return 0;
                case 2:
                    crb.csp = aVar3.BTU.readString();
                    AppMethodBeat.o(102411);
                    return 0;
                case 3:
                    crb.xoK = aVar3.BTU.readString();
                    AppMethodBeat.o(102411);
                    return 0;
                case 4:
                    crb.timestamp = aVar3.BTU.ve();
                    AppMethodBeat.o(102411);
                    return 0;
                default:
                    AppMethodBeat.o(102411);
                    return -1;
            }
        } else {
            AppMethodBeat.o(102411);
            return -1;
        }
    }
}
