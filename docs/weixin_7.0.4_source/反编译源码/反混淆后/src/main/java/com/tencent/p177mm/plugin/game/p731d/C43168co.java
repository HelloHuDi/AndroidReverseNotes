package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.co */
public final class C43168co extends C1331a {
    public String nap;
    public C45993cp ndf;
    public C45993cp ndg;
    public C45993cp ndh;
    public C45993cp ndi;
    public C45993cp ndj;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111652);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.ndf != null) {
                c6093a.mo13479iy(1, this.ndf.computeSize());
                this.ndf.writeFields(c6093a);
            }
            if (this.ndg != null) {
                c6093a.mo13479iy(2, this.ndg.computeSize());
                this.ndg.writeFields(c6093a);
            }
            if (this.ndh != null) {
                c6093a.mo13479iy(3, this.ndh.computeSize());
                this.ndh.writeFields(c6093a);
            }
            if (this.ndi != null) {
                c6093a.mo13479iy(4, this.ndi.computeSize());
                this.ndi.writeFields(c6093a);
            }
            if (this.ndj != null) {
                c6093a.mo13479iy(6, this.ndj.computeSize());
                this.ndj.writeFields(c6093a);
            }
            if (this.nap != null) {
                c6093a.mo13475e(5, this.nap);
            }
            AppMethodBeat.m2505o(111652);
            return 0;
        } else if (i == 1) {
            if (this.ndf != null) {
                ix = C6087a.m9557ix(1, this.ndf.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ndg != null) {
                ix += C6087a.m9557ix(2, this.ndg.computeSize());
            }
            if (this.ndh != null) {
                ix += C6087a.m9557ix(3, this.ndh.computeSize());
            }
            if (this.ndi != null) {
                ix += C6087a.m9557ix(4, this.ndi.computeSize());
            }
            if (this.ndj != null) {
                ix += C6087a.m9557ix(6, this.ndj.computeSize());
            }
            if (this.nap != null) {
                ix += C6091a.m9575f(5, this.nap);
            }
            AppMethodBeat.m2505o(111652);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(111652);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C43168co c43168co = (C43168co) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C45993cp c45993cp;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c45993cp = new C45993cp();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c45993cp.populateBuilderWithField(c6086a3, c45993cp, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c43168co.ndf = c45993cp;
                    }
                    AppMethodBeat.m2505o(111652);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c45993cp = new C45993cp();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c45993cp.populateBuilderWithField(c6086a3, c45993cp, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c43168co.ndg = c45993cp;
                    }
                    AppMethodBeat.m2505o(111652);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c45993cp = new C45993cp();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c45993cp.populateBuilderWithField(c6086a3, c45993cp, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c43168co.ndh = c45993cp;
                    }
                    AppMethodBeat.m2505o(111652);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c45993cp = new C45993cp();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c45993cp.populateBuilderWithField(c6086a3, c45993cp, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c43168co.ndi = c45993cp;
                    }
                    AppMethodBeat.m2505o(111652);
                    return 0;
                case 5:
                    c43168co.nap = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111652);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c45993cp = new C45993cp();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c45993cp.populateBuilderWithField(c6086a3, c45993cp, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c43168co.ndj = c45993cp;
                    }
                    AppMethodBeat.m2505o(111652);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111652);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111652);
            return -1;
        }
    }
}
