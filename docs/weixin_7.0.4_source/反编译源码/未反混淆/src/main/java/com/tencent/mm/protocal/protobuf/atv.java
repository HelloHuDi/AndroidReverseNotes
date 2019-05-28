package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class atv extends a {
    public String Title;
    public String Url;
    public String ncH;
    public String wxR;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28528);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Url != null) {
                aVar.e(1, this.Url);
            }
            if (this.Title != null) {
                aVar.e(2, this.Title);
            }
            if (this.wxR != null) {
                aVar.e(3, this.wxR);
            }
            if (this.ncH != null) {
                aVar.e(4, this.ncH);
            }
            AppMethodBeat.o(28528);
            return 0;
        } else if (i == 1) {
            if (this.Url != null) {
                f = e.a.a.b.b.a.f(1, this.Url) + 0;
            } else {
                f = 0;
            }
            if (this.Title != null) {
                f += e.a.a.b.b.a.f(2, this.Title);
            }
            if (this.wxR != null) {
                f += e.a.a.b.b.a.f(3, this.wxR);
            }
            if (this.ncH != null) {
                f += e.a.a.b.b.a.f(4, this.ncH);
            }
            AppMethodBeat.o(28528);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28528);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            atv atv = (atv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    atv.Url = aVar3.BTU.readString();
                    AppMethodBeat.o(28528);
                    return 0;
                case 2:
                    atv.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(28528);
                    return 0;
                case 3:
                    atv.wxR = aVar3.BTU.readString();
                    AppMethodBeat.o(28528);
                    return 0;
                case 4:
                    atv.ncH = aVar3.BTU.readString();
                    AppMethodBeat.o(28528);
                    return 0;
                default:
                    AppMethodBeat.o(28528);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28528);
            return -1;
        }
    }
}
