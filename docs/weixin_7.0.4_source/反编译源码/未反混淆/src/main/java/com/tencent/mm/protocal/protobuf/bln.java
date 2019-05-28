package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bln extends a {
    public String vJS;
    public bzy wOA;
    public bzy wOB;
    public boolean wOz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48926);
        int fv;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.aO(1, this.wOz);
            if (this.wOA != null) {
                aVar.iy(2, this.wOA.computeSize());
                this.wOA.writeFields(aVar);
            }
            if (this.wOB != null) {
                aVar.iy(3, this.wOB.computeSize());
                this.wOB.writeFields(aVar);
            }
            if (this.vJS != null) {
                aVar.e(4, this.vJS);
            }
            AppMethodBeat.o(48926);
            return 0;
        } else if (i == 1) {
            fv = (e.a.a.b.b.a.fv(1) + 1) + 0;
            if (this.wOA != null) {
                fv += e.a.a.a.ix(2, this.wOA.computeSize());
            }
            if (this.wOB != null) {
                fv += e.a.a.a.ix(3, this.wOB.computeSize());
            }
            if (this.vJS != null) {
                fv += e.a.a.b.b.a.f(4, this.vJS);
            }
            AppMethodBeat.o(48926);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48926);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bln bln = (bln) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            bzy bzy;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bln.wOz = aVar3.BTU.ehX();
                    AppMethodBeat.o(48926);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzy = new bzy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzy.populateBuilderWithField(aVar4, bzy, a.getNextFieldNumber(aVar4))) {
                        }
                        bln.wOA = bzy;
                    }
                    AppMethodBeat.o(48926);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzy = new bzy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzy.populateBuilderWithField(aVar4, bzy, a.getNextFieldNumber(aVar4))) {
                        }
                        bln.wOB = bzy;
                    }
                    AppMethodBeat.o(48926);
                    return 0;
                case 4:
                    bln.vJS = aVar3.BTU.readString();
                    AppMethodBeat.o(48926);
                    return 0;
                default:
                    AppMethodBeat.o(48926);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48926);
            return -1;
        }
    }
}
