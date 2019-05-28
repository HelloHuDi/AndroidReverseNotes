package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.azu */
public final class azu extends C1331a {
    public String desc;
    public int duration;
    public int fga;
    public int fgb = 0;
    public int fgc;
    public String fgd;
    public String lvx;
    public int vGc = -1;
    public int videoHeight;
    public int videoWidth;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94536);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.vGc);
            c6093a.mo13480iz(2, this.fgb);
            if (this.desc != null) {
                c6093a.mo13475e(3, this.desc);
            }
            c6093a.mo13480iz(4, this.videoWidth);
            c6093a.mo13480iz(5, this.videoHeight);
            c6093a.mo13480iz(6, this.fga);
            c6093a.mo13480iz(7, this.duration);
            if (this.fgd != null) {
                c6093a.mo13475e(8, this.fgd);
            }
            c6093a.mo13480iz(9, this.fgc);
            if (this.lvx != null) {
                c6093a.mo13475e(10, this.lvx);
            }
            AppMethodBeat.m2505o(94536);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.vGc) + 0) + C6091a.m9572bs(2, this.fgb);
            if (this.desc != null) {
                bs += C6091a.m9575f(3, this.desc);
            }
            bs = (((bs + C6091a.m9572bs(4, this.videoWidth)) + C6091a.m9572bs(5, this.videoHeight)) + C6091a.m9572bs(6, this.fga)) + C6091a.m9572bs(7, this.duration);
            if (this.fgd != null) {
                bs += C6091a.m9575f(8, this.fgd);
            }
            bs += C6091a.m9572bs(9, this.fgc);
            if (this.lvx != null) {
                bs += C6091a.m9575f(10, this.lvx);
            }
            AppMethodBeat.m2505o(94536);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(94536);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            azu azu = (azu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    azu.vGc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94536);
                    return 0;
                case 2:
                    azu.fgb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94536);
                    return 0;
                case 3:
                    azu.desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94536);
                    return 0;
                case 4:
                    azu.videoWidth = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94536);
                    return 0;
                case 5:
                    azu.videoHeight = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94536);
                    return 0;
                case 6:
                    azu.fga = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94536);
                    return 0;
                case 7:
                    azu.duration = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94536);
                    return 0;
                case 8:
                    azu.fgd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94536);
                    return 0;
                case 9:
                    azu.fgc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94536);
                    return 0;
                case 10:
                    azu.lvx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94536);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94536);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94536);
            return -1;
        }
    }
}
