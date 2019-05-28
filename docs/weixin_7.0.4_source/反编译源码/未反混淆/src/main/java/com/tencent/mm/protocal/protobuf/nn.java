package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class nn extends a {
    public String name;
    public LinkedList<ul> vRR = new LinkedList();
    public int vRS;
    public String vRT;
    public String vzX;

    public nn() {
        AppMethodBeat.i(28351);
        AppMethodBeat.o(28351);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28352);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.vRR);
            if (this.vzX != null) {
                aVar.e(2, this.vzX);
            }
            aVar.iz(3, this.vRS);
            if (this.vRT != null) {
                aVar.e(4, this.vRT);
            }
            if (this.name != null) {
                aVar.e(5, this.name);
            }
            AppMethodBeat.o(28352);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.vRR) + 0;
            if (this.vzX != null) {
                c += e.a.a.b.b.a.f(2, this.vzX);
            }
            c += e.a.a.b.b.a.bs(3, this.vRS);
            if (this.vRT != null) {
                c += e.a.a.b.b.a.f(4, this.vRT);
            }
            if (this.name != null) {
                c += e.a.a.b.b.a.f(5, this.name);
            }
            AppMethodBeat.o(28352);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vRR.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28352);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            nn nnVar = (nn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ul ulVar = new ul();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ulVar.populateBuilderWithField(aVar4, ulVar, a.getNextFieldNumber(aVar4))) {
                        }
                        nnVar.vRR.add(ulVar);
                    }
                    AppMethodBeat.o(28352);
                    return 0;
                case 2:
                    nnVar.vzX = aVar3.BTU.readString();
                    AppMethodBeat.o(28352);
                    return 0;
                case 3:
                    nnVar.vRS = aVar3.BTU.vd();
                    AppMethodBeat.o(28352);
                    return 0;
                case 4:
                    nnVar.vRT = aVar3.BTU.readString();
                    AppMethodBeat.o(28352);
                    return 0;
                case 5:
                    nnVar.name = aVar3.BTU.readString();
                    AppMethodBeat.o(28352);
                    return 0;
                default:
                    AppMethodBeat.o(28352);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28352);
            return -1;
        }
    }
}
