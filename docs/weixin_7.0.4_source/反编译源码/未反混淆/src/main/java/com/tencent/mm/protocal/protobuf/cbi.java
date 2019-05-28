package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cbi extends a {
    public int nbk;
    public long vQE;
    public SKBuiltinBuffer_t wLt;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94585);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.vQE);
            aVar.iz(2, this.nbk);
            if (this.wLt != null) {
                aVar.iy(3, this.wLt.computeSize());
                this.wLt.writeFields(aVar);
            }
            AppMethodBeat.o(94585);
            return 0;
        } else if (i == 1) {
            o = (e.a.a.b.b.a.o(1, this.vQE) + 0) + e.a.a.b.b.a.bs(2, this.nbk);
            if (this.wLt != null) {
                o += e.a.a.a.ix(3, this.wLt.computeSize());
            }
            AppMethodBeat.o(94585);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94585);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cbi cbi = (cbi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cbi.vQE = aVar3.BTU.ve();
                    AppMethodBeat.o(94585);
                    return 0;
                case 2:
                    cbi.nbk = aVar3.BTU.vd();
                    AppMethodBeat.o(94585);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        cbi.wLt = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(94585);
                    return 0;
                default:
                    AppMethodBeat.o(94585);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94585);
            return -1;
        }
    }
}
