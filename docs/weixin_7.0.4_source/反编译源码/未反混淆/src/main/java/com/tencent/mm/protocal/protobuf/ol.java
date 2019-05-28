package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class ol extends a {
    public LinkedList<oa> vUN = new LinkedList();

    public ol() {
        AppMethodBeat.i(89045);
        AppMethodBeat.o(89045);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89046);
        int c;
        byte[] bArr;
        if (i == 0) {
            ((e.a.a.c.a) objArr[0]).e(1, 8, this.vUN);
            AppMethodBeat.o(89046);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.vUN) + 0;
            AppMethodBeat.o(89046);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vUN.clear();
            e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar); c > 0; c = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, c)) {
                    aVar.ems();
                }
            }
            AppMethodBeat.o(89046);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar2 = (e.a.a.a.a) objArr[0];
            ol olVar = (ol) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar2.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        oa oaVar = new oa();
                        e.a.a.a.a aVar3 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = oaVar.populateBuilderWithField(aVar3, oaVar, a.getNextFieldNumber(aVar3))) {
                        }
                        olVar.vUN.add(oaVar);
                    }
                    AppMethodBeat.o(89046);
                    return 0;
                default:
                    AppMethodBeat.o(89046);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89046);
            return -1;
        }
    }
}
