package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.byl */
public final class byl extends btd {
    public String cMD;
    public String color;
    public String kbU;
    public String kbV;
    public String kbW;
    public String kbX;
    public int kbZ;
    public int kdC;
    public String kdg;
    public int qsn;
    public int qsq;
    public String qsr;
    public String qss;
    public String qst;
    public String qsu;
    public String qsv;
    public boolean qsw;
    public String title;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28641);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28641);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.kdC);
            if (this.kbU != null) {
                c6093a.mo13475e(3, this.kbU);
            }
            if (this.cMD != null) {
                c6093a.mo13475e(4, this.cMD);
            }
            if (this.title != null) {
                c6093a.mo13475e(5, this.title);
            }
            if (this.kbW != null) {
                c6093a.mo13475e(6, this.kbW);
            }
            if (this.kbX != null) {
                c6093a.mo13475e(7, this.kbX);
            }
            if (this.kdg != null) {
                c6093a.mo13475e(8, this.kdg);
            }
            if (this.kbV != null) {
                c6093a.mo13475e(9, this.kbV);
            }
            if (this.color != null) {
                c6093a.mo13475e(10, this.color);
            }
            c6093a.mo13480iz(11, this.qsn);
            c6093a.mo13480iz(12, this.qsq);
            if (this.qsr != null) {
                c6093a.mo13475e(13, this.qsr);
            }
            if (this.qss != null) {
                c6093a.mo13475e(14, this.qss);
            }
            if (this.qst != null) {
                c6093a.mo13475e(19, this.qst);
            }
            if (this.qsu != null) {
                c6093a.mo13475e(21, this.qsu);
            }
            c6093a.mo13480iz(22, this.kbZ);
            if (this.qsv != null) {
                c6093a.mo13475e(23, this.qsv);
            }
            c6093a.mo13471aO(24, this.qsw);
            AppMethodBeat.m2505o(28641);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.kdC);
            if (this.kbU != null) {
                ix += C6091a.m9575f(3, this.kbU);
            }
            if (this.cMD != null) {
                ix += C6091a.m9575f(4, this.cMD);
            }
            if (this.title != null) {
                ix += C6091a.m9575f(5, this.title);
            }
            if (this.kbW != null) {
                ix += C6091a.m9575f(6, this.kbW);
            }
            if (this.kbX != null) {
                ix += C6091a.m9575f(7, this.kbX);
            }
            if (this.kdg != null) {
                ix += C6091a.m9575f(8, this.kdg);
            }
            if (this.kbV != null) {
                ix += C6091a.m9575f(9, this.kbV);
            }
            if (this.color != null) {
                ix += C6091a.m9575f(10, this.color);
            }
            ix = (ix + C6091a.m9572bs(11, this.qsn)) + C6091a.m9572bs(12, this.qsq);
            if (this.qsr != null) {
                ix += C6091a.m9575f(13, this.qsr);
            }
            if (this.qss != null) {
                ix += C6091a.m9575f(14, this.qss);
            }
            if (this.qst != null) {
                ix += C6091a.m9575f(19, this.qst);
            }
            if (this.qsu != null) {
                ix += C6091a.m9575f(21, this.qsu);
            }
            ix += C6091a.m9572bs(22, this.kbZ);
            if (this.qsv != null) {
                ix += C6091a.m9575f(23, this.qsv);
            }
            int fv = ix + (C6091a.m9576fv(24) + 1);
            AppMethodBeat.m2505o(28641);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28641);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28641);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            byl byl = (byl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(c6086a3, baseResponse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        byl.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(28641);
                    return 0;
                case 2:
                    byl.kdC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28641);
                    return 0;
                case 3:
                    byl.kbU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28641);
                    return 0;
                case 4:
                    byl.cMD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28641);
                    return 0;
                case 5:
                    byl.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28641);
                    return 0;
                case 6:
                    byl.kbW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28641);
                    return 0;
                case 7:
                    byl.kbX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28641);
                    return 0;
                case 8:
                    byl.kdg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28641);
                    return 0;
                case 9:
                    byl.kbV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28641);
                    return 0;
                case 10:
                    byl.color = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28641);
                    return 0;
                case 11:
                    byl.qsn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28641);
                    return 0;
                case 12:
                    byl.qsq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28641);
                    return 0;
                case 13:
                    byl.qsr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28641);
                    return 0;
                case 14:
                    byl.qss = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28641);
                    return 0;
                case 19:
                    byl.qst = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28641);
                    return 0;
                case 21:
                    byl.qsu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28641);
                    return 0;
                case 22:
                    byl.kbZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28641);
                    return 0;
                case 23:
                    byl.qsv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28641);
                    return 0;
                case 24:
                    byl.qsw = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(28641);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28641);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28641);
            return -1;
        }
    }
}
