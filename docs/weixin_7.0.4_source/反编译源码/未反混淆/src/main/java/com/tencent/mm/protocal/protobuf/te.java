package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class te extends a {
    public String appId;
    public String appName;
    public String version;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124304);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.appId != null) {
                aVar.e(1, this.appId);
            }
            if (this.appName != null) {
                aVar.e(2, this.appName);
            }
            if (this.version != null) {
                aVar.e(3, this.version);
            }
            AppMethodBeat.o(124304);
            return 0;
        } else if (i == 1) {
            if (this.appId != null) {
                f = e.a.a.b.b.a.f(1, this.appId) + 0;
            } else {
                f = 0;
            }
            if (this.appName != null) {
                f += e.a.a.b.b.a.f(2, this.appName);
            }
            if (this.version != null) {
                f += e.a.a.b.b.a.f(3, this.version);
            }
            AppMethodBeat.o(124304);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124304);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            te teVar = (te) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    teVar.appId = aVar3.BTU.readString();
                    AppMethodBeat.o(124304);
                    return 0;
                case 2:
                    teVar.appName = aVar3.BTU.readString();
                    AppMethodBeat.o(124304);
                    return 0;
                case 3:
                    teVar.version = aVar3.BTU.readString();
                    AppMethodBeat.o(124304);
                    return 0;
                default:
                    AppMethodBeat.o(124304);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124304);
            return -1;
        }
    }
}
