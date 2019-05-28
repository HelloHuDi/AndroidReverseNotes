package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bss extends bsr {
    public int pLQ;
    public String pMd;
    public String pMe;
    public String pbn;
    public String vHu;
    public int vPy;
    public String wKQ;
    public int wUL;
    public String wUM;
    public int wUN;
    public int wUO;
    public b wUP;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48955);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.pMd != null) {
                aVar.e(2, this.pMd);
            }
            if (this.pMe != null) {
                aVar.e(3, this.pMe);
            }
            if (this.pbn != null) {
                aVar.e(4, this.pbn);
            }
            aVar.iz(5, this.pLQ);
            aVar.iz(6, this.wUL);
            if (this.wUM != null) {
                aVar.e(7, this.wUM);
            }
            aVar.iz(8, this.wUN);
            aVar.iz(9, this.wUO);
            if (this.vHu != null) {
                aVar.e(10, this.vHu);
            }
            if (this.wKQ != null) {
                aVar.e(11, this.wKQ);
            }
            if (this.wUP != null) {
                aVar.c(12, this.wUP);
            }
            aVar.iz(13, this.vPy);
            AppMethodBeat.o(48955);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.pMd != null) {
                ix += e.a.a.b.b.a.f(2, this.pMd);
            }
            if (this.pMe != null) {
                ix += e.a.a.b.b.a.f(3, this.pMe);
            }
            if (this.pbn != null) {
                ix += e.a.a.b.b.a.f(4, this.pbn);
            }
            ix = (ix + e.a.a.b.b.a.bs(5, this.pLQ)) + e.a.a.b.b.a.bs(6, this.wUL);
            if (this.wUM != null) {
                ix += e.a.a.b.b.a.f(7, this.wUM);
            }
            ix = (ix + e.a.a.b.b.a.bs(8, this.wUN)) + e.a.a.b.b.a.bs(9, this.wUO);
            if (this.vHu != null) {
                ix += e.a.a.b.b.a.f(10, this.vHu);
            }
            if (this.wKQ != null) {
                ix += e.a.a.b.b.a.f(11, this.wKQ);
            }
            if (this.wUP != null) {
                ix += e.a.a.b.b.a.b(12, this.wUP);
            }
            int bs = ix + e.a.a.b.b.a.bs(13, this.vPy);
            AppMethodBeat.o(48955);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48955);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bss bss = (bss) objArr[1];
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
                        bss.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(48955);
                    return 0;
                case 2:
                    bss.pMd = aVar3.BTU.readString();
                    AppMethodBeat.o(48955);
                    return 0;
                case 3:
                    bss.pMe = aVar3.BTU.readString();
                    AppMethodBeat.o(48955);
                    return 0;
                case 4:
                    bss.pbn = aVar3.BTU.readString();
                    AppMethodBeat.o(48955);
                    return 0;
                case 5:
                    bss.pLQ = aVar3.BTU.vd();
                    AppMethodBeat.o(48955);
                    return 0;
                case 6:
                    bss.wUL = aVar3.BTU.vd();
                    AppMethodBeat.o(48955);
                    return 0;
                case 7:
                    bss.wUM = aVar3.BTU.readString();
                    AppMethodBeat.o(48955);
                    return 0;
                case 8:
                    bss.wUN = aVar3.BTU.vd();
                    AppMethodBeat.o(48955);
                    return 0;
                case 9:
                    bss.wUO = aVar3.BTU.vd();
                    AppMethodBeat.o(48955);
                    return 0;
                case 10:
                    bss.vHu = aVar3.BTU.readString();
                    AppMethodBeat.o(48955);
                    return 0;
                case 11:
                    bss.wKQ = aVar3.BTU.readString();
                    AppMethodBeat.o(48955);
                    return 0;
                case 12:
                    bss.wUP = aVar3.BTU.emu();
                    AppMethodBeat.o(48955);
                    return 0;
                case 13:
                    bss.vPy = aVar3.BTU.vd();
                    AppMethodBeat.o(48955);
                    return 0;
                default:
                    AppMethodBeat.o(48955);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48955);
            return -1;
        }
    }
}
