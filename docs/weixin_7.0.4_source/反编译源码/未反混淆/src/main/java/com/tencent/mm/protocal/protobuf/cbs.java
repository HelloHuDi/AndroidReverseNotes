package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cbs extends a {
    public SKBuiltinBuffer_t xbe;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94598);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xbe != null) {
                aVar.iy(1, this.xbe.computeSize());
                this.xbe.writeFields(aVar);
            }
            AppMethodBeat.o(94598);
            return 0;
        } else if (i == 1) {
            if (this.xbe != null) {
                ix = e.a.a.a.ix(1, this.xbe.computeSize()) + 0;
            } else {
                ix = 0;
            }
            AppMethodBeat.o(94598);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94598);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cbs cbs = (cbs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        cbs.xbe = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(94598);
                    return 0;
                default:
                    AppMethodBeat.o(94598);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94598);
            return -1;
        }
    }
}
