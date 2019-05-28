package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public final class abl extends a {
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
    public String whU;
    public boolean whV = false;
    public boolean whW = false;
    public boolean whX = false;
    public boolean whY = false;
    public boolean whZ = false;
    public String wiC;
    public boolean wiD = false;
    public String wia;
    public boolean wib = false;
    public boolean wic = false;

    public final abl LN(int i) {
        this.cvp = i;
        this.whP = true;
        return this;
    }

    public final abl alD(String str) {
        this.cEV = str;
        this.whQ = true;
        return this;
    }

    public final abl alE(String str) {
        this.toUser = str;
        this.whR = true;
        return this;
    }

    public final abl alF(String str) {
        this.wiC = str;
        this.wiD = true;
        return this;
    }

    public final abl alG(String str) {
        this.whU = str;
        this.whV = true;
        return this;
    }

    public final abl ml(long j) {
        this.createTime = j;
        this.fDT = true;
        return this;
    }

    public final abl alH(String str) {
        this.cJb = str;
        this.whW = true;
        return this;
    }

    public final abl alI(String str) {
        this.cOS = str;
        this.whX = true;
        return this;
    }

    public final abl alJ(String str) {
        this.appId = str;
        this.whY = true;
        return this;
    }

    public final abl alK(String str) {
        this.link = str;
        this.whZ = true;
        return this;
    }

    public final abl alL(String str) {
        this.csl = str;
        this.wic = true;
        return this;
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51412);
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
                if (this.wiC != null) {
                    aVar.e(4, this.wiC);
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
                AppMethodBeat.o(51412);
                return 0;
            }
            bVar = new b("Not all required fields were included: sourceType");
            AppMethodBeat.o(51412);
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
            if (this.wiC != null) {
                bs += e.a.a.b.b.a.f(4, this.wiC);
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
            AppMethodBeat.o(51412);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.whP) {
                AppMethodBeat.o(51412);
                return 0;
            }
            bVar = new b("Not all required fields were included: sourceType");
            AppMethodBeat.o(51412);
            throw bVar;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            abl abl = (abl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abl.cvp = aVar3.BTU.vd();
                    abl.whP = true;
                    AppMethodBeat.o(51412);
                    return 0;
                case 2:
                    abl.cEV = aVar3.BTU.readString();
                    abl.whQ = true;
                    AppMethodBeat.o(51412);
                    return 0;
                case 3:
                    abl.toUser = aVar3.BTU.readString();
                    abl.whR = true;
                    AppMethodBeat.o(51412);
                    return 0;
                case 4:
                    abl.wiC = aVar3.BTU.readString();
                    abl.wiD = true;
                    AppMethodBeat.o(51412);
                    return 0;
                case 5:
                    abl.whU = aVar3.BTU.readString();
                    abl.whV = true;
                    AppMethodBeat.o(51412);
                    return 0;
                case 6:
                    abl.createTime = aVar3.BTU.ve();
                    abl.fDT = true;
                    AppMethodBeat.o(51412);
                    return 0;
                case 7:
                    abl.cJb = aVar3.BTU.readString();
                    abl.whW = true;
                    AppMethodBeat.o(51412);
                    return 0;
                case 8:
                    abl.cOS = aVar3.BTU.readString();
                    abl.whX = true;
                    AppMethodBeat.o(51412);
                    return 0;
                case 9:
                    abl.appId = aVar3.BTU.readString();
                    abl.whY = true;
                    AppMethodBeat.o(51412);
                    return 0;
                case 10:
                    abl.link = aVar3.BTU.readString();
                    abl.whZ = true;
                    AppMethodBeat.o(51412);
                    return 0;
                case 11:
                    abl.wia = aVar3.BTU.readString();
                    abl.wib = true;
                    AppMethodBeat.o(51412);
                    return 0;
                case 12:
                    abl.csl = aVar3.BTU.readString();
                    abl.wic = true;
                    AppMethodBeat.o(51412);
                    return 0;
                default:
                    AppMethodBeat.o(51412);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51412);
            return -1;
        }
    }
}
