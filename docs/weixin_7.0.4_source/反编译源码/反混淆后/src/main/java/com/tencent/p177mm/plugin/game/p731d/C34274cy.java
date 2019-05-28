package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.cy */
public final class C34274cy extends C1331a {
    public String Title;
    public LinkedList<C6933an> mZK = new LinkedList();
    public String naP;
    public String nbi;

    public C34274cy() {
        AppMethodBeat.m2504i(111665);
        AppMethodBeat.m2505o(111665);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111666);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Title != null) {
                c6093a.mo13475e(1, this.Title);
            }
            c6093a.mo13474e(2, 8, this.mZK);
            if (this.naP != null) {
                c6093a.mo13475e(3, this.naP);
            }
            if (this.nbi != null) {
                c6093a.mo13475e(4, this.nbi);
            }
            AppMethodBeat.m2505o(111666);
            return 0;
        } else if (i == 1) {
            if (this.Title != null) {
                f = C6091a.m9575f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            f += C6087a.m9552c(2, 8, this.mZK);
            if (this.naP != null) {
                f += C6091a.m9575f(3, this.naP);
            }
            if (this.nbi != null) {
                f += C6091a.m9575f(4, this.nbi);
            }
            AppMethodBeat.m2505o(111666);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.mZK.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(111666);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C34274cy c34274cy = (C34274cy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c34274cy.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111666);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C6933an c6933an = new C6933an();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c6933an.populateBuilderWithField(c6086a3, c6933an, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c34274cy.mZK.add(c6933an);
                    }
                    AppMethodBeat.m2505o(111666);
                    return 0;
                case 3:
                    c34274cy.naP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111666);
                    return 0;
                case 4:
                    c34274cy.nbi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111666);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111666);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111666);
            return -1;
        }
    }
}
