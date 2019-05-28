package com.tencent.p177mm.plugin.downloader.p723c.p941a.p942a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.protocal.protobuf.BaseResponse;
import com.tencent.p177mm.protocal.protobuf.btd;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.downloader.c.a.a.m */
public final class C27703m extends btd {
    public C11502n kKG;
    public C45827i kKH;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(35522);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(35522);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.kKG != null) {
                c6093a.mo13479iy(2, this.kKG.computeSize());
                this.kKG.writeFields(c6093a);
            }
            if (this.kKH != null) {
                c6093a.mo13479iy(3, this.kKH.computeSize());
                this.kKH.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(35522);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.kKG != null) {
                ix += C6087a.m9557ix(2, this.kKG.computeSize());
            }
            if (this.kKH != null) {
                ix += C6087a.m9557ix(3, this.kKH.computeSize());
            }
            AppMethodBeat.m2505o(35522);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(35522);
                throw c6092b;
            }
            AppMethodBeat.m2505o(35522);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C27703m c27703m = (C27703m) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
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
                        c27703m.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(35522);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C11502n c11502n = new C11502n();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c11502n.populateBuilderWithField(c6086a3, c11502n, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c27703m.kKG = c11502n;
                    }
                    AppMethodBeat.m2505o(35522);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C45827i c45827i = new C45827i();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c45827i.populateBuilderWithField(c6086a3, c45827i, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c27703m.kKH = c45827i;
                    }
                    AppMethodBeat.m2505o(35522);
                    return 0;
                default:
                    AppMethodBeat.m2505o(35522);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(35522);
            return -1;
        }
    }
}
