package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bht extends a {
    public String vJS;
    public bln wKU;
    public LinkedList<bzy> wKV = new LinkedList();

    public bht() {
        AppMethodBeat.i(48913);
        AppMethodBeat.o(48913);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48914);
        int ix;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wKU != null) {
                aVar.iy(1, this.wKU.computeSize());
                this.wKU.writeFields(aVar);
            }
            aVar.e(2, 8, this.wKV);
            if (this.vJS != null) {
                aVar.e(3, this.vJS);
            }
            AppMethodBeat.o(48914);
            return 0;
        } else if (i == 1) {
            if (this.wKU != null) {
                ix = e.a.a.a.ix(1, this.wKU.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.a.c(2, 8, this.wKV);
            if (this.vJS != null) {
                ix += e.a.a.b.b.a.f(3, this.vJS);
            }
            AppMethodBeat.o(48914);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wKV.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48914);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bht bht = (bht) objArr[1];
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
                        bln bln = new bln();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bln.populateBuilderWithField(aVar4, bln, a.getNextFieldNumber(aVar4))) {
                        }
                        bht.wKU = bln;
                    }
                    AppMethodBeat.o(48914);
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
                        bht.wKV.add(bzy);
                    }
                    AppMethodBeat.o(48914);
                    return 0;
                case 3:
                    bht.vJS = aVar3.BTU.readString();
                    AppMethodBeat.o(48914);
                    return 0;
                default:
                    AppMethodBeat.o(48914);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48914);
            return -1;
        }
    }
}
