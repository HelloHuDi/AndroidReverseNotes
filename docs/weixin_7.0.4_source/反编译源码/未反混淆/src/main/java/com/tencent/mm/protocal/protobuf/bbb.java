package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class bbb extends a {
    public String ThumbUrl;
    public String Title;
    public int wFQ;
    public int wFR;
    public int wkB;
    public String wkC;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(54952);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(54952);
                throw bVar;
            } else if (this.ThumbUrl == null) {
                bVar = new b("Not all required fields were included: ThumbUrl");
                AppMethodBeat.o(54952);
                throw bVar;
            } else {
                aVar.iz(1, this.wFQ);
                if (this.Title != null) {
                    aVar.e(2, this.Title);
                }
                if (this.ThumbUrl != null) {
                    aVar.e(3, this.ThumbUrl);
                }
                aVar.iz(4, this.wkB);
                if (this.wkC != null) {
                    aVar.e(5, this.wkC);
                }
                aVar.iz(6, this.wFR);
                AppMethodBeat.o(54952);
                return 0;
            }
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.wFQ) + 0;
            if (this.Title != null) {
                bs += e.a.a.b.b.a.f(2, this.Title);
            }
            if (this.ThumbUrl != null) {
                bs += e.a.a.b.b.a.f(3, this.ThumbUrl);
            }
            bs += e.a.a.b.b.a.bs(4, this.wkB);
            if (this.wkC != null) {
                bs += e.a.a.b.b.a.f(5, this.wkC);
            }
            bs += e.a.a.b.b.a.bs(6, this.wFR);
            AppMethodBeat.o(54952);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(54952);
                throw bVar;
            } else if (this.ThumbUrl == null) {
                bVar = new b("Not all required fields were included: ThumbUrl");
                AppMethodBeat.o(54952);
                throw bVar;
            } else {
                AppMethodBeat.o(54952);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bbb bbb = (bbb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bbb.wFQ = aVar3.BTU.vd();
                    AppMethodBeat.o(54952);
                    return 0;
                case 2:
                    bbb.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(54952);
                    return 0;
                case 3:
                    bbb.ThumbUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(54952);
                    return 0;
                case 4:
                    bbb.wkB = aVar3.BTU.vd();
                    AppMethodBeat.o(54952);
                    return 0;
                case 5:
                    bbb.wkC = aVar3.BTU.readString();
                    AppMethodBeat.o(54952);
                    return 0;
                case 6:
                    bbb.wFR = aVar3.BTU.vd();
                    AppMethodBeat.o(54952);
                    return 0;
                default:
                    AppMethodBeat.o(54952);
                    return -1;
            }
        } else {
            AppMethodBeat.o(54952);
            return -1;
        }
    }
}
