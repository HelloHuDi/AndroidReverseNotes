package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class caf extends bsr {
    public int Scene;
    public String ptv;
    public int vFH;
    public bts wZq;
    public cao wZr;
    public bts wZs;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94555);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wZr == null) {
                bVar = new b("Not all required fields were included: Action");
                AppMethodBeat.o(94555);
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
            if (this.wZq != null) {
                aVar.iy(4, this.wZq.computeSize());
                this.wZq.writeFields(aVar);
            }
            aVar.iz(5, this.vFH);
            if (this.wZs != null) {
                aVar.iy(6, this.wZs.computeSize());
                this.wZs.writeFields(aVar);
            }
            aVar.iz(7, this.Scene);
            AppMethodBeat.o(94555);
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
            if (this.wZq != null) {
                ix += e.a.a.a.ix(4, this.wZq.computeSize());
            }
            ix += e.a.a.b.b.a.bs(5, this.vFH);
            if (this.wZs != null) {
                ix += e.a.a.a.ix(6, this.wZs.computeSize());
            }
            int bs = ix + e.a.a.b.b.a.bs(7, this.Scene);
            AppMethodBeat.o(94555);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wZr == null) {
                bVar = new b("Not all required fields were included: Action");
                AppMethodBeat.o(94555);
                throw bVar;
            }
            AppMethodBeat.o(94555);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            caf caf = (caf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            bts bts;
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
                        caf.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(94555);
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
                        caf.wZr = cao;
                    }
                    AppMethodBeat.o(94555);
                    return 0;
                case 3:
                    caf.ptv = aVar3.BTU.readString();
                    AppMethodBeat.o(94555);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        caf.wZq = bts;
                    }
                    AppMethodBeat.o(94555);
                    return 0;
                case 5:
                    caf.vFH = aVar3.BTU.vd();
                    AppMethodBeat.o(94555);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        caf.wZs = bts;
                    }
                    AppMethodBeat.o(94555);
                    return 0;
                case 7:
                    caf.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(94555);
                    return 0;
                default:
                    AppMethodBeat.o(94555);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94555);
            return -1;
        }
    }
}
