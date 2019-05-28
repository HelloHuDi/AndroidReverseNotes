package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aia */
public final class aia extends btd {
    public SKBuiltinBuffer_t wok;
    public LinkedList<C40588xx> woo = new LinkedList();
    public LinkedList<C7288xz> wop = new LinkedList();

    public aia() {
        AppMethodBeat.m2504i(62549);
        AppMethodBeat.m2505o(62549);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(62550);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(62550);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13474e(2, 8, this.woo);
            if (this.wok != null) {
                c6093a.mo13479iy(3, this.wok.computeSize());
                this.wok.writeFields(c6093a);
            }
            c6093a.mo13474e(4, 8, this.wop);
            AppMethodBeat.m2505o(62550);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6087a.m9552c(2, 8, this.woo);
            if (this.wok != null) {
                ix += C6087a.m9557ix(3, this.wok.computeSize());
            }
            int c = ix + C6087a.m9552c(4, 8, this.wop);
            AppMethodBeat.m2505o(62550);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.woo.clear();
            this.wop.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(62550);
                throw c6092b;
            }
            AppMethodBeat.m2505o(62550);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aia aia = (aia) objArr[1];
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
                        aia.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(62550);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C40588xx c40588xx = new C40588xx();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c40588xx.populateBuilderWithField(c6086a3, c40588xx, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aia.woo.add(c40588xx);
                    }
                    AppMethodBeat.m2505o(62550);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aia.wok = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(62550);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7288xz c7288xz = new C7288xz();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7288xz.populateBuilderWithField(c6086a3, c7288xz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aia.wop.add(c7288xz);
                    }
                    AppMethodBeat.m2505o(62550);
                    return 0;
                default:
                    AppMethodBeat.m2505o(62550);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(62550);
            return -1;
        }
    }
}
