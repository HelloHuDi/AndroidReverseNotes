package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class b extends a {
    public String bzH;
    public int id;
    public String title;
    public LinkedList<a> vzI = new LinkedList();

    public b() {
        AppMethodBeat.i(105577);
        AppMethodBeat.o(105577);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(105578);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.id);
            if (this.title != null) {
                aVar.e(2, this.title);
            }
            if (this.bzH != null) {
                aVar.e(3, this.bzH);
            }
            aVar.e(4, 8, this.vzI);
            AppMethodBeat.o(105578);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.id) + 0;
            if (this.title != null) {
                bs += e.a.a.b.b.a.f(2, this.title);
            }
            if (this.bzH != null) {
                bs += e.a.a.b.b.a.f(3, this.bzH);
            }
            bs += e.a.a.a.c(4, 8, this.vzI);
            AppMethodBeat.o(105578);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vzI.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(105578);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bVar.id = aVar3.BTU.vd();
                    AppMethodBeat.o(105578);
                    return 0;
                case 2:
                    bVar.title = aVar3.BTU.readString();
                    AppMethodBeat.o(105578);
                    return 0;
                case 3:
                    bVar.bzH = aVar3.BTU.readString();
                    AppMethodBeat.o(105578);
                    return 0;
                case 4:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        a aVar4 = new a();
                        e.a.a.a.a aVar5 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = aVar4.populateBuilderWithField(aVar5, aVar4, a.getNextFieldNumber(aVar5))) {
                        }
                        bVar.vzI.add(aVar4);
                    }
                    AppMethodBeat.o(105578);
                    return 0;
                default:
                    AppMethodBeat.o(105578);
                    return -1;
            }
        } else {
            AppMethodBeat.o(105578);
            return -1;
        }
    }
}
