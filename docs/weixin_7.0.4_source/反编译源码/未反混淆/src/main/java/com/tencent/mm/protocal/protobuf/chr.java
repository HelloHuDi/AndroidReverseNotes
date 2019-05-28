package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class chr extends a {
    public int Scene;
    public int nbk;
    public String ncM;
    public int vFH;
    public int vGB;
    public String wDM;
    public String wUo;
    public String wbI;
    public String xgs;
    public String xgw;
    public String xgx;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124369);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wUo != null) {
                aVar.e(1, this.wUo);
            }
            if (this.xgx != null) {
                aVar.e(2, this.xgx);
            }
            aVar.iz(3, this.nbk);
            if (this.xgs != null) {
                aVar.e(4, this.xgs);
            }
            if (this.ncM != null) {
                aVar.e(5, this.ncM);
            }
            aVar.iz(6, this.Scene);
            if (this.wDM != null) {
                aVar.e(7, this.wDM);
            }
            aVar.iz(8, this.vGB);
            if (this.wbI != null) {
                aVar.e(9, this.wbI);
            }
            if (this.xgw != null) {
                aVar.e(10, this.xgw);
            }
            aVar.iz(11, this.vFH);
            AppMethodBeat.o(124369);
            return 0;
        } else if (i == 1) {
            if (this.wUo != null) {
                f = e.a.a.b.b.a.f(1, this.wUo) + 0;
            } else {
                f = 0;
            }
            if (this.xgx != null) {
                f += e.a.a.b.b.a.f(2, this.xgx);
            }
            f += e.a.a.b.b.a.bs(3, this.nbk);
            if (this.xgs != null) {
                f += e.a.a.b.b.a.f(4, this.xgs);
            }
            if (this.ncM != null) {
                f += e.a.a.b.b.a.f(5, this.ncM);
            }
            f += e.a.a.b.b.a.bs(6, this.Scene);
            if (this.wDM != null) {
                f += e.a.a.b.b.a.f(7, this.wDM);
            }
            f += e.a.a.b.b.a.bs(8, this.vGB);
            if (this.wbI != null) {
                f += e.a.a.b.b.a.f(9, this.wbI);
            }
            if (this.xgw != null) {
                f += e.a.a.b.b.a.f(10, this.xgw);
            }
            int bs = f + e.a.a.b.b.a.bs(11, this.vFH);
            AppMethodBeat.o(124369);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124369);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            chr chr = (chr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    chr.wUo = aVar3.BTU.readString();
                    AppMethodBeat.o(124369);
                    return 0;
                case 2:
                    chr.xgx = aVar3.BTU.readString();
                    AppMethodBeat.o(124369);
                    return 0;
                case 3:
                    chr.nbk = aVar3.BTU.vd();
                    AppMethodBeat.o(124369);
                    return 0;
                case 4:
                    chr.xgs = aVar3.BTU.readString();
                    AppMethodBeat.o(124369);
                    return 0;
                case 5:
                    chr.ncM = aVar3.BTU.readString();
                    AppMethodBeat.o(124369);
                    return 0;
                case 6:
                    chr.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(124369);
                    return 0;
                case 7:
                    chr.wDM = aVar3.BTU.readString();
                    AppMethodBeat.o(124369);
                    return 0;
                case 8:
                    chr.vGB = aVar3.BTU.vd();
                    AppMethodBeat.o(124369);
                    return 0;
                case 9:
                    chr.wbI = aVar3.BTU.readString();
                    AppMethodBeat.o(124369);
                    return 0;
                case 10:
                    chr.xgw = aVar3.BTU.readString();
                    AppMethodBeat.o(124369);
                    return 0;
                case 11:
                    chr.vFH = aVar3.BTU.vd();
                    AppMethodBeat.o(124369);
                    return 0;
                default:
                    AppMethodBeat.o(124369);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124369);
            return -1;
        }
    }
}
