package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ds extends a {
    public String Id;
    public String jCh;
    public String ncH;
    public String vFw;
    public String vFx;
    public int vFy;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94507);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Id != null) {
                aVar.e(1, this.Id);
            }
            if (this.jCh != null) {
                aVar.e(2, this.jCh);
            }
            if (this.ncH != null) {
                aVar.e(3, this.ncH);
            }
            if (this.vFw != null) {
                aVar.e(4, this.vFw);
            }
            if (this.vFx != null) {
                aVar.e(5, this.vFx);
            }
            aVar.iz(6, this.vFy);
            AppMethodBeat.o(94507);
            return 0;
        } else if (i == 1) {
            if (this.Id != null) {
                f = e.a.a.b.b.a.f(1, this.Id) + 0;
            } else {
                f = 0;
            }
            if (this.jCh != null) {
                f += e.a.a.b.b.a.f(2, this.jCh);
            }
            if (this.ncH != null) {
                f += e.a.a.b.b.a.f(3, this.ncH);
            }
            if (this.vFw != null) {
                f += e.a.a.b.b.a.f(4, this.vFw);
            }
            if (this.vFx != null) {
                f += e.a.a.b.b.a.f(5, this.vFx);
            }
            int bs = f + e.a.a.b.b.a.bs(6, this.vFy);
            AppMethodBeat.o(94507);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94507);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ds dsVar = (ds) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dsVar.Id = aVar3.BTU.readString();
                    AppMethodBeat.o(94507);
                    return 0;
                case 2:
                    dsVar.jCh = aVar3.BTU.readString();
                    AppMethodBeat.o(94507);
                    return 0;
                case 3:
                    dsVar.ncH = aVar3.BTU.readString();
                    AppMethodBeat.o(94507);
                    return 0;
                case 4:
                    dsVar.vFw = aVar3.BTU.readString();
                    AppMethodBeat.o(94507);
                    return 0;
                case 5:
                    dsVar.vFx = aVar3.BTU.readString();
                    AppMethodBeat.o(94507);
                    return 0;
                case 6:
                    dsVar.vFy = aVar3.BTU.vd();
                    AppMethodBeat.o(94507);
                    return 0;
                default:
                    AppMethodBeat.o(94507);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94507);
            return -1;
        }
    }
}
