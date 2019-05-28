package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bzz */
public final class bzz extends C1331a {
    public int Scene;
    public String Title;
    public String Url;
    public String wYV;
    public String wYW;
    public String wYX;
    public int wYY;
    public String wYZ;
    public String wZa;
    public String wZb;
    public int wZc;
    public int wZd;
    public int wZe;
    public int wZf;
    public int wZg;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(124363);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wYV == null) {
                c6092b = new C6092b("Not all required fields were included: PickedWord");
                AppMethodBeat.m2505o(124363);
                throw c6092b;
            }
            if (this.wYV != null) {
                c6093a.mo13475e(1, this.wYV);
            }
            if (this.wYW != null) {
                c6093a.mo13475e(2, this.wYW);
            }
            if (this.wYX != null) {
                c6093a.mo13475e(3, this.wYX);
            }
            c6093a.mo13480iz(4, this.Scene);
            c6093a.mo13480iz(5, this.wYY);
            if (this.Url != null) {
                c6093a.mo13475e(6, this.Url);
            }
            if (this.Title != null) {
                c6093a.mo13475e(7, this.Title);
            }
            if (this.wYZ != null) {
                c6093a.mo13475e(8, this.wYZ);
            }
            if (this.wZa != null) {
                c6093a.mo13475e(9, this.wZa);
            }
            if (this.wZb != null) {
                c6093a.mo13475e(10, this.wZb);
            }
            c6093a.mo13480iz(11, this.wZc);
            c6093a.mo13480iz(12, this.wZd);
            c6093a.mo13480iz(13, this.wZe);
            c6093a.mo13480iz(14, this.wZf);
            c6093a.mo13480iz(15, this.wZg);
            AppMethodBeat.m2505o(124363);
            return 0;
        } else if (i == 1) {
            if (this.wYV != null) {
                f = C6091a.m9575f(1, this.wYV) + 0;
            } else {
                f = 0;
            }
            if (this.wYW != null) {
                f += C6091a.m9575f(2, this.wYW);
            }
            if (this.wYX != null) {
                f += C6091a.m9575f(3, this.wYX);
            }
            f = (f + C6091a.m9572bs(4, this.Scene)) + C6091a.m9572bs(5, this.wYY);
            if (this.Url != null) {
                f += C6091a.m9575f(6, this.Url);
            }
            if (this.Title != null) {
                f += C6091a.m9575f(7, this.Title);
            }
            if (this.wYZ != null) {
                f += C6091a.m9575f(8, this.wYZ);
            }
            if (this.wZa != null) {
                f += C6091a.m9575f(9, this.wZa);
            }
            if (this.wZb != null) {
                f += C6091a.m9575f(10, this.wZb);
            }
            int bs = ((((f + C6091a.m9572bs(11, this.wZc)) + C6091a.m9572bs(12, this.wZd)) + C6091a.m9572bs(13, this.wZe)) + C6091a.m9572bs(14, this.wZf)) + C6091a.m9572bs(15, this.wZg);
            AppMethodBeat.m2505o(124363);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.wYV == null) {
                c6092b = new C6092b("Not all required fields were included: PickedWord");
                AppMethodBeat.m2505o(124363);
                throw c6092b;
            }
            AppMethodBeat.m2505o(124363);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bzz bzz = (bzz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bzz.wYV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124363);
                    return 0;
                case 2:
                    bzz.wYW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124363);
                    return 0;
                case 3:
                    bzz.wYX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124363);
                    return 0;
                case 4:
                    bzz.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124363);
                    return 0;
                case 5:
                    bzz.wYY = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124363);
                    return 0;
                case 6:
                    bzz.Url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124363);
                    return 0;
                case 7:
                    bzz.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124363);
                    return 0;
                case 8:
                    bzz.wYZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124363);
                    return 0;
                case 9:
                    bzz.wZa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124363);
                    return 0;
                case 10:
                    bzz.wZb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124363);
                    return 0;
                case 11:
                    bzz.wZc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124363);
                    return 0;
                case 12:
                    bzz.wZd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124363);
                    return 0;
                case 13:
                    bzz.wZe = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124363);
                    return 0;
                case 14:
                    bzz.wZf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124363);
                    return 0;
                case 15:
                    bzz.wZg = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124363);
                    return 0;
                default:
                    AppMethodBeat.m2505o(124363);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(124363);
            return -1;
        }
    }
}
