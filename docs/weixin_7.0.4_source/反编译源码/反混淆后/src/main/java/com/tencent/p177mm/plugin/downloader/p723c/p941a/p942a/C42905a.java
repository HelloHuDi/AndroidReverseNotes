package com.tencent.p177mm.plugin.downloader.p723c.p941a.p942a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.protocal.protobuf.C7267hl;
import com.tencent.p177mm.protocal.protobuf.bsr;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.downloader.c.a.a.a */
public final class C42905a extends bsr {
    public LinkedList<String> kKk = new LinkedList();
    public boolean kKl;
    public boolean kKm;
    public boolean kKn;

    public C42905a() {
        AppMethodBeat.m2504i(35506);
        AppMethodBeat.m2505o(35506);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(35507);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13474e(2, 1, this.kKk);
            c6093a.mo13471aO(3, this.kKl);
            c6093a.mo13471aO(4, this.kKm);
            c6093a.mo13471aO(5, this.kKn);
            AppMethodBeat.m2505o(35507);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int c = (((ix + C6087a.m9552c(2, 1, this.kKk)) + (C6091a.m9576fv(3) + 1)) + (C6091a.m9576fv(4) + 1)) + (C6091a.m9576fv(5) + 1);
            AppMethodBeat.m2505o(35507);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.kKk.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(35507);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C42905a c42905a = (C42905a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c42905a.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(35507);
                    return 0;
                case 2:
                    c42905a.kKk.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(35507);
                    return 0;
                case 3:
                    c42905a.kKl = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(35507);
                    return 0;
                case 4:
                    c42905a.kKm = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(35507);
                    return 0;
                case 5:
                    c42905a.kKn = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(35507);
                    return 0;
                default:
                    AppMethodBeat.m2505o(35507);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(35507);
            return -1;
        }
    }
}
