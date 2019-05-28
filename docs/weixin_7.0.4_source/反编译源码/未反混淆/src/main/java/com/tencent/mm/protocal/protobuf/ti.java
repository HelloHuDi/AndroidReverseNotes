package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class ti extends a {
    public String nQB;
    public long timestamp;
    public String vGv;
    public String way;
    public te waz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124309);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.timestamp);
            if (this.way != null) {
                aVar.e(2, this.way);
            }
            if (this.vGv != null) {
                aVar.e(3, this.vGv);
            }
            if (this.nQB != null) {
                aVar.e(4, this.nQB);
            }
            if (this.waz != null) {
                aVar.iy(5, this.waz.computeSize());
                this.waz.writeFields(aVar);
            }
            AppMethodBeat.o(124309);
            return 0;
        } else if (i == 1) {
            o = e.a.a.b.b.a.o(1, this.timestamp) + 0;
            if (this.way != null) {
                o += e.a.a.b.b.a.f(2, this.way);
            }
            if (this.vGv != null) {
                o += e.a.a.b.b.a.f(3, this.vGv);
            }
            if (this.nQB != null) {
                o += e.a.a.b.b.a.f(4, this.nQB);
            }
            if (this.waz != null) {
                o += e.a.a.a.ix(5, this.waz.computeSize());
            }
            AppMethodBeat.o(124309);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124309);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ti tiVar = (ti) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    tiVar.timestamp = aVar3.BTU.ve();
                    AppMethodBeat.o(124309);
                    return 0;
                case 2:
                    tiVar.way = aVar3.BTU.readString();
                    AppMethodBeat.o(124309);
                    return 0;
                case 3:
                    tiVar.vGv = aVar3.BTU.readString();
                    AppMethodBeat.o(124309);
                    return 0;
                case 4:
                    tiVar.nQB = aVar3.BTU.readString();
                    AppMethodBeat.o(124309);
                    return 0;
                case 5:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        te teVar = new te();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = teVar.populateBuilderWithField(aVar4, teVar, a.getNextFieldNumber(aVar4))) {
                        }
                        tiVar.waz = teVar;
                    }
                    AppMethodBeat.o(124309);
                    return 0;
                default:
                    AppMethodBeat.o(124309);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124309);
            return -1;
        }
    }
}
