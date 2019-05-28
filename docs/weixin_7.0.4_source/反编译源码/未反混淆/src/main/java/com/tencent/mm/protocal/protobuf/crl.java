package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class crl extends a {
    public String username;
    public String xoP;
    public cql xoU;
    public String xpf;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(102423);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xoU == null) {
                bVar = new b("Not all required fields were included: base_request");
                AppMethodBeat.o(102423);
                throw bVar;
            }
            if (this.xoU != null) {
                aVar.iy(1, this.xoU.computeSize());
                this.xoU.writeFields(aVar);
            }
            if (this.username != null) {
                aVar.e(2, this.username);
            }
            if (this.xoP != null) {
                aVar.e(3, this.xoP);
            }
            if (this.xpf != null) {
                aVar.e(4, this.xpf);
            }
            AppMethodBeat.o(102423);
            return 0;
        } else if (i == 1) {
            if (this.xoU != null) {
                ix = e.a.a.a.ix(1, this.xoU.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.username != null) {
                ix += e.a.a.b.b.a.f(2, this.username);
            }
            if (this.xoP != null) {
                ix += e.a.a.b.b.a.f(3, this.xoP);
            }
            if (this.xpf != null) {
                ix += e.a.a.b.b.a.f(4, this.xpf);
            }
            AppMethodBeat.o(102423);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.xoU == null) {
                bVar = new b("Not all required fields were included: base_request");
                AppMethodBeat.o(102423);
                throw bVar;
            }
            AppMethodBeat.o(102423);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            crl crl = (crl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        cql cql = new cql();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cql.populateBuilderWithField(aVar4, cql, a.getNextFieldNumber(aVar4))) {
                        }
                        crl.xoU = cql;
                    }
                    AppMethodBeat.o(102423);
                    return 0;
                case 2:
                    crl.username = aVar3.BTU.readString();
                    AppMethodBeat.o(102423);
                    return 0;
                case 3:
                    crl.xoP = aVar3.BTU.readString();
                    AppMethodBeat.o(102423);
                    return 0;
                case 4:
                    crl.xpf = aVar3.BTU.readString();
                    AppMethodBeat.o(102423);
                    return 0;
                default:
                    AppMethodBeat.o(102423);
                    return -1;
            }
        } else {
            AppMethodBeat.o(102423);
            return -1;
        }
    }
}
