package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public class axv extends a {
    public int guN;
    public String guO;
    public String guP;
    public String guQ;
    public String guS;
    public String guW;
    public String guX;
    public String jBB;
    public String jCH;
    public int vEE;
    public String vXm;
    public String vXn;
    public String wBS;
    public int wBT;
    public String wBU;
    public String wBV;
    public String wBW;
    public int wBX;
    public int wBY;
    public ccl wBZ;
    public uy wCa;
    public String wlF;
    public String wsM;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(55526);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.jBB != null) {
                aVar.e(1, this.jBB);
            }
            if (this.jCH != null) {
                aVar.e(2, this.jCH);
            }
            if (this.guO != null) {
                aVar.e(3, this.guO);
            }
            if (this.guP != null) {
                aVar.e(4, this.guP);
            }
            if (this.guQ != null) {
                aVar.e(5, this.guQ);
            }
            if (this.wBS != null) {
                aVar.e(6, this.wBS);
            }
            aVar.iz(7, this.guN);
            aVar.iz(8, this.vEE);
            aVar.iz(9, this.wBT);
            if (this.wBU != null) {
                aVar.e(10, this.wBU);
            }
            if (this.wsM != null) {
                aVar.e(11, this.wsM);
            }
            if (this.guS != null) {
                aVar.e(12, this.guS);
            }
            if (this.wBV != null) {
                aVar.e(13, this.wBV);
            }
            if (this.wBW != null) {
                aVar.e(14, this.wBW);
            }
            aVar.iz(15, this.wBX);
            aVar.iz(19, this.wBY);
            if (this.wBZ != null) {
                aVar.iy(20, this.wBZ.computeSize());
                this.wBZ.writeFields(aVar);
            }
            if (this.guW != null) {
                aVar.e(21, this.guW);
            }
            if (this.vXm != null) {
                aVar.e(22, this.vXm);
            }
            if (this.vXn != null) {
                aVar.e(23, this.vXn);
            }
            if (this.guX != null) {
                aVar.e(24, this.guX);
            }
            if (this.wCa != null) {
                aVar.iy(25, this.wCa.computeSize());
                this.wCa.writeFields(aVar);
            }
            if (this.wlF != null) {
                aVar.e(26, this.wlF);
            }
            AppMethodBeat.o(55526);
            return 0;
        } else if (i == 1) {
            if (this.jBB != null) {
                f = e.a.a.b.b.a.f(1, this.jBB) + 0;
            } else {
                f = 0;
            }
            if (this.jCH != null) {
                f += e.a.a.b.b.a.f(2, this.jCH);
            }
            if (this.guO != null) {
                f += e.a.a.b.b.a.f(3, this.guO);
            }
            if (this.guP != null) {
                f += e.a.a.b.b.a.f(4, this.guP);
            }
            if (this.guQ != null) {
                f += e.a.a.b.b.a.f(5, this.guQ);
            }
            if (this.wBS != null) {
                f += e.a.a.b.b.a.f(6, this.wBS);
            }
            f = ((f + e.a.a.b.b.a.bs(7, this.guN)) + e.a.a.b.b.a.bs(8, this.vEE)) + e.a.a.b.b.a.bs(9, this.wBT);
            if (this.wBU != null) {
                f += e.a.a.b.b.a.f(10, this.wBU);
            }
            if (this.wsM != null) {
                f += e.a.a.b.b.a.f(11, this.wsM);
            }
            if (this.guS != null) {
                f += e.a.a.b.b.a.f(12, this.guS);
            }
            if (this.wBV != null) {
                f += e.a.a.b.b.a.f(13, this.wBV);
            }
            if (this.wBW != null) {
                f += e.a.a.b.b.a.f(14, this.wBW);
            }
            f = (f + e.a.a.b.b.a.bs(15, this.wBX)) + e.a.a.b.b.a.bs(19, this.wBY);
            if (this.wBZ != null) {
                f += e.a.a.a.ix(20, this.wBZ.computeSize());
            }
            if (this.guW != null) {
                f += e.a.a.b.b.a.f(21, this.guW);
            }
            if (this.vXm != null) {
                f += e.a.a.b.b.a.f(22, this.vXm);
            }
            if (this.vXn != null) {
                f += e.a.a.b.b.a.f(23, this.vXn);
            }
            if (this.guX != null) {
                f += e.a.a.b.b.a.f(24, this.guX);
            }
            if (this.wCa != null) {
                f += e.a.a.a.ix(25, this.wCa.computeSize());
            }
            if (this.wlF != null) {
                f += e.a.a.b.b.a.f(26, this.wlF);
            }
            AppMethodBeat.o(55526);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(55526);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            axv axv = (axv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    axv.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(55526);
                    return 0;
                case 2:
                    axv.jCH = aVar3.BTU.readString();
                    AppMethodBeat.o(55526);
                    return 0;
                case 3:
                    axv.guO = aVar3.BTU.readString();
                    AppMethodBeat.o(55526);
                    return 0;
                case 4:
                    axv.guP = aVar3.BTU.readString();
                    AppMethodBeat.o(55526);
                    return 0;
                case 5:
                    axv.guQ = aVar3.BTU.readString();
                    AppMethodBeat.o(55526);
                    return 0;
                case 6:
                    axv.wBS = aVar3.BTU.readString();
                    AppMethodBeat.o(55526);
                    return 0;
                case 7:
                    axv.guN = aVar3.BTU.vd();
                    AppMethodBeat.o(55526);
                    return 0;
                case 8:
                    axv.vEE = aVar3.BTU.vd();
                    AppMethodBeat.o(55526);
                    return 0;
                case 9:
                    axv.wBT = aVar3.BTU.vd();
                    AppMethodBeat.o(55526);
                    return 0;
                case 10:
                    axv.wBU = aVar3.BTU.readString();
                    AppMethodBeat.o(55526);
                    return 0;
                case 11:
                    axv.wsM = aVar3.BTU.readString();
                    AppMethodBeat.o(55526);
                    return 0;
                case 12:
                    axv.guS = aVar3.BTU.readString();
                    AppMethodBeat.o(55526);
                    return 0;
                case 13:
                    axv.wBV = aVar3.BTU.readString();
                    AppMethodBeat.o(55526);
                    return 0;
                case 14:
                    axv.wBW = aVar3.BTU.readString();
                    AppMethodBeat.o(55526);
                    return 0;
                case 15:
                    axv.wBX = aVar3.BTU.vd();
                    AppMethodBeat.o(55526);
                    return 0;
                case 19:
                    axv.wBY = aVar3.BTU.vd();
                    AppMethodBeat.o(55526);
                    return 0;
                case 20:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ccl ccl = new ccl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccl.populateBuilderWithField(aVar4, ccl, a.getNextFieldNumber(aVar4))) {
                        }
                        axv.wBZ = ccl;
                    }
                    AppMethodBeat.o(55526);
                    return 0;
                case 21:
                    axv.guW = aVar3.BTU.readString();
                    AppMethodBeat.o(55526);
                    return 0;
                case 22:
                    axv.vXm = aVar3.BTU.readString();
                    AppMethodBeat.o(55526);
                    return 0;
                case 23:
                    axv.vXn = aVar3.BTU.readString();
                    AppMethodBeat.o(55526);
                    return 0;
                case 24:
                    axv.guX = aVar3.BTU.readString();
                    AppMethodBeat.o(55526);
                    return 0;
                case 25:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        uy uyVar = new uy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = uyVar.populateBuilderWithField(aVar4, uyVar, a.getNextFieldNumber(aVar4))) {
                        }
                        axv.wCa = uyVar;
                    }
                    AppMethodBeat.o(55526);
                    return 0;
                case 26:
                    axv.wlF = aVar3.BTU.readString();
                    AppMethodBeat.o(55526);
                    return 0;
                default:
                    AppMethodBeat.o(55526);
                    return -1;
            }
        } else {
            AppMethodBeat.o(55526);
            return -1;
        }
    }
}
