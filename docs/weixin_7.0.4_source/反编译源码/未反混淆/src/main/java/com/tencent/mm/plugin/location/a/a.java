package com.tencent.mm.plugin.location.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bt.a {
    public LinkedList<String> cGh = new LinkedList();
    public double latitude;
    public double longitude;
    public String nJq;
    public long timestamp;
    public String username;

    public a() {
        AppMethodBeat.i(113289);
        AppMethodBeat.o(113289);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(113290);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username == null) {
                bVar = new b("Not all required fields were included: username");
                AppMethodBeat.o(113290);
                throw bVar;
            }
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            aVar.e(2, 1, this.cGh);
            aVar.f(3, this.longitude);
            aVar.f(4, this.latitude);
            if (this.nJq != null) {
                aVar.e(5, this.nJq);
            }
            aVar.ai(6, this.timestamp);
            AppMethodBeat.o(113290);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                f = e.a.a.b.b.a.f(1, this.username) + 0;
            } else {
                f = 0;
            }
            f = ((f + e.a.a.a.c(2, 1, this.cGh)) + (e.a.a.b.b.a.fv(3) + 8)) + (e.a.a.b.b.a.fv(4) + 8);
            if (this.nJq != null) {
                f += e.a.a.b.b.a.f(5, this.nJq);
            }
            int o = f + e.a.a.b.b.a.o(6, this.timestamp);
            AppMethodBeat.o(113290);
            return o;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.cGh.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); f > 0; f = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.username == null) {
                bVar = new b("Not all required fields were included: username");
                AppMethodBeat.o(113290);
                throw bVar;
            }
            AppMethodBeat.o(113290);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.username = aVar3.BTU.readString();
                    AppMethodBeat.o(113290);
                    return 0;
                case 2:
                    aVar4.cGh.add(aVar3.BTU.readString());
                    AppMethodBeat.o(113290);
                    return 0;
                case 3:
                    aVar4.longitude = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(113290);
                    return 0;
                case 4:
                    aVar4.latitude = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(113290);
                    return 0;
                case 5:
                    aVar4.nJq = aVar3.BTU.readString();
                    AppMethodBeat.o(113290);
                    return 0;
                case 6:
                    aVar4.timestamp = aVar3.BTU.ve();
                    AppMethodBeat.o(113290);
                    return 0;
                default:
                    AppMethodBeat.o(113290);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113290);
            return -1;
        }
    }
}
