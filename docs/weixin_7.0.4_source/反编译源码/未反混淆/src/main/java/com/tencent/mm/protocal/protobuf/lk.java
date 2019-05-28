package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.bt.a;
import com.tencent.mm.storage.ad;
import e.a.a.b;

public final class lk extends a {
    public ad ehM;
    public d pkW;
    public String userName;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14716);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.userName == null) {
                bVar = new b("Not all required fields were included: userName");
                AppMethodBeat.o(14716);
                throw bVar;
            }
            if (this.userName != null) {
                aVar.e(1, this.userName);
            }
            AppMethodBeat.o(14716);
            return 0;
        } else if (i == 1) {
            if (this.userName != null) {
                f = e.a.a.b.b.a.f(1, this.userName) + 0;
            } else {
                f = 0;
            }
            AppMethodBeat.o(14716);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.userName == null) {
                bVar = new b("Not all required fields were included: userName");
                AppMethodBeat.o(14716);
                throw bVar;
            }
            AppMethodBeat.o(14716);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            lk lkVar = (lk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    lkVar.userName = aVar3.BTU.readString();
                    AppMethodBeat.o(14716);
                    return 0;
                default:
                    AppMethodBeat.o(14716);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14716);
            return -1;
        }
    }
}
