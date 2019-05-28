package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class acy extends a {
    public String mZr;
    public String vEA;
    public int wkB;
    public String wkC;
    public String wkK;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(112425);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.mZr == null) {
                bVar = new b("Not all required fields were included: AppID");
                AppMethodBeat.o(112425);
                throw bVar;
            } else if (this.wkK == null) {
                bVar = new b("Not all required fields were included: RecommendKey");
                AppMethodBeat.o(112425);
                throw bVar;
            } else {
                if (this.mZr != null) {
                    aVar.e(1, this.mZr);
                }
                if (this.wkK != null) {
                    aVar.e(2, this.wkK);
                }
                if (this.vEA != null) {
                    aVar.e(3, this.vEA);
                }
                aVar.iz(4, this.wkB);
                if (this.wkC != null) {
                    aVar.e(5, this.wkC);
                }
                AppMethodBeat.o(112425);
                return 0;
            }
        } else if (i == 1) {
            if (this.mZr != null) {
                f = e.a.a.b.b.a.f(1, this.mZr) + 0;
            } else {
                f = 0;
            }
            if (this.wkK != null) {
                f += e.a.a.b.b.a.f(2, this.wkK);
            }
            if (this.vEA != null) {
                f += e.a.a.b.b.a.f(3, this.vEA);
            }
            f += e.a.a.b.b.a.bs(4, this.wkB);
            if (this.wkC != null) {
                f += e.a.a.b.b.a.f(5, this.wkC);
            }
            AppMethodBeat.o(112425);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.mZr == null) {
                bVar = new b("Not all required fields were included: AppID");
                AppMethodBeat.o(112425);
                throw bVar;
            } else if (this.wkK == null) {
                bVar = new b("Not all required fields were included: RecommendKey");
                AppMethodBeat.o(112425);
                throw bVar;
            } else {
                AppMethodBeat.o(112425);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            acy acy = (acy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    acy.mZr = aVar3.BTU.readString();
                    AppMethodBeat.o(112425);
                    return 0;
                case 2:
                    acy.wkK = aVar3.BTU.readString();
                    AppMethodBeat.o(112425);
                    return 0;
                case 3:
                    acy.vEA = aVar3.BTU.readString();
                    AppMethodBeat.o(112425);
                    return 0;
                case 4:
                    acy.wkB = aVar3.BTU.vd();
                    AppMethodBeat.o(112425);
                    return 0;
                case 5:
                    acy.wkC = aVar3.BTU.readString();
                    AppMethodBeat.o(112425);
                    return 0;
                default:
                    AppMethodBeat.o(112425);
                    return -1;
            }
        } else {
            AppMethodBeat.o(112425);
            return -1;
        }
    }
}
