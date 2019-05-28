package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cma extends a {
    public String title;
    public LinkedList<cgf> xjK = new LinkedList();
    public LinkedList<cgf> xjL = new LinkedList();
    public LinkedList<tm> xjM = new LinkedList();

    public cma() {
        AppMethodBeat.i(89150);
        AppMethodBeat.o(89150);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89151);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            aVar.e(2, 8, this.xjK);
            aVar.e(3, 8, this.xjL);
            aVar.e(4, 8, this.xjM);
            AppMethodBeat.o(89151);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = e.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                f = 0;
            }
            int c = ((f + e.a.a.a.c(2, 8, this.xjK)) + e.a.a.a.c(3, 8, this.xjL)) + e.a.a.a.c(4, 8, this.xjM);
            AppMethodBeat.o(89151);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xjK.clear();
            this.xjL.clear();
            this.xjM.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89151);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cma cma = (cma) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            cgf cgf;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cma.title = aVar3.BTU.readString();
                    AppMethodBeat.o(89151);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgf = new cgf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgf.populateBuilderWithField(aVar4, cgf, a.getNextFieldNumber(aVar4))) {
                        }
                        cma.xjK.add(cgf);
                    }
                    AppMethodBeat.o(89151);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgf = new cgf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgf.populateBuilderWithField(aVar4, cgf, a.getNextFieldNumber(aVar4))) {
                        }
                        cma.xjL.add(cgf);
                    }
                    AppMethodBeat.o(89151);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        tm tmVar = new tm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tmVar.populateBuilderWithField(aVar4, tmVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cma.xjM.add(tmVar);
                    }
                    AppMethodBeat.o(89151);
                    return 0;
                default:
                    AppMethodBeat.o(89151);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89151);
            return -1;
        }
    }
}
