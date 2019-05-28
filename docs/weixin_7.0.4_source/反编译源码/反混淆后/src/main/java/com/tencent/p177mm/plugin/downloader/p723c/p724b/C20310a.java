package com.tencent.p177mm.plugin.downloader.p723c.p724b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.downloader.c.b.a */
public final class C20310a extends C1331a {
    public String cIY;
    public C33907p kKL;
    public C33907p kKM;
    public String kKN;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(35525);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.cIY != null) {
                c6093a.mo13475e(1, this.cIY);
            }
            if (this.kKL != null) {
                c6093a.mo13479iy(2, this.kKL.computeSize());
                this.kKL.writeFields(c6093a);
            }
            if (this.kKM != null) {
                c6093a.mo13479iy(3, this.kKM.computeSize());
                this.kKM.writeFields(c6093a);
            }
            if (this.kKN != null) {
                c6093a.mo13475e(4, this.kKN);
            }
            AppMethodBeat.m2505o(35525);
            return 0;
        } else if (i == 1) {
            if (this.cIY != null) {
                f = C6091a.m9575f(1, this.cIY) + 0;
            } else {
                f = 0;
            }
            if (this.kKL != null) {
                f += C6087a.m9557ix(2, this.kKL.computeSize());
            }
            if (this.kKM != null) {
                f += C6087a.m9557ix(3, this.kKM.computeSize());
            }
            if (this.kKN != null) {
                f += C6091a.m9575f(4, this.kKN);
            }
            AppMethodBeat.m2505o(35525);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(35525);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C20310a c20310a = (C20310a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C33907p c33907p;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c20310a.cIY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35525);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c33907p = new C33907p();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c33907p.populateBuilderWithField(c6086a3, c33907p, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c20310a.kKL = c33907p;
                    }
                    AppMethodBeat.m2505o(35525);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c33907p = new C33907p();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c33907p.populateBuilderWithField(c6086a3, c33907p, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c20310a.kKM = c33907p;
                    }
                    AppMethodBeat.m2505o(35525);
                    return 0;
                case 4:
                    c20310a.kKN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35525);
                    return 0;
                default:
                    AppMethodBeat.m2505o(35525);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(35525);
            return -1;
        }
    }
}
