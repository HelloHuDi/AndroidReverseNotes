package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.da */
public final class C7256da extends C1331a {
    public String title;
    public String vFh;
    public LinkedList<cdm> vFi = new LinkedList();

    public C7256da() {
        AppMethodBeat.m2504i(28308);
        AppMethodBeat.m2505o(28308);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28309);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vFh != null) {
                c6093a.mo13475e(1, this.vFh);
            }
            c6093a.mo13474e(2, 8, this.vFi);
            if (this.title != null) {
                c6093a.mo13475e(3, this.title);
            }
            AppMethodBeat.m2505o(28309);
            return 0;
        } else if (i == 1) {
            if (this.vFh != null) {
                f = C6091a.m9575f(1, this.vFh) + 0;
            } else {
                f = 0;
            }
            f += C6087a.m9552c(2, 8, this.vFi);
            if (this.title != null) {
                f += C6091a.m9575f(3, this.title);
            }
            AppMethodBeat.m2505o(28309);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vFi.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28309);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7256da c7256da = (C7256da) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c7256da.vFh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28309);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdm cdm = new cdm();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cdm.populateBuilderWithField(c6086a3, cdm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7256da.vFi.add(cdm);
                    }
                    AppMethodBeat.m2505o(28309);
                    return 0;
                case 3:
                    c7256da.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28309);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28309);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28309);
            return -1;
        }
    }
}
