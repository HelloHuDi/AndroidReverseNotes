package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cwt extends a {
    public int cOq;
    public String cOr;
    public String fKh;
    public String iBB;
    public int iBG;
    public int jCt;
    public int lvf;
    public int pXC;
    public int pXD;
    public int ugc;
    public String vGA;
    public String xso;
    public String xsp;
    public int xsq;
    public String xsr;
    public int xss;
    public String xst;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96330);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.jCt);
            if (this.fKh != null) {
                aVar.e(2, this.fKh);
            }
            if (this.xso != null) {
                aVar.e(3, this.xso);
            }
            aVar.iz(4, this.pXC);
            aVar.iz(5, this.lvf);
            aVar.iz(6, this.pXD);
            if (this.xsp != null) {
                aVar.e(7, this.xsp);
            }
            aVar.iz(8, this.xsq);
            if (this.vGA != null) {
                aVar.e(9, this.vGA);
            }
            if (this.xsr != null) {
                aVar.e(10, this.xsr);
            }
            aVar.iz(11, this.ugc);
            aVar.iz(12, this.xss);
            if (this.xst != null) {
                aVar.e(13, this.xst);
            }
            if (this.iBB != null) {
                aVar.e(14, this.iBB);
            }
            aVar.iz(15, this.cOq);
            if (this.cOr != null) {
                aVar.e(16, this.cOr);
            }
            aVar.iz(17, this.iBG);
            AppMethodBeat.o(96330);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.jCt) + 0;
            if (this.fKh != null) {
                bs += e.a.a.b.b.a.f(2, this.fKh);
            }
            if (this.xso != null) {
                bs += e.a.a.b.b.a.f(3, this.xso);
            }
            bs = ((bs + e.a.a.b.b.a.bs(4, this.pXC)) + e.a.a.b.b.a.bs(5, this.lvf)) + e.a.a.b.b.a.bs(6, this.pXD);
            if (this.xsp != null) {
                bs += e.a.a.b.b.a.f(7, this.xsp);
            }
            bs += e.a.a.b.b.a.bs(8, this.xsq);
            if (this.vGA != null) {
                bs += e.a.a.b.b.a.f(9, this.vGA);
            }
            if (this.xsr != null) {
                bs += e.a.a.b.b.a.f(10, this.xsr);
            }
            bs = (bs + e.a.a.b.b.a.bs(11, this.ugc)) + e.a.a.b.b.a.bs(12, this.xss);
            if (this.xst != null) {
                bs += e.a.a.b.b.a.f(13, this.xst);
            }
            if (this.iBB != null) {
                bs += e.a.a.b.b.a.f(14, this.iBB);
            }
            bs += e.a.a.b.b.a.bs(15, this.cOq);
            if (this.cOr != null) {
                bs += e.a.a.b.b.a.f(16, this.cOr);
            }
            bs += e.a.a.b.b.a.bs(17, this.iBG);
            AppMethodBeat.o(96330);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96330);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cwt cwt = (cwt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cwt.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(96330);
                    return 0;
                case 2:
                    cwt.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(96330);
                    return 0;
                case 3:
                    cwt.xso = aVar3.BTU.readString();
                    AppMethodBeat.o(96330);
                    return 0;
                case 4:
                    cwt.pXC = aVar3.BTU.vd();
                    AppMethodBeat.o(96330);
                    return 0;
                case 5:
                    cwt.lvf = aVar3.BTU.vd();
                    AppMethodBeat.o(96330);
                    return 0;
                case 6:
                    cwt.pXD = aVar3.BTU.vd();
                    AppMethodBeat.o(96330);
                    return 0;
                case 7:
                    cwt.xsp = aVar3.BTU.readString();
                    AppMethodBeat.o(96330);
                    return 0;
                case 8:
                    cwt.xsq = aVar3.BTU.vd();
                    AppMethodBeat.o(96330);
                    return 0;
                case 9:
                    cwt.vGA = aVar3.BTU.readString();
                    AppMethodBeat.o(96330);
                    return 0;
                case 10:
                    cwt.xsr = aVar3.BTU.readString();
                    AppMethodBeat.o(96330);
                    return 0;
                case 11:
                    cwt.ugc = aVar3.BTU.vd();
                    AppMethodBeat.o(96330);
                    return 0;
                case 12:
                    cwt.xss = aVar3.BTU.vd();
                    AppMethodBeat.o(96330);
                    return 0;
                case 13:
                    cwt.xst = aVar3.BTU.readString();
                    AppMethodBeat.o(96330);
                    return 0;
                case 14:
                    cwt.iBB = aVar3.BTU.readString();
                    AppMethodBeat.o(96330);
                    return 0;
                case 15:
                    cwt.cOq = aVar3.BTU.vd();
                    AppMethodBeat.o(96330);
                    return 0;
                case 16:
                    cwt.cOr = aVar3.BTU.readString();
                    AppMethodBeat.o(96330);
                    return 0;
                case 17:
                    cwt.iBG = aVar3.BTU.vd();
                    AppMethodBeat.o(96330);
                    return 0;
                default:
                    AppMethodBeat.o(96330);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96330);
            return -1;
        }
    }
}
