package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bek extends a {
    public int Ret;
    public int jBT;
    public int vQe;
    public SKBuiltinBuffer_t vTO;
    public tc vTR;
    public int wIy;
    public int wIz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58923);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vTR == null) {
                bVar = new b("Not all required fields were included: CmdList");
                AppMethodBeat.o(58923);
                throw bVar;
            } else if (this.vTO == null) {
                bVar = new b("Not all required fields were included: KeyBuf");
                AppMethodBeat.o(58923);
                throw bVar;
            } else {
                aVar.iz(1, this.Ret);
                if (this.vTR != null) {
                    aVar.iy(2, this.vTR.computeSize());
                    this.vTR.writeFields(aVar);
                }
                aVar.iz(3, this.vQe);
                if (this.vTO != null) {
                    aVar.iy(4, this.vTO.computeSize());
                    this.vTO.writeFields(aVar);
                }
                aVar.iz(5, this.jBT);
                aVar.iz(6, this.wIy);
                aVar.iz(7, this.wIz);
                AppMethodBeat.o(58923);
                return 0;
            }
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.Ret) + 0;
            if (this.vTR != null) {
                bs += e.a.a.a.ix(2, this.vTR.computeSize());
            }
            bs += e.a.a.b.b.a.bs(3, this.vQe);
            if (this.vTO != null) {
                bs += e.a.a.a.ix(4, this.vTO.computeSize());
            }
            bs = ((bs + e.a.a.b.b.a.bs(5, this.jBT)) + e.a.a.b.b.a.bs(6, this.wIy)) + e.a.a.b.b.a.bs(7, this.wIz);
            AppMethodBeat.o(58923);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.vTR == null) {
                bVar = new b("Not all required fields were included: CmdList");
                AppMethodBeat.o(58923);
                throw bVar;
            } else if (this.vTO == null) {
                bVar = new b("Not all required fields were included: KeyBuf");
                AppMethodBeat.o(58923);
                throw bVar;
            } else {
                AppMethodBeat.o(58923);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bek bek = (bek) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bek.Ret = aVar3.BTU.vd();
                    AppMethodBeat.o(58923);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        tc tcVar = new tc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tcVar.populateBuilderWithField(aVar4, tcVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bek.vTR = tcVar;
                    }
                    AppMethodBeat.o(58923);
                    return 0;
                case 3:
                    bek.vQe = aVar3.BTU.vd();
                    AppMethodBeat.o(58923);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        bek.vTO = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58923);
                    return 0;
                case 5:
                    bek.jBT = aVar3.BTU.vd();
                    AppMethodBeat.o(58923);
                    return 0;
                case 6:
                    bek.wIy = aVar3.BTU.vd();
                    AppMethodBeat.o(58923);
                    return 0;
                case 7:
                    bek.wIz = aVar3.BTU.vd();
                    AppMethodBeat.o(58923);
                    return 0;
                default:
                    AppMethodBeat.o(58923);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58923);
            return -1;
        }
    }
}
