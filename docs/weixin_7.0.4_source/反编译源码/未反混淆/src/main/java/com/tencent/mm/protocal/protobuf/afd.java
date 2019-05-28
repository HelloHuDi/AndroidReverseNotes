package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class afd extends a {
    public aw vRP;
    public String vWV;
    public LinkedList<String> wmD = new LinkedList();

    public afd() {
        AppMethodBeat.i(56807);
        AppMethodBeat.o(56807);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56808);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 1, this.wmD);
            if (this.vRP != null) {
                aVar.iy(2, this.vRP.computeSize());
                this.vRP.writeFields(aVar);
            }
            if (this.vWV != null) {
                aVar.e(3, this.vWV);
            }
            AppMethodBeat.o(56808);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 1, this.wmD) + 0;
            if (this.vRP != null) {
                c += e.a.a.a.ix(2, this.vRP.computeSize());
            }
            if (this.vWV != null) {
                c += e.a.a.b.b.a.f(3, this.vWV);
            }
            AppMethodBeat.o(56808);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wmD.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56808);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            afd afd = (afd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    afd.wmD.add(aVar3.BTU.readString());
                    AppMethodBeat.o(56808);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aw awVar = new aw();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = awVar.populateBuilderWithField(aVar4, awVar, a.getNextFieldNumber(aVar4))) {
                        }
                        afd.vRP = awVar;
                    }
                    AppMethodBeat.o(56808);
                    return 0;
                case 3:
                    afd.vWV = aVar3.BTU.readString();
                    AppMethodBeat.o(56808);
                    return 0;
                default:
                    AppMethodBeat.o(56808);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56808);
            return -1;
        }
    }
}
