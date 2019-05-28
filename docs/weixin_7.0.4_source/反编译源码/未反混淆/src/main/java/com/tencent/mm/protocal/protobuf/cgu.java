package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cgu extends a {
    public int eUv;
    public String text;
    public int textColor;
    public cnw wCL;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(2533);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.text == null) {
                bVar = new b("Not all required fields were included: text");
                AppMethodBeat.o(2533);
                throw bVar;
            } else if (this.wCL == null) {
                bVar = new b("Not all required fields were included: matrix");
                AppMethodBeat.o(2533);
                throw bVar;
            } else {
                if (this.text != null) {
                    aVar.e(1, this.text);
                }
                aVar.iz(2, this.textColor);
                aVar.iz(3, this.eUv);
                if (this.wCL != null) {
                    aVar.iy(4, this.wCL.computeSize());
                    this.wCL.writeFields(aVar);
                }
                AppMethodBeat.o(2533);
                return 0;
            }
        } else if (i == 1) {
            if (this.text != null) {
                f = e.a.a.b.b.a.f(1, this.text) + 0;
            } else {
                f = 0;
            }
            f = (f + e.a.a.b.b.a.bs(2, this.textColor)) + e.a.a.b.b.a.bs(3, this.eUv);
            if (this.wCL != null) {
                f += e.a.a.a.ix(4, this.wCL.computeSize());
            }
            AppMethodBeat.o(2533);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.text == null) {
                bVar = new b("Not all required fields were included: text");
                AppMethodBeat.o(2533);
                throw bVar;
            } else if (this.wCL == null) {
                bVar = new b("Not all required fields were included: matrix");
                AppMethodBeat.o(2533);
                throw bVar;
            } else {
                AppMethodBeat.o(2533);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cgu cgu = (cgu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cgu.text = aVar3.BTU.readString();
                    AppMethodBeat.o(2533);
                    return 0;
                case 2:
                    cgu.textColor = aVar3.BTU.vd();
                    AppMethodBeat.o(2533);
                    return 0;
                case 3:
                    cgu.eUv = aVar3.BTU.vd();
                    AppMethodBeat.o(2533);
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
                        cgu.wCL = cnw;
                    }
                    AppMethodBeat.o(2533);
                    return 0;
                default:
                    AppMethodBeat.o(2533);
                    return -1;
            }
        } else {
            AppMethodBeat.o(2533);
            return -1;
        }
    }
}
