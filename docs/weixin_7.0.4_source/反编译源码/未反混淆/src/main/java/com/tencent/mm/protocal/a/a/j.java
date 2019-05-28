package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class j extends a {
    public int ret;
    public int vyT;
    public int vyU;
    public o vyV;
    public o vyW;
    public int vyX;
    public int vyY;
    public int vzh;
    public o vzi;
    public int vzm;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(72828);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.ret);
            aVar.iz(2, this.vyT);
            aVar.iz(3, this.vyU);
            aVar.iz(4, this.vzh);
            if (this.vyV != null) {
                aVar.iy(5, this.vyV.computeSize());
                this.vyV.writeFields(aVar);
            }
            if (this.vyW != null) {
                aVar.iy(6, this.vyW.computeSize());
                this.vyW.writeFields(aVar);
            }
            if (this.vzi != null) {
                aVar.iy(7, this.vzi.computeSize());
                this.vzi.writeFields(aVar);
            }
            aVar.iz(8, this.vyX);
            aVar.iz(9, this.vzm);
            aVar.iz(10, this.vyY);
            AppMethodBeat.o(72828);
            return 0;
        } else if (i == 1) {
            bs = (((e.a.a.b.b.a.bs(1, this.ret) + 0) + e.a.a.b.b.a.bs(2, this.vyT)) + e.a.a.b.b.a.bs(3, this.vyU)) + e.a.a.b.b.a.bs(4, this.vzh);
            if (this.vyV != null) {
                bs += e.a.a.a.ix(5, this.vyV.computeSize());
            }
            if (this.vyW != null) {
                bs += e.a.a.a.ix(6, this.vyW.computeSize());
            }
            if (this.vzi != null) {
                bs += e.a.a.a.ix(7, this.vzi.computeSize());
            }
            bs = ((bs + e.a.a.b.b.a.bs(8, this.vyX)) + e.a.a.b.b.a.bs(9, this.vzm)) + e.a.a.b.b.a.bs(10, this.vyY);
            AppMethodBeat.o(72828);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(72828);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            j jVar = (j) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            o oVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    jVar.ret = aVar3.BTU.vd();
                    AppMethodBeat.o(72828);
                    return 0;
                case 2:
                    jVar.vyT = aVar3.BTU.vd();
                    AppMethodBeat.o(72828);
                    return 0;
                case 3:
                    jVar.vyU = aVar3.BTU.vd();
                    AppMethodBeat.o(72828);
                    return 0;
                case 4:
                    jVar.vzh = aVar3.BTU.vd();
                    AppMethodBeat.o(72828);
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
                        jVar.vyV = oVar;
                    }
                    AppMethodBeat.o(72828);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        oVar = new o();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = oVar.populateBuilderWithField(aVar4, oVar, a.getNextFieldNumber(aVar4))) {
                        }
                        jVar.vyW = oVar;
                    }
                    AppMethodBeat.o(72828);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        oVar = new o();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = oVar.populateBuilderWithField(aVar4, oVar, a.getNextFieldNumber(aVar4))) {
                        }
                        jVar.vzi = oVar;
                    }
                    AppMethodBeat.o(72828);
                    return 0;
                case 8:
                    jVar.vyX = aVar3.BTU.vd();
                    AppMethodBeat.o(72828);
                    return 0;
                case 9:
                    jVar.vzm = aVar3.BTU.vd();
                    AppMethodBeat.o(72828);
                    return 0;
                case 10:
                    jVar.vyY = aVar3.BTU.vd();
                    AppMethodBeat.o(72828);
                    return 0;
                default:
                    AppMethodBeat.o(72828);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72828);
            return -1;
        }
    }
}
