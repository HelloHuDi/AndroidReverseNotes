package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class tv extends a {
    public LinkedList<tu> vEN = new LinkedList();
    public long waM;
    public long wbj;

    public tv() {
        AppMethodBeat.i(135601);
        AppMethodBeat.o(135601);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(135602);
        int o;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.wbj);
            aVar.ai(2, this.waM);
            aVar.e(3, 8, this.vEN);
            AppMethodBeat.o(135602);
            return 0;
        } else if (i == 1) {
            o = ((e.a.a.b.b.a.o(1, this.wbj) + 0) + e.a.a.b.b.a.o(2, this.waM)) + e.a.a.a.c(3, 8, this.vEN);
            AppMethodBeat.o(135602);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vEN.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(135602);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            tv tvVar = (tv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    tvVar.wbj = aVar3.BTU.ve();
                    AppMethodBeat.o(135602);
                    return 0;
                case 2:
                    tvVar.waM = aVar3.BTU.ve();
                    AppMethodBeat.o(135602);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        tu tuVar = new tu();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = tuVar.populateBuilderWithField(aVar4, tuVar, a.getNextFieldNumber(aVar4))) {
                        }
                        tvVar.vEN.add(tuVar);
                    }
                    AppMethodBeat.o(135602);
                    return 0;
                default:
                    AppMethodBeat.o(135602);
                    return -1;
            }
        } else {
            AppMethodBeat.o(135602);
            return -1;
        }
    }
}
