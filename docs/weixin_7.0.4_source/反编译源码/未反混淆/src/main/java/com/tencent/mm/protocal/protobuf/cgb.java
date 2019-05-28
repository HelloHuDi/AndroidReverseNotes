package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cgb extends a {
    public String vEn;
    public String xfb;
    public cxr xfe;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(114991);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xfb == null) {
                bVar = new b("Not all required fields were included: WxaUserName");
                AppMethodBeat.o(114991);
                throw bVar;
            }
            if (this.xfb != null) {
                aVar.e(1, this.xfb);
            }
            if (this.xfe != null) {
                aVar.iy(2, this.xfe.computeSize());
                this.xfe.writeFields(aVar);
            }
            if (this.vEn != null) {
                aVar.e(3, this.vEn);
            }
            AppMethodBeat.o(114991);
            return 0;
        } else if (i == 1) {
            if (this.xfb != null) {
                f = e.a.a.b.b.a.f(1, this.xfb) + 0;
            } else {
                f = 0;
            }
            if (this.xfe != null) {
                f += e.a.a.a.ix(2, this.xfe.computeSize());
            }
            if (this.vEn != null) {
                f += e.a.a.b.b.a.f(3, this.vEn);
            }
            AppMethodBeat.o(114991);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.xfb == null) {
                bVar = new b("Not all required fields were included: WxaUserName");
                AppMethodBeat.o(114991);
                throw bVar;
            }
            AppMethodBeat.o(114991);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cgb cgb = (cgb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cgb.xfb = aVar3.BTU.readString();
                    AppMethodBeat.o(114991);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        cxr cxr = new cxr();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cxr.populateBuilderWithField(aVar4, cxr, a.getNextFieldNumber(aVar4))) {
                        }
                        cgb.xfe = cxr;
                    }
                    AppMethodBeat.o(114991);
                    return 0;
                case 3:
                    cgb.vEn = aVar3.BTU.readString();
                    AppMethodBeat.o(114991);
                    return 0;
                default:
                    AppMethodBeat.o(114991);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114991);
            return -1;
        }
    }
}
