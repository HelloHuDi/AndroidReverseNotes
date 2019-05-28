package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class sf extends bsr {
    public int Scene;
    public String ndF;
    public String ndG;
    public int ptD;
    public long ptF;
    public int ptw;
    public String vZx;
    public coa vZy;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28362);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.vZx != null) {
                aVar.e(2, this.vZx);
            }
            aVar.iz(3, this.ptw);
            aVar.iz(4, this.ptD);
            if (this.vZy != null) {
                aVar.iy(5, this.vZy.computeSize());
                this.vZy.writeFields(aVar);
            }
            aVar.ai(6, this.ptF);
            aVar.iz(7, this.Scene);
            if (this.ndG != null) {
                aVar.e(8, this.ndG);
            }
            if (this.ndF != null) {
                aVar.e(9, this.ndF);
            }
            AppMethodBeat.o(28362);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vZx != null) {
                ix += e.a.a.b.b.a.f(2, this.vZx);
            }
            ix = (ix + e.a.a.b.b.a.bs(3, this.ptw)) + e.a.a.b.b.a.bs(4, this.ptD);
            if (this.vZy != null) {
                ix += e.a.a.a.ix(5, this.vZy.computeSize());
            }
            ix = (ix + e.a.a.b.b.a.o(6, this.ptF)) + e.a.a.b.b.a.bs(7, this.Scene);
            if (this.ndG != null) {
                ix += e.a.a.b.b.a.f(8, this.ndG);
            }
            if (this.ndF != null) {
                ix += e.a.a.b.b.a.f(9, this.ndF);
            }
            AppMethodBeat.o(28362);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28362);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            sf sfVar = (sf) objArr[1];
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
                        sfVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28362);
                    return 0;
                case 2:
                    sfVar.vZx = aVar3.BTU.readString();
                    AppMethodBeat.o(28362);
                    return 0;
                case 3:
                    sfVar.ptw = aVar3.BTU.vd();
                    AppMethodBeat.o(28362);
                    return 0;
                case 4:
                    sfVar.ptD = aVar3.BTU.vd();
                    AppMethodBeat.o(28362);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        coa coa = new coa();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = coa.populateBuilderWithField(aVar4, coa, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        sfVar.vZy = coa;
                    }
                    AppMethodBeat.o(28362);
                    return 0;
                case 6:
                    sfVar.ptF = aVar3.BTU.ve();
                    AppMethodBeat.o(28362);
                    return 0;
                case 7:
                    sfVar.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(28362);
                    return 0;
                case 8:
                    sfVar.ndG = aVar3.BTU.readString();
                    AppMethodBeat.o(28362);
                    return 0;
                case 9:
                    sfVar.ndF = aVar3.BTU.readString();
                    AppMethodBeat.o(28362);
                    return 0;
                default:
                    AppMethodBeat.o(28362);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28362);
            return -1;
        }
    }
}
