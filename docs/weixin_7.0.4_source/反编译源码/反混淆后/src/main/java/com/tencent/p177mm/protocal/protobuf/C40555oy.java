package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.oy */
public final class C40555oy extends btd {
    public int kCl;
    public int pPV;
    public String pPW;
    public String pPX;
    public String twd;
    public String url;
    public LinkedList<bbc> vVY = new LinkedList();
    public bbc vVZ;
    public String vWa;
    public boolean vWb;
    public String vWc;
    public int vWd;
    public bbj vWe;
    public bpt vWf;

    public C40555oy() {
        AppMethodBeat.m2504i(56752);
        AppMethodBeat.m2505o(56752);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56753);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56753);
                throw c6092b;
            }
            if (this.BaseResponse != null) {
                c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(c6093a);
            }
            if (this.url != null) {
                c6093a.mo13475e(2, this.url);
            }
            c6093a.mo13474e(3, 8, this.vVY);
            if (this.vVZ != null) {
                c6093a.mo13479iy(4, this.vVZ.computeSize());
                this.vVZ.writeFields(c6093a);
            }
            if (this.twd != null) {
                c6093a.mo13475e(5, this.twd);
            }
            if (this.vWa != null) {
                c6093a.mo13475e(6, this.vWa);
            }
            c6093a.mo13471aO(7, this.vWb);
            c6093a.mo13480iz(8, this.pPV);
            if (this.vWc != null) {
                c6093a.mo13475e(9, this.vWc);
            }
            if (this.pPW != null) {
                c6093a.mo13475e(10, this.pPW);
            }
            if (this.pPX != null) {
                c6093a.mo13475e(11, this.pPX);
            }
            c6093a.mo13480iz(12, this.vWd);
            if (this.vWe != null) {
                c6093a.mo13479iy(13, this.vWe.computeSize());
                this.vWe.writeFields(c6093a);
            }
            if (this.vWf != null) {
                c6093a.mo13479iy(14, this.vWf.computeSize());
                this.vWf.writeFields(c6093a);
            }
            c6093a.mo13480iz(15, this.kCl);
            AppMethodBeat.m2505o(56753);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.url != null) {
                ix += C6091a.m9575f(2, this.url);
            }
            ix += C6087a.m9552c(3, 8, this.vVY);
            if (this.vVZ != null) {
                ix += C6087a.m9557ix(4, this.vVZ.computeSize());
            }
            if (this.twd != null) {
                ix += C6091a.m9575f(5, this.twd);
            }
            if (this.vWa != null) {
                ix += C6091a.m9575f(6, this.vWa);
            }
            ix = (ix + (C6091a.m9576fv(7) + 1)) + C6091a.m9572bs(8, this.pPV);
            if (this.vWc != null) {
                ix += C6091a.m9575f(9, this.vWc);
            }
            if (this.pPW != null) {
                ix += C6091a.m9575f(10, this.pPW);
            }
            if (this.pPX != null) {
                ix += C6091a.m9575f(11, this.pPX);
            }
            ix += C6091a.m9572bs(12, this.vWd);
            if (this.vWe != null) {
                ix += C6087a.m9557ix(13, this.vWe.computeSize());
            }
            if (this.vWf != null) {
                ix += C6087a.m9557ix(14, this.vWf.computeSize());
            }
            int bs = ix + C6091a.m9572bs(15, this.kCl);
            AppMethodBeat.m2505o(56753);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vVY.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(56753);
                throw c6092b;
            }
            AppMethodBeat.m2505o(56753);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40555oy c40555oy = (C40555oy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            bbc bbc;
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
                        c40555oy.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(56753);
                    return 0;
                case 2:
                    c40555oy.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56753);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bbc = new bbc();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbc.populateBuilderWithField(c6086a3, bbc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40555oy.vVY.add(bbc);
                    }
                    AppMethodBeat.m2505o(56753);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bbc = new bbc();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbc.populateBuilderWithField(c6086a3, bbc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40555oy.vVZ = bbc;
                    }
                    AppMethodBeat.m2505o(56753);
                    return 0;
                case 5:
                    c40555oy.twd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56753);
                    return 0;
                case 6:
                    c40555oy.vWa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56753);
                    return 0;
                case 7:
                    c40555oy.vWb = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(56753);
                    return 0;
                case 8:
                    c40555oy.pPV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56753);
                    return 0;
                case 9:
                    c40555oy.vWc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56753);
                    return 0;
                case 10:
                    c40555oy.pPW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56753);
                    return 0;
                case 11:
                    c40555oy.pPX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56753);
                    return 0;
                case 12:
                    c40555oy.vWd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56753);
                    return 0;
                case 13:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bbj bbj = new bbj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbj.populateBuilderWithField(c6086a3, bbj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40555oy.vWe = bbj;
                    }
                    AppMethodBeat.m2505o(56753);
                    return 0;
                case 14:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bpt bpt = new bpt();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpt.populateBuilderWithField(c6086a3, bpt, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40555oy.vWf = bpt;
                    }
                    AppMethodBeat.m2505o(56753);
                    return 0;
                case 15:
                    c40555oy.kCl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56753);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56753);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56753);
            return -1;
        }
    }
}
