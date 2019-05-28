package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class bvy extends a {
    public int wWH;
    public int wWI;
    public int wWJ;
    public int wWK;
    public int wWL;
    public int wWM;
    public int wWN;
    public b wdt;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28628);
        e.a.a.b bVar;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wdt == null) {
                bVar = new e.a.a.b("Not all required fields were included: data");
                AppMethodBeat.o(28628);
                throw bVar;
            }
            aVar.iz(1, this.wWH);
            aVar.iz(2, this.wWI);
            aVar.iz(3, this.wWJ);
            aVar.iz(4, this.wWK);
            aVar.iz(5, this.wWL);
            aVar.iz(6, this.wWM);
            aVar.iz(7, this.wWN);
            if (this.wdt != null) {
                aVar.c(8, this.wdt);
            }
            AppMethodBeat.o(28628);
            return 0;
        } else if (i == 1) {
            int bs = ((((((e.a.a.b.b.a.bs(1, this.wWH) + 0) + e.a.a.b.b.a.bs(2, this.wWI)) + e.a.a.b.b.a.bs(3, this.wWJ)) + e.a.a.b.b.a.bs(4, this.wWK)) + e.a.a.b.b.a.bs(5, this.wWL)) + e.a.a.b.b.a.bs(6, this.wWM)) + e.a.a.b.b.a.bs(7, this.wWN);
            if (this.wdt != null) {
                bs += e.a.a.b.b.a.b(8, this.wdt);
            }
            AppMethodBeat.o(28628);
            return bs;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.ems();
                }
            }
            if (bArr == null) {
                bVar = new e.a.a.b("Not all required fields were included: data");
                AppMethodBeat.o(28628);
                throw bVar;
            }
            AppMethodBeat.o(28628);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bvy bvy = (bvy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bvy.wWH = aVar3.BTU.vd();
                    AppMethodBeat.o(28628);
                    return 0;
                case 2:
                    bvy.wWI = aVar3.BTU.vd();
                    AppMethodBeat.o(28628);
                    return 0;
                case 3:
                    bvy.wWJ = aVar3.BTU.vd();
                    AppMethodBeat.o(28628);
                    return 0;
                case 4:
                    bvy.wWK = aVar3.BTU.vd();
                    AppMethodBeat.o(28628);
                    return 0;
                case 5:
                    bvy.wWL = aVar3.BTU.vd();
                    AppMethodBeat.o(28628);
                    return 0;
                case 6:
                    bvy.wWM = aVar3.BTU.vd();
                    AppMethodBeat.o(28628);
                    return 0;
                case 7:
                    bvy.wWN = aVar3.BTU.vd();
                    AppMethodBeat.o(28628);
                    return 0;
                case 8:
                    bvy.wdt = aVar3.BTU.emu();
                    AppMethodBeat.o(28628);
                    return 0;
                default:
                    AppMethodBeat.o(28628);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28628);
            return -1;
        }
    }
}
