package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cdb extends a {
    public int scene;
    public cda xcI;
    public cda xcJ;
    public cda xcK;
    public int xcL;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96295);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xcI != null) {
                aVar.iy(1, this.xcI.computeSize());
                this.xcI.writeFields(aVar);
            }
            if (this.xcJ != null) {
                aVar.iy(2, this.xcJ.computeSize());
                this.xcJ.writeFields(aVar);
            }
            if (this.xcK != null) {
                aVar.iy(3, this.xcK.computeSize());
                this.xcK.writeFields(aVar);
            }
            aVar.iz(4, this.scene);
            aVar.iz(5, this.xcL);
            AppMethodBeat.o(96295);
            return 0;
        } else if (i == 1) {
            if (this.xcI != null) {
                ix = e.a.a.a.ix(1, this.xcI.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xcJ != null) {
                ix += e.a.a.a.ix(2, this.xcJ.computeSize());
            }
            if (this.xcK != null) {
                ix += e.a.a.a.ix(3, this.xcK.computeSize());
            }
            int bs = (ix + e.a.a.b.b.a.bs(4, this.scene)) + e.a.a.b.b.a.bs(5, this.xcL);
            AppMethodBeat.o(96295);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96295);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cdb cdb = (cdb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            cda cda;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cda = new cda();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cda.populateBuilderWithField(aVar4, cda, a.getNextFieldNumber(aVar4))) {
                        }
                        cdb.xcI = cda;
                    }
                    AppMethodBeat.o(96295);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cda = new cda();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cda.populateBuilderWithField(aVar4, cda, a.getNextFieldNumber(aVar4))) {
                        }
                        cdb.xcJ = cda;
                    }
                    AppMethodBeat.o(96295);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cda = new cda();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cda.populateBuilderWithField(aVar4, cda, a.getNextFieldNumber(aVar4))) {
                        }
                        cdb.xcK = cda;
                    }
                    AppMethodBeat.o(96295);
                    return 0;
                case 4:
                    cdb.scene = aVar3.BTU.vd();
                    AppMethodBeat.o(96295);
                    return 0;
                case 5:
                    cdb.xcL = aVar3.BTU.vd();
                    AppMethodBeat.o(96295);
                    return 0;
                default:
                    AppMethodBeat.o(96295);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96295);
            return -1;
        }
    }
}
