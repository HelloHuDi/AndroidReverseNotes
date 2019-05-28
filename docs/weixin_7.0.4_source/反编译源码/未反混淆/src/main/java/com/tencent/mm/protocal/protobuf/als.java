package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class als extends bsr {
    public int OpCode;
    public int Scene;
    public double vNH;
    public double vNI;
    public String wkD;
    public SKBuiltinBuffer_t wpP;
    public int wpR;
    public double wqS;
    public double wqT;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(113782);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wpP == null) {
                bVar = new b("Not all required fields were included: Buff");
                AppMethodBeat.o(113782);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.Scene);
            aVar.iz(3, this.OpCode);
            if (this.wkD != null) {
                aVar.e(4, this.wkD);
            }
            if (this.wpP != null) {
                aVar.iy(5, this.wpP.computeSize());
                this.wpP.writeFields(aVar);
            }
            aVar.f(6, this.vNH);
            aVar.f(7, this.vNI);
            aVar.f(8, this.wqS);
            aVar.f(9, this.wqT);
            aVar.iz(10, this.wpR);
            AppMethodBeat.o(113782);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.Scene)) + e.a.a.b.b.a.bs(3, this.OpCode);
            if (this.wkD != null) {
                ix += e.a.a.b.b.a.f(4, this.wkD);
            }
            if (this.wpP != null) {
                ix += e.a.a.a.ix(5, this.wpP.computeSize());
            }
            int fv = ((((ix + (e.a.a.b.b.a.fv(6) + 8)) + (e.a.a.b.b.a.fv(7) + 8)) + (e.a.a.b.b.a.fv(8) + 8)) + (e.a.a.b.b.a.fv(9) + 8)) + e.a.a.b.b.a.bs(10, this.wpR);
            AppMethodBeat.o(113782);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wpP == null) {
                bVar = new b("Not all required fields were included: Buff");
                AppMethodBeat.o(113782);
                throw bVar;
            }
            AppMethodBeat.o(113782);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            als als = (als) objArr[1];
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
                        als.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(113782);
                    return 0;
                case 2:
                    als.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(113782);
                    return 0;
                case 3:
                    als.OpCode = aVar3.BTU.vd();
                    AppMethodBeat.o(113782);
                    return 0;
                case 4:
                    als.wkD = aVar3.BTU.readString();
                    AppMethodBeat.o(113782);
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
                        als.wpP = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(113782);
                    return 0;
                case 6:
                    als.vNH = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(113782);
                    return 0;
                case 7:
                    als.vNI = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(113782);
                    return 0;
                case 8:
                    als.wqS = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(113782);
                    return 0;
                case 9:
                    als.wqT = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(113782);
                    return 0;
                case 10:
                    als.wpR = aVar3.BTU.vd();
                    AppMethodBeat.o(113782);
                    return 0;
                default:
                    AppMethodBeat.o(113782);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113782);
            return -1;
        }
    }
}
