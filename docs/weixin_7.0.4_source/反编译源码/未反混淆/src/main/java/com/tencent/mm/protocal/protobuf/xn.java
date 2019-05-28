package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class xn extends bsr {
    public int ptD;
    public long ptF;
    public String vEf;
    public String vFF;
    public int vOq;
    public int wdn;
    public long wdo;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(116802);
        int bs;
        if (i == 0) {
            a aVar = (a) objArr[0];
            aVar.iz(1, this.ptD);
            aVar.iz(2, this.vOq);
            aVar.iz(3, this.wdn);
            if (this.vFF != null) {
                aVar.e(4, this.vFF);
            }
            if (this.BaseRequest != null) {
                aVar.iy(5, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.ai(6, this.ptF);
            if (this.vEf != null) {
                aVar.e(7, this.vEf);
            }
            aVar.ai(8, this.wdo);
            AppMethodBeat.o(116802);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.ptD) + 0) + e.a.a.b.b.a.bs(2, this.vOq)) + e.a.a.b.b.a.bs(3, this.wdn);
            if (this.vFF != null) {
                bs += e.a.a.b.b.a.f(4, this.vFF);
            }
            if (this.BaseRequest != null) {
                bs += e.a.a.a.ix(5, this.BaseRequest.computeSize());
            }
            bs += e.a.a.b.b.a.o(6, this.ptF);
            if (this.vEf != null) {
                bs += e.a.a.b.b.a.f(7, this.vEf);
            }
            bs += e.a.a.b.b.a.o(8, this.wdo);
            AppMethodBeat.o(116802);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); bs > 0; bs = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(116802);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            xn xnVar = (xn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    xnVar.ptD = aVar3.BTU.vd();
                    AppMethodBeat.o(116802);
                    return 0;
                case 2:
                    xnVar.vOq = aVar3.BTU.vd();
                    AppMethodBeat.o(116802);
                    return 0;
                case 3:
                    xnVar.wdn = aVar3.BTU.vd();
                    AppMethodBeat.o(116802);
                    return 0;
                case 4:
                    xnVar.vFF = aVar3.BTU.readString();
                    AppMethodBeat.o(116802);
                    return 0;
                case 5:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        xnVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(116802);
                    return 0;
                case 6:
                    xnVar.ptF = aVar3.BTU.ve();
                    AppMethodBeat.o(116802);
                    return 0;
                case 7:
                    xnVar.vEf = aVar3.BTU.readString();
                    AppMethodBeat.o(116802);
                    return 0;
                case 8:
                    xnVar.wdo = aVar3.BTU.ve();
                    AppMethodBeat.o(116802);
                    return 0;
                default:
                    AppMethodBeat.o(116802);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116802);
            return -1;
        }
    }
}
