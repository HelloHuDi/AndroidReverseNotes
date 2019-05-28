package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.n */
public final class C43171n extends C1331a {
    public String Desc;
    public String Name;
    public String mZW;
    public int mZX;
    public String mZj;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111553);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.mZW != null) {
                c6093a.mo13475e(1, this.mZW);
            }
            if (this.Name != null) {
                c6093a.mo13475e(2, this.Name);
            }
            if (this.Desc != null) {
                c6093a.mo13475e(3, this.Desc);
            }
            if (this.mZj != null) {
                c6093a.mo13475e(4, this.mZj);
            }
            c6093a.mo13480iz(5, this.mZX);
            AppMethodBeat.m2505o(111553);
            return 0;
        } else if (i == 1) {
            if (this.mZW != null) {
                f = C6091a.m9575f(1, this.mZW) + 0;
            } else {
                f = 0;
            }
            if (this.Name != null) {
                f += C6091a.m9575f(2, this.Name);
            }
            if (this.Desc != null) {
                f += C6091a.m9575f(3, this.Desc);
            }
            if (this.mZj != null) {
                f += C6091a.m9575f(4, this.mZj);
            }
            int bs = f + C6091a.m9572bs(5, this.mZX);
            AppMethodBeat.m2505o(111553);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(111553);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C43171n c43171n = (C43171n) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c43171n.mZW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111553);
                    return 0;
                case 2:
                    c43171n.Name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111553);
                    return 0;
                case 3:
                    c43171n.Desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111553);
                    return 0;
                case 4:
                    c43171n.mZj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111553);
                    return 0;
                case 5:
                    c43171n.mZX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111553);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111553);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111553);
            return -1;
        }
    }
}
