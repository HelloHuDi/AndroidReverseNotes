package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cho extends a {
    public int Category;
    public String ncM;
    public int wSb;
    public LinkedList<String> wSd = new LinkedList();
    public long xgq;
    public int xgr;

    public cho() {
        AppMethodBeat.i(55704);
        AppMethodBeat.o(55704);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(55705);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ncM != null) {
                aVar.e(1, this.ncM);
            }
            aVar.ai(2, this.xgq);
            aVar.iz(3, this.wSb);
            aVar.iz(4, this.xgr);
            aVar.iz(5, this.Category);
            aVar.e(6, 1, this.wSd);
            AppMethodBeat.o(55705);
            return 0;
        } else if (i == 1) {
            if (this.ncM != null) {
                f = e.a.a.b.b.a.f(1, this.ncM) + 0;
            } else {
                f = 0;
            }
            int o = ((((f + e.a.a.b.b.a.o(2, this.xgq)) + e.a.a.b.b.a.bs(3, this.wSb)) + e.a.a.b.b.a.bs(4, this.xgr)) + e.a.a.b.b.a.bs(5, this.Category)) + e.a.a.a.c(6, 1, this.wSd);
            AppMethodBeat.o(55705);
            return o;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wSd.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(55705);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cho cho = (cho) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cho.ncM = aVar3.BTU.readString();
                    AppMethodBeat.o(55705);
                    return 0;
                case 2:
                    cho.xgq = aVar3.BTU.ve();
                    AppMethodBeat.o(55705);
                    return 0;
                case 3:
                    cho.wSb = aVar3.BTU.vd();
                    AppMethodBeat.o(55705);
                    return 0;
                case 4:
                    cho.xgr = aVar3.BTU.vd();
                    AppMethodBeat.o(55705);
                    return 0;
                case 5:
                    cho.Category = aVar3.BTU.vd();
                    AppMethodBeat.o(55705);
                    return 0;
                case 6:
                    cho.wSd.add(aVar3.BTU.readString());
                    AppMethodBeat.o(55705);
                    return 0;
                default:
                    AppMethodBeat.o(55705);
                    return -1;
            }
        } else {
            AppMethodBeat.o(55705);
            return -1;
        }
    }
}
