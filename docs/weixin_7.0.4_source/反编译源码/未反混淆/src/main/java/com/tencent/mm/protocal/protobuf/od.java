package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class od extends a {
    public float cEB;
    public float cGm;
    public String country;
    public String descriptor;
    public String duc;
    public String dud;
    public String fBg;
    public String kck;
    public String kdF;
    public String name;
    public float qVo;
    public String vTL;
    public String vTM;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89039);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.e(1, this.name);
            }
            if (this.descriptor != null) {
                aVar.e(2, this.descriptor);
            }
            if (this.kck != null) {
                aVar.e(3, this.kck);
            }
            if (this.country != null) {
                aVar.e(4, this.country);
            }
            if (this.duc != null) {
                aVar.e(5, this.duc);
            }
            if (this.dud != null) {
                aVar.e(6, this.dud);
            }
            if (this.fBg != null) {
                aVar.e(7, this.fBg);
            }
            aVar.r(8, this.qVo);
            aVar.r(9, this.cGm);
            aVar.r(10, this.cEB);
            if (this.kdF != null) {
                aVar.e(11, this.kdF);
            }
            if (this.vTL != null) {
                aVar.e(12, this.vTL);
            }
            if (this.vTM != null) {
                aVar.e(13, this.vTM);
            }
            AppMethodBeat.o(89039);
            return 0;
        } else if (i == 1) {
            if (this.name != null) {
                f = e.a.a.b.b.a.f(1, this.name) + 0;
            } else {
                f = 0;
            }
            if (this.descriptor != null) {
                f += e.a.a.b.b.a.f(2, this.descriptor);
            }
            if (this.kck != null) {
                f += e.a.a.b.b.a.f(3, this.kck);
            }
            if (this.country != null) {
                f += e.a.a.b.b.a.f(4, this.country);
            }
            if (this.duc != null) {
                f += e.a.a.b.b.a.f(5, this.duc);
            }
            if (this.dud != null) {
                f += e.a.a.b.b.a.f(6, this.dud);
            }
            if (this.fBg != null) {
                f += e.a.a.b.b.a.f(7, this.fBg);
            }
            f = ((f + (e.a.a.b.b.a.fv(8) + 4)) + (e.a.a.b.b.a.fv(9) + 4)) + (e.a.a.b.b.a.fv(10) + 4);
            if (this.kdF != null) {
                f += e.a.a.b.b.a.f(11, this.kdF);
            }
            if (this.vTL != null) {
                f += e.a.a.b.b.a.f(12, this.vTL);
            }
            if (this.vTM != null) {
                f += e.a.a.b.b.a.f(13, this.vTM);
            }
            AppMethodBeat.o(89039);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89039);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            od odVar = (od) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    odVar.name = aVar3.BTU.readString();
                    AppMethodBeat.o(89039);
                    return 0;
                case 2:
                    odVar.descriptor = aVar3.BTU.readString();
                    AppMethodBeat.o(89039);
                    return 0;
                case 3:
                    odVar.kck = aVar3.BTU.readString();
                    AppMethodBeat.o(89039);
                    return 0;
                case 4:
                    odVar.country = aVar3.BTU.readString();
                    AppMethodBeat.o(89039);
                    return 0;
                case 5:
                    odVar.duc = aVar3.BTU.readString();
                    AppMethodBeat.o(89039);
                    return 0;
                case 6:
                    odVar.dud = aVar3.BTU.readString();
                    AppMethodBeat.o(89039);
                    return 0;
                case 7:
                    odVar.fBg = aVar3.BTU.readString();
                    AppMethodBeat.o(89039);
                    return 0;
                case 8:
                    odVar.qVo = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(89039);
                    return 0;
                case 9:
                    odVar.cGm = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(89039);
                    return 0;
                case 10:
                    odVar.cEB = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(89039);
                    return 0;
                case 11:
                    odVar.kdF = aVar3.BTU.readString();
                    AppMethodBeat.o(89039);
                    return 0;
                case 12:
                    odVar.vTL = aVar3.BTU.readString();
                    AppMethodBeat.o(89039);
                    return 0;
                case 13:
                    odVar.vTM = aVar3.BTU.readString();
                    AppMethodBeat.o(89039);
                    return 0;
                default:
                    AppMethodBeat.o(89039);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89039);
            return -1;
        }
    }
}
