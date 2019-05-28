package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class gs extends a {
    public String ID;
    public int Ret;
    public SKBuiltinBuffer_t vIT;
    public String vIU;
    public int vIV;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28331);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vIT == null) {
                bVar = new b("Not all required fields were included: QRCodeBuffer");
                AppMethodBeat.o(28331);
                throw bVar;
            }
            aVar.iz(1, this.Ret);
            if (this.vIT != null) {
                aVar.iy(2, this.vIT.computeSize());
                this.vIT.writeFields(aVar);
            }
            if (this.vIU != null) {
                aVar.e(3, this.vIU);
            }
            aVar.iz(4, this.vIV);
            if (this.ID != null) {
                aVar.e(5, this.ID);
            }
            AppMethodBeat.o(28331);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.Ret) + 0;
            if (this.vIT != null) {
                bs += e.a.a.a.ix(2, this.vIT.computeSize());
            }
            if (this.vIU != null) {
                bs += e.a.a.b.b.a.f(3, this.vIU);
            }
            bs += e.a.a.b.b.a.bs(4, this.vIV);
            if (this.ID != null) {
                bs += e.a.a.b.b.a.f(5, this.ID);
            }
            AppMethodBeat.o(28331);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.vIT == null) {
                bVar = new b("Not all required fields were included: QRCodeBuffer");
                AppMethodBeat.o(28331);
                throw bVar;
            }
            AppMethodBeat.o(28331);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            gs gsVar = (gs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    gsVar.Ret = aVar3.BTU.vd();
                    AppMethodBeat.o(28331);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        gsVar.vIT = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28331);
                    return 0;
                case 3:
                    gsVar.vIU = aVar3.BTU.readString();
                    AppMethodBeat.o(28331);
                    return 0;
                case 4:
                    gsVar.vIV = aVar3.BTU.vd();
                    AppMethodBeat.o(28331);
                    return 0;
                case 5:
                    gsVar.ID = aVar3.BTU.readString();
                    AppMethodBeat.o(28331);
                    return 0;
                default:
                    AppMethodBeat.o(28331);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28331);
            return -1;
        }
    }
}
