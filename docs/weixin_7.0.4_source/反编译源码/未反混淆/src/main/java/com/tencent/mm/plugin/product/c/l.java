package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public class l extends a {
    public String phU;
    public int phV;
    public LinkedList<e> phW = new LinkedList();
    public int phq;
    public String url;

    public l() {
        AppMethodBeat.i(56635);
        AppMethodBeat.o(56635);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56636);
        b bVar;
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.phU == null) {
                bVar = new b("Not all required fields were included: id_info");
                AppMethodBeat.o(56636);
                throw bVar;
            }
            if (this.phU != null) {
                aVar.e(1, this.phU);
            }
            aVar.iz(2, this.phV);
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            aVar.e(4, 8, this.phW);
            aVar.iz(5, this.phq);
            AppMethodBeat.o(56636);
            return 0;
        } else if (i == 1) {
            if (this.phU != null) {
                f = e.a.a.b.b.a.f(1, this.phU) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.phV);
            if (this.url != null) {
                f += e.a.a.b.b.a.f(3, this.url);
            }
            int c = (f + e.a.a.a.c(4, 8, this.phW)) + e.a.a.b.b.a.bs(5, this.phq);
            AppMethodBeat.o(56636);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.phW.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.phU == null) {
                bVar = new b("Not all required fields were included: id_info");
                AppMethodBeat.o(56636);
                throw bVar;
            }
            AppMethodBeat.o(56636);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    lVar.phU = aVar3.BTU.readString();
                    AppMethodBeat.o(56636);
                    return 0;
                case 2:
                    lVar.phV = aVar3.BTU.vd();
                    AppMethodBeat.o(56636);
                    return 0;
                case 3:
                    lVar.url = aVar3.BTU.readString();
                    AppMethodBeat.o(56636);
                    return 0;
                case 4:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        e eVar = new e();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.populateBuilderWithField(aVar4, eVar, a.getNextFieldNumber(aVar4))) {
                        }
                        lVar.phW.add(eVar);
                    }
                    AppMethodBeat.o(56636);
                    return 0;
                case 5:
                    lVar.phq = aVar3.BTU.vd();
                    AppMethodBeat.o(56636);
                    return 0;
                default:
                    AppMethodBeat.o(56636);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56636);
            return -1;
        }
    }
}
