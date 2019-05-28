package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.acr */
public final class acr extends C1331a {
    public LinkedList<C23406kf> vNd = new LinkedList();
    public C44133kd wku;

    public acr() {
        AppMethodBeat.m2504i(11749);
        AppMethodBeat.m2505o(11749);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(11750);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wku != null) {
                c6093a.mo13479iy(1, this.wku.computeSize());
                this.wku.writeFields(c6093a);
            }
            c6093a.mo13474e(2, 8, this.vNd);
            AppMethodBeat.m2505o(11750);
            return 0;
        } else if (i == 1) {
            if (this.wku != null) {
                ix = C6087a.m9557ix(1, this.wku.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int c = ix + C6087a.m9552c(2, 8, this.vNd);
            AppMethodBeat.m2505o(11750);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vNd.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(11750);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            acr acr = (acr) objArr[1];
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
                        C44133kd c44133kd = new C44133kd();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44133kd.populateBuilderWithField(c6086a3, c44133kd, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        acr.wku = c44133kd;
                    }
                    AppMethodBeat.m2505o(11750);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23406kf c23406kf = new C23406kf();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23406kf.populateBuilderWithField(c6086a3, c23406kf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        acr.vNd.add(c23406kf);
                    }
                    AppMethodBeat.m2505o(11750);
                    return 0;
                default:
                    AppMethodBeat.m2505o(11750);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(11750);
            return -1;
        }
    }
}
