package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aat */
public final class aat extends C1331a {
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

    /* renamed from: LI */
    public final aat mo64043LI(int i) {
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

    /* renamed from: mi */
    public final aat mo64052mi(long j) {
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

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(51392);
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
                if (this.whS != null) {
                    c6093a.mo13475e(4, this.whS);
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
                AppMethodBeat.m2505o(51392);
                return 0;
            }
            c6092b = new C6092b("Not all required fields were included: sourceType");
            AppMethodBeat.m2505o(51392);
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
            if (this.whS != null) {
                bs += C6091a.m9575f(4, this.whS);
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
            AppMethodBeat.m2505o(51392);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.whP) {
                AppMethodBeat.m2505o(51392);
                return 0;
            }
            c6092b = new C6092b("Not all required fields were included: sourceType");
            AppMethodBeat.m2505o(51392);
            throw c6092b;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aat aat = (aat) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aat.cvp = c6086a2.BTU.mo13458vd();
                    aat.whP = true;
                    AppMethodBeat.m2505o(51392);
                    return 0;
                case 2:
                    aat.cEV = c6086a2.BTU.readString();
                    aat.whQ = true;
                    AppMethodBeat.m2505o(51392);
                    return 0;
                case 3:
                    aat.toUser = c6086a2.BTU.readString();
                    aat.whR = true;
                    AppMethodBeat.m2505o(51392);
                    return 0;
                case 4:
                    aat.whS = c6086a2.BTU.readString();
                    aat.whT = true;
                    AppMethodBeat.m2505o(51392);
                    return 0;
                case 5:
                    aat.whU = c6086a2.BTU.readString();
                    aat.whV = true;
                    AppMethodBeat.m2505o(51392);
                    return 0;
                case 6:
                    aat.createTime = c6086a2.BTU.mo13459ve();
                    aat.fDT = true;
                    AppMethodBeat.m2505o(51392);
                    return 0;
                case 7:
                    aat.cJb = c6086a2.BTU.readString();
                    aat.whW = true;
                    AppMethodBeat.m2505o(51392);
                    return 0;
                case 8:
                    aat.cOS = c6086a2.BTU.readString();
                    aat.whX = true;
                    AppMethodBeat.m2505o(51392);
                    return 0;
                case 9:
                    aat.appId = c6086a2.BTU.readString();
                    aat.whY = true;
                    AppMethodBeat.m2505o(51392);
                    return 0;
                case 10:
                    aat.link = c6086a2.BTU.readString();
                    aat.whZ = true;
                    AppMethodBeat.m2505o(51392);
                    return 0;
                case 11:
                    aat.wia = c6086a2.BTU.readString();
                    aat.wib = true;
                    AppMethodBeat.m2505o(51392);
                    return 0;
                case 12:
                    aat.csl = c6086a2.BTU.readString();
                    aat.wic = true;
                    AppMethodBeat.m2505o(51392);
                    return 0;
                default:
                    AppMethodBeat.m2505o(51392);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(51392);
            return -1;
        }
    }
}
