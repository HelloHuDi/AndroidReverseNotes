package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cse extends a {
    public SKBuiltinBuffer_t vEF;
    public String vLX;
    public SKBuiltinBuffer_t vMb;
    public String xpA;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58940);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vMb == null) {
                bVar = new b("Not all required fields were included: KSid");
                AppMethodBeat.o(58940);
                throw bVar;
            } else if (this.vEF == null) {
                bVar = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(58940);
                throw bVar;
            } else {
                if (this.xpA != null) {
                    aVar.e(1, this.xpA);
                }
                if (this.vMb != null) {
                    aVar.iy(2, this.vMb.computeSize());
                    this.vMb.writeFields(aVar);
                }
                if (this.vLX != null) {
                    aVar.e(3, this.vLX);
                }
                if (this.vEF != null) {
                    aVar.iy(4, this.vEF.computeSize());
                    this.vEF.writeFields(aVar);
                }
                AppMethodBeat.o(58940);
                return 0;
            }
        } else if (i == 1) {
            if (this.xpA != null) {
                f = e.a.a.b.b.a.f(1, this.xpA) + 0;
            } else {
                f = 0;
            }
            if (this.vMb != null) {
                f += e.a.a.a.ix(2, this.vMb.computeSize());
            }
            if (this.vLX != null) {
                f += e.a.a.b.b.a.f(3, this.vLX);
            }
            if (this.vEF != null) {
                f += e.a.a.a.ix(4, this.vEF.computeSize());
            }
            AppMethodBeat.o(58940);
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
                AppMethodBeat.o(58940);
                throw bVar;
            } else if (this.vEF == null) {
                bVar = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(58940);
                throw bVar;
            } else {
                AppMethodBeat.o(58940);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cse cse = (cse) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cse.xpA = aVar3.BTU.readString();
                    AppMethodBeat.o(58940);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        cse.vMb = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58940);
                    return 0;
                case 3:
                    cse.vLX = aVar3.BTU.readString();
                    AppMethodBeat.o(58940);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        cse.vEF = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58940);
                    return 0;
                default:
                    AppMethodBeat.o(58940);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58940);
            return -1;
        }
    }
}
