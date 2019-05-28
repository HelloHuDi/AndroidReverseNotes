package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class ui extends a {
    public int state;
    public cgv vCN;
    public String vJS;
    public LinkedList<cgv> vTB = new LinkedList();
    public LinkedList<cgv> wbU = new LinkedList();
    public String wbV;

    public ui() {
        AppMethodBeat.i(48826);
        AppMethodBeat.o(48826);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48827);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.state);
            if (this.vCN != null) {
                aVar.iy(2, this.vCN.computeSize());
                this.vCN.writeFields(aVar);
            }
            aVar.e(3, 8, this.vTB);
            aVar.e(4, 8, this.wbU);
            if (this.wbV != null) {
                aVar.e(5, this.wbV);
            }
            if (this.vJS != null) {
                aVar.e(6, this.vJS);
            }
            AppMethodBeat.o(48827);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.state) + 0;
            if (this.vCN != null) {
                bs += e.a.a.a.ix(2, this.vCN.computeSize());
            }
            bs = (bs + e.a.a.a.c(3, 8, this.vTB)) + e.a.a.a.c(4, 8, this.wbU);
            if (this.wbV != null) {
                bs += e.a.a.b.b.a.f(5, this.wbV);
            }
            if (this.vJS != null) {
                bs += e.a.a.b.b.a.f(6, this.vJS);
            }
            AppMethodBeat.o(48827);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vTB.clear();
            this.wbU.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48827);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ui uiVar = (ui) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            cgv cgv;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    uiVar.state = aVar3.BTU.vd();
                    AppMethodBeat.o(48827);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv = new cgv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(aVar4, cgv, a.getNextFieldNumber(aVar4))) {
                        }
                        uiVar.vCN = cgv;
                    }
                    AppMethodBeat.o(48827);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv = new cgv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(aVar4, cgv, a.getNextFieldNumber(aVar4))) {
                        }
                        uiVar.vTB.add(cgv);
                    }
                    AppMethodBeat.o(48827);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv = new cgv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(aVar4, cgv, a.getNextFieldNumber(aVar4))) {
                        }
                        uiVar.wbU.add(cgv);
                    }
                    AppMethodBeat.o(48827);
                    return 0;
                case 5:
                    uiVar.wbV = aVar3.BTU.readString();
                    AppMethodBeat.o(48827);
                    return 0;
                case 6:
                    uiVar.vJS = aVar3.BTU.readString();
                    AppMethodBeat.o(48827);
                    return 0;
                default:
                    AppMethodBeat.o(48827);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48827);
            return -1;
        }
    }
}
