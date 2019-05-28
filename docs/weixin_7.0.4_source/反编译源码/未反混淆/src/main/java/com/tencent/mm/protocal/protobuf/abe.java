package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class abe extends a {
    public String desc;
    public String info;
    public String thumbUrl;
    public String title;
    public int type;
    public boolean wfS = false;
    public boolean wfT = false;
    public boolean wiq = false;
    public boolean wir = false;
    public boolean wis = false;

    public final abe alw(String str) {
        this.title = str;
        this.wfS = true;
        return this;
    }

    public final abe alx(String str) {
        this.desc = str;
        this.wfT = true;
        return this;
    }

    public final abe aly(String str) {
        this.thumbUrl = str;
        this.wiq = true;
        return this;
    }

    public final abe alz(String str) {
        this.info = str;
        this.wir = true;
        return this;
    }

    public final abe LK(int i) {
        this.type = i;
        this.wis = true;
        return this;
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51403);
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
            if (this.wis) {
                aVar.iz(5, this.type);
            }
            AppMethodBeat.o(51403);
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
            if (this.wis) {
                f += e.a.a.b.b.a.bs(5, this.type);
            }
            AppMethodBeat.o(51403);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(51403);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            abe abe = (abe) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abe.title = aVar3.BTU.readString();
                    abe.wfS = true;
                    AppMethodBeat.o(51403);
                    return 0;
                case 2:
                    abe.desc = aVar3.BTU.readString();
                    abe.wfT = true;
                    AppMethodBeat.o(51403);
                    return 0;
                case 3:
                    abe.thumbUrl = aVar3.BTU.readString();
                    abe.wiq = true;
                    AppMethodBeat.o(51403);
                    return 0;
                case 4:
                    abe.info = aVar3.BTU.readString();
                    abe.wir = true;
                    AppMethodBeat.o(51403);
                    return 0;
                case 5:
                    abe.type = aVar3.BTU.vd();
                    abe.wis = true;
                    AppMethodBeat.o(51403);
                    return 0;
                default:
                    AppMethodBeat.o(51403);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51403);
            return -1;
        }
    }
}
