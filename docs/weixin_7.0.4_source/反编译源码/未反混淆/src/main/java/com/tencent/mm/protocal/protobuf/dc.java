package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class dc extends a {
    public int bJt;
    public String cEh;
    public String kCs;
    public String nZb;
    public String nZc;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48772);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.bJt);
            if (this.cEh != null) {
                aVar.e(2, this.cEh);
            }
            if (this.nZb != null) {
                aVar.e(3, this.nZb);
            }
            if (this.nZc != null) {
                aVar.e(4, this.nZc);
            }
            if (this.kCs != null) {
                aVar.e(5, this.kCs);
            }
            AppMethodBeat.o(48772);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.bJt) + 0;
            if (this.cEh != null) {
                bs += e.a.a.b.b.a.f(2, this.cEh);
            }
            if (this.nZb != null) {
                bs += e.a.a.b.b.a.f(3, this.nZb);
            }
            if (this.nZc != null) {
                bs += e.a.a.b.b.a.f(4, this.nZc);
            }
            if (this.kCs != null) {
                bs += e.a.a.b.b.a.f(5, this.kCs);
            }
            AppMethodBeat.o(48772);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48772);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dc dcVar = (dc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dcVar.bJt = aVar3.BTU.vd();
                    AppMethodBeat.o(48772);
                    return 0;
                case 2:
                    dcVar.cEh = aVar3.BTU.readString();
                    AppMethodBeat.o(48772);
                    return 0;
                case 3:
                    dcVar.nZb = aVar3.BTU.readString();
                    AppMethodBeat.o(48772);
                    return 0;
                case 4:
                    dcVar.nZc = aVar3.BTU.readString();
                    AppMethodBeat.o(48772);
                    return 0;
                case 5:
                    dcVar.kCs = aVar3.BTU.readString();
                    AppMethodBeat.o(48772);
                    return 0;
                default:
                    AppMethodBeat.o(48772);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48772);
            return -1;
        }
    }
}
