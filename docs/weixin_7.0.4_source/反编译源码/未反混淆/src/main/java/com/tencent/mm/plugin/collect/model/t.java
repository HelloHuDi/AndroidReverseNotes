package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public class t extends a {
    public String cAa;
    public String cuZ;
    public String eoz;
    public double kCJ;
    public String kCK;
    public int msgType;
    public int scene;
    public int status;
    public int timestamp;
    public String type;
    public String username;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56607);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username == null) {
                bVar = new b("Not all required fields were included: username");
                AppMethodBeat.o(56607);
                throw bVar;
            } else if (this.cAa == null) {
                bVar = new b("Not all required fields were included: transactionId");
                AppMethodBeat.o(56607);
                throw bVar;
            } else if (this.cuZ == null) {
                bVar = new b("Not all required fields were included: feeType");
                AppMethodBeat.o(56607);
                throw bVar;
            } else {
                if (this.username != null) {
                    aVar.e(1, this.username);
                }
                if (this.cAa != null) {
                    aVar.e(2, this.cAa);
                }
                aVar.f(3, this.kCJ);
                if (this.cuZ != null) {
                    aVar.e(4, this.cuZ);
                }
                aVar.iz(5, this.timestamp);
                aVar.iz(6, this.scene);
                aVar.iz(7, this.status);
                if (this.eoz != null) {
                    aVar.e(8, this.eoz);
                }
                if (this.kCK != null) {
                    aVar.e(9, this.kCK);
                }
                aVar.iz(10, this.msgType);
                if (this.type != null) {
                    aVar.e(11, this.type);
                }
                AppMethodBeat.o(56607);
                return 0;
            }
        } else if (i == 1) {
            if (this.username != null) {
                f = e.a.a.b.b.a.f(1, this.username) + 0;
            } else {
                f = 0;
            }
            if (this.cAa != null) {
                f += e.a.a.b.b.a.f(2, this.cAa);
            }
            f += e.a.a.b.b.a.fv(3) + 8;
            if (this.cuZ != null) {
                f += e.a.a.b.b.a.f(4, this.cuZ);
            }
            f = ((f + e.a.a.b.b.a.bs(5, this.timestamp)) + e.a.a.b.b.a.bs(6, this.scene)) + e.a.a.b.b.a.bs(7, this.status);
            if (this.eoz != null) {
                f += e.a.a.b.b.a.f(8, this.eoz);
            }
            if (this.kCK != null) {
                f += e.a.a.b.b.a.f(9, this.kCK);
            }
            f += e.a.a.b.b.a.bs(10, this.msgType);
            if (this.type != null) {
                f += e.a.a.b.b.a.f(11, this.type);
            }
            AppMethodBeat.o(56607);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.username == null) {
                bVar = new b("Not all required fields were included: username");
                AppMethodBeat.o(56607);
                throw bVar;
            } else if (this.cAa == null) {
                bVar = new b("Not all required fields were included: transactionId");
                AppMethodBeat.o(56607);
                throw bVar;
            } else if (this.cuZ == null) {
                bVar = new b("Not all required fields were included: feeType");
                AppMethodBeat.o(56607);
                throw bVar;
            } else {
                AppMethodBeat.o(56607);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            t tVar = (t) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tVar.username = aVar3.BTU.readString();
                    AppMethodBeat.o(56607);
                    return 0;
                case 2:
                    tVar.cAa = aVar3.BTU.readString();
                    AppMethodBeat.o(56607);
                    return 0;
                case 3:
                    tVar.kCJ = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(56607);
                    return 0;
                case 4:
                    tVar.cuZ = aVar3.BTU.readString();
                    AppMethodBeat.o(56607);
                    return 0;
                case 5:
                    tVar.timestamp = aVar3.BTU.vd();
                    AppMethodBeat.o(56607);
                    return 0;
                case 6:
                    tVar.scene = aVar3.BTU.vd();
                    AppMethodBeat.o(56607);
                    return 0;
                case 7:
                    tVar.status = aVar3.BTU.vd();
                    AppMethodBeat.o(56607);
                    return 0;
                case 8:
                    tVar.eoz = aVar3.BTU.readString();
                    AppMethodBeat.o(56607);
                    return 0;
                case 9:
                    tVar.kCK = aVar3.BTU.readString();
                    AppMethodBeat.o(56607);
                    return 0;
                case 10:
                    tVar.msgType = aVar3.BTU.vd();
                    AppMethodBeat.o(56607);
                    return 0;
                case 11:
                    tVar.type = aVar3.BTU.readString();
                    AppMethodBeat.o(56607);
                    return 0;
                default:
                    AppMethodBeat.o(56607);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56607);
            return -1;
        }
    }
}
