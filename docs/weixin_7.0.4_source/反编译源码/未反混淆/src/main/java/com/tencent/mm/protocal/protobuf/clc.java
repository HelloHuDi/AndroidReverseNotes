package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class clc extends bsr {
    public int fJT;
    public String jBB;
    public SKBuiltinBuffer_t ptz;
    public int vHo;
    public int vHr;
    public int vOq;
    public String xiM;
    public int xiN;
    public int xiO;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(116807);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.ptz == null) {
                bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(116807);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.jBB != null) {
                aVar.e(2, this.jBB);
            }
            if (this.ptz != null) {
                aVar.iy(3, this.ptz.computeSize());
                this.ptz.writeFields(aVar);
            }
            aVar.iz(4, this.vOq);
            if (this.xiM != null) {
                aVar.e(5, this.xiM);
            }
            aVar.iz(6, this.fJT);
            aVar.iz(7, this.xiN);
            aVar.iz(8, this.vHr);
            aVar.iz(9, this.xiO);
            aVar.iz(10, this.vHo);
            AppMethodBeat.o(116807);
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
            if (this.ptz != null) {
                ix += e.a.a.a.ix(3, this.ptz.computeSize());
            }
            ix += e.a.a.b.b.a.bs(4, this.vOq);
            if (this.xiM != null) {
                ix += e.a.a.b.b.a.f(5, this.xiM);
            }
            int bs = ((((ix + e.a.a.b.b.a.bs(6, this.fJT)) + e.a.a.b.b.a.bs(7, this.xiN)) + e.a.a.b.b.a.bs(8, this.vHr)) + e.a.a.b.b.a.bs(9, this.xiO)) + e.a.a.b.b.a.bs(10, this.vHo);
            AppMethodBeat.o(116807);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.ptz == null) {
                bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(116807);
                throw bVar;
            }
            AppMethodBeat.o(116807);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            clc clc = (clc) objArr[1];
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
                        clc.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(116807);
                    return 0;
                case 2:
                    clc.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(116807);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        clc.ptz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(116807);
                    return 0;
                case 4:
                    clc.vOq = aVar3.BTU.vd();
                    AppMethodBeat.o(116807);
                    return 0;
                case 5:
                    clc.xiM = aVar3.BTU.readString();
                    AppMethodBeat.o(116807);
                    return 0;
                case 6:
                    clc.fJT = aVar3.BTU.vd();
                    AppMethodBeat.o(116807);
                    return 0;
                case 7:
                    clc.xiN = aVar3.BTU.vd();
                    AppMethodBeat.o(116807);
                    return 0;
                case 8:
                    clc.vHr = aVar3.BTU.vd();
                    AppMethodBeat.o(116807);
                    return 0;
                case 9:
                    clc.xiO = aVar3.BTU.vd();
                    AppMethodBeat.o(116807);
                    return 0;
                case 10:
                    clc.vHo = aVar3.BTU.vd();
                    AppMethodBeat.o(116807);
                    return 0;
                default:
                    AppMethodBeat.o(116807);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116807);
            return -1;
        }
    }
}
