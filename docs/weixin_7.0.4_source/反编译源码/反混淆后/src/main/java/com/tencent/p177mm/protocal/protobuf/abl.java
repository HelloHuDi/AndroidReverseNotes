package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.abl */
public final class abl extends C1331a {
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

    /* renamed from: LN */
    public final abl mo39126LN(int i) {
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

    /* renamed from: ml */
    public final abl mo39136ml(long j) {
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

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(51412);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.whP) {
                if (this.whP) {
                    c6093a.mo13480iz(1, this.cvp);
                }
                if (this.cEV != null) {
                    c6093a.mo13475e(2, this.cEV);
                }
                if (this.toUser != null) {
                    c6093a.mo13475e(3, this.toUser);
                }
                if (this.wiC != null) {
                    c6093a.mo13475e(4, this.wiC);
                }
                if (this.whU != null) {
                    c6093a.mo13475e(5, this.whU);
                }
                if (this.fDT) {
                    c6093a.mo13472ai(6, this.createTime);
                }
                if (this.cJb != null) {
                    c6093a.mo13475e(7, this.cJb);
                }
                if (this.cOS != null) {
                    c6093a.mo13475e(8, this.cOS);
                }
                if (this.appId != null) {
                    c6093a.mo13475e(9, this.appId);
                }
                if (this.link != null) {
                    c6093a.mo13475e(10, this.link);
                }
                if (this.wia != null) {
                    c6093a.mo13475e(11, this.wia);
                }
                if (this.csl != null) {
                    c6093a.mo13475e(12, this.csl);
                }
                AppMethodBeat.m2505o(51412);
                return 0;
            }
            c6092b = new C6092b("Not all required fields were included: sourceType");
            AppMethodBeat.m2505o(51412);
            throw c6092b;
        } else if (i == 1) {
            if (this.whP) {
                bs = C6091a.m9572bs(1, this.cvp) + 0;
            } else {
                bs = 0;
            }
            if (this.cEV != null) {
                bs += C6091a.m9575f(2, this.cEV);
            }
            if (this.toUser != null) {
                bs += C6091a.m9575f(3, this.toUser);
            }
            if (this.wiC != null) {
                bs += C6091a.m9575f(4, this.wiC);
            }
            if (this.whU != null) {
                bs += C6091a.m9575f(5, this.whU);
            }
            if (this.fDT) {
                bs += C6091a.m9578o(6, this.createTime);
            }
            if (this.cJb != null) {
                bs += C6091a.m9575f(7, this.cJb);
            }
            if (this.cOS != null) {
                bs += C6091a.m9575f(8, this.cOS);
            }
            if (this.appId != null) {
                bs += C6091a.m9575f(9, this.appId);
            }
            if (this.link != null) {
                bs += C6091a.m9575f(10, this.link);
            }
            if (this.wia != null) {
                bs += C6091a.m9575f(11, this.wia);
            }
            if (this.csl != null) {
                bs += C6091a.m9575f(12, this.csl);
            }
            AppMethodBeat.m2505o(51412);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.whP) {
                AppMethodBeat.m2505o(51412);
                return 0;
            }
            c6092b = new C6092b("Not all required fields were included: sourceType");
            AppMethodBeat.m2505o(51412);
            throw c6092b;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            abl abl = (abl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abl.cvp = c6086a2.BTU.mo13458vd();
                    abl.whP = true;
                    AppMethodBeat.m2505o(51412);
                    return 0;
                case 2:
                    abl.cEV = c6086a2.BTU.readString();
                    abl.whQ = true;
                    AppMethodBeat.m2505o(51412);
                    return 0;
                case 3:
                    abl.toUser = c6086a2.BTU.readString();
                    abl.whR = true;
                    AppMethodBeat.m2505o(51412);
                    return 0;
                case 4:
                    abl.wiC = c6086a2.BTU.readString();
                    abl.wiD = true;
                    AppMethodBeat.m2505o(51412);
                    return 0;
                case 5:
                    abl.whU = c6086a2.BTU.readString();
                    abl.whV = true;
                    AppMethodBeat.m2505o(51412);
                    return 0;
                case 6:
                    abl.createTime = c6086a2.BTU.mo13459ve();
                    abl.fDT = true;
                    AppMethodBeat.m2505o(51412);
                    return 0;
                case 7:
                    abl.cJb = c6086a2.BTU.readString();
                    abl.whW = true;
                    AppMethodBeat.m2505o(51412);
                    return 0;
                case 8:
                    abl.cOS = c6086a2.BTU.readString();
                    abl.whX = true;
                    AppMethodBeat.m2505o(51412);
                    return 0;
                case 9:
                    abl.appId = c6086a2.BTU.readString();
                    abl.whY = true;
                    AppMethodBeat.m2505o(51412);
                    return 0;
                case 10:
                    abl.link = c6086a2.BTU.readString();
                    abl.whZ = true;
                    AppMethodBeat.m2505o(51412);
                    return 0;
                case 11:
                    abl.wia = c6086a2.BTU.readString();
                    abl.wib = true;
                    AppMethodBeat.m2505o(51412);
                    return 0;
                case 12:
                    abl.csl = c6086a2.BTU.readString();
                    abl.wic = true;
                    AppMethodBeat.m2505o(51412);
                    return 0;
                default:
                    AppMethodBeat.m2505o(51412);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(51412);
            return -1;
        }
    }
}
