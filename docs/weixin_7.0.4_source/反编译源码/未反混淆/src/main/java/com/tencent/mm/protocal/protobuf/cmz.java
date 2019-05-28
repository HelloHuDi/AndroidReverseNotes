package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cmz extends bsr {
    public int OpCode;
    public SKBuiltinBuffer_t vJT;
    public String vLW;
    public bts vMa;
    public SKBuiltinBuffer_t vMb;
    public int wXN;
    public bts wtZ;
    public String xkw;
    public bts xkx;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(60072);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.OpCode);
            if (this.xkw != null) {
                aVar.e(3, this.xkw);
            }
            if (this.vLW != null) {
                aVar.e(4, this.vLW);
            }
            if (this.wtZ != null) {
                aVar.iy(5, this.wtZ.computeSize());
                this.wtZ.writeFields(aVar);
            }
            if (this.xkx != null) {
                aVar.iy(6, this.xkx.computeSize());
                this.xkx.writeFields(aVar);
            }
            if (this.vMa != null) {
                aVar.iy(7, this.vMa.computeSize());
                this.vMa.writeFields(aVar);
            }
            if (this.vMb != null) {
                aVar.iy(8, this.vMb.computeSize());
                this.vMb.writeFields(aVar);
            }
            aVar.iz(9, this.wXN);
            if (this.vJT != null) {
                aVar.iy(10, this.vJT.computeSize());
                this.vJT.writeFields(aVar);
            }
            AppMethodBeat.o(60072);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.OpCode);
            if (this.xkw != null) {
                ix += e.a.a.b.b.a.f(3, this.xkw);
            }
            if (this.vLW != null) {
                ix += e.a.a.b.b.a.f(4, this.vLW);
            }
            if (this.wtZ != null) {
                ix += e.a.a.a.ix(5, this.wtZ.computeSize());
            }
            if (this.xkx != null) {
                ix += e.a.a.a.ix(6, this.xkx.computeSize());
            }
            if (this.vMa != null) {
                ix += e.a.a.a.ix(7, this.vMa.computeSize());
            }
            if (this.vMb != null) {
                ix += e.a.a.a.ix(8, this.vMb.computeSize());
            }
            ix += e.a.a.b.b.a.bs(9, this.wXN);
            if (this.vJT != null) {
                ix += e.a.a.a.ix(10, this.vJT.computeSize());
            }
            AppMethodBeat.o(60072);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(60072);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cmz cmz = (cmz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            bts bts;
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
                        cmz.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(60072);
                    return 0;
                case 2:
                    cmz.OpCode = aVar3.BTU.vd();
                    AppMethodBeat.o(60072);
                    return 0;
                case 3:
                    cmz.xkw = aVar3.BTU.readString();
                    AppMethodBeat.o(60072);
                    return 0;
                case 4:
                    cmz.vLW = aVar3.BTU.readString();
                    AppMethodBeat.o(60072);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cmz.wtZ = bts;
                    }
                    AppMethodBeat.o(60072);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cmz.xkx = bts;
                    }
                    AppMethodBeat.o(60072);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cmz.vMa = bts;
                    }
                    AppMethodBeat.o(60072);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cmz.vMb = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(60072);
                    return 0;
                case 9:
                    cmz.wXN = aVar3.BTU.vd();
                    AppMethodBeat.o(60072);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cmz.vJT = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(60072);
                    return 0;
                default:
                    AppMethodBeat.o(60072);
                    return -1;
            }
        } else {
            AppMethodBeat.o(60072);
            return -1;
        }
    }
}
