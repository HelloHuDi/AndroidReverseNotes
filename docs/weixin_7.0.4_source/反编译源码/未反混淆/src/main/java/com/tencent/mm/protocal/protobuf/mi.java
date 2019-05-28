package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class mi extends a {
    public String IconUrl;
    public String vQh;
    public String vQi;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124296);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.IconUrl == null) {
                bVar = new b("Not all required fields were included: IconUrl");
                AppMethodBeat.o(124296);
                throw bVar;
            }
            if (this.IconUrl != null) {
                aVar.e(1, this.IconUrl);
            }
            if (this.vQh != null) {
                aVar.e(2, this.vQh);
            }
            if (this.vQi != null) {
                aVar.e(3, this.vQi);
            }
            AppMethodBeat.o(124296);
            return 0;
        } else if (i == 1) {
            if (this.IconUrl != null) {
                f = e.a.a.b.b.a.f(1, this.IconUrl) + 0;
            } else {
                f = 0;
            }
            if (this.vQh != null) {
                f += e.a.a.b.b.a.f(2, this.vQh);
            }
            if (this.vQi != null) {
                f += e.a.a.b.b.a.f(3, this.vQi);
            }
            AppMethodBeat.o(124296);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.IconUrl == null) {
                bVar = new b("Not all required fields were included: IconUrl");
                AppMethodBeat.o(124296);
                throw bVar;
            }
            AppMethodBeat.o(124296);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            mi miVar = (mi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    miVar.IconUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(124296);
                    return 0;
                case 2:
                    miVar.vQh = aVar3.BTU.readString();
                    AppMethodBeat.o(124296);
                    return 0;
                case 3:
                    miVar.vQi = aVar3.BTU.readString();
                    AppMethodBeat.o(124296);
                    return 0;
                default:
                    AppMethodBeat.o(124296);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124296);
            return -1;
        }
    }
}
