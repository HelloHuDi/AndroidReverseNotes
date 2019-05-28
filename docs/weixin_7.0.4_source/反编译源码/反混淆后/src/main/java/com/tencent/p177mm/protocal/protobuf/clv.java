package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.clv */
public final class clv extends bsr {
    public int Scene;
    public String ndF;
    public String ndG;
    public SKBuiltinBuffer_t ptz;
    public clu vZA;
    public String vZx;
    public coa vZy;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28690);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vZy == null) {
                c6092b = new C6092b("Not all required fields were included: VoiceAttr");
                AppMethodBeat.m2505o(28690);
                throw c6092b;
            } else if (this.vZA == null) {
                c6092b = new C6092b("Not all required fields were included: UploadCtx");
                AppMethodBeat.m2505o(28690);
                throw c6092b;
            } else if (this.ptz == null) {
                c6092b = new C6092b("Not all required fields were included: Data");
                AppMethodBeat.m2505o(28690);
                throw c6092b;
            } else {
                if (this.BaseRequest != null) {
                    c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(c6093a);
                }
                if (this.vZx != null) {
                    c6093a.mo13475e(2, this.vZx);
                }
                if (this.vZy != null) {
                    c6093a.mo13479iy(3, this.vZy.computeSize());
                    this.vZy.writeFields(c6093a);
                }
                if (this.vZA != null) {
                    c6093a.mo13479iy(4, this.vZA.computeSize());
                    this.vZA.writeFields(c6093a);
                }
                if (this.ptz != null) {
                    c6093a.mo13479iy(5, this.ptz.computeSize());
                    this.ptz.writeFields(c6093a);
                }
                c6093a.mo13480iz(6, this.Scene);
                if (this.ndG != null) {
                    c6093a.mo13475e(7, this.ndG);
                }
                if (this.ndF != null) {
                    c6093a.mo13475e(8, this.ndF);
                }
                AppMethodBeat.m2505o(28690);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vZx != null) {
                ix += C6091a.m9575f(2, this.vZx);
            }
            if (this.vZy != null) {
                ix += C6087a.m9557ix(3, this.vZy.computeSize());
            }
            if (this.vZA != null) {
                ix += C6087a.m9557ix(4, this.vZA.computeSize());
            }
            if (this.ptz != null) {
                ix += C6087a.m9557ix(5, this.ptz.computeSize());
            }
            ix += C6091a.m9572bs(6, this.Scene);
            if (this.ndG != null) {
                ix += C6091a.m9575f(7, this.ndG);
            }
            if (this.ndF != null) {
                ix += C6091a.m9575f(8, this.ndF);
            }
            AppMethodBeat.m2505o(28690);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.vZy == null) {
                c6092b = new C6092b("Not all required fields were included: VoiceAttr");
                AppMethodBeat.m2505o(28690);
                throw c6092b;
            } else if (this.vZA == null) {
                c6092b = new C6092b("Not all required fields were included: UploadCtx");
                AppMethodBeat.m2505o(28690);
                throw c6092b;
            } else if (this.ptz == null) {
                c6092b = new C6092b("Not all required fields were included: Data");
                AppMethodBeat.m2505o(28690);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(28690);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            clv clv = (clv) objArr[1];
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
                        C7267hl c7267hl = new C7267hl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        clv.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(28690);
                    return 0;
                case 2:
                    clv.vZx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28690);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        coa coa = new coa();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = coa.populateBuilderWithField(c6086a3, coa, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        clv.vZy = coa;
                    }
                    AppMethodBeat.m2505o(28690);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        clu clu = new clu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = clu.populateBuilderWithField(c6086a3, clu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        clv.vZA = clu;
                    }
                    AppMethodBeat.m2505o(28690);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        clv.ptz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(28690);
                    return 0;
                case 6:
                    clv.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28690);
                    return 0;
                case 7:
                    clv.ndG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28690);
                    return 0;
                case 8:
                    clv.ndF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28690);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28690);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28690);
            return -1;
        }
    }
}
