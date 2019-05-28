package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class brd extends a {
    public String Title;
    public LinkedList<btf> vHk = new LinkedList();

    public brd() {
        AppMethodBeat.i(124340);
        AppMethodBeat.o(124340);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124341);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            aVar.e(2, 8, this.vHk);
            AppMethodBeat.o(124341);
            return 0;
        } else if (i == 1) {
            if (this.Title != null) {
                f = e.a.a.b.b.a.f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            int c = f + e.a.a.a.c(2, 8, this.vHk);
            AppMethodBeat.o(124341);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vHk.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124341);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            brd brd = (brd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    brd.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(124341);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btf btf = new btf();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = btf.populateBuilderWithField(aVar4, btf, a.getNextFieldNumber(aVar4))) {
                        }
                        brd.vHk.add(btf);
                    }
                    AppMethodBeat.o(124341);
                    return 0;
                default:
                    AppMethodBeat.o(124341);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124341);
            return -1;
        }
    }
}
