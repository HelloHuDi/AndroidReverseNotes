package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class fm extends a {
    public String cxb;
    public String fLi;
    public String geY;
    public LinkedList<String> vHv = new LinkedList();
    public long vHw;

    public fm() {
        AppMethodBeat.i(118265);
        AppMethodBeat.o(118265);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(118266);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.geY == null) {
                bVar = new b("Not all required fields were included: roomname");
                AppMethodBeat.o(118266);
                throw bVar;
            }
            if (this.geY != null) {
                aVar.e(1, this.geY);
            }
            if (this.cxb != null) {
                aVar.e(2, this.cxb);
            }
            if (this.fLi != null) {
                aVar.e(3, this.fLi);
            }
            aVar.e(4, 1, this.vHv);
            aVar.ai(5, this.vHw);
            AppMethodBeat.o(118266);
            return 0;
        } else if (i == 1) {
            if (this.geY != null) {
                f = e.a.a.b.b.a.f(1, this.geY) + 0;
            } else {
                f = 0;
            }
            if (this.cxb != null) {
                f += e.a.a.b.b.a.f(2, this.cxb);
            }
            if (this.fLi != null) {
                f += e.a.a.b.b.a.f(3, this.fLi);
            }
            int c = (f + e.a.a.a.c(4, 1, this.vHv)) + e.a.a.b.b.a.o(5, this.vHw);
            AppMethodBeat.o(118266);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.vHv.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.geY == null) {
                bVar = new b("Not all required fields were included: roomname");
                AppMethodBeat.o(118266);
                throw bVar;
            }
            AppMethodBeat.o(118266);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            fm fmVar = (fm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fmVar.geY = aVar3.BTU.readString();
                    AppMethodBeat.o(118266);
                    return 0;
                case 2:
                    fmVar.cxb = aVar3.BTU.readString();
                    AppMethodBeat.o(118266);
                    return 0;
                case 3:
                    fmVar.fLi = aVar3.BTU.readString();
                    AppMethodBeat.o(118266);
                    return 0;
                case 4:
                    fmVar.vHv.add(aVar3.BTU.readString());
                    AppMethodBeat.o(118266);
                    return 0;
                case 5:
                    fmVar.vHw = aVar3.BTU.ve();
                    AppMethodBeat.o(118266);
                    return 0;
                default:
                    AppMethodBeat.o(118266);
                    return -1;
            }
        } else {
            AppMethodBeat.o(118266);
            return -1;
        }
    }
}
