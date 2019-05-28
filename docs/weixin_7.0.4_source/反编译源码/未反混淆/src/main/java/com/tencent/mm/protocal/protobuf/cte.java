package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cte extends a {
    public String Desc;
    public LinkedList<acc> xqk = new LinkedList();
    public String xql;

    public cte() {
        AppMethodBeat.i(63691);
        AppMethodBeat.o(63691);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(63692);
        b bVar;
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xql == null) {
                bVar = new b("Not all required fields were included: Charset");
                AppMethodBeat.o(63692);
                throw bVar;
            }
            aVar.e(1, 8, this.xqk);
            if (this.xql != null) {
                aVar.e(2, this.xql);
            }
            if (this.Desc != null) {
                aVar.e(3, this.Desc);
            }
            AppMethodBeat.o(63692);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.xqk) + 0;
            if (this.xql != null) {
                c += e.a.a.b.b.a.f(2, this.xql);
            }
            if (this.Desc != null) {
                c += e.a.a.b.b.a.f(3, this.Desc);
            }
            AppMethodBeat.o(63692);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xqk.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            if (this.xql == null) {
                bVar = new b("Not all required fields were included: Charset");
                AppMethodBeat.o(63692);
                throw bVar;
            }
            AppMethodBeat.o(63692);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cte cte = (cte) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        acc acc = new acc();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = acc.populateBuilderWithField(aVar4, acc, a.getNextFieldNumber(aVar4))) {
                        }
                        cte.xqk.add(acc);
                    }
                    AppMethodBeat.o(63692);
                    return 0;
                case 2:
                    cte.xql = aVar3.BTU.readString();
                    AppMethodBeat.o(63692);
                    return 0;
                case 3:
                    cte.Desc = aVar3.BTU.readString();
                    AppMethodBeat.o(63692);
                    return 0;
                default:
                    AppMethodBeat.o(63692);
                    return -1;
            }
        } else {
            AppMethodBeat.o(63692);
            return -1;
        }
    }
}
