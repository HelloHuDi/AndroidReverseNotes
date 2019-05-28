package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class aj extends a {
    public cb naR;
    public cb naS;
    public cb naT;
    public cz naU;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111576);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.naR != null) {
                aVar.iy(1, this.naR.computeSize());
                this.naR.writeFields(aVar);
            }
            if (this.naS != null) {
                aVar.iy(2, this.naS.computeSize());
                this.naS.writeFields(aVar);
            }
            if (this.naT != null) {
                aVar.iy(3, this.naT.computeSize());
                this.naT.writeFields(aVar);
            }
            if (this.naU != null) {
                aVar.iy(4, this.naU.computeSize());
                this.naU.writeFields(aVar);
            }
            AppMethodBeat.o(111576);
            return 0;
        } else if (i == 1) {
            if (this.naR != null) {
                ix = e.a.a.a.ix(1, this.naR.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.naS != null) {
                ix += e.a.a.a.ix(2, this.naS.computeSize());
            }
            if (this.naT != null) {
                ix += e.a.a.a.ix(3, this.naT.computeSize());
            }
            if (this.naU != null) {
                ix += e.a.a.a.ix(4, this.naU.computeSize());
            }
            AppMethodBeat.o(111576);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111576);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aj ajVar = (aj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            cb cbVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbVar = new cb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbVar.populateBuilderWithField(aVar4, cbVar, a.getNextFieldNumber(aVar4))) {
                        }
                        ajVar.naR = cbVar;
                    }
                    AppMethodBeat.o(111576);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbVar = new cb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbVar.populateBuilderWithField(aVar4, cbVar, a.getNextFieldNumber(aVar4))) {
                        }
                        ajVar.naS = cbVar;
                    }
                    AppMethodBeat.o(111576);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbVar = new cb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbVar.populateBuilderWithField(aVar4, cbVar, a.getNextFieldNumber(aVar4))) {
                        }
                        ajVar.naT = cbVar;
                    }
                    AppMethodBeat.o(111576);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cz czVar = new cz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = czVar.populateBuilderWithField(aVar4, czVar, a.getNextFieldNumber(aVar4))) {
                        }
                        ajVar.naU = czVar;
                    }
                    AppMethodBeat.o(111576);
                    return 0;
                default:
                    AppMethodBeat.o(111576);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111576);
            return -1;
        }
    }
}
