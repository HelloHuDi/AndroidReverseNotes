package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ccy extends a {
    public int xcC;
    public int xcD;
    public int xcE;
    public int xcg;
    public coj xch;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5223);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xch == null) {
                bVar = new b("Not all required fields were included: Addr");
                AppMethodBeat.o(5223);
                throw bVar;
            }
            if (this.xch != null) {
                aVar.iy(1, this.xch.computeSize());
                this.xch.writeFields(aVar);
            }
            aVar.iz(2, this.xcg);
            aVar.iz(3, this.xcC);
            aVar.iz(4, this.xcD);
            aVar.iz(5, this.xcE);
            AppMethodBeat.o(5223);
            return 0;
        } else if (i == 1) {
            if (this.xch != null) {
                ix = e.a.a.a.ix(1, this.xch.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = (((ix + e.a.a.b.b.a.bs(2, this.xcg)) + e.a.a.b.b.a.bs(3, this.xcC)) + e.a.a.b.b.a.bs(4, this.xcD)) + e.a.a.b.b.a.bs(5, this.xcE);
            AppMethodBeat.o(5223);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.xch == null) {
                bVar = new b("Not all required fields were included: Addr");
                AppMethodBeat.o(5223);
                throw bVar;
            }
            AppMethodBeat.o(5223);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ccy ccy = (ccy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        coj coj = new coj();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = coj.populateBuilderWithField(aVar4, coj, a.getNextFieldNumber(aVar4))) {
                        }
                        ccy.xch = coj;
                    }
                    AppMethodBeat.o(5223);
                    return 0;
                case 2:
                    ccy.xcg = aVar3.BTU.vd();
                    AppMethodBeat.o(5223);
                    return 0;
                case 3:
                    ccy.xcC = aVar3.BTU.vd();
                    AppMethodBeat.o(5223);
                    return 0;
                case 4:
                    ccy.xcD = aVar3.BTU.vd();
                    AppMethodBeat.o(5223);
                    return 0;
                case 5:
                    ccy.xcE = aVar3.BTU.vd();
                    AppMethodBeat.o(5223);
                    return 0;
                default:
                    AppMethodBeat.o(5223);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5223);
            return -1;
        }
    }
}
