package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class mm extends a {
    public String pdB;
    public String vQq;
    public String vQr;
    public String vQs;
    public int vQt;
    public String vQu;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124299);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vQq == null) {
                bVar = new b("Not all required fields were included: ProductId");
                AppMethodBeat.o(124299);
                throw bVar;
            } else if (this.pdB == null) {
                bVar = new b("Not all required fields were included: ProductName");
                AppMethodBeat.o(124299);
                throw bVar;
            } else if (this.vQr == null) {
                bVar = new b("Not all required fields were included: SellerName");
                AppMethodBeat.o(124299);
                throw bVar;
            } else if (this.vQs == null) {
                bVar = new b("Not all required fields were included: SellerUserName");
                AppMethodBeat.o(124299);
                throw bVar;
            } else {
                if (this.vQq != null) {
                    aVar.e(1, this.vQq);
                }
                if (this.pdB != null) {
                    aVar.e(2, this.pdB);
                }
                if (this.vQr != null) {
                    aVar.e(3, this.vQr);
                }
                if (this.vQs != null) {
                    aVar.e(4, this.vQs);
                }
                aVar.iz(5, this.vQt);
                if (this.vQu != null) {
                    aVar.e(6, this.vQu);
                }
                AppMethodBeat.o(124299);
                return 0;
            }
        } else if (i == 1) {
            if (this.vQq != null) {
                f = e.a.a.b.b.a.f(1, this.vQq) + 0;
            } else {
                f = 0;
            }
            if (this.pdB != null) {
                f += e.a.a.b.b.a.f(2, this.pdB);
            }
            if (this.vQr != null) {
                f += e.a.a.b.b.a.f(3, this.vQr);
            }
            if (this.vQs != null) {
                f += e.a.a.b.b.a.f(4, this.vQs);
            }
            f += e.a.a.b.b.a.bs(5, this.vQt);
            if (this.vQu != null) {
                f += e.a.a.b.b.a.f(6, this.vQu);
            }
            AppMethodBeat.o(124299);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.vQq == null) {
                bVar = new b("Not all required fields were included: ProductId");
                AppMethodBeat.o(124299);
                throw bVar;
            } else if (this.pdB == null) {
                bVar = new b("Not all required fields were included: ProductName");
                AppMethodBeat.o(124299);
                throw bVar;
            } else if (this.vQr == null) {
                bVar = new b("Not all required fields were included: SellerName");
                AppMethodBeat.o(124299);
                throw bVar;
            } else if (this.vQs == null) {
                bVar = new b("Not all required fields were included: SellerUserName");
                AppMethodBeat.o(124299);
                throw bVar;
            } else {
                AppMethodBeat.o(124299);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            mm mmVar = (mm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mmVar.vQq = aVar3.BTU.readString();
                    AppMethodBeat.o(124299);
                    return 0;
                case 2:
                    mmVar.pdB = aVar3.BTU.readString();
                    AppMethodBeat.o(124299);
                    return 0;
                case 3:
                    mmVar.vQr = aVar3.BTU.readString();
                    AppMethodBeat.o(124299);
                    return 0;
                case 4:
                    mmVar.vQs = aVar3.BTU.readString();
                    AppMethodBeat.o(124299);
                    return 0;
                case 5:
                    mmVar.vQt = aVar3.BTU.vd();
                    AppMethodBeat.o(124299);
                    return 0;
                case 6:
                    mmVar.vQu = aVar3.BTU.readString();
                    AppMethodBeat.o(124299);
                    return 0;
                default:
                    AppMethodBeat.o(124299);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124299);
            return -1;
        }
    }
}
