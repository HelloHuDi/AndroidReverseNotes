package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cf extends a {
    public String Title;
    public String naq;
    public LinkedList<cl> ncS = new LinkedList();

    public cf() {
        AppMethodBeat.i(111641);
        AppMethodBeat.o(111641);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111642);
        b bVar;
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(111642);
                throw bVar;
            } else if (this.naq == null) {
                bVar = new b("Not all required fields were included: Detail");
                AppMethodBeat.o(111642);
                throw bVar;
            } else {
                if (this.Title != null) {
                    aVar.e(1, this.Title);
                }
                aVar.e(2, 8, this.ncS);
                if (this.naq != null) {
                    aVar.e(3, this.naq);
                }
                AppMethodBeat.o(111642);
                return 0;
            }
        } else if (i == 1) {
            if (this.Title != null) {
                f = e.a.a.b.b.a.f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.a.c(2, 8, this.ncS);
            if (this.naq != null) {
                f += e.a.a.b.b.a.f(3, this.naq);
            }
            AppMethodBeat.o(111642);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ncS.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(111642);
                throw bVar;
            } else if (this.naq == null) {
                bVar = new b("Not all required fields were included: Detail");
                AppMethodBeat.o(111642);
                throw bVar;
            } else {
                AppMethodBeat.o(111642);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cf cfVar = (cf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cfVar.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(111642);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cl clVar = new cl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = clVar.populateBuilderWithField(aVar4, clVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cfVar.ncS.add(clVar);
                    }
                    AppMethodBeat.o(111642);
                    return 0;
                case 3:
                    cfVar.naq = aVar3.BTU.readString();
                    AppMethodBeat.o(111642);
                    return 0;
                default:
                    AppMethodBeat.o(111642);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111642);
            return -1;
        }
    }
}
