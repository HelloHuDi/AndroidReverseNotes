package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cas */
public final class cas extends btd {
    public String vEA;
    public LinkedList<cbf> vKB = new LinkedList();
    public int wGG;
    public String wZT;
    public int wZX;
    public int wZY;
    public cbw wZZ;

    public cas() {
        AppMethodBeat.m2504i(94568);
        AppMethodBeat.m2505o(94568);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94569);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(94569);
                throw c6092b;
            } else if (this.wZZ == null) {
                c6092b = new C6092b("Not all required fields were included: ServerConfig");
                AppMethodBeat.m2505o(94569);
                throw c6092b;
            } else {
                if (this.BaseResponse != null) {
                    c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(c6093a);
                }
                if (this.wZT != null) {
                    c6093a.mo13475e(2, this.wZT);
                }
                c6093a.mo13480iz(3, this.wGG);
                c6093a.mo13474e(4, 8, this.vKB);
                c6093a.mo13480iz(5, this.wZX);
                if (this.vEA != null) {
                    c6093a.mo13475e(6, this.vEA);
                }
                c6093a.mo13480iz(7, this.wZY);
                if (this.wZZ != null) {
                    c6093a.mo13479iy(8, this.wZZ.computeSize());
                    this.wZZ.writeFields(c6093a);
                }
                AppMethodBeat.m2505o(94569);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wZT != null) {
                ix += C6091a.m9575f(2, this.wZT);
            }
            ix = ((ix + C6091a.m9572bs(3, this.wGG)) + C6087a.m9552c(4, 8, this.vKB)) + C6091a.m9572bs(5, this.wZX);
            if (this.vEA != null) {
                ix += C6091a.m9575f(6, this.vEA);
            }
            ix += C6091a.m9572bs(7, this.wZY);
            if (this.wZZ != null) {
                ix += C6087a.m9557ix(8, this.wZZ.computeSize());
            }
            AppMethodBeat.m2505o(94569);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vKB.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(94569);
                throw c6092b;
            } else if (this.wZZ == null) {
                c6092b = new C6092b("Not all required fields were included: ServerConfig");
                AppMethodBeat.m2505o(94569);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(94569);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cas cas = (cas) objArr[1];
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
                        cas.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(94569);
                    return 0;
                case 2:
                    cas.wZT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94569);
                    return 0;
                case 3:
                    cas.wGG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94569);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbf cbf = new cbf();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbf.populateBuilderWithField(c6086a3, cbf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cas.vKB.add(cbf);
                    }
                    AppMethodBeat.m2505o(94569);
                    return 0;
                case 5:
                    cas.wZX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94569);
                    return 0;
                case 6:
                    cas.vEA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94569);
                    return 0;
                case 7:
                    cas.wZY = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94569);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbw cbw = new cbw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbw.populateBuilderWithField(c6086a3, cbw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cas.wZZ = cbw;
                    }
                    AppMethodBeat.m2505o(94569);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94569);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94569);
            return -1;
        }
    }
}
