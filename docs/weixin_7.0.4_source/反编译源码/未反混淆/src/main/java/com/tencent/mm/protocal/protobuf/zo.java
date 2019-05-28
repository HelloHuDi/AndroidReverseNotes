package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class zo extends a {
    public String weG;
    public String weR;
    public LinkedList<String> weS = new LinkedList();
    public boolean weT;

    public zo() {
        AppMethodBeat.i(28399);
        AppMethodBeat.o(28399);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28400);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.weG == null) {
                bVar = new b("Not all required fields were included: LoginUrl");
                AppMethodBeat.o(28400);
                throw bVar;
            }
            if (this.weG != null) {
                aVar.e(1, this.weG);
            }
            if (this.weR != null) {
                aVar.e(2, this.weR);
            }
            aVar.e(3, 1, this.weS);
            aVar.aO(4, this.weT);
            AppMethodBeat.o(28400);
            return 0;
        } else if (i == 1) {
            if (this.weG != null) {
                f = e.a.a.b.b.a.f(1, this.weG) + 0;
            } else {
                f = 0;
            }
            if (this.weR != null) {
                f += e.a.a.b.b.a.f(2, this.weR);
            }
            int c = (f + e.a.a.a.c(3, 1, this.weS)) + (e.a.a.b.b.a.fv(4) + 1);
            AppMethodBeat.o(28400);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.weS.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.weG == null) {
                bVar = new b("Not all required fields were included: LoginUrl");
                AppMethodBeat.o(28400);
                throw bVar;
            }
            AppMethodBeat.o(28400);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            zo zoVar = (zo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    zoVar.weG = aVar3.BTU.readString();
                    AppMethodBeat.o(28400);
                    return 0;
                case 2:
                    zoVar.weR = aVar3.BTU.readString();
                    AppMethodBeat.o(28400);
                    return 0;
                case 3:
                    zoVar.weS.add(aVar3.BTU.readString());
                    AppMethodBeat.o(28400);
                    return 0;
                case 4:
                    zoVar.weT = aVar3.BTU.ehX();
                    AppMethodBeat.o(28400);
                    return 0;
                default:
                    AppMethodBeat.o(28400);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28400);
            return -1;
        }
    }
}
