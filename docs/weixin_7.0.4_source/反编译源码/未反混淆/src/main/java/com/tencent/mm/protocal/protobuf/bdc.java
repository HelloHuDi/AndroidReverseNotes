package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bdc extends bsr {
    public long cSh;
    public int ehf;
    public String pbn;
    public String pck;
    public String vEQ;
    public String vER;
    public int vES;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56860);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.vES);
            if (this.pbn != null) {
                aVar.e(3, this.pbn);
            }
            if (this.pck != null) {
                aVar.e(4, this.pck);
            }
            if (this.vEQ != null) {
                aVar.e(5, this.vEQ);
            }
            aVar.ai(6, this.cSh);
            aVar.iz(7, this.ehf);
            if (this.vER != null) {
                aVar.e(8, this.vER);
            }
            AppMethodBeat.o(56860);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.vES);
            if (this.pbn != null) {
                ix += e.a.a.b.b.a.f(3, this.pbn);
            }
            if (this.pck != null) {
                ix += e.a.a.b.b.a.f(4, this.pck);
            }
            if (this.vEQ != null) {
                ix += e.a.a.b.b.a.f(5, this.vEQ);
            }
            ix = (ix + e.a.a.b.b.a.o(6, this.cSh)) + e.a.a.b.b.a.bs(7, this.ehf);
            if (this.vER != null) {
                ix += e.a.a.b.b.a.f(8, this.vER);
            }
            AppMethodBeat.o(56860);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56860);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bdc bdc = (bdc) objArr[1];
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
                        bdc.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56860);
                    return 0;
                case 2:
                    bdc.vES = aVar3.BTU.vd();
                    AppMethodBeat.o(56860);
                    return 0;
                case 3:
                    bdc.pbn = aVar3.BTU.readString();
                    AppMethodBeat.o(56860);
                    return 0;
                case 4:
                    bdc.pck = aVar3.BTU.readString();
                    AppMethodBeat.o(56860);
                    return 0;
                case 5:
                    bdc.vEQ = aVar3.BTU.readString();
                    AppMethodBeat.o(56860);
                    return 0;
                case 6:
                    bdc.cSh = aVar3.BTU.ve();
                    AppMethodBeat.o(56860);
                    return 0;
                case 7:
                    bdc.ehf = aVar3.BTU.vd();
                    AppMethodBeat.o(56860);
                    return 0;
                case 8:
                    bdc.vER = aVar3.BTU.readString();
                    AppMethodBeat.o(56860);
                    return 0;
                default:
                    AppMethodBeat.o(56860);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56860);
            return -1;
        }
    }
}
