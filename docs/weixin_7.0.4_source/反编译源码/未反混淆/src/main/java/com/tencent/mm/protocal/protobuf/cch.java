package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cch extends btd {
    public LinkedList<cbf> vKB = new LinkedList();
    public int wGG;
    public String wZT;
    public int wZX;
    public int wZY;
    public cbw wZZ;
    public SKBuiltinBuffer_t wZw;
    public int xbC;
    public int xbD;
    public LinkedList<cy> xbE = new LinkedList();
    public int xbF;
    public LinkedList<bpx> xbG = new LinkedList();
    public int xbH;
    public LinkedList<vd> xbI = new LinkedList();

    public cch() {
        AppMethodBeat.i(94618);
        AppMethodBeat.o(94618);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94619);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(94619);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wZT != null) {
                aVar.e(2, this.wZT);
            }
            aVar.iz(3, this.wGG);
            aVar.e(4, 8, this.vKB);
            aVar.iz(5, this.xbC);
            aVar.iz(6, this.wZX);
            aVar.iz(7, this.wZY);
            if (this.wZZ != null) {
                aVar.iy(8, this.wZZ.computeSize());
                this.wZZ.writeFields(aVar);
            }
            aVar.iz(9, this.xbD);
            aVar.e(10, 8, this.xbE);
            if (this.wZw != null) {
                aVar.iy(11, this.wZw.computeSize());
                this.wZw.writeFields(aVar);
            }
            aVar.iz(12, this.xbF);
            aVar.e(13, 8, this.xbG);
            aVar.iz(14, this.xbH);
            aVar.e(15, 8, this.xbI);
            AppMethodBeat.o(94619);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wZT != null) {
                ix += e.a.a.b.b.a.f(2, this.wZT);
            }
            ix = ((((ix + e.a.a.b.b.a.bs(3, this.wGG)) + e.a.a.a.c(4, 8, this.vKB)) + e.a.a.b.b.a.bs(5, this.xbC)) + e.a.a.b.b.a.bs(6, this.wZX)) + e.a.a.b.b.a.bs(7, this.wZY);
            if (this.wZZ != null) {
                ix += e.a.a.a.ix(8, this.wZZ.computeSize());
            }
            ix = (ix + e.a.a.b.b.a.bs(9, this.xbD)) + e.a.a.a.c(10, 8, this.xbE);
            if (this.wZw != null) {
                ix += e.a.a.a.ix(11, this.wZw.computeSize());
            }
            int bs = (((ix + e.a.a.b.b.a.bs(12, this.xbF)) + e.a.a.a.c(13, 8, this.xbG)) + e.a.a.b.b.a.bs(14, this.xbH)) + e.a.a.a.c(15, 8, this.xbI);
            AppMethodBeat.o(94619);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vKB.clear();
            this.xbE.clear();
            this.xbG.clear();
            this.xbI.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(94619);
                throw bVar;
            }
            AppMethodBeat.o(94619);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cch cch = (cch) objArr[1];
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
                        BaseResponse baseResponse = new BaseResponse();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cch.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(94619);
                    return 0;
                case 2:
                    cch.wZT = aVar3.BTU.readString();
                    AppMethodBeat.o(94619);
                    return 0;
                case 3:
                    cch.wGG = aVar3.BTU.vd();
                    AppMethodBeat.o(94619);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbf cbf = new cbf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbf.populateBuilderWithField(aVar4, cbf, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cch.vKB.add(cbf);
                    }
                    AppMethodBeat.o(94619);
                    return 0;
                case 5:
                    cch.xbC = aVar3.BTU.vd();
                    AppMethodBeat.o(94619);
                    return 0;
                case 6:
                    cch.wZX = aVar3.BTU.vd();
                    AppMethodBeat.o(94619);
                    return 0;
                case 7:
                    cch.wZY = aVar3.BTU.vd();
                    AppMethodBeat.o(94619);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbw cbw = new cbw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbw.populateBuilderWithField(aVar4, cbw, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cch.wZZ = cbw;
                    }
                    AppMethodBeat.o(94619);
                    return 0;
                case 9:
                    cch.xbD = aVar3.BTU.vd();
                    AppMethodBeat.o(94619);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cy cyVar = new cy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cyVar.populateBuilderWithField(aVar4, cyVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cch.xbE.add(cyVar);
                    }
                    AppMethodBeat.o(94619);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cch.wZw = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(94619);
                    return 0;
                case 12:
                    cch.xbF = aVar3.BTU.vd();
                    AppMethodBeat.o(94619);
                    return 0;
                case 13:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bpx bpx = new bpx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpx.populateBuilderWithField(aVar4, bpx, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cch.xbG.add(bpx);
                    }
                    AppMethodBeat.o(94619);
                    return 0;
                case 14:
                    cch.xbH = aVar3.BTU.vd();
                    AppMethodBeat.o(94619);
                    return 0;
                case 15:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        vd vdVar = new vd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vdVar.populateBuilderWithField(aVar4, vdVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cch.xbI.add(vdVar);
                    }
                    AppMethodBeat.o(94619);
                    return 0;
                default:
                    AppMethodBeat.o(94619);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94619);
            return -1;
        }
    }
}
