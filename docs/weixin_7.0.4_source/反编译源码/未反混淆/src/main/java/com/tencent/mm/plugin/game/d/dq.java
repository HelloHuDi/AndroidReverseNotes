package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class dq extends a {
    public String mZL;
    public dr ndN;
    public ab ndO;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111681);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ndN != null) {
                aVar.iy(1, this.ndN.computeSize());
                this.ndN.writeFields(aVar);
            }
            if (this.ndO != null) {
                aVar.iy(2, this.ndO.computeSize());
                this.ndO.writeFields(aVar);
            }
            if (this.mZL != null) {
                aVar.e(3, this.mZL);
            }
            AppMethodBeat.o(111681);
            return 0;
        } else if (i == 1) {
            if (this.ndN != null) {
                ix = e.a.a.a.ix(1, this.ndN.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ndO != null) {
                ix += e.a.a.a.ix(2, this.ndO.computeSize());
            }
            if (this.mZL != null) {
                ix += e.a.a.b.b.a.f(3, this.mZL);
            }
            AppMethodBeat.o(111681);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111681);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dq dqVar = (dq) objArr[1];
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
                        dr drVar = new dr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = drVar.populateBuilderWithField(aVar4, drVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dqVar.ndN = drVar;
                    }
                    AppMethodBeat.o(111681);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ab abVar = new ab();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = abVar.populateBuilderWithField(aVar4, abVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dqVar.ndO = abVar;
                    }
                    AppMethodBeat.o(111681);
                    return 0;
                case 3:
                    dqVar.mZL = aVar3.BTU.readString();
                    AppMethodBeat.o(111681);
                    return 0;
                default:
                    AppMethodBeat.o(111681);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111681);
            return -1;
        }
    }
}
