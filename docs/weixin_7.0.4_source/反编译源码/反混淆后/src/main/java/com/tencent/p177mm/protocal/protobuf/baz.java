package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.baz */
public final class baz extends C1331a {
    public int guN;
    public String guO;
    public String guP;
    public String guQ;
    public int guR;
    public String guW;
    public int wBT;
    public String wBU;
    public int wFJ;
    public bts wFK;
    public bts wFL;
    public bts wFM;
    public int wbA;
    public bts wcG;
    public bts wce;
    public bts wcf;
    public bts wyX;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(5594);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wcG == null) {
                c6092b = new C6092b("Not all required fields were included: MemberName");
                AppMethodBeat.m2505o(5594);
                throw c6092b;
            } else if (this.wyX == null) {
                c6092b = new C6092b("Not all required fields were included: NickName");
                AppMethodBeat.m2505o(5594);
                throw c6092b;
            } else if (this.wce == null) {
                c6092b = new C6092b("Not all required fields were included: PYInitial");
                AppMethodBeat.m2505o(5594);
                throw c6092b;
            } else if (this.wcf == null) {
                c6092b = new C6092b("Not all required fields were included: QuanPin");
                AppMethodBeat.m2505o(5594);
                throw c6092b;
            } else if (this.wFK == null) {
                c6092b = new C6092b("Not all required fields were included: Remark");
                AppMethodBeat.m2505o(5594);
                throw c6092b;
            } else if (this.wFL == null) {
                c6092b = new C6092b("Not all required fields were included: RemarkPYInitial");
                AppMethodBeat.m2505o(5594);
                throw c6092b;
            } else if (this.wFM == null) {
                c6092b = new C6092b("Not all required fields were included: RemarkQuanPin");
                AppMethodBeat.m2505o(5594);
                throw c6092b;
            } else {
                if (this.wcG != null) {
                    c6093a.mo13479iy(1, this.wcG.computeSize());
                    this.wcG.writeFields(c6093a);
                }
                c6093a.mo13480iz(2, this.wFJ);
                if (this.wyX != null) {
                    c6093a.mo13479iy(3, this.wyX.computeSize());
                    this.wyX.writeFields(c6093a);
                }
                if (this.wce != null) {
                    c6093a.mo13479iy(4, this.wce.computeSize());
                    this.wce.writeFields(c6093a);
                }
                if (this.wcf != null) {
                    c6093a.mo13479iy(5, this.wcf.computeSize());
                    this.wcf.writeFields(c6093a);
                }
                c6093a.mo13480iz(6, this.guN);
                if (this.wFK != null) {
                    c6093a.mo13479iy(9, this.wFK.computeSize());
                    this.wFK.writeFields(c6093a);
                }
                if (this.wFL != null) {
                    c6093a.mo13479iy(10, this.wFL.computeSize());
                    this.wFL.writeFields(c6093a);
                }
                if (this.wFM != null) {
                    c6093a.mo13479iy(11, this.wFM.computeSize());
                    this.wFM.writeFields(c6093a);
                }
                c6093a.mo13480iz(12, this.wbA);
                if (this.guO != null) {
                    c6093a.mo13475e(13, this.guO);
                }
                if (this.guP != null) {
                    c6093a.mo13475e(14, this.guP);
                }
                if (this.guQ != null) {
                    c6093a.mo13475e(15, this.guQ);
                }
                c6093a.mo13480iz(16, this.guR);
                c6093a.mo13480iz(17, this.wBT);
                if (this.wBU != null) {
                    c6093a.mo13475e(18, this.wBU);
                }
                if (this.guW != null) {
                    c6093a.mo13475e(19, this.guW);
                }
                AppMethodBeat.m2505o(5594);
                return 0;
            }
        } else if (i == 1) {
            if (this.wcG != null) {
                ix = C6087a.m9557ix(1, this.wcG.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.wFJ);
            if (this.wyX != null) {
                ix += C6087a.m9557ix(3, this.wyX.computeSize());
            }
            if (this.wce != null) {
                ix += C6087a.m9557ix(4, this.wce.computeSize());
            }
            if (this.wcf != null) {
                ix += C6087a.m9557ix(5, this.wcf.computeSize());
            }
            ix += C6091a.m9572bs(6, this.guN);
            if (this.wFK != null) {
                ix += C6087a.m9557ix(9, this.wFK.computeSize());
            }
            if (this.wFL != null) {
                ix += C6087a.m9557ix(10, this.wFL.computeSize());
            }
            if (this.wFM != null) {
                ix += C6087a.m9557ix(11, this.wFM.computeSize());
            }
            ix += C6091a.m9572bs(12, this.wbA);
            if (this.guO != null) {
                ix += C6091a.m9575f(13, this.guO);
            }
            if (this.guP != null) {
                ix += C6091a.m9575f(14, this.guP);
            }
            if (this.guQ != null) {
                ix += C6091a.m9575f(15, this.guQ);
            }
            ix = (ix + C6091a.m9572bs(16, this.guR)) + C6091a.m9572bs(17, this.wBT);
            if (this.wBU != null) {
                ix += C6091a.m9575f(18, this.wBU);
            }
            if (this.guW != null) {
                ix += C6091a.m9575f(19, this.guW);
            }
            AppMethodBeat.m2505o(5594);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.wcG == null) {
                c6092b = new C6092b("Not all required fields were included: MemberName");
                AppMethodBeat.m2505o(5594);
                throw c6092b;
            } else if (this.wyX == null) {
                c6092b = new C6092b("Not all required fields were included: NickName");
                AppMethodBeat.m2505o(5594);
                throw c6092b;
            } else if (this.wce == null) {
                c6092b = new C6092b("Not all required fields were included: PYInitial");
                AppMethodBeat.m2505o(5594);
                throw c6092b;
            } else if (this.wcf == null) {
                c6092b = new C6092b("Not all required fields were included: QuanPin");
                AppMethodBeat.m2505o(5594);
                throw c6092b;
            } else if (this.wFK == null) {
                c6092b = new C6092b("Not all required fields were included: Remark");
                AppMethodBeat.m2505o(5594);
                throw c6092b;
            } else if (this.wFL == null) {
                c6092b = new C6092b("Not all required fields were included: RemarkPYInitial");
                AppMethodBeat.m2505o(5594);
                throw c6092b;
            } else if (this.wFM == null) {
                c6092b = new C6092b("Not all required fields were included: RemarkQuanPin");
                AppMethodBeat.m2505o(5594);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(5594);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            baz baz = (baz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            bts bts;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        baz.wcG = bts;
                    }
                    AppMethodBeat.m2505o(5594);
                    return 0;
                case 2:
                    baz.wFJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5594);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        baz.wyX = bts;
                    }
                    AppMethodBeat.m2505o(5594);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        baz.wce = bts;
                    }
                    AppMethodBeat.m2505o(5594);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        baz.wcf = bts;
                    }
                    AppMethodBeat.m2505o(5594);
                    return 0;
                case 6:
                    baz.guN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5594);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        baz.wFK = bts;
                    }
                    AppMethodBeat.m2505o(5594);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        baz.wFL = bts;
                    }
                    AppMethodBeat.m2505o(5594);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        baz.wFM = bts;
                    }
                    AppMethodBeat.m2505o(5594);
                    return 0;
                case 12:
                    baz.wbA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5594);
                    return 0;
                case 13:
                    baz.guO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(5594);
                    return 0;
                case 14:
                    baz.guP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(5594);
                    return 0;
                case 15:
                    baz.guQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(5594);
                    return 0;
                case 16:
                    baz.guR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5594);
                    return 0;
                case 17:
                    baz.wBT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5594);
                    return 0;
                case 18:
                    baz.wBU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(5594);
                    return 0;
                case 19:
                    baz.guW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(5594);
                    return 0;
                default:
                    AppMethodBeat.m2505o(5594);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(5594);
            return -1;
        }
    }
}
