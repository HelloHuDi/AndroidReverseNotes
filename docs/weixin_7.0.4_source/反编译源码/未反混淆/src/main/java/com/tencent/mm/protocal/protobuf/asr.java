package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class asr extends a {
    public String IconUrl;
    public int dFp;
    public long dFq;
    public String dFr;
    public String dFs;
    public String dFt;
    public String dFu;
    public String guS;
    public String mZj;
    public String vHO;
    public String vKF;
    public String wwm;
    public String wwn;
    public int wwo;
    public int wwp;
    public int wwq;
    public int wwr;
    public String wws;
    public String wwt;
    public String wwu;
    public String wwv;
    public int www;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10190);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wwm != null) {
                aVar.e(1, this.wwm);
            }
            if (this.vHO != null) {
                aVar.e(2, this.vHO);
            }
            if (this.vKF != null) {
                aVar.e(3, this.vKF);
            }
            if (this.wwn != null) {
                aVar.e(4, this.wwn);
            }
            aVar.iz(5, this.wwo);
            aVar.iz(6, this.wwp);
            aVar.iz(7, this.wwq);
            aVar.iz(8, this.wwr);
            if (this.wws != null) {
                aVar.e(9, this.wws);
            }
            if (this.guS != null) {
                aVar.e(10, this.guS);
            }
            if (this.IconUrl != null) {
                aVar.e(11, this.IconUrl);
            }
            if (this.mZj != null) {
                aVar.e(12, this.mZj);
            }
            if (this.wwt != null) {
                aVar.e(13, this.wwt);
            }
            if (this.wwu != null) {
                aVar.e(14, this.wwu);
            }
            if (this.wwv != null) {
                aVar.e(15, this.wwv);
            }
            aVar.iz(16, this.www);
            aVar.iz(17, this.dFp);
            aVar.ai(18, this.dFq);
            if (this.dFr != null) {
                aVar.e(19, this.dFr);
            }
            if (this.dFs != null) {
                aVar.e(20, this.dFs);
            }
            if (this.dFt != null) {
                aVar.e(21, this.dFt);
            }
            if (this.dFu != null) {
                aVar.e(22, this.dFu);
            }
            AppMethodBeat.o(10190);
            return 0;
        } else if (i == 1) {
            if (this.wwm != null) {
                f = e.a.a.b.b.a.f(1, this.wwm) + 0;
            } else {
                f = 0;
            }
            if (this.vHO != null) {
                f += e.a.a.b.b.a.f(2, this.vHO);
            }
            if (this.vKF != null) {
                f += e.a.a.b.b.a.f(3, this.vKF);
            }
            if (this.wwn != null) {
                f += e.a.a.b.b.a.f(4, this.wwn);
            }
            f = (((f + e.a.a.b.b.a.bs(5, this.wwo)) + e.a.a.b.b.a.bs(6, this.wwp)) + e.a.a.b.b.a.bs(7, this.wwq)) + e.a.a.b.b.a.bs(8, this.wwr);
            if (this.wws != null) {
                f += e.a.a.b.b.a.f(9, this.wws);
            }
            if (this.guS != null) {
                f += e.a.a.b.b.a.f(10, this.guS);
            }
            if (this.IconUrl != null) {
                f += e.a.a.b.b.a.f(11, this.IconUrl);
            }
            if (this.mZj != null) {
                f += e.a.a.b.b.a.f(12, this.mZj);
            }
            if (this.wwt != null) {
                f += e.a.a.b.b.a.f(13, this.wwt);
            }
            if (this.wwu != null) {
                f += e.a.a.b.b.a.f(14, this.wwu);
            }
            if (this.wwv != null) {
                f += e.a.a.b.b.a.f(15, this.wwv);
            }
            f = ((f + e.a.a.b.b.a.bs(16, this.www)) + e.a.a.b.b.a.bs(17, this.dFp)) + e.a.a.b.b.a.o(18, this.dFq);
            if (this.dFr != null) {
                f += e.a.a.b.b.a.f(19, this.dFr);
            }
            if (this.dFs != null) {
                f += e.a.a.b.b.a.f(20, this.dFs);
            }
            if (this.dFt != null) {
                f += e.a.a.b.b.a.f(21, this.dFt);
            }
            if (this.dFu != null) {
                f += e.a.a.b.b.a.f(22, this.dFu);
            }
            AppMethodBeat.o(10190);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(10190);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            asr asr = (asr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    asr.wwm = aVar3.BTU.readString();
                    AppMethodBeat.o(10190);
                    return 0;
                case 2:
                    asr.vHO = aVar3.BTU.readString();
                    AppMethodBeat.o(10190);
                    return 0;
                case 3:
                    asr.vKF = aVar3.BTU.readString();
                    AppMethodBeat.o(10190);
                    return 0;
                case 4:
                    asr.wwn = aVar3.BTU.readString();
                    AppMethodBeat.o(10190);
                    return 0;
                case 5:
                    asr.wwo = aVar3.BTU.vd();
                    AppMethodBeat.o(10190);
                    return 0;
                case 6:
                    asr.wwp = aVar3.BTU.vd();
                    AppMethodBeat.o(10190);
                    return 0;
                case 7:
                    asr.wwq = aVar3.BTU.vd();
                    AppMethodBeat.o(10190);
                    return 0;
                case 8:
                    asr.wwr = aVar3.BTU.vd();
                    AppMethodBeat.o(10190);
                    return 0;
                case 9:
                    asr.wws = aVar3.BTU.readString();
                    AppMethodBeat.o(10190);
                    return 0;
                case 10:
                    asr.guS = aVar3.BTU.readString();
                    AppMethodBeat.o(10190);
                    return 0;
                case 11:
                    asr.IconUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(10190);
                    return 0;
                case 12:
                    asr.mZj = aVar3.BTU.readString();
                    AppMethodBeat.o(10190);
                    return 0;
                case 13:
                    asr.wwt = aVar3.BTU.readString();
                    AppMethodBeat.o(10190);
                    return 0;
                case 14:
                    asr.wwu = aVar3.BTU.readString();
                    AppMethodBeat.o(10190);
                    return 0;
                case 15:
                    asr.wwv = aVar3.BTU.readString();
                    AppMethodBeat.o(10190);
                    return 0;
                case 16:
                    asr.www = aVar3.BTU.vd();
                    AppMethodBeat.o(10190);
                    return 0;
                case 17:
                    asr.dFp = aVar3.BTU.vd();
                    AppMethodBeat.o(10190);
                    return 0;
                case 18:
                    asr.dFq = aVar3.BTU.ve();
                    AppMethodBeat.o(10190);
                    return 0;
                case 19:
                    asr.dFr = aVar3.BTU.readString();
                    AppMethodBeat.o(10190);
                    return 0;
                case 20:
                    asr.dFs = aVar3.BTU.readString();
                    AppMethodBeat.o(10190);
                    return 0;
                case 21:
                    asr.dFt = aVar3.BTU.readString();
                    AppMethodBeat.o(10190);
                    return 0;
                case 22:
                    asr.dFu = aVar3.BTU.readString();
                    AppMethodBeat.o(10190);
                    return 0;
                default:
                    AppMethodBeat.o(10190);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10190);
            return -1;
        }
    }
}
