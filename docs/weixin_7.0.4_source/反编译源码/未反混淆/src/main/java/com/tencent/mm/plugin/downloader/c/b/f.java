package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class f extends a {
    public b kLn;
    public i kLo;
    public boolean kLp;
    public int kLq;
    public boolean kLr;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(35532);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kLn != null) {
                aVar.iy(1, this.kLn.computeSize());
                this.kLn.writeFields(aVar);
            }
            if (this.kLo != null) {
                aVar.iy(2, this.kLo.computeSize());
                this.kLo.writeFields(aVar);
            }
            aVar.aO(3, this.kLp);
            aVar.iz(4, this.kLq);
            aVar.aO(5, this.kLr);
            AppMethodBeat.o(35532);
            return 0;
        } else if (i == 1) {
            if (this.kLn != null) {
                ix = e.a.a.a.ix(1, this.kLn.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.kLo != null) {
                ix += e.a.a.a.ix(2, this.kLo.computeSize());
            }
            int fv = ((ix + (e.a.a.b.b.a.fv(3) + 1)) + e.a.a.b.b.a.bs(4, this.kLq)) + (e.a.a.b.b.a.fv(5) + 1);
            AppMethodBeat.o(35532);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(35532);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            f fVar = (f) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        b bVar = new b();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bVar.populateBuilderWithField(aVar4, bVar, a.getNextFieldNumber(aVar4))) {
                        }
                        fVar.kLn = bVar;
                    }
                    AppMethodBeat.o(35532);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        i iVar = new i();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = iVar.populateBuilderWithField(aVar4, iVar, a.getNextFieldNumber(aVar4))) {
                        }
                        fVar.kLo = iVar;
                    }
                    AppMethodBeat.o(35532);
                    return 0;
                case 3:
                    fVar.kLp = aVar3.BTU.ehX();
                    AppMethodBeat.o(35532);
                    return 0;
                case 4:
                    fVar.kLq = aVar3.BTU.vd();
                    AppMethodBeat.o(35532);
                    return 0;
                case 5:
                    fVar.kLr = aVar3.BTU.ehX();
                    AppMethodBeat.o(35532);
                    return 0;
                default:
                    AppMethodBeat.o(35532);
                    return -1;
            }
        } else {
            AppMethodBeat.o(35532);
            return -1;
        }
    }
}
