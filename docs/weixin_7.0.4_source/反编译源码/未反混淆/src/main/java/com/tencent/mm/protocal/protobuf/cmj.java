package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cmj extends a {
    public String vHl;
    public bku xkm;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(113793);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xkm == null) {
                bVar = new b("Not all required fields were included: Position");
                AppMethodBeat.o(113793);
                throw bVar;
            }
            if (this.vHl != null) {
                aVar.e(1, this.vHl);
            }
            if (this.xkm != null) {
                aVar.iy(2, this.xkm.computeSize());
                this.xkm.writeFields(aVar);
            }
            AppMethodBeat.o(113793);
            return 0;
        } else if (i == 1) {
            if (this.vHl != null) {
                f = e.a.a.b.b.a.f(1, this.vHl) + 0;
            } else {
                f = 0;
            }
            if (this.xkm != null) {
                f += e.a.a.a.ix(2, this.xkm.computeSize());
            }
            AppMethodBeat.o(113793);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.xkm == null) {
                bVar = new b("Not all required fields were included: Position");
                AppMethodBeat.o(113793);
                throw bVar;
            }
            AppMethodBeat.o(113793);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cmj cmj = (cmj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cmj.vHl = aVar3.BTU.readString();
                    AppMethodBeat.o(113793);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bku bku = new bku();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bku.populateBuilderWithField(aVar4, bku, a.getNextFieldNumber(aVar4))) {
                        }
                        cmj.xkm = bku;
                    }
                    AppMethodBeat.o(113793);
                    return 0;
                default:
                    AppMethodBeat.o(113793);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113793);
            return -1;
        }
    }
}
