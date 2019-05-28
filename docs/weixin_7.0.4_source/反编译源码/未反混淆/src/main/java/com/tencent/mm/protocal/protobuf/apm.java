package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class apm extends bsr {
    public String csB;
    public int cvd;
    public boolean wtw;
    public LinkedList<String> wtx = new LinkedList();

    public apm() {
        AppMethodBeat.i(102377);
        AppMethodBeat.o(102377);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(102378);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.csB != null) {
                aVar.e(2, this.csB);
            }
            aVar.aO(3, this.wtw);
            aVar.e(4, 1, this.wtx);
            aVar.iz(5, this.cvd);
            AppMethodBeat.o(102378);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.csB != null) {
                ix += e.a.a.b.b.a.f(2, this.csB);
            }
            int fv = ((ix + (e.a.a.b.b.a.fv(3) + 1)) + e.a.a.a.c(4, 1, this.wtx)) + e.a.a.b.b.a.bs(5, this.cvd);
            AppMethodBeat.o(102378);
            return fv;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wtx.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(102378);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            apm apm = (apm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        apm.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(102378);
                    return 0;
                case 2:
                    apm.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(102378);
                    return 0;
                case 3:
                    apm.wtw = aVar3.BTU.ehX();
                    AppMethodBeat.o(102378);
                    return 0;
                case 4:
                    apm.wtx.add(aVar3.BTU.readString());
                    AppMethodBeat.o(102378);
                    return 0;
                case 5:
                    apm.cvd = aVar3.BTU.vd();
                    AppMethodBeat.o(102378);
                    return 0;
                default:
                    AppMethodBeat.o(102378);
                    return -1;
            }
        } else {
            AppMethodBeat.o(102378);
            return -1;
        }
    }
}
