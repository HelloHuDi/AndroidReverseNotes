package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cty extends a {
    public long vIs;
    public String xqA;
    public LinkedList<ctz> xqB = new LinkedList();
    public long xqz;

    public cty() {
        AppMethodBeat.i(28735);
        AppMethodBeat.o(28735);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28736);
        b bVar;
        int o;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xqA == null) {
                bVar = new b("Not all required fields were included: TotalMsg");
                AppMethodBeat.o(28736);
                throw bVar;
            }
            aVar.ai(1, this.xqz);
            aVar.ai(2, this.vIs);
            if (this.xqA != null) {
                aVar.e(3, this.xqA);
            }
            aVar.e(4, 8, this.xqB);
            AppMethodBeat.o(28736);
            return 0;
        } else if (i == 1) {
            o = (e.a.a.b.b.a.o(1, this.xqz) + 0) + e.a.a.b.b.a.o(2, this.vIs);
            if (this.xqA != null) {
                o += e.a.a.b.b.a.f(3, this.xqA);
            }
            o += e.a.a.a.c(4, 8, this.xqB);
            AppMethodBeat.o(28736);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xqB.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            if (this.xqA == null) {
                bVar = new b("Not all required fields were included: TotalMsg");
                AppMethodBeat.o(28736);
                throw bVar;
            }
            AppMethodBeat.o(28736);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cty cty = (cty) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cty.xqz = aVar3.BTU.ve();
                    AppMethodBeat.o(28736);
                    return 0;
                case 2:
                    cty.vIs = aVar3.BTU.ve();
                    AppMethodBeat.o(28736);
                    return 0;
                case 3:
                    cty.xqA = aVar3.BTU.readString();
                    AppMethodBeat.o(28736);
                    return 0;
                case 4:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ctz ctz = new ctz();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ctz.populateBuilderWithField(aVar4, ctz, a.getNextFieldNumber(aVar4))) {
                        }
                        cty.xqB.add(ctz);
                    }
                    AppMethodBeat.o(28736);
                    return 0;
                default:
                    AppMethodBeat.o(28736);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28736);
            return -1;
        }
    }
}
