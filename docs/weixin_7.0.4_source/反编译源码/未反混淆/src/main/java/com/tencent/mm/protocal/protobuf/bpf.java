package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bpf extends bsr {
    public bpk wRJ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28599);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wRJ == null) {
                bVar = new b("Not all required fields were included: rcptinfo");
                AppMethodBeat.o(28599);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wRJ != null) {
                aVar.iy(2, this.wRJ.computeSize());
                this.wRJ.writeFields(aVar);
            }
            AppMethodBeat.o(28599);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wRJ != null) {
                ix += e.a.a.a.ix(2, this.wRJ.computeSize());
            }
            AppMethodBeat.o(28599);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wRJ == null) {
                bVar = new b("Not all required fields were included: rcptinfo");
                AppMethodBeat.o(28599);
                throw bVar;
            }
            AppMethodBeat.o(28599);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bpf bpf = (bpf) objArr[1];
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
                        bpf.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28599);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bpk bpk = new bpk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpk.populateBuilderWithField(aVar4, bpk, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bpf.wRJ = bpk;
                    }
                    AppMethodBeat.o(28599);
                    return 0;
                default:
                    AppMethodBeat.o(28599);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28599);
            return -1;
        }
    }
}
