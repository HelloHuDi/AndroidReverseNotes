package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class bbc extends a {
    public String cEh;
    public int type;
    public String url;
    public String wFS;
    public String wFT;
    public String wFU;
    public int wFV;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56853);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.cEh == null) {
                bVar = new b("Not all required fields were included: wording");
                AppMethodBeat.o(56853);
                throw bVar;
            }
            aVar.iz(1, this.type);
            if (this.cEh != null) {
                aVar.e(2, this.cEh);
            }
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            if (this.wFS != null) {
                aVar.e(4, this.wFS);
            }
            if (this.wFT != null) {
                aVar.e(5, this.wFT);
            }
            if (this.wFU != null) {
                aVar.e(6, this.wFU);
            }
            aVar.iz(7, this.wFV);
            AppMethodBeat.o(56853);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.type) + 0;
            if (this.cEh != null) {
                bs += e.a.a.b.b.a.f(2, this.cEh);
            }
            if (this.url != null) {
                bs += e.a.a.b.b.a.f(3, this.url);
            }
            if (this.wFS != null) {
                bs += e.a.a.b.b.a.f(4, this.wFS);
            }
            if (this.wFT != null) {
                bs += e.a.a.b.b.a.f(5, this.wFT);
            }
            if (this.wFU != null) {
                bs += e.a.a.b.b.a.f(6, this.wFU);
            }
            bs += e.a.a.b.b.a.bs(7, this.wFV);
            AppMethodBeat.o(56853);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.cEh == null) {
                bVar = new b("Not all required fields were included: wording");
                AppMethodBeat.o(56853);
                throw bVar;
            }
            AppMethodBeat.o(56853);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bbc bbc = (bbc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bbc.type = aVar3.BTU.vd();
                    AppMethodBeat.o(56853);
                    return 0;
                case 2:
                    bbc.cEh = aVar3.BTU.readString();
                    AppMethodBeat.o(56853);
                    return 0;
                case 3:
                    bbc.url = aVar3.BTU.readString();
                    AppMethodBeat.o(56853);
                    return 0;
                case 4:
                    bbc.wFS = aVar3.BTU.readString();
                    AppMethodBeat.o(56853);
                    return 0;
                case 5:
                    bbc.wFT = aVar3.BTU.readString();
                    AppMethodBeat.o(56853);
                    return 0;
                case 6:
                    bbc.wFU = aVar3.BTU.readString();
                    AppMethodBeat.o(56853);
                    return 0;
                case 7:
                    bbc.wFV = aVar3.BTU.vd();
                    AppMethodBeat.o(56853);
                    return 0;
                default:
                    AppMethodBeat.o(56853);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56853);
            return -1;
        }
    }
}
