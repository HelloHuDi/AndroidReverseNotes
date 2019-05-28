package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class nr extends a {
    public String vSL;
    public String vSM;
    public String vSN;
    public int vSO;
    public ny vSP;
    public int vSQ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89024);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vSL != null) {
                aVar.e(1, this.vSL);
            }
            if (this.vSM != null) {
                aVar.e(2, this.vSM);
            }
            if (this.vSN != null) {
                aVar.e(3, this.vSN);
            }
            aVar.iz(4, this.vSO);
            if (this.vSP != null) {
                aVar.iy(5, this.vSP.computeSize());
                this.vSP.writeFields(aVar);
            }
            aVar.iz(6, this.vSQ);
            AppMethodBeat.o(89024);
            return 0;
        } else if (i == 1) {
            if (this.vSL != null) {
                f = e.a.a.b.b.a.f(1, this.vSL) + 0;
            } else {
                f = 0;
            }
            if (this.vSM != null) {
                f += e.a.a.b.b.a.f(2, this.vSM);
            }
            if (this.vSN != null) {
                f += e.a.a.b.b.a.f(3, this.vSN);
            }
            f += e.a.a.b.b.a.bs(4, this.vSO);
            if (this.vSP != null) {
                f += e.a.a.a.ix(5, this.vSP.computeSize());
            }
            int bs = f + e.a.a.b.b.a.bs(6, this.vSQ);
            AppMethodBeat.o(89024);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89024);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            nr nrVar = (nr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    nrVar.vSL = aVar3.BTU.readString();
                    AppMethodBeat.o(89024);
                    return 0;
                case 2:
                    nrVar.vSM = aVar3.BTU.readString();
                    AppMethodBeat.o(89024);
                    return 0;
                case 3:
                    nrVar.vSN = aVar3.BTU.readString();
                    AppMethodBeat.o(89024);
                    return 0;
                case 4:
                    nrVar.vSO = aVar3.BTU.vd();
                    AppMethodBeat.o(89024);
                    return 0;
                case 5:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        ny nyVar = new ny();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = nyVar.populateBuilderWithField(aVar4, nyVar, a.getNextFieldNumber(aVar4))) {
                        }
                        nrVar.vSP = nyVar;
                    }
                    AppMethodBeat.o(89024);
                    return 0;
                case 6:
                    nrVar.vSQ = aVar3.BTU.vd();
                    AppMethodBeat.o(89024);
                    return 0;
                default:
                    AppMethodBeat.o(89024);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89024);
            return -1;
        }
    }
}
