package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cau extends bsr {
    public String ptv;
    public cao wZr;
    public bts wZs;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94571);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wZr == null) {
                bVar = new b("Not all required fields were included: Action");
                AppMethodBeat.o(94571);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wZr != null) {
                aVar.iy(2, this.wZr.computeSize());
                this.wZr.writeFields(aVar);
            }
            if (this.ptv != null) {
                aVar.e(3, this.ptv);
            }
            if (this.wZs != null) {
                aVar.iy(4, this.wZs.computeSize());
                this.wZs.writeFields(aVar);
            }
            AppMethodBeat.o(94571);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wZr != null) {
                ix += e.a.a.a.ix(2, this.wZr.computeSize());
            }
            if (this.ptv != null) {
                ix += e.a.a.b.b.a.f(3, this.ptv);
            }
            if (this.wZs != null) {
                ix += e.a.a.a.ix(4, this.wZs.computeSize());
            }
            AppMethodBeat.o(94571);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wZr == null) {
                bVar = new b("Not all required fields were included: Action");
                AppMethodBeat.o(94571);
                throw bVar;
            }
            AppMethodBeat.o(94571);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cau cau = (cau) objArr[1];
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
                        cau.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(94571);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cao cao = new cao();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cao.populateBuilderWithField(aVar4, cao, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cau.wZr = cao;
                    }
                    AppMethodBeat.o(94571);
                    return 0;
                case 3:
                    cau.ptv = aVar3.BTU.readString();
                    AppMethodBeat.o(94571);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cau.wZs = bts;
                    }
                    AppMethodBeat.o(94571);
                    return 0;
                default:
                    AppMethodBeat.o(94571);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94571);
            return -1;
        }
    }
}
