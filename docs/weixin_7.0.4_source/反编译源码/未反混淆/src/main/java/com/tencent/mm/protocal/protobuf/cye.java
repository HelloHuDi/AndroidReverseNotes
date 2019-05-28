package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public class cye extends a {
    public String IconUrl;
    public String fKh;
    public String jBB;
    public String nay;
    public String ncH;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(93819);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.fKh == null) {
                bVar = new b("Not all required fields were included: AppId");
                AppMethodBeat.o(93819);
                throw bVar;
            } else if (this.ncH == null) {
                bVar = new b("Not all required fields were included: AppName");
                AppMethodBeat.o(93819);
                throw bVar;
            } else if (this.jBB == null) {
                bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(93819);
                throw bVar;
            } else if (this.IconUrl == null) {
                bVar = new b("Not all required fields were included: IconUrl");
                AppMethodBeat.o(93819);
                throw bVar;
            } else {
                if (this.fKh != null) {
                    aVar.e(1, this.fKh);
                }
                if (this.ncH != null) {
                    aVar.e(2, this.ncH);
                }
                if (this.jBB != null) {
                    aVar.e(3, this.jBB);
                }
                if (this.IconUrl != null) {
                    aVar.e(4, this.IconUrl);
                }
                if (this.nay != null) {
                    aVar.e(5, this.nay);
                }
                AppMethodBeat.o(93819);
                return 0;
            }
        } else if (i == 1) {
            if (this.fKh != null) {
                f = e.a.a.b.b.a.f(1, this.fKh) + 0;
            } else {
                f = 0;
            }
            if (this.ncH != null) {
                f += e.a.a.b.b.a.f(2, this.ncH);
            }
            if (this.jBB != null) {
                f += e.a.a.b.b.a.f(3, this.jBB);
            }
            if (this.IconUrl != null) {
                f += e.a.a.b.b.a.f(4, this.IconUrl);
            }
            if (this.nay != null) {
                f += e.a.a.b.b.a.f(5, this.nay);
            }
            AppMethodBeat.o(93819);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.fKh == null) {
                bVar = new b("Not all required fields were included: AppId");
                AppMethodBeat.o(93819);
                throw bVar;
            } else if (this.ncH == null) {
                bVar = new b("Not all required fields were included: AppName");
                AppMethodBeat.o(93819);
                throw bVar;
            } else if (this.jBB == null) {
                bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(93819);
                throw bVar;
            } else if (this.IconUrl == null) {
                bVar = new b("Not all required fields were included: IconUrl");
                AppMethodBeat.o(93819);
                throw bVar;
            } else {
                AppMethodBeat.o(93819);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cye cye = (cye) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cye.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(93819);
                    return 0;
                case 2:
                    cye.ncH = aVar3.BTU.readString();
                    AppMethodBeat.o(93819);
                    return 0;
                case 3:
                    cye.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(93819);
                    return 0;
                case 4:
                    cye.IconUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(93819);
                    return 0;
                case 5:
                    cye.nay = aVar3.BTU.readString();
                    AppMethodBeat.o(93819);
                    return 0;
                default:
                    AppMethodBeat.o(93819);
                    return -1;
            }
        } else {
            AppMethodBeat.o(93819);
            return -1;
        }
    }
}
