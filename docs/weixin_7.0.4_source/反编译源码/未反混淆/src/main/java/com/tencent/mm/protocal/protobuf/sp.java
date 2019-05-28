package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class sp extends a {
    public String csB;
    public String iAa;
    public String iAb;
    public String iAc;
    public int iAd;
    public String iAe;
    public String izZ;
    public int position;
    public String username;
    public int wad;
    public int wae;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(134425);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            if (this.izZ != null) {
                aVar.e(2, this.izZ);
            }
            aVar.iz(3, this.wad);
            aVar.iz(4, this.wae);
            if (this.iAa != null) {
                aVar.e(5, this.iAa);
            }
            if (this.csB != null) {
                aVar.e(6, this.csB);
            }
            if (this.iAb != null) {
                aVar.e(7, this.iAb);
            }
            if (this.iAc != null) {
                aVar.e(8, this.iAc);
            }
            aVar.iz(9, this.iAd);
            if (this.iAe != null) {
                aVar.e(10, this.iAe);
            }
            aVar.iz(11, this.position);
            AppMethodBeat.o(134425);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                f = e.a.a.b.b.a.f(1, this.username) + 0;
            } else {
                f = 0;
            }
            if (this.izZ != null) {
                f += e.a.a.b.b.a.f(2, this.izZ);
            }
            f = (f + e.a.a.b.b.a.bs(3, this.wad)) + e.a.a.b.b.a.bs(4, this.wae);
            if (this.iAa != null) {
                f += e.a.a.b.b.a.f(5, this.iAa);
            }
            if (this.csB != null) {
                f += e.a.a.b.b.a.f(6, this.csB);
            }
            if (this.iAb != null) {
                f += e.a.a.b.b.a.f(7, this.iAb);
            }
            if (this.iAc != null) {
                f += e.a.a.b.b.a.f(8, this.iAc);
            }
            f += e.a.a.b.b.a.bs(9, this.iAd);
            if (this.iAe != null) {
                f += e.a.a.b.b.a.f(10, this.iAe);
            }
            int bs = f + e.a.a.b.b.a.bs(11, this.position);
            AppMethodBeat.o(134425);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(134425);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            sp spVar = (sp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    spVar.username = aVar3.BTU.readString();
                    AppMethodBeat.o(134425);
                    return 0;
                case 2:
                    spVar.izZ = aVar3.BTU.readString();
                    AppMethodBeat.o(134425);
                    return 0;
                case 3:
                    spVar.wad = aVar3.BTU.vd();
                    AppMethodBeat.o(134425);
                    return 0;
                case 4:
                    spVar.wae = aVar3.BTU.vd();
                    AppMethodBeat.o(134425);
                    return 0;
                case 5:
                    spVar.iAa = aVar3.BTU.readString();
                    AppMethodBeat.o(134425);
                    return 0;
                case 6:
                    spVar.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(134425);
                    return 0;
                case 7:
                    spVar.iAb = aVar3.BTU.readString();
                    AppMethodBeat.o(134425);
                    return 0;
                case 8:
                    spVar.iAc = aVar3.BTU.readString();
                    AppMethodBeat.o(134425);
                    return 0;
                case 9:
                    spVar.iAd = aVar3.BTU.vd();
                    AppMethodBeat.o(134425);
                    return 0;
                case 10:
                    spVar.iAe = aVar3.BTU.readString();
                    AppMethodBeat.o(134425);
                    return 0;
                case 11:
                    spVar.position = aVar3.BTU.vd();
                    AppMethodBeat.o(134425);
                    return 0;
                default:
                    AppMethodBeat.o(134425);
                    return -1;
            }
        } else {
            AppMethodBeat.o(134425);
            return -1;
        }
    }
}
