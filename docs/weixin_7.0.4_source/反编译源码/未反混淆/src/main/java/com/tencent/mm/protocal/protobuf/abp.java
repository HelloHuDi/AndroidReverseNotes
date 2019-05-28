package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class abp extends a {
    public int bGt;
    public String rMJ;
    public String wiE;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51416);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.rMJ == null) {
                bVar = new b("Not all required fields were included: tagName");
                AppMethodBeat.o(51416);
                throw bVar;
            } else if (this.wiE == null) {
                bVar = new b("Not all required fields were included: tagPinYin");
                AppMethodBeat.o(51416);
                throw bVar;
            } else {
                if (this.rMJ != null) {
                    aVar.e(1, this.rMJ);
                }
                if (this.wiE != null) {
                    aVar.e(2, this.wiE);
                }
                aVar.iz(3, this.bGt);
                AppMethodBeat.o(51416);
                return 0;
            }
        } else if (i == 1) {
            if (this.rMJ != null) {
                f = e.a.a.b.b.a.f(1, this.rMJ) + 0;
            } else {
                f = 0;
            }
            if (this.wiE != null) {
                f += e.a.a.b.b.a.f(2, this.wiE);
            }
            int bs = f + e.a.a.b.b.a.bs(3, this.bGt);
            AppMethodBeat.o(51416);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.rMJ == null) {
                bVar = new b("Not all required fields were included: tagName");
                AppMethodBeat.o(51416);
                throw bVar;
            } else if (this.wiE == null) {
                bVar = new b("Not all required fields were included: tagPinYin");
                AppMethodBeat.o(51416);
                throw bVar;
            } else {
                AppMethodBeat.o(51416);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            abp abp = (abp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abp.rMJ = aVar3.BTU.readString();
                    AppMethodBeat.o(51416);
                    return 0;
                case 2:
                    abp.wiE = aVar3.BTU.readString();
                    AppMethodBeat.o(51416);
                    return 0;
                case 3:
                    abp.bGt = aVar3.BTU.vd();
                    AppMethodBeat.o(51416);
                    return 0;
                default:
                    AppMethodBeat.o(51416);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51416);
            return -1;
        }
    }
}
