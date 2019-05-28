package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aea */
public final class aea extends bsr {
    public int count;
    public String csB;
    public String desc;
    public int scene;
    public String sign;
    public int wlY;
    public int wlZ;
    public String wma;
    public String wmb;
    public String wmc;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48843);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.csB == null) {
                c6092b = new C6092b("Not all required fields were included: appid");
                AppMethodBeat.m2505o(48843);
                throw c6092b;
            } else if (this.wmb == null) {
                c6092b = new C6092b("Not all required fields were included: busi_id");
                AppMethodBeat.m2505o(48843);
                throw c6092b;
            } else {
                if (this.BaseRequest != null) {
                    c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(c6093a);
                }
                c6093a.mo13480iz(2, this.wlY);
                if (this.csB != null) {
                    c6093a.mo13475e(3, this.csB);
                }
                if (this.desc != null) {
                    c6093a.mo13475e(4, this.desc);
                }
                c6093a.mo13480iz(5, this.wlZ);
                if (this.wma != null) {
                    c6093a.mo13475e(6, this.wma);
                }
                c6093a.mo13480iz(7, this.count);
                c6093a.mo13480iz(8, this.scene);
                if (this.wmb != null) {
                    c6093a.mo13475e(9, this.wmb);
                }
                if (this.sign != null) {
                    c6093a.mo13475e(10, this.sign);
                }
                if (this.wmc != null) {
                    c6093a.mo13475e(11, this.wmc);
                }
                AppMethodBeat.m2505o(48843);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.wlY);
            if (this.csB != null) {
                ix += C6091a.m9575f(3, this.csB);
            }
            if (this.desc != null) {
                ix += C6091a.m9575f(4, this.desc);
            }
            ix += C6091a.m9572bs(5, this.wlZ);
            if (this.wma != null) {
                ix += C6091a.m9575f(6, this.wma);
            }
            ix = (ix + C6091a.m9572bs(7, this.count)) + C6091a.m9572bs(8, this.scene);
            if (this.wmb != null) {
                ix += C6091a.m9575f(9, this.wmb);
            }
            if (this.sign != null) {
                ix += C6091a.m9575f(10, this.sign);
            }
            if (this.wmc != null) {
                ix += C6091a.m9575f(11, this.wmc);
            }
            AppMethodBeat.m2505o(48843);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.csB == null) {
                c6092b = new C6092b("Not all required fields were included: appid");
                AppMethodBeat.m2505o(48843);
                throw c6092b;
            } else if (this.wmb == null) {
                c6092b = new C6092b("Not all required fields were included: busi_id");
                AppMethodBeat.m2505o(48843);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(48843);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aea aea = (aea) objArr[1];
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
                        aea.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(48843);
                    return 0;
                case 2:
                    aea.wlY = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48843);
                    return 0;
                case 3:
                    aea.csB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48843);
                    return 0;
                case 4:
                    aea.desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48843);
                    return 0;
                case 5:
                    aea.wlZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48843);
                    return 0;
                case 6:
                    aea.wma = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48843);
                    return 0;
                case 7:
                    aea.count = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48843);
                    return 0;
                case 8:
                    aea.scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48843);
                    return 0;
                case 9:
                    aea.wmb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48843);
                    return 0;
                case 10:
                    aea.sign = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48843);
                    return 0;
                case 11:
                    aea.wmc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48843);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48843);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48843);
            return -1;
        }
    }
}
