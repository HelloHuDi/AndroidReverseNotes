package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bhv extends a {
    public String key;
    public String pPk;
    public String value;
    public LinkedList<String> wLa = new LinkedList();

    public bhv() {
        AppMethodBeat.i(90695);
        AppMethodBeat.o(90695);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(90696);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.key == null) {
                bVar = new b("Not all required fields were included: key");
                AppMethodBeat.o(90696);
                throw bVar;
            } else if (this.value == null) {
                bVar = new b("Not all required fields were included: value");
                AppMethodBeat.o(90696);
                throw bVar;
            } else {
                if (this.key != null) {
                    aVar.e(1, this.key);
                }
                if (this.value != null) {
                    aVar.e(2, this.value);
                }
                if (this.pPk != null) {
                    aVar.e(3, this.pPk);
                }
                aVar.e(4, 1, this.wLa);
                AppMethodBeat.o(90696);
                return 0;
            }
        } else if (i == 1) {
            if (this.key != null) {
                f = e.a.a.b.b.a.f(1, this.key) + 0;
            } else {
                f = 0;
            }
            if (this.value != null) {
                f += e.a.a.b.b.a.f(2, this.value);
            }
            if (this.pPk != null) {
                f += e.a.a.b.b.a.f(3, this.pPk);
            }
            int c = f + e.a.a.a.c(4, 1, this.wLa);
            AppMethodBeat.o(90696);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wLa.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.key == null) {
                bVar = new b("Not all required fields were included: key");
                AppMethodBeat.o(90696);
                throw bVar;
            } else if (this.value == null) {
                bVar = new b("Not all required fields were included: value");
                AppMethodBeat.o(90696);
                throw bVar;
            } else {
                AppMethodBeat.o(90696);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bhv bhv = (bhv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bhv.key = aVar3.BTU.readString();
                    AppMethodBeat.o(90696);
                    return 0;
                case 2:
                    bhv.value = aVar3.BTU.readString();
                    AppMethodBeat.o(90696);
                    return 0;
                case 3:
                    bhv.pPk = aVar3.BTU.readString();
                    AppMethodBeat.o(90696);
                    return 0;
                case 4:
                    bhv.wLa.add(aVar3.BTU.readString());
                    AppMethodBeat.o(90696);
                    return 0;
                default:
                    AppMethodBeat.o(90696);
                    return -1;
            }
        } else {
            AppMethodBeat.o(90696);
            return -1;
        }
    }
}
