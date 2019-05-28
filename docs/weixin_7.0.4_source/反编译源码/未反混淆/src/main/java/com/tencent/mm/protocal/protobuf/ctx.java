package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class ctx extends a {
    public String Title;
    public String ncM;
    public long vIs;
    public String wyw;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28734);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wyw == null) {
                bVar = new b("Not all required fields were included: Talker");
                AppMethodBeat.o(28734);
                throw bVar;
            } else if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(28734);
                throw bVar;
            } else if (this.ncM == null) {
                bVar = new b("Not all required fields were included: Content");
                AppMethodBeat.o(28734);
                throw bVar;
            } else {
                if (this.wyw != null) {
                    aVar.e(1, this.wyw);
                }
                if (this.Title != null) {
                    aVar.e(2, this.Title);
                }
                if (this.ncM != null) {
                    aVar.e(3, this.ncM);
                }
                aVar.ai(4, this.vIs);
                AppMethodBeat.o(28734);
                return 0;
            }
        } else if (i == 1) {
            if (this.wyw != null) {
                f = e.a.a.b.b.a.f(1, this.wyw) + 0;
            } else {
                f = 0;
            }
            if (this.Title != null) {
                f += e.a.a.b.b.a.f(2, this.Title);
            }
            if (this.ncM != null) {
                f += e.a.a.b.b.a.f(3, this.ncM);
            }
            int o = f + e.a.a.b.b.a.o(4, this.vIs);
            AppMethodBeat.o(28734);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.wyw == null) {
                bVar = new b("Not all required fields were included: Talker");
                AppMethodBeat.o(28734);
                throw bVar;
            } else if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(28734);
                throw bVar;
            } else if (this.ncM == null) {
                bVar = new b("Not all required fields were included: Content");
                AppMethodBeat.o(28734);
                throw bVar;
            } else {
                AppMethodBeat.o(28734);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ctx ctx = (ctx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ctx.wyw = aVar3.BTU.readString();
                    AppMethodBeat.o(28734);
                    return 0;
                case 2:
                    ctx.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(28734);
                    return 0;
                case 3:
                    ctx.ncM = aVar3.BTU.readString();
                    AppMethodBeat.o(28734);
                    return 0;
                case 4:
                    ctx.vIs = aVar3.BTU.ve();
                    AppMethodBeat.o(28734);
                    return 0;
                default:
                    AppMethodBeat.o(28734);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28734);
            return -1;
        }
    }
}
