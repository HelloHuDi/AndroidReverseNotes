package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cmn extends a {
    public String Desc;
    public int ID;
    public SKBuiltinBuffer_t xkq;
    public SKBuiltinBuffer_t xkr;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28695);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xkq == null) {
                bVar = new b("Not all required fields were included: Icon");
                AppMethodBeat.o(28695);
                throw bVar;
            } else if (this.xkr == null) {
                bVar = new b("Not all required fields were included: HDIcon");
                AppMethodBeat.o(28695);
                throw bVar;
            } else {
                aVar.iz(1, this.ID);
                if (this.Desc != null) {
                    aVar.e(2, this.Desc);
                }
                if (this.xkq != null) {
                    aVar.iy(3, this.xkq.computeSize());
                    this.xkq.writeFields(aVar);
                }
                if (this.xkr != null) {
                    aVar.iy(4, this.xkr.computeSize());
                    this.xkr.writeFields(aVar);
                }
                AppMethodBeat.o(28695);
                return 0;
            }
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.ID) + 0;
            if (this.Desc != null) {
                bs += e.a.a.b.b.a.f(2, this.Desc);
            }
            if (this.xkq != null) {
                bs += e.a.a.a.ix(3, this.xkq.computeSize());
            }
            if (this.xkr != null) {
                bs += e.a.a.a.ix(4, this.xkr.computeSize());
            }
            AppMethodBeat.o(28695);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.xkq == null) {
                bVar = new b("Not all required fields were included: Icon");
                AppMethodBeat.o(28695);
                throw bVar;
            } else if (this.xkr == null) {
                bVar = new b("Not all required fields were included: HDIcon");
                AppMethodBeat.o(28695);
                throw bVar;
            } else {
                AppMethodBeat.o(28695);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cmn cmn = (cmn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cmn.ID = aVar3.BTU.vd();
                    AppMethodBeat.o(28695);
                    return 0;
                case 2:
                    cmn.Desc = aVar3.BTU.readString();
                    AppMethodBeat.o(28695);
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
                        cmn.xkq = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28695);
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
                        cmn.xkr = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28695);
                    return 0;
                default:
                    AppMethodBeat.o(28695);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28695);
            return -1;
        }
    }
}
