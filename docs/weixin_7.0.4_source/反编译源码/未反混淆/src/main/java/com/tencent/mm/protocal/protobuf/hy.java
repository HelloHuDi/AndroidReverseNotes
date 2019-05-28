package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class hy extends bsr {
    public LinkedList<String> vKr = new LinkedList();
    public LinkedList<bsq> vKs = new LinkedList();
    public String vKt;
    public long vKu;
    public int vKv;
    public int vKw;

    public hy() {
        AppMethodBeat.i(14707);
        AppMethodBeat.o(14707);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14708);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 1, this.vKr);
            aVar.e(3, 8, this.vKs);
            if (this.vKt != null) {
                aVar.e(4, this.vKt);
            }
            aVar.ai(5, this.vKu);
            aVar.iz(6, this.vKv);
            aVar.iz(7, this.vKw);
            AppMethodBeat.o(14708);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.a.c(2, 1, this.vKr)) + e.a.a.a.c(3, 8, this.vKs);
            if (this.vKt != null) {
                ix += e.a.a.b.b.a.f(4, this.vKt);
            }
            int o = ((ix + e.a.a.b.b.a.o(5, this.vKu)) + e.a.a.b.b.a.bs(6, this.vKv)) + e.a.a.b.b.a.bs(7, this.vKw);
            AppMethodBeat.o(14708);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vKr.clear();
            this.vKs.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(14708);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            hy hyVar = (hy) objArr[1];
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
                        hyVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(14708);
                    return 0;
                case 2:
                    hyVar.vKr.add(aVar3.BTU.readString());
                    AppMethodBeat.o(14708);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bsq bsq = new bsq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bsq.populateBuilderWithField(aVar4, bsq, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        hyVar.vKs.add(bsq);
                    }
                    AppMethodBeat.o(14708);
                    return 0;
                case 4:
                    hyVar.vKt = aVar3.BTU.readString();
                    AppMethodBeat.o(14708);
                    return 0;
                case 5:
                    hyVar.vKu = aVar3.BTU.ve();
                    AppMethodBeat.o(14708);
                    return 0;
                case 6:
                    hyVar.vKv = aVar3.BTU.vd();
                    AppMethodBeat.o(14708);
                    return 0;
                case 7:
                    hyVar.vKw = aVar3.BTU.vd();
                    AppMethodBeat.o(14708);
                    return 0;
                default:
                    AppMethodBeat.o(14708);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14708);
            return -1;
        }
    }
}
