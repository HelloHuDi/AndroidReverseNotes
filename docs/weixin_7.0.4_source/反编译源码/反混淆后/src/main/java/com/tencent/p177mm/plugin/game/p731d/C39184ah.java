package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.ah */
public final class C39184ah extends C1331a {
    public String mZL;
    public String mZM;
    public LinkedList<C34273cx> naO = new LinkedList();
    public String naP;
    public String naQ;

    public C39184ah() {
        AppMethodBeat.m2504i(111573);
        AppMethodBeat.m2505o(111573);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111574);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.mZM != null) {
                c6093a.mo13475e(1, this.mZM);
            }
            c6093a.mo13474e(2, 8, this.naO);
            if (this.naP != null) {
                c6093a.mo13475e(3, this.naP);
            }
            if (this.naQ != null) {
                c6093a.mo13475e(4, this.naQ);
            }
            if (this.mZL != null) {
                c6093a.mo13475e(5, this.mZL);
            }
            AppMethodBeat.m2505o(111574);
            return 0;
        } else if (i == 1) {
            if (this.mZM != null) {
                f = C6091a.m9575f(1, this.mZM) + 0;
            } else {
                f = 0;
            }
            f += C6087a.m9552c(2, 8, this.naO);
            if (this.naP != null) {
                f += C6091a.m9575f(3, this.naP);
            }
            if (this.naQ != null) {
                f += C6091a.m9575f(4, this.naQ);
            }
            if (this.mZL != null) {
                f += C6091a.m9575f(5, this.mZL);
            }
            AppMethodBeat.m2505o(111574);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.naO.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(111574);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C39184ah c39184ah = (C39184ah) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c39184ah.mZM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111574);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C34273cx c34273cx = new C34273cx();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c34273cx.populateBuilderWithField(c6086a3, c34273cx, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c39184ah.naO.add(c34273cx);
                    }
                    AppMethodBeat.m2505o(111574);
                    return 0;
                case 3:
                    c39184ah.naP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111574);
                    return 0;
                case 4:
                    c39184ah.naQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111574);
                    return 0;
                case 5:
                    c39184ah.mZL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111574);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111574);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111574);
            return -1;
        }
    }
}
