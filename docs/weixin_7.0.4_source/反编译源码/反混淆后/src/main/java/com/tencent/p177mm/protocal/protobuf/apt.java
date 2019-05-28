package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.apt */
public final class apt extends btd {
    public String fha;
    public boolean lvU;
    public LinkedList<ach> vEx = new LinkedList();
    public LinkedList<String> wtG = new LinkedList();
    public String wtH;
    public String wtI;
    public boolean wtK;
    public LinkedList<cyi> wtN = new LinkedList();
    public LinkedList<cyj> wtO = new LinkedList();
    public String wtP;
    public String wtQ;
    public String wtR;
    public String wtS;
    public boolean wtT;
    public int wtU;
    public String wtV;

    public apt() {
        AppMethodBeat.m2504i(28482);
        AppMethodBeat.m2505o(28482);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28483);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28483);
                throw c6092b;
            } else if (this.wtP == null) {
                c6092b = new C6092b("Not all required fields were included: championcoverurl");
                AppMethodBeat.m2505o(28483);
                throw c6092b;
            } else if (this.wtQ == null) {
                c6092b = new C6092b("Not all required fields were included: championmotto");
                AppMethodBeat.m2505o(28483);
                throw c6092b;
            } else if (this.fha == null) {
                c6092b = new C6092b("Not all required fields were included: rankid");
                AppMethodBeat.m2505o(28483);
                throw c6092b;
            } else {
                if (this.BaseResponse != null) {
                    c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(c6093a);
                }
                c6093a.mo13474e(2, 8, this.wtN);
                c6093a.mo13474e(3, 8, this.wtO);
                c6093a.mo13474e(4, 1, this.wtG);
                if (this.wtP != null) {
                    c6093a.mo13475e(5, this.wtP);
                }
                if (this.wtQ != null) {
                    c6093a.mo13475e(6, this.wtQ);
                }
                if (this.fha != null) {
                    c6093a.mo13475e(7, this.fha);
                }
                if (this.wtR != null) {
                    c6093a.mo13475e(8, this.wtR);
                }
                if (this.wtH != null) {
                    c6093a.mo13475e(9, this.wtH);
                }
                c6093a.mo13471aO(10, this.lvU);
                if (this.wtI != null) {
                    c6093a.mo13475e(11, this.wtI);
                }
                c6093a.mo13474e(12, 8, this.vEx);
                c6093a.mo13471aO(13, this.wtK);
                if (this.wtS != null) {
                    c6093a.mo13475e(14, this.wtS);
                }
                c6093a.mo13471aO(15, this.wtT);
                c6093a.mo13480iz(16, this.wtU);
                if (this.wtV != null) {
                    c6093a.mo13475e(17, this.wtV);
                }
                AppMethodBeat.m2505o(28483);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((ix + C6087a.m9552c(2, 8, this.wtN)) + C6087a.m9552c(3, 8, this.wtO)) + C6087a.m9552c(4, 1, this.wtG);
            if (this.wtP != null) {
                ix += C6091a.m9575f(5, this.wtP);
            }
            if (this.wtQ != null) {
                ix += C6091a.m9575f(6, this.wtQ);
            }
            if (this.fha != null) {
                ix += C6091a.m9575f(7, this.fha);
            }
            if (this.wtR != null) {
                ix += C6091a.m9575f(8, this.wtR);
            }
            if (this.wtH != null) {
                ix += C6091a.m9575f(9, this.wtH);
            }
            ix += C6091a.m9576fv(10) + 1;
            if (this.wtI != null) {
                ix += C6091a.m9575f(11, this.wtI);
            }
            ix = (ix + C6087a.m9552c(12, 8, this.vEx)) + (C6091a.m9576fv(13) + 1);
            if (this.wtS != null) {
                ix += C6091a.m9575f(14, this.wtS);
            }
            ix = (ix + (C6091a.m9576fv(15) + 1)) + C6091a.m9572bs(16, this.wtU);
            if (this.wtV != null) {
                ix += C6091a.m9575f(17, this.wtV);
            }
            AppMethodBeat.m2505o(28483);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wtN.clear();
            this.wtO.clear();
            this.wtG.clear();
            this.vEx.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28483);
                throw c6092b;
            } else if (this.wtP == null) {
                c6092b = new C6092b("Not all required fields were included: championcoverurl");
                AppMethodBeat.m2505o(28483);
                throw c6092b;
            } else if (this.wtQ == null) {
                c6092b = new C6092b("Not all required fields were included: championmotto");
                AppMethodBeat.m2505o(28483);
                throw c6092b;
            } else if (this.fha == null) {
                c6092b = new C6092b("Not all required fields were included: rankid");
                AppMethodBeat.m2505o(28483);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(28483);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            apt apt = (apt) objArr[1];
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
                        apt.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(28483);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cyi cyi = new cyi();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cyi.populateBuilderWithField(c6086a3, cyi, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        apt.wtN.add(cyi);
                    }
                    AppMethodBeat.m2505o(28483);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cyj cyj = new cyj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cyj.populateBuilderWithField(c6086a3, cyj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        apt.wtO.add(cyj);
                    }
                    AppMethodBeat.m2505o(28483);
                    return 0;
                case 4:
                    apt.wtG.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(28483);
                    return 0;
                case 5:
                    apt.wtP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28483);
                    return 0;
                case 6:
                    apt.wtQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28483);
                    return 0;
                case 7:
                    apt.fha = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28483);
                    return 0;
                case 8:
                    apt.wtR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28483);
                    return 0;
                case 9:
                    apt.wtH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28483);
                    return 0;
                case 10:
                    apt.lvU = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(28483);
                    return 0;
                case 11:
                    apt.wtI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28483);
                    return 0;
                case 12:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ach ach = new ach();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ach.populateBuilderWithField(c6086a3, ach, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        apt.vEx.add(ach);
                    }
                    AppMethodBeat.m2505o(28483);
                    return 0;
                case 13:
                    apt.wtK = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(28483);
                    return 0;
                case 14:
                    apt.wtS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28483);
                    return 0;
                case 15:
                    apt.wtT = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(28483);
                    return 0;
                case 16:
                    apt.wtU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28483);
                    return 0;
                case 17:
                    apt.wtV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28483);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28483);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28483);
            return -1;
        }
    }
}
