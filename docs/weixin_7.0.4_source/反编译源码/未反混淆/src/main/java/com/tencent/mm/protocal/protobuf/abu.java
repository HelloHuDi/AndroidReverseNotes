package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class abu extends a {
    public String canvasPageXml;
    public String desc;
    public int fgt;
    public String thumbUrl;
    public String title;
    public boolean wfS = false;
    public boolean wfT = false;
    public boolean whe = false;
    public String wiY;
    public boolean wiZ = false;
    public boolean wiq = false;
    public int wja;
    public boolean wjb = false;
    public boolean wjc = false;

    public final abu alQ(String str) {
        this.title = str;
        this.wfS = true;
        return this;
    }

    public final abu alR(String str) {
        this.desc = str;
        this.wfT = true;
        return this;
    }

    public final abu alS(String str) {
        this.wiY = str;
        this.wiZ = true;
        return this;
    }

    public final abu alT(String str) {
        this.thumbUrl = str;
        this.wiq = true;
        return this;
    }

    public final abu LO(int i) {
        this.wja = i;
        this.wjb = true;
        return this;
    }

    public final abu LP(int i) {
        this.fgt = i;
        this.wjc = true;
        return this;
    }

    public final abu alU(String str) {
        this.canvasPageXml = str;
        this.whe = true;
        return this;
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51424);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            if (this.wiY != null) {
                aVar.e(3, this.wiY);
            }
            if (this.thumbUrl != null) {
                aVar.e(4, this.thumbUrl);
            }
            if (this.wjb) {
                aVar.iz(5, this.wja);
            }
            if (this.wjc) {
                aVar.iz(6, this.fgt);
            }
            if (this.canvasPageXml != null) {
                aVar.e(7, this.canvasPageXml);
            }
            AppMethodBeat.o(51424);
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
            if (this.wiY != null) {
                f += e.a.a.b.b.a.f(3, this.wiY);
            }
            if (this.thumbUrl != null) {
                f += e.a.a.b.b.a.f(4, this.thumbUrl);
            }
            if (this.wjb) {
                f += e.a.a.b.b.a.bs(5, this.wja);
            }
            if (this.wjc) {
                f += e.a.a.b.b.a.bs(6, this.fgt);
            }
            if (this.canvasPageXml != null) {
                f += e.a.a.b.b.a.f(7, this.canvasPageXml);
            }
            AppMethodBeat.o(51424);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(51424);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            abu abu = (abu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abu.title = aVar3.BTU.readString();
                    abu.wfS = true;
                    AppMethodBeat.o(51424);
                    return 0;
                case 2:
                    abu.desc = aVar3.BTU.readString();
                    abu.wfT = true;
                    AppMethodBeat.o(51424);
                    return 0;
                case 3:
                    abu.wiY = aVar3.BTU.readString();
                    abu.wiZ = true;
                    AppMethodBeat.o(51424);
                    return 0;
                case 4:
                    abu.thumbUrl = aVar3.BTU.readString();
                    abu.wiq = true;
                    AppMethodBeat.o(51424);
                    return 0;
                case 5:
                    abu.wja = aVar3.BTU.vd();
                    abu.wjb = true;
                    AppMethodBeat.o(51424);
                    return 0;
                case 6:
                    abu.fgt = aVar3.BTU.vd();
                    abu.wjc = true;
                    AppMethodBeat.o(51424);
                    return 0;
                case 7:
                    abu.canvasPageXml = aVar3.BTU.readString();
                    abu.whe = true;
                    AppMethodBeat.o(51424);
                    return 0;
                default:
                    AppMethodBeat.o(51424);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51424);
            return -1;
        }
    }
}
