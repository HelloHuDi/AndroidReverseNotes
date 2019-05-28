package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.au */
public final class C35905au extends C1331a {
    public String IconUrl;
    public String Name;
    public int jCt;
    public String ncM;
    public String phA;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56696);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Name != null) {
                c6093a.mo13475e(1, this.Name);
            }
            if (this.phA != null) {
                c6093a.mo13475e(2, this.phA);
            }
            c6093a.mo13480iz(3, this.jCt);
            if (this.ncM != null) {
                c6093a.mo13475e(4, this.ncM);
            }
            if (this.IconUrl != null) {
                c6093a.mo13475e(5, this.IconUrl);
            }
            AppMethodBeat.m2505o(56696);
            return 0;
        } else if (i == 1) {
            if (this.Name != null) {
                f = C6091a.m9575f(1, this.Name) + 0;
            } else {
                f = 0;
            }
            if (this.phA != null) {
                f += C6091a.m9575f(2, this.phA);
            }
            f += C6091a.m9572bs(3, this.jCt);
            if (this.ncM != null) {
                f += C6091a.m9575f(4, this.ncM);
            }
            if (this.IconUrl != null) {
                f += C6091a.m9575f(5, this.IconUrl);
            }
            AppMethodBeat.m2505o(56696);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56696);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35905au c35905au = (C35905au) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c35905au.Name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56696);
                    return 0;
                case 2:
                    c35905au.phA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56696);
                    return 0;
                case 3:
                    c35905au.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56696);
                    return 0;
                case 4:
                    c35905au.ncM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56696);
                    return 0;
                case 5:
                    c35905au.IconUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56696);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56696);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56696);
            return -1;
        }
    }
}
