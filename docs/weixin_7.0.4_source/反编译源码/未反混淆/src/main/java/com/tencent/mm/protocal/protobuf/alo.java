package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class alo extends a {
    public int scene;
    public am wqQ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28452);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.scene);
            if (this.wqQ != null) {
                aVar.iy(2, this.wqQ.computeSize());
                this.wqQ.writeFields(aVar);
            }
            AppMethodBeat.o(28452);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.scene) + 0;
            if (this.wqQ != null) {
                bs += e.a.a.a.ix(2, this.wqQ.computeSize());
            }
            AppMethodBeat.o(28452);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28452);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            alo alo = (alo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    alo.scene = aVar3.BTU.vd();
                    AppMethodBeat.o(28452);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        am amVar = new am();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = amVar.populateBuilderWithField(aVar4, amVar, a.getNextFieldNumber(aVar4))) {
                        }
                        alo.wqQ = amVar;
                    }
                    AppMethodBeat.o(28452);
                    return 0;
                default:
                    AppMethodBeat.o(28452);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28452);
            return -1;
        }
    }
}
