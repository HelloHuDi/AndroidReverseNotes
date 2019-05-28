package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class m extends a {
    public String jBE;
    public String jBF;
    public String jBG;
    public String jBH;
    public String jBI;
    public int jBJ;
    public long jBK;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(18060);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.jBE == null) {
                bVar = new b("Not all required fields were included: DeviceID");
                AppMethodBeat.o(18060);
                throw bVar;
            } else if (this.jBF == null) {
                bVar = new b("Not all required fields were included: DeviceName");
                AppMethodBeat.o(18060);
                throw bVar;
            } else if (this.jBG == null) {
                bVar = new b("Not all required fields were included: Model");
                AppMethodBeat.o(18060);
                throw bVar;
            } else if (this.jBH == null) {
                bVar = new b("Not all required fields were included: SystemName");
                AppMethodBeat.o(18060);
                throw bVar;
            } else if (this.jBI == null) {
                bVar = new b("Not all required fields were included: SystemVersion");
                AppMethodBeat.o(18060);
                throw bVar;
            } else {
                if (this.jBE != null) {
                    aVar.e(1, this.jBE);
                }
                if (this.jBF != null) {
                    aVar.e(2, this.jBF);
                }
                if (this.jBG != null) {
                    aVar.e(3, this.jBG);
                }
                if (this.jBH != null) {
                    aVar.e(4, this.jBH);
                }
                if (this.jBI != null) {
                    aVar.e(5, this.jBI);
                }
                aVar.iz(6, this.jBJ);
                aVar.ai(7, this.jBK);
                AppMethodBeat.o(18060);
                return 0;
            }
        } else if (i == 1) {
            if (this.jBE != null) {
                f = e.a.a.b.b.a.f(1, this.jBE) + 0;
            } else {
                f = 0;
            }
            if (this.jBF != null) {
                f += e.a.a.b.b.a.f(2, this.jBF);
            }
            if (this.jBG != null) {
                f += e.a.a.b.b.a.f(3, this.jBG);
            }
            if (this.jBH != null) {
                f += e.a.a.b.b.a.f(4, this.jBH);
            }
            if (this.jBI != null) {
                f += e.a.a.b.b.a.f(5, this.jBI);
            }
            int bs = (f + e.a.a.b.b.a.bs(6, this.jBJ)) + e.a.a.b.b.a.o(7, this.jBK);
            AppMethodBeat.o(18060);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.jBE == null) {
                bVar = new b("Not all required fields were included: DeviceID");
                AppMethodBeat.o(18060);
                throw bVar;
            } else if (this.jBF == null) {
                bVar = new b("Not all required fields were included: DeviceName");
                AppMethodBeat.o(18060);
                throw bVar;
            } else if (this.jBG == null) {
                bVar = new b("Not all required fields were included: Model");
                AppMethodBeat.o(18060);
                throw bVar;
            } else if (this.jBH == null) {
                bVar = new b("Not all required fields were included: SystemName");
                AppMethodBeat.o(18060);
                throw bVar;
            } else if (this.jBI == null) {
                bVar = new b("Not all required fields were included: SystemVersion");
                AppMethodBeat.o(18060);
                throw bVar;
            } else {
                AppMethodBeat.o(18060);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            m mVar = (m) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mVar.jBE = aVar3.BTU.readString();
                    AppMethodBeat.o(18060);
                    return 0;
                case 2:
                    mVar.jBF = aVar3.BTU.readString();
                    AppMethodBeat.o(18060);
                    return 0;
                case 3:
                    mVar.jBG = aVar3.BTU.readString();
                    AppMethodBeat.o(18060);
                    return 0;
                case 4:
                    mVar.jBH = aVar3.BTU.readString();
                    AppMethodBeat.o(18060);
                    return 0;
                case 5:
                    mVar.jBI = aVar3.BTU.readString();
                    AppMethodBeat.o(18060);
                    return 0;
                case 6:
                    mVar.jBJ = aVar3.BTU.vd();
                    AppMethodBeat.o(18060);
                    return 0;
                case 7:
                    mVar.jBK = aVar3.BTU.ve();
                    AppMethodBeat.o(18060);
                    return 0;
                default:
                    AppMethodBeat.o(18060);
                    return -1;
            }
        } else {
            AppMethodBeat.o(18060);
            return -1;
        }
    }
}
