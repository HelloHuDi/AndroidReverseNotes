package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class atu extends a {
    public String Title;
    public String Url;
    public int jCt;
    public String ncH;
    public String vYK;
    public String wxR;
    public String wxS;
    public String wxT;
    public String wxU;
    public int wxV;
    public String wxW;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28527);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            if (this.wxR != null) {
                aVar.e(2, this.wxR);
            }
            aVar.iz(3, this.jCt);
            if (this.Url != null) {
                aVar.e(4, this.Url);
            }
            if (this.wxS != null) {
                aVar.e(5, this.wxS);
            }
            if (this.vYK != null) {
                aVar.e(6, this.vYK);
            }
            if (this.wxT != null) {
                aVar.e(7, this.wxT);
            }
            if (this.ncH != null) {
                aVar.e(8, this.ncH);
            }
            if (this.wxU != null) {
                aVar.e(9, this.wxU);
            }
            aVar.iz(10, this.wxV);
            if (this.wxW != null) {
                aVar.e(11, this.wxW);
            }
            AppMethodBeat.o(28527);
            return 0;
        } else if (i == 1) {
            if (this.Title != null) {
                f = e.a.a.b.b.a.f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            if (this.wxR != null) {
                f += e.a.a.b.b.a.f(2, this.wxR);
            }
            f += e.a.a.b.b.a.bs(3, this.jCt);
            if (this.Url != null) {
                f += e.a.a.b.b.a.f(4, this.Url);
            }
            if (this.wxS != null) {
                f += e.a.a.b.b.a.f(5, this.wxS);
            }
            if (this.vYK != null) {
                f += e.a.a.b.b.a.f(6, this.vYK);
            }
            if (this.wxT != null) {
                f += e.a.a.b.b.a.f(7, this.wxT);
            }
            if (this.ncH != null) {
                f += e.a.a.b.b.a.f(8, this.ncH);
            }
            if (this.wxU != null) {
                f += e.a.a.b.b.a.f(9, this.wxU);
            }
            f += e.a.a.b.b.a.bs(10, this.wxV);
            if (this.wxW != null) {
                f += e.a.a.b.b.a.f(11, this.wxW);
            }
            AppMethodBeat.o(28527);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28527);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            atu atu = (atu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    atu.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(28527);
                    return 0;
                case 2:
                    atu.wxR = aVar3.BTU.readString();
                    AppMethodBeat.o(28527);
                    return 0;
                case 3:
                    atu.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(28527);
                    return 0;
                case 4:
                    atu.Url = aVar3.BTU.readString();
                    AppMethodBeat.o(28527);
                    return 0;
                case 5:
                    atu.wxS = aVar3.BTU.readString();
                    AppMethodBeat.o(28527);
                    return 0;
                case 6:
                    atu.vYK = aVar3.BTU.readString();
                    AppMethodBeat.o(28527);
                    return 0;
                case 7:
                    atu.wxT = aVar3.BTU.readString();
                    AppMethodBeat.o(28527);
                    return 0;
                case 8:
                    atu.ncH = aVar3.BTU.readString();
                    AppMethodBeat.o(28527);
                    return 0;
                case 9:
                    atu.wxU = aVar3.BTU.readString();
                    AppMethodBeat.o(28527);
                    return 0;
                case 10:
                    atu.wxV = aVar3.BTU.vd();
                    AppMethodBeat.o(28527);
                    return 0;
                case 11:
                    atu.wxW = aVar3.BTU.readString();
                    AppMethodBeat.o(28527);
                    return 0;
                default:
                    AppMethodBeat.o(28527);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28527);
            return -1;
        }
    }
}
