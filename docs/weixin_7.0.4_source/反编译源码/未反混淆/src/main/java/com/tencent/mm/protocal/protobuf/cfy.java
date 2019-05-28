package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cfy extends a {
    public String vJS;
    public int wRi;
    public int xeY;
    public xc xeZ;
    public xc xfa;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48964);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wRi);
            aVar.iz(2, this.xeY);
            if (this.vJS != null) {
                aVar.e(3, this.vJS);
            }
            if (this.xeZ != null) {
                aVar.iy(4, this.xeZ.computeSize());
                this.xeZ.writeFields(aVar);
            }
            if (this.xfa != null) {
                aVar.iy(5, this.xfa.computeSize());
                this.xfa.writeFields(aVar);
            }
            AppMethodBeat.o(48964);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.wRi) + 0) + e.a.a.b.b.a.bs(2, this.xeY);
            if (this.vJS != null) {
                bs += e.a.a.b.b.a.f(3, this.vJS);
            }
            if (this.xeZ != null) {
                bs += e.a.a.a.ix(4, this.xeZ.computeSize());
            }
            if (this.xfa != null) {
                bs += e.a.a.a.ix(5, this.xfa.computeSize());
            }
            AppMethodBeat.o(48964);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48964);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cfy cfy = (cfy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            xc xcVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cfy.wRi = aVar3.BTU.vd();
                    AppMethodBeat.o(48964);
                    return 0;
                case 2:
                    cfy.xeY = aVar3.BTU.vd();
                    AppMethodBeat.o(48964);
                    return 0;
                case 3:
                    cfy.vJS = aVar3.BTU.readString();
                    AppMethodBeat.o(48964);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        xcVar = new xc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xcVar.populateBuilderWithField(aVar4, xcVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cfy.xeZ = xcVar;
                    }
                    AppMethodBeat.o(48964);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        xcVar = new xc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xcVar.populateBuilderWithField(aVar4, xcVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cfy.xfa = xcVar;
                    }
                    AppMethodBeat.o(48964);
                    return 0;
                default:
                    AppMethodBeat.o(48964);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48964);
            return -1;
        }
    }
}
