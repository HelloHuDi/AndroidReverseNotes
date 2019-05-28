package p1121d.p1122a.p1123a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: d.a.a.c */
public final class C31176c extends C1331a {
    public int BTA;
    public int BTB;
    public int BTC;
    public C31177e BTD;
    public String BTE;
    public C41148b BTF;
    public String wdr;
    public String wev;
    public LinkedList<C44605g> wew = new LinkedList();
    public int wex;
    public C44604a wey;

    public C31176c() {
        AppMethodBeat.m2504i(57007);
        AppMethodBeat.m2505o(57007);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(57008);
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 8, this.wew);
            c6093a.mo13480iz(2, this.BTA);
            if (this.wdr != null) {
                c6093a.mo13475e(3, this.wdr);
            }
            c6093a.mo13480iz(4, this.wex);
            if (this.wey != null) {
                c6093a.mo13479iy(5, this.wey.computeSize());
                this.wey.writeFields(c6093a);
            }
            if (this.wev != null) {
                c6093a.mo13475e(6, this.wev);
            }
            c6093a.mo13480iz(7, this.BTB);
            c6093a.mo13480iz(8, this.BTC);
            if (this.BTD != null) {
                c6093a.mo13479iy(9, this.BTD.computeSize());
                this.BTD.writeFields(c6093a);
            }
            if (this.BTE != null) {
                c6093a.mo13475e(10, this.BTE);
            }
            if (this.BTF != null) {
                c6093a.mo13479iy(11, this.BTF.computeSize());
                this.BTF.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(57008);
            return 0;
        } else if (i == 1) {
            c = (C6087a.m9552c(1, 8, this.wew) + 0) + C6091a.m9572bs(2, this.BTA);
            if (this.wdr != null) {
                c += C6091a.m9575f(3, this.wdr);
            }
            c += C6091a.m9572bs(4, this.wex);
            if (this.wey != null) {
                c += C6087a.m9557ix(5, this.wey.computeSize());
            }
            if (this.wev != null) {
                c += C6091a.m9575f(6, this.wev);
            }
            c = (c + C6091a.m9572bs(7, this.BTB)) + C6091a.m9572bs(8, this.BTC);
            if (this.BTD != null) {
                c += C6087a.m9557ix(9, this.BTD.computeSize());
            }
            if (this.BTE != null) {
                c += C6091a.m9575f(10, this.BTE);
            }
            if (this.BTF != null) {
                c += C6087a.m9557ix(11, this.BTF.computeSize());
            }
            AppMethodBeat.m2505o(57008);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wew.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(57008);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C31176c c31176c = (C31176c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C44605g c44605g = new C44605g();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44605g.populateBuilderWithField(c6086a3, c44605g, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c31176c.wew.add(c44605g);
                    }
                    AppMethodBeat.m2505o(57008);
                    return 0;
                case 2:
                    c31176c.BTA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(57008);
                    return 0;
                case 3:
                    c31176c.wdr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(57008);
                    return 0;
                case 4:
                    c31176c.wex = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(57008);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C44604a c44604a = new C44604a();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44604a.populateBuilderWithField(c6086a3, c44604a, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c31176c.wey = c44604a;
                    }
                    AppMethodBeat.m2505o(57008);
                    return 0;
                case 6:
                    c31176c.wev = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(57008);
                    return 0;
                case 7:
                    c31176c.BTB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(57008);
                    return 0;
                case 8:
                    c31176c.BTC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(57008);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C31177e c31177e = new C31177e();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c31177e.populateBuilderWithField(c6086a3, c31177e, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c31176c.BTD = c31177e;
                    }
                    AppMethodBeat.m2505o(57008);
                    return 0;
                case 10:
                    c31176c.BTE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(57008);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C41148b c41148b = new C41148b();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c41148b.populateBuilderWithField(c6086a3, c41148b, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c31176c.BTF = c41148b;
                    }
                    AppMethodBeat.m2505o(57008);
                    return 0;
                default:
                    AppMethodBeat.m2505o(57008);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(57008);
            return -1;
        }
    }
}
