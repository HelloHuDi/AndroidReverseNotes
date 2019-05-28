package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cxr extends a {
    public cxt xtd;
    public cxs xte;
    public cxu xtf;
    public cxw xtg;
    public cxv xth;
    public cxx xti;
    public cxq xtj;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(115018);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xtd != null) {
                aVar.iy(1, this.xtd.computeSize());
                this.xtd.writeFields(aVar);
            }
            if (this.xte != null) {
                aVar.iy(2, this.xte.computeSize());
                this.xte.writeFields(aVar);
            }
            if (this.xtf != null) {
                aVar.iy(3, this.xtf.computeSize());
                this.xtf.writeFields(aVar);
            }
            if (this.xtg != null) {
                aVar.iy(4, this.xtg.computeSize());
                this.xtg.writeFields(aVar);
            }
            if (this.xth != null) {
                aVar.iy(5, this.xth.computeSize());
                this.xth.writeFields(aVar);
            }
            if (this.xti != null) {
                aVar.iy(6, this.xti.computeSize());
                this.xti.writeFields(aVar);
            }
            if (this.xtj != null) {
                aVar.iy(7, this.xtj.computeSize());
                this.xtj.writeFields(aVar);
            }
            AppMethodBeat.o(115018);
            return 0;
        } else if (i == 1) {
            if (this.xtd != null) {
                ix = e.a.a.a.ix(1, this.xtd.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xte != null) {
                ix += e.a.a.a.ix(2, this.xte.computeSize());
            }
            if (this.xtf != null) {
                ix += e.a.a.a.ix(3, this.xtf.computeSize());
            }
            if (this.xtg != null) {
                ix += e.a.a.a.ix(4, this.xtg.computeSize());
            }
            if (this.xth != null) {
                ix += e.a.a.a.ix(5, this.xth.computeSize());
            }
            if (this.xti != null) {
                ix += e.a.a.a.ix(6, this.xti.computeSize());
            }
            if (this.xtj != null) {
                ix += e.a.a.a.ix(7, this.xtj.computeSize());
            }
            AppMethodBeat.o(115018);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(115018);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cxr cxr = (cxr) objArr[1];
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
                        cxt cxt = new cxt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxt.populateBuilderWithField(aVar4, cxt, a.getNextFieldNumber(aVar4))) {
                        }
                        cxr.xtd = cxt;
                    }
                    AppMethodBeat.o(115018);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cxs cxs = new cxs();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxs.populateBuilderWithField(aVar4, cxs, a.getNextFieldNumber(aVar4))) {
                        }
                        cxr.xte = cxs;
                    }
                    AppMethodBeat.o(115018);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cxu cxu = new cxu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxu.populateBuilderWithField(aVar4, cxu, a.getNextFieldNumber(aVar4))) {
                        }
                        cxr.xtf = cxu;
                    }
                    AppMethodBeat.o(115018);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cxw cxw = new cxw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxw.populateBuilderWithField(aVar4, cxw, a.getNextFieldNumber(aVar4))) {
                        }
                        cxr.xtg = cxw;
                    }
                    AppMethodBeat.o(115018);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cxv cxv = new cxv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxv.populateBuilderWithField(aVar4, cxv, a.getNextFieldNumber(aVar4))) {
                        }
                        cxr.xth = cxv;
                    }
                    AppMethodBeat.o(115018);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cxx cxx = new cxx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxx.populateBuilderWithField(aVar4, cxx, a.getNextFieldNumber(aVar4))) {
                        }
                        cxr.xti = cxx;
                    }
                    AppMethodBeat.o(115018);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cxq cxq = new cxq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxq.populateBuilderWithField(aVar4, cxq, a.getNextFieldNumber(aVar4))) {
                        }
                        cxr.xtj = cxq;
                    }
                    AppMethodBeat.o(115018);
                    return 0;
                default:
                    AppMethodBeat.o(115018);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115018);
            return -1;
        }
    }
}
