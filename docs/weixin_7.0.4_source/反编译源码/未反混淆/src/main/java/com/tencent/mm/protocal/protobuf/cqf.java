package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cqf extends a {
    public bts xfu;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5274);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xfu == null) {
                bVar = new b("Not all required fields were included: StatReport");
                AppMethodBeat.o(5274);
                throw bVar;
            }
            if (this.xfu != null) {
                aVar.iy(1, this.xfu.computeSize());
                this.xfu.writeFields(aVar);
            }
            AppMethodBeat.o(5274);
            return 0;
        } else if (i == 1) {
            if (this.xfu != null) {
                ix = e.a.a.a.ix(1, this.xfu.computeSize()) + 0;
            } else {
                ix = 0;
            }
            AppMethodBeat.o(5274);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.xfu == null) {
                bVar = new b("Not all required fields were included: StatReport");
                AppMethodBeat.o(5274);
                throw bVar;
            }
            AppMethodBeat.o(5274);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cqf cqf = (cqf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        cqf.xfu = bts;
                    }
                    AppMethodBeat.o(5274);
                    return 0;
                default:
                    AppMethodBeat.o(5274);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5274);
            return -1;
        }
    }
}
