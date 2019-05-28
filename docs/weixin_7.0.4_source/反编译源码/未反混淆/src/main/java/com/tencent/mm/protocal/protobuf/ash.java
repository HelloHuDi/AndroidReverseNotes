package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ash extends a {
    public String nSa;
    public String nickname;
    public String username;
    public long wvQ;
    public long wvR;
    public int wvS;
    public String wvT;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56842);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.wvQ);
            aVar.ai(2, this.wvR);
            if (this.nickname != null) {
                aVar.e(3, this.nickname);
            }
            if (this.nSa != null) {
                aVar.e(4, this.nSa);
            }
            aVar.iz(5, this.wvS);
            if (this.username != null) {
                aVar.e(6, this.username);
            }
            if (this.wvT != null) {
                aVar.e(7, this.wvT);
            }
            AppMethodBeat.o(56842);
            return 0;
        } else if (i == 1) {
            o = (e.a.a.b.b.a.o(1, this.wvQ) + 0) + e.a.a.b.b.a.o(2, this.wvR);
            if (this.nickname != null) {
                o += e.a.a.b.b.a.f(3, this.nickname);
            }
            if (this.nSa != null) {
                o += e.a.a.b.b.a.f(4, this.nSa);
            }
            o += e.a.a.b.b.a.bs(5, this.wvS);
            if (this.username != null) {
                o += e.a.a.b.b.a.f(6, this.username);
            }
            if (this.wvT != null) {
                o += e.a.a.b.b.a.f(7, this.wvT);
            }
            AppMethodBeat.o(56842);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56842);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ash ash = (ash) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ash.wvQ = aVar3.BTU.ve();
                    AppMethodBeat.o(56842);
                    return 0;
                case 2:
                    ash.wvR = aVar3.BTU.ve();
                    AppMethodBeat.o(56842);
                    return 0;
                case 3:
                    ash.nickname = aVar3.BTU.readString();
                    AppMethodBeat.o(56842);
                    return 0;
                case 4:
                    ash.nSa = aVar3.BTU.readString();
                    AppMethodBeat.o(56842);
                    return 0;
                case 5:
                    ash.wvS = aVar3.BTU.vd();
                    AppMethodBeat.o(56842);
                    return 0;
                case 6:
                    ash.username = aVar3.BTU.readString();
                    AppMethodBeat.o(56842);
                    return 0;
                case 7:
                    ash.wvT = aVar3.BTU.readString();
                    AppMethodBeat.o(56842);
                    return 0;
                default:
                    AppMethodBeat.o(56842);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56842);
            return -1;
        }
    }
}
