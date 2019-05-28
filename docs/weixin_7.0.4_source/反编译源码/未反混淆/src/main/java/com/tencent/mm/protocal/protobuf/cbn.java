package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cbn extends a {
    public int xaO;
    public ccp xaP;
    public boo xaQ;
    public wh xaR;
    public blk xaS;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94592);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.xaO);
            if (this.xaP != null) {
                aVar.iy(2, this.xaP.computeSize());
                this.xaP.writeFields(aVar);
            }
            if (this.xaQ != null) {
                aVar.iy(3, this.xaQ.computeSize());
                this.xaQ.writeFields(aVar);
            }
            if (this.xaR != null) {
                aVar.iy(4, this.xaR.computeSize());
                this.xaR.writeFields(aVar);
            }
            if (this.xaS != null) {
                aVar.iy(5, this.xaS.computeSize());
                this.xaS.writeFields(aVar);
            }
            AppMethodBeat.o(94592);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.xaO) + 0;
            if (this.xaP != null) {
                bs += e.a.a.a.ix(2, this.xaP.computeSize());
            }
            if (this.xaQ != null) {
                bs += e.a.a.a.ix(3, this.xaQ.computeSize());
            }
            if (this.xaR != null) {
                bs += e.a.a.a.ix(4, this.xaR.computeSize());
            }
            if (this.xaS != null) {
                bs += e.a.a.a.ix(5, this.xaS.computeSize());
            }
            AppMethodBeat.o(94592);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94592);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cbn cbn = (cbn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cbn.xaO = aVar3.BTU.vd();
                    AppMethodBeat.o(94592);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ccp ccp = new ccp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccp.populateBuilderWithField(aVar4, ccp, a.getNextFieldNumber(aVar4))) {
                        }
                        cbn.xaP = ccp;
                    }
                    AppMethodBeat.o(94592);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        boo boo = new boo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = boo.populateBuilderWithField(aVar4, boo, a.getNextFieldNumber(aVar4))) {
                        }
                        cbn.xaQ = boo;
                    }
                    AppMethodBeat.o(94592);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        wh whVar = new wh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = whVar.populateBuilderWithField(aVar4, whVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cbn.xaR = whVar;
                    }
                    AppMethodBeat.o(94592);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        blk blk = new blk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = blk.populateBuilderWithField(aVar4, blk, a.getNextFieldNumber(aVar4))) {
                        }
                        cbn.xaS = blk;
                    }
                    AppMethodBeat.o(94592);
                    return 0;
                default:
                    AppMethodBeat.o(94592);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94592);
            return -1;
        }
    }
}
