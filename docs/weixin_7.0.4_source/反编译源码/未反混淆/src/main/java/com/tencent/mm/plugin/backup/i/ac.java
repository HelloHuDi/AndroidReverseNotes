package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class ac extends a {
    public int jBT;
    public int jBh;
    public q jCL;
    public p jCM;
    public r jCN;
    public s jCO;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(18078);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.jBh);
            aVar.iz(2, this.jBT);
            if (this.jCL != null) {
                aVar.iy(3, this.jCL.computeSize());
                this.jCL.writeFields(aVar);
            }
            if (this.jCM != null) {
                aVar.iy(4, this.jCM.computeSize());
                this.jCM.writeFields(aVar);
            }
            if (this.jCN != null) {
                aVar.iy(5, this.jCN.computeSize());
                this.jCN.writeFields(aVar);
            }
            if (this.jCO != null) {
                aVar.iy(6, this.jCO.computeSize());
                this.jCO.writeFields(aVar);
            }
            AppMethodBeat.o(18078);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.jBh) + 0) + e.a.a.b.b.a.bs(2, this.jBT);
            if (this.jCL != null) {
                bs += e.a.a.a.ix(3, this.jCL.computeSize());
            }
            if (this.jCM != null) {
                bs += e.a.a.a.ix(4, this.jCM.computeSize());
            }
            if (this.jCN != null) {
                bs += e.a.a.a.ix(5, this.jCN.computeSize());
            }
            if (this.jCO != null) {
                bs += e.a.a.a.ix(6, this.jCO.computeSize());
            }
            AppMethodBeat.o(18078);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(18078);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ac acVar = (ac) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    acVar.jBh = aVar3.BTU.vd();
                    AppMethodBeat.o(18078);
                    return 0;
                case 2:
                    acVar.jBT = aVar3.BTU.vd();
                    AppMethodBeat.o(18078);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        q qVar = new q();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qVar.populateBuilderWithField(aVar4, qVar, a.getNextFieldNumber(aVar4))) {
                        }
                        acVar.jCL = qVar;
                    }
                    AppMethodBeat.o(18078);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        p pVar = new p();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = pVar.populateBuilderWithField(aVar4, pVar, a.getNextFieldNumber(aVar4))) {
                        }
                        acVar.jCM = pVar;
                    }
                    AppMethodBeat.o(18078);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        r rVar = new r();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = rVar.populateBuilderWithField(aVar4, rVar, a.getNextFieldNumber(aVar4))) {
                        }
                        acVar.jCN = rVar;
                    }
                    AppMethodBeat.o(18078);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        s sVar = new s();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sVar.populateBuilderWithField(aVar4, sVar, a.getNextFieldNumber(aVar4))) {
                        }
                        acVar.jCO = sVar;
                    }
                    AppMethodBeat.o(18078);
                    return 0;
                default:
                    AppMethodBeat.o(18078);
                    return -1;
            }
        } else {
            AppMethodBeat.o(18078);
            return -1;
        }
    }
}
