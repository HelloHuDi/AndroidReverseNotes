package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class fc extends a {
    public int OpCode;
    public String fKh;
    public int vHa;
    public int vHb;
    public fh vHc;
    public fb vHd;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28314);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fKh == null) {
                bVar = new b("Not all required fields were included: AppId");
                AppMethodBeat.o(28314);
                throw bVar;
            }
            aVar.iz(1, this.OpCode);
            if (this.fKh != null) {
                aVar.e(2, this.fKh);
            }
            aVar.iz(3, this.vHa);
            aVar.iz(4, this.vHb);
            if (this.vHc != null) {
                aVar.iy(5, this.vHc.computeSize());
                this.vHc.writeFields(aVar);
            }
            if (this.vHd != null) {
                aVar.iy(6, this.vHd.computeSize());
                this.vHd.writeFields(aVar);
            }
            AppMethodBeat.o(28314);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.OpCode) + 0;
            if (this.fKh != null) {
                bs += e.a.a.b.b.a.f(2, this.fKh);
            }
            bs = (bs + e.a.a.b.b.a.bs(3, this.vHa)) + e.a.a.b.b.a.bs(4, this.vHb);
            if (this.vHc != null) {
                bs += e.a.a.a.ix(5, this.vHc.computeSize());
            }
            if (this.vHd != null) {
                bs += e.a.a.a.ix(6, this.vHd.computeSize());
            }
            AppMethodBeat.o(28314);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.fKh == null) {
                bVar = new b("Not all required fields were included: AppId");
                AppMethodBeat.o(28314);
                throw bVar;
            }
            AppMethodBeat.o(28314);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            fc fcVar = (fc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    fcVar.OpCode = aVar3.BTU.vd();
                    AppMethodBeat.o(28314);
                    return 0;
                case 2:
                    fcVar.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(28314);
                    return 0;
                case 3:
                    fcVar.vHa = aVar3.BTU.vd();
                    AppMethodBeat.o(28314);
                    return 0;
                case 4:
                    fcVar.vHb = aVar3.BTU.vd();
                    AppMethodBeat.o(28314);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        fh fhVar = new fh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.populateBuilderWithField(aVar4, fhVar, a.getNextFieldNumber(aVar4))) {
                        }
                        fcVar.vHc = fhVar;
                    }
                    AppMethodBeat.o(28314);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        fb fbVar = new fb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fbVar.populateBuilderWithField(aVar4, fbVar, a.getNextFieldNumber(aVar4))) {
                        }
                        fcVar.vHd = fbVar;
                    }
                    AppMethodBeat.o(28314);
                    return 0;
                default:
                    AppMethodBeat.o(28314);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28314);
            return -1;
        }
    }
}
