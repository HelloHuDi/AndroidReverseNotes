package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cc extends a {
    public String Title;
    public LinkedList<cd> ncP = new LinkedList();
    public ce ncQ;

    public cc() {
        AppMethodBeat.i(111637);
        AppMethodBeat.o(111637);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111638);
        b bVar;
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(111638);
                throw bVar;
            }
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            aVar.e(2, 8, this.ncP);
            if (this.ncQ != null) {
                aVar.iy(3, this.ncQ.computeSize());
                this.ncQ.writeFields(aVar);
            }
            AppMethodBeat.o(111638);
            return 0;
        } else if (i == 1) {
            if (this.Title != null) {
                f = e.a.a.b.b.a.f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.a.c(2, 8, this.ncP);
            if (this.ncQ != null) {
                f += e.a.a.a.ix(3, this.ncQ.computeSize());
            }
            AppMethodBeat.o(111638);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ncP.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.Title == null) {
                bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(111638);
                throw bVar;
            }
            AppMethodBeat.o(111638);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cc ccVar = (cc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    ccVar.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(111638);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cd cdVar = new cd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdVar.populateBuilderWithField(aVar4, cdVar, a.getNextFieldNumber(aVar4))) {
                        }
                        ccVar.ncP.add(cdVar);
                    }
                    AppMethodBeat.o(111638);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ce ceVar = new ce();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ceVar.populateBuilderWithField(aVar4, ceVar, a.getNextFieldNumber(aVar4))) {
                        }
                        ccVar.ncQ = ceVar;
                    }
                    AppMethodBeat.o(111638);
                    return 0;
                default:
                    AppMethodBeat.o(111638);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111638);
            return -1;
        }
    }
}
