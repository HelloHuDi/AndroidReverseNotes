package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class ux extends a {
    public bdq wcs;
    public LinkedList<xc> wct = new LinkedList();
    public LinkedList<cnv> wcu = new LinkedList();
    public String wcv;

    public ux() {
        AppMethodBeat.i(48830);
        AppMethodBeat.o(48830);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48831);
        int ix;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wcs != null) {
                aVar.iy(1, this.wcs.computeSize());
                this.wcs.writeFields(aVar);
            }
            aVar.e(2, 8, this.wct);
            aVar.e(3, 8, this.wcu);
            if (this.wcv != null) {
                aVar.e(4, this.wcv);
            }
            AppMethodBeat.o(48831);
            return 0;
        } else if (i == 1) {
            if (this.wcs != null) {
                ix = e.a.a.a.ix(1, this.wcs.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.a.c(2, 8, this.wct)) + e.a.a.a.c(3, 8, this.wcu);
            if (this.wcv != null) {
                ix += e.a.a.b.b.a.f(4, this.wcv);
            }
            AppMethodBeat.o(48831);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wct.clear();
            this.wcu.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48831);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ux uxVar = (ux) objArr[1];
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
                        uxVar.wcs = bdq;
                    }
                    AppMethodBeat.o(48831);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        xc xcVar = new xc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xcVar.populateBuilderWithField(aVar4, xcVar, a.getNextFieldNumber(aVar4))) {
                        }
                        uxVar.wct.add(xcVar);
                    }
                    AppMethodBeat.o(48831);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cnv cnv = new cnv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cnv.populateBuilderWithField(aVar4, cnv, a.getNextFieldNumber(aVar4))) {
                        }
                        uxVar.wcu.add(cnv);
                    }
                    AppMethodBeat.o(48831);
                    return 0;
                case 4:
                    uxVar.wcv = aVar3.BTU.readString();
                    AppMethodBeat.o(48831);
                    return 0;
                default:
                    AppMethodBeat.o(48831);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48831);
            return -1;
        }
    }
}
