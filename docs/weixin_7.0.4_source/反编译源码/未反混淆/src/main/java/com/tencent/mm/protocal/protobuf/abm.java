package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class abm extends a {
    public int vTN;
    public SKBuiltinBuffer_t vTO;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51413);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vTO == null) {
                bVar = new b("Not all required fields were included: KeyBuf");
                AppMethodBeat.o(51413);
                throw bVar;
            }
            aVar.iz(1, this.vTN);
            if (this.vTO != null) {
                aVar.iy(3, this.vTO.computeSize());
                this.vTO.writeFields(aVar);
            }
            AppMethodBeat.o(51413);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.vTN) + 0;
            if (this.vTO != null) {
                bs += e.a.a.a.ix(3, this.vTO.computeSize());
            }
            AppMethodBeat.o(51413);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.vTO == null) {
                bVar = new b("Not all required fields were included: KeyBuf");
                AppMethodBeat.o(51413);
                throw bVar;
            }
            AppMethodBeat.o(51413);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            abm abm = (abm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    abm.vTN = aVar3.BTU.vd();
                    AppMethodBeat.o(51413);
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
                        abm.vTO = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(51413);
                    return 0;
                default:
                    AppMethodBeat.o(51413);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51413);
            return -1;
        }
    }
}
