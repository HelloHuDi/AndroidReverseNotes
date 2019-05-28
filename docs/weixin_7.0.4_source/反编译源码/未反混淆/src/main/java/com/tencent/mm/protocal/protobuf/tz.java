package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class tz extends a {
    public cfy wbn;
    public cgv wbo;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48825);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wbn != null) {
                aVar.iy(1, this.wbn.computeSize());
                this.wbn.writeFields(aVar);
            }
            if (this.wbo != null) {
                aVar.iy(2, this.wbo.computeSize());
                this.wbo.writeFields(aVar);
            }
            AppMethodBeat.o(48825);
            return 0;
        } else if (i == 1) {
            if (this.wbn != null) {
                ix = e.a.a.a.ix(1, this.wbn.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wbo != null) {
                ix += e.a.a.a.ix(2, this.wbo.computeSize());
            }
            AppMethodBeat.o(48825);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48825);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            tz tzVar = (tz) objArr[1];
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
                        cfy cfy = new cfy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cfy.populateBuilderWithField(aVar4, cfy, a.getNextFieldNumber(aVar4))) {
                        }
                        tzVar.wbn = cfy;
                    }
                    AppMethodBeat.o(48825);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv cgv = new cgv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(aVar4, cgv, a.getNextFieldNumber(aVar4))) {
                        }
                        tzVar.wbo = cgv;
                    }
                    AppMethodBeat.o(48825);
                    return 0;
                default:
                    AppMethodBeat.o(48825);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48825);
            return -1;
        }
    }
}
