package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class js extends bsr {
    public String mac;
    public String vMg;
    public String vMh;
    public long vMi;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10160);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.vMg != null) {
                aVar.e(2, this.vMg);
            }
            if (this.vMh != null) {
                aVar.e(3, this.vMh);
            }
            if (this.mac != null) {
                aVar.e(4, this.mac);
            }
            aVar.ai(5, this.vMi);
            AppMethodBeat.o(10160);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vMg != null) {
                ix += e.a.a.b.b.a.f(2, this.vMg);
            }
            if (this.vMh != null) {
                ix += e.a.a.b.b.a.f(3, this.vMh);
            }
            if (this.mac != null) {
                ix += e.a.a.b.b.a.f(4, this.mac);
            }
            int o = ix + e.a.a.b.b.a.o(5, this.vMi);
            AppMethodBeat.o(10160);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(10160);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            js jsVar = (js) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        jsVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(10160);
                    return 0;
                case 2:
                    jsVar.vMg = aVar3.BTU.readString();
                    AppMethodBeat.o(10160);
                    return 0;
                case 3:
                    jsVar.vMh = aVar3.BTU.readString();
                    AppMethodBeat.o(10160);
                    return 0;
                case 4:
                    jsVar.mac = aVar3.BTU.readString();
                    AppMethodBeat.o(10160);
                    return 0;
                case 5:
                    jsVar.vMi = aVar3.BTU.ve();
                    AppMethodBeat.o(10160);
                    return 0;
                default:
                    AppMethodBeat.o(10160);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10160);
            return -1;
        }
    }
}
