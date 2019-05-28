package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bd extends a {
    public be vDb;
    public be vDc;
    public be vDd;
    public be vDe;
    public be vDf;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73643);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vDb != null) {
                aVar.iy(1, this.vDb.computeSize());
                this.vDb.writeFields(aVar);
            }
            if (this.vDc != null) {
                aVar.iy(2, this.vDc.computeSize());
                this.vDc.writeFields(aVar);
            }
            if (this.vDd != null) {
                aVar.iy(3, this.vDd.computeSize());
                this.vDd.writeFields(aVar);
            }
            if (this.vDe != null) {
                aVar.iy(4, this.vDe.computeSize());
                this.vDe.writeFields(aVar);
            }
            if (this.vDf != null) {
                aVar.iy(5, this.vDf.computeSize());
                this.vDf.writeFields(aVar);
            }
            AppMethodBeat.o(73643);
            return 0;
        } else if (i == 1) {
            if (this.vDb != null) {
                ix = e.a.a.a.ix(1, this.vDb.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vDc != null) {
                ix += e.a.a.a.ix(2, this.vDc.computeSize());
            }
            if (this.vDd != null) {
                ix += e.a.a.a.ix(3, this.vDd.computeSize());
            }
            if (this.vDe != null) {
                ix += e.a.a.a.ix(4, this.vDe.computeSize());
            }
            if (this.vDf != null) {
                ix += e.a.a.a.ix(5, this.vDf.computeSize());
            }
            AppMethodBeat.o(73643);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(73643);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bd bdVar = (bd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            be beVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        beVar = new be();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = beVar.populateBuilderWithField(aVar4, beVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bdVar.vDb = beVar;
                    }
                    AppMethodBeat.o(73643);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        beVar = new be();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = beVar.populateBuilderWithField(aVar4, beVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bdVar.vDc = beVar;
                    }
                    AppMethodBeat.o(73643);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        beVar = new be();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = beVar.populateBuilderWithField(aVar4, beVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bdVar.vDd = beVar;
                    }
                    AppMethodBeat.o(73643);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        beVar = new be();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = beVar.populateBuilderWithField(aVar4, beVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bdVar.vDe = beVar;
                    }
                    AppMethodBeat.o(73643);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        beVar = new be();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = beVar.populateBuilderWithField(aVar4, beVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bdVar.vDf = beVar;
                    }
                    AppMethodBeat.o(73643);
                    return 0;
                default:
                    AppMethodBeat.o(73643);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73643);
            return -1;
        }
    }
}
