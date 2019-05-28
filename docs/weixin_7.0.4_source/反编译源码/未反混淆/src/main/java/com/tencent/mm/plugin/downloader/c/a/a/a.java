package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bsr;
import com.tencent.mm.protocal.protobuf.hl;
import java.util.LinkedList;

public final class a extends bsr {
    public LinkedList<String> kKk = new LinkedList();
    public boolean kKl;
    public boolean kKm;
    public boolean kKn;

    public a() {
        AppMethodBeat.i(35506);
        AppMethodBeat.o(35506);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(35507);
        int ix;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 1, this.kKk);
            aVar.aO(3, this.kKl);
            aVar.aO(4, this.kKm);
            aVar.aO(5, this.kKn);
            AppMethodBeat.o(35507);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int c = (((ix + e.a.a.a.c(2, 1, this.kKk)) + (e.a.a.b.b.a.fv(3) + 1)) + (e.a.a.b.b.a.fv(4) + 1)) + (e.a.a.b.b.a.fv(5) + 1);
            AppMethodBeat.o(35507);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.kKk.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(35507);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar5 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar5, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar5))) {
                        }
                        aVar4.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(35507);
                    return 0;
                case 2:
                    aVar4.kKk.add(aVar3.BTU.readString());
                    AppMethodBeat.o(35507);
                    return 0;
                case 3:
                    aVar4.kKl = aVar3.BTU.ehX();
                    AppMethodBeat.o(35507);
                    return 0;
                case 4:
                    aVar4.kKm = aVar3.BTU.ehX();
                    AppMethodBeat.o(35507);
                    return 0;
                case 5:
                    aVar4.kKn = aVar3.BTU.ehX();
                    AppMethodBeat.o(35507);
                    return 0;
                default:
                    AppMethodBeat.o(35507);
                    return -1;
            }
        } else {
            AppMethodBeat.o(35507);
            return -1;
        }
    }
}
