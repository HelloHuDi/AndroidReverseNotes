package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class csd extends a {
    public String vLX;
    public String vLY;
    public SKBuiltinBuffer_t vMb;
    public String xpA;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58939);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vMb == null) {
                bVar = new b("Not all required fields were included: KSid");
                AppMethodBeat.o(58939);
                throw bVar;
            }
            if (this.vLX != null) {
                aVar.e(1, this.vLX);
            }
            if (this.vLY != null) {
                aVar.e(2, this.vLY);
            }
            if (this.xpA != null) {
                aVar.e(3, this.xpA);
            }
            if (this.vMb != null) {
                aVar.iy(4, this.vMb.computeSize());
                this.vMb.writeFields(aVar);
            }
            AppMethodBeat.o(58939);
            return 0;
        } else if (i == 1) {
            if (this.vLX != null) {
                f = e.a.a.b.b.a.f(1, this.vLX) + 0;
            } else {
                f = 0;
            }
            if (this.vLY != null) {
                f += e.a.a.b.b.a.f(2, this.vLY);
            }
            if (this.xpA != null) {
                f += e.a.a.b.b.a.f(3, this.xpA);
            }
            if (this.vMb != null) {
                f += e.a.a.a.ix(4, this.vMb.computeSize());
            }
            AppMethodBeat.o(58939);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.vMb == null) {
                bVar = new b("Not all required fields were included: KSid");
                AppMethodBeat.o(58939);
                throw bVar;
            }
            AppMethodBeat.o(58939);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            csd csd = (csd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    csd.vLX = aVar3.BTU.readString();
                    AppMethodBeat.o(58939);
                    return 0;
                case 2:
                    csd.vLY = aVar3.BTU.readString();
                    AppMethodBeat.o(58939);
                    return 0;
                case 3:
                    csd.xpA = aVar3.BTU.readString();
                    AppMethodBeat.o(58939);
                    return 0;
                case 4:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        csd.vMb = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58939);
                    return 0;
                default:
                    AppMethodBeat.o(58939);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58939);
            return -1;
        }
    }
}
