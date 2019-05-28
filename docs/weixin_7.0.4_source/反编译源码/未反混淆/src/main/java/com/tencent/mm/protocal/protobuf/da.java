package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class da extends a {
    public String title;
    public String vFh;
    public LinkedList<cdm> vFi = new LinkedList();

    public da() {
        AppMethodBeat.i(28308);
        AppMethodBeat.o(28308);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28309);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vFh != null) {
                aVar.e(1, this.vFh);
            }
            aVar.e(2, 8, this.vFi);
            if (this.title != null) {
                aVar.e(3, this.title);
            }
            AppMethodBeat.o(28309);
            return 0;
        } else if (i == 1) {
            if (this.vFh != null) {
                f = e.a.a.b.b.a.f(1, this.vFh) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.a.c(2, 8, this.vFi);
            if (this.title != null) {
                f += e.a.a.b.b.a.f(3, this.title);
            }
            AppMethodBeat.o(28309);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vFi.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28309);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            da daVar = (da) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    daVar.vFh = aVar3.BTU.readString();
                    AppMethodBeat.o(28309);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdm cdm = new cdm();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cdm.populateBuilderWithField(aVar4, cdm, a.getNextFieldNumber(aVar4))) {
                        }
                        daVar.vFi.add(cdm);
                    }
                    AppMethodBeat.o(28309);
                    return 0;
                case 3:
                    daVar.title = aVar3.BTU.readString();
                    AppMethodBeat.o(28309);
                    return 0;
                default:
                    AppMethodBeat.o(28309);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28309);
            return -1;
        }
    }
}
