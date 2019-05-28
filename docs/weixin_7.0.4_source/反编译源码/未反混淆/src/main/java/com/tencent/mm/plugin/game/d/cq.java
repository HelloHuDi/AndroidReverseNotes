package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cq extends a {
    public String ncB;
    public LinkedList<cr> ndk = new LinkedList();
    public String ndl;

    public cq() {
        AppMethodBeat.i(111654);
        AppMethodBeat.o(111654);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111655);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.ndk);
            if (this.ncB != null) {
                aVar.e(2, this.ncB);
            }
            if (this.ndl != null) {
                aVar.e(3, this.ndl);
            }
            AppMethodBeat.o(111655);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.ndk) + 0;
            if (this.ncB != null) {
                c += e.a.a.b.b.a.f(2, this.ncB);
            }
            if (this.ndl != null) {
                c += e.a.a.b.b.a.f(3, this.ndl);
            }
            AppMethodBeat.o(111655);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ndk.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111655);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cq cqVar = (cq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cr crVar = new cr();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = crVar.populateBuilderWithField(aVar4, crVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cqVar.ndk.add(crVar);
                    }
                    AppMethodBeat.o(111655);
                    return 0;
                case 2:
                    cqVar.ncB = aVar3.BTU.readString();
                    AppMethodBeat.o(111655);
                    return 0;
                case 3:
                    cqVar.ndl = aVar3.BTU.readString();
                    AppMethodBeat.o(111655);
                    return 0;
                default:
                    AppMethodBeat.o(111655);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111655);
            return -1;
        }
    }
}
