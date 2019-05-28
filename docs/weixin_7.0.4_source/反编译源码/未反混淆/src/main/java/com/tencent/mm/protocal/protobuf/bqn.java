package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bqn extends a {
    public int type;
    public cgv wbo;
    public String wpJ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48951);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.type);
            if (this.wpJ != null) {
                aVar.e(2, this.wpJ);
            }
            if (this.wbo != null) {
                aVar.iy(3, this.wbo.computeSize());
                this.wbo.writeFields(aVar);
            }
            AppMethodBeat.o(48951);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.type) + 0;
            if (this.wpJ != null) {
                bs += e.a.a.b.b.a.f(2, this.wpJ);
            }
            if (this.wbo != null) {
                bs += e.a.a.a.ix(3, this.wbo.computeSize());
            }
            AppMethodBeat.o(48951);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48951);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bqn bqn = (bqn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bqn.type = aVar3.BTU.vd();
                    AppMethodBeat.o(48951);
                    return 0;
                case 2:
                    bqn.wpJ = aVar3.BTU.readString();
                    AppMethodBeat.o(48951);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        cgv cgv = new cgv();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cgv.populateBuilderWithField(aVar4, cgv, a.getNextFieldNumber(aVar4))) {
                        }
                        bqn.wbo = cgv;
                    }
                    AppMethodBeat.o(48951);
                    return 0;
                default:
                    AppMethodBeat.o(48951);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48951);
            return -1;
        }
    }
}
