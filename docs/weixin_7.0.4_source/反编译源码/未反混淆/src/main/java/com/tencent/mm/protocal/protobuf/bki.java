package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bki extends a {
    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(134435);
        if (i == 0) {
            AppMethodBeat.o(134435);
            return 0;
        } else if (i == 1) {
            AppMethodBeat.o(134435);
            return 0;
        } else if (i == 2) {
            e.a.a.a.a aVar = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, nextFieldNumber)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(134435);
            return 0;
        } else if (i == 3) {
            ((Integer) objArr[2]).intValue();
            AppMethodBeat.o(134435);
            return -1;
        } else {
            AppMethodBeat.o(134435);
            return -1;
        }
    }
}
