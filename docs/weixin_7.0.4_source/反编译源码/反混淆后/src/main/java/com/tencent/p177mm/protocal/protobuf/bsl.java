package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bsl */
public final class bsl extends C1331a {
    public String AesKey;
    public String wTY;
    public String wUA;
    public String wUB;
    public String wUC;
    public String wUD;
    public float wUE;
    public String wUv;
    public float wUw;
    public String wUx;
    public String wUy;
    public String wUz;
    public String wdO;
    public String wip;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(65420);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wip == null) {
                c6092b = new C6092b("Not all required fields were included: FileID");
                AppMethodBeat.m2505o(65420);
                throw c6092b;
            } else if (this.AesKey == null) {
                c6092b = new C6092b("Not all required fields were included: AesKey");
                AppMethodBeat.m2505o(65420);
                throw c6092b;
            } else if (this.wUx == null) {
                c6092b = new C6092b("Not all required fields were included: ThumbFileID");
                AppMethodBeat.m2505o(65420);
                throw c6092b;
            } else if (this.wUy == null) {
                c6092b = new C6092b("Not all required fields were included: ThumbAesKey");
                AppMethodBeat.m2505o(65420);
                throw c6092b;
            } else if (this.wUz == null) {
                c6092b = new C6092b("Not all required fields were included: ThumbMD5");
                AppMethodBeat.m2505o(65420);
                throw c6092b;
            } else if (this.wUB == null) {
                c6092b = new C6092b("Not all required fields were included: OriginThumbFileID");
                AppMethodBeat.m2505o(65420);
                throw c6092b;
            } else if (this.wUC == null) {
                c6092b = new C6092b("Not all required fields were included: OriginThumbAesKey");
                AppMethodBeat.m2505o(65420);
                throw c6092b;
            } else if (this.wUD == null) {
                c6092b = new C6092b("Not all required fields were included: OriginThumbMD5");
                AppMethodBeat.m2505o(65420);
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
                if (this.wUv != null) {
                    c6093a.mo13475e(4, this.wUv);
                }
                c6093a.mo13481r(5, this.wUw);
                if (this.wUx != null) {
                    c6093a.mo13475e(6, this.wUx);
                }
                if (this.wUy != null) {
                    c6093a.mo13475e(7, this.wUy);
                }
                if (this.wUz != null) {
                    c6093a.mo13475e(8, this.wUz);
                }
                if (this.wTY != null) {
                    c6093a.mo13475e(9, this.wTY);
                }
                if (this.wUA != null) {
                    c6093a.mo13475e(10, this.wUA);
                }
                if (this.wUB != null) {
                    c6093a.mo13475e(11, this.wUB);
                }
                if (this.wUC != null) {
                    c6093a.mo13475e(12, this.wUC);
                }
                if (this.wUD != null) {
                    c6093a.mo13475e(13, this.wUD);
                }
                c6093a.mo13481r(14, this.wUE);
                AppMethodBeat.m2505o(65420);
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
            if (this.wUv != null) {
                f += C6091a.m9575f(4, this.wUv);
            }
            f += C6091a.m9576fv(5) + 4;
            if (this.wUx != null) {
                f += C6091a.m9575f(6, this.wUx);
            }
            if (this.wUy != null) {
                f += C6091a.m9575f(7, this.wUy);
            }
            if (this.wUz != null) {
                f += C6091a.m9575f(8, this.wUz);
            }
            if (this.wTY != null) {
                f += C6091a.m9575f(9, this.wTY);
            }
            if (this.wUA != null) {
                f += C6091a.m9575f(10, this.wUA);
            }
            if (this.wUB != null) {
                f += C6091a.m9575f(11, this.wUB);
            }
            if (this.wUC != null) {
                f += C6091a.m9575f(12, this.wUC);
            }
            if (this.wUD != null) {
                f += C6091a.m9575f(13, this.wUD);
            }
            int fv = f + (C6091a.m9576fv(14) + 4);
            AppMethodBeat.m2505o(65420);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.wip == null) {
                c6092b = new C6092b("Not all required fields were included: FileID");
                AppMethodBeat.m2505o(65420);
                throw c6092b;
            } else if (this.AesKey == null) {
                c6092b = new C6092b("Not all required fields were included: AesKey");
                AppMethodBeat.m2505o(65420);
                throw c6092b;
            } else if (this.wUx == null) {
                c6092b = new C6092b("Not all required fields were included: ThumbFileID");
                AppMethodBeat.m2505o(65420);
                throw c6092b;
            } else if (this.wUy == null) {
                c6092b = new C6092b("Not all required fields were included: ThumbAesKey");
                AppMethodBeat.m2505o(65420);
                throw c6092b;
            } else if (this.wUz == null) {
                c6092b = new C6092b("Not all required fields were included: ThumbMD5");
                AppMethodBeat.m2505o(65420);
                throw c6092b;
            } else if (this.wUB == null) {
                c6092b = new C6092b("Not all required fields were included: OriginThumbFileID");
                AppMethodBeat.m2505o(65420);
                throw c6092b;
            } else if (this.wUC == null) {
                c6092b = new C6092b("Not all required fields were included: OriginThumbAesKey");
                AppMethodBeat.m2505o(65420);
                throw c6092b;
            } else if (this.wUD == null) {
                c6092b = new C6092b("Not all required fields were included: OriginThumbMD5");
                AppMethodBeat.m2505o(65420);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(65420);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bsl bsl = (bsl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bsl.wip = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(65420);
                    return 0;
                case 2:
                    bsl.AesKey = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(65420);
                    return 0;
                case 3:
                    bsl.wdO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(65420);
                    return 0;
                case 4:
                    bsl.wUv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(65420);
                    return 0;
                case 5:
                    bsl.wUw = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(65420);
                    return 0;
                case 6:
                    bsl.wUx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(65420);
                    return 0;
                case 7:
                    bsl.wUy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(65420);
                    return 0;
                case 8:
                    bsl.wUz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(65420);
                    return 0;
                case 9:
                    bsl.wTY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(65420);
                    return 0;
                case 10:
                    bsl.wUA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(65420);
                    return 0;
                case 11:
                    bsl.wUB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(65420);
                    return 0;
                case 12:
                    bsl.wUC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(65420);
                    return 0;
                case 13:
                    bsl.wUD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(65420);
                    return 0;
                case 14:
                    bsl.wUE = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(65420);
                    return 0;
                default:
                    AppMethodBeat.m2505o(65420);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(65420);
            return -1;
        }
    }
}
