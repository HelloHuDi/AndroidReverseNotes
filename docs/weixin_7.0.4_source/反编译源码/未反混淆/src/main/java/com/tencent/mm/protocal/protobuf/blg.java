package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class blg extends bsr {
    public String tgu;
    public int wOi;
    public int wOj;
    public ha wOk;
    public int wOl;
    public String wOm;
    public int wao;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56925);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.wOi);
            aVar.iz(3, this.wOj);
            if (this.wOk != null) {
                aVar.iy(4, this.wOk.computeSize());
                this.wOk.writeFields(aVar);
            }
            aVar.iz(5, this.wao);
            aVar.iz(6, this.wOl);
            if (this.wOm != null) {
                aVar.e(7, this.wOm);
            }
            if (this.tgu != null) {
                aVar.e(100, this.tgu);
            }
            AppMethodBeat.o(56925);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.wOi)) + e.a.a.b.b.a.bs(3, this.wOj);
            if (this.wOk != null) {
                ix += e.a.a.a.ix(4, this.wOk.computeSize());
            }
            ix = (ix + e.a.a.b.b.a.bs(5, this.wao)) + e.a.a.b.b.a.bs(6, this.wOl);
            if (this.wOm != null) {
                ix += e.a.a.b.b.a.f(7, this.wOm);
            }
            if (this.tgu != null) {
                ix += e.a.a.b.b.a.f(100, this.tgu);
            }
            AppMethodBeat.o(56925);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56925);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            blg blg = (blg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        blg.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56925);
                    return 0;
                case 2:
                    blg.wOi = aVar3.BTU.vd();
                    AppMethodBeat.o(56925);
                    return 0;
                case 3:
                    blg.wOj = aVar3.BTU.vd();
                    AppMethodBeat.o(56925);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ha haVar = new ha();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = haVar.populateBuilderWithField(aVar4, haVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        blg.wOk = haVar;
                    }
                    AppMethodBeat.o(56925);
                    return 0;
                case 5:
                    blg.wao = aVar3.BTU.vd();
                    AppMethodBeat.o(56925);
                    return 0;
                case 6:
                    blg.wOl = aVar3.BTU.vd();
                    AppMethodBeat.o(56925);
                    return 0;
                case 7:
                    blg.wOm = aVar3.BTU.readString();
                    AppMethodBeat.o(56925);
                    return 0;
                case 100:
                    blg.tgu = aVar3.BTU.readString();
                    AppMethodBeat.o(56925);
                    return 0;
                default:
                    AppMethodBeat.o(56925);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56925);
            return -1;
        }
    }
}
