package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.awd */
public final class awd extends btd {
    public C1332b jBi;
    public String ncH;
    public String vDm;
    public avi wzH;
    public String wzJ;
    public String wzK;
    public String wzL;
    public buj wzS;
    public C15390va wzT;
    public boolean wzU;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96267);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(96267);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.wzH != null) {
                c6093a.mo13479iy(2, this.wzH.computeSize());
                this.wzH.writeFields(c6093a);
            }
            if (this.jBi != null) {
                c6093a.mo13473c(3, this.jBi);
            }
            if (this.wzS != null) {
                c6093a.mo13479iy(4, this.wzS.computeSize());
                this.wzS.writeFields(c6093a);
            }
            if (this.ncH != null) {
                c6093a.mo13475e(5, this.ncH);
            }
            if (this.vDm != null) {
                c6093a.mo13475e(6, this.vDm);
            }
            if (this.wzT != null) {
                c6093a.mo13479iy(7, this.wzT.computeSize());
                this.wzT.writeFields(c6093a);
            }
            c6093a.mo13471aO(8, this.wzU);
            if (this.wzJ != null) {
                c6093a.mo13475e(9, this.wzJ);
            }
            if (this.wzK != null) {
                c6093a.mo13475e(10, this.wzK);
            }
            if (this.wzL != null) {
                c6093a.mo13475e(11, this.wzL);
            }
            AppMethodBeat.m2505o(96267);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wzH != null) {
                ix += C6087a.m9557ix(2, this.wzH.computeSize());
            }
            if (this.jBi != null) {
                ix += C6091a.m9571b(3, this.jBi);
            }
            if (this.wzS != null) {
                ix += C6087a.m9557ix(4, this.wzS.computeSize());
            }
            if (this.ncH != null) {
                ix += C6091a.m9575f(5, this.ncH);
            }
            if (this.vDm != null) {
                ix += C6091a.m9575f(6, this.vDm);
            }
            if (this.wzT != null) {
                ix += C6087a.m9557ix(7, this.wzT.computeSize());
            }
            ix += C6091a.m9576fv(8) + 1;
            if (this.wzJ != null) {
                ix += C6091a.m9575f(9, this.wzJ);
            }
            if (this.wzK != null) {
                ix += C6091a.m9575f(10, this.wzK);
            }
            if (this.wzL != null) {
                ix += C6091a.m9575f(11, this.wzL);
            }
            AppMethodBeat.m2505o(96267);
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
                AppMethodBeat.m2505o(96267);
                throw c6092b;
            }
            AppMethodBeat.m2505o(96267);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            awd awd = (awd) objArr[1];
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
                        awd.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(96267);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        avi avi = new avi();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = avi.populateBuilderWithField(c6086a3, avi, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        awd.wzH = avi;
                    }
                    AppMethodBeat.m2505o(96267);
                    return 0;
                case 3:
                    awd.jBi = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(96267);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        buj buj = new buj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = buj.populateBuilderWithField(c6086a3, buj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        awd.wzS = buj;
                    }
                    AppMethodBeat.m2505o(96267);
                    return 0;
                case 5:
                    awd.ncH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96267);
                    return 0;
                case 6:
                    awd.vDm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96267);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15390va c15390va = new C15390va();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15390va.populateBuilderWithField(c6086a3, c15390va, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        awd.wzT = c15390va;
                    }
                    AppMethodBeat.m2505o(96267);
                    return 0;
                case 8:
                    awd.wzU = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(96267);
                    return 0;
                case 9:
                    awd.wzJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96267);
                    return 0;
                case 10:
                    awd.wzK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96267);
                    return 0;
                case 11:
                    awd.wzL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96267);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96267);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96267);
            return -1;
        }
    }
}
