package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cbb extends a {
    public int pcX;
    public String vHl;
    public SKBuiltinBuffer_t wZK;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94576);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wZK == null) {
                bVar = new b("Not all required fields were included: HBBuffer");
                AppMethodBeat.o(94576);
                throw bVar;
            }
            if (this.vHl != null) {
                aVar.e(1, this.vHl);
            }
            aVar.iz(2, this.pcX);
            if (this.wZK != null) {
                aVar.iy(3, this.wZK.computeSize());
                this.wZK.writeFields(aVar);
            }
            AppMethodBeat.o(94576);
            return 0;
        } else if (i == 1) {
            if (this.vHl != null) {
                f = e.a.a.b.b.a.f(1, this.vHl) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.pcX);
            if (this.wZK != null) {
                f += e.a.a.a.ix(3, this.wZK.computeSize());
            }
            AppMethodBeat.o(94576);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.wZK == null) {
                bVar = new b("Not all required fields were included: HBBuffer");
                AppMethodBeat.o(94576);
                throw bVar;
            }
            AppMethodBeat.o(94576);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cbb cbb = (cbb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cbb.vHl = aVar3.BTU.readString();
                    AppMethodBeat.o(94576);
                    return 0;
                case 2:
                    cbb.pcX = aVar3.BTU.vd();
                    AppMethodBeat.o(94576);
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
                        cbb.wZK = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(94576);
                    return 0;
                default:
                    AppMethodBeat.o(94576);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94576);
            return -1;
        }
    }
}
