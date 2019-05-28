package com.tencent.mm.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class p extends a {
    public String fgd;
    public int fjA;
    public int fjB;
    public String fjC;
    public String fjD;
    public int fjE;
    public int fjF;
    public String fjG;
    public String fjH;
    public String fjI;
    public String fjJ;
    public String fjK;
    public String fjL;
    public int fjM;
    public int fjN;
    public String fjO;
    public String fjv;
    public String fjw;
    public String fjx;
    public String fjy;
    public String fjz;
    public long time;
    public String title;
    public int type;
    public String url;
    public int videoHeight;
    public int videoWidth;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(105479);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.fjv != null) {
                aVar.e(3, this.fjv);
            }
            if (this.fjw != null) {
                aVar.e(4, this.fjw);
            }
            aVar.ai(5, this.time);
            if (this.fjx != null) {
                aVar.e(6, this.fjx);
            }
            if (this.fjy != null) {
                aVar.e(7, this.fjy);
            }
            if (this.fjz != null) {
                aVar.e(8, this.fjz);
            }
            aVar.iz(9, this.type);
            aVar.iz(10, this.fjA);
            aVar.iz(11, this.fjB);
            if (this.fjC != null) {
                aVar.e(12, this.fjC);
            }
            if (this.fjD != null) {
                aVar.e(13, this.fjD);
            }
            aVar.iz(14, this.fjE);
            aVar.iz(15, this.fjF);
            if (this.fjG != null) {
                aVar.e(16, this.fjG);
            }
            if (this.fjH != null) {
                aVar.e(17, this.fjH);
            }
            if (this.fjI != null) {
                aVar.e(18, this.fjI);
            }
            if (this.fjJ != null) {
                aVar.e(19, this.fjJ);
            }
            if (this.fjK != null) {
                aVar.e(20, this.fjK);
            }
            if (this.fjL != null) {
                aVar.e(21, this.fjL);
            }
            aVar.iz(22, this.fjM);
            aVar.iz(23, this.fjN);
            if (this.fjO != null) {
                aVar.e(24, this.fjO);
            }
            aVar.iz(25, this.videoWidth);
            aVar.iz(26, this.videoHeight);
            if (this.fgd != null) {
                aVar.e(27, this.fgd);
            }
            AppMethodBeat.o(105479);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = e.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.url != null) {
                f += e.a.a.b.b.a.f(2, this.url);
            }
            if (this.fjv != null) {
                f += e.a.a.b.b.a.f(3, this.fjv);
            }
            if (this.fjw != null) {
                f += e.a.a.b.b.a.f(4, this.fjw);
            }
            f += e.a.a.b.b.a.o(5, this.time);
            if (this.fjx != null) {
                f += e.a.a.b.b.a.f(6, this.fjx);
            }
            if (this.fjy != null) {
                f += e.a.a.b.b.a.f(7, this.fjy);
            }
            if (this.fjz != null) {
                f += e.a.a.b.b.a.f(8, this.fjz);
            }
            f = ((f + e.a.a.b.b.a.bs(9, this.type)) + e.a.a.b.b.a.bs(10, this.fjA)) + e.a.a.b.b.a.bs(11, this.fjB);
            if (this.fjC != null) {
                f += e.a.a.b.b.a.f(12, this.fjC);
            }
            if (this.fjD != null) {
                f += e.a.a.b.b.a.f(13, this.fjD);
            }
            f = (f + e.a.a.b.b.a.bs(14, this.fjE)) + e.a.a.b.b.a.bs(15, this.fjF);
            if (this.fjG != null) {
                f += e.a.a.b.b.a.f(16, this.fjG);
            }
            if (this.fjH != null) {
                f += e.a.a.b.b.a.f(17, this.fjH);
            }
            if (this.fjI != null) {
                f += e.a.a.b.b.a.f(18, this.fjI);
            }
            if (this.fjJ != null) {
                f += e.a.a.b.b.a.f(19, this.fjJ);
            }
            if (this.fjK != null) {
                f += e.a.a.b.b.a.f(20, this.fjK);
            }
            if (this.fjL != null) {
                f += e.a.a.b.b.a.f(21, this.fjL);
            }
            f = (f + e.a.a.b.b.a.bs(22, this.fjM)) + e.a.a.b.b.a.bs(23, this.fjN);
            if (this.fjO != null) {
                f += e.a.a.b.b.a.f(24, this.fjO);
            }
            f = (f + e.a.a.b.b.a.bs(25, this.videoWidth)) + e.a.a.b.b.a.bs(26, this.videoHeight);
            if (this.fgd != null) {
                f += e.a.a.b.b.a.f(27, this.fgd);
            }
            AppMethodBeat.o(105479);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(105479);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            p pVar = (p) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pVar.title = aVar3.BTU.readString();
                    AppMethodBeat.o(105479);
                    return 0;
                case 2:
                    pVar.url = aVar3.BTU.readString();
                    AppMethodBeat.o(105479);
                    return 0;
                case 3:
                    pVar.fjv = aVar3.BTU.readString();
                    AppMethodBeat.o(105479);
                    return 0;
                case 4:
                    pVar.fjw = aVar3.BTU.readString();
                    AppMethodBeat.o(105479);
                    return 0;
                case 5:
                    pVar.time = aVar3.BTU.ve();
                    AppMethodBeat.o(105479);
                    return 0;
                case 6:
                    pVar.fjx = aVar3.BTU.readString();
                    AppMethodBeat.o(105479);
                    return 0;
                case 7:
                    pVar.fjy = aVar3.BTU.readString();
                    AppMethodBeat.o(105479);
                    return 0;
                case 8:
                    pVar.fjz = aVar3.BTU.readString();
                    AppMethodBeat.o(105479);
                    return 0;
                case 9:
                    pVar.type = aVar3.BTU.vd();
                    AppMethodBeat.o(105479);
                    return 0;
                case 10:
                    pVar.fjA = aVar3.BTU.vd();
                    AppMethodBeat.o(105479);
                    return 0;
                case 11:
                    pVar.fjB = aVar3.BTU.vd();
                    AppMethodBeat.o(105479);
                    return 0;
                case 12:
                    pVar.fjC = aVar3.BTU.readString();
                    AppMethodBeat.o(105479);
                    return 0;
                case 13:
                    pVar.fjD = aVar3.BTU.readString();
                    AppMethodBeat.o(105479);
                    return 0;
                case 14:
                    pVar.fjE = aVar3.BTU.vd();
                    AppMethodBeat.o(105479);
                    return 0;
                case 15:
                    pVar.fjF = aVar3.BTU.vd();
                    AppMethodBeat.o(105479);
                    return 0;
                case 16:
                    pVar.fjG = aVar3.BTU.readString();
                    AppMethodBeat.o(105479);
                    return 0;
                case 17:
                    pVar.fjH = aVar3.BTU.readString();
                    AppMethodBeat.o(105479);
                    return 0;
                case 18:
                    pVar.fjI = aVar3.BTU.readString();
                    AppMethodBeat.o(105479);
                    return 0;
                case 19:
                    pVar.fjJ = aVar3.BTU.readString();
                    AppMethodBeat.o(105479);
                    return 0;
                case 20:
                    pVar.fjK = aVar3.BTU.readString();
                    AppMethodBeat.o(105479);
                    return 0;
                case 21:
                    pVar.fjL = aVar3.BTU.readString();
                    AppMethodBeat.o(105479);
                    return 0;
                case 22:
                    pVar.fjM = aVar3.BTU.vd();
                    AppMethodBeat.o(105479);
                    return 0;
                case 23:
                    pVar.fjN = aVar3.BTU.vd();
                    AppMethodBeat.o(105479);
                    return 0;
                case 24:
                    pVar.fjO = aVar3.BTU.readString();
                    AppMethodBeat.o(105479);
                    return 0;
                case 25:
                    pVar.videoWidth = aVar3.BTU.vd();
                    AppMethodBeat.o(105479);
                    return 0;
                case 26:
                    pVar.videoHeight = aVar3.BTU.vd();
                    AppMethodBeat.o(105479);
                    return 0;
                case 27:
                    pVar.fgd = aVar3.BTU.readString();
                    AppMethodBeat.o(105479);
                    return 0;
                default:
                    AppMethodBeat.o(105479);
                    return -1;
            }
        } else {
            AppMethodBeat.o(105479);
            return -1;
        }
    }
}
