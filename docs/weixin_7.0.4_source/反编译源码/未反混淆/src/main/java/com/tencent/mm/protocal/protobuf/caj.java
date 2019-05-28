package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class caj extends bsr {
    public int Scene;
    public int vFH;
    public brf vFa;
    public long vQE;
    public SKBuiltinBuffer_t wZw;
    public SKBuiltinBuffer_t wZx;
    public int wZy;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94559);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.ai(2, this.vQE);
            aVar.iz(3, this.Scene);
            if (this.wZw != null) {
                aVar.iy(4, this.wZw.computeSize());
                this.wZw.writeFields(aVar);
            }
            aVar.iz(5, this.vFH);
            if (this.wZx != null) {
                aVar.iy(6, this.wZx.computeSize());
                this.wZx.writeFields(aVar);
            }
            aVar.iz(7, this.wZy);
            if (this.vFa != null) {
                aVar.iy(8, this.vFa.computeSize());
                this.vFa.writeFields(aVar);
            }
            AppMethodBeat.o(94559);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.o(2, this.vQE)) + e.a.a.b.b.a.bs(3, this.Scene);
            if (this.wZw != null) {
                ix += e.a.a.a.ix(4, this.wZw.computeSize());
            }
            ix += e.a.a.b.b.a.bs(5, this.vFH);
            if (this.wZx != null) {
                ix += e.a.a.a.ix(6, this.wZx.computeSize());
            }
            ix += e.a.a.b.b.a.bs(7, this.wZy);
            if (this.vFa != null) {
                ix += e.a.a.a.ix(8, this.vFa.computeSize());
            }
            AppMethodBeat.o(94559);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94559);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            caj caj = (caj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
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
                        caj.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(94559);
                    return 0;
                case 2:
                    caj.vQE = aVar3.BTU.ve();
                    AppMethodBeat.o(94559);
                    return 0;
                case 3:
                    caj.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(94559);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        caj.wZw = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(94559);
                    return 0;
                case 5:
                    caj.vFH = aVar3.BTU.vd();
                    AppMethodBeat.o(94559);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        caj.wZx = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(94559);
                    return 0;
                case 7:
                    caj.wZy = aVar3.BTU.vd();
                    AppMethodBeat.o(94559);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        brf brf = new brf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = brf.populateBuilderWithField(aVar4, brf, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        caj.vFa = brf;
                    }
                    AppMethodBeat.o(94559);
                    return 0;
                default:
                    AppMethodBeat.o(94559);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94559);
            return -1;
        }
    }
}
