package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bal extends a {
    public String bssid;
    public String cuH;
    public int cyC;
    public int mue;
    public String ssid;
    public int wEh;
    public String wEi;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28547);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ssid != null) {
                aVar.e(1, this.ssid);
            }
            if (this.bssid != null) {
                aVar.e(2, this.bssid);
            }
            aVar.iz(3, this.cyC);
            aVar.iz(4, this.wEh);
            if (this.wEi != null) {
                aVar.e(5, this.wEi);
            }
            if (this.cuH != null) {
                aVar.e(6, this.cuH);
            }
            aVar.iz(7, this.mue);
            AppMethodBeat.o(28547);
            return 0;
        } else if (i == 1) {
            if (this.ssid != null) {
                f = e.a.a.b.b.a.f(1, this.ssid) + 0;
            } else {
                f = 0;
            }
            if (this.bssid != null) {
                f += e.a.a.b.b.a.f(2, this.bssid);
            }
            f = (f + e.a.a.b.b.a.bs(3, this.cyC)) + e.a.a.b.b.a.bs(4, this.wEh);
            if (this.wEi != null) {
                f += e.a.a.b.b.a.f(5, this.wEi);
            }
            if (this.cuH != null) {
                f += e.a.a.b.b.a.f(6, this.cuH);
            }
            int bs = f + e.a.a.b.b.a.bs(7, this.mue);
            AppMethodBeat.o(28547);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28547);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bal bal = (bal) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bal.ssid = aVar3.BTU.readString();
                    AppMethodBeat.o(28547);
                    return 0;
                case 2:
                    bal.bssid = aVar3.BTU.readString();
                    AppMethodBeat.o(28547);
                    return 0;
                case 3:
                    bal.cyC = aVar3.BTU.vd();
                    AppMethodBeat.o(28547);
                    return 0;
                case 4:
                    bal.wEh = aVar3.BTU.vd();
                    AppMethodBeat.o(28547);
                    return 0;
                case 5:
                    bal.wEi = aVar3.BTU.readString();
                    AppMethodBeat.o(28547);
                    return 0;
                case 6:
                    bal.cuH = aVar3.BTU.readString();
                    AppMethodBeat.o(28547);
                    return 0;
                case 7:
                    bal.mue = aVar3.BTU.vd();
                    AppMethodBeat.o(28547);
                    return 0;
                default:
                    AppMethodBeat.o(28547);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28547);
            return -1;
        }
    }
}
