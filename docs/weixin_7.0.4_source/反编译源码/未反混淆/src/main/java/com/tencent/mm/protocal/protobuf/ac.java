package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ac extends bsr {
    public LinkedList<dh> vAL = new LinkedList();
    public int vBd;
    public xa vBe;
    public int vBf;

    public ac() {
        AppMethodBeat.i(28294);
        AppMethodBeat.o(28294);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28295);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.vBd);
            aVar.e(3, 8, this.vAL);
            if (this.vBe != null) {
                aVar.iy(4, this.vBe.computeSize());
                this.vBe.writeFields(aVar);
            }
            aVar.iz(5, this.vBf);
            AppMethodBeat.o(28295);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.vBd)) + e.a.a.a.c(3, 8, this.vAL);
            if (this.vBe != null) {
                ix += e.a.a.a.ix(4, this.vBe.computeSize());
            }
            int bs = ix + e.a.a.b.b.a.bs(5, this.vBf);
            AppMethodBeat.o(28295);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vAL.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28295);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ac acVar = (ac) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
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
                        acVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28295);
                    return 0;
                case 2:
                    acVar.vBd = aVar3.BTU.vd();
                    AppMethodBeat.o(28295);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        dh dhVar = new dh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dhVar.populateBuilderWithField(aVar4, dhVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        acVar.vAL.add(dhVar);
                    }
                    AppMethodBeat.o(28295);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        xa xaVar = new xa();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xaVar.populateBuilderWithField(aVar4, xaVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        acVar.vBe = xaVar;
                    }
                    AppMethodBeat.o(28295);
                    return 0;
                case 5:
                    acVar.vBf = aVar3.BTU.vd();
                    AppMethodBeat.o(28295);
                    return 0;
                default:
                    AppMethodBeat.o(28295);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28295);
            return -1;
        }
    }
}
