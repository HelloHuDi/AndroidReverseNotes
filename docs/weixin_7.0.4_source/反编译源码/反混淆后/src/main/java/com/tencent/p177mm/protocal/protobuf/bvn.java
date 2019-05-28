package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bvn */
public final class bvn extends C1331a {
    public int guN;
    public String guO;
    public String guP;
    public String guQ;
    public int guR;
    public String guS;
    public String guW;
    public String vXm;
    public String vXn;
    public int wBT;
    public String wBU;
    public String wBV;
    public String wBW;
    public int wBX;
    public C7285uy wCa;
    public bts wcB;
    public bts wyX;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(14749);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wcB == null) {
                c6092b = new C6092b("Not all required fields were included: UserName");
                AppMethodBeat.m2505o(14749);
                throw c6092b;
            } else if (this.wyX == null) {
                c6092b = new C6092b("Not all required fields were included: NickName");
                AppMethodBeat.m2505o(14749);
                throw c6092b;
            } else {
                if (this.wcB != null) {
                    c6093a.mo13479iy(1, this.wcB.computeSize());
                    this.wcB.writeFields(c6093a);
                }
                if (this.wyX != null) {
                    c6093a.mo13479iy(2, this.wyX.computeSize());
                    this.wyX.writeFields(c6093a);
                }
                c6093a.mo13480iz(3, this.guN);
                if (this.guO != null) {
                    c6093a.mo13475e(4, this.guO);
                }
                if (this.guP != null) {
                    c6093a.mo13475e(5, this.guP);
                }
                if (this.guQ != null) {
                    c6093a.mo13475e(6, this.guQ);
                }
                c6093a.mo13480iz(7, this.guR);
                c6093a.mo13480iz(8, this.wBT);
                if (this.wBU != null) {
                    c6093a.mo13475e(9, this.wBU);
                }
                if (this.wBV != null) {
                    c6093a.mo13475e(10, this.wBV);
                }
                if (this.guS != null) {
                    c6093a.mo13475e(11, this.guS);
                }
                if (this.wBW != null) {
                    c6093a.mo13475e(12, this.wBW);
                }
                c6093a.mo13480iz(13, this.wBX);
                if (this.guW != null) {
                    c6093a.mo13475e(14, this.guW);
                }
                if (this.wCa != null) {
                    c6093a.mo13479iy(15, this.wCa.computeSize());
                    this.wCa.writeFields(c6093a);
                }
                if (this.vXm != null) {
                    c6093a.mo13475e(16, this.vXm);
                }
                if (this.vXn != null) {
                    c6093a.mo13475e(17, this.vXn);
                }
                AppMethodBeat.m2505o(14749);
                return 0;
            }
        } else if (i == 1) {
            if (this.wcB != null) {
                ix = C6087a.m9557ix(1, this.wcB.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wyX != null) {
                ix += C6087a.m9557ix(2, this.wyX.computeSize());
            }
            ix += C6091a.m9572bs(3, this.guN);
            if (this.guO != null) {
                ix += C6091a.m9575f(4, this.guO);
            }
            if (this.guP != null) {
                ix += C6091a.m9575f(5, this.guP);
            }
            if (this.guQ != null) {
                ix += C6091a.m9575f(6, this.guQ);
            }
            ix = (ix + C6091a.m9572bs(7, this.guR)) + C6091a.m9572bs(8, this.wBT);
            if (this.wBU != null) {
                ix += C6091a.m9575f(9, this.wBU);
            }
            if (this.wBV != null) {
                ix += C6091a.m9575f(10, this.wBV);
            }
            if (this.guS != null) {
                ix += C6091a.m9575f(11, this.guS);
            }
            if (this.wBW != null) {
                ix += C6091a.m9575f(12, this.wBW);
            }
            ix += C6091a.m9572bs(13, this.wBX);
            if (this.guW != null) {
                ix += C6091a.m9575f(14, this.guW);
            }
            if (this.wCa != null) {
                ix += C6087a.m9557ix(15, this.wCa.computeSize());
            }
            if (this.vXm != null) {
                ix += C6091a.m9575f(16, this.vXm);
            }
            if (this.vXn != null) {
                ix += C6091a.m9575f(17, this.vXn);
            }
            AppMethodBeat.m2505o(14749);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.wcB == null) {
                c6092b = new C6092b("Not all required fields were included: UserName");
                AppMethodBeat.m2505o(14749);
                throw c6092b;
            } else if (this.wyX == null) {
                c6092b = new C6092b("Not all required fields were included: NickName");
                AppMethodBeat.m2505o(14749);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(14749);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bvn bvn = (bvn) objArr[1];
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
                        bvn.wcB = bts;
                    }
                    AppMethodBeat.m2505o(14749);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bvn.wyX = bts;
                    }
                    AppMethodBeat.m2505o(14749);
                    return 0;
                case 3:
                    bvn.guN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14749);
                    return 0;
                case 4:
                    bvn.guO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14749);
                    return 0;
                case 5:
                    bvn.guP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14749);
                    return 0;
                case 6:
                    bvn.guQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14749);
                    return 0;
                case 7:
                    bvn.guR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14749);
                    return 0;
                case 8:
                    bvn.wBT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14749);
                    return 0;
                case 9:
                    bvn.wBU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14749);
                    return 0;
                case 10:
                    bvn.wBV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14749);
                    return 0;
                case 11:
                    bvn.guS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14749);
                    return 0;
                case 12:
                    bvn.wBW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14749);
                    return 0;
                case 13:
                    bvn.wBX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14749);
                    return 0;
                case 14:
                    bvn.guW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14749);
                    return 0;
                case 15:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7285uy c7285uy = new C7285uy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7285uy.populateBuilderWithField(c6086a3, c7285uy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bvn.wCa = c7285uy;
                    }
                    AppMethodBeat.m2505o(14749);
                    return 0;
                case 16:
                    bvn.vXm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14749);
                    return 0;
                case 17:
                    bvn.vXn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14749);
                    return 0;
                default:
                    AppMethodBeat.m2505o(14749);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(14749);
            return -1;
        }
    }
}
