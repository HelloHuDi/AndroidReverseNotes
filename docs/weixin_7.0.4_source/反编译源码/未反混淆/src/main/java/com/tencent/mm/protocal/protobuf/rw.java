package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class rw extends a {
    public int jCt;
    public LinkedList<String> vZh = new LinkedList();
    public String vZi;
    public long vZj;

    public rw() {
        AppMethodBeat.i(14717);
        AppMethodBeat.o(14717);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14718);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.jCt);
            aVar.e(2, 1, this.vZh);
            if (this.vZi != null) {
                aVar.e(3, this.vZi);
            }
            aVar.ai(4, this.vZj);
            AppMethodBeat.o(14718);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.jCt) + 0) + e.a.a.a.c(2, 1, this.vZh);
            if (this.vZi != null) {
                bs += e.a.a.b.b.a.f(3, this.vZi);
            }
            bs += e.a.a.b.b.a.o(4, this.vZj);
            AppMethodBeat.o(14718);
            return bs;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.vZh.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(14718);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            rw rwVar = (rw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    rwVar.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(14718);
                    return 0;
                case 2:
                    rwVar.vZh.add(aVar3.BTU.readString());
                    AppMethodBeat.o(14718);
                    return 0;
                case 3:
                    rwVar.vZi = aVar3.BTU.readString();
                    AppMethodBeat.o(14718);
                    return 0;
                case 4:
                    rwVar.vZj = aVar3.BTU.ve();
                    AppMethodBeat.o(14718);
                    return 0;
                default:
                    AppMethodBeat.o(14718);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14718);
            return -1;
        }
    }
}
