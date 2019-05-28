package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class ctz extends a {
    public String jCH;
    public String wyw;
    public long xqz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28737);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wyw == null) {
                bVar = new b("Not all required fields were included: Talker");
                AppMethodBeat.o(28737);
                throw bVar;
            } else if (this.jCH == null) {
                bVar = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(28737);
                throw bVar;
            } else {
                if (this.wyw != null) {
                    aVar.e(1, this.wyw);
                }
                if (this.jCH != null) {
                    aVar.e(2, this.jCH);
                }
                aVar.ai(3, this.xqz);
                AppMethodBeat.o(28737);
                return 0;
            }
        } else if (i == 1) {
            if (this.wyw != null) {
                f = e.a.a.b.b.a.f(1, this.wyw) + 0;
            } else {
                f = 0;
            }
            if (this.jCH != null) {
                f += e.a.a.b.b.a.f(2, this.jCH);
            }
            int o = f + e.a.a.b.b.a.o(3, this.xqz);
            AppMethodBeat.o(28737);
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
                AppMethodBeat.o(28737);
                throw bVar;
            } else if (this.jCH == null) {
                bVar = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(28737);
                throw bVar;
            } else {
                AppMethodBeat.o(28737);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ctz ctz = (ctz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ctz.wyw = aVar3.BTU.readString();
                    AppMethodBeat.o(28737);
                    return 0;
                case 2:
                    ctz.jCH = aVar3.BTU.readString();
                    AppMethodBeat.o(28737);
                    return 0;
                case 3:
                    ctz.xqz = aVar3.BTU.ve();
                    AppMethodBeat.o(28737);
                    return 0;
                default:
                    AppMethodBeat.o(28737);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28737);
            return -1;
        }
    }
}
