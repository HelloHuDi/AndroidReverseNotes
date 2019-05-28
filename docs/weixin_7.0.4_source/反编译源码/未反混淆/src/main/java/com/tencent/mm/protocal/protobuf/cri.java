package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cri extends a {
    public cre xoZ;
    public cqu xpa;
    public String xpb;
    public String xpc;
    public String xpd;
    public int xpe;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(102420);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xoZ != null) {
                aVar.iy(1, this.xoZ.computeSize());
                this.xoZ.writeFields(aVar);
            }
            if (this.xpa != null) {
                aVar.iy(2, this.xpa.computeSize());
                this.xpa.writeFields(aVar);
            }
            if (this.xpb != null) {
                aVar.e(3, this.xpb);
            }
            if (this.xpc != null) {
                aVar.e(4, this.xpc);
            }
            if (this.xpd != null) {
                aVar.e(5, this.xpd);
            }
            aVar.iz(6, this.xpe);
            AppMethodBeat.o(102420);
            return 0;
        } else if (i == 1) {
            if (this.xoZ != null) {
                ix = e.a.a.a.ix(1, this.xoZ.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xpa != null) {
                ix += e.a.a.a.ix(2, this.xpa.computeSize());
            }
            if (this.xpb != null) {
                ix += e.a.a.b.b.a.f(3, this.xpb);
            }
            if (this.xpc != null) {
                ix += e.a.a.b.b.a.f(4, this.xpc);
            }
            if (this.xpd != null) {
                ix += e.a.a.b.b.a.f(5, this.xpd);
            }
            int bs = ix + e.a.a.b.b.a.bs(6, this.xpe);
            AppMethodBeat.o(102420);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(102420);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cri cri = (cri) objArr[1];
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
                        cre cre = new cre();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cre.populateBuilderWithField(aVar4, cre, a.getNextFieldNumber(aVar4))) {
                        }
                        cri.xoZ = cre;
                    }
                    AppMethodBeat.o(102420);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cqu cqu = new cqu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cqu.populateBuilderWithField(aVar4, cqu, a.getNextFieldNumber(aVar4))) {
                        }
                        cri.xpa = cqu;
                    }
                    AppMethodBeat.o(102420);
                    return 0;
                case 3:
                    cri.xpb = aVar3.BTU.readString();
                    AppMethodBeat.o(102420);
                    return 0;
                case 4:
                    cri.xpc = aVar3.BTU.readString();
                    AppMethodBeat.o(102420);
                    return 0;
                case 5:
                    cri.xpd = aVar3.BTU.readString();
                    AppMethodBeat.o(102420);
                    return 0;
                case 6:
                    cri.xpe = aVar3.BTU.vd();
                    AppMethodBeat.o(102420);
                    return 0;
                default:
                    AppMethodBeat.o(102420);
                    return -1;
            }
        } else {
            AppMethodBeat.o(102420);
            return -1;
        }
    }
}
