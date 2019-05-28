package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class gd extends a {
    public String desc;
    public String title;
    public LinkedList<gc> vIf = new LinkedList();

    public gd() {
        AppMethodBeat.i(96200);
        AppMethodBeat.o(96200);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96201);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            aVar.e(3, 8, this.vIf);
            AppMethodBeat.o(96201);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = e.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.desc != null) {
                f += e.a.a.b.b.a.f(2, this.desc);
            }
            int c = f + e.a.a.a.c(3, 8, this.vIf);
            AppMethodBeat.o(96201);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vIf.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96201);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            gd gdVar = (gd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    gdVar.title = aVar3.BTU.readString();
                    AppMethodBeat.o(96201);
                    return 0;
                case 2:
                    gdVar.desc = aVar3.BTU.readString();
                    AppMethodBeat.o(96201);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        gc gcVar = new gc();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = gcVar.populateBuilderWithField(aVar4, gcVar, a.getNextFieldNumber(aVar4))) {
                        }
                        gdVar.vIf.add(gcVar);
                    }
                    AppMethodBeat.o(96201);
                    return 0;
                default:
                    AppMethodBeat.o(96201);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96201);
            return -1;
        }
    }
}
