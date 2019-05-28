package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.fq */
public final class C35917fq extends C1331a {
    public String Name;
    public String Title;
    public String vEA;
    public C40521fr vHA;
    public String vHz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94510);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vHA == null) {
                c6092b = new C6092b("Not all required fields were included: ArtisIcon");
                AppMethodBeat.m2505o(94510);
                throw c6092b;
            }
            if (this.Name != null) {
                c6093a.mo13475e(1, this.Name);
            }
            if (this.Title != null) {
                c6093a.mo13475e(2, this.Title);
            }
            if (this.vHz != null) {
                c6093a.mo13475e(3, this.vHz);
            }
            if (this.vEA != null) {
                c6093a.mo13475e(4, this.vEA);
            }
            if (this.vHA != null) {
                c6093a.mo13479iy(5, this.vHA.computeSize());
                this.vHA.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(94510);
            return 0;
        } else if (i == 1) {
            if (this.Name != null) {
                f = C6091a.m9575f(1, this.Name) + 0;
            } else {
                f = 0;
            }
            if (this.Title != null) {
                f += C6091a.m9575f(2, this.Title);
            }
            if (this.vHz != null) {
                f += C6091a.m9575f(3, this.vHz);
            }
            if (this.vEA != null) {
                f += C6091a.m9575f(4, this.vEA);
            }
            if (this.vHA != null) {
                f += C6087a.m9557ix(5, this.vHA.computeSize());
            }
            AppMethodBeat.m2505o(94510);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.vHA == null) {
                c6092b = new C6092b("Not all required fields were included: ArtisIcon");
                AppMethodBeat.m2505o(94510);
                throw c6092b;
            }
            AppMethodBeat.m2505o(94510);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35917fq c35917fq = (C35917fq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c35917fq.Name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94510);
                    return 0;
                case 2:
                    c35917fq.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94510);
                    return 0;
                case 3:
                    c35917fq.vHz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94510);
                    return 0;
                case 4:
                    c35917fq.vEA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94510);
                    return 0;
                case 5:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C40521fr c40521fr = new C40521fr();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c40521fr.populateBuilderWithField(c6086a3, c40521fr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35917fq.vHA = c40521fr;
                    }
                    AppMethodBeat.m2505o(94510);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94510);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94510);
            return -1;
        }
    }
}
