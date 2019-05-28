package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class ph extends a {
    public pg vWA;
    public pg vWB;
    public pg vWC;
    public pg vWD;
    public pg vWE;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89051);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vWA != null) {
                aVar.iy(1, this.vWA.computeSize());
                this.vWA.writeFields(aVar);
            }
            if (this.vWB != null) {
                aVar.iy(2, this.vWB.computeSize());
                this.vWB.writeFields(aVar);
            }
            if (this.vWC != null) {
                aVar.iy(3, this.vWC.computeSize());
                this.vWC.writeFields(aVar);
            }
            if (this.vWD != null) {
                aVar.iy(4, this.vWD.computeSize());
                this.vWD.writeFields(aVar);
            }
            if (this.vWE != null) {
                aVar.iy(5, this.vWE.computeSize());
                this.vWE.writeFields(aVar);
            }
            AppMethodBeat.o(89051);
            return 0;
        } else if (i == 1) {
            if (this.vWA != null) {
                ix = e.a.a.a.ix(1, this.vWA.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vWB != null) {
                ix += e.a.a.a.ix(2, this.vWB.computeSize());
            }
            if (this.vWC != null) {
                ix += e.a.a.a.ix(3, this.vWC.computeSize());
            }
            if (this.vWD != null) {
                ix += e.a.a.a.ix(4, this.vWD.computeSize());
            }
            if (this.vWE != null) {
                ix += e.a.a.a.ix(5, this.vWE.computeSize());
            }
            AppMethodBeat.o(89051);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89051);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ph phVar = (ph) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            pg pgVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        pgVar = new pg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = pgVar.populateBuilderWithField(aVar4, pgVar, a.getNextFieldNumber(aVar4))) {
                        }
                        phVar.vWA = pgVar;
                    }
                    AppMethodBeat.o(89051);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        pgVar = new pg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = pgVar.populateBuilderWithField(aVar4, pgVar, a.getNextFieldNumber(aVar4))) {
                        }
                        phVar.vWB = pgVar;
                    }
                    AppMethodBeat.o(89051);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        pgVar = new pg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = pgVar.populateBuilderWithField(aVar4, pgVar, a.getNextFieldNumber(aVar4))) {
                        }
                        phVar.vWC = pgVar;
                    }
                    AppMethodBeat.o(89051);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        pgVar = new pg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = pgVar.populateBuilderWithField(aVar4, pgVar, a.getNextFieldNumber(aVar4))) {
                        }
                        phVar.vWD = pgVar;
                    }
                    AppMethodBeat.o(89051);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        pgVar = new pg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = pgVar.populateBuilderWithField(aVar4, pgVar, a.getNextFieldNumber(aVar4))) {
                        }
                        phVar.vWE = pgVar;
                    }
                    AppMethodBeat.o(89051);
                    return 0;
                default:
                    AppMethodBeat.o(89051);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89051);
            return -1;
        }
    }
}
