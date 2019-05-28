package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;

public final class cus extends a {
    public int Scene;
    public b vHn;
    public String wyw;
    public long xqQ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28760);
        e.a.a.b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wyw == null) {
                bVar = new e.a.a.b("Not all required fields were included: Talker");
                AppMethodBeat.o(28760);
                throw bVar;
            } else if (this.vHn == null) {
                bVar = new e.a.a.b("Not all required fields were included: VoiceData");
                AppMethodBeat.o(28760);
                throw bVar;
            } else {
                if (this.wyw != null) {
                    aVar.e(1, this.wyw);
                }
                aVar.ai(2, this.xqQ);
                if (this.vHn != null) {
                    aVar.c(3, this.vHn);
                }
                aVar.iz(4, this.Scene);
                AppMethodBeat.o(28760);
                return 0;
            }
        } else if (i == 1) {
            if (this.wyw != null) {
                f = e.a.a.b.b.a.f(1, this.wyw) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.o(2, this.xqQ);
            if (this.vHn != null) {
                f += e.a.a.b.b.a.b(3, this.vHn);
            }
            int bs = f + e.a.a.b.b.a.bs(4, this.Scene);
            AppMethodBeat.o(28760);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.wyw == null) {
                bVar = new e.a.a.b("Not all required fields were included: Talker");
                AppMethodBeat.o(28760);
                throw bVar;
            } else if (this.vHn == null) {
                bVar = new e.a.a.b("Not all required fields were included: VoiceData");
                AppMethodBeat.o(28760);
                throw bVar;
            } else {
                AppMethodBeat.o(28760);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cus cus = (cus) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cus.wyw = aVar3.BTU.readString();
                    AppMethodBeat.o(28760);
                    return 0;
                case 2:
                    cus.xqQ = aVar3.BTU.ve();
                    AppMethodBeat.o(28760);
                    return 0;
                case 3:
                    cus.vHn = aVar3.BTU.emu();
                    AppMethodBeat.o(28760);
                    return 0;
                case 4:
                    cus.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(28760);
                    return 0;
                default:
                    AppMethodBeat.o(28760);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28760);
            return -1;
        }
    }
}
