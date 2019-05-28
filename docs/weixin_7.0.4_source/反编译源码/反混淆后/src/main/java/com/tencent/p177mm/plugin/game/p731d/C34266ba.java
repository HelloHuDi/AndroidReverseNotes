package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.protocal.protobuf.BaseResponse;
import com.tencent.p177mm.protocal.protobuf.btd;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.ba */
public final class C34266ba extends btd {
    public C45998e mZk;
    public String nbJ;
    public LinkedList<C43174v> nbK = new LinkedList();
    public C43164cf nbL;
    public C34269bv nbM;
    public C6935bs nbN;
    public C12119cv nbO;
    public LinkedList<C43175w> nbP = new LinkedList();
    public C34275da nbQ;
    public C39191bu nbR;
    public C6934br nbS;

    public C34266ba() {
        AppMethodBeat.m2504i(111595);
        AppMethodBeat.m2505o(111595);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111596);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(111596);
                throw c6092b;
            } else if (this.mZk == null) {
                c6092b = new C6092b("Not all required fields were included: AppItem");
                AppMethodBeat.m2505o(111596);
                throw c6092b;
            } else if (this.nbJ == null) {
                c6092b = new C6092b("Not all required fields were included: BackGroundURL");
                AppMethodBeat.m2505o(111596);
                throw c6092b;
            } else {
                if (this.BaseResponse != null) {
                    c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(c6093a);
                }
                if (this.mZk != null) {
                    c6093a.mo13479iy(2, this.mZk.computeSize());
                    this.mZk.writeFields(c6093a);
                }
                if (this.nbJ != null) {
                    c6093a.mo13475e(3, this.nbJ);
                }
                c6093a.mo13474e(4, 8, this.nbK);
                if (this.nbL != null) {
                    c6093a.mo13479iy(5, this.nbL.computeSize());
                    this.nbL.writeFields(c6093a);
                }
                if (this.nbM != null) {
                    c6093a.mo13479iy(7, this.nbM.computeSize());
                    this.nbM.writeFields(c6093a);
                }
                if (this.nbN != null) {
                    c6093a.mo13479iy(8, this.nbN.computeSize());
                    this.nbN.writeFields(c6093a);
                }
                if (this.nbO != null) {
                    c6093a.mo13479iy(9, this.nbO.computeSize());
                    this.nbO.writeFields(c6093a);
                }
                c6093a.mo13474e(10, 8, this.nbP);
                if (this.nbQ != null) {
                    c6093a.mo13479iy(11, this.nbQ.computeSize());
                    this.nbQ.writeFields(c6093a);
                }
                if (this.nbR != null) {
                    c6093a.mo13479iy(12, this.nbR.computeSize());
                    this.nbR.writeFields(c6093a);
                }
                if (this.nbS != null) {
                    c6093a.mo13479iy(13, this.nbS.computeSize());
                    this.nbS.writeFields(c6093a);
                }
                AppMethodBeat.m2505o(111596);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.mZk != null) {
                ix += C6087a.m9557ix(2, this.mZk.computeSize());
            }
            if (this.nbJ != null) {
                ix += C6091a.m9575f(3, this.nbJ);
            }
            ix += C6087a.m9552c(4, 8, this.nbK);
            if (this.nbL != null) {
                ix += C6087a.m9557ix(5, this.nbL.computeSize());
            }
            if (this.nbM != null) {
                ix += C6087a.m9557ix(7, this.nbM.computeSize());
            }
            if (this.nbN != null) {
                ix += C6087a.m9557ix(8, this.nbN.computeSize());
            }
            if (this.nbO != null) {
                ix += C6087a.m9557ix(9, this.nbO.computeSize());
            }
            ix += C6087a.m9552c(10, 8, this.nbP);
            if (this.nbQ != null) {
                ix += C6087a.m9557ix(11, this.nbQ.computeSize());
            }
            if (this.nbR != null) {
                ix += C6087a.m9557ix(12, this.nbR.computeSize());
            }
            if (this.nbS != null) {
                ix += C6087a.m9557ix(13, this.nbS.computeSize());
            }
            AppMethodBeat.m2505o(111596);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nbK.clear();
            this.nbP.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(111596);
                throw c6092b;
            } else if (this.mZk == null) {
                c6092b = new C6092b("Not all required fields were included: AppItem");
                AppMethodBeat.m2505o(111596);
                throw c6092b;
            } else if (this.nbJ == null) {
                c6092b = new C6092b("Not all required fields were included: BackGroundURL");
                AppMethodBeat.m2505o(111596);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(111596);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C34266ba c34266ba = (C34266ba) objArr[1];
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
                        c34266ba.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(111596);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C45998e c45998e = new C45998e();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c45998e.populateBuilderWithField(c6086a3, c45998e, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c34266ba.mZk = c45998e;
                    }
                    AppMethodBeat.m2505o(111596);
                    return 0;
                case 3:
                    c34266ba.nbJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111596);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C43174v c43174v = new C43174v();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c43174v.populateBuilderWithField(c6086a3, c43174v, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c34266ba.nbK.add(c43174v);
                    }
                    AppMethodBeat.m2505o(111596);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C43164cf c43164cf = new C43164cf();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c43164cf.populateBuilderWithField(c6086a3, c43164cf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c34266ba.nbL = c43164cf;
                    }
                    AppMethodBeat.m2505o(111596);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C34269bv c34269bv = new C34269bv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c34269bv.populateBuilderWithField(c6086a3, c34269bv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c34266ba.nbM = c34269bv;
                    }
                    AppMethodBeat.m2505o(111596);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C6935bs c6935bs = new C6935bs();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c6935bs.populateBuilderWithField(c6086a3, c6935bs, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c34266ba.nbN = c6935bs;
                    }
                    AppMethodBeat.m2505o(111596);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C12119cv c12119cv = new C12119cv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c12119cv.populateBuilderWithField(c6086a3, c12119cv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c34266ba.nbO = c12119cv;
                    }
                    AppMethodBeat.m2505o(111596);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C43175w c43175w = new C43175w();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c43175w.populateBuilderWithField(c6086a3, c43175w, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c34266ba.nbP.add(c43175w);
                    }
                    AppMethodBeat.m2505o(111596);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C34275da c34275da = new C34275da();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c34275da.populateBuilderWithField(c6086a3, c34275da, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c34266ba.nbQ = c34275da;
                    }
                    AppMethodBeat.m2505o(111596);
                    return 0;
                case 12:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C39191bu c39191bu = new C39191bu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c39191bu.populateBuilderWithField(c6086a3, c39191bu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c34266ba.nbR = c39191bu;
                    }
                    AppMethodBeat.m2505o(111596);
                    return 0;
                case 13:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C6934br c6934br = new C6934br();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c6934br.populateBuilderWithField(c6086a3, c6934br, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c34266ba.nbS = c6934br;
                    }
                    AppMethodBeat.m2505o(111596);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111596);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111596);
            return -1;
        }
    }
}
