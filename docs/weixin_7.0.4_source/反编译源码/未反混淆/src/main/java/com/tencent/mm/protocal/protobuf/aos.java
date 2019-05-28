package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aos extends bsr {
    public int mZF;
    public LinkedList<bts> nbX = new LinkedList();
    public String nbs;
    public int ncn;
    public int nco;
    public int wsQ;

    public aos() {
        AppMethodBeat.i(80097);
        AppMethodBeat.o(80097);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80098);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.mZF);
            aVar.iz(3, this.ncn);
            aVar.iz(4, this.nco);
            if (this.nbs != null) {
                aVar.e(5, this.nbs);
            }
            aVar.iz(6, this.wsQ);
            aVar.e(7, 8, this.nbX);
            AppMethodBeat.o(80098);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((ix + e.a.a.b.b.a.bs(2, this.mZF)) + e.a.a.b.b.a.bs(3, this.ncn)) + e.a.a.b.b.a.bs(4, this.nco);
            if (this.nbs != null) {
                ix += e.a.a.b.b.a.f(5, this.nbs);
            }
            int bs = (ix + e.a.a.b.b.a.bs(6, this.wsQ)) + e.a.a.a.c(7, 8, this.nbX);
            AppMethodBeat.o(80098);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nbX.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80098);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aos aos = (aos) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
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
                        aos.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(80098);
                    return 0;
                case 2:
                    aos.mZF = aVar3.BTU.vd();
                    AppMethodBeat.o(80098);
                    return 0;
                case 3:
                    aos.ncn = aVar3.BTU.vd();
                    AppMethodBeat.o(80098);
                    return 0;
                case 4:
                    aos.nco = aVar3.BTU.vd();
                    AppMethodBeat.o(80098);
                    return 0;
                case 5:
                    aos.nbs = aVar3.BTU.readString();
                    AppMethodBeat.o(80098);
                    return 0;
                case 6:
                    aos.wsQ = aVar3.BTU.vd();
                    AppMethodBeat.o(80098);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aos.nbX.add(bts);
                    }
                    AppMethodBeat.o(80098);
                    return 0;
                default:
                    AppMethodBeat.o(80098);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80098);
            return -1;
        }
    }
}
