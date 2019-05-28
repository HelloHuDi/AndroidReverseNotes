package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bpu extends bsr {
    public String pXM;
    public String vOA;
    public String vOB;
    public String vOC;
    public String vOD;
    public String vOz;
    public int wBd;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80160);
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
            aVar.iz(7, this.wBd);
            if (this.pXM != null) {
                aVar.e(8, this.pXM);
            }
            AppMethodBeat.o(80160);
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
            ix += e.a.a.b.b.a.bs(7, this.wBd);
            if (this.pXM != null) {
                ix += e.a.a.b.b.a.f(8, this.pXM);
            }
            AppMethodBeat.o(80160);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80160);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bpu bpu = (bpu) objArr[1];
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
                        bpu.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(80160);
                    return 0;
                case 2:
                    bpu.vOz = aVar3.BTU.readString();
                    AppMethodBeat.o(80160);
                    return 0;
                case 3:
                    bpu.vOA = aVar3.BTU.readString();
                    AppMethodBeat.o(80160);
                    return 0;
                case 4:
                    bpu.vOB = aVar3.BTU.readString();
                    AppMethodBeat.o(80160);
                    return 0;
                case 5:
                    bpu.vOC = aVar3.BTU.readString();
                    AppMethodBeat.o(80160);
                    return 0;
                case 6:
                    bpu.vOD = aVar3.BTU.readString();
                    AppMethodBeat.o(80160);
                    return 0;
                case 7:
                    bpu.wBd = aVar3.BTU.vd();
                    AppMethodBeat.o(80160);
                    return 0;
                case 8:
                    bpu.pXM = aVar3.BTU.readString();
                    AppMethodBeat.o(80160);
                    return 0;
                default:
                    AppMethodBeat.o(80160);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80160);
            return -1;
        }
    }
}
