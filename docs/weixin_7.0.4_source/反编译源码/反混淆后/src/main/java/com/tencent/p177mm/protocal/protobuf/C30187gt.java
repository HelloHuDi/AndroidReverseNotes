package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.gt */
public final class C30187gt extends C1331a implements bzw {
    /* renamed from: ID */
    public String f13734ID;
    public int Ret;
    public String vIS;
    public SKBuiltinBuffer_t vIT;
    public String vIU;
    public int vIV;
    public String vIW;
    public String vIX;
    public SKBuiltinBuffer_t vIn;

    public final int getRet() {
        return this.Ret;
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28332);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vIT == null) {
                c6092b = new C6092b("Not all required fields were included: QRCodeBuffer");
                AppMethodBeat.m2505o(28332);
                throw c6092b;
            } else if (this.vIn == null) {
                c6092b = new C6092b("Not all required fields were included: Key");
                AppMethodBeat.m2505o(28332);
                throw c6092b;
            } else {
                c6093a.mo13480iz(1, this.Ret);
                if (this.vIT != null) {
                    c6093a.mo13479iy(2, this.vIT.computeSize());
                    this.vIT.writeFields(c6093a);
                }
                if (this.vIU != null) {
                    c6093a.mo13475e(3, this.vIU);
                }
                if (this.vIn != null) {
                    c6093a.mo13479iy(4, this.vIn.computeSize());
                    this.vIn.writeFields(c6093a);
                }
                if (this.vIW != null) {
                    c6093a.mo13475e(5, this.vIW);
                }
                if (this.vIX != null) {
                    c6093a.mo13475e(6, this.vIX);
                }
                c6093a.mo13480iz(7, this.vIV);
                if (this.f13734ID != null) {
                    c6093a.mo13475e(8, this.f13734ID);
                }
                if (this.vIS != null) {
                    c6093a.mo13475e(9, this.vIS);
                }
                AppMethodBeat.m2505o(28332);
                return 0;
            }
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.Ret) + 0;
            if (this.vIT != null) {
                bs += C6087a.m9557ix(2, this.vIT.computeSize());
            }
            if (this.vIU != null) {
                bs += C6091a.m9575f(3, this.vIU);
            }
            if (this.vIn != null) {
                bs += C6087a.m9557ix(4, this.vIn.computeSize());
            }
            if (this.vIW != null) {
                bs += C6091a.m9575f(5, this.vIW);
            }
            if (this.vIX != null) {
                bs += C6091a.m9575f(6, this.vIX);
            }
            bs += C6091a.m9572bs(7, this.vIV);
            if (this.f13734ID != null) {
                bs += C6091a.m9575f(8, this.f13734ID);
            }
            if (this.vIS != null) {
                bs += C6091a.m9575f(9, this.vIS);
            }
            AppMethodBeat.m2505o(28332);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.vIT == null) {
                c6092b = new C6092b("Not all required fields were included: QRCodeBuffer");
                AppMethodBeat.m2505o(28332);
                throw c6092b;
            } else if (this.vIn == null) {
                c6092b = new C6092b("Not all required fields were included: Key");
                AppMethodBeat.m2505o(28332);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(28332);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C30187gt c30187gt = (C30187gt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c30187gt.Ret = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28332);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30187gt.vIT = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(28332);
                    return 0;
                case 3:
                    c30187gt.vIU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28332);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30187gt.vIn = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(28332);
                    return 0;
                case 5:
                    c30187gt.vIW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28332);
                    return 0;
                case 6:
                    c30187gt.vIX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28332);
                    return 0;
                case 7:
                    c30187gt.vIV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28332);
                    return 0;
                case 8:
                    c30187gt.f13734ID = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28332);
                    return 0;
                case 9:
                    c30187gt.vIS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28332);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28332);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28332);
            return -1;
        }
    }
}
