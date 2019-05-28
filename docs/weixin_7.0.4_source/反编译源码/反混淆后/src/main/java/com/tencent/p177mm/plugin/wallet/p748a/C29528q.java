package com.tencent.p177mm.plugin.wallet.p748a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.wallet.a.q */
public final class C29528q extends C1331a {
    public String desc;
    public String fjD;
    /* renamed from: id */
    public String f13716id;
    public String name;
    public int status;
    public String tmN;
    public String tnt;
    public String tnu;
    public String tnv = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    public String tnw = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    public int tnx = 0;
    public int tny;
    public String tnz;
    public int type;
    public String url;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56660);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.f13716id != null) {
                c6093a.mo13475e(1, this.f13716id);
            }
            if (this.name != null) {
                c6093a.mo13475e(2, this.name);
            }
            if (this.desc != null) {
                c6093a.mo13475e(3, this.desc);
            }
            c6093a.mo13480iz(4, this.status);
            if (this.url != null) {
                c6093a.mo13475e(5, this.url);
            }
            c6093a.mo13480iz(6, this.type);
            if (this.tnt != null) {
                c6093a.mo13475e(7, this.tnt);
            }
            if (this.tnu != null) {
                c6093a.mo13475e(8, this.tnu);
            }
            if (this.tnv != null) {
                c6093a.mo13475e(9, this.tnv);
            }
            if (this.tnw != null) {
                c6093a.mo13475e(10, this.tnw);
            }
            c6093a.mo13480iz(11, this.tnx);
            if (this.tmN != null) {
                c6093a.mo13475e(12, this.tmN);
            }
            if (this.fjD != null) {
                c6093a.mo13475e(13, this.fjD);
            }
            c6093a.mo13480iz(14, this.tny);
            if (this.tnz != null) {
                c6093a.mo13475e(15, this.tnz);
            }
            AppMethodBeat.m2505o(56660);
            return 0;
        } else if (i == 1) {
            if (this.f13716id != null) {
                f = C6091a.m9575f(1, this.f13716id) + 0;
            } else {
                f = 0;
            }
            if (this.name != null) {
                f += C6091a.m9575f(2, this.name);
            }
            if (this.desc != null) {
                f += C6091a.m9575f(3, this.desc);
            }
            f += C6091a.m9572bs(4, this.status);
            if (this.url != null) {
                f += C6091a.m9575f(5, this.url);
            }
            f += C6091a.m9572bs(6, this.type);
            if (this.tnt != null) {
                f += C6091a.m9575f(7, this.tnt);
            }
            if (this.tnu != null) {
                f += C6091a.m9575f(8, this.tnu);
            }
            if (this.tnv != null) {
                f += C6091a.m9575f(9, this.tnv);
            }
            if (this.tnw != null) {
                f += C6091a.m9575f(10, this.tnw);
            }
            f += C6091a.m9572bs(11, this.tnx);
            if (this.tmN != null) {
                f += C6091a.m9575f(12, this.tmN);
            }
            if (this.fjD != null) {
                f += C6091a.m9575f(13, this.fjD);
            }
            f += C6091a.m9572bs(14, this.tny);
            if (this.tnz != null) {
                f += C6091a.m9575f(15, this.tnz);
            }
            AppMethodBeat.m2505o(56660);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56660);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C29528q c29528q = (C29528q) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c29528q.f13716id = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56660);
                    return 0;
                case 2:
                    c29528q.name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56660);
                    return 0;
                case 3:
                    c29528q.desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56660);
                    return 0;
                case 4:
                    c29528q.status = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56660);
                    return 0;
                case 5:
                    c29528q.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56660);
                    return 0;
                case 6:
                    c29528q.type = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56660);
                    return 0;
                case 7:
                    c29528q.tnt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56660);
                    return 0;
                case 8:
                    c29528q.tnu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56660);
                    return 0;
                case 9:
                    c29528q.tnv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56660);
                    return 0;
                case 10:
                    c29528q.tnw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56660);
                    return 0;
                case 11:
                    c29528q.tnx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56660);
                    return 0;
                case 12:
                    c29528q.tmN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56660);
                    return 0;
                case 13:
                    c29528q.fjD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56660);
                    return 0;
                case 14:
                    c29528q.tny = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56660);
                    return 0;
                case 15:
                    c29528q.tnz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56660);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56660);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56660);
            return -1;
        }
    }
}
