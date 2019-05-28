package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class zd extends a {
    public int count;
    public String csB;
    public String iAa;
    public String iAb;
    public String iAc;
    public int iAd;
    public String iAe;
    public String izZ;
    public int position;
    public String username;
    public int wez;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(134427);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            aVar.iz(2, this.count);
            if (this.izZ != null) {
                aVar.e(3, this.izZ);
            }
            if (this.iAa != null) {
                aVar.e(4, this.iAa);
            }
            aVar.iz(5, this.wez);
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
            AppMethodBeat.o(134427);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                f = e.a.a.b.b.a.f(1, this.username) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.count);
            if (this.izZ != null) {
                f += e.a.a.b.b.a.f(3, this.izZ);
            }
            if (this.iAa != null) {
                f += e.a.a.b.b.a.f(4, this.iAa);
            }
            f += e.a.a.b.b.a.bs(5, this.wez);
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
            AppMethodBeat.o(134427);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(134427);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            zd zdVar = (zd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    zdVar.username = aVar3.BTU.readString();
                    AppMethodBeat.o(134427);
                    return 0;
                case 2:
                    zdVar.count = aVar3.BTU.vd();
                    AppMethodBeat.o(134427);
                    return 0;
                case 3:
                    zdVar.izZ = aVar3.BTU.readString();
                    AppMethodBeat.o(134427);
                    return 0;
                case 4:
                    zdVar.iAa = aVar3.BTU.readString();
                    AppMethodBeat.o(134427);
                    return 0;
                case 5:
                    zdVar.wez = aVar3.BTU.vd();
                    AppMethodBeat.o(134427);
                    return 0;
                case 6:
                    zdVar.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(134427);
                    return 0;
                case 7:
                    zdVar.iAb = aVar3.BTU.readString();
                    AppMethodBeat.o(134427);
                    return 0;
                case 8:
                    zdVar.iAc = aVar3.BTU.readString();
                    AppMethodBeat.o(134427);
                    return 0;
                case 9:
                    zdVar.iAd = aVar3.BTU.vd();
                    AppMethodBeat.o(134427);
                    return 0;
                case 10:
                    zdVar.iAe = aVar3.BTU.readString();
                    AppMethodBeat.o(134427);
                    return 0;
                case 11:
                    zdVar.position = aVar3.BTU.vd();
                    AppMethodBeat.o(134427);
                    return 0;
                default:
                    AppMethodBeat.o(134427);
                    return -1;
            }
        } else {
            AppMethodBeat.o(134427);
            return -1;
        }
    }
}
