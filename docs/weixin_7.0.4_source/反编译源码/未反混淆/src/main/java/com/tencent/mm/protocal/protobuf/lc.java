package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class lc extends bsr {
    public int count;
    public int oZe;
    public int pXL;
    public String pZo;
    public String pZp;
    public int type;
    public String vOA;
    public String vOB;
    public String vOC;
    public String vOD;
    public String vOE;
    public String vOz;
    public String value;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11727);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.vOz != null) {
                aVar.e(2, this.vOz);
            }
            if (this.vOA != null) {
                aVar.e(3, this.vOA);
            }
            if (this.vOB != null) {
                aVar.e(4, this.vOB);
            }
            if (this.vOC != null) {
                aVar.e(5, this.vOC);
            }
            if (this.vOD != null) {
                aVar.e(6, this.vOD);
            }
            aVar.iz(7, this.pXL);
            if (this.vOE != null) {
                aVar.e(8, this.vOE);
            }
            if (this.pZp != null) {
                aVar.e(9, this.pZp);
            }
            if (this.pZo != null) {
                aVar.e(10, this.pZo);
            }
            aVar.iz(11, this.type);
            if (this.value != null) {
                aVar.e(12, this.value);
            }
            aVar.iz(13, this.count);
            aVar.iz(14, this.oZe);
            AppMethodBeat.o(11727);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vOz != null) {
                ix += e.a.a.b.b.a.f(2, this.vOz);
            }
            if (this.vOA != null) {
                ix += e.a.a.b.b.a.f(3, this.vOA);
            }
            if (this.vOB != null) {
                ix += e.a.a.b.b.a.f(4, this.vOB);
            }
            if (this.vOC != null) {
                ix += e.a.a.b.b.a.f(5, this.vOC);
            }
            if (this.vOD != null) {
                ix += e.a.a.b.b.a.f(6, this.vOD);
            }
            ix += e.a.a.b.b.a.bs(7, this.pXL);
            if (this.vOE != null) {
                ix += e.a.a.b.b.a.f(8, this.vOE);
            }
            if (this.pZp != null) {
                ix += e.a.a.b.b.a.f(9, this.pZp);
            }
            if (this.pZo != null) {
                ix += e.a.a.b.b.a.f(10, this.pZo);
            }
            ix += e.a.a.b.b.a.bs(11, this.type);
            if (this.value != null) {
                ix += e.a.a.b.b.a.f(12, this.value);
            }
            int bs = (ix + e.a.a.b.b.a.bs(13, this.count)) + e.a.a.b.b.a.bs(14, this.oZe);
            AppMethodBeat.o(11727);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(11727);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            lc lcVar = (lc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        lcVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(11727);
                    return 0;
                case 2:
                    lcVar.vOz = aVar3.BTU.readString();
                    AppMethodBeat.o(11727);
                    return 0;
                case 3:
                    lcVar.vOA = aVar3.BTU.readString();
                    AppMethodBeat.o(11727);
                    return 0;
                case 4:
                    lcVar.vOB = aVar3.BTU.readString();
                    AppMethodBeat.o(11727);
                    return 0;
                case 5:
                    lcVar.vOC = aVar3.BTU.readString();
                    AppMethodBeat.o(11727);
                    return 0;
                case 6:
                    lcVar.vOD = aVar3.BTU.readString();
                    AppMethodBeat.o(11727);
                    return 0;
                case 7:
                    lcVar.pXL = aVar3.BTU.vd();
                    AppMethodBeat.o(11727);
                    return 0;
                case 8:
                    lcVar.vOE = aVar3.BTU.readString();
                    AppMethodBeat.o(11727);
                    return 0;
                case 9:
                    lcVar.pZp = aVar3.BTU.readString();
                    AppMethodBeat.o(11727);
                    return 0;
                case 10:
                    lcVar.pZo = aVar3.BTU.readString();
                    AppMethodBeat.o(11727);
                    return 0;
                case 11:
                    lcVar.type = aVar3.BTU.vd();
                    AppMethodBeat.o(11727);
                    return 0;
                case 12:
                    lcVar.value = aVar3.BTU.readString();
                    AppMethodBeat.o(11727);
                    return 0;
                case 13:
                    lcVar.count = aVar3.BTU.vd();
                    AppMethodBeat.o(11727);
                    return 0;
                case 14:
                    lcVar.oZe = aVar3.BTU.vd();
                    AppMethodBeat.o(11727);
                    return 0;
                default:
                    AppMethodBeat.o(11727);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11727);
            return -1;
        }
    }
}
