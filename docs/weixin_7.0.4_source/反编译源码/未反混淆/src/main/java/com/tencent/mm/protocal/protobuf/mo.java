package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;
import java.util.LinkedList;

public final class mo extends a {
    public b vQB;
    public b vQC;
    public LinkedList<bxh> vQD = new LinkedList();

    public mo() {
        AppMethodBeat.i(124301);
        AppMethodBeat.o(124301);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124302);
        e.a.a.b bVar;
        int b;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vQB == null) {
                bVar = new e.a.a.b("Not all required fields were included: Title");
                AppMethodBeat.o(124302);
                throw bVar;
            } else if (this.vQC == null) {
                bVar = new e.a.a.b("Not all required fields were included: ServiceUrl");
                AppMethodBeat.o(124302);
                throw bVar;
            } else {
                if (this.vQB != null) {
                    aVar.c(1, this.vQB);
                }
                if (this.vQC != null) {
                    aVar.c(2, this.vQC);
                }
                aVar.e(3, 8, this.vQD);
                AppMethodBeat.o(124302);
                return 0;
            }
        } else if (i == 1) {
            if (this.vQB != null) {
                b = e.a.a.b.b.a.b(1, this.vQB) + 0;
            } else {
                b = 0;
            }
            if (this.vQC != null) {
                b += e.a.a.b.b.a.b(2, this.vQC);
            }
            int c = b + e.a.a.a.c(3, 8, this.vQD);
            AppMethodBeat.o(124302);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vQD.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (b = a.getNextFieldNumber(aVar2); b > 0; b = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, b)) {
                    aVar2.ems();
                }
            }
            if (this.vQB == null) {
                bVar = new e.a.a.b("Not all required fields were included: Title");
                AppMethodBeat.o(124302);
                throw bVar;
            } else if (this.vQC == null) {
                bVar = new e.a.a.b("Not all required fields were included: ServiceUrl");
                AppMethodBeat.o(124302);
                throw bVar;
            } else {
                AppMethodBeat.o(124302);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            mo moVar = (mo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    moVar.vQB = aVar3.BTU.emu();
                    AppMethodBeat.o(124302);
                    return 0;
                case 2:
                    moVar.vQC = aVar3.BTU.emu();
                    AppMethodBeat.o(124302);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bxh bxh = new bxh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bxh.populateBuilderWithField(aVar4, bxh, a.getNextFieldNumber(aVar4))) {
                        }
                        moVar.vQD.add(bxh);
                    }
                    AppMethodBeat.o(124302);
                    return 0;
                default:
                    AppMethodBeat.o(124302);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124302);
            return -1;
        }
    }
}
