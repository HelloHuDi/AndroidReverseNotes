package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ces extends a {
    public int nbk;
    public long xdq;
    public SKBuiltinBuffer_t xet;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56536);
        b bVar;
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xet == null) {
                bVar = new b("Not all required fields were included: OpContent");
                AppMethodBeat.o(56536);
                throw bVar;
            }
            aVar.ai(1, this.xdq);
            aVar.iz(2, this.nbk);
            if (this.xet != null) {
                aVar.iy(3, this.xet.computeSize());
                this.xet.writeFields(aVar);
            }
            AppMethodBeat.o(56536);
            return 0;
        } else if (i == 1) {
            o = (e.a.a.b.b.a.o(1, this.xdq) + 0) + e.a.a.b.b.a.bs(2, this.nbk);
            if (this.xet != null) {
                o += e.a.a.a.ix(3, this.xet.computeSize());
            }
            AppMethodBeat.o(56536);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            if (this.xet == null) {
                bVar = new b("Not all required fields were included: OpContent");
                AppMethodBeat.o(56536);
                throw bVar;
            }
            AppMethodBeat.o(56536);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ces ces = (ces) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ces.xdq = aVar3.BTU.ve();
                    AppMethodBeat.o(56536);
                    return 0;
                case 2:
                    ces.nbk = aVar3.BTU.vd();
                    AppMethodBeat.o(56536);
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
                        ces.xet = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(56536);
                    return 0;
                default:
                    AppMethodBeat.o(56536);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56536);
            return -1;
        }
    }
}
