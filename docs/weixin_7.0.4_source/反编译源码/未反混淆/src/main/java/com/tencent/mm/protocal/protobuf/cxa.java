package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;
import java.util.LinkedList;

public final class cxa extends a {
    public b vMS;
    public LinkedList<cwx> vMT = new LinkedList();
    public String xfb;

    public cxa() {
        AppMethodBeat.i(96338);
        AppMethodBeat.o(96338);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96339);
        e.a.a.b bVar;
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xfb == null) {
                bVar = new e.a.a.b("Not all required fields were included: WxaUserName");
                AppMethodBeat.o(96339);
                throw bVar;
            }
            if (this.xfb != null) {
                aVar.e(1, this.xfb);
            }
            if (this.vMS != null) {
                aVar.c(2, this.vMS);
            }
            aVar.e(3, 8, this.vMT);
            AppMethodBeat.o(96339);
            return 0;
        } else if (i == 1) {
            if (this.xfb != null) {
                f = e.a.a.b.b.a.f(1, this.xfb) + 0;
            } else {
                f = 0;
            }
            if (this.vMS != null) {
                f += e.a.a.b.b.a.b(2, this.vMS);
            }
            int c = f + e.a.a.a.c(3, 8, this.vMT);
            AppMethodBeat.o(96339);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vMT.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.xfb == null) {
                bVar = new e.a.a.b("Not all required fields were included: WxaUserName");
                AppMethodBeat.o(96339);
                throw bVar;
            }
            AppMethodBeat.o(96339);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cxa cxa = (cxa) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cxa.xfb = aVar3.BTU.readString();
                    AppMethodBeat.o(96339);
                    return 0;
                case 2:
                    cxa.vMS = aVar3.BTU.emu();
                    AppMethodBeat.o(96339);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cwx cwx = new cwx();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cwx.populateBuilderWithField(aVar4, cwx, a.getNextFieldNumber(aVar4))) {
                        }
                        cxa.vMT.add(cwx);
                    }
                    AppMethodBeat.o(96339);
                    return 0;
                default:
                    AppMethodBeat.o(96339);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96339);
            return -1;
        }
    }
}
