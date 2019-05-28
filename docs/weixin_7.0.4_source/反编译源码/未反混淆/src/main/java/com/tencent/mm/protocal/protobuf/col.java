package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class col extends bsr {
    public int vZF;
    public String wPm;
    public int wem;
    public long wen;
    public cpx xlM;
    public cpx xlN;
    public long xlQ;
    public int xlR;
    public int xmb;
    public int xmc;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5230);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wPm != null) {
                aVar.e(2, this.wPm);
            }
            aVar.iz(3, this.wem);
            aVar.iz(4, this.xmb);
            if (this.xlM != null) {
                aVar.iy(5, this.xlM.computeSize());
                this.xlM.writeFields(aVar);
            }
            if (this.xlN != null) {
                aVar.iy(6, this.xlN.computeSize());
                this.xlN.writeFields(aVar);
            }
            aVar.ai(7, this.wen);
            aVar.iz(8, this.vZF);
            aVar.ai(9, this.xlQ);
            aVar.iz(10, this.xmc);
            aVar.iz(11, this.xlR);
            AppMethodBeat.o(5230);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wPm != null) {
                ix += e.a.a.b.b.a.f(2, this.wPm);
            }
            ix = (ix + e.a.a.b.b.a.bs(3, this.wem)) + e.a.a.b.b.a.bs(4, this.xmb);
            if (this.xlM != null) {
                ix += e.a.a.a.ix(5, this.xlM.computeSize());
            }
            if (this.xlN != null) {
                ix += e.a.a.a.ix(6, this.xlN.computeSize());
            }
            int o = ((((ix + e.a.a.b.b.a.o(7, this.wen)) + e.a.a.b.b.a.bs(8, this.vZF)) + e.a.a.b.b.a.o(9, this.xlQ)) + e.a.a.b.b.a.bs(10, this.xmc)) + e.a.a.b.b.a.bs(11, this.xlR);
            AppMethodBeat.o(5230);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(5230);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            col col = (col) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            cpx cpx;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        col.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(5230);
                    return 0;
                case 2:
                    col.wPm = aVar3.BTU.readString();
                    AppMethodBeat.o(5230);
                    return 0;
                case 3:
                    col.wem = aVar3.BTU.vd();
                    AppMethodBeat.o(5230);
                    return 0;
                case 4:
                    col.xmb = aVar3.BTU.vd();
                    AppMethodBeat.o(5230);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cpx = new cpx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpx.populateBuilderWithField(aVar4, cpx, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        col.xlM = cpx;
                    }
                    AppMethodBeat.o(5230);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cpx = new cpx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpx.populateBuilderWithField(aVar4, cpx, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        col.xlN = cpx;
                    }
                    AppMethodBeat.o(5230);
                    return 0;
                case 7:
                    col.wen = aVar3.BTU.ve();
                    AppMethodBeat.o(5230);
                    return 0;
                case 8:
                    col.vZF = aVar3.BTU.vd();
                    AppMethodBeat.o(5230);
                    return 0;
                case 9:
                    col.xlQ = aVar3.BTU.ve();
                    AppMethodBeat.o(5230);
                    return 0;
                case 10:
                    col.xmc = aVar3.BTU.vd();
                    AppMethodBeat.o(5230);
                    return 0;
                case 11:
                    col.xlR = aVar3.BTU.vd();
                    AppMethodBeat.o(5230);
                    return 0;
                default:
                    AppMethodBeat.o(5230);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5230);
            return -1;
        }
    }
}
