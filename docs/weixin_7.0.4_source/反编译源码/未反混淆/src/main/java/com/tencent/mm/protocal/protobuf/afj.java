package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class afj extends bsr {
    public int Scene;
    public int jCt;
    public SKBuiltinBuffer_t vLz;
    public String wmM;
    public int wmN;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(845);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.jCt);
            aVar.iz(3, this.Scene);
            if (this.wmM != null) {
                aVar.e(4, this.wmM);
            }
            if (this.vLz != null) {
                aVar.iy(5, this.vLz.computeSize());
                this.vLz.writeFields(aVar);
            }
            aVar.iz(6, this.wmN);
            AppMethodBeat.o(845);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.jCt)) + e.a.a.b.b.a.bs(3, this.Scene);
            if (this.wmM != null) {
                ix += e.a.a.b.b.a.f(4, this.wmM);
            }
            if (this.vLz != null) {
                ix += e.a.a.a.ix(5, this.vLz.computeSize());
            }
            int bs = ix + e.a.a.b.b.a.bs(6, this.wmN);
            AppMethodBeat.o(845);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(845);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            afj afj = (afj) objArr[1];
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
                        afj.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(845);
                    return 0;
                case 2:
                    afj.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(845);
                    return 0;
                case 3:
                    afj.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(845);
                    return 0;
                case 4:
                    afj.wmM = aVar3.BTU.readString();
                    AppMethodBeat.o(845);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        afj.vLz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(845);
                    return 0;
                case 6:
                    afj.wmN = aVar3.BTU.vd();
                    AppMethodBeat.o(845);
                    return 0;
                default:
                    AppMethodBeat.o(845);
                    return -1;
            }
        } else {
            AppMethodBeat.o(845);
            return -1;
        }
    }
}
