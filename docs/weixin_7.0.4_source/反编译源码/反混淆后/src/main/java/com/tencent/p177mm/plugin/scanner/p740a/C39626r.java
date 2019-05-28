package com.tencent.p177mm.plugin.scanner.p740a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.scanner.a.r */
public final class C39626r {
    public static C39626r qaD;
    public String bCu;
    public String dtV;
    public String hHN;
    public String hHW;
    public String qaA;
    public String qaB;
    public String qaC;
    public C28891b qam;
    C39625c qan;
    public C39625c qao;
    C39625c qap;
    public String qaq;
    public C13118a qar;
    public C13118a qas;
    public C13118a qat;
    public C13118a qau;
    public List<String> qav;
    public List<String> qaw;
    public List<String> qax;
    public List<String> qay;
    public List<String> qaz;
    public String title;
    public String url;

    /* renamed from: com.tencent.mm.plugin.scanner.a.r$a */
    public static class C13118a {
        private String country;
        private String fBi;
        private String fQE;
        private String hIa;
        private String hIb;
        private String qaE;
        private String qaF;

        public C13118a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            AppMethodBeat.m2504i(80886);
            if (str == null) {
                str = "";
            }
            this.qaE = str;
            if (str2 == null) {
                str2 = "";
            }
            this.qaF = str2;
            if (str3 == null) {
                str3 = "";
            }
            this.hIa = str3;
            if (str4 == null) {
                str4 = "";
            }
            this.fBi = str4;
            if (str5 == null) {
                str5 = "";
            }
            this.fQE = str5;
            if (str6 == null) {
                str6 = "";
            }
            this.hIb = str6;
            if (str7 == null) {
                str7 = "";
            }
            this.country = str7;
            AppMethodBeat.m2505o(80886);
        }

        public final String aDu() {
            String stringBuilder;
            AppMethodBeat.m2504i(80887);
            StringBuilder stringBuilder2;
            if (C5046bo.amT(this.qaE) || C5046bo.amT(this.qaF) || C5046bo.amT(this.hIa) || C5046bo.amT(this.fBi) || C5046bo.amT(this.fQE) || C5046bo.amT(this.country)) {
                stringBuilder2 = new StringBuilder();
                if (this.country.length() > 0) {
                    stringBuilder2.append(this.country);
                    stringBuilder2.append(IOUtils.LINE_SEPARATOR_UNIX);
                }
                if (this.fQE.length() > 0) {
                    stringBuilder2.append(this.fQE + " ");
                }
                if (this.fBi.length() > 0) {
                    stringBuilder2.append(this.fBi);
                }
                if (this.fQE.length() > 0 || this.fBi.length() > 0) {
                    stringBuilder2.append(IOUtils.LINE_SEPARATOR_UNIX);
                }
                if (this.hIa.length() > 0) {
                    stringBuilder2.append(this.hIa + " ");
                    stringBuilder2.append(IOUtils.LINE_SEPARATOR_UNIX);
                }
                if (this.qaF.length() > 0) {
                    stringBuilder2.append(this.qaF);
                    stringBuilder2.append(IOUtils.LINE_SEPARATOR_UNIX);
                }
                if (this.qaE.length() > 0) {
                    stringBuilder2.append(this.qaE);
                    stringBuilder2.append(IOUtils.LINE_SEPARATOR_UNIX);
                }
                if (this.hIb.length() > 0) {
                    stringBuilder2.append(this.hIb);
                }
                stringBuilder = stringBuilder2.toString();
                if (stringBuilder.endsWith(IOUtils.LINE_SEPARATOR_UNIX)) {
                    stringBuilder = stringBuilder.substring(0, stringBuilder.length() - 1);
                }
                AppMethodBeat.m2505o(80887);
            } else {
                stringBuilder2 = new StringBuilder();
                if (this.qaE.length() > 0) {
                    stringBuilder2.append(this.qaE);
                    stringBuilder2.append(IOUtils.LINE_SEPARATOR_UNIX);
                }
                if (this.qaF.length() > 0) {
                    stringBuilder2.append(this.qaF);
                    stringBuilder2.append(IOUtils.LINE_SEPARATOR_UNIX);
                }
                if (this.hIa.length() > 0) {
                    stringBuilder2.append(this.hIa);
                    stringBuilder2.append(IOUtils.LINE_SEPARATOR_UNIX);
                }
                if (this.fBi.length() > 0) {
                    stringBuilder2.append(this.fBi + " ");
                }
                if (this.fQE.length() > 0) {
                    stringBuilder2.append(this.fQE + " ");
                }
                if (this.hIb.length() > 0) {
                    stringBuilder2.append(this.hIb);
                }
                if (this.fBi.length() > 0 || this.fQE.length() > 0) {
                    stringBuilder2.append(IOUtils.LINE_SEPARATOR_UNIX);
                }
                if (this.country.length() > 0) {
                    stringBuilder2.append(this.country);
                }
                stringBuilder = stringBuilder2.toString();
                if (stringBuilder.endsWith(IOUtils.LINE_SEPARATOR_UNIX)) {
                    stringBuilder = stringBuilder.substring(0, stringBuilder.length() - 1);
                }
                AppMethodBeat.m2505o(80887);
            }
            return stringBuilder;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.a.r$b */
    public static class C28891b {
        private String firstName;
        private String lastName;
        private String middleName;

        public C28891b(String str, String str2, String str3) {
            AppMethodBeat.m2504i(80888);
            if (str == null) {
                str = "";
            }
            this.firstName = str;
            if (str2 == null) {
                str2 = "";
            }
            this.middleName = str2;
            if (str3 == null) {
                str3 = "";
            }
            this.lastName = str3;
            AppMethodBeat.m2505o(80888);
        }

        public final String aDu() {
            AppMethodBeat.m2504i(80889);
            StringBuilder stringBuilder = new StringBuilder();
            if (C5046bo.amT(this.firstName) || C5046bo.amT(this.middleName) || C5046bo.amT(this.lastName)) {
                if (this.lastName.trim().length() > 0) {
                    stringBuilder.append(this.lastName);
                }
                if (this.middleName.trim().length() > 0) {
                    stringBuilder.append(this.middleName);
                }
                if (this.firstName.trim().length() > 0) {
                    stringBuilder.append(this.firstName);
                }
            } else {
                if (this.firstName.trim().length() > 0) {
                    stringBuilder.append(this.firstName);
                }
                if (this.middleName.trim().length() > 0) {
                    stringBuilder.append(" ");
                    stringBuilder.append(this.middleName);
                }
                if (this.lastName.trim().length() > 0) {
                    stringBuilder.append(" ");
                    stringBuilder.append(this.lastName);
                }
            }
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(80889);
            return stringBuilder2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.a.r$c */
    public static class C39625c {
        public String qaG;
        public String qaH;

        public C39625c(String str, String str2) {
            this.qaG = str;
            this.qaH = str2;
        }
    }
}
