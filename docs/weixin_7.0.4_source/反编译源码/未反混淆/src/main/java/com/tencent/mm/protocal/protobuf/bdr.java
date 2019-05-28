package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bdr extends a {
    public int type;
    public auj vQK;
    public cgv wbo;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48899);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vQK != null) {
                aVar.iy(1, this.vQK.computeSize());
                this.vQK.writeFields(aVar);
            }
            if (this.wbo != null) {
                aVar.iy(2, this.wbo.computeSize());
                this.wbo.writeFields(aVar);
            }
            aVar.iz(3, this.type);
            AppMethodBeat.o(48899);
            return 0;
        } else if (i == 1) {
            if (this.vQK != null) {
                ix = e.a.a.a.ix(1, this.vQK.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wbo != null) {
                ix += e.a.a.a.ix(2, this.wbo.computeSize());
            }
            int bs = ix + e.a.a.b.b.a.bs(3, this.type);
            AppMethodBeat.o(48899);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48899);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bdr bdr = (bdr) objArr[1];
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
                        auj auj = new auj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = auj.populateBuilderWithField(aVar4, auj, a.getNextFieldNumber(aVar4))) {
                        }
                        bdr.vQK = auj;
                    }
                    AppMethodBeat.o(48899);
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
                        bdr.wbo = cgv;
                    }
                    AppMethodBeat.o(48899);
                    return 0;
                case 3:
                    bdr.type = aVar3.BTU.vd();
                    AppMethodBeat.o(48899);
                    return 0;
                default:
                    AppMethodBeat.o(48899);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48899);
            return -1;
        }
    }
}
