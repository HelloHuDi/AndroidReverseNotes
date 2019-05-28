package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class crm extends a {
    public cqm xoW;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(102424);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xoW == null) {
                bVar = new b("Not all required fields were included: base_response");
                AppMethodBeat.o(102424);
                throw bVar;
            }
            if (this.xoW != null) {
                aVar.iy(1, this.xoW.computeSize());
                this.xoW.writeFields(aVar);
            }
            AppMethodBeat.o(102424);
            return 0;
        } else if (i == 1) {
            if (this.xoW != null) {
                ix = e.a.a.a.ix(1, this.xoW.computeSize()) + 0;
            } else {
                ix = 0;
            }
            AppMethodBeat.o(102424);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.xoW == null) {
                bVar = new b("Not all required fields were included: base_response");
                AppMethodBeat.o(102424);
                throw bVar;
            }
            AppMethodBeat.o(102424);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            crm crm = (crm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        cqm cqm = new cqm();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cqm.populateBuilderWithField(aVar4, cqm, a.getNextFieldNumber(aVar4))) {
                        }
                        crm.xoW = cqm;
                    }
                    AppMethodBeat.o(102424);
                    return 0;
                default:
                    AppMethodBeat.o(102424);
                    return -1;
            }
        } else {
            AppMethodBeat.o(102424);
            return -1;
        }
    }
}
