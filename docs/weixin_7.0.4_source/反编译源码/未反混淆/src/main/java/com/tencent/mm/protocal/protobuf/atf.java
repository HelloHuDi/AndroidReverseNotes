package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class atf extends a {
    public String pLH;
    public int state;
    public String title;
    public String vPX;
    public String wxf;
    public long wxg;
    public String wxh;
    public String wxi;
    public String wxj;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48866);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vPX != null) {
                aVar.e(1, this.vPX);
            }
            aVar.iz(2, this.state);
            if (this.title != null) {
                aVar.e(3, this.title);
            }
            if (this.wxf != null) {
                aVar.e(4, this.wxf);
            }
            aVar.ai(5, this.wxg);
            if (this.wxh != null) {
                aVar.e(6, this.wxh);
            }
            if (this.pLH != null) {
                aVar.e(7, this.pLH);
            }
            if (this.wxi != null) {
                aVar.e(8, this.wxi);
            }
            if (this.wxj != null) {
                aVar.e(9, this.wxj);
            }
            AppMethodBeat.o(48866);
            return 0;
        } else if (i == 1) {
            if (this.vPX != null) {
                f = e.a.a.b.b.a.f(1, this.vPX) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.state);
            if (this.title != null) {
                f += e.a.a.b.b.a.f(3, this.title);
            }
            if (this.wxf != null) {
                f += e.a.a.b.b.a.f(4, this.wxf);
            }
            f += e.a.a.b.b.a.o(5, this.wxg);
            if (this.wxh != null) {
                f += e.a.a.b.b.a.f(6, this.wxh);
            }
            if (this.pLH != null) {
                f += e.a.a.b.b.a.f(7, this.pLH);
            }
            if (this.wxi != null) {
                f += e.a.a.b.b.a.f(8, this.wxi);
            }
            if (this.wxj != null) {
                f += e.a.a.b.b.a.f(9, this.wxj);
            }
            AppMethodBeat.o(48866);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48866);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            atf atf = (atf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    atf.vPX = aVar3.BTU.readString();
                    AppMethodBeat.o(48866);
                    return 0;
                case 2:
                    atf.state = aVar3.BTU.vd();
                    AppMethodBeat.o(48866);
                    return 0;
                case 3:
                    atf.title = aVar3.BTU.readString();
                    AppMethodBeat.o(48866);
                    return 0;
                case 4:
                    atf.wxf = aVar3.BTU.readString();
                    AppMethodBeat.o(48866);
                    return 0;
                case 5:
                    atf.wxg = aVar3.BTU.ve();
                    AppMethodBeat.o(48866);
                    return 0;
                case 6:
                    atf.wxh = aVar3.BTU.readString();
                    AppMethodBeat.o(48866);
                    return 0;
                case 7:
                    atf.pLH = aVar3.BTU.readString();
                    AppMethodBeat.o(48866);
                    return 0;
                case 8:
                    atf.wxi = aVar3.BTU.readString();
                    AppMethodBeat.o(48866);
                    return 0;
                case 9:
                    atf.wxj = aVar3.BTU.readString();
                    AppMethodBeat.o(48866);
                    return 0;
                default:
                    AppMethodBeat.o(48866);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48866);
            return -1;
        }
    }
}
