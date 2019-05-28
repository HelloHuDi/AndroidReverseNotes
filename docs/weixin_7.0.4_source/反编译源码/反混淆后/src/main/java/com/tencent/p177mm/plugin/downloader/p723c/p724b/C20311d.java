package com.tencent.p177mm.plugin.downloader.p723c.p724b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.downloader.c.b.d */
public final class C20311d extends C1331a {
    public String kLe;
    public LinkedList<String> kLf = new LinkedList();
    public String kLg;
    public String kLh;
    public LinkedList<String> kLi = new LinkedList();
    public C11505m kLj;
    public C27705e kLk;

    public C20311d() {
        AppMethodBeat.m2504i(35528);
        AppMethodBeat.m2505o(35528);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(35529);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.kLe != null) {
                c6093a.mo13475e(1, this.kLe);
            }
            c6093a.mo13474e(2, 1, this.kLf);
            if (this.kLg != null) {
                c6093a.mo13475e(3, this.kLg);
            }
            if (this.kLh != null) {
                c6093a.mo13475e(4, this.kLh);
            }
            c6093a.mo13474e(5, 1, this.kLi);
            if (this.kLj != null) {
                c6093a.mo13479iy(6, this.kLj.computeSize());
                this.kLj.writeFields(c6093a);
            }
            if (this.kLk != null) {
                c6093a.mo13479iy(7, this.kLk.computeSize());
                this.kLk.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(35529);
            return 0;
        } else if (i == 1) {
            if (this.kLe != null) {
                f = C6091a.m9575f(1, this.kLe) + 0;
            } else {
                f = 0;
            }
            f += C6087a.m9552c(2, 1, this.kLf);
            if (this.kLg != null) {
                f += C6091a.m9575f(3, this.kLg);
            }
            if (this.kLh != null) {
                f += C6091a.m9575f(4, this.kLh);
            }
            f += C6087a.m9552c(5, 1, this.kLi);
            if (this.kLj != null) {
                f += C6087a.m9557ix(6, this.kLj.computeSize());
            }
            if (this.kLk != null) {
                f += C6087a.m9557ix(7, this.kLk.computeSize());
            }
            AppMethodBeat.m2505o(35529);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.kLf.clear();
            this.kLi.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(35529);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C20311d c20311d = (C20311d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c20311d.kLe = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35529);
                    return 0;
                case 2:
                    c20311d.kLf.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(35529);
                    return 0;
                case 3:
                    c20311d.kLg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35529);
                    return 0;
                case 4:
                    c20311d.kLh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35529);
                    return 0;
                case 5:
                    c20311d.kLi.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(35529);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C11505m c11505m = new C11505m();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c11505m.populateBuilderWithField(c6086a3, c11505m, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c20311d.kLj = c11505m;
                    }
                    AppMethodBeat.m2505o(35529);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C27705e c27705e = new C27705e();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c27705e.populateBuilderWithField(c6086a3, c27705e, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c20311d.kLk = c27705e;
                    }
                    AppMethodBeat.m2505o(35529);
                    return 0;
                default:
                    AppMethodBeat.m2505o(35529);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(35529);
            return -1;
        }
    }
}
