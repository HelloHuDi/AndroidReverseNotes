package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class btq extends a {
    public String vJS;
    public float wVA;
    public long wVB;
    public bif wVz;
    public cgv wbo;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48960);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vJS != null) {
                aVar.e(1, this.vJS);
            }
            if (this.wbo != null) {
                aVar.iy(2, this.wbo.computeSize());
                this.wbo.writeFields(aVar);
            }
            if (this.wVz != null) {
                aVar.iy(3, this.wVz.computeSize());
                this.wVz.writeFields(aVar);
            }
            aVar.r(4, this.wVA);
            aVar.ai(5, this.wVB);
            AppMethodBeat.o(48960);
            return 0;
        } else if (i == 1) {
            if (this.vJS != null) {
                f = e.a.a.b.b.a.f(1, this.vJS) + 0;
            } else {
                f = 0;
            }
            if (this.wbo != null) {
                f += e.a.a.a.ix(2, this.wbo.computeSize());
            }
            if (this.wVz != null) {
                f += e.a.a.a.ix(3, this.wVz.computeSize());
            }
            int fv = (f + (e.a.a.b.b.a.fv(4) + 4)) + e.a.a.b.b.a.o(5, this.wVB);
            AppMethodBeat.o(48960);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48960);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            btq btq = (btq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    btq.vJS = aVar3.BTU.readString();
                    AppMethodBeat.o(48960);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv cgv = new cgv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(aVar4, cgv, a.getNextFieldNumber(aVar4))) {
                        }
                        btq.wbo = cgv;
                    }
                    AppMethodBeat.o(48960);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bif bif = new bif();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bif.populateBuilderWithField(aVar4, bif, a.getNextFieldNumber(aVar4))) {
                        }
                        btq.wVz = bif;
                    }
                    AppMethodBeat.o(48960);
                    return 0;
                case 4:
                    btq.wVA = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(48960);
                    return 0;
                case 5:
                    btq.wVB = aVar3.BTU.ve();
                    AppMethodBeat.o(48960);
                    return 0;
                default:
                    AppMethodBeat.o(48960);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48960);
            return -1;
        }
    }
}
