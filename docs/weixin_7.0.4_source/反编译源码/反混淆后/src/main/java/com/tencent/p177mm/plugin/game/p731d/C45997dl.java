package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.dl */
public final class C45997dl extends C1331a {
    public String ndG;
    public String ndH;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111679);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.ndG == null) {
                c6092b = new C6092b("Not all required fields were included: FromUserName");
                AppMethodBeat.m2505o(111679);
                throw c6092b;
            } else if (this.ndH == null) {
                c6092b = new C6092b("Not all required fields were included: TimeDesc");
                AppMethodBeat.m2505o(111679);
                throw c6092b;
            } else {
                if (this.ndG != null) {
                    c6093a.mo13475e(1, this.ndG);
                }
                if (this.ndH != null) {
                    c6093a.mo13475e(2, this.ndH);
                }
                AppMethodBeat.m2505o(111679);
                return 0;
            }
        } else if (i == 1) {
            if (this.ndG != null) {
                f = C6091a.m9575f(1, this.ndG) + 0;
            } else {
                f = 0;
            }
            if (this.ndH != null) {
                f += C6091a.m9575f(2, this.ndH);
            }
            AppMethodBeat.m2505o(111679);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.ndG == null) {
                c6092b = new C6092b("Not all required fields were included: FromUserName");
                AppMethodBeat.m2505o(111679);
                throw c6092b;
            } else if (this.ndH == null) {
                c6092b = new C6092b("Not all required fields were included: TimeDesc");
                AppMethodBeat.m2505o(111679);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(111679);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C45997dl c45997dl = (C45997dl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c45997dl.ndG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111679);
                    return 0;
                case 2:
                    c45997dl.ndH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111679);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111679);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111679);
            return -1;
        }
    }
}
