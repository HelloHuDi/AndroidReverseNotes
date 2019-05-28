package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cht extends a {
    public String cIY;
    public String cJb;
    public int dtW;
    public String extInfo;
    public int fQi;
    public long fRS;
    public int tZU;
    public String text;
    public int type;
    public int uaU;
    public int uaV;
    public int uaW;
    public int xgA;
    public long xgB;
    public long xgz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(55706);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.cJb != null) {
                aVar.e(1, this.cJb);
            }
            aVar.iz(2, this.uaU);
            aVar.iz(3, this.uaV);
            aVar.ai(4, this.fRS);
            aVar.iz(5, this.tZU);
            aVar.iz(6, this.type);
            if (this.text != null) {
                aVar.e(7, this.text);
            }
            if (this.cIY != null) {
                aVar.e(8, this.cIY);
            }
            aVar.ai(9, this.xgz);
            aVar.iz(10, this.uaW);
            aVar.iz(11, this.xgA);
            aVar.ai(12, this.xgB);
            aVar.iz(13, this.dtW);
            aVar.iz(14, this.fQi);
            if (this.extInfo != null) {
                aVar.e(15, this.extInfo);
            }
            AppMethodBeat.o(55706);
            return 0;
        } else if (i == 1) {
            if (this.cJb != null) {
                f = e.a.a.b.b.a.f(1, this.cJb) + 0;
            } else {
                f = 0;
            }
            f = ((((f + e.a.a.b.b.a.bs(2, this.uaU)) + e.a.a.b.b.a.bs(3, this.uaV)) + e.a.a.b.b.a.o(4, this.fRS)) + e.a.a.b.b.a.bs(5, this.tZU)) + e.a.a.b.b.a.bs(6, this.type);
            if (this.text != null) {
                f += e.a.a.b.b.a.f(7, this.text);
            }
            if (this.cIY != null) {
                f += e.a.a.b.b.a.f(8, this.cIY);
            }
            f = (((((f + e.a.a.b.b.a.o(9, this.xgz)) + e.a.a.b.b.a.bs(10, this.uaW)) + e.a.a.b.b.a.bs(11, this.xgA)) + e.a.a.b.b.a.o(12, this.xgB)) + e.a.a.b.b.a.bs(13, this.dtW)) + e.a.a.b.b.a.bs(14, this.fQi);
            if (this.extInfo != null) {
                f += e.a.a.b.b.a.f(15, this.extInfo);
            }
            AppMethodBeat.o(55706);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(55706);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cht cht = (cht) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cht.cJb = aVar3.BTU.readString();
                    AppMethodBeat.o(55706);
                    return 0;
                case 2:
                    cht.uaU = aVar3.BTU.vd();
                    AppMethodBeat.o(55706);
                    return 0;
                case 3:
                    cht.uaV = aVar3.BTU.vd();
                    AppMethodBeat.o(55706);
                    return 0;
                case 4:
                    cht.fRS = aVar3.BTU.ve();
                    AppMethodBeat.o(55706);
                    return 0;
                case 5:
                    cht.tZU = aVar3.BTU.vd();
                    AppMethodBeat.o(55706);
                    return 0;
                case 6:
                    cht.type = aVar3.BTU.vd();
                    AppMethodBeat.o(55706);
                    return 0;
                case 7:
                    cht.text = aVar3.BTU.readString();
                    AppMethodBeat.o(55706);
                    return 0;
                case 8:
                    cht.cIY = aVar3.BTU.readString();
                    AppMethodBeat.o(55706);
                    return 0;
                case 9:
                    cht.xgz = aVar3.BTU.ve();
                    AppMethodBeat.o(55706);
                    return 0;
                case 10:
                    cht.uaW = aVar3.BTU.vd();
                    AppMethodBeat.o(55706);
                    return 0;
                case 11:
                    cht.xgA = aVar3.BTU.vd();
                    AppMethodBeat.o(55706);
                    return 0;
                case 12:
                    cht.xgB = aVar3.BTU.ve();
                    AppMethodBeat.o(55706);
                    return 0;
                case 13:
                    cht.dtW = aVar3.BTU.vd();
                    AppMethodBeat.o(55706);
                    return 0;
                case 14:
                    cht.fQi = aVar3.BTU.vd();
                    AppMethodBeat.o(55706);
                    return 0;
                case 15:
                    cht.extInfo = aVar3.BTU.readString();
                    AppMethodBeat.o(55706);
                    return 0;
                default:
                    AppMethodBeat.o(55706);
                    return -1;
            }
        } else {
            AppMethodBeat.o(55706);
            return -1;
        }
    }
}
