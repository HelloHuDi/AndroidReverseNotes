package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class chp extends a {
    public int Scene;
    public String Title;
    public String ncM;
    public int vFH;
    public int vGB;
    public String wDM;
    public String wUo;
    public String wbI;
    public String xgs;
    public String xgt;
    public String xgu;
    public String xgv;
    public String xgw;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124367);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xgs != null) {
                aVar.e(1, this.xgs);
            }
            if (this.wUo != null) {
                aVar.e(2, this.wUo);
            }
            if (this.ncM != null) {
                aVar.e(3, this.ncM);
            }
            if (this.xgt != null) {
                aVar.e(4, this.xgt);
            }
            if (this.xgu != null) {
                aVar.e(5, this.xgu);
            }
            if (this.xgv != null) {
                aVar.e(6, this.xgv);
            }
            if (this.Title != null) {
                aVar.e(7, this.Title);
            }
            if (this.wDM != null) {
                aVar.e(8, this.wDM);
            }
            aVar.iz(9, this.Scene);
            aVar.iz(10, this.vGB);
            if (this.xgw != null) {
                aVar.e(11, this.xgw);
            }
            if (this.wbI != null) {
                aVar.e(12, this.wbI);
            }
            aVar.iz(13, this.vFH);
            AppMethodBeat.o(124367);
            return 0;
        } else if (i == 1) {
            if (this.xgs != null) {
                f = e.a.a.b.b.a.f(1, this.xgs) + 0;
            } else {
                f = 0;
            }
            if (this.wUo != null) {
                f += e.a.a.b.b.a.f(2, this.wUo);
            }
            if (this.ncM != null) {
                f += e.a.a.b.b.a.f(3, this.ncM);
            }
            if (this.xgt != null) {
                f += e.a.a.b.b.a.f(4, this.xgt);
            }
            if (this.xgu != null) {
                f += e.a.a.b.b.a.f(5, this.xgu);
            }
            if (this.xgv != null) {
                f += e.a.a.b.b.a.f(6, this.xgv);
            }
            if (this.Title != null) {
                f += e.a.a.b.b.a.f(7, this.Title);
            }
            if (this.wDM != null) {
                f += e.a.a.b.b.a.f(8, this.wDM);
            }
            f = (f + e.a.a.b.b.a.bs(9, this.Scene)) + e.a.a.b.b.a.bs(10, this.vGB);
            if (this.xgw != null) {
                f += e.a.a.b.b.a.f(11, this.xgw);
            }
            if (this.wbI != null) {
                f += e.a.a.b.b.a.f(12, this.wbI);
            }
            int bs = f + e.a.a.b.b.a.bs(13, this.vFH);
            AppMethodBeat.o(124367);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124367);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            chp chp = (chp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    chp.xgs = aVar3.BTU.readString();
                    AppMethodBeat.o(124367);
                    return 0;
                case 2:
                    chp.wUo = aVar3.BTU.readString();
                    AppMethodBeat.o(124367);
                    return 0;
                case 3:
                    chp.ncM = aVar3.BTU.readString();
                    AppMethodBeat.o(124367);
                    return 0;
                case 4:
                    chp.xgt = aVar3.BTU.readString();
                    AppMethodBeat.o(124367);
                    return 0;
                case 5:
                    chp.xgu = aVar3.BTU.readString();
                    AppMethodBeat.o(124367);
                    return 0;
                case 6:
                    chp.xgv = aVar3.BTU.readString();
                    AppMethodBeat.o(124367);
                    return 0;
                case 7:
                    chp.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(124367);
                    return 0;
                case 8:
                    chp.wDM = aVar3.BTU.readString();
                    AppMethodBeat.o(124367);
                    return 0;
                case 9:
                    chp.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(124367);
                    return 0;
                case 10:
                    chp.vGB = aVar3.BTU.vd();
                    AppMethodBeat.o(124367);
                    return 0;
                case 11:
                    chp.xgw = aVar3.BTU.readString();
                    AppMethodBeat.o(124367);
                    return 0;
                case 12:
                    chp.wbI = aVar3.BTU.readString();
                    AppMethodBeat.o(124367);
                    return 0;
                case 13:
                    chp.vFH = aVar3.BTU.vd();
                    AppMethodBeat.o(124367);
                    return 0;
                default:
                    AppMethodBeat.o(124367);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124367);
            return -1;
        }
    }
}
