package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ajc */
public final class ajc extends btd {
    public int OpCode;
    public String woW;
    public C40545mk woX;
    public long woY;
    public C7254cm woZ;
    public int wpa;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(59564);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(59564);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.OpCode);
            c6093a.mo13472ai(3, this.woY);
            if (this.woZ != null) {
                c6093a.mo13479iy(4, this.woZ.computeSize());
                this.woZ.writeFields(c6093a);
            }
            if (this.woW != null) {
                c6093a.mo13475e(5, this.woW);
            }
            c6093a.mo13480iz(6, this.wpa);
            if (this.woX != null) {
                c6093a.mo13479iy(7, this.woX.computeSize());
                this.woX.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(59564);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6091a.m9572bs(2, this.OpCode)) + C6091a.m9578o(3, this.woY);
            if (this.woZ != null) {
                ix += C6087a.m9557ix(4, this.woZ.computeSize());
            }
            if (this.woW != null) {
                ix += C6091a.m9575f(5, this.woW);
            }
            ix += C6091a.m9572bs(6, this.wpa);
            if (this.woX != null) {
                ix += C6087a.m9557ix(7, this.woX.computeSize());
            }
            AppMethodBeat.m2505o(59564);
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
                AppMethodBeat.m2505o(59564);
                throw c6092b;
            }
            AppMethodBeat.m2505o(59564);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ajc ajc = (ajc) objArr[1];
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
                        ajc.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(59564);
                    return 0;
                case 2:
                    ajc.OpCode = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(59564);
                    return 0;
                case 3:
                    ajc.woY = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(59564);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7254cm c7254cm = new C7254cm();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7254cm.populateBuilderWithField(c6086a3, c7254cm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ajc.woZ = c7254cm;
                    }
                    AppMethodBeat.m2505o(59564);
                    return 0;
                case 5:
                    ajc.woW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(59564);
                    return 0;
                case 6:
                    ajc.wpa = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(59564);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C40545mk c40545mk = new C40545mk();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c40545mk.populateBuilderWithField(c6086a3, c40545mk, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ajc.woX = c40545mk;
                    }
                    AppMethodBeat.m2505o(59564);
                    return 0;
                default:
                    AppMethodBeat.m2505o(59564);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(59564);
            return -1;
        }
    }
}
