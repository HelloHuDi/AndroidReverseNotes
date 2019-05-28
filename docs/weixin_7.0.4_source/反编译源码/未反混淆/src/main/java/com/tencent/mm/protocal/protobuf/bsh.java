package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bsh extends bsr {
    public long rUb;
    public LinkedList<bqk> wUm = new LinkedList();

    public bsh() {
        AppMethodBeat.i(108902);
        AppMethodBeat.o(108902);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(108903);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.ai(2, this.rUb);
            aVar.e(3, 8, this.wUm);
            AppMethodBeat.o(108903);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int o = (ix + e.a.a.b.b.a.o(2, this.rUb)) + e.a.a.a.c(3, 8, this.wUm);
            AppMethodBeat.o(108903);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wUm.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(108903);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bsh bsh = (bsh) objArr[1];
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
                        bsh.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(108903);
                    return 0;
                case 2:
                    bsh.rUb = aVar3.BTU.ve();
                    AppMethodBeat.o(108903);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bqk bqk = new bqk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqk.populateBuilderWithField(aVar4, bqk, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bsh.wUm.add(bqk);
                    }
                    AppMethodBeat.o(108903);
                    return 0;
                default:
                    AppMethodBeat.o(108903);
                    return -1;
            }
        } else {
            AppMethodBeat.o(108903);
            return -1;
        }
    }
}
