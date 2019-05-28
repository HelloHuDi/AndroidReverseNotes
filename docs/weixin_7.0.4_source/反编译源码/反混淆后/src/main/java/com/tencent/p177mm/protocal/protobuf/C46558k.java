package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.k */
public final class C46558k extends C1331a {
    public long cSh;
    public int state;
    public String title;
    public String vzL;
    public String vzM;
    public String vzV;
    public int vzW;
    public String vzX;
    public String vzY;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56679);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vzL != null) {
                c6093a.mo13475e(1, this.vzL);
            }
            if (this.title != null) {
                c6093a.mo13475e(2, this.title);
            }
            c6093a.mo13472ai(3, this.cSh);
            if (this.vzV != null) {
                c6093a.mo13475e(5, this.vzV);
            }
            c6093a.mo13480iz(10, this.state);
            c6093a.mo13480iz(11, this.vzW);
            if (this.vzX != null) {
                c6093a.mo13475e(12, this.vzX);
            }
            if (this.vzM != null) {
                c6093a.mo13475e(13, this.vzM);
            }
            if (this.vzY != null) {
                c6093a.mo13475e(14, this.vzY);
            }
            AppMethodBeat.m2505o(56679);
            return 0;
        } else if (i == 1) {
            if (this.vzL != null) {
                f = C6091a.m9575f(1, this.vzL) + 0;
            } else {
                f = 0;
            }
            if (this.title != null) {
                f += C6091a.m9575f(2, this.title);
            }
            f += C6091a.m9578o(3, this.cSh);
            if (this.vzV != null) {
                f += C6091a.m9575f(5, this.vzV);
            }
            f = (f + C6091a.m9572bs(10, this.state)) + C6091a.m9572bs(11, this.vzW);
            if (this.vzX != null) {
                f += C6091a.m9575f(12, this.vzX);
            }
            if (this.vzM != null) {
                f += C6091a.m9575f(13, this.vzM);
            }
            if (this.vzY != null) {
                f += C6091a.m9575f(14, this.vzY);
            }
            AppMethodBeat.m2505o(56679);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56679);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46558k c46558k = (C46558k) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c46558k.vzL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56679);
                    return 0;
                case 2:
                    c46558k.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56679);
                    return 0;
                case 3:
                    c46558k.cSh = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56679);
                    return 0;
                case 5:
                    c46558k.vzV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56679);
                    return 0;
                case 10:
                    c46558k.state = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56679);
                    return 0;
                case 11:
                    c46558k.vzW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56679);
                    return 0;
                case 12:
                    c46558k.vzX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56679);
                    return 0;
                case 13:
                    c46558k.vzM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56679);
                    return 0;
                case 14:
                    c46558k.vzY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56679);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56679);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56679);
            return -1;
        }
    }
}
