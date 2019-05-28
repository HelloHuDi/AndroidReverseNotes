package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class dg extends a {
    public String cEh;
    public int type;
    public String url;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56703);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.cEh == null) {
                bVar = new b("Not all required fields were included: wording");
                AppMethodBeat.o(56703);
                throw bVar;
            } else if (this.url == null) {
                bVar = new b("Not all required fields were included: url");
                AppMethodBeat.o(56703);
                throw bVar;
            } else {
                aVar.iz(1, this.type);
                if (this.cEh != null) {
                    aVar.e(2, this.cEh);
                }
                if (this.url != null) {
                    aVar.e(3, this.url);
                }
                AppMethodBeat.o(56703);
                return 0;
            }
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.type) + 0;
            if (this.cEh != null) {
                bs += e.a.a.b.b.a.f(2, this.cEh);
            }
            if (this.url != null) {
                bs += e.a.a.b.b.a.f(3, this.url);
            }
            AppMethodBeat.o(56703);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.cEh == null) {
                bVar = new b("Not all required fields were included: wording");
                AppMethodBeat.o(56703);
                throw bVar;
            } else if (this.url == null) {
                bVar = new b("Not all required fields were included: url");
                AppMethodBeat.o(56703);
                throw bVar;
            } else {
                AppMethodBeat.o(56703);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dg dgVar = (dg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dgVar.type = aVar3.BTU.vd();
                    AppMethodBeat.o(56703);
                    return 0;
                case 2:
                    dgVar.cEh = aVar3.BTU.readString();
                    AppMethodBeat.o(56703);
                    return 0;
                case 3:
                    dgVar.url = aVar3.BTU.readString();
                    AppMethodBeat.o(56703);
                    return 0;
                default:
                    AppMethodBeat.o(56703);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56703);
            return -1;
        }
    }
}
