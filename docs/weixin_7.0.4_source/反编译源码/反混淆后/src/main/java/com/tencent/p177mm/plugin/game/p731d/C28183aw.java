package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.aw */
public final class C28183aw extends C1331a {
    public String IconUrl;
    public String Title;
    public String fKh;
    public String mZi;
    public C45998e mZk;
    public LinkedList<String> nbo = new LinkedList();
    public String nbp;
    public String nbq;
    public String nbr;

    public C28183aw() {
        AppMethodBeat.m2504i(111592);
        AppMethodBeat.m2505o(111592);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111593);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Title != null) {
                c6093a.mo13475e(1, this.Title);
            }
            if (this.IconUrl != null) {
                c6093a.mo13475e(2, this.IconUrl);
            }
            c6093a.mo13474e(3, 1, this.nbo);
            if (this.nbp != null) {
                c6093a.mo13475e(4, this.nbp);
            }
            if (this.mZi != null) {
                c6093a.mo13475e(5, this.mZi);
            }
            if (this.nbq != null) {
                c6093a.mo13475e(6, this.nbq);
            }
            if (this.nbr != null) {
                c6093a.mo13475e(8, this.nbr);
            }
            if (this.fKh != null) {
                c6093a.mo13475e(9, this.fKh);
            }
            if (this.mZk != null) {
                c6093a.mo13479iy(10, this.mZk.computeSize());
                this.mZk.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(111593);
            return 0;
        } else if (i == 1) {
            if (this.Title != null) {
                f = C6091a.m9575f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            if (this.IconUrl != null) {
                f += C6091a.m9575f(2, this.IconUrl);
            }
            f += C6087a.m9552c(3, 1, this.nbo);
            if (this.nbp != null) {
                f += C6091a.m9575f(4, this.nbp);
            }
            if (this.mZi != null) {
                f += C6091a.m9575f(5, this.mZi);
            }
            if (this.nbq != null) {
                f += C6091a.m9575f(6, this.nbq);
            }
            if (this.nbr != null) {
                f += C6091a.m9575f(8, this.nbr);
            }
            if (this.fKh != null) {
                f += C6091a.m9575f(9, this.fKh);
            }
            if (this.mZk != null) {
                f += C6087a.m9557ix(10, this.mZk.computeSize());
            }
            AppMethodBeat.m2505o(111593);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nbo.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(111593);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C28183aw c28183aw = (C28183aw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c28183aw.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111593);
                    return 0;
                case 2:
                    c28183aw.IconUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111593);
                    return 0;
                case 3:
                    c28183aw.nbo.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(111593);
                    return 0;
                case 4:
                    c28183aw.nbp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111593);
                    return 0;
                case 5:
                    c28183aw.mZi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111593);
                    return 0;
                case 6:
                    c28183aw.nbq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111593);
                    return 0;
                case 8:
                    c28183aw.nbr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111593);
                    return 0;
                case 9:
                    c28183aw.fKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111593);
                    return 0;
                case 10:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C45998e c45998e = new C45998e();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c45998e.populateBuilderWithField(c6086a3, c45998e, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c28183aw.mZk = c45998e;
                    }
                    AppMethodBeat.m2505o(111593);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111593);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111593);
            return -1;
        }
    }
}
