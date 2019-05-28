package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class aza extends a {
    public String devicename;
    public String devicetype;
    public String eCq;
    public int wCN;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73737);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.eCq != null) {
                aVar.e(1, this.eCq);
            }
            if (this.devicename != null) {
                aVar.e(2, this.devicename);
            }
            if (this.devicetype != null) {
                aVar.e(3, this.devicetype);
            }
            aVar.iz(4, this.wCN);
            AppMethodBeat.o(73737);
            return 0;
        } else if (i == 1) {
            if (this.eCq != null) {
                f = e.a.a.b.b.a.f(1, this.eCq) + 0;
            } else {
                f = 0;
            }
            if (this.devicename != null) {
                f += e.a.a.b.b.a.f(2, this.devicename);
            }
            if (this.devicetype != null) {
                f += e.a.a.b.b.a.f(3, this.devicetype);
            }
            int bs = f + e.a.a.b.b.a.bs(4, this.wCN);
            AppMethodBeat.o(73737);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(73737);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aza aza = (aza) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aza.eCq = aVar3.BTU.readString();
                    AppMethodBeat.o(73737);
                    return 0;
                case 2:
                    aza.devicename = aVar3.BTU.readString();
                    AppMethodBeat.o(73737);
                    return 0;
                case 3:
                    aza.devicetype = aVar3.BTU.readString();
                    AppMethodBeat.o(73737);
                    return 0;
                case 4:
                    aza.wCN = aVar3.BTU.vd();
                    AppMethodBeat.o(73737);
                    return 0;
                default:
                    AppMethodBeat.o(73737);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73737);
            return -1;
        }
    }
}
