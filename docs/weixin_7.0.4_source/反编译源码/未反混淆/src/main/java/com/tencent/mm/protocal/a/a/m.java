package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class m extends a {
    public int vzw;
    public int vzx;
    public LinkedList<n> vzy = new LinkedList();

    public m() {
        AppMethodBeat.i(72832);
        AppMethodBeat.o(72832);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(72833);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vzw);
            aVar.iz(2, this.vzx);
            aVar.e(3, 8, this.vzy);
            AppMethodBeat.o(72833);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.vzw) + 0) + e.a.a.b.b.a.bs(2, this.vzx)) + e.a.a.a.c(3, 8, this.vzy);
            AppMethodBeat.o(72833);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vzy.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(72833);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            m mVar = (m) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    mVar.vzw = aVar3.BTU.vd();
                    AppMethodBeat.o(72833);
                    return 0;
                case 2:
                    mVar.vzx = aVar3.BTU.vd();
                    AppMethodBeat.o(72833);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        n nVar = new n();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = nVar.populateBuilderWithField(aVar4, nVar, a.getNextFieldNumber(aVar4))) {
                        }
                        mVar.vzy.add(nVar);
                    }
                    AppMethodBeat.o(72833);
                    return 0;
                default:
                    AppMethodBeat.o(72833);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72833);
            return -1;
        }
    }
}
