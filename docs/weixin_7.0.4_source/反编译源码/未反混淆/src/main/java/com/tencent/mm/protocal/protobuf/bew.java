package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bew extends a {
    public String desc;
    public String iyZ;
    public String scope;
    public int wIR;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10227);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.scope != null) {
                aVar.e(1, this.scope);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            aVar.iz(3, this.wIR);
            if (this.iyZ != null) {
                aVar.e(4, this.iyZ);
            }
            AppMethodBeat.o(10227);
            return 0;
        } else if (i == 1) {
            if (this.scope != null) {
                f = e.a.a.b.b.a.f(1, this.scope) + 0;
            } else {
                f = 0;
            }
            if (this.desc != null) {
                f += e.a.a.b.b.a.f(2, this.desc);
            }
            f += e.a.a.b.b.a.bs(3, this.wIR);
            if (this.iyZ != null) {
                f += e.a.a.b.b.a.f(4, this.iyZ);
            }
            AppMethodBeat.o(10227);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(10227);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bew bew = (bew) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bew.scope = aVar3.BTU.readString();
                    AppMethodBeat.o(10227);
                    return 0;
                case 2:
                    bew.desc = aVar3.BTU.readString();
                    AppMethodBeat.o(10227);
                    return 0;
                case 3:
                    bew.wIR = aVar3.BTU.vd();
                    AppMethodBeat.o(10227);
                    return 0;
                case 4:
                    bew.iyZ = aVar3.BTU.readString();
                    AppMethodBeat.o(10227);
                    return 0;
                default:
                    AppMethodBeat.o(10227);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10227);
            return -1;
        }
    }
}
