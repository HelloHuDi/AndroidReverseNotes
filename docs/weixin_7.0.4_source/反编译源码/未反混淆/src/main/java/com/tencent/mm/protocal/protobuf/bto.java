package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bto extends a {
    public btr vCP;
    public String vJS;
    public int wVx;
    public int wVy;
    public cgv wbo;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48959);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wVx);
            aVar.iz(2, this.wVy);
            if (this.vCP != null) {
                aVar.iy(3, this.vCP.computeSize());
                this.vCP.writeFields(aVar);
            }
            if (this.wbo != null) {
                aVar.iy(4, this.wbo.computeSize());
                this.wbo.writeFields(aVar);
            }
            if (this.vJS != null) {
                aVar.e(5, this.vJS);
            }
            AppMethodBeat.o(48959);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.wVx) + 0) + e.a.a.b.b.a.bs(2, this.wVy);
            if (this.vCP != null) {
                bs += e.a.a.a.ix(3, this.vCP.computeSize());
            }
            if (this.wbo != null) {
                bs += e.a.a.a.ix(4, this.wbo.computeSize());
            }
            if (this.vJS != null) {
                bs += e.a.a.b.b.a.f(5, this.vJS);
            }
            AppMethodBeat.o(48959);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48959);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bto bto = (bto) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bto.wVx = aVar3.BTU.vd();
                    AppMethodBeat.o(48959);
                    return 0;
                case 2:
                    bto.wVy = aVar3.BTU.vd();
                    AppMethodBeat.o(48959);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btr btr = new btr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btr.populateBuilderWithField(aVar4, btr, a.getNextFieldNumber(aVar4))) {
                        }
                        bto.vCP = btr;
                    }
                    AppMethodBeat.o(48959);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv cgv = new cgv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(aVar4, cgv, a.getNextFieldNumber(aVar4))) {
                        }
                        bto.wbo = cgv;
                    }
                    AppMethodBeat.o(48959);
                    return 0;
                case 5:
                    bto.vJS = aVar3.BTU.readString();
                    AppMethodBeat.o(48959);
                    return 0;
                default:
                    AppMethodBeat.o(48959);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48959);
            return -1;
        }
    }
}
