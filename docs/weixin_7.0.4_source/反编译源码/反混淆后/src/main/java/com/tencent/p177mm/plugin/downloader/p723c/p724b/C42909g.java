package com.tencent.p177mm.plugin.downloader.p723c.p724b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.downloader.c.b.g */
public final class C42909g extends C1331a {
    public C38846h kLs;
    public C38846h kLt;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(35533);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.kLs != null) {
                c6093a.mo13479iy(1, this.kLs.computeSize());
                this.kLs.writeFields(c6093a);
            }
            if (this.kLt != null) {
                c6093a.mo13479iy(2, this.kLt.computeSize());
                this.kLt.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(35533);
            return 0;
        } else if (i == 1) {
            if (this.kLs != null) {
                ix = C6087a.m9557ix(1, this.kLs.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.kLt != null) {
                ix += C6087a.m9557ix(2, this.kLt.computeSize());
            }
            AppMethodBeat.m2505o(35533);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(35533);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C42909g c42909g = (C42909g) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C38846h c38846h;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c38846h = new C38846h();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c38846h.populateBuilderWithField(c6086a3, c38846h, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c42909g.kLs = c38846h;
                    }
                    AppMethodBeat.m2505o(35533);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c38846h = new C38846h();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c38846h.populateBuilderWithField(c6086a3, c38846h, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c42909g.kLt = c38846h;
                    }
                    AppMethodBeat.m2505o(35533);
                    return 0;
                default:
                    AppMethodBeat.m2505o(35533);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(35533);
            return -1;
        }
    }
}
