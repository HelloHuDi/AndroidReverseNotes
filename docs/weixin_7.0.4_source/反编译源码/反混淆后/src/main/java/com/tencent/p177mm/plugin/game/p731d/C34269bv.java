package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.bv */
public final class C34269bv extends C1331a {
    public String Title;
    public String ncA;
    public String ncB;
    public LinkedList<C34270bw> ncE = new LinkedList();

    public C34269bv() {
        AppMethodBeat.m2504i(111628);
        AppMethodBeat.m2505o(111628);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111629);
        C6092b c6092b;
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Title == null) {
                c6092b = new C6092b("Not all required fields were included: Title");
                AppMethodBeat.m2505o(111629);
                throw c6092b;
            }
            if (this.Title != null) {
                c6093a.mo13475e(1, this.Title);
            }
            c6093a.mo13474e(2, 8, this.ncE);
            if (this.ncA != null) {
                c6093a.mo13475e(3, this.ncA);
            }
            if (this.ncB != null) {
                c6093a.mo13475e(4, this.ncB);
            }
            AppMethodBeat.m2505o(111629);
            return 0;
        } else if (i == 1) {
            if (this.Title != null) {
                f = C6091a.m9575f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            f += C6087a.m9552c(2, 8, this.ncE);
            if (this.ncA != null) {
                f += C6091a.m9575f(3, this.ncA);
            }
            if (this.ncB != null) {
                f += C6091a.m9575f(4, this.ncB);
            }
            AppMethodBeat.m2505o(111629);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ncE.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.Title == null) {
                c6092b = new C6092b("Not all required fields were included: Title");
                AppMethodBeat.m2505o(111629);
                throw c6092b;
            }
            AppMethodBeat.m2505o(111629);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C34269bv c34269bv = (C34269bv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c34269bv.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111629);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C34270bw c34270bw = new C34270bw();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c34270bw.populateBuilderWithField(c6086a3, c34270bw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c34269bv.ncE.add(c34270bw);
                    }
                    AppMethodBeat.m2505o(111629);
                    return 0;
                case 3:
                    c34269bv.ncA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111629);
                    return 0;
                case 4:
                    c34269bv.ncB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111629);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111629);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111629);
            return -1;
        }
    }
}
