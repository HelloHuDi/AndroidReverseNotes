package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ayv extends a {
    public String eUt;
    public String eUu;
    public cnw wCL;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(2532);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.eUt == null) {
                bVar = new b("Not all required fields were included: cityName");
                AppMethodBeat.o(2532);
                throw bVar;
            } else if (this.eUu == null) {
                bVar = new b("Not all required fields were included: poiName");
                AppMethodBeat.o(2532);
                throw bVar;
            } else if (this.wCL == null) {
                bVar = new b("Not all required fields were included: matrix");
                AppMethodBeat.o(2532);
                throw bVar;
            } else {
                if (this.eUt != null) {
                    aVar.e(1, this.eUt);
                }
                if (this.eUu != null) {
                    aVar.e(2, this.eUu);
                }
                if (this.wCL != null) {
                    aVar.iy(4, this.wCL.computeSize());
                    this.wCL.writeFields(aVar);
                }
                AppMethodBeat.o(2532);
                return 0;
            }
        } else if (i == 1) {
            if (this.eUt != null) {
                f = e.a.a.b.b.a.f(1, this.eUt) + 0;
            } else {
                f = 0;
            }
            if (this.eUu != null) {
                f += e.a.a.b.b.a.f(2, this.eUu);
            }
            if (this.wCL != null) {
                f += e.a.a.a.ix(4, this.wCL.computeSize());
            }
            AppMethodBeat.o(2532);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.eUt == null) {
                bVar = new b("Not all required fields were included: cityName");
                AppMethodBeat.o(2532);
                throw bVar;
            } else if (this.eUu == null) {
                bVar = new b("Not all required fields were included: poiName");
                AppMethodBeat.o(2532);
                throw bVar;
            } else if (this.wCL == null) {
                bVar = new b("Not all required fields were included: matrix");
                AppMethodBeat.o(2532);
                throw bVar;
            } else {
                AppMethodBeat.o(2532);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ayv ayv = (ayv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ayv.eUt = aVar3.BTU.readString();
                    AppMethodBeat.o(2532);
                    return 0;
                case 2:
                    ayv.eUu = aVar3.BTU.readString();
                    AppMethodBeat.o(2532);
                    return 0;
                case 4:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        cnw cnw = new cnw();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cnw.populateBuilderWithField(aVar4, cnw, a.getNextFieldNumber(aVar4))) {
                        }
                        ayv.wCL = cnw;
                    }
                    AppMethodBeat.o(2532);
                    return 0;
                default:
                    AppMethodBeat.o(2532);
                    return -1;
            }
        } else {
            AppMethodBeat.o(2532);
            return -1;
        }
    }
}
