package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class acr extends a {
    public LinkedList<kf> vNd = new LinkedList();
    public kd wku;

    public acr() {
        AppMethodBeat.i(11749);
        AppMethodBeat.o(11749);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11750);
        int ix;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wku != null) {
                aVar.iy(1, this.wku.computeSize());
                this.wku.writeFields(aVar);
            }
            aVar.e(2, 8, this.vNd);
            AppMethodBeat.o(11750);
            return 0;
        } else if (i == 1) {
            if (this.wku != null) {
                ix = e.a.a.a.ix(1, this.wku.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int c = ix + e.a.a.a.c(2, 8, this.vNd);
            AppMethodBeat.o(11750);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vNd.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(11750);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            acr acr = (acr) objArr[1];
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
                        kd kdVar = new kd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kdVar.populateBuilderWithField(aVar4, kdVar, a.getNextFieldNumber(aVar4))) {
                        }
                        acr.wku = kdVar;
                    }
                    AppMethodBeat.o(11750);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        kf kfVar = new kf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kfVar.populateBuilderWithField(aVar4, kfVar, a.getNextFieldNumber(aVar4))) {
                        }
                        acr.vNd.add(kfVar);
                    }
                    AppMethodBeat.o(11750);
                    return 0;
                default:
                    AppMethodBeat.o(11750);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11750);
            return -1;
        }
    }
}
