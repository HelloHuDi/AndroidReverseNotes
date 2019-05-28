package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cod extends a {
    public int fJT;
    public String vZx;
    public SKBuiltinBuffer_t xiP;
    public int xlD;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(116817);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xiP == null) {
                bVar = new b("Not all required fields were included: Text");
                AppMethodBeat.o(116817);
                throw bVar;
            }
            if (this.xiP != null) {
                aVar.iy(1, this.xiP.computeSize());
                this.xiP.writeFields(aVar);
            }
            if (this.vZx != null) {
                aVar.e(2, this.vZx);
            }
            aVar.iz(3, this.fJT);
            aVar.iz(4, this.xlD);
            AppMethodBeat.o(116817);
            return 0;
        } else if (i == 1) {
            if (this.xiP != null) {
                ix = e.a.a.a.ix(1, this.xiP.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vZx != null) {
                ix += e.a.a.b.b.a.f(2, this.vZx);
            }
            int bs = (ix + e.a.a.b.b.a.bs(3, this.fJT)) + e.a.a.b.b.a.bs(4, this.xlD);
            AppMethodBeat.o(116817);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.xiP == null) {
                bVar = new b("Not all required fields were included: Text");
                AppMethodBeat.o(116817);
                throw bVar;
            }
            AppMethodBeat.o(116817);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cod cod = (cod) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        cod.xiP = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(116817);
                    return 0;
                case 2:
                    cod.vZx = aVar3.BTU.readString();
                    AppMethodBeat.o(116817);
                    return 0;
                case 3:
                    cod.fJT = aVar3.BTU.vd();
                    AppMethodBeat.o(116817);
                    return 0;
                case 4:
                    cod.xlD = aVar3.BTU.vd();
                    AppMethodBeat.o(116817);
                    return 0;
                default:
                    AppMethodBeat.o(116817);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116817);
            return -1;
        }
    }
}
