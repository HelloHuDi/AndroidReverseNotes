package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class cuq extends a {
    public int Scene;
    public String vQq;
    public String wdK;
    public String wdO;
    public String wyw;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28758);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wyw == null) {
                bVar = new b("Not all required fields were included: Talker");
                AppMethodBeat.o(28758);
                throw bVar;
            } else if (this.wdK == null) {
                bVar = new b("Not all required fields were included: Text");
                AppMethodBeat.o(28758);
                throw bVar;
            } else if (this.wdO == null) {
                bVar = new b("Not all required fields were included: MD5");
                AppMethodBeat.o(28758);
                throw bVar;
            } else if (this.vQq == null) {
                bVar = new b("Not all required fields were included: ProductId");
                AppMethodBeat.o(28758);
                throw bVar;
            } else {
                if (this.wyw != null) {
                    aVar.e(1, this.wyw);
                }
                if (this.wdK != null) {
                    aVar.e(2, this.wdK);
                }
                if (this.wdO != null) {
                    aVar.e(3, this.wdO);
                }
                if (this.vQq != null) {
                    aVar.e(4, this.vQq);
                }
                aVar.iz(5, this.Scene);
                AppMethodBeat.o(28758);
                return 0;
            }
        } else if (i == 1) {
            if (this.wyw != null) {
                f = e.a.a.b.b.a.f(1, this.wyw) + 0;
            } else {
                f = 0;
            }
            if (this.wdK != null) {
                f += e.a.a.b.b.a.f(2, this.wdK);
            }
            if (this.wdO != null) {
                f += e.a.a.b.b.a.f(3, this.wdO);
            }
            if (this.vQq != null) {
                f += e.a.a.b.b.a.f(4, this.vQq);
            }
            int bs = f + e.a.a.b.b.a.bs(5, this.Scene);
            AppMethodBeat.o(28758);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.wyw == null) {
                bVar = new b("Not all required fields were included: Talker");
                AppMethodBeat.o(28758);
                throw bVar;
            } else if (this.wdK == null) {
                bVar = new b("Not all required fields were included: Text");
                AppMethodBeat.o(28758);
                throw bVar;
            } else if (this.wdO == null) {
                bVar = new b("Not all required fields were included: MD5");
                AppMethodBeat.o(28758);
                throw bVar;
            } else if (this.vQq == null) {
                bVar = new b("Not all required fields were included: ProductId");
                AppMethodBeat.o(28758);
                throw bVar;
            } else {
                AppMethodBeat.o(28758);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cuq cuq = (cuq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cuq.wyw = aVar3.BTU.readString();
                    AppMethodBeat.o(28758);
                    return 0;
                case 2:
                    cuq.wdK = aVar3.BTU.readString();
                    AppMethodBeat.o(28758);
                    return 0;
                case 3:
                    cuq.wdO = aVar3.BTU.readString();
                    AppMethodBeat.o(28758);
                    return 0;
                case 4:
                    cuq.vQq = aVar3.BTU.readString();
                    AppMethodBeat.o(28758);
                    return 0;
                case 5:
                    cuq.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(28758);
                    return 0;
                default:
                    AppMethodBeat.o(28758);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28758);
            return -1;
        }
    }
}
