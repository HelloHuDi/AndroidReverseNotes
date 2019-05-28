package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cbu extends a {
    public int wUX;
    public int xbg;
    public LinkedList<cbb> xbh = new LinkedList();
    public int xbi;
    public int xbj;

    public cbu() {
        AppMethodBeat.i(94600);
        AppMethodBeat.o(94600);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94601);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.xbg);
            aVar.e(2, 8, this.xbh);
            aVar.iz(3, this.xbi);
            aVar.iz(4, this.wUX);
            aVar.iz(5, this.xbj);
            AppMethodBeat.o(94601);
            return 0;
        } else if (i == 1) {
            bs = ((((e.a.a.b.b.a.bs(1, this.xbg) + 0) + e.a.a.a.c(2, 8, this.xbh)) + e.a.a.b.b.a.bs(3, this.xbi)) + e.a.a.b.b.a.bs(4, this.wUX)) + e.a.a.b.b.a.bs(5, this.xbj);
            AppMethodBeat.o(94601);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xbh.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94601);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cbu cbu = (cbu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cbu.xbg = aVar3.BTU.vd();
                    AppMethodBeat.o(94601);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbb cbb = new cbb();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cbb.populateBuilderWithField(aVar4, cbb, a.getNextFieldNumber(aVar4))) {
                        }
                        cbu.xbh.add(cbb);
                    }
                    AppMethodBeat.o(94601);
                    return 0;
                case 3:
                    cbu.xbi = aVar3.BTU.vd();
                    AppMethodBeat.o(94601);
                    return 0;
                case 4:
                    cbu.wUX = aVar3.BTU.vd();
                    AppMethodBeat.o(94601);
                    return 0;
                case 5:
                    cbu.xbj = aVar3.BTU.vd();
                    AppMethodBeat.o(94601);
                    return 0;
                default:
                    AppMethodBeat.o(94601);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94601);
            return -1;
        }
    }
}
