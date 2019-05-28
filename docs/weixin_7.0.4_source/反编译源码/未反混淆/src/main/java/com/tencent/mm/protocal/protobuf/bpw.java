package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bpw extends a {
    public int Category;
    public int wSb;
    public int wSc;
    public LinkedList<String> wSd = new LinkedList();
    public int wSe;

    public bpw() {
        AppMethodBeat.i(124334);
        AppMethodBeat.o(124334);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124335);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wSb);
            aVar.iz(2, this.wSc);
            aVar.iz(3, this.Category);
            aVar.e(4, 1, this.wSd);
            aVar.iz(5, this.wSe);
            AppMethodBeat.o(124335);
            return 0;
        } else if (i == 1) {
            bs = ((((e.a.a.b.b.a.bs(1, this.wSb) + 0) + e.a.a.b.b.a.bs(2, this.wSc)) + e.a.a.b.b.a.bs(3, this.Category)) + e.a.a.a.c(4, 1, this.wSd)) + e.a.a.b.b.a.bs(5, this.wSe);
            AppMethodBeat.o(124335);
            return bs;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wSd.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124335);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bpw bpw = (bpw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bpw.wSb = aVar3.BTU.vd();
                    AppMethodBeat.o(124335);
                    return 0;
                case 2:
                    bpw.wSc = aVar3.BTU.vd();
                    AppMethodBeat.o(124335);
                    return 0;
                case 3:
                    bpw.Category = aVar3.BTU.vd();
                    AppMethodBeat.o(124335);
                    return 0;
                case 4:
                    bpw.wSd.add(aVar3.BTU.readString());
                    AppMethodBeat.o(124335);
                    return 0;
                case 5:
                    bpw.wSe = aVar3.BTU.vd();
                    AppMethodBeat.o(124335);
                    return 0;
                default:
                    AppMethodBeat.o(124335);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124335);
            return -1;
        }
    }
}
