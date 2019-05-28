package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cdg extends a {
    public cdh xcS;
    public cdf xcT;
    public cde xcU;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94631);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xcS != null) {
                aVar.iy(1, this.xcS.computeSize());
                this.xcS.writeFields(aVar);
            }
            if (this.xcT != null) {
                aVar.iy(2, this.xcT.computeSize());
                this.xcT.writeFields(aVar);
            }
            if (this.xcU != null) {
                aVar.iy(3, this.xcU.computeSize());
                this.xcU.writeFields(aVar);
            }
            AppMethodBeat.o(94631);
            return 0;
        } else if (i == 1) {
            if (this.xcS != null) {
                ix = e.a.a.a.ix(1, this.xcS.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xcT != null) {
                ix += e.a.a.a.ix(2, this.xcT.computeSize());
            }
            if (this.xcU != null) {
                ix += e.a.a.a.ix(3, this.xcU.computeSize());
            }
            AppMethodBeat.o(94631);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94631);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cdg cdg = (cdg) objArr[1];
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
                        cdh cdh = new cdh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdh.populateBuilderWithField(aVar4, cdh, a.getNextFieldNumber(aVar4))) {
                        }
                        cdg.xcS = cdh;
                    }
                    AppMethodBeat.o(94631);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdf cdf = new cdf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdf.populateBuilderWithField(aVar4, cdf, a.getNextFieldNumber(aVar4))) {
                        }
                        cdg.xcT = cdf;
                    }
                    AppMethodBeat.o(94631);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cde cde = new cde();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cde.populateBuilderWithField(aVar4, cde, a.getNextFieldNumber(aVar4))) {
                        }
                        cdg.xcU = cde;
                    }
                    AppMethodBeat.o(94631);
                    return 0;
                default:
                    AppMethodBeat.o(94631);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94631);
            return -1;
        }
    }
}
