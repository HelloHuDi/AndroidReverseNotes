package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.mr */
public final class C40546mr extends C1331a {
    public String cIY;
    public String tID;
    public String title;
    public int type;
    public String tzT;
    public String url;
    public String vQG;
    public String vQH;
    public int vQI;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56733);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.type);
            if (this.tID != null) {
                c6093a.mo13475e(2, this.tID);
            }
            if (this.cIY != null) {
                c6093a.mo13475e(3, this.cIY);
            }
            if (this.title != null) {
                c6093a.mo13475e(4, this.title);
            }
            if (this.tzT != null) {
                c6093a.mo13475e(5, this.tzT);
            }
            if (this.url != null) {
                c6093a.mo13475e(6, this.url);
            }
            if (this.vQG != null) {
                c6093a.mo13475e(7, this.vQG);
            }
            if (this.vQH != null) {
                c6093a.mo13475e(8, this.vQH);
            }
            c6093a.mo13480iz(9, this.vQI);
            AppMethodBeat.m2505o(56733);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.type) + 0;
            if (this.tID != null) {
                bs += C6091a.m9575f(2, this.tID);
            }
            if (this.cIY != null) {
                bs += C6091a.m9575f(3, this.cIY);
            }
            if (this.title != null) {
                bs += C6091a.m9575f(4, this.title);
            }
            if (this.tzT != null) {
                bs += C6091a.m9575f(5, this.tzT);
            }
            if (this.url != null) {
                bs += C6091a.m9575f(6, this.url);
            }
            if (this.vQG != null) {
                bs += C6091a.m9575f(7, this.vQG);
            }
            if (this.vQH != null) {
                bs += C6091a.m9575f(8, this.vQH);
            }
            bs += C6091a.m9572bs(9, this.vQI);
            AppMethodBeat.m2505o(56733);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56733);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40546mr c40546mr = (C40546mr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c40546mr.type = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56733);
                    return 0;
                case 2:
                    c40546mr.tID = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56733);
                    return 0;
                case 3:
                    c40546mr.cIY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56733);
                    return 0;
                case 4:
                    c40546mr.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56733);
                    return 0;
                case 5:
                    c40546mr.tzT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56733);
                    return 0;
                case 6:
                    c40546mr.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56733);
                    return 0;
                case 7:
                    c40546mr.vQG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56733);
                    return 0;
                case 8:
                    c40546mr.vQH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56733);
                    return 0;
                case 9:
                    c40546mr.vQI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56733);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56733);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56733);
            return -1;
        }
    }
}
