package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aqg */
public final class aqg extends btd {
    public ato vLK;
    public C7270lm vLL;
    public bdu vLM;
    public String wuf;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28494);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28494);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.wuf != null) {
                c6093a.mo13475e(2, this.wuf);
            }
            if (this.vLL != null) {
                c6093a.mo13479iy(3, this.vLL.computeSize());
                this.vLL.writeFields(c6093a);
            }
            if (this.vLK != null) {
                c6093a.mo13479iy(4, this.vLK.computeSize());
                this.vLK.writeFields(c6093a);
            }
            if (this.vLM != null) {
                c6093a.mo13479iy(5, this.vLM.computeSize());
                this.vLM.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(28494);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wuf != null) {
                ix += C6091a.m9575f(2, this.wuf);
            }
            if (this.vLL != null) {
                ix += C6087a.m9557ix(3, this.vLL.computeSize());
            }
            if (this.vLK != null) {
                ix += C6087a.m9557ix(4, this.vLK.computeSize());
            }
            if (this.vLM != null) {
                ix += C6087a.m9557ix(5, this.vLM.computeSize());
            }
            AppMethodBeat.m2505o(28494);
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
                AppMethodBeat.m2505o(28494);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28494);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aqg aqg = (aqg) objArr[1];
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
                        aqg.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(28494);
                    return 0;
                case 2:
                    aqg.wuf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28494);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7270lm c7270lm = new C7270lm();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7270lm.populateBuilderWithField(c6086a3, c7270lm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aqg.vLL = c7270lm;
                    }
                    AppMethodBeat.m2505o(28494);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ato ato = new ato();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ato.populateBuilderWithField(c6086a3, ato, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aqg.vLK = ato;
                    }
                    AppMethodBeat.m2505o(28494);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdu bdu = new bdu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdu.populateBuilderWithField(c6086a3, bdu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aqg.vLM = bdu;
                    }
                    AppMethodBeat.m2505o(28494);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28494);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28494);
            return -1;
        }
    }
}
