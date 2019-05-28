package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class aap extends a {
    public String appId;
    public int cBc;
    public String csu;
    public String iconUrl;
    public int type;
    public String username;
    public String wfO;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51388);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            if (this.appId != null) {
                aVar.e(2, this.appId);
            }
            aVar.iz(3, this.cBc);
            if (this.iconUrl != null) {
                aVar.e(4, this.iconUrl);
            }
            aVar.iz(5, this.type);
            if (this.csu != null) {
                aVar.e(6, this.csu);
            }
            if (this.wfO != null) {
                aVar.e(7, this.wfO);
            }
            AppMethodBeat.o(51388);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                f = e.a.a.b.b.a.f(1, this.username) + 0;
            } else {
                f = 0;
            }
            if (this.appId != null) {
                f += e.a.a.b.b.a.f(2, this.appId);
            }
            f += e.a.a.b.b.a.bs(3, this.cBc);
            if (this.iconUrl != null) {
                f += e.a.a.b.b.a.f(4, this.iconUrl);
            }
            f += e.a.a.b.b.a.bs(5, this.type);
            if (this.csu != null) {
                f += e.a.a.b.b.a.f(6, this.csu);
            }
            if (this.wfO != null) {
                f += e.a.a.b.b.a.f(7, this.wfO);
            }
            AppMethodBeat.o(51388);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(51388);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aap aap = (aap) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aap.username = aVar3.BTU.readString();
                    AppMethodBeat.o(51388);
                    return 0;
                case 2:
                    aap.appId = aVar3.BTU.readString();
                    AppMethodBeat.o(51388);
                    return 0;
                case 3:
                    aap.cBc = aVar3.BTU.vd();
                    AppMethodBeat.o(51388);
                    return 0;
                case 4:
                    aap.iconUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(51388);
                    return 0;
                case 5:
                    aap.type = aVar3.BTU.vd();
                    AppMethodBeat.o(51388);
                    return 0;
                case 6:
                    aap.csu = aVar3.BTU.readString();
                    AppMethodBeat.o(51388);
                    return 0;
                case 7:
                    aap.wfO = aVar3.BTU.readString();
                    AppMethodBeat.o(51388);
                    return 0;
                default:
                    AppMethodBeat.o(51388);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51388);
            return -1;
        }
    }
}
