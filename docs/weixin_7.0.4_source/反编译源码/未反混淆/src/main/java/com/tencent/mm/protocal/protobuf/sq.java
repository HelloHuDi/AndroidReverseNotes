package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class sq extends a {
    public double latitude;
    public double longitude;
    public String waf;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(134426);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.waf != null) {
                aVar.e(1, this.waf);
            }
            aVar.f(2, this.longitude);
            aVar.f(3, this.latitude);
            AppMethodBeat.o(134426);
            return 0;
        } else if (i == 1) {
            if (this.waf != null) {
                f = e.a.a.b.b.a.f(1, this.waf) + 0;
            } else {
                f = 0;
            }
            int fv = (f + (e.a.a.b.b.a.fv(2) + 8)) + (e.a.a.b.b.a.fv(3) + 8);
            AppMethodBeat.o(134426);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(134426);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            sq sqVar = (sq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    sqVar.waf = aVar3.BTU.readString();
                    AppMethodBeat.o(134426);
                    return 0;
                case 2:
                    sqVar.longitude = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(134426);
                    return 0;
                case 3:
                    sqVar.latitude = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(134426);
                    return 0;
                default:
                    AppMethodBeat.o(134426);
                    return -1;
            }
        } else {
            AppMethodBeat.o(134426);
            return -1;
        }
    }
}
