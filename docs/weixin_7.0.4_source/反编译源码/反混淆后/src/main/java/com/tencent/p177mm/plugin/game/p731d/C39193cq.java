package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.cq */
public final class C39193cq extends C1331a {
    public String ncB;
    public LinkedList<C45994cr> ndk = new LinkedList();
    public String ndl;

    public C39193cq() {
        AppMethodBeat.m2504i(111654);
        AppMethodBeat.m2505o(111654);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111655);
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 8, this.ndk);
            if (this.ncB != null) {
                c6093a.mo13475e(2, this.ncB);
            }
            if (this.ndl != null) {
                c6093a.mo13475e(3, this.ndl);
            }
            AppMethodBeat.m2505o(111655);
            return 0;
        } else if (i == 1) {
            c = C6087a.m9552c(1, 8, this.ndk) + 0;
            if (this.ncB != null) {
                c += C6091a.m9575f(2, this.ncB);
            }
            if (this.ndl != null) {
                c += C6091a.m9575f(3, this.ndl);
            }
            AppMethodBeat.m2505o(111655);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ndk.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(111655);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C39193cq c39193cq = (C39193cq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C45994cr c45994cr = new C45994cr();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c45994cr.populateBuilderWithField(c6086a3, c45994cr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c39193cq.ndk.add(c45994cr);
                    }
                    AppMethodBeat.m2505o(111655);
                    return 0;
                case 2:
                    c39193cq.ncB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111655);
                    return 0;
                case 3:
                    c39193cq.ndl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111655);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111655);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111655);
            return -1;
        }
    }
}
