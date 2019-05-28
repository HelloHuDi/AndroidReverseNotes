package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cjh extends a {
    public String content;
    public String title;
    public ayi xhU;
    public ayi xhV;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48978);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.content != null) {
                aVar.e(2, this.content);
            }
            if (this.xhU != null) {
                aVar.iy(3, this.xhU.computeSize());
                this.xhU.writeFields(aVar);
            }
            if (this.xhV != null) {
                aVar.iy(4, this.xhV.computeSize());
                this.xhV.writeFields(aVar);
            }
            AppMethodBeat.o(48978);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = e.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.content != null) {
                f += e.a.a.b.b.a.f(2, this.content);
            }
            if (this.xhU != null) {
                f += e.a.a.a.ix(3, this.xhU.computeSize());
            }
            if (this.xhV != null) {
                f += e.a.a.a.ix(4, this.xhV.computeSize());
            }
            AppMethodBeat.o(48978);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48978);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cjh cjh = (cjh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            ayi ayi;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cjh.title = aVar3.BTU.readString();
                    AppMethodBeat.o(48978);
                    return 0;
                case 2:
                    cjh.content = aVar3.BTU.readString();
                    AppMethodBeat.o(48978);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ayi = new ayi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ayi.populateBuilderWithField(aVar4, ayi, a.getNextFieldNumber(aVar4))) {
                        }
                        cjh.xhU = ayi;
                    }
                    AppMethodBeat.o(48978);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ayi = new ayi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ayi.populateBuilderWithField(aVar4, ayi, a.getNextFieldNumber(aVar4))) {
                        }
                        cjh.xhV = ayi;
                    }
                    AppMethodBeat.o(48978);
                    return 0;
                default:
                    AppMethodBeat.o(48978);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48978);
            return -1;
        }
    }
}
