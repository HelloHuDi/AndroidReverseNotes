package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class atz extends a {
    public String eCq;
    public double fNN;
    public int major;
    public int minor;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10191);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.eCq != null) {
                aVar.e(1, this.eCq);
            }
            aVar.iz(2, this.major);
            aVar.iz(3, this.minor);
            aVar.f(4, this.fNN);
            AppMethodBeat.o(10191);
            return 0;
        } else if (i == 1) {
            if (this.eCq != null) {
                f = e.a.a.b.b.a.f(1, this.eCq) + 0;
            } else {
                f = 0;
            }
            int bs = ((f + e.a.a.b.b.a.bs(2, this.major)) + e.a.a.b.b.a.bs(3, this.minor)) + (e.a.a.b.b.a.fv(4) + 8);
            AppMethodBeat.o(10191);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(10191);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            atz atz = (atz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    atz.eCq = aVar3.BTU.readString();
                    AppMethodBeat.o(10191);
                    return 0;
                case 2:
                    atz.major = aVar3.BTU.vd();
                    AppMethodBeat.o(10191);
                    return 0;
                case 3:
                    atz.minor = aVar3.BTU.vd();
                    AppMethodBeat.o(10191);
                    return 0;
                case 4:
                    atz.fNN = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(10191);
                    return 0;
                default:
                    AppMethodBeat.o(10191);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10191);
            return -1;
        }
    }
}
