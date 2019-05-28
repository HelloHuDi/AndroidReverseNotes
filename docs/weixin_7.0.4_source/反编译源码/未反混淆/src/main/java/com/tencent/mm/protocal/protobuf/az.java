package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class az extends a {
    public cgv vCN;
    public cgv vCO;
    public btr vCP;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48769);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vCN != null) {
                aVar.iy(1, this.vCN.computeSize());
                this.vCN.writeFields(aVar);
            }
            if (this.vCO != null) {
                aVar.iy(2, this.vCO.computeSize());
                this.vCO.writeFields(aVar);
            }
            if (this.vCP != null) {
                aVar.iy(3, this.vCP.computeSize());
                this.vCP.writeFields(aVar);
            }
            AppMethodBeat.o(48769);
            return 0;
        } else if (i == 1) {
            if (this.vCN != null) {
                ix = e.a.a.a.ix(1, this.vCN.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vCO != null) {
                ix += e.a.a.a.ix(2, this.vCO.computeSize());
            }
            if (this.vCP != null) {
                ix += e.a.a.a.ix(3, this.vCP.computeSize());
            }
            AppMethodBeat.o(48769);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48769);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            az azVar = (az) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            cgv cgv;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv = new cgv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(aVar4, cgv, a.getNextFieldNumber(aVar4))) {
                        }
                        azVar.vCN = cgv;
                    }
                    AppMethodBeat.o(48769);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv = new cgv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(aVar4, cgv, a.getNextFieldNumber(aVar4))) {
                        }
                        azVar.vCO = cgv;
                    }
                    AppMethodBeat.o(48769);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btr btr = new btr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btr.populateBuilderWithField(aVar4, btr, a.getNextFieldNumber(aVar4))) {
                        }
                        azVar.vCP = btr;
                    }
                    AppMethodBeat.o(48769);
                    return 0;
                default:
                    AppMethodBeat.o(48769);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48769);
            return -1;
        }
    }
}
