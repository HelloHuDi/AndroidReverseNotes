package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class co extends a {
    public String nap;
    public cp ndf;
    public cp ndg;
    public cp ndh;
    public cp ndi;
    public cp ndj;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111652);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ndf != null) {
                aVar.iy(1, this.ndf.computeSize());
                this.ndf.writeFields(aVar);
            }
            if (this.ndg != null) {
                aVar.iy(2, this.ndg.computeSize());
                this.ndg.writeFields(aVar);
            }
            if (this.ndh != null) {
                aVar.iy(3, this.ndh.computeSize());
                this.ndh.writeFields(aVar);
            }
            if (this.ndi != null) {
                aVar.iy(4, this.ndi.computeSize());
                this.ndi.writeFields(aVar);
            }
            if (this.ndj != null) {
                aVar.iy(6, this.ndj.computeSize());
                this.ndj.writeFields(aVar);
            }
            if (this.nap != null) {
                aVar.e(5, this.nap);
            }
            AppMethodBeat.o(111652);
            return 0;
        } else if (i == 1) {
            if (this.ndf != null) {
                ix = e.a.a.a.ix(1, this.ndf.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ndg != null) {
                ix += e.a.a.a.ix(2, this.ndg.computeSize());
            }
            if (this.ndh != null) {
                ix += e.a.a.a.ix(3, this.ndh.computeSize());
            }
            if (this.ndi != null) {
                ix += e.a.a.a.ix(4, this.ndi.computeSize());
            }
            if (this.ndj != null) {
                ix += e.a.a.a.ix(6, this.ndj.computeSize());
            }
            if (this.nap != null) {
                ix += e.a.a.b.b.a.f(5, this.nap);
            }
            AppMethodBeat.o(111652);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111652);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            co coVar = (co) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            cp cpVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cpVar = new cp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpVar.populateBuilderWithField(aVar4, cpVar, a.getNextFieldNumber(aVar4))) {
                        }
                        coVar.ndf = cpVar;
                    }
                    AppMethodBeat.o(111652);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cpVar = new cp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpVar.populateBuilderWithField(aVar4, cpVar, a.getNextFieldNumber(aVar4))) {
                        }
                        coVar.ndg = cpVar;
                    }
                    AppMethodBeat.o(111652);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cpVar = new cp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpVar.populateBuilderWithField(aVar4, cpVar, a.getNextFieldNumber(aVar4))) {
                        }
                        coVar.ndh = cpVar;
                    }
                    AppMethodBeat.o(111652);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cpVar = new cp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpVar.populateBuilderWithField(aVar4, cpVar, a.getNextFieldNumber(aVar4))) {
                        }
                        coVar.ndi = cpVar;
                    }
                    AppMethodBeat.o(111652);
                    return 0;
                case 5:
                    coVar.nap = aVar3.BTU.readString();
                    AppMethodBeat.o(111652);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cpVar = new cp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpVar.populateBuilderWithField(aVar4, cpVar, a.getNextFieldNumber(aVar4))) {
                        }
                        coVar.ndj = cpVar;
                    }
                    AppMethodBeat.o(111652);
                    return 0;
                default:
                    AppMethodBeat.o(111652);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111652);
            return -1;
        }
    }
}
