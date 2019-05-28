package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class qa extends a {
    public int kKS;
    public String kKT;
    public String kKY;
    public String kKZ;
    public String kLL;
    public int vWZ;
    public String vXa;
    public int vXb;
    public String vXc;
    public int vXd;
    public String vXe;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94513);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vWZ);
            if (this.kLL != null) {
                aVar.e(2, this.kLL);
            }
            if (this.vXa != null) {
                aVar.e(3, this.vXa);
            }
            if (this.kKY != null) {
                aVar.e(4, this.kKY);
            }
            aVar.iz(5, this.vXb);
            if (this.vXc != null) {
                aVar.e(6, this.vXc);
            }
            aVar.iz(7, this.vXd);
            if (this.kKZ != null) {
                aVar.e(8, this.kKZ);
            }
            if (this.vXe != null) {
                aVar.e(9, this.vXe);
            }
            aVar.iz(10, this.kKS);
            if (this.kKT != null) {
                aVar.e(11, this.kKT);
            }
            AppMethodBeat.o(94513);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.vWZ) + 0;
            if (this.kLL != null) {
                bs += e.a.a.b.b.a.f(2, this.kLL);
            }
            if (this.vXa != null) {
                bs += e.a.a.b.b.a.f(3, this.vXa);
            }
            if (this.kKY != null) {
                bs += e.a.a.b.b.a.f(4, this.kKY);
            }
            bs += e.a.a.b.b.a.bs(5, this.vXb);
            if (this.vXc != null) {
                bs += e.a.a.b.b.a.f(6, this.vXc);
            }
            bs += e.a.a.b.b.a.bs(7, this.vXd);
            if (this.kKZ != null) {
                bs += e.a.a.b.b.a.f(8, this.kKZ);
            }
            if (this.vXe != null) {
                bs += e.a.a.b.b.a.f(9, this.vXe);
            }
            bs += e.a.a.b.b.a.bs(10, this.kKS);
            if (this.kKT != null) {
                bs += e.a.a.b.b.a.f(11, this.kKT);
            }
            AppMethodBeat.o(94513);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94513);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            qa qaVar = (qa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qaVar.vWZ = aVar3.BTU.vd();
                    AppMethodBeat.o(94513);
                    return 0;
                case 2:
                    qaVar.kLL = aVar3.BTU.readString();
                    AppMethodBeat.o(94513);
                    return 0;
                case 3:
                    qaVar.vXa = aVar3.BTU.readString();
                    AppMethodBeat.o(94513);
                    return 0;
                case 4:
                    qaVar.kKY = aVar3.BTU.readString();
                    AppMethodBeat.o(94513);
                    return 0;
                case 5:
                    qaVar.vXb = aVar3.BTU.vd();
                    AppMethodBeat.o(94513);
                    return 0;
                case 6:
                    qaVar.vXc = aVar3.BTU.readString();
                    AppMethodBeat.o(94513);
                    return 0;
                case 7:
                    qaVar.vXd = aVar3.BTU.vd();
                    AppMethodBeat.o(94513);
                    return 0;
                case 8:
                    qaVar.kKZ = aVar3.BTU.readString();
                    AppMethodBeat.o(94513);
                    return 0;
                case 9:
                    qaVar.vXe = aVar3.BTU.readString();
                    AppMethodBeat.o(94513);
                    return 0;
                case 10:
                    qaVar.kKS = aVar3.BTU.vd();
                    AppMethodBeat.o(94513);
                    return 0;
                case 11:
                    qaVar.kKT = aVar3.BTU.readString();
                    AppMethodBeat.o(94513);
                    return 0;
                default:
                    AppMethodBeat.o(94513);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94513);
            return -1;
        }
    }
}
