package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cwm */
public final class cwm extends btd {
    public cwg vXT;
    public LinkedList<cwu> xsh = new LinkedList();

    public cwm() {
        AppMethodBeat.m2504i(114999);
        AppMethodBeat.m2505o(114999);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(115000);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13474e(2, 8, this.xsh);
            if (this.vXT != null) {
                c6093a.mo13479iy(3, this.vXT.computeSize());
                this.vXT.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(115000);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6087a.m9552c(2, 8, this.xsh);
            if (this.vXT != null) {
                ix += C6087a.m9557ix(3, this.vXT.computeSize());
            }
            AppMethodBeat.m2505o(115000);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xsh.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(115000);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cwm cwm = (cwm) objArr[1];
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
                        BaseResponse baseResponse = new BaseResponse();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(c6086a3, baseResponse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cwm.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(115000);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cwu cwu = new cwu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cwu.populateBuilderWithField(c6086a3, cwu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cwm.xsh.add(cwu);
                    }
                    AppMethodBeat.m2505o(115000);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cwg cwg = new cwg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cwg.populateBuilderWithField(c6086a3, cwg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cwm.vXT = cwg;
                    }
                    AppMethodBeat.m2505o(115000);
                    return 0;
                default:
                    AppMethodBeat.m2505o(115000);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(115000);
            return -1;
        }
    }
}
