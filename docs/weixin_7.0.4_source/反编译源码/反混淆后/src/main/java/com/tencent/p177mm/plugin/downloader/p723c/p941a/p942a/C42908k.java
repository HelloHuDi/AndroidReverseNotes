package com.tencent.p177mm.plugin.downloader.p723c.p941a.p942a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.protocal.protobuf.BaseResponse;
import com.tencent.p177mm.protocal.protobuf.btd;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.downloader.c.a.a.k */
public final class C42908k extends btd {
    public int kKC;
    public String kKD;
    public C33904d kKy;
    public int kdT;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(35520);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(35520);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.kKy != null) {
                c6093a.mo13479iy(2, this.kKy.computeSize());
                this.kKy.writeFields(c6093a);
            }
            c6093a.mo13480iz(3, this.kdT);
            c6093a.mo13480iz(4, this.kKC);
            if (this.kKD != null) {
                c6093a.mo13475e(5, this.kKD);
            }
            AppMethodBeat.m2505o(35520);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.kKy != null) {
                ix += C6087a.m9557ix(2, this.kKy.computeSize());
            }
            ix = (ix + C6091a.m9572bs(3, this.kdT)) + C6091a.m9572bs(4, this.kKC);
            if (this.kKD != null) {
                ix += C6091a.m9575f(5, this.kKD);
            }
            AppMethodBeat.m2505o(35520);
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
                AppMethodBeat.m2505o(35520);
                throw c6092b;
            }
            AppMethodBeat.m2505o(35520);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C42908k c42908k = (C42908k) objArr[1];
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
                        c42908k.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(35520);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C33904d c33904d = new C33904d();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c33904d.populateBuilderWithField(c6086a3, c33904d, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c42908k.kKy = c33904d;
                    }
                    AppMethodBeat.m2505o(35520);
                    return 0;
                case 3:
                    c42908k.kdT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(35520);
                    return 0;
                case 4:
                    c42908k.kKC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(35520);
                    return 0;
                case 5:
                    c42908k.kKD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35520);
                    return 0;
                default:
                    AppMethodBeat.m2505o(35520);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(35520);
            return -1;
        }
    }
}
