package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ln extends bsr {
    public String pPZ;
    public String vFb;
    public String vFc;
    public String vFd;
    public int vFg;
    public b vPe;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56716);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.vFb != null) {
                aVar.e(2, this.vFb);
            }
            if (this.vFc != null) {
                aVar.e(3, this.vFc);
            }
            if (this.pPZ != null) {
                aVar.e(4, this.pPZ);
            }
            aVar.iz(5, this.vFg);
            if (this.vPe != null) {
                aVar.c(6, this.vPe);
            }
            if (this.vFd != null) {
                aVar.e(7, this.vFd);
            }
            AppMethodBeat.o(56716);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vFb != null) {
                ix += e.a.a.b.b.a.f(2, this.vFb);
            }
            if (this.vFc != null) {
                ix += e.a.a.b.b.a.f(3, this.vFc);
            }
            if (this.pPZ != null) {
                ix += e.a.a.b.b.a.f(4, this.pPZ);
            }
            ix += e.a.a.b.b.a.bs(5, this.vFg);
            if (this.vPe != null) {
                ix += e.a.a.b.b.a.b(6, this.vPe);
            }
            if (this.vFd != null) {
                ix += e.a.a.b.b.a.f(7, this.vFd);
            }
            AppMethodBeat.o(56716);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56716);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ln lnVar = (ln) objArr[1];
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
                        lnVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56716);
                    return 0;
                case 2:
                    lnVar.vFb = aVar3.BTU.readString();
                    AppMethodBeat.o(56716);
                    return 0;
                case 3:
                    lnVar.vFc = aVar3.BTU.readString();
                    AppMethodBeat.o(56716);
                    return 0;
                case 4:
                    lnVar.pPZ = aVar3.BTU.readString();
                    AppMethodBeat.o(56716);
                    return 0;
                case 5:
                    lnVar.vFg = aVar3.BTU.vd();
                    AppMethodBeat.o(56716);
                    return 0;
                case 6:
                    lnVar.vPe = aVar3.BTU.emu();
                    AppMethodBeat.o(56716);
                    return 0;
                case 7:
                    lnVar.vFd = aVar3.BTU.readString();
                    AppMethodBeat.o(56716);
                    return 0;
                default:
                    AppMethodBeat.o(56716);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56716);
            return -1;
        }
    }
}
