package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;
import java.util.LinkedList;

public final class i extends a {
    public int vyT;
    public int vzh;
    public int vzj;
    public LinkedList<e> vzk = new LinkedList();
    public b vzl;

    public i() {
        AppMethodBeat.i(72826);
        AppMethodBeat.o(72826);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(72827);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vyT);
            aVar.iz(2, this.vzj);
            aVar.iz(3, this.vzh);
            aVar.e(4, 8, this.vzk);
            if (this.vzl != null) {
                aVar.c(5, this.vzl);
            }
            AppMethodBeat.o(72827);
            return 0;
        } else if (i == 1) {
            bs = (((e.a.a.b.b.a.bs(1, this.vyT) + 0) + e.a.a.b.b.a.bs(2, this.vzj)) + e.a.a.b.b.a.bs(3, this.vzh)) + e.a.a.a.c(4, 8, this.vzk);
            if (this.vzl != null) {
                bs += e.a.a.b.b.a.b(5, this.vzl);
            }
            AppMethodBeat.o(72827);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vzk.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(72827);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            i iVar = (i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    iVar.vyT = aVar3.BTU.vd();
                    AppMethodBeat.o(72827);
                    return 0;
                case 2:
                    iVar.vzj = aVar3.BTU.vd();
                    AppMethodBeat.o(72827);
                    return 0;
                case 3:
                    iVar.vzh = aVar3.BTU.vd();
                    AppMethodBeat.o(72827);
                    return 0;
                case 4:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        e eVar = new e();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.populateBuilderWithField(aVar4, eVar, a.getNextFieldNumber(aVar4))) {
                        }
                        iVar.vzk.add(eVar);
                    }
                    AppMethodBeat.o(72827);
                    return 0;
                case 5:
                    iVar.vzl = aVar3.BTU.emu();
                    AppMethodBeat.o(72827);
                    return 0;
                default:
                    AppMethodBeat.o(72827);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72827);
            return -1;
        }
    }
}
