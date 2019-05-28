package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.auj */
public final class auj extends C1331a {
    public float height;
    public String url;
    public String vJS;
    public float width;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48875);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.url != null) {
                c6093a.mo13475e(1, this.url);
            }
            if (this.vJS != null) {
                c6093a.mo13475e(2, this.vJS);
            }
            c6093a.mo13481r(3, this.width);
            c6093a.mo13481r(4, this.height);
            AppMethodBeat.m2505o(48875);
            return 0;
        } else if (i == 1) {
            if (this.url != null) {
                f = C6091a.m9575f(1, this.url) + 0;
            } else {
                f = 0;
            }
            if (this.vJS != null) {
                f += C6091a.m9575f(2, this.vJS);
            }
            int fv = (f + (C6091a.m9576fv(3) + 4)) + (C6091a.m9576fv(4) + 4);
            AppMethodBeat.m2505o(48875);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48875);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            auj auj = (auj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    auj.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48875);
                    return 0;
                case 2:
                    auj.vJS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48875);
                    return 0;
                case 3:
                    auj.width = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(48875);
                    return 0;
                case 4:
                    auj.height = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(48875);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48875);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48875);
            return -1;
        }
    }
}
