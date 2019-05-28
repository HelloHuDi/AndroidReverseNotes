package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class aao extends a {
    public long wfL;
    public long wfM;
    public LinkedList<cgy> wfN = new LinkedList();

    public aao() {
        AppMethodBeat.i(94520);
        AppMethodBeat.o(94520);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94521);
        int o;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.wfL);
            aVar.ai(2, this.wfM);
            aVar.e(3, 8, this.wfN);
            AppMethodBeat.o(94521);
            return 0;
        } else if (i == 1) {
            o = ((e.a.a.b.b.a.o(1, this.wfL) + 0) + e.a.a.b.b.a.o(2, this.wfM)) + e.a.a.a.c(3, 8, this.wfN);
            AppMethodBeat.o(94521);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wfN.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94521);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aao aao = (aao) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aao.wfL = aVar3.BTU.ve();
                    AppMethodBeat.o(94521);
                    return 0;
                case 2:
                    aao.wfM = aVar3.BTU.ve();
                    AppMethodBeat.o(94521);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgy cgy = new cgy();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cgy.populateBuilderWithField(aVar4, cgy, a.getNextFieldNumber(aVar4))) {
                        }
                        aao.wfN.add(cgy);
                    }
                    AppMethodBeat.o(94521);
                    return 0;
                default:
                    AppMethodBeat.o(94521);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94521);
            return -1;
        }
    }
}
