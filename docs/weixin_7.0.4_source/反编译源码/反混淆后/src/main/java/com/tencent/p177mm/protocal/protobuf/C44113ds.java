package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ds */
public final class C44113ds extends C1331a {
    /* renamed from: Id */
    public String f17242Id;
    public String jCh;
    public String ncH;
    public String vFw;
    public String vFx;
    public int vFy;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94507);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.f17242Id != null) {
                c6093a.mo13475e(1, this.f17242Id);
            }
            if (this.jCh != null) {
                c6093a.mo13475e(2, this.jCh);
            }
            if (this.ncH != null) {
                c6093a.mo13475e(3, this.ncH);
            }
            if (this.vFw != null) {
                c6093a.mo13475e(4, this.vFw);
            }
            if (this.vFx != null) {
                c6093a.mo13475e(5, this.vFx);
            }
            c6093a.mo13480iz(6, this.vFy);
            AppMethodBeat.m2505o(94507);
            return 0;
        } else if (i == 1) {
            if (this.f17242Id != null) {
                f = C6091a.m9575f(1, this.f17242Id) + 0;
            } else {
                f = 0;
            }
            if (this.jCh != null) {
                f += C6091a.m9575f(2, this.jCh);
            }
            if (this.ncH != null) {
                f += C6091a.m9575f(3, this.ncH);
            }
            if (this.vFw != null) {
                f += C6091a.m9575f(4, this.vFw);
            }
            if (this.vFx != null) {
                f += C6091a.m9575f(5, this.vFx);
            }
            int bs = f + C6091a.m9572bs(6, this.vFy);
            AppMethodBeat.m2505o(94507);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(94507);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44113ds c44113ds = (C44113ds) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c44113ds.f17242Id = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94507);
                    return 0;
                case 2:
                    c44113ds.jCh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94507);
                    return 0;
                case 3:
                    c44113ds.ncH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94507);
                    return 0;
                case 4:
                    c44113ds.vFw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94507);
                    return 0;
                case 5:
                    c44113ds.vFx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94507);
                    return 0;
                case 6:
                    c44113ds.vFy = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94507);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94507);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94507);
            return -1;
        }
    }
}
