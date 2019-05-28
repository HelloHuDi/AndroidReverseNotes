package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bdq extends a {
    public cgv vCN;
    public bds wHr;
    public bdr wHs;
    public bdr wHt;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48898);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vCN != null) {
                aVar.iy(1, this.vCN.computeSize());
                this.vCN.writeFields(aVar);
            }
            if (this.wHr != null) {
                aVar.iy(2, this.wHr.computeSize());
                this.wHr.writeFields(aVar);
            }
            if (this.wHs != null) {
                aVar.iy(3, this.wHs.computeSize());
                this.wHs.writeFields(aVar);
            }
            if (this.wHt != null) {
                aVar.iy(4, this.wHt.computeSize());
                this.wHt.writeFields(aVar);
            }
            AppMethodBeat.o(48898);
            return 0;
        } else if (i == 1) {
            if (this.vCN != null) {
                ix = e.a.a.a.ix(1, this.vCN.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wHr != null) {
                ix += e.a.a.a.ix(2, this.wHr.computeSize());
            }
            if (this.wHs != null) {
                ix += e.a.a.a.ix(3, this.wHs.computeSize());
            }
            if (this.wHt != null) {
                ix += e.a.a.a.ix(4, this.wHt.computeSize());
            }
            AppMethodBeat.o(48898);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48898);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bdq bdq = (bdq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            bdr bdr;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv cgv = new cgv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(aVar4, cgv, a.getNextFieldNumber(aVar4))) {
                        }
                        bdq.vCN = cgv;
                    }
                    AppMethodBeat.o(48898);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bds bds = new bds();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bds.populateBuilderWithField(aVar4, bds, a.getNextFieldNumber(aVar4))) {
                        }
                        bdq.wHr = bds;
                    }
                    AppMethodBeat.o(48898);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdr = new bdr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdr.populateBuilderWithField(aVar4, bdr, a.getNextFieldNumber(aVar4))) {
                        }
                        bdq.wHs = bdr;
                    }
                    AppMethodBeat.o(48898);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdr = new bdr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdr.populateBuilderWithField(aVar4, bdr, a.getNextFieldNumber(aVar4))) {
                        }
                        bdq.wHt = bdr;
                    }
                    AppMethodBeat.o(48898);
                    return 0;
                default:
                    AppMethodBeat.o(48898);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48898);
            return -1;
        }
    }
}
