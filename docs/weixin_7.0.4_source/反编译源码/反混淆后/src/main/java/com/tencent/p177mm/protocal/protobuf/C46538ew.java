package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ew */
public final class C46538ew extends C1331a {
    public int height;
    public String url;
    public int vGK;
    public int vGL;
    public long vGM;
    public int vGN;
    public int width;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(14706);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.url != null) {
                c6093a.mo13475e(1, this.url);
            }
            c6093a.mo13480iz(2, this.vGK);
            c6093a.mo13480iz(3, this.vGL);
            c6093a.mo13472ai(4, this.vGM);
            c6093a.mo13480iz(5, this.width);
            c6093a.mo13480iz(6, this.height);
            c6093a.mo13480iz(10, this.vGN);
            AppMethodBeat.m2505o(14706);
            return 0;
        } else if (i == 1) {
            if (this.url != null) {
                f = C6091a.m9575f(1, this.url) + 0;
            } else {
                f = 0;
            }
            int bs = (((((f + C6091a.m9572bs(2, this.vGK)) + C6091a.m9572bs(3, this.vGL)) + C6091a.m9578o(4, this.vGM)) + C6091a.m9572bs(5, this.width)) + C6091a.m9572bs(6, this.height)) + C6091a.m9572bs(10, this.vGN);
            AppMethodBeat.m2505o(14706);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(14706);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46538ew c46538ew = (C46538ew) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c46538ew.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14706);
                    return 0;
                case 2:
                    c46538ew.vGK = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14706);
                    return 0;
                case 3:
                    c46538ew.vGL = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14706);
                    return 0;
                case 4:
                    c46538ew.vGM = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(14706);
                    return 0;
                case 5:
                    c46538ew.width = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14706);
                    return 0;
                case 6:
                    c46538ew.height = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14706);
                    return 0;
                case 10:
                    c46538ew.vGN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14706);
                    return 0;
                default:
                    AppMethodBeat.m2505o(14706);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(14706);
            return -1;
        }
    }
}
