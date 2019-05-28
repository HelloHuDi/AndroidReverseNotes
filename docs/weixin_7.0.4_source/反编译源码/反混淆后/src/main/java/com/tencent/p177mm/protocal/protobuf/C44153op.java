package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.op */
public class C44153op extends C1331a {
    public String kKZ;
    public String kbW;
    public String kfM;
    public String title;
    public String url;
    public String vTL;
    public String vTM;
    public long vUW;
    public String vUX;
    public String vUY;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89047);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.title != null) {
                c6093a.mo13475e(1, this.title);
            }
            if (this.kbW != null) {
                c6093a.mo13475e(2, this.kbW);
            }
            if (this.kfM != null) {
                c6093a.mo13475e(3, this.kfM);
            }
            if (this.url != null) {
                c6093a.mo13475e(4, this.url);
            }
            c6093a.mo13472ai(5, this.vUW);
            if (this.vUX != null) {
                c6093a.mo13475e(6, this.vUX);
            }
            if (this.vUY != null) {
                c6093a.mo13475e(7, this.vUY);
            }
            if (this.kKZ != null) {
                c6093a.mo13475e(8, this.kKZ);
            }
            if (this.vTL != null) {
                c6093a.mo13475e(9, this.vTL);
            }
            if (this.vTM != null) {
                c6093a.mo13475e(10, this.vTM);
            }
            AppMethodBeat.m2505o(89047);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = C6091a.m9575f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.kbW != null) {
                f += C6091a.m9575f(2, this.kbW);
            }
            if (this.kfM != null) {
                f += C6091a.m9575f(3, this.kfM);
            }
            if (this.url != null) {
                f += C6091a.m9575f(4, this.url);
            }
            f += C6091a.m9578o(5, this.vUW);
            if (this.vUX != null) {
                f += C6091a.m9575f(6, this.vUX);
            }
            if (this.vUY != null) {
                f += C6091a.m9575f(7, this.vUY);
            }
            if (this.kKZ != null) {
                f += C6091a.m9575f(8, this.kKZ);
            }
            if (this.vTL != null) {
                f += C6091a.m9575f(9, this.vTL);
            }
            if (this.vTM != null) {
                f += C6091a.m9575f(10, this.vTM);
            }
            AppMethodBeat.m2505o(89047);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89047);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44153op c44153op = (C44153op) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c44153op.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89047);
                    return 0;
                case 2:
                    c44153op.kbW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89047);
                    return 0;
                case 3:
                    c44153op.kfM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89047);
                    return 0;
                case 4:
                    c44153op.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89047);
                    return 0;
                case 5:
                    c44153op.vUW = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(89047);
                    return 0;
                case 6:
                    c44153op.vUX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89047);
                    return 0;
                case 7:
                    c44153op.vUY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89047);
                    return 0;
                case 8:
                    c44153op.kKZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89047);
                    return 0;
                case 9:
                    c44153op.vTL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89047);
                    return 0;
                case 10:
                    c44153op.vTM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89047);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89047);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89047);
            return -1;
        }
    }
}
