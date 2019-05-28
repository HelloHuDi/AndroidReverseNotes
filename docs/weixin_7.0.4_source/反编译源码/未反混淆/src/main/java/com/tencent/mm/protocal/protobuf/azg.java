package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.plugin.appbrand.jsapi.e.g;

public final class azg extends a {
    public String csB;
    public String kKY;
    public int kLb;
    public String wDa;
    public String wDb;
    public String wDc;
    public String wDd;
    public int wDe;
    public String wDf;
    public int wDg;
    public int wDh;
    public String wDi;
    public int wDj;
    public int wDk;
    public String wDl;
    public int wDm;
    public int wDn;
    public String wDo;
    public String wDp;
    public String wDq;
    public String wDr;
    public int wcR;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80121);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.csB != null) {
                aVar.e(1, this.csB);
            }
            if (this.wDa != null) {
                aVar.e(20, this.wDa);
            }
            if (this.wDb != null) {
                aVar.e(21, this.wDb);
            }
            if (this.wDc != null) {
                aVar.e(22, this.wDc);
            }
            if (this.wDd != null) {
                aVar.e(23, this.wDd);
            }
            if (this.kKY != null) {
                aVar.e(31, this.kKY);
            }
            aVar.iz(32, this.kLb);
            aVar.iz(33, this.wDe);
            if (this.wDf != null) {
                aVar.e(34, this.wDf);
            }
            aVar.iz(35, this.wDg);
            aVar.iz(36, this.wDh);
            if (this.wDi != null) {
                aVar.e(37, this.wDi);
            }
            aVar.iz(38, this.wDj);
            aVar.iz(39, this.wDk);
            if (this.wDl != null) {
                aVar.e(41, this.wDl);
            }
            aVar.iz(200, this.wDm);
            aVar.iz(201, this.wDn);
            aVar.iz(202, this.wcR);
            if (this.wDo != null) {
                aVar.e(203, this.wDo);
            }
            if (this.wDp != null) {
                aVar.e(204, this.wDp);
            }
            if (this.wDq != null) {
                aVar.e(205, this.wDq);
            }
            if (this.wDr != null) {
                aVar.e(206, this.wDr);
            }
            AppMethodBeat.o(80121);
            return 0;
        } else if (i == 1) {
            if (this.csB != null) {
                f = e.a.a.b.b.a.f(1, this.csB) + 0;
            } else {
                f = 0;
            }
            if (this.wDa != null) {
                f += e.a.a.b.b.a.f(20, this.wDa);
            }
            if (this.wDb != null) {
                f += e.a.a.b.b.a.f(21, this.wDb);
            }
            if (this.wDc != null) {
                f += e.a.a.b.b.a.f(22, this.wDc);
            }
            if (this.wDd != null) {
                f += e.a.a.b.b.a.f(23, this.wDd);
            }
            if (this.kKY != null) {
                f += e.a.a.b.b.a.f(31, this.kKY);
            }
            f = (f + e.a.a.b.b.a.bs(32, this.kLb)) + e.a.a.b.b.a.bs(33, this.wDe);
            if (this.wDf != null) {
                f += e.a.a.b.b.a.f(34, this.wDf);
            }
            f = (f + e.a.a.b.b.a.bs(35, this.wDg)) + e.a.a.b.b.a.bs(36, this.wDh);
            if (this.wDi != null) {
                f += e.a.a.b.b.a.f(37, this.wDi);
            }
            f = (f + e.a.a.b.b.a.bs(38, this.wDj)) + e.a.a.b.b.a.bs(39, this.wDk);
            if (this.wDl != null) {
                f += e.a.a.b.b.a.f(41, this.wDl);
            }
            f = ((f + e.a.a.b.b.a.bs(200, this.wDm)) + e.a.a.b.b.a.bs(201, this.wDn)) + e.a.a.b.b.a.bs(202, this.wcR);
            if (this.wDo != null) {
                f += e.a.a.b.b.a.f(203, this.wDo);
            }
            if (this.wDp != null) {
                f += e.a.a.b.b.a.f(204, this.wDp);
            }
            if (this.wDq != null) {
                f += e.a.a.b.b.a.f(205, this.wDq);
            }
            if (this.wDr != null) {
                f += e.a.a.b.b.a.f(206, this.wDr);
            }
            AppMethodBeat.o(80121);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80121);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            azg azg = (azg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    azg.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(80121);
                    return 0;
                case 20:
                    azg.wDa = aVar3.BTU.readString();
                    AppMethodBeat.o(80121);
                    return 0;
                case 21:
                    azg.wDb = aVar3.BTU.readString();
                    AppMethodBeat.o(80121);
                    return 0;
                case 22:
                    azg.wDc = aVar3.BTU.readString();
                    AppMethodBeat.o(80121);
                    return 0;
                case 23:
                    azg.wDd = aVar3.BTU.readString();
                    AppMethodBeat.o(80121);
                    return 0;
                case 31:
                    azg.kKY = aVar3.BTU.readString();
                    AppMethodBeat.o(80121);
                    return 0;
                case 32:
                    azg.kLb = aVar3.BTU.vd();
                    AppMethodBeat.o(80121);
                    return 0;
                case 33:
                    azg.wDe = aVar3.BTU.vd();
                    AppMethodBeat.o(80121);
                    return 0;
                case 34:
                    azg.wDf = aVar3.BTU.readString();
                    AppMethodBeat.o(80121);
                    return 0;
                case 35:
                    azg.wDg = aVar3.BTU.vd();
                    AppMethodBeat.o(80121);
                    return 0;
                case 36:
                    azg.wDh = aVar3.BTU.vd();
                    AppMethodBeat.o(80121);
                    return 0;
                case g.CTRL_INDEX /*37*/:
                    azg.wDi = aVar3.BTU.readString();
                    AppMethodBeat.o(80121);
                    return 0;
                case 38:
                    azg.wDj = aVar3.BTU.vd();
                    AppMethodBeat.o(80121);
                    return 0;
                case 39:
                    azg.wDk = aVar3.BTU.vd();
                    AppMethodBeat.o(80121);
                    return 0;
                case 41:
                    azg.wDl = aVar3.BTU.readString();
                    AppMethodBeat.o(80121);
                    return 0;
                case 200:
                    azg.wDm = aVar3.BTU.vd();
                    AppMethodBeat.o(80121);
                    return 0;
                case 201:
                    azg.wDn = aVar3.BTU.vd();
                    AppMethodBeat.o(80121);
                    return 0;
                case 202:
                    azg.wcR = aVar3.BTU.vd();
                    AppMethodBeat.o(80121);
                    return 0;
                case 203:
                    azg.wDo = aVar3.BTU.readString();
                    AppMethodBeat.o(80121);
                    return 0;
                case 204:
                    azg.wDp = aVar3.BTU.readString();
                    AppMethodBeat.o(80121);
                    return 0;
                case 205:
                    azg.wDq = aVar3.BTU.readString();
                    AppMethodBeat.o(80121);
                    return 0;
                case 206:
                    azg.wDr = aVar3.BTU.readString();
                    AppMethodBeat.o(80121);
                    return 0;
                default:
                    AppMethodBeat.o(80121);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80121);
            return -1;
        }
    }
}
