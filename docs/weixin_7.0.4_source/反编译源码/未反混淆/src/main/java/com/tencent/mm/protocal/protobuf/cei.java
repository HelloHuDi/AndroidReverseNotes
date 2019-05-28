package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class cei extends a {
    public float bEJ;
    public String country;
    public String eUu;
    public String guP;
    public String rkg;
    public int rki;
    public int rkk;
    public int score;
    public float vRp;
    public float vRq;
    public String wCC;
    public String wCD;
    public int wCE;
    public int wCF;
    public b wCG;
    public String wCH;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56524);
        int fv;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.r(1, this.vRp);
            aVar.r(2, this.vRq);
            if (this.guP != null) {
                aVar.e(3, this.guP);
            }
            if (this.eUu != null) {
                aVar.e(4, this.eUu);
            }
            if (this.rkg != null) {
                aVar.e(5, this.rkg);
            }
            if (this.wCC != null) {
                aVar.e(6, this.wCC);
            }
            aVar.iz(7, this.rki);
            if (this.wCD != null) {
                aVar.e(8, this.wCD);
            }
            aVar.iz(9, this.wCE);
            aVar.iz(10, this.wCF);
            aVar.iz(11, this.rkk);
            aVar.r(12, this.bEJ);
            if (this.wCG != null) {
                aVar.c(13, this.wCG);
            }
            aVar.iz(14, this.score);
            if (this.wCH != null) {
                aVar.e(15, this.wCH);
            }
            if (this.country != null) {
                aVar.e(16, this.country);
            }
            AppMethodBeat.o(56524);
            return 0;
        } else if (i == 1) {
            fv = ((e.a.a.b.b.a.fv(1) + 4) + 0) + (e.a.a.b.b.a.fv(2) + 4);
            if (this.guP != null) {
                fv += e.a.a.b.b.a.f(3, this.guP);
            }
            if (this.eUu != null) {
                fv += e.a.a.b.b.a.f(4, this.eUu);
            }
            if (this.rkg != null) {
                fv += e.a.a.b.b.a.f(5, this.rkg);
            }
            if (this.wCC != null) {
                fv += e.a.a.b.b.a.f(6, this.wCC);
            }
            fv += e.a.a.b.b.a.bs(7, this.rki);
            if (this.wCD != null) {
                fv += e.a.a.b.b.a.f(8, this.wCD);
            }
            fv = (((fv + e.a.a.b.b.a.bs(9, this.wCE)) + e.a.a.b.b.a.bs(10, this.wCF)) + e.a.a.b.b.a.bs(11, this.rkk)) + (e.a.a.b.b.a.fv(12) + 4);
            if (this.wCG != null) {
                fv += e.a.a.b.b.a.b(13, this.wCG);
            }
            fv += e.a.a.b.b.a.bs(14, this.score);
            if (this.wCH != null) {
                fv += e.a.a.b.b.a.f(15, this.wCH);
            }
            if (this.country != null) {
                fv += e.a.a.b.b.a.f(16, this.country);
            }
            AppMethodBeat.o(56524);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56524);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cei cei = (cei) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cei.vRp = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(56524);
                    return 0;
                case 2:
                    cei.vRq = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(56524);
                    return 0;
                case 3:
                    cei.guP = aVar3.BTU.readString();
                    AppMethodBeat.o(56524);
                    return 0;
                case 4:
                    cei.eUu = aVar3.BTU.readString();
                    AppMethodBeat.o(56524);
                    return 0;
                case 5:
                    cei.rkg = aVar3.BTU.readString();
                    AppMethodBeat.o(56524);
                    return 0;
                case 6:
                    cei.wCC = aVar3.BTU.readString();
                    AppMethodBeat.o(56524);
                    return 0;
                case 7:
                    cei.rki = aVar3.BTU.vd();
                    AppMethodBeat.o(56524);
                    return 0;
                case 8:
                    cei.wCD = aVar3.BTU.readString();
                    AppMethodBeat.o(56524);
                    return 0;
                case 9:
                    cei.wCE = aVar3.BTU.vd();
                    AppMethodBeat.o(56524);
                    return 0;
                case 10:
                    cei.wCF = aVar3.BTU.vd();
                    AppMethodBeat.o(56524);
                    return 0;
                case 11:
                    cei.rkk = aVar3.BTU.vd();
                    AppMethodBeat.o(56524);
                    return 0;
                case 12:
                    cei.bEJ = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(56524);
                    return 0;
                case 13:
                    cei.wCG = aVar3.BTU.emu();
                    AppMethodBeat.o(56524);
                    return 0;
                case 14:
                    cei.score = aVar3.BTU.vd();
                    AppMethodBeat.o(56524);
                    return 0;
                case 15:
                    cei.wCH = aVar3.BTU.readString();
                    AppMethodBeat.o(56524);
                    return 0;
                case 16:
                    cei.country = aVar3.BTU.readString();
                    AppMethodBeat.o(56524);
                    return 0;
                default:
                    AppMethodBeat.o(56524);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56524);
            return -1;
        }
    }
}
