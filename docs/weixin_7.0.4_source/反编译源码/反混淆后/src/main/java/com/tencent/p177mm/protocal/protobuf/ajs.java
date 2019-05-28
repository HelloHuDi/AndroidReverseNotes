package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ajs */
public final class ajs extends btd {
    public int kdT;
    public String kdU;
    public ask vYe;
    public bab woj;
    public C30204mu wpq;
    public asi wpr;
    public atk wps;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48855);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(48855);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.kdT);
            if (this.kdU != null) {
                c6093a.mo13475e(3, this.kdU);
            }
            if (this.vYe != null) {
                c6093a.mo13479iy(4, this.vYe.computeSize());
                this.vYe.writeFields(c6093a);
            }
            if (this.wpq != null) {
                c6093a.mo13479iy(8, this.wpq.computeSize());
                this.wpq.writeFields(c6093a);
            }
            if (this.woj != null) {
                c6093a.mo13479iy(9, this.woj.computeSize());
                this.woj.writeFields(c6093a);
            }
            if (this.wpr != null) {
                c6093a.mo13479iy(10, this.wpr.computeSize());
                this.wpr.writeFields(c6093a);
            }
            if (this.wps != null) {
                c6093a.mo13479iy(11, this.wps.computeSize());
                this.wps.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(48855);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.kdT);
            if (this.kdU != null) {
                ix += C6091a.m9575f(3, this.kdU);
            }
            if (this.vYe != null) {
                ix += C6087a.m9557ix(4, this.vYe.computeSize());
            }
            if (this.wpq != null) {
                ix += C6087a.m9557ix(8, this.wpq.computeSize());
            }
            if (this.woj != null) {
                ix += C6087a.m9557ix(9, this.woj.computeSize());
            }
            if (this.wpr != null) {
                ix += C6087a.m9557ix(10, this.wpr.computeSize());
            }
            if (this.wps != null) {
                ix += C6087a.m9557ix(11, this.wps.computeSize());
            }
            AppMethodBeat.m2505o(48855);
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
                AppMethodBeat.m2505o(48855);
                throw c6092b;
            }
            AppMethodBeat.m2505o(48855);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ajs ajs = (ajs) objArr[1];
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
                        ajs.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(48855);
                    return 0;
                case 2:
                    ajs.kdT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48855);
                    return 0;
                case 3:
                    ajs.kdU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48855);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ask ask = new ask();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ask.populateBuilderWithField(c6086a3, ask, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ajs.vYe = ask;
                    }
                    AppMethodBeat.m2505o(48855);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C30204mu c30204mu = new C30204mu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c30204mu.populateBuilderWithField(c6086a3, c30204mu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ajs.wpq = c30204mu;
                    }
                    AppMethodBeat.m2505o(48855);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bab bab = new bab();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bab.populateBuilderWithField(c6086a3, bab, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ajs.woj = bab;
                    }
                    AppMethodBeat.m2505o(48855);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        asi asi = new asi();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = asi.populateBuilderWithField(c6086a3, asi, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ajs.wpr = asi;
                    }
                    AppMethodBeat.m2505o(48855);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        atk atk = new atk();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = atk.populateBuilderWithField(c6086a3, atk, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ajs.wps = atk;
                    }
                    AppMethodBeat.m2505o(48855);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48855);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48855);
            return -1;
        }
    }
}
