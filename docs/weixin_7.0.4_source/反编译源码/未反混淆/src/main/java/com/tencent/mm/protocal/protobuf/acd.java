package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class acd extends a {
    public String title;
    public String wjT;
    public LinkedList<ace> wjU = new LinkedList();

    public acd() {
        AppMethodBeat.i(56793);
        AppMethodBeat.o(56793);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56794);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.wjT != null) {
                aVar.e(2, this.wjT);
            }
            aVar.e(3, 8, this.wjU);
            AppMethodBeat.o(56794);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = e.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.wjT != null) {
                f += e.a.a.b.b.a.f(2, this.wjT);
            }
            int c = f + e.a.a.a.c(3, 8, this.wjU);
            AppMethodBeat.o(56794);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wjU.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56794);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            acd acd = (acd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    acd.title = aVar3.BTU.readString();
                    AppMethodBeat.o(56794);
                    return 0;
                case 2:
                    acd.wjT = aVar3.BTU.readString();
                    AppMethodBeat.o(56794);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ace ace = new ace();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ace.populateBuilderWithField(aVar4, ace, a.getNextFieldNumber(aVar4))) {
                        }
                        acd.wjU.add(ace);
                    }
                    AppMethodBeat.o(56794);
                    return 0;
                default:
                    AppMethodBeat.o(56794);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56794);
            return -1;
        }
    }
}
