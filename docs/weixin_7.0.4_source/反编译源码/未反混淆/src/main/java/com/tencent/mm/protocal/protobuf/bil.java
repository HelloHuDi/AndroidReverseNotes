package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bil extends a {
    public int uin;
    public int version;
    public SKBuiltinBuffer_t wLO;
    public int wLP;
    public SKBuiltinBuffer_t wLQ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51770);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.uin);
            aVar.iz(2, this.version);
            if (this.wLO != null) {
                aVar.iy(3, this.wLO.computeSize());
                this.wLO.writeFields(aVar);
            }
            aVar.iz(4, this.wLP);
            if (this.wLQ != null) {
                aVar.iy(5, this.wLQ.computeSize());
                this.wLQ.writeFields(aVar);
            }
            AppMethodBeat.o(51770);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.uin) + 0) + e.a.a.b.b.a.bs(2, this.version);
            if (this.wLO != null) {
                bs += e.a.a.a.ix(3, this.wLO.computeSize());
            }
            bs += e.a.a.b.b.a.bs(4, this.wLP);
            if (this.wLQ != null) {
                bs += e.a.a.a.ix(5, this.wLQ.computeSize());
            }
            AppMethodBeat.o(51770);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(51770);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bil bil = (bil) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bil.uin = aVar3.BTU.vd();
                    AppMethodBeat.o(51770);
                    return 0;
                case 2:
                    bil.version = aVar3.BTU.vd();
                    AppMethodBeat.o(51770);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        bil.wLO = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(51770);
                    return 0;
                case 4:
                    bil.wLP = aVar3.BTU.vd();
                    AppMethodBeat.o(51770);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        bil.wLQ = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(51770);
                    return 0;
                default:
                    AppMethodBeat.o(51770);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51770);
            return -1;
        }
    }
}
