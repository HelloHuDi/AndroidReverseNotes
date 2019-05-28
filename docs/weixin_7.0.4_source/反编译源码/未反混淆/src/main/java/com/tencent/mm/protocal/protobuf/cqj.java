package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cqj extends bsr {
    public int vTN;
    public SKBuiltinBuffer_t vTO;
    public String wPm;
    public int wem;
    public long wen;
    public long xlQ;
    public cpg xoq;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5279);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vTO == null) {
                bVar = new b("Not all required fields were included: KeyBuf");
                AppMethodBeat.o(5279);
                throw bVar;
            } else if (this.xoq == null) {
                bVar = new b("Not all required fields were included: OpLog");
                AppMethodBeat.o(5279);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.wPm != null) {
                    aVar.e(2, this.wPm);
                }
                aVar.iz(3, this.wem);
                if (this.vTO != null) {
                    aVar.iy(4, this.vTO.computeSize());
                    this.vTO.writeFields(aVar);
                }
                if (this.xoq != null) {
                    aVar.iy(5, this.xoq.computeSize());
                    this.xoq.writeFields(aVar);
                }
                aVar.ai(6, this.wen);
                aVar.iz(7, this.vTN);
                aVar.ai(8, this.xlQ);
                AppMethodBeat.o(5279);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wPm != null) {
                ix += e.a.a.b.b.a.f(2, this.wPm);
            }
            ix += e.a.a.b.b.a.bs(3, this.wem);
            if (this.vTO != null) {
                ix += e.a.a.a.ix(4, this.vTO.computeSize());
            }
            if (this.xoq != null) {
                ix += e.a.a.a.ix(5, this.xoq.computeSize());
            }
            int o = ((ix + e.a.a.b.b.a.o(6, this.wen)) + e.a.a.b.b.a.bs(7, this.vTN)) + e.a.a.b.b.a.o(8, this.xlQ);
            AppMethodBeat.o(5279);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.vTO == null) {
                bVar = new b("Not all required fields were included: KeyBuf");
                AppMethodBeat.o(5279);
                throw bVar;
            } else if (this.xoq == null) {
                bVar = new b("Not all required fields were included: OpLog");
                AppMethodBeat.o(5279);
                throw bVar;
            } else {
                AppMethodBeat.o(5279);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cqj cqj = (cqj) objArr[1];
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
                        cqj.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(5279);
                    return 0;
                case 2:
                    cqj.wPm = aVar3.BTU.readString();
                    AppMethodBeat.o(5279);
                    return 0;
                case 3:
                    cqj.wem = aVar3.BTU.vd();
                    AppMethodBeat.o(5279);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cqj.vTO = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(5279);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cpg cpg = new cpg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpg.populateBuilderWithField(aVar4, cpg, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cqj.xoq = cpg;
                    }
                    AppMethodBeat.o(5279);
                    return 0;
                case 6:
                    cqj.wen = aVar3.BTU.ve();
                    AppMethodBeat.o(5279);
                    return 0;
                case 7:
                    cqj.vTN = aVar3.BTU.vd();
                    AppMethodBeat.o(5279);
                    return 0;
                case 8:
                    cqj.xlQ = aVar3.BTU.ve();
                    AppMethodBeat.o(5279);
                    return 0;
                default:
                    AppMethodBeat.o(5279);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5279);
            return -1;
        }
    }
}
