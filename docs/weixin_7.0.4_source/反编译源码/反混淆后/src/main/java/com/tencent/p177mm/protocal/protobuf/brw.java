package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.brw */
public final class brw extends C1331a {
    public String AesKey;
    public String wTW;
    public String wTX;
    public String wTY;
    public String wdO;
    public String wip;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(65416);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wip == null) {
                c6092b = new C6092b("Not all required fields were included: FileID");
                AppMethodBeat.m2505o(65416);
                throw c6092b;
            } else if (this.AesKey == null) {
                c6092b = new C6092b("Not all required fields were included: AesKey");
                AppMethodBeat.m2505o(65416);
                throw c6092b;
            } else if (this.wdO == null) {
                c6092b = new C6092b("Not all required fields were included: MD5");
                AppMethodBeat.m2505o(65416);
                throw c6092b;
            } else if (this.wTW == null) {
                c6092b = new C6092b("Not all required fields were included: OriginFileID");
                AppMethodBeat.m2505o(65416);
                throw c6092b;
            } else if (this.wTX == null) {
                c6092b = new C6092b("Not all required fields were included: OriginAesKey");
                AppMethodBeat.m2505o(65416);
                throw c6092b;
            } else if (this.wTY == null) {
                c6092b = new C6092b("Not all required fields were included: OriginMD5");
                AppMethodBeat.m2505o(65416);
                throw c6092b;
            } else {
                if (this.wip != null) {
                    c6093a.mo13475e(1, this.wip);
                }
                if (this.AesKey != null) {
                    c6093a.mo13475e(2, this.AesKey);
                }
                if (this.wdO != null) {
                    c6093a.mo13475e(3, this.wdO);
                }
                if (this.wTW != null) {
                    c6093a.mo13475e(4, this.wTW);
                }
                if (this.wTX != null) {
                    c6093a.mo13475e(5, this.wTX);
                }
                if (this.wTY != null) {
                    c6093a.mo13475e(6, this.wTY);
                }
                AppMethodBeat.m2505o(65416);
                return 0;
            }
        } else if (i == 1) {
            if (this.wip != null) {
                f = C6091a.m9575f(1, this.wip) + 0;
            } else {
                f = 0;
            }
            if (this.AesKey != null) {
                f += C6091a.m9575f(2, this.AesKey);
            }
            if (this.wdO != null) {
                f += C6091a.m9575f(3, this.wdO);
            }
            if (this.wTW != null) {
                f += C6091a.m9575f(4, this.wTW);
            }
            if (this.wTX != null) {
                f += C6091a.m9575f(5, this.wTX);
            }
            if (this.wTY != null) {
                f += C6091a.m9575f(6, this.wTY);
            }
            AppMethodBeat.m2505o(65416);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.wip == null) {
                c6092b = new C6092b("Not all required fields were included: FileID");
                AppMethodBeat.m2505o(65416);
                throw c6092b;
            } else if (this.AesKey == null) {
                c6092b = new C6092b("Not all required fields were included: AesKey");
                AppMethodBeat.m2505o(65416);
                throw c6092b;
            } else if (this.wdO == null) {
                c6092b = new C6092b("Not all required fields were included: MD5");
                AppMethodBeat.m2505o(65416);
                throw c6092b;
            } else if (this.wTW == null) {
                c6092b = new C6092b("Not all required fields were included: OriginFileID");
                AppMethodBeat.m2505o(65416);
                throw c6092b;
            } else if (this.wTX == null) {
                c6092b = new C6092b("Not all required fields were included: OriginAesKey");
                AppMethodBeat.m2505o(65416);
                throw c6092b;
            } else if (this.wTY == null) {
                c6092b = new C6092b("Not all required fields were included: OriginMD5");
                AppMethodBeat.m2505o(65416);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(65416);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            brw brw = (brw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    brw.wip = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(65416);
                    return 0;
                case 2:
                    brw.AesKey = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(65416);
                    return 0;
                case 3:
                    brw.wdO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(65416);
                    return 0;
                case 4:
                    brw.wTW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(65416);
                    return 0;
                case 5:
                    brw.wTX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(65416);
                    return 0;
                case 6:
                    brw.wTY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(65416);
                    return 0;
                default:
                    AppMethodBeat.m2505o(65416);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(65416);
            return -1;
        }
    }
}
