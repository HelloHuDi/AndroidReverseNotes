package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class vj extends bsr {
    public int Scene;
    public int ehB;
    public String vEf;
    public LinkedList<vt> vEh = new LinkedList();

    public vj() {
        AppMethodBeat.i(5572);
        AppMethodBeat.o(5572);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5573);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.ehB);
            aVar.e(3, 8, this.vEh);
            if (this.vEf != null) {
                aVar.e(4, this.vEf);
            }
            aVar.iz(5, this.Scene);
            AppMethodBeat.o(5573);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.ehB)) + e.a.a.a.c(3, 8, this.vEh);
            if (this.vEf != null) {
                ix += e.a.a.b.b.a.f(4, this.vEf);
            }
            int bs = ix + e.a.a.b.b.a.bs(5, this.Scene);
            AppMethodBeat.o(5573);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vEh.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(5573);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            vj vjVar = (vj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
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
                        vjVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(5573);
                    return 0;
                case 2:
                    vjVar.ehB = aVar3.BTU.vd();
                    AppMethodBeat.o(5573);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        vt vtVar = new vt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vtVar.populateBuilderWithField(aVar4, vtVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        vjVar.vEh.add(vtVar);
                    }
                    AppMethodBeat.o(5573);
                    return 0;
                case 4:
                    vjVar.vEf = aVar3.BTU.readString();
                    AppMethodBeat.o(5573);
                    return 0;
                case 5:
                    vjVar.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(5573);
                    return 0;
                default:
                    AppMethodBeat.o(5573);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5573);
            return -1;
        }
    }
}
