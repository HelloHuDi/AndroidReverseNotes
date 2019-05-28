package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cdr extends a {
    public String ThumbUrl;
    public String jBB;
    public String nbr;
    public long xdq;
    public int xdr;
    public int xds;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56499);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.jBB != null) {
                aVar.e(1, this.jBB);
            }
            aVar.ai(2, this.xdq);
            aVar.iz(3, this.xdr);
            if (this.ThumbUrl != null) {
                aVar.e(4, this.ThumbUrl);
            }
            aVar.iz(5, this.xds);
            if (this.nbr != null) {
                aVar.e(6, this.nbr);
            }
            AppMethodBeat.o(56499);
            return 0;
        } else if (i == 1) {
            if (this.jBB != null) {
                f = e.a.a.b.b.a.f(1, this.jBB) + 0;
            } else {
                f = 0;
            }
            f = (f + e.a.a.b.b.a.o(2, this.xdq)) + e.a.a.b.b.a.bs(3, this.xdr);
            if (this.ThumbUrl != null) {
                f += e.a.a.b.b.a.f(4, this.ThumbUrl);
            }
            f += e.a.a.b.b.a.bs(5, this.xds);
            if (this.nbr != null) {
                f += e.a.a.b.b.a.f(6, this.nbr);
            }
            AppMethodBeat.o(56499);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56499);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cdr cdr = (cdr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cdr.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(56499);
                    return 0;
                case 2:
                    cdr.xdq = aVar3.BTU.ve();
                    AppMethodBeat.o(56499);
                    return 0;
                case 3:
                    cdr.xdr = aVar3.BTU.vd();
                    AppMethodBeat.o(56499);
                    return 0;
                case 4:
                    cdr.ThumbUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(56499);
                    return 0;
                case 5:
                    cdr.xds = aVar3.BTU.vd();
                    AppMethodBeat.o(56499);
                    return 0;
                case 6:
                    cdr.nbr = aVar3.BTU.readString();
                    AppMethodBeat.o(56499);
                    return 0;
                default:
                    AppMethodBeat.o(56499);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56499);
            return -1;
        }
    }
}
