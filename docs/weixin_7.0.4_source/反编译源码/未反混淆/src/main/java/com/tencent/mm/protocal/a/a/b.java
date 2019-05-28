package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class b extends a {
    public int nettype;
    public int uin;
    public int vyR;
    public LinkedList<a> vyS = new LinkedList();

    public b() {
        AppMethodBeat.i(72816);
        AppMethodBeat.o(72816);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(72817);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.uin);
            aVar.iz(2, this.vyR);
            aVar.e(3, 8, this.vyS);
            aVar.iz(4, this.nettype);
            AppMethodBeat.o(72817);
            return 0;
        } else if (i == 1) {
            bs = (((e.a.a.b.b.a.bs(1, this.uin) + 0) + e.a.a.b.b.a.bs(2, this.vyR)) + e.a.a.a.c(3, 8, this.vyS)) + e.a.a.b.b.a.bs(4, this.nettype);
            AppMethodBeat.o(72817);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vyS.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(72817);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bVar.uin = aVar3.BTU.vd();
                    AppMethodBeat.o(72817);
                    return 0;
                case 2:
                    bVar.vyR = aVar3.BTU.vd();
                    AppMethodBeat.o(72817);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        a aVar4 = new a();
                        e.a.a.a.a aVar5 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = aVar4.populateBuilderWithField(aVar5, aVar4, a.getNextFieldNumber(aVar5))) {
                        }
                        bVar.vyS.add(aVar4);
                    }
                    AppMethodBeat.o(72817);
                    return 0;
                case 4:
                    bVar.nettype = aVar3.BTU.vd();
                    AppMethodBeat.o(72817);
                    return 0;
                default:
                    AppMethodBeat.o(72817);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72817);
            return -1;
        }
    }
}
