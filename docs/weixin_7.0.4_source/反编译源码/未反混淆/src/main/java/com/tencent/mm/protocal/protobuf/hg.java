package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class hg extends a {
    public String title;
    public btr vCP;
    public String vJS;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48778);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.vCP != null) {
                aVar.iy(2, this.vCP.computeSize());
                this.vCP.writeFields(aVar);
            }
            if (this.vJS != null) {
                aVar.e(3, this.vJS);
            }
            AppMethodBeat.o(48778);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = e.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.vCP != null) {
                f += e.a.a.a.ix(2, this.vCP.computeSize());
            }
            if (this.vJS != null) {
                f += e.a.a.b.b.a.f(3, this.vJS);
            }
            AppMethodBeat.o(48778);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48778);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            hg hgVar = (hg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    hgVar.title = aVar3.BTU.readString();
                    AppMethodBeat.o(48778);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        btr btr = new btr();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = btr.populateBuilderWithField(aVar4, btr, a.getNextFieldNumber(aVar4))) {
                        }
                        hgVar.vCP = btr;
                    }
                    AppMethodBeat.o(48778);
                    return 0;
                case 3:
                    hgVar.vJS = aVar3.BTU.readString();
                    AppMethodBeat.o(48778);
                    return 0;
                default:
                    AppMethodBeat.o(48778);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48778);
            return -1;
        }
    }
}
