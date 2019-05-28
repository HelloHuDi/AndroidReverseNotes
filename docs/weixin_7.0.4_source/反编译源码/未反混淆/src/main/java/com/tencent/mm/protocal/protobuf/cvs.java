package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class cvs extends a {
    public String Md5;
    public String vMJ;
    public int xrE;
    public int xrF;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(63699);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Md5 == null) {
                bVar = new b("Not all required fields were included: Md5");
                AppMethodBeat.o(63699);
                throw bVar;
            } else if (this.vMJ == null) {
                bVar = new b("Not all required fields were included: DownloadUrl");
                AppMethodBeat.o(63699);
                throw bVar;
            } else {
                if (this.Md5 != null) {
                    aVar.e(1, this.Md5);
                }
                if (this.vMJ != null) {
                    aVar.e(2, this.vMJ);
                }
                aVar.iz(3, this.xrE);
                aVar.iz(4, this.xrF);
                AppMethodBeat.o(63699);
                return 0;
            }
        } else if (i == 1) {
            if (this.Md5 != null) {
                f = e.a.a.b.b.a.f(1, this.Md5) + 0;
            } else {
                f = 0;
            }
            if (this.vMJ != null) {
                f += e.a.a.b.b.a.f(2, this.vMJ);
            }
            int bs = (f + e.a.a.b.b.a.bs(3, this.xrE)) + e.a.a.b.b.a.bs(4, this.xrF);
            AppMethodBeat.o(63699);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.Md5 == null) {
                bVar = new b("Not all required fields were included: Md5");
                AppMethodBeat.o(63699);
                throw bVar;
            } else if (this.vMJ == null) {
                bVar = new b("Not all required fields were included: DownloadUrl");
                AppMethodBeat.o(63699);
                throw bVar;
            } else {
                AppMethodBeat.o(63699);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cvs cvs = (cvs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cvs.Md5 = aVar3.BTU.readString();
                    AppMethodBeat.o(63699);
                    return 0;
                case 2:
                    cvs.vMJ = aVar3.BTU.readString();
                    AppMethodBeat.o(63699);
                    return 0;
                case 3:
                    cvs.xrE = aVar3.BTU.vd();
                    AppMethodBeat.o(63699);
                    return 0;
                case 4:
                    cvs.xrF = aVar3.BTU.vd();
                    AppMethodBeat.o(63699);
                    return 0;
                default:
                    AppMethodBeat.o(63699);
                    return -1;
            }
        } else {
            AppMethodBeat.o(63699);
            return -1;
        }
    }
}
