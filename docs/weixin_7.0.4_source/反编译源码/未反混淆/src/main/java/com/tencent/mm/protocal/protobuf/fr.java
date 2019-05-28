package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class fr extends a {
    public bau vHB;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94511);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vHB == null) {
                bVar = new b("Not all required fields were included: MediaObj");
                AppMethodBeat.o(94511);
                throw bVar;
            }
            if (this.vHB != null) {
                aVar.iy(1, this.vHB.computeSize());
                this.vHB.writeFields(aVar);
            }
            AppMethodBeat.o(94511);
            return 0;
        } else if (i == 1) {
            if (this.vHB != null) {
                ix = e.a.a.a.ix(1, this.vHB.computeSize()) + 0;
            } else {
                ix = 0;
            }
            AppMethodBeat.o(94511);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.vHB == null) {
                bVar = new b("Not all required fields were included: MediaObj");
                AppMethodBeat.o(94511);
                throw bVar;
            }
            AppMethodBeat.o(94511);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            fr frVar = (fr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bau bau = new bau();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bau.populateBuilderWithField(aVar4, bau, a.getNextFieldNumber(aVar4))) {
                        }
                        frVar.vHB = bau;
                    }
                    AppMethodBeat.o(94511);
                    return 0;
                default:
                    AppMethodBeat.o(94511);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94511);
            return -1;
        }
    }
}
