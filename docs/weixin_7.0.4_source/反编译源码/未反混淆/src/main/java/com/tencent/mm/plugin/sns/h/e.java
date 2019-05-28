package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.protocal.protobuf.cao;
import e.a.a.b;
import java.util.LinkedList;

public final class e extends a {
    public cao qIS;
    public String qQm;
    public int qQn;
    public String qQo;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(36828);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.qQm == null) {
                bVar = new b("Not all required fields were included: clientID");
                AppMethodBeat.o(36828);
                throw bVar;
            } else if (this.qIS == null) {
                bVar = new b("Not all required fields were included: actionGroup");
                AppMethodBeat.o(36828);
                throw bVar;
            } else {
                if (this.qQm != null) {
                    aVar.e(1, this.qQm);
                }
                if (this.qIS != null) {
                    aVar.iy(2, this.qIS.computeSize());
                    this.qIS.writeFields(aVar);
                }
                aVar.iz(3, this.qQn);
                if (this.qQo != null) {
                    aVar.e(4, this.qQo);
                }
                AppMethodBeat.o(36828);
                return 0;
            }
        } else if (i == 1) {
            if (this.qQm != null) {
                f = e.a.a.b.b.a.f(1, this.qQm) + 0;
            } else {
                f = 0;
            }
            if (this.qIS != null) {
                f += e.a.a.a.ix(2, this.qIS.computeSize());
            }
            f += e.a.a.b.b.a.bs(3, this.qQn);
            if (this.qQo != null) {
                f += e.a.a.b.b.a.f(4, this.qQo);
            }
            AppMethodBeat.o(36828);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.qQm == null) {
                bVar = new b("Not all required fields were included: clientID");
                AppMethodBeat.o(36828);
                throw bVar;
            } else if (this.qIS == null) {
                bVar = new b("Not all required fields were included: actionGroup");
                AppMethodBeat.o(36828);
                throw bVar;
            } else {
                AppMethodBeat.o(36828);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eVar.qQm = aVar3.BTU.readString();
                    AppMethodBeat.o(36828);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        cao cao = new cao();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cao.populateBuilderWithField(aVar4, cao, a.getNextFieldNumber(aVar4))) {
                        }
                        eVar.qIS = cao;
                    }
                    AppMethodBeat.o(36828);
                    return 0;
                case 3:
                    eVar.qQn = aVar3.BTU.vd();
                    AppMethodBeat.o(36828);
                    return 0;
                case 4:
                    eVar.qQo = aVar3.BTU.readString();
                    AppMethodBeat.o(36828);
                    return 0;
                default:
                    AppMethodBeat.o(36828);
                    return -1;
            }
        } else {
            AppMethodBeat.o(36828);
            return -1;
        }
    }
}
