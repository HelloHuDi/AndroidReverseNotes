package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class co extends a {
    public String desc;
    public String gfa;
    public LinkedList<bgc> vEN = new LinkedList();

    public co() {
        AppMethodBeat.i(80007);
        AppMethodBeat.o(80007);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80008);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.gfa != null) {
                aVar.e(1, this.gfa);
            }
            aVar.e(2, 8, this.vEN);
            if (this.desc != null) {
                aVar.e(3, this.desc);
            }
            AppMethodBeat.o(80008);
            return 0;
        } else if (i == 1) {
            if (this.gfa != null) {
                f = e.a.a.b.b.a.f(1, this.gfa) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.a.c(2, 8, this.vEN);
            if (this.desc != null) {
                f += e.a.a.b.b.a.f(3, this.desc);
            }
            AppMethodBeat.o(80008);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vEN.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80008);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            co coVar = (co) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    coVar.gfa = aVar3.BTU.readString();
                    AppMethodBeat.o(80008);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bgc bgc = new bgc();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bgc.populateBuilderWithField(aVar4, bgc, a.getNextFieldNumber(aVar4))) {
                        }
                        coVar.vEN.add(bgc);
                    }
                    AppMethodBeat.o(80008);
                    return 0;
                case 3:
                    coVar.desc = aVar3.BTU.readString();
                    AppMethodBeat.o(80008);
                    return 0;
                default:
                    AppMethodBeat.o(80008);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80008);
            return -1;
        }
    }
}
