package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class amm extends bsr {
    public String cuH;
    public String cxb;
    public String mvO;
    public String mvP;
    public String mvQ;
    public String vAN;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28458);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.cuH != null) {
                aVar.e(2, this.cuH);
            }
            if (this.mvO != null) {
                aVar.e(3, this.mvO);
            }
            if (this.mvP != null) {
                aVar.e(4, this.mvP);
            }
            if (this.mvQ != null) {
                aVar.e(5, this.mvQ);
            }
            if (this.cxb != null) {
                aVar.e(6, this.cxb);
            }
            if (this.vAN != null) {
                aVar.e(7, this.vAN);
            }
            AppMethodBeat.o(28458);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.cuH != null) {
                ix += e.a.a.b.b.a.f(2, this.cuH);
            }
            if (this.mvO != null) {
                ix += e.a.a.b.b.a.f(3, this.mvO);
            }
            if (this.mvP != null) {
                ix += e.a.a.b.b.a.f(4, this.mvP);
            }
            if (this.mvQ != null) {
                ix += e.a.a.b.b.a.f(5, this.mvQ);
            }
            if (this.cxb != null) {
                ix += e.a.a.b.b.a.f(6, this.cxb);
            }
            if (this.vAN != null) {
                ix += e.a.a.b.b.a.f(7, this.vAN);
            }
            AppMethodBeat.o(28458);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28458);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            amm amm = (amm) objArr[1];
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
                        amm.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28458);
                    return 0;
                case 2:
                    amm.cuH = aVar3.BTU.readString();
                    AppMethodBeat.o(28458);
                    return 0;
                case 3:
                    amm.mvO = aVar3.BTU.readString();
                    AppMethodBeat.o(28458);
                    return 0;
                case 4:
                    amm.mvP = aVar3.BTU.readString();
                    AppMethodBeat.o(28458);
                    return 0;
                case 5:
                    amm.mvQ = aVar3.BTU.readString();
                    AppMethodBeat.o(28458);
                    return 0;
                case 6:
                    amm.cxb = aVar3.BTU.readString();
                    AppMethodBeat.o(28458);
                    return 0;
                case 7:
                    amm.vAN = aVar3.BTU.readString();
                    AppMethodBeat.o(28458);
                    return 0;
                default:
                    AppMethodBeat.o(28458);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28458);
            return -1;
        }
    }
}
