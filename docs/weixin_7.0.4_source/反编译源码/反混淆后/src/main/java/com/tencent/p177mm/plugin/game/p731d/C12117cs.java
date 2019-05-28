package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.cs */
public final class C12117cs extends C1331a {
    public String Desc;
    public String Title;
    public String fKh;
    public String mZi;
    public C45998e mZk;
    public String nas;
    public String nbr;
    public LinkedList<C43176x> ndm = new LinkedList();

    public C12117cs() {
        AppMethodBeat.m2504i(111658);
        AppMethodBeat.m2505o(111658);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111659);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Title != null) {
                c6093a.mo13475e(1, this.Title);
            }
            if (this.fKh != null) {
                c6093a.mo13475e(2, this.fKh);
            }
            if (this.mZi != null) {
                c6093a.mo13475e(3, this.mZi);
            }
            if (this.Desc != null) {
                c6093a.mo13475e(4, this.Desc);
            }
            if (this.nbr != null) {
                c6093a.mo13475e(5, this.nbr);
            }
            if (this.mZk != null) {
                c6093a.mo13479iy(6, this.mZk.computeSize());
                this.mZk.writeFields(c6093a);
            }
            c6093a.mo13474e(7, 8, this.ndm);
            if (this.nas != null) {
                c6093a.mo13475e(8, this.nas);
            }
            AppMethodBeat.m2505o(111659);
            return 0;
        } else if (i == 1) {
            if (this.Title != null) {
                f = C6091a.m9575f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            if (this.fKh != null) {
                f += C6091a.m9575f(2, this.fKh);
            }
            if (this.mZi != null) {
                f += C6091a.m9575f(3, this.mZi);
            }
            if (this.Desc != null) {
                f += C6091a.m9575f(4, this.Desc);
            }
            if (this.nbr != null) {
                f += C6091a.m9575f(5, this.nbr);
            }
            if (this.mZk != null) {
                f += C6087a.m9557ix(6, this.mZk.computeSize());
            }
            f += C6087a.m9552c(7, 8, this.ndm);
            if (this.nas != null) {
                f += C6091a.m9575f(8, this.nas);
            }
            AppMethodBeat.m2505o(111659);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ndm.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(111659);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C12117cs c12117cs = (C12117cs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c12117cs.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111659);
                    return 0;
                case 2:
                    c12117cs.fKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111659);
                    return 0;
                case 3:
                    c12117cs.mZi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111659);
                    return 0;
                case 4:
                    c12117cs.Desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111659);
                    return 0;
                case 5:
                    c12117cs.nbr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111659);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C45998e c45998e = new C45998e();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c45998e.populateBuilderWithField(c6086a3, c45998e, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c12117cs.mZk = c45998e;
                    }
                    AppMethodBeat.m2505o(111659);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C43176x c43176x = new C43176x();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c43176x.populateBuilderWithField(c6086a3, c43176x, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c12117cs.ndm.add(c43176x);
                    }
                    AppMethodBeat.m2505o(111659);
                    return 0;
                case 8:
                    c12117cs.nas = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111659);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111659);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111659);
            return -1;
        }
    }
}
