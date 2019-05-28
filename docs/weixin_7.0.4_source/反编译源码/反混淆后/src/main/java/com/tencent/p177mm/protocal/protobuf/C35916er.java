package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.er */
public final class C35916er extends C1331a {
    public int Scene;
    public String Url;
    public String vGA;
    public int vGB;
    public long vGy;
    public int vGz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(14702);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Url != null) {
                c6093a.mo13475e(1, this.Url);
            }
            c6093a.mo13472ai(2, this.vGy);
            c6093a.mo13480iz(3, this.vGz);
            if (this.vGA != null) {
                c6093a.mo13475e(4, this.vGA);
            }
            c6093a.mo13480iz(5, this.Scene);
            c6093a.mo13480iz(6, this.vGB);
            AppMethodBeat.m2505o(14702);
            return 0;
        } else if (i == 1) {
            if (this.Url != null) {
                f = C6091a.m9575f(1, this.Url) + 0;
            } else {
                f = 0;
            }
            f = (f + C6091a.m9578o(2, this.vGy)) + C6091a.m9572bs(3, this.vGz);
            if (this.vGA != null) {
                f += C6091a.m9575f(4, this.vGA);
            }
            int bs = (f + C6091a.m9572bs(5, this.Scene)) + C6091a.m9572bs(6, this.vGB);
            AppMethodBeat.m2505o(14702);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(14702);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35916er c35916er = (C35916er) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c35916er.Url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14702);
                    return 0;
                case 2:
                    c35916er.vGy = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(14702);
                    return 0;
                case 3:
                    c35916er.vGz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14702);
                    return 0;
                case 4:
                    c35916er.vGA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14702);
                    return 0;
                case 5:
                    c35916er.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14702);
                    return 0;
                case 6:
                    c35916er.vGB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14702);
                    return 0;
                default:
                    AppMethodBeat.m2505o(14702);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(14702);
            return -1;
        }
    }
}
