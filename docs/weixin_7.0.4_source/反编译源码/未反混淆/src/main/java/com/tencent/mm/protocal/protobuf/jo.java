package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class jo extends bsr {
    public String jBB;
    public String luQ;
    public String vHS;
    public int vIJ;
    public String vIj;
    public int vLA;
    public int vLB;
    public int vLC;
    public String vLD;
    public SKBuiltinBuffer_t vLE;
    public SKBuiltinBuffer_t vLF;
    public String vLG;
    public String vLs;
    public String vLt;
    public int vLu;
    public String vLv;
    public int vLw;
    public String vLx;
    public String vLy;
    public SKBuiltinBuffer_t vLz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(123506);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.jBB != null) {
                aVar.e(2, this.jBB);
            }
            if (this.vLs != null) {
                aVar.e(3, this.vLs);
            }
            aVar.iz(4, this.vIJ);
            if (this.vLt != null) {
                aVar.e(5, this.vLt);
            }
            aVar.iz(6, this.vLu);
            if (this.vLv != null) {
                aVar.e(7, this.vLv);
            }
            if (this.vHS != null) {
                aVar.e(8, this.vHS);
            }
            aVar.iz(9, this.vLw);
            if (this.vLx != null) {
                aVar.e(10, this.vLx);
            }
            if (this.vLy != null) {
                aVar.e(11, this.vLy);
            }
            if (this.vLz != null) {
                aVar.iy(12, this.vLz.computeSize());
                this.vLz.writeFields(aVar);
            }
            if (this.luQ != null) {
                aVar.e(13, this.luQ);
            }
            aVar.iz(14, this.vLA);
            aVar.iz(15, this.vLB);
            if (this.vIj != null) {
                aVar.e(16, this.vIj);
            }
            aVar.iz(17, this.vLC);
            if (this.vLD != null) {
                aVar.e(18, this.vLD);
            }
            if (this.vLE != null) {
                aVar.iy(19, this.vLE.computeSize());
                this.vLE.writeFields(aVar);
            }
            if (this.vLF != null) {
                aVar.iy(20, this.vLF.computeSize());
                this.vLF.writeFields(aVar);
            }
            if (this.vLG != null) {
                aVar.e(21, this.vLG);
            }
            AppMethodBeat.o(123506);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.jBB != null) {
                ix += e.a.a.b.b.a.f(2, this.jBB);
            }
            if (this.vLs != null) {
                ix += e.a.a.b.b.a.f(3, this.vLs);
            }
            ix += e.a.a.b.b.a.bs(4, this.vIJ);
            if (this.vLt != null) {
                ix += e.a.a.b.b.a.f(5, this.vLt);
            }
            ix += e.a.a.b.b.a.bs(6, this.vLu);
            if (this.vLv != null) {
                ix += e.a.a.b.b.a.f(7, this.vLv);
            }
            if (this.vHS != null) {
                ix += e.a.a.b.b.a.f(8, this.vHS);
            }
            ix += e.a.a.b.b.a.bs(9, this.vLw);
            if (this.vLx != null) {
                ix += e.a.a.b.b.a.f(10, this.vLx);
            }
            if (this.vLy != null) {
                ix += e.a.a.b.b.a.f(11, this.vLy);
            }
            if (this.vLz != null) {
                ix += e.a.a.a.ix(12, this.vLz.computeSize());
            }
            if (this.luQ != null) {
                ix += e.a.a.b.b.a.f(13, this.luQ);
            }
            ix = (ix + e.a.a.b.b.a.bs(14, this.vLA)) + e.a.a.b.b.a.bs(15, this.vLB);
            if (this.vIj != null) {
                ix += e.a.a.b.b.a.f(16, this.vIj);
            }
            ix += e.a.a.b.b.a.bs(17, this.vLC);
            if (this.vLD != null) {
                ix += e.a.a.b.b.a.f(18, this.vLD);
            }
            if (this.vLE != null) {
                ix += e.a.a.a.ix(19, this.vLE.computeSize());
            }
            if (this.vLF != null) {
                ix += e.a.a.a.ix(20, this.vLF.computeSize());
            }
            if (this.vLG != null) {
                ix += e.a.a.b.b.a.f(21, this.vLG);
            }
            AppMethodBeat.o(123506);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(123506);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            jo joVar = (jo) objArr[1];
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
                        joVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(123506);
                    return 0;
                case 2:
                    joVar.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(123506);
                    return 0;
                case 3:
                    joVar.vLs = aVar3.BTU.readString();
                    AppMethodBeat.o(123506);
                    return 0;
                case 4:
                    joVar.vIJ = aVar3.BTU.vd();
                    AppMethodBeat.o(123506);
                    return 0;
                case 5:
                    joVar.vLt = aVar3.BTU.readString();
                    AppMethodBeat.o(123506);
                    return 0;
                case 6:
                    joVar.vLu = aVar3.BTU.vd();
                    AppMethodBeat.o(123506);
                    return 0;
                case 7:
                    joVar.vLv = aVar3.BTU.readString();
                    AppMethodBeat.o(123506);
                    return 0;
                case 8:
                    joVar.vHS = aVar3.BTU.readString();
                    AppMethodBeat.o(123506);
                    return 0;
                case 9:
                    joVar.vLw = aVar3.BTU.vd();
                    AppMethodBeat.o(123506);
                    return 0;
                case 10:
                    joVar.vLx = aVar3.BTU.readString();
                    AppMethodBeat.o(123506);
                    return 0;
                case 11:
                    joVar.vLy = aVar3.BTU.readString();
                    AppMethodBeat.o(123506);
                    return 0;
                case 12:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        joVar.vLz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(123506);
                    return 0;
                case 13:
                    joVar.luQ = aVar3.BTU.readString();
                    AppMethodBeat.o(123506);
                    return 0;
                case 14:
                    joVar.vLA = aVar3.BTU.vd();
                    AppMethodBeat.o(123506);
                    return 0;
                case 15:
                    joVar.vLB = aVar3.BTU.vd();
                    AppMethodBeat.o(123506);
                    return 0;
                case 16:
                    joVar.vIj = aVar3.BTU.readString();
                    AppMethodBeat.o(123506);
                    return 0;
                case 17:
                    joVar.vLC = aVar3.BTU.vd();
                    AppMethodBeat.o(123506);
                    return 0;
                case 18:
                    joVar.vLD = aVar3.BTU.readString();
                    AppMethodBeat.o(123506);
                    return 0;
                case 19:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        joVar.vLE = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(123506);
                    return 0;
                case 20:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        joVar.vLF = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(123506);
                    return 0;
                case 21:
                    joVar.vLG = aVar3.BTU.readString();
                    AppMethodBeat.o(123506);
                    return 0;
                default:
                    AppMethodBeat.o(123506);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123506);
            return -1;
        }
    }
}
