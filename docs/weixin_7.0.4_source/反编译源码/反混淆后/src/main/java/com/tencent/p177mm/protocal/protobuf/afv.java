package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.afv */
public final class afv extends bsr {
    public String kmt;
    public String signature;
    public String tyv;
    public String vOV;
    public String wbO;
    public String wmY;
    public String wmZ;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(11765);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wbO == null) {
                c6092b = new C6092b("Not all required fields were included: corp_id");
                AppMethodBeat.m2505o(11765);
                throw c6092b;
            } else if (this.wmY == null) {
                c6092b = new C6092b("Not all required fields were included: group_id");
                AppMethodBeat.m2505o(11765);
                throw c6092b;
            } else if (this.tyv == null) {
                c6092b = new C6092b("Not all required fields were included: time_stamp");
                AppMethodBeat.m2505o(11765);
                throw c6092b;
            } else if (this.kmt == null) {
                c6092b = new C6092b("Not all required fields were included: nonce_str");
                AppMethodBeat.m2505o(11765);
                throw c6092b;
            } else if (this.signature == null) {
                c6092b = new C6092b("Not all required fields were included: signature");
                AppMethodBeat.m2505o(11765);
                throw c6092b;
            } else if (this.vOV == null) {
                c6092b = new C6092b("Not all required fields were included: from_url");
                AppMethodBeat.m2505o(11765);
                throw c6092b;
            } else {
                if (this.BaseRequest != null) {
                    c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(c6093a);
                }
                if (this.wbO != null) {
                    c6093a.mo13475e(2, this.wbO);
                }
                if (this.wmY != null) {
                    c6093a.mo13475e(3, this.wmY);
                }
                if (this.tyv != null) {
                    c6093a.mo13475e(4, this.tyv);
                }
                if (this.kmt != null) {
                    c6093a.mo13475e(5, this.kmt);
                }
                if (this.signature != null) {
                    c6093a.mo13475e(6, this.signature);
                }
                if (this.vOV != null) {
                    c6093a.mo13475e(7, this.vOV);
                }
                if (this.wmZ != null) {
                    c6093a.mo13475e(8, this.wmZ);
                }
                AppMethodBeat.m2505o(11765);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wbO != null) {
                ix += C6091a.m9575f(2, this.wbO);
            }
            if (this.wmY != null) {
                ix += C6091a.m9575f(3, this.wmY);
            }
            if (this.tyv != null) {
                ix += C6091a.m9575f(4, this.tyv);
            }
            if (this.kmt != null) {
                ix += C6091a.m9575f(5, this.kmt);
            }
            if (this.signature != null) {
                ix += C6091a.m9575f(6, this.signature);
            }
            if (this.vOV != null) {
                ix += C6091a.m9575f(7, this.vOV);
            }
            if (this.wmZ != null) {
                ix += C6091a.m9575f(8, this.wmZ);
            }
            AppMethodBeat.m2505o(11765);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.wbO == null) {
                c6092b = new C6092b("Not all required fields were included: corp_id");
                AppMethodBeat.m2505o(11765);
                throw c6092b;
            } else if (this.wmY == null) {
                c6092b = new C6092b("Not all required fields were included: group_id");
                AppMethodBeat.m2505o(11765);
                throw c6092b;
            } else if (this.tyv == null) {
                c6092b = new C6092b("Not all required fields were included: time_stamp");
                AppMethodBeat.m2505o(11765);
                throw c6092b;
            } else if (this.kmt == null) {
                c6092b = new C6092b("Not all required fields were included: nonce_str");
                AppMethodBeat.m2505o(11765);
                throw c6092b;
            } else if (this.signature == null) {
                c6092b = new C6092b("Not all required fields were included: signature");
                AppMethodBeat.m2505o(11765);
                throw c6092b;
            } else if (this.vOV == null) {
                c6092b = new C6092b("Not all required fields were included: from_url");
                AppMethodBeat.m2505o(11765);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(11765);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            afv afv = (afv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        afv.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(11765);
                    return 0;
                case 2:
                    afv.wbO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11765);
                    return 0;
                case 3:
                    afv.wmY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11765);
                    return 0;
                case 4:
                    afv.tyv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11765);
                    return 0;
                case 5:
                    afv.kmt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11765);
                    return 0;
                case 6:
                    afv.signature = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11765);
                    return 0;
                case 7:
                    afv.vOV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11765);
                    return 0;
                case 8:
                    afv.wmZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11765);
                    return 0;
                default:
                    AppMethodBeat.m2505o(11765);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(11765);
            return -1;
        }
    }
}
