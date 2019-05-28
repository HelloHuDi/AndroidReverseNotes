package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class xy extends a {
    public String cvZ;
    public String name;
    public cnw wdG;
    public cnw wdH;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(2531);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.cvZ == null) {
                bVar = new b("Not all required fields were included: md5");
                AppMethodBeat.o(2531);
                throw bVar;
            } else if (this.wdG == null) {
                bVar = new b("Not all required fields were included: editorMatrix");
                AppMethodBeat.o(2531);
                throw bVar;
            } else if (this.wdH == null) {
                bVar = new b("Not all required fields were included: showMatrix");
                AppMethodBeat.o(2531);
                throw bVar;
            } else {
                if (this.cvZ != null) {
                    aVar.e(1, this.cvZ);
                }
                if (this.name != null) {
                    aVar.e(2, this.name);
                }
                if (this.wdG != null) {
                    aVar.iy(3, this.wdG.computeSize());
                    this.wdG.writeFields(aVar);
                }
                if (this.wdH != null) {
                    aVar.iy(4, this.wdH.computeSize());
                    this.wdH.writeFields(aVar);
                }
                AppMethodBeat.o(2531);
                return 0;
            }
        } else if (i == 1) {
            if (this.cvZ != null) {
                f = e.a.a.b.b.a.f(1, this.cvZ) + 0;
            } else {
                f = 0;
            }
            if (this.name != null) {
                f += e.a.a.b.b.a.f(2, this.name);
            }
            if (this.wdG != null) {
                f += e.a.a.a.ix(3, this.wdG.computeSize());
            }
            if (this.wdH != null) {
                f += e.a.a.a.ix(4, this.wdH.computeSize());
            }
            AppMethodBeat.o(2531);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.cvZ == null) {
                bVar = new b("Not all required fields were included: md5");
                AppMethodBeat.o(2531);
                throw bVar;
            } else if (this.wdG == null) {
                bVar = new b("Not all required fields were included: editorMatrix");
                AppMethodBeat.o(2531);
                throw bVar;
            } else if (this.wdH == null) {
                bVar = new b("Not all required fields were included: showMatrix");
                AppMethodBeat.o(2531);
                throw bVar;
            } else {
                AppMethodBeat.o(2531);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            xy xyVar = (xy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            cnw cnw;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    xyVar.cvZ = aVar3.BTU.readString();
                    AppMethodBeat.o(2531);
                    return 0;
                case 2:
                    xyVar.name = aVar3.BTU.readString();
                    AppMethodBeat.o(2531);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cnw = new cnw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cnw.populateBuilderWithField(aVar4, cnw, a.getNextFieldNumber(aVar4))) {
                        }
                        xyVar.wdG = cnw;
                    }
                    AppMethodBeat.o(2531);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cnw = new cnw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cnw.populateBuilderWithField(aVar4, cnw, a.getNextFieldNumber(aVar4))) {
                        }
                        xyVar.wdH = cnw;
                    }
                    AppMethodBeat.o(2531);
                    return 0;
                default:
                    AppMethodBeat.o(2531);
                    return -1;
            }
        } else {
            AppMethodBeat.o(2531);
            return -1;
        }
    }
}
