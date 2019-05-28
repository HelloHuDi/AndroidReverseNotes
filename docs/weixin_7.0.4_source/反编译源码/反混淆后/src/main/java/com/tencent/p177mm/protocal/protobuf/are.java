package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.are */
public final class are extends btd {
    public String cEh;
    public int jsN;
    public cwg vXT;
    public String wuS;
    public String wuU;
    public int wuV;
    public LinkedList<bdt> wuW = new LinkedList();
    public int wuX;
    public String wuY;
    public String wuZ;
    public int wva;
    public String wvb;
    public String wvc;
    public String wvd;
    public int wve;
    public int wvf;
    public bdt wvg;

    public are() {
        AppMethodBeat.m2504i(96238);
        AppMethodBeat.m2505o(96238);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96239);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(96239);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.vXT != null) {
                c6093a.mo13479iy(2, this.vXT.computeSize());
                this.vXT.writeFields(c6093a);
            }
            if (this.wuU != null) {
                c6093a.mo13475e(3, this.wuU);
            }
            c6093a.mo13480iz(4, this.wuV);
            c6093a.mo13480iz(5, this.jsN);
            if (this.wuS != null) {
                c6093a.mo13475e(6, this.wuS);
            }
            c6093a.mo13474e(7, 8, this.wuW);
            c6093a.mo13480iz(8, this.wuX);
            if (this.wuY != null) {
                c6093a.mo13475e(9, this.wuY);
            }
            if (this.wuZ != null) {
                c6093a.mo13475e(10, this.wuZ);
            }
            c6093a.mo13480iz(11, this.wva);
            if (this.cEh != null) {
                c6093a.mo13475e(12, this.cEh);
            }
            if (this.wvb != null) {
                c6093a.mo13475e(13, this.wvb);
            }
            if (this.wvc != null) {
                c6093a.mo13475e(14, this.wvc);
            }
            if (this.wvd != null) {
                c6093a.mo13475e(15, this.wvd);
            }
            c6093a.mo13480iz(16, this.wve);
            c6093a.mo13480iz(17, this.wvf);
            if (this.wvg != null) {
                c6093a.mo13479iy(18, this.wvg.computeSize());
                this.wvg.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(96239);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vXT != null) {
                ix += C6087a.m9557ix(2, this.vXT.computeSize());
            }
            if (this.wuU != null) {
                ix += C6091a.m9575f(3, this.wuU);
            }
            ix = (ix + C6091a.m9572bs(4, this.wuV)) + C6091a.m9572bs(5, this.jsN);
            if (this.wuS != null) {
                ix += C6091a.m9575f(6, this.wuS);
            }
            ix = (ix + C6087a.m9552c(7, 8, this.wuW)) + C6091a.m9572bs(8, this.wuX);
            if (this.wuY != null) {
                ix += C6091a.m9575f(9, this.wuY);
            }
            if (this.wuZ != null) {
                ix += C6091a.m9575f(10, this.wuZ);
            }
            ix += C6091a.m9572bs(11, this.wva);
            if (this.cEh != null) {
                ix += C6091a.m9575f(12, this.cEh);
            }
            if (this.wvb != null) {
                ix += C6091a.m9575f(13, this.wvb);
            }
            if (this.wvc != null) {
                ix += C6091a.m9575f(14, this.wvc);
            }
            if (this.wvd != null) {
                ix += C6091a.m9575f(15, this.wvd);
            }
            ix = (ix + C6091a.m9572bs(16, this.wve)) + C6091a.m9572bs(17, this.wvf);
            if (this.wvg != null) {
                ix += C6087a.m9557ix(18, this.wvg.computeSize());
            }
            AppMethodBeat.m2505o(96239);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wuW.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(96239);
                throw c6092b;
            }
            AppMethodBeat.m2505o(96239);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            are are = (are) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            bdt bdt;
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
                        are.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(96239);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cwg cwg = new cwg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cwg.populateBuilderWithField(c6086a3, cwg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        are.vXT = cwg;
                    }
                    AppMethodBeat.m2505o(96239);
                    return 0;
                case 3:
                    are.wuU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96239);
                    return 0;
                case 4:
                    are.wuV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96239);
                    return 0;
                case 5:
                    are.jsN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96239);
                    return 0;
                case 6:
                    are.wuS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96239);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdt = new bdt();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdt.populateBuilderWithField(c6086a3, bdt, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        are.wuW.add(bdt);
                    }
                    AppMethodBeat.m2505o(96239);
                    return 0;
                case 8:
                    are.wuX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96239);
                    return 0;
                case 9:
                    are.wuY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96239);
                    return 0;
                case 10:
                    are.wuZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96239);
                    return 0;
                case 11:
                    are.wva = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96239);
                    return 0;
                case 12:
                    are.cEh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96239);
                    return 0;
                case 13:
                    are.wvb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96239);
                    return 0;
                case 14:
                    are.wvc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96239);
                    return 0;
                case 15:
                    are.wvd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96239);
                    return 0;
                case 16:
                    are.wve = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96239);
                    return 0;
                case 17:
                    are.wvf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96239);
                    return 0;
                case 18:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdt = new bdt();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdt.populateBuilderWithField(c6086a3, bdt, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        are.wvg = bdt;
                    }
                    AppMethodBeat.m2505o(96239);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96239);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96239);
            return -1;
        }
    }
}
