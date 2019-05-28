package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class awr extends a {
    public String cEh;
    public String nZb;
    public String nZc;
    public String title;
    public int ttd;
    public boolean wAV;
    public bqs wAW;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56846);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.ttd);
            aVar.aO(2, this.wAV);
            if (this.cEh != null) {
                aVar.e(3, this.cEh);
            }
            if (this.nZb != null) {
                aVar.e(4, this.nZb);
            }
            if (this.nZc != null) {
                aVar.e(5, this.nZc);
            }
            if (this.wAW != null) {
                aVar.iy(6, this.wAW.computeSize());
                this.wAW.writeFields(aVar);
            }
            if (this.title != null) {
                aVar.e(7, this.title);
            }
            AppMethodBeat.o(56846);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.ttd) + 0) + (e.a.a.b.b.a.fv(2) + 1);
            if (this.cEh != null) {
                bs += e.a.a.b.b.a.f(3, this.cEh);
            }
            if (this.nZb != null) {
                bs += e.a.a.b.b.a.f(4, this.nZb);
            }
            if (this.nZc != null) {
                bs += e.a.a.b.b.a.f(5, this.nZc);
            }
            if (this.wAW != null) {
                bs += e.a.a.a.ix(6, this.wAW.computeSize());
            }
            if (this.title != null) {
                bs += e.a.a.b.b.a.f(7, this.title);
            }
            AppMethodBeat.o(56846);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56846);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            awr awr = (awr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    awr.ttd = aVar3.BTU.vd();
                    AppMethodBeat.o(56846);
                    return 0;
                case 2:
                    awr.wAV = aVar3.BTU.ehX();
                    AppMethodBeat.o(56846);
                    return 0;
                case 3:
                    awr.cEh = aVar3.BTU.readString();
                    AppMethodBeat.o(56846);
                    return 0;
                case 4:
                    awr.nZb = aVar3.BTU.readString();
                    AppMethodBeat.o(56846);
                    return 0;
                case 5:
                    awr.nZc = aVar3.BTU.readString();
                    AppMethodBeat.o(56846);
                    return 0;
                case 6:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bqs bqs = new bqs();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bqs.populateBuilderWithField(aVar4, bqs, a.getNextFieldNumber(aVar4))) {
                        }
                        awr.wAW = bqs;
                    }
                    AppMethodBeat.o(56846);
                    return 0;
                case 7:
                    awr.title = aVar3.BTU.readString();
                    AppMethodBeat.o(56846);
                    return 0;
                default:
                    AppMethodBeat.o(56846);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56846);
            return -1;
        }
    }
}
