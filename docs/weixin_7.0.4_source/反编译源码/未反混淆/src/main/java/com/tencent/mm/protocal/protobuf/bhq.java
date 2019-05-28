package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bhq extends a {
    public tc wIw;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(60057);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wIw == null) {
                bVar = new b("Not all required fields were included: Oplog");
                AppMethodBeat.o(60057);
                throw bVar;
            }
            if (this.wIw != null) {
                aVar.iy(1, this.wIw.computeSize());
                this.wIw.writeFields(aVar);
            }
            AppMethodBeat.o(60057);
            return 0;
        } else if (i == 1) {
            if (this.wIw != null) {
                ix = e.a.a.a.ix(1, this.wIw.computeSize()) + 0;
            } else {
                ix = 0;
            }
            AppMethodBeat.o(60057);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wIw == null) {
                bVar = new b("Not all required fields were included: Oplog");
                AppMethodBeat.o(60057);
                throw bVar;
            }
            AppMethodBeat.o(60057);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bhq bhq = (bhq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        tc tcVar = new tc();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = tcVar.populateBuilderWithField(aVar4, tcVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bhq.wIw = tcVar;
                    }
                    AppMethodBeat.o(60057);
                    return 0;
                default:
                    AppMethodBeat.o(60057);
                    return -1;
            }
        } else {
            AppMethodBeat.o(60057);
            return -1;
        }
    }
}
