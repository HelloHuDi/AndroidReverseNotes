package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cdv extends a {
    public String ThumbUrl;
    public String ncM;
    public String ndF;
    public String ndG;
    public int pcX;
    public long vQE;
    public int wZF;
    public int wZG;
    public int wZH;
    public int wZL;
    public int xdA;
    public int xdB;
    public int xdC;
    public String xdy;
    public String xdz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56503);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.vQE);
            if (this.ndG != null) {
                aVar.e(2, this.ndG);
            }
            if (this.ndF != null) {
                aVar.e(3, this.ndF);
            }
            if (this.xdy != null) {
                aVar.e(4, this.xdy);
            }
            if (this.xdz != null) {
                aVar.e(5, this.xdz);
            }
            aVar.iz(6, this.pcX);
            if (this.ncM != null) {
                aVar.e(7, this.ncM);
            }
            aVar.iz(8, this.xdA);
            aVar.iz(9, this.wZL);
            aVar.iz(10, this.wZF);
            aVar.iz(11, this.wZG);
            aVar.iz(12, this.wZH);
            if (this.ThumbUrl != null) {
                aVar.e(13, this.ThumbUrl);
            }
            aVar.iz(14, this.xdB);
            aVar.iz(15, this.xdC);
            AppMethodBeat.o(56503);
            return 0;
        } else if (i == 1) {
            o = e.a.a.b.b.a.o(1, this.vQE) + 0;
            if (this.ndG != null) {
                o += e.a.a.b.b.a.f(2, this.ndG);
            }
            if (this.ndF != null) {
                o += e.a.a.b.b.a.f(3, this.ndF);
            }
            if (this.xdy != null) {
                o += e.a.a.b.b.a.f(4, this.xdy);
            }
            if (this.xdz != null) {
                o += e.a.a.b.b.a.f(5, this.xdz);
            }
            o += e.a.a.b.b.a.bs(6, this.pcX);
            if (this.ncM != null) {
                o += e.a.a.b.b.a.f(7, this.ncM);
            }
            o = ((((o + e.a.a.b.b.a.bs(8, this.xdA)) + e.a.a.b.b.a.bs(9, this.wZL)) + e.a.a.b.b.a.bs(10, this.wZF)) + e.a.a.b.b.a.bs(11, this.wZG)) + e.a.a.b.b.a.bs(12, this.wZH);
            if (this.ThumbUrl != null) {
                o += e.a.a.b.b.a.f(13, this.ThumbUrl);
            }
            o = (o + e.a.a.b.b.a.bs(14, this.xdB)) + e.a.a.b.b.a.bs(15, this.xdC);
            AppMethodBeat.o(56503);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56503);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cdv cdv = (cdv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cdv.vQE = aVar3.BTU.ve();
                    AppMethodBeat.o(56503);
                    return 0;
                case 2:
                    cdv.ndG = aVar3.BTU.readString();
                    AppMethodBeat.o(56503);
                    return 0;
                case 3:
                    cdv.ndF = aVar3.BTU.readString();
                    AppMethodBeat.o(56503);
                    return 0;
                case 4:
                    cdv.xdy = aVar3.BTU.readString();
                    AppMethodBeat.o(56503);
                    return 0;
                case 5:
                    cdv.xdz = aVar3.BTU.readString();
                    AppMethodBeat.o(56503);
                    return 0;
                case 6:
                    cdv.pcX = aVar3.BTU.vd();
                    AppMethodBeat.o(56503);
                    return 0;
                case 7:
                    cdv.ncM = aVar3.BTU.readString();
                    AppMethodBeat.o(56503);
                    return 0;
                case 8:
                    cdv.xdA = aVar3.BTU.vd();
                    AppMethodBeat.o(56503);
                    return 0;
                case 9:
                    cdv.wZL = aVar3.BTU.vd();
                    AppMethodBeat.o(56503);
                    return 0;
                case 10:
                    cdv.wZF = aVar3.BTU.vd();
                    AppMethodBeat.o(56503);
                    return 0;
                case 11:
                    cdv.wZG = aVar3.BTU.vd();
                    AppMethodBeat.o(56503);
                    return 0;
                case 12:
                    cdv.wZH = aVar3.BTU.vd();
                    AppMethodBeat.o(56503);
                    return 0;
                case 13:
                    cdv.ThumbUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(56503);
                    return 0;
                case 14:
                    cdv.xdB = aVar3.BTU.vd();
                    AppMethodBeat.o(56503);
                    return 0;
                case 15:
                    cdv.xdC = aVar3.BTU.vd();
                    AppMethodBeat.o(56503);
                    return 0;
                default:
                    AppMethodBeat.o(56503);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56503);
            return -1;
        }
    }
}
