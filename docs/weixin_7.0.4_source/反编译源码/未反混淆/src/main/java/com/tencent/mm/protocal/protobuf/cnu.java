package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cnu extends a {
    public ue xkY;
    public boolean xkZ = true;
    public cnq xla;
    public String xlb;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124376);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xkY != null) {
                aVar.iy(1, this.xkY.computeSize());
                this.xkY.writeFields(aVar);
            }
            aVar.aO(2, this.xkZ);
            if (this.xla != null) {
                aVar.iy(3, this.xla.computeSize());
                this.xla.writeFields(aVar);
            }
            if (this.xlb != null) {
                aVar.e(4, this.xlb);
            }
            AppMethodBeat.o(124376);
            return 0;
        } else if (i == 1) {
            if (this.xkY != null) {
                ix = e.a.a.a.ix(1, this.xkY.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.fv(2) + 1;
            if (this.xla != null) {
                ix += e.a.a.a.ix(3, this.xla.computeSize());
            }
            if (this.xlb != null) {
                ix += e.a.a.b.b.a.f(4, this.xlb);
            }
            AppMethodBeat.o(124376);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124376);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cnu cnu = (cnu) objArr[1];
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
                        ue ueVar = new ue();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ueVar.populateBuilderWithField(aVar4, ueVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cnu.xkY = ueVar;
                    }
                    AppMethodBeat.o(124376);
                    return 0;
                case 2:
                    cnu.xkZ = aVar3.BTU.ehX();
                    AppMethodBeat.o(124376);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cnq cnq = new cnq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cnq.populateBuilderWithField(aVar4, cnq, a.getNextFieldNumber(aVar4))) {
                        }
                        cnu.xla = cnq;
                    }
                    AppMethodBeat.o(124376);
                    return 0;
                case 4:
                    cnu.xlb = aVar3.BTU.readString();
                    AppMethodBeat.o(124376);
                    return 0;
                default:
                    AppMethodBeat.o(124376);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124376);
            return -1;
        }
    }
}
