package com.tencent.p177mm.plugin.appbrand.jsapi.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.contact.a */
public final class C45590a {
    String bCu;
    String dtV;
    C26955b hHM;
    String hHN;
    C19354a hHO;
    C19354a hHP;
    C19354a hHQ;
    String hHR;
    String hHS;
    String hHT;
    String hHU;
    String hHV;
    String hHW;
    String hHX;
    String hHY;
    String hHZ;
    String title;
    String url;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.contact.a$a */
    public static class C19354a {
        private String country;
        private String dud;
        private String hIa;
        String hIb;
        private String state;

        public C19354a(String str, String str2, String str3, String str4, String str5) {
            AppMethodBeat.m2504i(126257);
            this.country = C5046bo.nullAsNil(str);
            this.state = C5046bo.nullAsNil(str2);
            this.dud = C5046bo.nullAsNil(str3);
            this.hIa = C5046bo.nullAsNil(str4);
            this.hIb = C5046bo.nullAsNil(str5);
            AppMethodBeat.m2505o(126257);
        }

        public final String aDu() {
            AppMethodBeat.m2504i(126258);
            StringBuilder stringBuilder;
            String stringBuilder2;
            if (C5046bo.amT(this.country) || C5046bo.amT(this.state) || C5046bo.amT(this.dud) || C5046bo.amT(this.hIa) || C5046bo.amT(this.hIb)) {
                stringBuilder = new StringBuilder();
                if (this.country.length() > 0) {
                    stringBuilder.append(this.country);
                }
                if (this.state.length() > 0) {
                    stringBuilder.append(this.state);
                }
                if (this.dud.length() > 0) {
                    stringBuilder.append(this.dud);
                }
                if (this.hIa.length() > 0) {
                    stringBuilder.append(this.hIa);
                }
                if (this.hIb.length() > 0) {
                    stringBuilder.append(" ");
                    stringBuilder.append(this.hIb);
                }
                stringBuilder2 = stringBuilder.toString();
                AppMethodBeat.m2505o(126258);
                return stringBuilder2;
            }
            stringBuilder = new StringBuilder();
            if (this.hIa.length() > 0) {
                stringBuilder.append(this.hIa);
                stringBuilder.append(" ");
            }
            if (this.dud.length() > 0) {
                stringBuilder.append(this.dud + " ");
            }
            if (this.state.length() > 0) {
                stringBuilder.append(this.state + " ");
            }
            if (this.country.length() > 0) {
                stringBuilder.append(this.country);
            }
            if (this.hIb.length() > 0) {
                stringBuilder.append(" ");
                stringBuilder.append(this.hIb);
            }
            stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(126258);
            return stringBuilder2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.contact.a$b */
    public static class C26955b {
        String firstName;
        String lastName;
        String middleName;

        public C26955b(String str, String str2, String str3) {
            AppMethodBeat.m2504i(126259);
            this.firstName = C5046bo.nullAsNil(str);
            this.middleName = C5046bo.nullAsNil(str2);
            this.lastName = C5046bo.nullAsNil(str3);
            AppMethodBeat.m2505o(126259);
        }
    }
}
