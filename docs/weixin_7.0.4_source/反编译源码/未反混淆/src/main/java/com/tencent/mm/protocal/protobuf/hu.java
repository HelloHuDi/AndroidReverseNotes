package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class hu extends a {
    public int ReqType;
    public int vIK;
    public int vKj;
    public LinkedList<String> vKk = new LinkedList();

    public hu() {
        AppMethodBeat.i(62519);
        AppMethodBeat.o(62519);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62520);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vKj);
            aVar.iz(2, this.ReqType);
            aVar.e(3, 1, this.vKk);
            aVar.iz(4, this.vIK);
            AppMethodBeat.o(62520);
            return 0;
        } else if (i == 1) {
            bs = (((e.a.a.b.b.a.bs(1, this.vKj) + 0) + e.a.a.b.b.a.bs(2, this.ReqType)) + e.a.a.a.c(3, 1, this.vKk)) + e.a.a.b.b.a.bs(4, this.vIK);
            AppMethodBeat.o(62520);
            return bs;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.vKk.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(62520);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            hu huVar = (hu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    huVar.vKj = aVar3.BTU.vd();
                    AppMethodBeat.o(62520);
                    return 0;
                case 2:
                    huVar.ReqType = aVar3.BTU.vd();
                    AppMethodBeat.o(62520);
                    return 0;
                case 3:
                    huVar.vKk.add(aVar3.BTU.readString());
                    AppMethodBeat.o(62520);
                    return 0;
                case 4:
                    huVar.vIK = aVar3.BTU.vd();
                    AppMethodBeat.o(62520);
                    return 0;
                default:
                    AppMethodBeat.o(62520);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62520);
            return -1;
        }
    }
}
