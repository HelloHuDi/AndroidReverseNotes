package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.cc */
public final class C12116cc extends C1331a {
    public String Title;
    public LinkedList<C28189cd> ncP = new LinkedList();
    public C20950ce ncQ;

    public C12116cc() {
        AppMethodBeat.m2504i(111637);
        AppMethodBeat.m2505o(111637);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111638);
        C6092b c6092b;
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Title == null) {
                c6092b = new C6092b("Not all required fields were included: Title");
                AppMethodBeat.m2505o(111638);
                throw c6092b;
            }
            if (this.Title != null) {
                c6093a.mo13475e(1, this.Title);
            }
            c6093a.mo13474e(2, 8, this.ncP);
            if (this.ncQ != null) {
                c6093a.mo13479iy(3, this.ncQ.computeSize());
                this.ncQ.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(111638);
            return 0;
        } else if (i == 1) {
            if (this.Title != null) {
                f = C6091a.m9575f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            f += C6087a.m9552c(2, 8, this.ncP);
            if (this.ncQ != null) {
                f += C6087a.m9557ix(3, this.ncQ.computeSize());
            }
            AppMethodBeat.m2505o(111638);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ncP.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.Title == null) {
                c6092b = new C6092b("Not all required fields were included: Title");
                AppMethodBeat.m2505o(111638);
                throw c6092b;
            }
            AppMethodBeat.m2505o(111638);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C12116cc c12116cc = (C12116cc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c12116cc.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111638);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C28189cd c28189cd = new C28189cd();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c28189cd.populateBuilderWithField(c6086a3, c28189cd, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c12116cc.ncP.add(c28189cd);
                    }
                    AppMethodBeat.m2505o(111638);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C20950ce c20950ce = new C20950ce();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c20950ce.populateBuilderWithField(c6086a3, c20950ce, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c12116cc.ncQ = c20950ce;
                    }
                    AppMethodBeat.m2505o(111638);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111638);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111638);
            return -1;
        }
    }
}
