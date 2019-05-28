package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cge extends a {
    public bdq xfl;
    public LinkedList<ave> xfm = new LinkedList();
    public LinkedList<cgv> xfn = new LinkedList();

    public cge() {
        AppMethodBeat.i(48967);
        AppMethodBeat.o(48967);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48968);
        int ix;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xfl != null) {
                aVar.iy(1, this.xfl.computeSize());
                this.xfl.writeFields(aVar);
            }
            aVar.e(2, 8, this.xfm);
            aVar.e(3, 8, this.xfn);
            AppMethodBeat.o(48968);
            return 0;
        } else if (i == 1) {
            if (this.xfl != null) {
                ix = e.a.a.a.ix(1, this.xfl.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int c = (ix + e.a.a.a.c(2, 8, this.xfm)) + e.a.a.a.c(3, 8, this.xfn);
            AppMethodBeat.o(48968);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xfm.clear();
            this.xfn.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48968);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cge cge = (cge) objArr[1];
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
                        bdq bdq = new bdq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdq.populateBuilderWithField(aVar4, bdq, a.getNextFieldNumber(aVar4))) {
                        }
                        cge.xfl = bdq;
                    }
                    AppMethodBeat.o(48968);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ave ave = new ave();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ave.populateBuilderWithField(aVar4, ave, a.getNextFieldNumber(aVar4))) {
                        }
                        cge.xfm.add(ave);
                    }
                    AppMethodBeat.o(48968);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv cgv = new cgv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(aVar4, cgv, a.getNextFieldNumber(aVar4))) {
                        }
                        cge.xfn.add(cgv);
                    }
                    AppMethodBeat.o(48968);
                    return 0;
                default:
                    AppMethodBeat.o(48968);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48968);
            return -1;
        }
    }
}
