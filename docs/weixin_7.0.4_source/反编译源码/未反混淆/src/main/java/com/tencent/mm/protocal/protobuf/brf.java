package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class brf extends a {
    public SKBuiltinBuffer_t wTA;
    public SKBuiltinBuffer_t wTB;
    public SKBuiltinBuffer_t wTC;
    public SKBuiltinBuffer_t wTD;
    public int wTz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94553);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wTz);
            if (this.wTA != null) {
                aVar.iy(2, this.wTA.computeSize());
                this.wTA.writeFields(aVar);
            }
            if (this.wTB != null) {
                aVar.iy(3, this.wTB.computeSize());
                this.wTB.writeFields(aVar);
            }
            if (this.wTC != null) {
                aVar.iy(4, this.wTC.computeSize());
                this.wTC.writeFields(aVar);
            }
            if (this.wTD != null) {
                aVar.iy(5, this.wTD.computeSize());
                this.wTD.writeFields(aVar);
            }
            AppMethodBeat.o(94553);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.wTz) + 0;
            if (this.wTA != null) {
                bs += e.a.a.a.ix(2, this.wTA.computeSize());
            }
            if (this.wTB != null) {
                bs += e.a.a.a.ix(3, this.wTB.computeSize());
            }
            if (this.wTC != null) {
                bs += e.a.a.a.ix(4, this.wTC.computeSize());
            }
            if (this.wTD != null) {
                bs += e.a.a.a.ix(5, this.wTD.computeSize());
            }
            AppMethodBeat.o(94553);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94553);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            brf brf = (brf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    brf.wTz = aVar3.BTU.vd();
                    AppMethodBeat.o(94553);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        brf.wTA = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(94553);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        brf.wTB = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(94553);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        brf.wTC = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(94553);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        brf.wTD = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(94553);
                    return 0;
                default:
                    AppMethodBeat.o(94553);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94553);
            return -1;
        }
    }
}
