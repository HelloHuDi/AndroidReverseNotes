package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class lq extends bsr {
    public int cIb;
    public int nUf;
    public int pOA;
    public String pOB;
    public String pOC;
    public String pPW;
    public String pPZ;
    public String vFf;
    public String vPl;
    public int vPm;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56720);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.nUf);
            aVar.iz(3, this.cIb);
            aVar.iz(4, this.pOA);
            if (this.vPl != null) {
                aVar.e(5, this.vPl);
            }
            if (this.pPW != null) {
                aVar.e(6, this.pPW);
            }
            if (this.pOB != null) {
                aVar.e(7, this.pOB);
            }
            if (this.pPZ != null) {
                aVar.e(8, this.pPZ);
            }
            if (this.vFf != null) {
                aVar.e(9, this.vFf);
            }
            if (this.pOC != null) {
                aVar.e(10, this.pOC);
            }
            aVar.iz(11, this.vPm);
            AppMethodBeat.o(56720);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((ix + e.a.a.b.b.a.bs(2, this.nUf)) + e.a.a.b.b.a.bs(3, this.cIb)) + e.a.a.b.b.a.bs(4, this.pOA);
            if (this.vPl != null) {
                ix += e.a.a.b.b.a.f(5, this.vPl);
            }
            if (this.pPW != null) {
                ix += e.a.a.b.b.a.f(6, this.pPW);
            }
            if (this.pOB != null) {
                ix += e.a.a.b.b.a.f(7, this.pOB);
            }
            if (this.pPZ != null) {
                ix += e.a.a.b.b.a.f(8, this.pPZ);
            }
            if (this.vFf != null) {
                ix += e.a.a.b.b.a.f(9, this.vFf);
            }
            if (this.pOC != null) {
                ix += e.a.a.b.b.a.f(10, this.pOC);
            }
            int bs = ix + e.a.a.b.b.a.bs(11, this.vPm);
            AppMethodBeat.o(56720);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56720);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            lq lqVar = (lq) objArr[1];
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
                        lqVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56720);
                    return 0;
                case 2:
                    lqVar.nUf = aVar3.BTU.vd();
                    AppMethodBeat.o(56720);
                    return 0;
                case 3:
                    lqVar.cIb = aVar3.BTU.vd();
                    AppMethodBeat.o(56720);
                    return 0;
                case 4:
                    lqVar.pOA = aVar3.BTU.vd();
                    AppMethodBeat.o(56720);
                    return 0;
                case 5:
                    lqVar.vPl = aVar3.BTU.readString();
                    AppMethodBeat.o(56720);
                    return 0;
                case 6:
                    lqVar.pPW = aVar3.BTU.readString();
                    AppMethodBeat.o(56720);
                    return 0;
                case 7:
                    lqVar.pOB = aVar3.BTU.readString();
                    AppMethodBeat.o(56720);
                    return 0;
                case 8:
                    lqVar.pPZ = aVar3.BTU.readString();
                    AppMethodBeat.o(56720);
                    return 0;
                case 9:
                    lqVar.vFf = aVar3.BTU.readString();
                    AppMethodBeat.o(56720);
                    return 0;
                case 10:
                    lqVar.pOC = aVar3.BTU.readString();
                    AppMethodBeat.o(56720);
                    return 0;
                case 11:
                    lqVar.vPm = aVar3.BTU.vd();
                    AppMethodBeat.o(56720);
                    return 0;
                default:
                    AppMethodBeat.o(56720);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56720);
            return -1;
        }
    }
}
