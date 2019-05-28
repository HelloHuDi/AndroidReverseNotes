package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cpj extends bsr {
    public SKBuiltinBuffer_t vJd;
    public int wPb;
    public int wem;
    public long wen;
    public int xmN;
    public int xmO;
    public int xmP;
    public int xmQ;
    public int xmR;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5242);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vJd == null) {
                bVar = new b("Not all required fields were included: Buffer");
                AppMethodBeat.o(5242);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.wem);
            aVar.ai(3, this.wen);
            aVar.iz(4, this.wPb);
            aVar.iz(5, this.xmN);
            aVar.iz(6, this.xmO);
            aVar.iz(7, this.xmP);
            aVar.iz(8, this.xmQ);
            aVar.iz(9, this.xmR);
            if (this.vJd != null) {
                aVar.iy(10, this.vJd.computeSize());
                this.vJd.writeFields(aVar);
            }
            AppMethodBeat.o(5242);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (((((((ix + e.a.a.b.b.a.bs(2, this.wem)) + e.a.a.b.b.a.o(3, this.wen)) + e.a.a.b.b.a.bs(4, this.wPb)) + e.a.a.b.b.a.bs(5, this.xmN)) + e.a.a.b.b.a.bs(6, this.xmO)) + e.a.a.b.b.a.bs(7, this.xmP)) + e.a.a.b.b.a.bs(8, this.xmQ)) + e.a.a.b.b.a.bs(9, this.xmR);
            if (this.vJd != null) {
                ix += e.a.a.a.ix(10, this.vJd.computeSize());
            }
            AppMethodBeat.o(5242);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.vJd == null) {
                bVar = new b("Not all required fields were included: Buffer");
                AppMethodBeat.o(5242);
                throw bVar;
            }
            AppMethodBeat.o(5242);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cpj cpj = (cpj) objArr[1];
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
                        cpj.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(5242);
                    return 0;
                case 2:
                    cpj.wem = aVar3.BTU.vd();
                    AppMethodBeat.o(5242);
                    return 0;
                case 3:
                    cpj.wen = aVar3.BTU.ve();
                    AppMethodBeat.o(5242);
                    return 0;
                case 4:
                    cpj.wPb = aVar3.BTU.vd();
                    AppMethodBeat.o(5242);
                    return 0;
                case 5:
                    cpj.xmN = aVar3.BTU.vd();
                    AppMethodBeat.o(5242);
                    return 0;
                case 6:
                    cpj.xmO = aVar3.BTU.vd();
                    AppMethodBeat.o(5242);
                    return 0;
                case 7:
                    cpj.xmP = aVar3.BTU.vd();
                    AppMethodBeat.o(5242);
                    return 0;
                case 8:
                    cpj.xmQ = aVar3.BTU.vd();
                    AppMethodBeat.o(5242);
                    return 0;
                case 9:
                    cpj.xmR = aVar3.BTU.vd();
                    AppMethodBeat.o(5242);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cpj.vJd = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(5242);
                    return 0;
                default:
                    AppMethodBeat.o(5242);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5242);
            return -1;
        }
    }
}
