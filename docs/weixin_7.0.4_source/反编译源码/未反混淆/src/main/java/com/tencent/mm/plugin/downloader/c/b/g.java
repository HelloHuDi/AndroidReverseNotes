package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class g extends a {
    public h kLs;
    public h kLt;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(35533);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kLs != null) {
                aVar.iy(1, this.kLs.computeSize());
                this.kLs.writeFields(aVar);
            }
            if (this.kLt != null) {
                aVar.iy(2, this.kLt.computeSize());
                this.kLt.writeFields(aVar);
            }
            AppMethodBeat.o(35533);
            return 0;
        } else if (i == 1) {
            if (this.kLs != null) {
                ix = e.a.a.a.ix(1, this.kLs.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.kLt != null) {
                ix += e.a.a.a.ix(2, this.kLt.computeSize());
            }
            AppMethodBeat.o(35533);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(35533);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            h hVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hVar = new h();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hVar.populateBuilderWithField(aVar4, hVar, a.getNextFieldNumber(aVar4))) {
                        }
                        gVar.kLs = hVar;
                    }
                    AppMethodBeat.o(35533);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hVar = new h();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hVar.populateBuilderWithField(aVar4, hVar, a.getNextFieldNumber(aVar4))) {
                        }
                        gVar.kLt = hVar;
                    }
                    AppMethodBeat.o(35533);
                    return 0;
                default:
                    AppMethodBeat.o(35533);
                    return -1;
            }
        } else {
            AppMethodBeat.o(35533);
            return -1;
        }
    }
}
