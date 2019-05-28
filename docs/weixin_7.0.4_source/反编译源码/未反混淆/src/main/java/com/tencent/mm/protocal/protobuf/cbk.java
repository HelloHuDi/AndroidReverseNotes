package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cbk extends a {
    public int Scene;
    public int xaJ;
    public bts xaK;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94587);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.xaJ);
            if (this.xaK != null) {
                aVar.iy(2, this.xaK.computeSize());
                this.xaK.writeFields(aVar);
            }
            aVar.iz(3, this.Scene);
            AppMethodBeat.o(94587);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.xaJ) + 0;
            if (this.xaK != null) {
                bs += e.a.a.a.ix(2, this.xaK.computeSize());
            }
            bs += e.a.a.b.b.a.bs(3, this.Scene);
            AppMethodBeat.o(94587);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94587);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cbk cbk = (cbk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cbk.xaJ = aVar3.BTU.vd();
                    AppMethodBeat.o(94587);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        cbk.xaK = bts;
                    }
                    AppMethodBeat.o(94587);
                    return 0;
                case 3:
                    cbk.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(94587);
                    return 0;
                default:
                    AppMethodBeat.o(94587);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94587);
            return -1;
        }
    }
}
