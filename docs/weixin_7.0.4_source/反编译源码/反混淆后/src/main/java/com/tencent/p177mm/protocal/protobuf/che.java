package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.che */
public final class che extends C1331a {
    public String bzH;
    public String cdy;
    public int iCm;
    public String nna;
    public String nuk;
    public String num;
    public String nun;
    public String nuo;
    public String title;
    public int versionCode;
    public String xga;
    public String xgb;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(105579);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.num == null) {
                c6092b = new C6092b("Not all required fields were included: patchId");
                AppMethodBeat.m2505o(105579);
                throw c6092b;
            } else if (this.nun == null) {
                c6092b = new C6092b("Not all required fields were included: newApkMd5");
                AppMethodBeat.m2505o(105579);
                throw c6092b;
            } else if (this.nuo == null) {
                c6092b = new C6092b("Not all required fields were included: oldApkMd5");
                AppMethodBeat.m2505o(105579);
                throw c6092b;
            } else if (this.title == null) {
                c6092b = new C6092b("Not all required fields were included: title");
                AppMethodBeat.m2505o(105579);
                throw c6092b;
            } else if (this.xgb == null) {
                c6092b = new C6092b("Not all required fields were included: okBtn");
                AppMethodBeat.m2505o(105579);
                throw c6092b;
            } else if (this.nna == null) {
                c6092b = new C6092b("Not all required fields were included: cancelBtn");
                AppMethodBeat.m2505o(105579);
                throw c6092b;
            } else if (this.cdy == null) {
                c6092b = new C6092b("Not all required fields were included: patchMd5");
                AppMethodBeat.m2505o(105579);
                throw c6092b;
            } else {
                if (this.num != null) {
                    c6093a.mo13475e(1, this.num);
                }
                if (this.xga != null) {
                    c6093a.mo13475e(2, this.xga);
                }
                c6093a.mo13480iz(3, this.iCm);
                if (this.nun != null) {
                    c6093a.mo13475e(4, this.nun);
                }
                if (this.nuo != null) {
                    c6093a.mo13475e(5, this.nuo);
                }
                if (this.title != null) {
                    c6093a.mo13475e(6, this.title);
                }
                if (this.bzH != null) {
                    c6093a.mo13475e(7, this.bzH);
                }
                if (this.xgb != null) {
                    c6093a.mo13475e(8, this.xgb);
                }
                if (this.nna != null) {
                    c6093a.mo13475e(9, this.nna);
                }
                if (this.nuk != null) {
                    c6093a.mo13475e(10, this.nuk);
                }
                if (this.cdy != null) {
                    c6093a.mo13475e(11, this.cdy);
                }
                c6093a.mo13480iz(12, this.versionCode);
                AppMethodBeat.m2505o(105579);
                return 0;
            }
        } else if (i == 1) {
            if (this.num != null) {
                f = C6091a.m9575f(1, this.num) + 0;
            } else {
                f = 0;
            }
            if (this.xga != null) {
                f += C6091a.m9575f(2, this.xga);
            }
            f += C6091a.m9572bs(3, this.iCm);
            if (this.nun != null) {
                f += C6091a.m9575f(4, this.nun);
            }
            if (this.nuo != null) {
                f += C6091a.m9575f(5, this.nuo);
            }
            if (this.title != null) {
                f += C6091a.m9575f(6, this.title);
            }
            if (this.bzH != null) {
                f += C6091a.m9575f(7, this.bzH);
            }
            if (this.xgb != null) {
                f += C6091a.m9575f(8, this.xgb);
            }
            if (this.nna != null) {
                f += C6091a.m9575f(9, this.nna);
            }
            if (this.nuk != null) {
                f += C6091a.m9575f(10, this.nuk);
            }
            if (this.cdy != null) {
                f += C6091a.m9575f(11, this.cdy);
            }
            int bs = f + C6091a.m9572bs(12, this.versionCode);
            AppMethodBeat.m2505o(105579);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.num == null) {
                c6092b = new C6092b("Not all required fields were included: patchId");
                AppMethodBeat.m2505o(105579);
                throw c6092b;
            } else if (this.nun == null) {
                c6092b = new C6092b("Not all required fields were included: newApkMd5");
                AppMethodBeat.m2505o(105579);
                throw c6092b;
            } else if (this.nuo == null) {
                c6092b = new C6092b("Not all required fields were included: oldApkMd5");
                AppMethodBeat.m2505o(105579);
                throw c6092b;
            } else if (this.title == null) {
                c6092b = new C6092b("Not all required fields were included: title");
                AppMethodBeat.m2505o(105579);
                throw c6092b;
            } else if (this.xgb == null) {
                c6092b = new C6092b("Not all required fields were included: okBtn");
                AppMethodBeat.m2505o(105579);
                throw c6092b;
            } else if (this.nna == null) {
                c6092b = new C6092b("Not all required fields were included: cancelBtn");
                AppMethodBeat.m2505o(105579);
                throw c6092b;
            } else if (this.cdy == null) {
                c6092b = new C6092b("Not all required fields were included: patchMd5");
                AppMethodBeat.m2505o(105579);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(105579);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            che che = (che) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    che.num = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105579);
                    return 0;
                case 2:
                    che.xga = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105579);
                    return 0;
                case 3:
                    che.iCm = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(105579);
                    return 0;
                case 4:
                    che.nun = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105579);
                    return 0;
                case 5:
                    che.nuo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105579);
                    return 0;
                case 6:
                    che.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105579);
                    return 0;
                case 7:
                    che.bzH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105579);
                    return 0;
                case 8:
                    che.xgb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105579);
                    return 0;
                case 9:
                    che.nna = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105579);
                    return 0;
                case 10:
                    che.nuk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105579);
                    return 0;
                case 11:
                    che.cdy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105579);
                    return 0;
                case 12:
                    che.versionCode = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(105579);
                    return 0;
                default:
                    AppMethodBeat.m2505o(105579);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(105579);
            return -1;
        }
    }
}
