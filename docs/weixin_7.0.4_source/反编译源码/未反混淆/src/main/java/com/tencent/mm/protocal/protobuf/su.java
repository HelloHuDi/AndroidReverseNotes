package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class su extends a {
    public int wal;
    public LinkedList<st> wam = new LinkedList();

    public su() {
        AppMethodBeat.i(126190);
        AppMethodBeat.o(126190);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(126191);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wal);
            aVar.e(2, 8, this.wam);
            AppMethodBeat.o(126191);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.wal) + 0) + e.a.a.a.c(2, 8, this.wam);
            AppMethodBeat.o(126191);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wam.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(126191);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            su suVar = (su) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    suVar.wal = aVar3.BTU.vd();
                    AppMethodBeat.o(126191);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        st stVar = new st();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = stVar.populateBuilderWithField(aVar4, stVar, a.getNextFieldNumber(aVar4))) {
                        }
                        suVar.wam.add(stVar);
                    }
                    AppMethodBeat.o(126191);
                    return 0;
                default:
                    AppMethodBeat.o(126191);
                    return -1;
            }
        } else {
            AppMethodBeat.o(126191);
            return -1;
        }
    }
}
