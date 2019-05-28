package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cwn extends a {
    public LinkedList<bkn> xsi = new LinkedList();
    public LinkedList<aws> xsj = new LinkedList();

    public cwn() {
        AppMethodBeat.i(96324);
        AppMethodBeat.o(96324);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96325);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.xsi);
            aVar.e(2, 8, this.xsj);
            AppMethodBeat.o(96325);
            return 0;
        } else if (i == 1) {
            c = (e.a.a.a.c(1, 8, this.xsi) + 0) + e.a.a.a.c(2, 8, this.xsj);
            AppMethodBeat.o(96325);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xsi.clear();
            this.xsj.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96325);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cwn cwn = (cwn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bkn bkn = new bkn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bkn.populateBuilderWithField(aVar4, bkn, a.getNextFieldNumber(aVar4))) {
                        }
                        cwn.xsi.add(bkn);
                    }
                    AppMethodBeat.o(96325);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aws aws = new aws();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aws.populateBuilderWithField(aVar4, aws, a.getNextFieldNumber(aVar4))) {
                        }
                        cwn.xsj.add(aws);
                    }
                    AppMethodBeat.o(96325);
                    return 0;
                default:
                    AppMethodBeat.o(96325);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96325);
            return -1;
        }
    }
}
