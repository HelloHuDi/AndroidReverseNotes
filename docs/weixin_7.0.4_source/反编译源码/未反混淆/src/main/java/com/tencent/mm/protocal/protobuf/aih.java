package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class aih extends a {
    public String Md5;
    public String wot;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62553);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wot == null) {
                bVar = new b("Not all required fields were included: ActivityId");
                AppMethodBeat.o(62553);
                throw bVar;
            }
            if (this.wot != null) {
                aVar.e(1, this.wot);
            }
            if (this.Md5 != null) {
                aVar.e(2, this.Md5);
            }
            AppMethodBeat.o(62553);
            return 0;
        } else if (i == 1) {
            if (this.wot != null) {
                f = e.a.a.b.b.a.f(1, this.wot) + 0;
            } else {
                f = 0;
            }
            if (this.Md5 != null) {
                f += e.a.a.b.b.a.f(2, this.Md5);
            }
            AppMethodBeat.o(62553);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.wot == null) {
                bVar = new b("Not all required fields were included: ActivityId");
                AppMethodBeat.o(62553);
                throw bVar;
            }
            AppMethodBeat.o(62553);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aih aih = (aih) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aih.wot = aVar3.BTU.readString();
                    AppMethodBeat.o(62553);
                    return 0;
                case 2:
                    aih.Md5 = aVar3.BTU.readString();
                    AppMethodBeat.o(62553);
                    return 0;
                default:
                    AppMethodBeat.o(62553);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62553);
            return -1;
        }
    }
}
