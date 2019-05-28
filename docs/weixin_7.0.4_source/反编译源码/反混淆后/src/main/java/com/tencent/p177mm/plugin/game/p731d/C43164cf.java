package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.cf */
public final class C43164cf extends C1331a {
    public String Title;
    public String naq;
    public LinkedList<C20952cl> ncS = new LinkedList();

    public C43164cf() {
        AppMethodBeat.m2504i(111641);
        AppMethodBeat.m2505o(111641);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111642);
        C6092b c6092b;
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Title == null) {
                c6092b = new C6092b("Not all required fields were included: Title");
                AppMethodBeat.m2505o(111642);
                throw c6092b;
            } else if (this.naq == null) {
                c6092b = new C6092b("Not all required fields were included: Detail");
                AppMethodBeat.m2505o(111642);
                throw c6092b;
            } else {
                if (this.Title != null) {
                    c6093a.mo13475e(1, this.Title);
                }
                c6093a.mo13474e(2, 8, this.ncS);
                if (this.naq != null) {
                    c6093a.mo13475e(3, this.naq);
                }
                AppMethodBeat.m2505o(111642);
                return 0;
            }
        } else if (i == 1) {
            if (this.Title != null) {
                f = C6091a.m9575f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            f += C6087a.m9552c(2, 8, this.ncS);
            if (this.naq != null) {
                f += C6091a.m9575f(3, this.naq);
            }
            AppMethodBeat.m2505o(111642);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ncS.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.Title == null) {
                c6092b = new C6092b("Not all required fields were included: Title");
                AppMethodBeat.m2505o(111642);
                throw c6092b;
            } else if (this.naq == null) {
                c6092b = new C6092b("Not all required fields were included: Detail");
                AppMethodBeat.m2505o(111642);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(111642);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C43164cf c43164cf = (C43164cf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c43164cf.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111642);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C20952cl c20952cl = new C20952cl();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c20952cl.populateBuilderWithField(c6086a3, c20952cl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c43164cf.ncS.add(c20952cl);
                    }
                    AppMethodBeat.m2505o(111642);
                    return 0;
                case 3:
                    c43164cf.naq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111642);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111642);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111642);
            return -1;
        }
    }
}
