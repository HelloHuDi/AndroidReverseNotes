package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bmn extends bsr {
    public String tgu;
    public String wOm;
    public String wPv;
    public int wPw;
    public String wPx;
    public int wao;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56936);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wPv != null) {
                aVar.e(2, this.wPv);
            }
            aVar.iz(3, this.wPw);
            aVar.iz(4, this.wao);
            if (this.wPx != null) {
                aVar.e(5, this.wPx);
            }
            if (this.wOm != null) {
                aVar.e(7, this.wOm);
            }
            if (this.tgu != null) {
                aVar.e(100, this.tgu);
            }
            AppMethodBeat.o(56936);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wPv != null) {
                ix += e.a.a.b.b.a.f(2, this.wPv);
            }
            ix = (ix + e.a.a.b.b.a.bs(3, this.wPw)) + e.a.a.b.b.a.bs(4, this.wao);
            if (this.wPx != null) {
                ix += e.a.a.b.b.a.f(5, this.wPx);
            }
            if (this.wOm != null) {
                ix += e.a.a.b.b.a.f(7, this.wOm);
            }
            if (this.tgu != null) {
                ix += e.a.a.b.b.a.f(100, this.tgu);
            }
            AppMethodBeat.o(56936);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56936);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bmn bmn = (bmn) objArr[1];
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
                        bmn.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56936);
                    return 0;
                case 2:
                    bmn.wPv = aVar3.BTU.readString();
                    AppMethodBeat.o(56936);
                    return 0;
                case 3:
                    bmn.wPw = aVar3.BTU.vd();
                    AppMethodBeat.o(56936);
                    return 0;
                case 4:
                    bmn.wao = aVar3.BTU.vd();
                    AppMethodBeat.o(56936);
                    return 0;
                case 5:
                    bmn.wPx = aVar3.BTU.readString();
                    AppMethodBeat.o(56936);
                    return 0;
                case 7:
                    bmn.wOm = aVar3.BTU.readString();
                    AppMethodBeat.o(56936);
                    return 0;
                case 100:
                    bmn.tgu = aVar3.BTU.readString();
                    AppMethodBeat.o(56936);
                    return 0;
                default:
                    AppMethodBeat.o(56936);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56936);
            return -1;
        }
    }
}
