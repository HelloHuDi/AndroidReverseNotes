package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class dq extends a {
    public String csB;
    public int status;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73647);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.csB == null) {
                bVar = new b("Not all required fields were included: appid");
                AppMethodBeat.o(73647);
                throw bVar;
            }
            if (this.csB != null) {
                aVar.e(1, this.csB);
            }
            aVar.iz(2, this.status);
            AppMethodBeat.o(73647);
            return 0;
        } else if (i == 1) {
            if (this.csB != null) {
                f = e.a.a.b.b.a.f(1, this.csB) + 0;
            } else {
                f = 0;
            }
            int bs = f + e.a.a.b.b.a.bs(2, this.status);
            AppMethodBeat.o(73647);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.csB == null) {
                bVar = new b("Not all required fields were included: appid");
                AppMethodBeat.o(73647);
                throw bVar;
            }
            AppMethodBeat.o(73647);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dq dqVar = (dq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dqVar.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(73647);
                    return 0;
                case 2:
                    dqVar.status = aVar3.BTU.vd();
                    AppMethodBeat.o(73647);
                    return 0;
                default:
                    AppMethodBeat.o(73647);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73647);
            return -1;
        }
    }
}
