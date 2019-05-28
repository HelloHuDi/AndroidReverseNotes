package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bc */
public final class C23372bc extends C1331a {
    public String cEh;
    public String cIY;
    public String tID;
    public int tIE;
    public String title;
    public String ttg;
    public String tzW;
    public String url;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56698);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.url != null) {
                c6093a.mo13475e(1, this.url);
            }
            if (this.cEh != null) {
                c6093a.mo13475e(2, this.cEh);
            }
            if (this.cIY != null) {
                c6093a.mo13475e(3, this.cIY);
            }
            if (this.tID != null) {
                c6093a.mo13475e(4, this.tID);
            }
            if (this.title != null) {
                c6093a.mo13475e(5, this.title);
            }
            if (this.tzW != null) {
                c6093a.mo13475e(6, this.tzW);
            }
            if (this.ttg != null) {
                c6093a.mo13475e(7, this.ttg);
            }
            c6093a.mo13480iz(8, this.tIE);
            AppMethodBeat.m2505o(56698);
            return 0;
        } else if (i == 1) {
            if (this.url != null) {
                f = C6091a.m9575f(1, this.url) + 0;
            } else {
                f = 0;
            }
            if (this.cEh != null) {
                f += C6091a.m9575f(2, this.cEh);
            }
            if (this.cIY != null) {
                f += C6091a.m9575f(3, this.cIY);
            }
            if (this.tID != null) {
                f += C6091a.m9575f(4, this.tID);
            }
            if (this.title != null) {
                f += C6091a.m9575f(5, this.title);
            }
            if (this.tzW != null) {
                f += C6091a.m9575f(6, this.tzW);
            }
            if (this.ttg != null) {
                f += C6091a.m9575f(7, this.ttg);
            }
            int bs = f + C6091a.m9572bs(8, this.tIE);
            AppMethodBeat.m2505o(56698);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56698);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23372bc c23372bc = (C23372bc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c23372bc.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56698);
                    return 0;
                case 2:
                    c23372bc.cEh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56698);
                    return 0;
                case 3:
                    c23372bc.cIY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56698);
                    return 0;
                case 4:
                    c23372bc.tID = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56698);
                    return 0;
                case 5:
                    c23372bc.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56698);
                    return 0;
                case 6:
                    c23372bc.tzW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56698);
                    return 0;
                case 7:
                    c23372bc.ttg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56698);
                    return 0;
                case 8:
                    c23372bc.tIE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56698);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56698);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56698);
            return -1;
        }
    }
}
