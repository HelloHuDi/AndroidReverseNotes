package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class abo extends a {
    public String desc;
    public String info;
    public String thumbUrl;
    public String title;
    public boolean wfS = false;
    public boolean wfT = false;
    public boolean wiq = false;
    public boolean wir = false;

    public final abo alM(String str) {
        this.title = str;
        this.wfS = true;
        return this;
    }

    public final abo alN(String str) {
        this.desc = str;
        this.wfT = true;
        return this;
    }

    public final abo alO(String str) {
        this.thumbUrl = str;
        this.wiq = true;
        return this;
    }

    public final abo alP(String str) {
        this.info = str;
        this.wir = true;
        return this;
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51415);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            if (this.thumbUrl != null) {
                aVar.e(3, this.thumbUrl);
            }
            if (this.info != null) {
                aVar.e(4, this.info);
            }
            AppMethodBeat.o(51415);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = e.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.desc != null) {
                f += e.a.a.b.b.a.f(2, this.desc);
            }
            if (this.thumbUrl != null) {
                f += e.a.a.b.b.a.f(3, this.thumbUrl);
            }
            if (this.info != null) {
                f += e.a.a.b.b.a.f(4, this.info);
            }
            AppMethodBeat.o(51415);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(51415);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            abo abo = (abo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abo.title = aVar3.BTU.readString();
                    abo.wfS = true;
                    AppMethodBeat.o(51415);
                    return 0;
                case 2:
                    abo.desc = aVar3.BTU.readString();
                    abo.wfT = true;
                    AppMethodBeat.o(51415);
                    return 0;
                case 3:
                    abo.thumbUrl = aVar3.BTU.readString();
                    abo.wiq = true;
                    AppMethodBeat.o(51415);
                    return 0;
                case 4:
                    abo.info = aVar3.BTU.readString();
                    abo.wir = true;
                    AppMethodBeat.o(51415);
                    return 0;
                default:
                    AppMethodBeat.o(51415);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51415);
            return -1;
        }
    }
}
