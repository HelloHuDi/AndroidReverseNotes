package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.uf */
public final class C30230uf extends C1331a {
    public String Desc;
    public String Title;
    public String Url;
    public int wbJ;
    public LinkedList<bau> wbK = new LinkedList();
    public int wbL;
    public String wbM;
    public azu wbN;

    public C30230uf() {
        AppMethodBeat.m2504i(94516);
        AppMethodBeat.m2505o(94516);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94517);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Desc != null) {
                c6093a.mo13475e(1, this.Desc);
            }
            c6093a.mo13480iz(2, this.wbJ);
            if (this.Title != null) {
                c6093a.mo13475e(3, this.Title);
            }
            if (this.Url != null) {
                c6093a.mo13475e(4, this.Url);
            }
            c6093a.mo13474e(5, 8, this.wbK);
            c6093a.mo13480iz(6, this.wbL);
            if (this.wbM != null) {
                c6093a.mo13475e(7, this.wbM);
            }
            if (this.wbN != null) {
                c6093a.mo13479iy(8, this.wbN.computeSize());
                this.wbN.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(94517);
            return 0;
        } else if (i == 1) {
            if (this.Desc != null) {
                f = C6091a.m9575f(1, this.Desc) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.wbJ);
            if (this.Title != null) {
                f += C6091a.m9575f(3, this.Title);
            }
            if (this.Url != null) {
                f += C6091a.m9575f(4, this.Url);
            }
            f = (f + C6087a.m9552c(5, 8, this.wbK)) + C6091a.m9572bs(6, this.wbL);
            if (this.wbM != null) {
                f += C6091a.m9575f(7, this.wbM);
            }
            if (this.wbN != null) {
                f += C6087a.m9557ix(8, this.wbN.computeSize());
            }
            AppMethodBeat.m2505o(94517);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wbK.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(94517);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C30230uf c30230uf = (C30230uf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c30230uf.Desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94517);
                    return 0;
                case 2:
                    c30230uf.wbJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94517);
                    return 0;
                case 3:
                    c30230uf.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94517);
                    return 0;
                case 4:
                    c30230uf.Url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94517);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bau bau = new bau();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bau.populateBuilderWithField(c6086a3, bau, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30230uf.wbK.add(bau);
                    }
                    AppMethodBeat.m2505o(94517);
                    return 0;
                case 6:
                    c30230uf.wbL = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94517);
                    return 0;
                case 7:
                    c30230uf.wbM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94517);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        azu azu = new azu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = azu.populateBuilderWithField(c6086a3, azu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30230uf.wbN = azu;
                    }
                    AppMethodBeat.m2505o(94517);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94517);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94517);
            return -1;
        }
    }
}
