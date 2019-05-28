package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class mt extends a {
    public tz vQM;
    public ms vQN;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48785);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vQM != null) {
                aVar.iy(1, this.vQM.computeSize());
                this.vQM.writeFields(aVar);
            }
            if (this.vQN != null) {
                aVar.iy(2, this.vQN.computeSize());
                this.vQN.writeFields(aVar);
            }
            AppMethodBeat.o(48785);
            return 0;
        } else if (i == 1) {
            if (this.vQM != null) {
                ix = e.a.a.a.ix(1, this.vQM.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vQN != null) {
                ix += e.a.a.a.ix(2, this.vQN.computeSize());
            }
            AppMethodBeat.o(48785);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48785);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            mt mtVar = (mt) objArr[1];
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
                        tz tzVar = new tz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tzVar.populateBuilderWithField(aVar4, tzVar, a.getNextFieldNumber(aVar4))) {
                        }
                        mtVar.vQM = tzVar;
                    }
                    AppMethodBeat.o(48785);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ms msVar = new ms();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = msVar.populateBuilderWithField(aVar4, msVar, a.getNextFieldNumber(aVar4))) {
                        }
                        mtVar.vQN = msVar;
                    }
                    AppMethodBeat.o(48785);
                    return 0;
                default:
                    AppMethodBeat.o(48785);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48785);
            return -1;
        }
    }
}
