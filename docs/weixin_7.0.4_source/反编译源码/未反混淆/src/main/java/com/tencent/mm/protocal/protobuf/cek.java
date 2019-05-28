package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class cek extends a {
    public String Id;
    public String Url;
    public int cNE;
    public int cuu;
    public String cvZ;
    public float duration;
    public int jCt;
    public int wEG;
    public String wEH;
    public int wEI;
    public int wET;
    public long wEU;
    public String wEV;
    public String wEW;
    public int wEX;
    public String wEY;
    public String wEZ;
    public int wFa;
    public String wFb;
    public String wFc;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56527);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Id != null) {
                aVar.e(1, this.Id);
            }
            aVar.iz(2, this.jCt);
            if (this.Url != null) {
                aVar.e(3, this.Url);
            }
            aVar.iz(4, this.wEG);
            if (this.wEH != null) {
                aVar.e(5, this.wEH);
            }
            aVar.iz(6, this.wEI);
            aVar.iz(7, this.cuu);
            if (this.cvZ != null) {
                aVar.e(8, this.cvZ);
            }
            if (this.wFc != null) {
                aVar.e(9, this.wFc);
            }
            aVar.iz(10, this.cNE);
            aVar.iz(11, this.wET);
            aVar.ai(12, this.wEU);
            if (this.wEV != null) {
                aVar.e(13, this.wEV);
            }
            if (this.wEW != null) {
                aVar.e(14, this.wEW);
            }
            aVar.iz(15, this.wEX);
            if (this.wEY != null) {
                aVar.e(16, this.wEY);
            }
            if (this.wEZ != null) {
                aVar.e(17, this.wEZ);
            }
            aVar.iz(18, this.wFa);
            if (this.wFb != null) {
                aVar.e(19, this.wFb);
            }
            aVar.r(20, this.duration);
            AppMethodBeat.o(56527);
            return 0;
        } else if (i == 1) {
            if (this.Id != null) {
                f = e.a.a.b.b.a.f(1, this.Id) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.jCt);
            if (this.Url != null) {
                f += e.a.a.b.b.a.f(3, this.Url);
            }
            f += e.a.a.b.b.a.bs(4, this.wEG);
            if (this.wEH != null) {
                f += e.a.a.b.b.a.f(5, this.wEH);
            }
            f = (f + e.a.a.b.b.a.bs(6, this.wEI)) + e.a.a.b.b.a.bs(7, this.cuu);
            if (this.cvZ != null) {
                f += e.a.a.b.b.a.f(8, this.cvZ);
            }
            if (this.wFc != null) {
                f += e.a.a.b.b.a.f(9, this.wFc);
            }
            f = ((f + e.a.a.b.b.a.bs(10, this.cNE)) + e.a.a.b.b.a.bs(11, this.wET)) + e.a.a.b.b.a.o(12, this.wEU);
            if (this.wEV != null) {
                f += e.a.a.b.b.a.f(13, this.wEV);
            }
            if (this.wEW != null) {
                f += e.a.a.b.b.a.f(14, this.wEW);
            }
            f += e.a.a.b.b.a.bs(15, this.wEX);
            if (this.wEY != null) {
                f += e.a.a.b.b.a.f(16, this.wEY);
            }
            if (this.wEZ != null) {
                f += e.a.a.b.b.a.f(17, this.wEZ);
            }
            f += e.a.a.b.b.a.bs(18, this.wFa);
            if (this.wFb != null) {
                f += e.a.a.b.b.a.f(19, this.wFb);
            }
            int fv = f + (e.a.a.b.b.a.fv(20) + 4);
            AppMethodBeat.o(56527);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56527);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cek cek = (cek) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cek.Id = aVar3.BTU.readString();
                    AppMethodBeat.o(56527);
                    return 0;
                case 2:
                    cek.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(56527);
                    return 0;
                case 3:
                    cek.Url = aVar3.BTU.readString();
                    AppMethodBeat.o(56527);
                    return 0;
                case 4:
                    cek.wEG = aVar3.BTU.vd();
                    AppMethodBeat.o(56527);
                    return 0;
                case 5:
                    cek.wEH = aVar3.BTU.readString();
                    AppMethodBeat.o(56527);
                    return 0;
                case 6:
                    cek.wEI = aVar3.BTU.vd();
                    AppMethodBeat.o(56527);
                    return 0;
                case 7:
                    cek.cuu = aVar3.BTU.vd();
                    AppMethodBeat.o(56527);
                    return 0;
                case 8:
                    cek.cvZ = aVar3.BTU.readString();
                    AppMethodBeat.o(56527);
                    return 0;
                case 9:
                    cek.wFc = aVar3.BTU.readString();
                    AppMethodBeat.o(56527);
                    return 0;
                case 10:
                    cek.cNE = aVar3.BTU.vd();
                    AppMethodBeat.o(56527);
                    return 0;
                case 11:
                    cek.wET = aVar3.BTU.vd();
                    AppMethodBeat.o(56527);
                    return 0;
                case 12:
                    cek.wEU = aVar3.BTU.ve();
                    AppMethodBeat.o(56527);
                    return 0;
                case 13:
                    cek.wEV = aVar3.BTU.readString();
                    AppMethodBeat.o(56527);
                    return 0;
                case 14:
                    cek.wEW = aVar3.BTU.readString();
                    AppMethodBeat.o(56527);
                    return 0;
                case 15:
                    cek.wEX = aVar3.BTU.vd();
                    AppMethodBeat.o(56527);
                    return 0;
                case 16:
                    cek.wEY = aVar3.BTU.readString();
                    AppMethodBeat.o(56527);
                    return 0;
                case 17:
                    cek.wEZ = aVar3.BTU.readString();
                    AppMethodBeat.o(56527);
                    return 0;
                case 18:
                    cek.wFa = aVar3.BTU.vd();
                    AppMethodBeat.o(56527);
                    return 0;
                case 19:
                    cek.wFb = aVar3.BTU.readString();
                    AppMethodBeat.o(56527);
                    return 0;
                case 20:
                    cek.duration = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(56527);
                    return 0;
                default:
                    AppMethodBeat.o(56527);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56527);
            return -1;
        }
    }
}
