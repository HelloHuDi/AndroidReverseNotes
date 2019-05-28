package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class aat extends a {
    public String appId;
    public String cEV;
    public String cJb;
    public String cOS;
    public long createTime;
    public String csl;
    public int cvp;
    public boolean fDT = false;
    public String link;
    public String toUser;
    public boolean whP = false;
    public boolean whQ = false;
    public boolean whR = false;
    public String whS;
    public boolean whT = false;
    public String whU;
    public boolean whV = false;
    public boolean whW = false;
    public boolean whX = false;
    public boolean whY = false;
    public boolean whZ = false;
    public String wia;
    public boolean wib = false;
    public boolean wic = false;

    public final aat LI(int i) {
        this.cvp = i;
        this.whP = true;
        return this;
    }

    public final aat alm(String str) {
        this.cEV = str;
        this.whQ = true;
        return this;
    }

    public final aat aln(String str) {
        this.toUser = str;
        this.whR = true;
        return this;
    }

    public final aat alo(String str) {
        this.whS = str;
        this.whT = true;
        return this;
    }

    public final aat alp(String str) {
        this.whU = str;
        this.whV = true;
        return this;
    }

    public final aat mi(long j) {
        this.createTime = j;
        this.fDT = true;
        return this;
    }

    public final aat alq(String str) {
        this.cJb = str;
        this.whW = true;
        return this;
    }

    public final aat alr(String str) {
        this.appId = str;
        this.whY = true;
        return this;
    }

    public final aat als(String str) {
        this.link = str;
        this.whZ = true;
        return this;
    }

    public final aat alt(String str) {
        this.csl = str;
        this.wic = true;
        return this;
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51392);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.whP) {
                if (this.whP) {
                    aVar.iz(1, this.cvp);
                }
                if (this.cEV != null) {
                    aVar.e(2, this.cEV);
                }
                if (this.toUser != null) {
                    aVar.e(3, this.toUser);
                }
                if (this.whS != null) {
                    aVar.e(4, this.whS);
                }
                if (this.whU != null) {
                    aVar.e(5, this.whU);
                }
                if (this.fDT) {
                    aVar.ai(6, this.createTime);
                }
                if (this.cJb != null) {
                    aVar.e(7, this.cJb);
                }
                if (this.cOS != null) {
                    aVar.e(8, this.cOS);
                }
                if (this.appId != null) {
                    aVar.e(9, this.appId);
                }
                if (this.link != null) {
                    aVar.e(10, this.link);
                }
                if (this.wia != null) {
                    aVar.e(11, this.wia);
                }
                if (this.csl != null) {
                    aVar.e(12, this.csl);
                }
                AppMethodBeat.o(51392);
                return 0;
            }
            bVar = new b("Not all required fields were included: sourceType");
            AppMethodBeat.o(51392);
            throw bVar;
        } else if (i == 1) {
            if (this.whP) {
                bs = e.a.a.b.b.a.bs(1, this.cvp) + 0;
            } else {
                bs = 0;
            }
            if (this.cEV != null) {
                bs += e.a.a.b.b.a.f(2, this.cEV);
            }
            if (this.toUser != null) {
                bs += e.a.a.b.b.a.f(3, this.toUser);
            }
            if (this.whS != null) {
                bs += e.a.a.b.b.a.f(4, this.whS);
            }
            if (this.whU != null) {
                bs += e.a.a.b.b.a.f(5, this.whU);
            }
            if (this.fDT) {
                bs += e.a.a.b.b.a.o(6, this.createTime);
            }
            if (this.cJb != null) {
                bs += e.a.a.b.b.a.f(7, this.cJb);
            }
            if (this.cOS != null) {
                bs += e.a.a.b.b.a.f(8, this.cOS);
            }
            if (this.appId != null) {
                bs += e.a.a.b.b.a.f(9, this.appId);
            }
            if (this.link != null) {
                bs += e.a.a.b.b.a.f(10, this.link);
            }
            if (this.wia != null) {
                bs += e.a.a.b.b.a.f(11, this.wia);
            }
            if (this.csl != null) {
                bs += e.a.a.b.b.a.f(12, this.csl);
            }
            AppMethodBeat.o(51392);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.whP) {
                AppMethodBeat.o(51392);
                return 0;
            }
            bVar = new b("Not all required fields were included: sourceType");
            AppMethodBeat.o(51392);
            throw bVar;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aat aat = (aat) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aat.cvp = aVar3.BTU.vd();
                    aat.whP = true;
                    AppMethodBeat.o(51392);
                    return 0;
                case 2:
                    aat.cEV = aVar3.BTU.readString();
                    aat.whQ = true;
                    AppMethodBeat.o(51392);
                    return 0;
                case 3:
                    aat.toUser = aVar3.BTU.readString();
                    aat.whR = true;
                    AppMethodBeat.o(51392);
                    return 0;
                case 4:
                    aat.whS = aVar3.BTU.readString();
                    aat.whT = true;
                    AppMethodBeat.o(51392);
                    return 0;
                case 5:
                    aat.whU = aVar3.BTU.readString();
                    aat.whV = true;
                    AppMethodBeat.o(51392);
                    return 0;
                case 6:
                    aat.createTime = aVar3.BTU.ve();
                    aat.fDT = true;
                    AppMethodBeat.o(51392);
                    return 0;
                case 7:
                    aat.cJb = aVar3.BTU.readString();
                    aat.whW = true;
                    AppMethodBeat.o(51392);
                    return 0;
                case 8:
                    aat.cOS = aVar3.BTU.readString();
                    aat.whX = true;
                    AppMethodBeat.o(51392);
                    return 0;
                case 9:
                    aat.appId = aVar3.BTU.readString();
                    aat.whY = true;
                    AppMethodBeat.o(51392);
                    return 0;
                case 10:
                    aat.link = aVar3.BTU.readString();
                    aat.whZ = true;
                    AppMethodBeat.o(51392);
                    return 0;
                case 11:
                    aat.wia = aVar3.BTU.readString();
                    aat.wib = true;
                    AppMethodBeat.o(51392);
                    return 0;
                case 12:
                    aat.csl = aVar3.BTU.readString();
                    aat.wic = true;
                    AppMethodBeat.o(51392);
                    return 0;
                default:
                    AppMethodBeat.o(51392);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51392);
            return -1;
        }
    }
}
