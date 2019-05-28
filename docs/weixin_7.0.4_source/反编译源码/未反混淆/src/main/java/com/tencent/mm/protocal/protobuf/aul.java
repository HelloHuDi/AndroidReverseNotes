package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class aul extends a {
    public int wyA;
    public int wyB;
    public int wyC;
    public int wyD;
    public float wyE;
    public float wyF;
    public float wyG;
    public String wyv;
    public String wyw;
    public long wyx;
    public int wyy;
    public int wyz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(54937);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wyv != null) {
                aVar.e(1, this.wyv);
            }
            if (this.wyw != null) {
                aVar.e(2, this.wyw);
            }
            aVar.ai(3, this.wyx);
            aVar.iz(4, this.wyy);
            aVar.iz(5, this.wyz);
            aVar.iz(6, this.wyA);
            aVar.iz(7, this.wyB);
            aVar.iz(8, this.wyC);
            aVar.iz(9, this.wyD);
            aVar.r(10, this.wyE);
            aVar.r(11, this.wyF);
            aVar.r(12, this.wyG);
            AppMethodBeat.o(54937);
            return 0;
        } else if (i == 1) {
            if (this.wyv != null) {
                f = e.a.a.b.b.a.f(1, this.wyv) + 0;
            } else {
                f = 0;
            }
            if (this.wyw != null) {
                f += e.a.a.b.b.a.f(2, this.wyw);
            }
            int o = (((((((((f + e.a.a.b.b.a.o(3, this.wyx)) + e.a.a.b.b.a.bs(4, this.wyy)) + e.a.a.b.b.a.bs(5, this.wyz)) + e.a.a.b.b.a.bs(6, this.wyA)) + e.a.a.b.b.a.bs(7, this.wyB)) + e.a.a.b.b.a.bs(8, this.wyC)) + e.a.a.b.b.a.bs(9, this.wyD)) + (e.a.a.b.b.a.fv(10) + 4)) + (e.a.a.b.b.a.fv(11) + 4)) + (e.a.a.b.b.a.fv(12) + 4);
            AppMethodBeat.o(54937);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(54937);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aul aul = (aul) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aul.wyv = aVar3.BTU.readString();
                    AppMethodBeat.o(54937);
                    return 0;
                case 2:
                    aul.wyw = aVar3.BTU.readString();
                    AppMethodBeat.o(54937);
                    return 0;
                case 3:
                    aul.wyx = aVar3.BTU.ve();
                    AppMethodBeat.o(54937);
                    return 0;
                case 4:
                    aul.wyy = aVar3.BTU.vd();
                    AppMethodBeat.o(54937);
                    return 0;
                case 5:
                    aul.wyz = aVar3.BTU.vd();
                    AppMethodBeat.o(54937);
                    return 0;
                case 6:
                    aul.wyA = aVar3.BTU.vd();
                    AppMethodBeat.o(54937);
                    return 0;
                case 7:
                    aul.wyB = aVar3.BTU.vd();
                    AppMethodBeat.o(54937);
                    return 0;
                case 8:
                    aul.wyC = aVar3.BTU.vd();
                    AppMethodBeat.o(54937);
                    return 0;
                case 9:
                    aul.wyD = aVar3.BTU.vd();
                    AppMethodBeat.o(54937);
                    return 0;
                case 10:
                    aul.wyE = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(54937);
                    return 0;
                case 11:
                    aul.wyF = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(54937);
                    return 0;
                case 12:
                    aul.wyG = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(54937);
                    return 0;
                default:
                    AppMethodBeat.o(54937);
                    return -1;
            }
        } else {
            AppMethodBeat.o(54937);
            return -1;
        }
    }
}
