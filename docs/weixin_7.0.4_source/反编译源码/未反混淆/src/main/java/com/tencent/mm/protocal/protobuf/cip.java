package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cip extends bsr {
    public String link;
    public int scene;
    public avc xhv;
    public LinkedList<df> xhw = new LinkedList();

    public cip() {
        AppMethodBeat.i(80198);
        AppMethodBeat.o(80198);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80199);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.link != null) {
                aVar.e(2, this.link);
            }
            aVar.iz(3, this.scene);
            if (this.xhv != null) {
                aVar.iy(4, this.xhv.computeSize());
                this.xhv.writeFields(aVar);
            }
            aVar.e(5, 8, this.xhw);
            AppMethodBeat.o(80199);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.link != null) {
                ix += e.a.a.b.b.a.f(2, this.link);
            }
            ix += e.a.a.b.b.a.bs(3, this.scene);
            if (this.xhv != null) {
                ix += e.a.a.a.ix(4, this.xhv.computeSize());
            }
            int c = ix + e.a.a.a.c(5, 8, this.xhw);
            AppMethodBeat.o(80199);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xhw.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80199);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cip cip = (cip) objArr[1];
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
                        cip.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(80199);
                    return 0;
                case 2:
                    cip.link = aVar3.BTU.readString();
                    AppMethodBeat.o(80199);
                    return 0;
                case 3:
                    cip.scene = aVar3.BTU.vd();
                    AppMethodBeat.o(80199);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        avc avc = new avc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = avc.populateBuilderWithField(aVar4, avc, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cip.xhv = avc;
                    }
                    AppMethodBeat.o(80199);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        df dfVar = new df();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dfVar.populateBuilderWithField(aVar4, dfVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cip.xhw.add(dfVar);
                    }
                    AppMethodBeat.o(80199);
                    return 0;
                default:
                    AppMethodBeat.o(80199);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80199);
            return -1;
        }
    }
}
