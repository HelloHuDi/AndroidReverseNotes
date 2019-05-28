package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class h extends a {
    public int ret;
    public int vyT;
    public int vyU;
    public o vyV;
    public o vyW;
    public int vyX;
    public int vyY;
    public int vzm;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(72825);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.ret);
            aVar.iz(2, this.vyT);
            aVar.iz(3, this.vyU);
            if (this.vyV != null) {
                aVar.iy(4, this.vyV.computeSize());
                this.vyV.writeFields(aVar);
            }
            if (this.vyW != null) {
                aVar.iy(5, this.vyW.computeSize());
                this.vyW.writeFields(aVar);
            }
            aVar.iz(6, this.vyX);
            aVar.iz(7, this.vzm);
            aVar.iz(8, this.vyY);
            AppMethodBeat.o(72825);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.ret) + 0) + e.a.a.b.b.a.bs(2, this.vyT)) + e.a.a.b.b.a.bs(3, this.vyU);
            if (this.vyV != null) {
                bs += e.a.a.a.ix(4, this.vyV.computeSize());
            }
            if (this.vyW != null) {
                bs += e.a.a.a.ix(5, this.vyW.computeSize());
            }
            bs = ((bs + e.a.a.b.b.a.bs(6, this.vyX)) + e.a.a.b.b.a.bs(7, this.vzm)) + e.a.a.b.b.a.bs(8, this.vyY);
            AppMethodBeat.o(72825);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(72825);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            h hVar = (h) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            o oVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    hVar.ret = aVar3.BTU.vd();
                    AppMethodBeat.o(72825);
                    return 0;
                case 2:
                    hVar.vyT = aVar3.BTU.vd();
                    AppMethodBeat.o(72825);
                    return 0;
                case 3:
                    hVar.vyU = aVar3.BTU.vd();
                    AppMethodBeat.o(72825);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        oVar = new o();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = oVar.populateBuilderWithField(aVar4, oVar, a.getNextFieldNumber(aVar4))) {
                        }
                        hVar.vyV = oVar;
                    }
                    AppMethodBeat.o(72825);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        oVar = new o();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = oVar.populateBuilderWithField(aVar4, oVar, a.getNextFieldNumber(aVar4))) {
                        }
                        hVar.vyW = oVar;
                    }
                    AppMethodBeat.o(72825);
                    return 0;
                case 6:
                    hVar.vyX = aVar3.BTU.vd();
                    AppMethodBeat.o(72825);
                    return 0;
                case 7:
                    hVar.vzm = aVar3.BTU.vd();
                    AppMethodBeat.o(72825);
                    return 0;
                case 8:
                    hVar.vyY = aVar3.BTU.vd();
                    AppMethodBeat.o(72825);
                    return 0;
                default:
                    AppMethodBeat.o(72825);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72825);
            return -1;
        }
    }
}
