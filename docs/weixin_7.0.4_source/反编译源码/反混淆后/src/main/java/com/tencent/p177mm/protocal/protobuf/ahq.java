package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ahq */
public final class ahq extends btd {
    /* renamed from: ID */
    public String f2976ID;
    public int Scene;
    public long jBP;
    public int jCt;
    public int vIN;
    public LinkedList<C7284ua> vIO = new LinkedList();
    public String vIP;
    public String vIQ;
    public String vIR;
    public int vIV;
    public String vIW;
    public String vIX;
    public SKBuiltinBuffer_t vIn;
    public String wnV;

    public ahq() {
        AppMethodBeat.m2504i(28423);
        AppMethodBeat.m2505o(28423);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28424);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28424);
                throw c6092b;
            } else if (this.vIn == null) {
                c6092b = new C6092b("Not all required fields were included: Key");
                AppMethodBeat.m2505o(28424);
                throw c6092b;
            } else {
                if (this.BaseResponse != null) {
                    c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(c6093a);
                }
                if (this.f2976ID != null) {
                    c6093a.mo13475e(2, this.f2976ID);
                }
                if (this.vIn != null) {
                    c6093a.mo13479iy(3, this.vIn.computeSize());
                    this.vIn.writeFields(c6093a);
                }
                if (this.vIW != null) {
                    c6093a.mo13475e(4, this.vIW);
                }
                if (this.vIX != null) {
                    c6093a.mo13475e(5, this.vIX);
                }
                c6093a.mo13480iz(6, this.jCt);
                c6093a.mo13480iz(7, this.vIN);
                c6093a.mo13474e(8, 8, this.vIO);
                if (this.wnV != null) {
                    c6093a.mo13475e(9, this.wnV);
                }
                if (this.vIP != null) {
                    c6093a.mo13475e(10, this.vIP);
                }
                if (this.vIQ != null) {
                    c6093a.mo13475e(11, this.vIQ);
                }
                c6093a.mo13480iz(12, this.vIV);
                c6093a.mo13480iz(13, this.Scene);
                c6093a.mo13472ai(14, this.jBP);
                if (this.vIR != null) {
                    c6093a.mo13475e(15, this.vIR);
                }
                AppMethodBeat.m2505o(28424);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.f2976ID != null) {
                ix += C6091a.m9575f(2, this.f2976ID);
            }
            if (this.vIn != null) {
                ix += C6087a.m9557ix(3, this.vIn.computeSize());
            }
            if (this.vIW != null) {
                ix += C6091a.m9575f(4, this.vIW);
            }
            if (this.vIX != null) {
                ix += C6091a.m9575f(5, this.vIX);
            }
            ix = ((ix + C6091a.m9572bs(6, this.jCt)) + C6091a.m9572bs(7, this.vIN)) + C6087a.m9552c(8, 8, this.vIO);
            if (this.wnV != null) {
                ix += C6091a.m9575f(9, this.wnV);
            }
            if (this.vIP != null) {
                ix += C6091a.m9575f(10, this.vIP);
            }
            if (this.vIQ != null) {
                ix += C6091a.m9575f(11, this.vIQ);
            }
            ix = ((ix + C6091a.m9572bs(12, this.vIV)) + C6091a.m9572bs(13, this.Scene)) + C6091a.m9578o(14, this.jBP);
            if (this.vIR != null) {
                ix += C6091a.m9575f(15, this.vIR);
            }
            AppMethodBeat.m2505o(28424);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vIO.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28424);
                throw c6092b;
            } else if (this.vIn == null) {
                c6092b = new C6092b("Not all required fields were included: Key");
                AppMethodBeat.m2505o(28424);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(28424);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ahq ahq = (ahq) objArr[1];
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
                        ahq.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(28424);
                    return 0;
                case 2:
                    ahq.f2976ID = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28424);
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
                        ahq.vIn = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(28424);
                    return 0;
                case 4:
                    ahq.vIW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28424);
                    return 0;
                case 5:
                    ahq.vIX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28424);
                    return 0;
                case 6:
                    ahq.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28424);
                    return 0;
                case 7:
                    ahq.vIN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28424);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7284ua c7284ua = new C7284ua();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7284ua.populateBuilderWithField(c6086a3, c7284ua, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ahq.vIO.add(c7284ua);
                    }
                    AppMethodBeat.m2505o(28424);
                    return 0;
                case 9:
                    ahq.wnV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28424);
                    return 0;
                case 10:
                    ahq.vIP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28424);
                    return 0;
                case 11:
                    ahq.vIQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28424);
                    return 0;
                case 12:
                    ahq.vIV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28424);
                    return 0;
                case 13:
                    ahq.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28424);
                    return 0;
                case 14:
                    ahq.jBP = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(28424);
                    return 0;
                case 15:
                    ahq.vIR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28424);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28424);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28424);
            return -1;
        }
    }
}
