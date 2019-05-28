package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bmj extends bsr {
    public long wOP;
    public long wOS;
    public String wPm;
    public int wPn;
    public int wPo;
    public int wem;
    public long wen;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28593);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wPm == null) {
                bVar = new b("Not all required fields were included: FromUsername");
                AppMethodBeat.o(28593);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wPm != null) {
                aVar.e(2, this.wPm);
            }
            aVar.iz(3, this.wem);
            aVar.ai(4, this.wen);
            aVar.ai(5, this.wOP);
            aVar.iz(6, this.wPn);
            aVar.ai(7, this.wOS);
            aVar.iz(8, this.wPo);
            AppMethodBeat.o(28593);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wPm != null) {
                ix += e.a.a.b.b.a.f(2, this.wPm);
            }
            int bs = (((((ix + e.a.a.b.b.a.bs(3, this.wem)) + e.a.a.b.b.a.o(4, this.wen)) + e.a.a.b.b.a.o(5, this.wOP)) + e.a.a.b.b.a.bs(6, this.wPn)) + e.a.a.b.b.a.o(7, this.wOS)) + e.a.a.b.b.a.bs(8, this.wPo);
            AppMethodBeat.o(28593);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wPm == null) {
                bVar = new b("Not all required fields were included: FromUsername");
                AppMethodBeat.o(28593);
                throw bVar;
            }
            AppMethodBeat.o(28593);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bmj bmj = (bmj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bmj.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28593);
                    return 0;
                case 2:
                    bmj.wPm = aVar3.BTU.readString();
                    AppMethodBeat.o(28593);
                    return 0;
                case 3:
                    bmj.wem = aVar3.BTU.vd();
                    AppMethodBeat.o(28593);
                    return 0;
                case 4:
                    bmj.wen = aVar3.BTU.ve();
                    AppMethodBeat.o(28593);
                    return 0;
                case 5:
                    bmj.wOP = aVar3.BTU.ve();
                    AppMethodBeat.o(28593);
                    return 0;
                case 6:
                    bmj.wPn = aVar3.BTU.vd();
                    AppMethodBeat.o(28593);
                    return 0;
                case 7:
                    bmj.wOS = aVar3.BTU.ve();
                    AppMethodBeat.o(28593);
                    return 0;
                case 8:
                    bmj.wPo = aVar3.BTU.vd();
                    AppMethodBeat.o(28593);
                    return 0;
                default:
                    AppMethodBeat.o(28593);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28593);
            return -1;
        }
    }
}
