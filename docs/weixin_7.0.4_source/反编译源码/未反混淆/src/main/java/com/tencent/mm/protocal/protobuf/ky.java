package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ky extends bsr {
    public int Scene;
    public int fJT;
    public int vLZ;
    public int vOn;
    public SKBuiltinBuffer_t vOo;
    public int vOp;
    public int vOq;
    public int vOr;
    public int vOs;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11723);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vOo == null) {
                bVar = new b("Not all required fields were included: ImageBuffer");
                AppMethodBeat.o(11723);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.vOn);
            if (this.vOo != null) {
                aVar.iy(3, this.vOo.computeSize());
                this.vOo.writeFields(aVar);
            }
            aVar.iz(4, this.vOp);
            aVar.iz(5, this.vOq);
            aVar.iz(6, this.fJT);
            aVar.iz(7, this.vOr);
            aVar.iz(8, this.vLZ);
            aVar.iz(9, this.vOs);
            aVar.iz(10, this.Scene);
            AppMethodBeat.o(11723);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.vOn);
            if (this.vOo != null) {
                ix += e.a.a.a.ix(3, this.vOo.computeSize());
            }
            int bs = ((((((ix + e.a.a.b.b.a.bs(4, this.vOp)) + e.a.a.b.b.a.bs(5, this.vOq)) + e.a.a.b.b.a.bs(6, this.fJT)) + e.a.a.b.b.a.bs(7, this.vOr)) + e.a.a.b.b.a.bs(8, this.vLZ)) + e.a.a.b.b.a.bs(9, this.vOs)) + e.a.a.b.b.a.bs(10, this.Scene);
            AppMethodBeat.o(11723);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.vOo == null) {
                bVar = new b("Not all required fields were included: ImageBuffer");
                AppMethodBeat.o(11723);
                throw bVar;
            }
            AppMethodBeat.o(11723);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ky kyVar = (ky) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        kyVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(11723);
                    return 0;
                case 2:
                    kyVar.vOn = aVar3.BTU.vd();
                    AppMethodBeat.o(11723);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        kyVar.vOo = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(11723);
                    return 0;
                case 4:
                    kyVar.vOp = aVar3.BTU.vd();
                    AppMethodBeat.o(11723);
                    return 0;
                case 5:
                    kyVar.vOq = aVar3.BTU.vd();
                    AppMethodBeat.o(11723);
                    return 0;
                case 6:
                    kyVar.fJT = aVar3.BTU.vd();
                    AppMethodBeat.o(11723);
                    return 0;
                case 7:
                    kyVar.vOr = aVar3.BTU.vd();
                    AppMethodBeat.o(11723);
                    return 0;
                case 8:
                    kyVar.vLZ = aVar3.BTU.vd();
                    AppMethodBeat.o(11723);
                    return 0;
                case 9:
                    kyVar.vOs = aVar3.BTU.vd();
                    AppMethodBeat.o(11723);
                    return 0;
                case 10:
                    kyVar.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(11723);
                    return 0;
                default:
                    AppMethodBeat.o(11723);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11723);
            return -1;
        }
    }
}
