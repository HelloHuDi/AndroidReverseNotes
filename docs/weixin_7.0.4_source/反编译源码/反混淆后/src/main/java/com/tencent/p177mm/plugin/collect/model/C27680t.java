package com.tencent.p177mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.collect.model.t */
public class C27680t extends C1331a {
    public String cAa;
    public String cuZ;
    public String eoz;
    public double kCJ;
    public String kCK;
    public int msgType;
    public int scene;
    public int status;
    public int timestamp;
    public String type;
    public String username;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56607);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.username == null) {
                c6092b = new C6092b("Not all required fields were included: username");
                AppMethodBeat.m2505o(56607);
                throw c6092b;
            } else if (this.cAa == null) {
                c6092b = new C6092b("Not all required fields were included: transactionId");
                AppMethodBeat.m2505o(56607);
                throw c6092b;
            } else if (this.cuZ == null) {
                c6092b = new C6092b("Not all required fields were included: feeType");
                AppMethodBeat.m2505o(56607);
                throw c6092b;
            } else {
                if (this.username != null) {
                    c6093a.mo13475e(1, this.username);
                }
                if (this.cAa != null) {
                    c6093a.mo13475e(2, this.cAa);
                }
                c6093a.mo13476f(3, this.kCJ);
                if (this.cuZ != null) {
                    c6093a.mo13475e(4, this.cuZ);
                }
                c6093a.mo13480iz(5, this.timestamp);
                c6093a.mo13480iz(6, this.scene);
                c6093a.mo13480iz(7, this.status);
                if (this.eoz != null) {
                    c6093a.mo13475e(8, this.eoz);
                }
                if (this.kCK != null) {
                    c6093a.mo13475e(9, this.kCK);
                }
                c6093a.mo13480iz(10, this.msgType);
                if (this.type != null) {
                    c6093a.mo13475e(11, this.type);
                }
                AppMethodBeat.m2505o(56607);
                return 0;
            }
        } else if (i == 1) {
            if (this.username != null) {
                f = C6091a.m9575f(1, this.username) + 0;
            } else {
                f = 0;
            }
            if (this.cAa != null) {
                f += C6091a.m9575f(2, this.cAa);
            }
            f += C6091a.m9576fv(3) + 8;
            if (this.cuZ != null) {
                f += C6091a.m9575f(4, this.cuZ);
            }
            f = ((f + C6091a.m9572bs(5, this.timestamp)) + C6091a.m9572bs(6, this.scene)) + C6091a.m9572bs(7, this.status);
            if (this.eoz != null) {
                f += C6091a.m9575f(8, this.eoz);
            }
            if (this.kCK != null) {
                f += C6091a.m9575f(9, this.kCK);
            }
            f += C6091a.m9572bs(10, this.msgType);
            if (this.type != null) {
                f += C6091a.m9575f(11, this.type);
            }
            AppMethodBeat.m2505o(56607);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.username == null) {
                c6092b = new C6092b("Not all required fields were included: username");
                AppMethodBeat.m2505o(56607);
                throw c6092b;
            } else if (this.cAa == null) {
                c6092b = new C6092b("Not all required fields were included: transactionId");
                AppMethodBeat.m2505o(56607);
                throw c6092b;
            } else if (this.cuZ == null) {
                c6092b = new C6092b("Not all required fields were included: feeType");
                AppMethodBeat.m2505o(56607);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(56607);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C27680t c27680t = (C27680t) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c27680t.username = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56607);
                    return 0;
                case 2:
                    c27680t.cAa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56607);
                    return 0;
                case 3:
                    c27680t.kCJ = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(56607);
                    return 0;
                case 4:
                    c27680t.cuZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56607);
                    return 0;
                case 5:
                    c27680t.timestamp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56607);
                    return 0;
                case 6:
                    c27680t.scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56607);
                    return 0;
                case 7:
                    c27680t.status = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56607);
                    return 0;
                case 8:
                    c27680t.eoz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56607);
                    return 0;
                case 9:
                    c27680t.kCK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56607);
                    return 0;
                case 10:
                    c27680t.msgType = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56607);
                    return 0;
                case 11:
                    c27680t.type = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56607);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56607);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56607);
            return -1;
        }
    }
}
