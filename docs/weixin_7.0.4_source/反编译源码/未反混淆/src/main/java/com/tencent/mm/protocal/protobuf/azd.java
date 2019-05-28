package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class azd extends a {
    public String guM;
    public int guN;
    public String guO;
    public String guP;
    public String guQ;
    public int guR;
    public String guS;
    public int guT;
    public int guU;
    public String guV;
    public String guW;
    public String guX;
    public String vHl;
    public String vXm;
    public String vXn;
    public ccl wBZ;
    public String wCW;
    public zs wCX;
    public uy wCa;
    public String wlF;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73739);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vHl != null) {
                aVar.e(1, this.vHl);
            }
            if (this.wCW != null) {
                aVar.e(2, this.wCW);
            }
            if (this.guM != null) {
                aVar.e(3, this.guM);
            }
            aVar.iz(4, this.guN);
            if (this.guO != null) {
                aVar.e(5, this.guO);
            }
            if (this.guP != null) {
                aVar.e(6, this.guP);
            }
            if (this.guQ != null) {
                aVar.e(7, this.guQ);
            }
            aVar.iz(8, this.guR);
            if (this.guS != null) {
                aVar.e(9, this.guS);
            }
            if (this.wCX != null) {
                aVar.iy(10, this.wCX.computeSize());
                this.wCX.writeFields(aVar);
            }
            aVar.iz(11, this.guT);
            aVar.iz(12, this.guU);
            if (this.guV != null) {
                aVar.e(13, this.guV);
            }
            if (this.wBZ != null) {
                aVar.iy(14, this.wBZ.computeSize());
                this.wBZ.writeFields(aVar);
            }
            if (this.guW != null) {
                aVar.e(15, this.guW);
            }
            if (this.guX != null) {
                aVar.e(16, this.guX);
            }
            if (this.wCa != null) {
                aVar.iy(17, this.wCa.computeSize());
                this.wCa.writeFields(aVar);
            }
            if (this.vXm != null) {
                aVar.e(20, this.vXm);
            }
            if (this.vXn != null) {
                aVar.e(21, this.vXn);
            }
            if (this.wlF != null) {
                aVar.e(22, this.wlF);
            }
            AppMethodBeat.o(73739);
            return 0;
        } else if (i == 1) {
            if (this.vHl != null) {
                f = e.a.a.b.b.a.f(1, this.vHl) + 0;
            } else {
                f = 0;
            }
            if (this.wCW != null) {
                f += e.a.a.b.b.a.f(2, this.wCW);
            }
            if (this.guM != null) {
                f += e.a.a.b.b.a.f(3, this.guM);
            }
            f += e.a.a.b.b.a.bs(4, this.guN);
            if (this.guO != null) {
                f += e.a.a.b.b.a.f(5, this.guO);
            }
            if (this.guP != null) {
                f += e.a.a.b.b.a.f(6, this.guP);
            }
            if (this.guQ != null) {
                f += e.a.a.b.b.a.f(7, this.guQ);
            }
            f += e.a.a.b.b.a.bs(8, this.guR);
            if (this.guS != null) {
                f += e.a.a.b.b.a.f(9, this.guS);
            }
            if (this.wCX != null) {
                f += e.a.a.a.ix(10, this.wCX.computeSize());
            }
            f = (f + e.a.a.b.b.a.bs(11, this.guT)) + e.a.a.b.b.a.bs(12, this.guU);
            if (this.guV != null) {
                f += e.a.a.b.b.a.f(13, this.guV);
            }
            if (this.wBZ != null) {
                f += e.a.a.a.ix(14, this.wBZ.computeSize());
            }
            if (this.guW != null) {
                f += e.a.a.b.b.a.f(15, this.guW);
            }
            if (this.guX != null) {
                f += e.a.a.b.b.a.f(16, this.guX);
            }
            if (this.wCa != null) {
                f += e.a.a.a.ix(17, this.wCa.computeSize());
            }
            if (this.vXm != null) {
                f += e.a.a.b.b.a.f(20, this.vXm);
            }
            if (this.vXn != null) {
                f += e.a.a.b.b.a.f(21, this.vXn);
            }
            if (this.wlF != null) {
                f += e.a.a.b.b.a.f(22, this.wlF);
            }
            AppMethodBeat.o(73739);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(73739);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            azd azd = (azd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    azd.vHl = aVar3.BTU.readString();
                    AppMethodBeat.o(73739);
                    return 0;
                case 2:
                    azd.wCW = aVar3.BTU.readString();
                    AppMethodBeat.o(73739);
                    return 0;
                case 3:
                    azd.guM = aVar3.BTU.readString();
                    AppMethodBeat.o(73739);
                    return 0;
                case 4:
                    azd.guN = aVar3.BTU.vd();
                    AppMethodBeat.o(73739);
                    return 0;
                case 5:
                    azd.guO = aVar3.BTU.readString();
                    AppMethodBeat.o(73739);
                    return 0;
                case 6:
                    azd.guP = aVar3.BTU.readString();
                    AppMethodBeat.o(73739);
                    return 0;
                case 7:
                    azd.guQ = aVar3.BTU.readString();
                    AppMethodBeat.o(73739);
                    return 0;
                case 8:
                    azd.guR = aVar3.BTU.vd();
                    AppMethodBeat.o(73739);
                    return 0;
                case 9:
                    azd.guS = aVar3.BTU.readString();
                    AppMethodBeat.o(73739);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        zs zsVar = new zs();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = zsVar.populateBuilderWithField(aVar4, zsVar, a.getNextFieldNumber(aVar4))) {
                        }
                        azd.wCX = zsVar;
                    }
                    AppMethodBeat.o(73739);
                    return 0;
                case 11:
                    azd.guT = aVar3.BTU.vd();
                    AppMethodBeat.o(73739);
                    return 0;
                case 12:
                    azd.guU = aVar3.BTU.vd();
                    AppMethodBeat.o(73739);
                    return 0;
                case 13:
                    azd.guV = aVar3.BTU.readString();
                    AppMethodBeat.o(73739);
                    return 0;
                case 14:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ccl ccl = new ccl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccl.populateBuilderWithField(aVar4, ccl, a.getNextFieldNumber(aVar4))) {
                        }
                        azd.wBZ = ccl;
                    }
                    AppMethodBeat.o(73739);
                    return 0;
                case 15:
                    azd.guW = aVar3.BTU.readString();
                    AppMethodBeat.o(73739);
                    return 0;
                case 16:
                    azd.guX = aVar3.BTU.readString();
                    AppMethodBeat.o(73739);
                    return 0;
                case 17:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        uy uyVar = new uy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = uyVar.populateBuilderWithField(aVar4, uyVar, a.getNextFieldNumber(aVar4))) {
                        }
                        azd.wCa = uyVar;
                    }
                    AppMethodBeat.o(73739);
                    return 0;
                case 20:
                    azd.vXm = aVar3.BTU.readString();
                    AppMethodBeat.o(73739);
                    return 0;
                case 21:
                    azd.vXn = aVar3.BTU.readString();
                    AppMethodBeat.o(73739);
                    return 0;
                case 22:
                    azd.wlF = aVar3.BTU.readString();
                    AppMethodBeat.o(73739);
                    return 0;
                default:
                    AppMethodBeat.o(73739);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73739);
            return -1;
        }
    }
}
