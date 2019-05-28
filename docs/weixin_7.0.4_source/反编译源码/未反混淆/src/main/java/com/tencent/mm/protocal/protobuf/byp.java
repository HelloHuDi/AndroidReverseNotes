package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class byp extends bsr {
    public int fJT;
    public SKBuiltinBuffer_t ptz;
    public int vFE;
    public float vRq;
    public int vZF;
    public int wXO;
    public float wXP;
    public float wXQ;
    public int wrA;
    public int wrB;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28646);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.ptz == null) {
                bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(28646);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.ptz != null) {
                aVar.iy(2, this.ptz.computeSize());
                this.ptz.writeFields(aVar);
            }
            aVar.iz(3, this.wXO);
            aVar.iz(4, this.fJT);
            aVar.r(5, this.wXP);
            aVar.iz(6, this.vZF);
            aVar.iz(7, this.vFE);
            aVar.r(8, this.wXQ);
            aVar.r(9, this.vRq);
            aVar.iz(10, this.wrA);
            aVar.iz(11, this.wrB);
            AppMethodBeat.o(28646);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ptz != null) {
                ix += e.a.a.a.ix(2, this.ptz.computeSize());
            }
            int bs = ((((((((ix + e.a.a.b.b.a.bs(3, this.wXO)) + e.a.a.b.b.a.bs(4, this.fJT)) + (e.a.a.b.b.a.fv(5) + 4)) + e.a.a.b.b.a.bs(6, this.vZF)) + e.a.a.b.b.a.bs(7, this.vFE)) + (e.a.a.b.b.a.fv(8) + 4)) + (e.a.a.b.b.a.fv(9) + 4)) + e.a.a.b.b.a.bs(10, this.wrA)) + e.a.a.b.b.a.bs(11, this.wrB);
            AppMethodBeat.o(28646);
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
                AppMethodBeat.o(28646);
                throw bVar;
            }
            AppMethodBeat.o(28646);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            byp byp = (byp) objArr[1];
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
                        byp.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28646);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        byp.ptz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28646);
                    return 0;
                case 3:
                    byp.wXO = aVar3.BTU.vd();
                    AppMethodBeat.o(28646);
                    return 0;
                case 4:
                    byp.fJT = aVar3.BTU.vd();
                    AppMethodBeat.o(28646);
                    return 0;
                case 5:
                    byp.wXP = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(28646);
                    return 0;
                case 6:
                    byp.vZF = aVar3.BTU.vd();
                    AppMethodBeat.o(28646);
                    return 0;
                case 7:
                    byp.vFE = aVar3.BTU.vd();
                    AppMethodBeat.o(28646);
                    return 0;
                case 8:
                    byp.wXQ = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(28646);
                    return 0;
                case 9:
                    byp.vRq = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(28646);
                    return 0;
                case 10:
                    byp.wrA = aVar3.BTU.vd();
                    AppMethodBeat.o(28646);
                    return 0;
                case 11:
                    byp.wrB = aVar3.BTU.vd();
                    AppMethodBeat.o(28646);
                    return 0;
                default:
                    AppMethodBeat.o(28646);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28646);
            return -1;
        }
    }
}
