package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class sj extends a {
    public int jCy;
    public int luF;
    public LinkedList<awy> naO = new LinkedList();
    public int vKd;
    public String vOA;
    public String vOB;
    public String vOC;
    public String vOD;
    public String vOz;
    public int vZF;

    public sj() {
        AppMethodBeat.i(72841);
        AppMethodBeat.o(72841);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(72842);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.luF);
            if (this.vOB != null) {
                aVar.e(7, this.vOB);
            }
            aVar.iz(2, this.vKd);
            aVar.iz(3, this.vZF);
            aVar.e(4, 8, this.naO);
            if (this.vOz != null) {
                aVar.e(5, this.vOz);
            }
            if (this.vOA != null) {
                aVar.e(6, this.vOA);
            }
            if (this.vOC != null) {
                aVar.e(8, this.vOC);
            }
            if (this.vOD != null) {
                aVar.e(9, this.vOD);
            }
            aVar.iz(10, this.jCy);
            AppMethodBeat.o(72842);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.luF) + 0;
            if (this.vOB != null) {
                bs += e.a.a.b.b.a.f(7, this.vOB);
            }
            bs = ((bs + e.a.a.b.b.a.bs(2, this.vKd)) + e.a.a.b.b.a.bs(3, this.vZF)) + e.a.a.a.c(4, 8, this.naO);
            if (this.vOz != null) {
                bs += e.a.a.b.b.a.f(5, this.vOz);
            }
            if (this.vOA != null) {
                bs += e.a.a.b.b.a.f(6, this.vOA);
            }
            if (this.vOC != null) {
                bs += e.a.a.b.b.a.f(8, this.vOC);
            }
            if (this.vOD != null) {
                bs += e.a.a.b.b.a.f(9, this.vOD);
            }
            bs += e.a.a.b.b.a.bs(10, this.jCy);
            AppMethodBeat.o(72842);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.naO.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(72842);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            sj sjVar = (sj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    sjVar.luF = aVar3.BTU.vd();
                    AppMethodBeat.o(72842);
                    return 0;
                case 2:
                    sjVar.vKd = aVar3.BTU.vd();
                    AppMethodBeat.o(72842);
                    return 0;
                case 3:
                    sjVar.vZF = aVar3.BTU.vd();
                    AppMethodBeat.o(72842);
                    return 0;
                case 4:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        awy awy = new awy();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = awy.populateBuilderWithField(aVar4, awy, a.getNextFieldNumber(aVar4))) {
                        }
                        sjVar.naO.add(awy);
                    }
                    AppMethodBeat.o(72842);
                    return 0;
                case 5:
                    sjVar.vOz = aVar3.BTU.readString();
                    AppMethodBeat.o(72842);
                    return 0;
                case 6:
                    sjVar.vOA = aVar3.BTU.readString();
                    AppMethodBeat.o(72842);
                    return 0;
                case 7:
                    sjVar.vOB = aVar3.BTU.readString();
                    AppMethodBeat.o(72842);
                    return 0;
                case 8:
                    sjVar.vOC = aVar3.BTU.readString();
                    AppMethodBeat.o(72842);
                    return 0;
                case 9:
                    sjVar.vOD = aVar3.BTU.readString();
                    AppMethodBeat.o(72842);
                    return 0;
                case 10:
                    sjVar.jCy = aVar3.BTU.vd();
                    AppMethodBeat.o(72842);
                    return 0;
                default:
                    AppMethodBeat.o(72842);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72842);
            return -1;
        }
    }
}
