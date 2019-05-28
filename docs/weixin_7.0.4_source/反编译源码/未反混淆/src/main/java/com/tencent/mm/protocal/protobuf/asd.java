package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class asd extends a {
    public cgv vCN;
    public LinkedList<bzy> vCQ = new LinkedList();
    public String vJS;

    public asd() {
        AppMethodBeat.i(48861);
        AppMethodBeat.o(48861);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48862);
        int ix;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vCN != null) {
                aVar.iy(1, this.vCN.computeSize());
                this.vCN.writeFields(aVar);
            }
            aVar.e(2, 8, this.vCQ);
            if (this.vJS != null) {
                aVar.e(3, this.vJS);
            }
            AppMethodBeat.o(48862);
            return 0;
        } else if (i == 1) {
            if (this.vCN != null) {
                ix = e.a.a.a.ix(1, this.vCN.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.a.c(2, 8, this.vCQ);
            if (this.vJS != null) {
                ix += e.a.a.b.b.a.f(3, this.vJS);
            }
            AppMethodBeat.o(48862);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vCQ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48862);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            asd asd = (asd) objArr[1];
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
                        cgv cgv = new cgv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(aVar4, cgv, a.getNextFieldNumber(aVar4))) {
                        }
                        asd.vCN = cgv;
                    }
                    AppMethodBeat.o(48862);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzy bzy = new bzy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzy.populateBuilderWithField(aVar4, bzy, a.getNextFieldNumber(aVar4))) {
                        }
                        asd.vCQ.add(bzy);
                    }
                    AppMethodBeat.o(48862);
                    return 0;
                case 3:
                    asd.vJS = aVar3.BTU.readString();
                    AppMethodBeat.o(48862);
                    return 0;
                default:
                    AppMethodBeat.o(48862);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48862);
            return -1;
        }
    }
}
