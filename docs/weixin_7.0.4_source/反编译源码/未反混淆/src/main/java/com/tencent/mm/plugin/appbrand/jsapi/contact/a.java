package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class a {
    String bCu;
    String dtV;
    b hHM;
    String hHN;
    a hHO;
    a hHP;
    a hHQ;
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

    public static class a {
        private String country;
        private String dud;
        private String hIa;
        String hIb;
        private String state;

        public a(String str, String str2, String str3, String str4, String str5) {
            AppMethodBeat.i(126257);
            this.country = bo.nullAsNil(str);
            this.state = bo.nullAsNil(str2);
            this.dud = bo.nullAsNil(str3);
            this.hIa = bo.nullAsNil(str4);
            this.hIb = bo.nullAsNil(str5);
            AppMethodBeat.o(126257);
        }

        public final String aDu() {
            AppMethodBeat.i(126258);
            StringBuilder stringBuilder;
            String stringBuilder2;
            if (bo.amT(this.country) || bo.amT(this.state) || bo.amT(this.dud) || bo.amT(this.hIa) || bo.amT(this.hIb)) {
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
                AppMethodBeat.o(126258);
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
            AppMethodBeat.o(126258);
            return stringBuilder2;
        }
    }

    public static class b {
        String firstName;
        String lastName;
        String middleName;

        public b(String str, String str2, String str3) {
            AppMethodBeat.i(126259);
            this.firstName = bo.nullAsNil(str);
            this.middleName = bo.nullAsNil(str2);
            this.lastName = bo.nullAsNil(str3);
            AppMethodBeat.o(126259);
        }
    }
}
