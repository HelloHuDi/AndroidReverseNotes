package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class ary extends a {
    public String Name;
    public LinkedList<bau> wbK = new LinkedList();

    public ary() {
        AppMethodBeat.i(94532);
        AppMethodBeat.o(94532);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94533);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Name != null) {
                aVar.e(1, this.Name);
            }
            aVar.e(2, 8, this.wbK);
            AppMethodBeat.o(94533);
            return 0;
        } else if (i == 1) {
            if (this.Name != null) {
                f = e.a.a.b.b.a.f(1, this.Name) + 0;
            } else {
                f = 0;
            }
            int c = f + e.a.a.a.c(2, 8, this.wbK);
            AppMethodBeat.o(94533);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wbK.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94533);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ary ary = (ary) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ary.Name = aVar3.BTU.readString();
                    AppMethodBeat.o(94533);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bau bau = new bau();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bau.populateBuilderWithField(aVar4, bau, a.getNextFieldNumber(aVar4))) {
                        }
                        ary.wbK.add(bau);
                    }
                    AppMethodBeat.o(94533);
                    return 0;
                default:
                    AppMethodBeat.o(94533);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94533);
            return -1;
        }
    }
}
