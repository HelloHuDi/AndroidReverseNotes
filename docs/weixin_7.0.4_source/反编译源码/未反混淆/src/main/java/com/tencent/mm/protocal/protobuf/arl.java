package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class arl extends bsr {
    public String cMC;
    public String wvx;
    public int wvy;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89108);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.cMC == null) {
                bVar = new b("Not all required fields were included: card_id");
                AppMethodBeat.o(89108);
                throw bVar;
            } else if (this.wvx == null) {
                bVar = new b("Not all required fields were included: to_username");
                AppMethodBeat.o(89108);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.cMC != null) {
                    aVar.e(2, this.cMC);
                }
                if (this.wvx != null) {
                    aVar.e(3, this.wvx);
                }
                aVar.iz(4, this.wvy);
                AppMethodBeat.o(89108);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.cMC != null) {
                ix += e.a.a.b.b.a.f(2, this.cMC);
            }
            if (this.wvx != null) {
                ix += e.a.a.b.b.a.f(3, this.wvx);
            }
            int bs = ix + e.a.a.b.b.a.bs(4, this.wvy);
            AppMethodBeat.o(89108);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.cMC == null) {
                bVar = new b("Not all required fields were included: card_id");
                AppMethodBeat.o(89108);
                throw bVar;
            } else if (this.wvx == null) {
                bVar = new b("Not all required fields were included: to_username");
                AppMethodBeat.o(89108);
                throw bVar;
            } else {
                AppMethodBeat.o(89108);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            arl arl = (arl) objArr[1];
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
                        arl.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(89108);
                    return 0;
                case 2:
                    arl.cMC = aVar3.BTU.readString();
                    AppMethodBeat.o(89108);
                    return 0;
                case 3:
                    arl.wvx = aVar3.BTU.readString();
                    AppMethodBeat.o(89108);
                    return 0;
                case 4:
                    arl.wvy = aVar3.BTU.vd();
                    AppMethodBeat.o(89108);
                    return 0;
                default:
                    AppMethodBeat.o(89108);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89108);
            return -1;
        }
    }
}
