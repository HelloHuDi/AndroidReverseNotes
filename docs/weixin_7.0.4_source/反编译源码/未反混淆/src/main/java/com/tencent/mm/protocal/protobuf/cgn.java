package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cgn extends a {
    public int wBd;
    public bts xfu;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28668);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xfu == null) {
                bVar = new b("Not all required fields were included: StatReport");
                AppMethodBeat.o(28668);
                throw bVar;
            }
            aVar.iz(1, this.wBd);
            if (this.xfu != null) {
                aVar.iy(2, this.xfu.computeSize());
                this.xfu.writeFields(aVar);
            }
            AppMethodBeat.o(28668);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.wBd) + 0;
            if (this.xfu != null) {
                bs += e.a.a.a.ix(2, this.xfu.computeSize());
            }
            AppMethodBeat.o(28668);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.xfu == null) {
                bVar = new b("Not all required fields were included: StatReport");
                AppMethodBeat.o(28668);
                throw bVar;
            }
            AppMethodBeat.o(28668);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cgn cgn = (cgn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cgn.wBd = aVar3.BTU.vd();
                    AppMethodBeat.o(28668);
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
                        cgn.xfu = bts;
                    }
                    AppMethodBeat.o(28668);
                    return 0;
                default:
                    AppMethodBeat.o(28668);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28668);
            return -1;
        }
    }
}
