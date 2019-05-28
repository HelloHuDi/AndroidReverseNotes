package com.tencent.mm.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class b extends a {
    public String apkMd5;
    public int cdf;
    public String cdg;
    public int cdh;
    public String cdi;
    public String cdj;
    public boolean cdk;
    public int cdl;
    public boolean cdm;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(125684);
        e.a.a.b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.apkMd5 == null) {
                bVar = new e.a.a.b("Not all required fields were included: apkMd5");
                AppMethodBeat.o(125684);
                throw bVar;
            }
            if (this.apkMd5 != null) {
                aVar.e(1, this.apkMd5);
            }
            aVar.iA(2, this.cdf);
            if (this.cdg != null) {
                aVar.e(3, this.cdg);
            }
            aVar.iA(4, this.cdh);
            if (this.cdi != null) {
                aVar.e(5, this.cdi);
            }
            if (this.cdj != null) {
                aVar.e(6, this.cdj);
            }
            aVar.aO(7, this.cdk);
            aVar.iA(8, this.cdl);
            aVar.aO(9, this.cdm);
            AppMethodBeat.o(125684);
            return 0;
        } else if (i == 1) {
            if (this.apkMd5 != null) {
                f = e.a.a.a.f(1, this.apkMd5) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.a.iw(2, this.cdf);
            if (this.cdg != null) {
                f += e.a.a.a.f(3, this.cdg);
            }
            f += e.a.a.a.iw(4, this.cdh);
            if (this.cdi != null) {
                f += e.a.a.a.f(5, this.cdi);
            }
            if (this.cdj != null) {
                f += e.a.a.a.f(6, this.cdj);
            }
            int Vg = ((f + e.a.a.a.Vg(7)) + e.a.a.a.iw(8, this.cdl)) + e.a.a.a.Vg(9);
            AppMethodBeat.o(125684);
            return Vg;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.apkMd5 == null) {
                bVar = new e.a.a.b("Not all required fields were included: apkMd5");
                AppMethodBeat.o(125684);
                throw bVar;
            }
            AppMethodBeat.o(125684);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            b bVar2 = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar2.apkMd5 = aVar3.emq();
                    AppMethodBeat.o(125684);
                    return 0;
                case 2:
                    bVar2.cdf = aVar3.emp();
                    AppMethodBeat.o(125684);
                    return 0;
                case 3:
                    bVar2.cdg = aVar3.emq();
                    AppMethodBeat.o(125684);
                    return 0;
                case 4:
                    bVar2.cdh = aVar3.emp();
                    AppMethodBeat.o(125684);
                    return 0;
                case 5:
                    bVar2.cdi = aVar3.emq();
                    AppMethodBeat.o(125684);
                    return 0;
                case 6:
                    bVar2.cdj = aVar3.emq();
                    AppMethodBeat.o(125684);
                    return 0;
                case 7:
                    bVar2.cdk = aVar3.emr();
                    AppMethodBeat.o(125684);
                    return 0;
                case 8:
                    bVar2.cdl = aVar3.emp();
                    AppMethodBeat.o(125684);
                    return 0;
                case 9:
                    bVar2.cdm = aVar3.emr();
                    AppMethodBeat.o(125684);
                    return 0;
                default:
                    AppMethodBeat.o(125684);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125684);
            return -1;
        }
    }
}
