package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class ch extends a {
    public LinkedList<b> ncU = new LinkedList();
    public cq ncV;
    public LinkedList<l> ncW = new LinkedList();
    public cm ncX;
    public LinkedList<dc> ncY = new LinkedList();

    public ch() {
        AppMethodBeat.i(111644);
        AppMethodBeat.o(111644);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111645);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.ncU);
            if (this.ncV != null) {
                aVar.iy(2, this.ncV.computeSize());
                this.ncV.writeFields(aVar);
            }
            aVar.e(3, 8, this.ncW);
            if (this.ncX != null) {
                aVar.iy(4, this.ncX.computeSize());
                this.ncX.writeFields(aVar);
            }
            aVar.e(5, 8, this.ncY);
            AppMethodBeat.o(111645);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.ncU) + 0;
            if (this.ncV != null) {
                c += e.a.a.a.ix(2, this.ncV.computeSize());
            }
            c += e.a.a.a.c(3, 8, this.ncW);
            if (this.ncX != null) {
                c += e.a.a.a.ix(4, this.ncX.computeSize());
            }
            c += e.a.a.a.c(5, 8, this.ncY);
            AppMethodBeat.o(111645);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ncU.clear();
            this.ncW.clear();
            this.ncY.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111645);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ch chVar = (ch) objArr[1];
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
                        b bVar = new b();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bVar.populateBuilderWithField(aVar4, bVar, a.getNextFieldNumber(aVar4))) {
                        }
                        chVar.ncU.add(bVar);
                    }
                    AppMethodBeat.o(111645);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cq cqVar = new cq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cqVar.populateBuilderWithField(aVar4, cqVar, a.getNextFieldNumber(aVar4))) {
                        }
                        chVar.ncV = cqVar;
                    }
                    AppMethodBeat.o(111645);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        l lVar = new l();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lVar.populateBuilderWithField(aVar4, lVar, a.getNextFieldNumber(aVar4))) {
                        }
                        chVar.ncW.add(lVar);
                    }
                    AppMethodBeat.o(111645);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cm cmVar = new cm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cmVar.populateBuilderWithField(aVar4, cmVar, a.getNextFieldNumber(aVar4))) {
                        }
                        chVar.ncX = cmVar;
                    }
                    AppMethodBeat.o(111645);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        dc dcVar = new dc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dcVar.populateBuilderWithField(aVar4, dcVar, a.getNextFieldNumber(aVar4))) {
                        }
                        chVar.ncY.add(dcVar);
                    }
                    AppMethodBeat.o(111645);
                    return 0;
                default:
                    AppMethodBeat.o(111645);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111645);
            return -1;
        }
    }
}
