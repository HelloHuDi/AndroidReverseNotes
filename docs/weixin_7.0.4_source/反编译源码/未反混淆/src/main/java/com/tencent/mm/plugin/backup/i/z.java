package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class z extends a {
    public String jBt;
    public long jCE;
    public long jCF;
    public String jCG;
    public String jCH;
    public LinkedList<String> jCl = new LinkedList();

    public z() {
        AppMethodBeat.i(18074);
        AppMethodBeat.o(18074);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(18075);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.jBt == null) {
                bVar = new b("Not all required fields were included: BakChatName");
                AppMethodBeat.o(18075);
                throw bVar;
            } else if (this.jCG == null) {
                bVar = new b("Not all required fields were included: MsgDataID");
                AppMethodBeat.o(18075);
                throw bVar;
            } else if (this.jCH == null) {
                bVar = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(18075);
                throw bVar;
            } else {
                if (this.jBt != null) {
                    aVar.e(1, this.jBt);
                }
                aVar.ai(2, this.jCE);
                aVar.ai(3, this.jCF);
                if (this.jCG != null) {
                    aVar.e(4, this.jCG);
                }
                if (this.jCH != null) {
                    aVar.e(5, this.jCH);
                }
                aVar.e(6, 1, this.jCl);
                AppMethodBeat.o(18075);
                return 0;
            }
        } else if (i == 1) {
            if (this.jBt != null) {
                f = e.a.a.b.b.a.f(1, this.jBt) + 0;
            } else {
                f = 0;
            }
            f = (f + e.a.a.b.b.a.o(2, this.jCE)) + e.a.a.b.b.a.o(3, this.jCF);
            if (this.jCG != null) {
                f += e.a.a.b.b.a.f(4, this.jCG);
            }
            if (this.jCH != null) {
                f += e.a.a.b.b.a.f(5, this.jCH);
            }
            int c = f + e.a.a.a.c(6, 1, this.jCl);
            AppMethodBeat.o(18075);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.jCl.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.jBt == null) {
                bVar = new b("Not all required fields were included: BakChatName");
                AppMethodBeat.o(18075);
                throw bVar;
            } else if (this.jCG == null) {
                bVar = new b("Not all required fields were included: MsgDataID");
                AppMethodBeat.o(18075);
                throw bVar;
            } else if (this.jCH == null) {
                bVar = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(18075);
                throw bVar;
            } else {
                AppMethodBeat.o(18075);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            z zVar = (z) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    zVar.jBt = aVar3.BTU.readString();
                    AppMethodBeat.o(18075);
                    return 0;
                case 2:
                    zVar.jCE = aVar3.BTU.ve();
                    AppMethodBeat.o(18075);
                    return 0;
                case 3:
                    zVar.jCF = aVar3.BTU.ve();
                    AppMethodBeat.o(18075);
                    return 0;
                case 4:
                    zVar.jCG = aVar3.BTU.readString();
                    AppMethodBeat.o(18075);
                    return 0;
                case 5:
                    zVar.jCH = aVar3.BTU.readString();
                    AppMethodBeat.o(18075);
                    return 0;
                case 6:
                    zVar.jCl.add(aVar3.BTU.readString());
                    AppMethodBeat.o(18075);
                    return 0;
                default:
                    AppMethodBeat.o(18075);
                    return -1;
            }
        } else {
            AppMethodBeat.o(18075);
            return -1;
        }
    }
}
