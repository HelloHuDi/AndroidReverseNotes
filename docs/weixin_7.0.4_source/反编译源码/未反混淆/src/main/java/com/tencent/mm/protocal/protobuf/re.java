package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class re extends bsr {
    public String vYm;
    public String vYn;
    public String vYo;
    public String vYp;
    public String vYq;
    public long vYr;
    public String vYs;
    public String vYt;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28357);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.vYm != null) {
                aVar.e(2, this.vYm);
            }
            if (this.vYn != null) {
                aVar.e(3, this.vYn);
            }
            if (this.vYo != null) {
                aVar.e(4, this.vYo);
            }
            if (this.vYp != null) {
                aVar.e(5, this.vYp);
            }
            if (this.vYq != null) {
                aVar.e(6, this.vYq);
            }
            aVar.ai(7, this.vYr);
            if (this.vYs != null) {
                aVar.e(8, this.vYs);
            }
            if (this.vYt != null) {
                aVar.e(9, this.vYt);
            }
            AppMethodBeat.o(28357);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vYm != null) {
                ix += e.a.a.b.b.a.f(2, this.vYm);
            }
            if (this.vYn != null) {
                ix += e.a.a.b.b.a.f(3, this.vYn);
            }
            if (this.vYo != null) {
                ix += e.a.a.b.b.a.f(4, this.vYo);
            }
            if (this.vYp != null) {
                ix += e.a.a.b.b.a.f(5, this.vYp);
            }
            if (this.vYq != null) {
                ix += e.a.a.b.b.a.f(6, this.vYq);
            }
            ix += e.a.a.b.b.a.o(7, this.vYr);
            if (this.vYs != null) {
                ix += e.a.a.b.b.a.f(8, this.vYs);
            }
            if (this.vYt != null) {
                ix += e.a.a.b.b.a.f(9, this.vYt);
            }
            AppMethodBeat.o(28357);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28357);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            re reVar = (re) objArr[1];
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
                        reVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28357);
                    return 0;
                case 2:
                    reVar.vYm = aVar3.BTU.readString();
                    AppMethodBeat.o(28357);
                    return 0;
                case 3:
                    reVar.vYn = aVar3.BTU.readString();
                    AppMethodBeat.o(28357);
                    return 0;
                case 4:
                    reVar.vYo = aVar3.BTU.readString();
                    AppMethodBeat.o(28357);
                    return 0;
                case 5:
                    reVar.vYp = aVar3.BTU.readString();
                    AppMethodBeat.o(28357);
                    return 0;
                case 6:
                    reVar.vYq = aVar3.BTU.readString();
                    AppMethodBeat.o(28357);
                    return 0;
                case 7:
                    reVar.vYr = aVar3.BTU.ve();
                    AppMethodBeat.o(28357);
                    return 0;
                case 8:
                    reVar.vYs = aVar3.BTU.readString();
                    AppMethodBeat.o(28357);
                    return 0;
                case 9:
                    reVar.vYt = aVar3.BTU.readString();
                    AppMethodBeat.o(28357);
                    return 0;
                default:
                    AppMethodBeat.o(28357);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28357);
            return -1;
        }
    }
}
