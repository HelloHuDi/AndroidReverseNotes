package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.bs */
public final class C6935bs extends C1331a {
    public String Title;
    public String ncA;
    public String ncB;
    public LinkedList<C34268bt> ncz = new LinkedList();

    public C6935bs() {
        AppMethodBeat.m2504i(111624);
        AppMethodBeat.m2505o(111624);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111625);
        C6092b c6092b;
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Title == null) {
                c6092b = new C6092b("Not all required fields were included: Title");
                AppMethodBeat.m2505o(111625);
                throw c6092b;
            }
            if (this.Title != null) {
                c6093a.mo13475e(1, this.Title);
            }
            c6093a.mo13474e(2, 8, this.ncz);
            if (this.ncA != null) {
                c6093a.mo13475e(3, this.ncA);
            }
            if (this.ncB != null) {
                c6093a.mo13475e(4, this.ncB);
            }
            AppMethodBeat.m2505o(111625);
            return 0;
        } else if (i == 1) {
            if (this.Title != null) {
                f = C6091a.m9575f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            f += C6087a.m9552c(2, 8, this.ncz);
            if (this.ncA != null) {
                f += C6091a.m9575f(3, this.ncA);
            }
            if (this.ncB != null) {
                f += C6091a.m9575f(4, this.ncB);
            }
            AppMethodBeat.m2505o(111625);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ncz.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.Title == null) {
                c6092b = new C6092b("Not all required fields were included: Title");
                AppMethodBeat.m2505o(111625);
                throw c6092b;
            }
            AppMethodBeat.m2505o(111625);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C6935bs c6935bs = (C6935bs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c6935bs.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111625);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C34268bt c34268bt = new C34268bt();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c34268bt.populateBuilderWithField(c6086a3, c34268bt, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c6935bs.ncz.add(c34268bt);
                    }
                    AppMethodBeat.m2505o(111625);
                    return 0;
                case 3:
                    c6935bs.ncA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111625);
                    return 0;
                case 4:
                    c6935bs.ncB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111625);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111625);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111625);
            return -1;
        }
    }
}
