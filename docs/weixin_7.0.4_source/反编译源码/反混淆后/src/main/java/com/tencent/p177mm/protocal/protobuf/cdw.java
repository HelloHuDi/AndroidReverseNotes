package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cdw */
public final class cdw extends C1331a {
    public String cEV;
    public String clientId;
    public String content;
    public String cvF;
    public int fDG;
    public long rUJ;
    public int rVd;
    public String rVl;
    public int rVm;
    public int retryCount;
    public int state;
    public String toUser;
    public int xdD;
    public int xdE;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(108907);
        C6092b c6092b;
        int o;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.cEV == null) {
                c6092b = new C6092b("Not all required fields were included: fromUser");
                AppMethodBeat.m2505o(108907);
                throw c6092b;
            } else if (this.toUser == null) {
                c6092b = new C6092b("Not all required fields were included: toUser");
                AppMethodBeat.m2505o(108907);
                throw c6092b;
            } else {
                c6093a.mo13472ai(1, this.rUJ);
                c6093a.mo13480iz(2, this.fDG);
                if (this.cEV != null) {
                    c6093a.mo13475e(3, this.cEV);
                }
                if (this.toUser != null) {
                    c6093a.mo13475e(4, this.toUser);
                }
                if (this.content != null) {
                    c6093a.mo13475e(5, this.content);
                }
                c6093a.mo13480iz(6, this.state);
                if (this.clientId != null) {
                    c6093a.mo13475e(7, this.clientId);
                }
                c6093a.mo13480iz(8, this.rVd);
                c6093a.mo13480iz(9, this.xdD);
                c6093a.mo13480iz(10, this.retryCount);
                c6093a.mo13480iz(11, this.xdE);
                if (this.cvF != null) {
                    c6093a.mo13475e(12, this.cvF);
                }
                if (this.rVl != null) {
                    c6093a.mo13475e(13, this.rVl);
                }
                c6093a.mo13480iz(14, this.rVm);
                AppMethodBeat.m2505o(108907);
                return 0;
            }
        } else if (i == 1) {
            o = (C6091a.m9578o(1, this.rUJ) + 0) + C6091a.m9572bs(2, this.fDG);
            if (this.cEV != null) {
                o += C6091a.m9575f(3, this.cEV);
            }
            if (this.toUser != null) {
                o += C6091a.m9575f(4, this.toUser);
            }
            if (this.content != null) {
                o += C6091a.m9575f(5, this.content);
            }
            o += C6091a.m9572bs(6, this.state);
            if (this.clientId != null) {
                o += C6091a.m9575f(7, this.clientId);
            }
            o = (((o + C6091a.m9572bs(8, this.rVd)) + C6091a.m9572bs(9, this.xdD)) + C6091a.m9572bs(10, this.retryCount)) + C6091a.m9572bs(11, this.xdE);
            if (this.cvF != null) {
                o += C6091a.m9575f(12, this.cvF);
            }
            if (this.rVl != null) {
                o += C6091a.m9575f(13, this.rVl);
            }
            o += C6091a.m9572bs(14, this.rVm);
            AppMethodBeat.m2505o(108907);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            if (this.cEV == null) {
                c6092b = new C6092b("Not all required fields were included: fromUser");
                AppMethodBeat.m2505o(108907);
                throw c6092b;
            } else if (this.toUser == null) {
                c6092b = new C6092b("Not all required fields were included: toUser");
                AppMethodBeat.m2505o(108907);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(108907);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cdw cdw = (cdw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cdw.rUJ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(108907);
                    return 0;
                case 2:
                    cdw.fDG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(108907);
                    return 0;
                case 3:
                    cdw.cEV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(108907);
                    return 0;
                case 4:
                    cdw.toUser = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(108907);
                    return 0;
                case 5:
                    cdw.content = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(108907);
                    return 0;
                case 6:
                    cdw.state = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(108907);
                    return 0;
                case 7:
                    cdw.clientId = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(108907);
                    return 0;
                case 8:
                    cdw.rVd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(108907);
                    return 0;
                case 9:
                    cdw.xdD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(108907);
                    return 0;
                case 10:
                    cdw.retryCount = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(108907);
                    return 0;
                case 11:
                    cdw.xdE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(108907);
                    return 0;
                case 12:
                    cdw.cvF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(108907);
                    return 0;
                case 13:
                    cdw.rVl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(108907);
                    return 0;
                case 14:
                    cdw.rVm = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(108907);
                    return 0;
                default:
                    AppMethodBeat.m2505o(108907);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(108907);
            return -1;
        }
    }
}
