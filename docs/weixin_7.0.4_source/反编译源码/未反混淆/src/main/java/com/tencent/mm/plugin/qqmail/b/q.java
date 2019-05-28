package com.tencent.mm.plugin.qqmail.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class q {
    String cEV = null;
    String ptN = null;
    private String[] pur = null;
    private String[] pus = null;
    private String[] put = null;
    String puu = null;
    a[] puv = null;
    a[] puw = null;

    public static class a {
        String fileName;
        int fileSize;
        String name;
        String pux;
    }

    public q(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2) {
        AppMethodBeat.i(67973);
        if (!bo.isNullOrNil(str)) {
            this.cEV = str;
        }
        if (strArr == null || strArr.length <= 0) {
            this.pur = null;
        } else {
            this.pur = strArr;
        }
        if (strArr2 == null || strArr2.length <= 0) {
            this.pus = null;
        } else {
            this.pus = strArr2;
        }
        if (strArr3 == null || strArr3.length <= 0) {
            this.put = null;
        } else {
            this.put = strArr3;
        }
        if (bo.isNullOrNil(str2)) {
            this.ptN = null;
            AppMethodBeat.o(67973);
            return;
        }
        this.ptN = str2;
        AppMethodBeat.o(67973);
    }

    /* Access modifiers changed, original: final */
    public final String ccr() {
        AppMethodBeat.i(67974);
        if (this.pur != null) {
            StringBuilder stringBuilder = new StringBuilder("");
            stringBuilder.append("To: ");
            for (String str : this.pur) {
                stringBuilder.append("\"");
                stringBuilder.append("=?utf-8?B?");
                stringBuilder.append(Base64.encodeToString(str.getBytes(), 2));
                stringBuilder.append("?=");
                stringBuilder.append("\"");
                stringBuilder.append(" ");
                stringBuilder.append("<");
                stringBuilder.append(str);
                stringBuilder.append(">");
                stringBuilder.append(" ,");
            }
            String stringBuilder2 = stringBuilder.toString();
            int lastIndexOf = stringBuilder2.lastIndexOf(" ,");
            if (lastIndexOf != -1) {
                stringBuilder2 = stringBuilder2.substring(0, lastIndexOf);
            }
            AppMethodBeat.o(67974);
            return stringBuilder2;
        }
        AppMethodBeat.o(67974);
        return null;
    }

    /* Access modifiers changed, original: final */
    public final String ccs() {
        AppMethodBeat.i(67975);
        if (this.pus != null) {
            StringBuilder stringBuilder = new StringBuilder("");
            stringBuilder.append("Cc: ");
            for (String str : this.pus) {
                stringBuilder.append("\"");
                stringBuilder.append("=?utf-8?B?");
                stringBuilder.append(Base64.encodeToString(str.getBytes(), 2));
                stringBuilder.append("?=");
                stringBuilder.append("\"");
                stringBuilder.append(" ");
                stringBuilder.append("<");
                stringBuilder.append(str);
                stringBuilder.append(">");
                stringBuilder.append(" ,");
            }
            String stringBuilder2 = stringBuilder.toString();
            int lastIndexOf = stringBuilder2.lastIndexOf(" ,");
            if (lastIndexOf != -1) {
                stringBuilder2 = stringBuilder2.substring(0, lastIndexOf);
            }
            AppMethodBeat.o(67975);
            return stringBuilder2;
        }
        AppMethodBeat.o(67975);
        return null;
    }

    /* Access modifiers changed, original: final */
    public final String cct() {
        AppMethodBeat.i(67976);
        if (this.put != null) {
            StringBuilder stringBuilder = new StringBuilder("");
            stringBuilder.append("Bcc: ");
            for (String str : this.pus) {
                stringBuilder.append("\"");
                stringBuilder.append("=?utf-8?B?");
                stringBuilder.append(Base64.encodeToString(str.getBytes(), 2));
                stringBuilder.append("?=");
                stringBuilder.append("\"");
                stringBuilder.append(" ");
                stringBuilder.append("<");
                stringBuilder.append(str);
                stringBuilder.append(">");
                stringBuilder.append(" ,");
            }
            String stringBuilder2 = stringBuilder.toString();
            int lastIndexOf = stringBuilder2.lastIndexOf(" ,");
            if (lastIndexOf != -1) {
                stringBuilder2 = stringBuilder2.substring(0, lastIndexOf);
            }
            AppMethodBeat.o(67976);
            return stringBuilder2;
        }
        AppMethodBeat.o(67976);
        return null;
    }

    public static String Vk(String str) {
        String x;
        String str2 = null;
        AppMethodBeat.i(67977);
        String str3 = "abEdf4&^^*sxcSD$%&1sdfz@!~AZcT4s322dA%^&&*$##C$%__SDy4d_(*%";
        int length = str3.length();
        try {
            x = g.x((str + "d$3^&xRw%&*_(").getBytes());
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MailContentFormatter", e, "", new Object[0]);
            ab.e("MicroMsg.MailContentFormatter", "attachIdToKey, error:" + e.getLocalizedMessage());
            x = str2;
        }
        char[] cArr = new char[(x.length() * 2)];
        int i = 0;
        for (int i2 = 0; i2 < x.length(); i2++) {
            int i3 = i + 1;
            cArr[i] = x.charAt(i2);
            char charAt = x.charAt(i2);
            i = i3 + 1;
            cArr[i3] = (char) (str3.charAt(charAt % length) + x.charAt(i2));
        }
        try {
            str2 = g.x(new String(cArr).getBytes("ISO-8859-1"));
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.MailContentFormatter", e2, "", new Object[0]);
            ab.e("MicroMsg.MailContentFormatter", "attachIdToKey, error:" + e2.getLocalizedMessage());
        }
        AppMethodBeat.o(67977);
        return str2;
    }
}
