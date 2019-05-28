package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class dh extends a {
    public String mac;
    public String ssid;
    public int vFl;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28310);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.mac != null) {
                aVar.e(1, this.mac);
            }
            aVar.iz(2, this.vFl);
            if (this.ssid != null) {
                aVar.e(3, this.ssid);
            }
            AppMethodBeat.o(28310);
            return 0;
        } else if (i == 1) {
            if (this.mac != null) {
                f = e.a.a.b.b.a.f(1, this.mac) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.vFl);
            if (this.ssid != null) {
                f += e.a.a.b.b.a.f(3, this.ssid);
            }
            AppMethodBeat.o(28310);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28310);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dh dhVar = (dh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dhVar.mac = aVar3.BTU.readString();
                    AppMethodBeat.o(28310);
                    return 0;
                case 2:
                    dhVar.vFl = aVar3.BTU.vd();
                    AppMethodBeat.o(28310);
                    return 0;
                case 3:
                    dhVar.ssid = aVar3.BTU.readString();
                    AppMethodBeat.o(28310);
                    return 0;
                default:
                    AppMethodBeat.o(28310);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28310);
            return -1;
        }
    }
}
