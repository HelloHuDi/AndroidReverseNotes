package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ccg extends bsr {
    public String wZT;
    public long wZU;
    public SKBuiltinBuffer_t wZw;
    public int wZy;
    public LinkedList<Long> xbA = new LinkedList();
    public int xbB;
    public long xbw;
    public int xbx;
    public long xby;
    public int xbz;

    public ccg() {
        AppMethodBeat.i(94616);
        AppMethodBeat.o(94616);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94617);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wZT != null) {
                aVar.e(2, this.wZT);
            }
            aVar.ai(3, this.wZU);
            aVar.ai(4, this.xbw);
            aVar.iz(5, this.xbx);
            aVar.ai(6, this.xby);
            if (this.wZw != null) {
                aVar.iy(7, this.wZw.computeSize());
                this.wZw.writeFields(aVar);
            }
            aVar.iz(8, this.wZy);
            aVar.iz(11, this.xbz);
            aVar.f(12, 3, this.xbA);
            aVar.iz(13, this.xbB);
            AppMethodBeat.o(94617);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wZT != null) {
                ix += e.a.a.b.b.a.f(2, this.wZT);
            }
            ix = (((ix + e.a.a.b.b.a.o(3, this.wZU)) + e.a.a.b.b.a.o(4, this.xbw)) + e.a.a.b.b.a.bs(5, this.xbx)) + e.a.a.b.b.a.o(6, this.xby);
            if (this.wZw != null) {
                ix += e.a.a.a.ix(7, this.wZw.computeSize());
            }
            int bs = (((ix + e.a.a.b.b.a.bs(8, this.wZy)) + e.a.a.b.b.a.bs(11, this.xbz)) + e.a.a.a.d(12, 3, this.xbA)) + e.a.a.b.b.a.bs(13, this.xbB);
            AppMethodBeat.o(94617);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xbA.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94617);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ccg ccg = (ccg) objArr[1];
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
                        ccg.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(94617);
                    return 0;
                case 2:
                    ccg.wZT = aVar3.BTU.readString();
                    AppMethodBeat.o(94617);
                    return 0;
                case 3:
                    ccg.wZU = aVar3.BTU.ve();
                    AppMethodBeat.o(94617);
                    return 0;
                case 4:
                    ccg.xbw = aVar3.BTU.ve();
                    AppMethodBeat.o(94617);
                    return 0;
                case 5:
                    ccg.xbx = aVar3.BTU.vd();
                    AppMethodBeat.o(94617);
                    return 0;
                case 6:
                    ccg.xby = aVar3.BTU.ve();
                    AppMethodBeat.o(94617);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ccg.wZw = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(94617);
                    return 0;
                case 8:
                    ccg.wZy = aVar3.BTU.vd();
                    AppMethodBeat.o(94617);
                    return 0;
                case 11:
                    ccg.xbz = aVar3.BTU.vd();
                    AppMethodBeat.o(94617);
                    return 0;
                case 12:
                    e.a.a.b.a.a aVar5 = new e.a.a.a.a(aVar3.BTU.emu().wR, unknownTagHandler).BTU;
                    LinkedList linkedList = new LinkedList();
                    while (aVar5.bxm < aVar5.bufferSize) {
                        linkedList.add(Long.valueOf(aVar5.ve()));
                    }
                    ccg.xbA = linkedList;
                    AppMethodBeat.o(94617);
                    return 0;
                case 13:
                    ccg.xbB = aVar3.BTU.vd();
                    AppMethodBeat.o(94617);
                    return 0;
                default:
                    AppMethodBeat.o(94617);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94617);
            return -1;
        }
    }
}
