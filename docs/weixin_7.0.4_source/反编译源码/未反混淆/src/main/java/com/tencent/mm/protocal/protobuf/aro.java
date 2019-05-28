package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class aro extends a {
    public String Desc;
    public String IconUrl;
    public String Title;
    public String wvB;
    public String wvC;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80105);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wvB != null) {
                aVar.e(1, this.wvB);
            }
            if (this.IconUrl != null) {
                aVar.e(2, this.IconUrl);
            }
            if (this.Title != null) {
                aVar.e(3, this.Title);
            }
            if (this.Desc != null) {
                aVar.e(4, this.Desc);
            }
            if (this.wvC != null) {
                aVar.e(5, this.wvC);
            }
            AppMethodBeat.o(80105);
            return 0;
        } else if (i == 1) {
            if (this.wvB != null) {
                f = e.a.a.b.b.a.f(1, this.wvB) + 0;
            } else {
                f = 0;
            }
            if (this.IconUrl != null) {
                f += e.a.a.b.b.a.f(2, this.IconUrl);
            }
            if (this.Title != null) {
                f += e.a.a.b.b.a.f(3, this.Title);
            }
            if (this.Desc != null) {
                f += e.a.a.b.b.a.f(4, this.Desc);
            }
            if (this.wvC != null) {
                f += e.a.a.b.b.a.f(5, this.wvC);
            }
            AppMethodBeat.o(80105);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80105);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aro aro = (aro) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aro.wvB = aVar3.BTU.readString();
                    AppMethodBeat.o(80105);
                    return 0;
                case 2:
                    aro.IconUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(80105);
                    return 0;
                case 3:
                    aro.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(80105);
                    return 0;
                case 4:
                    aro.Desc = aVar3.BTU.readString();
                    AppMethodBeat.o(80105);
                    return 0;
                case 5:
                    aro.wvC = aVar3.BTU.readString();
                    AppMethodBeat.o(80105);
                    return 0;
                default:
                    AppMethodBeat.o(80105);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80105);
            return -1;
        }
    }
}
