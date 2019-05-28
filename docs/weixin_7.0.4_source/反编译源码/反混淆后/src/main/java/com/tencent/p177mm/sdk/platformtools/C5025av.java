package com.tencent.p177mm.sdk.platformtools;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5028aw.C5026a;
import com.tencent.p177mm.sdk.platformtools.C5028aw.C5027b;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.sdk.platformtools.av */
public final class C5025av {
    public static C5028aw xAC = null;

    /* renamed from: hR */
    public static String m7484hR(String str, String str2) {
        AppMethodBeat.m2504i(52202);
        String replace = C5025av.amN(str).replace("+", "");
        if (xAC == null) {
            xAC = new C5028aw();
        }
        int length;
        String str3;
        if (C5046bo.isNullOrNil(str2)) {
            for (C5026a c5026a : xAC.xAD) {
                if (replace.startsWith(c5026a.xAF)) {
                    length = replace.length() - c5026a.xAF.length();
                    if (length >= c5026a.xAG && length <= c5026a.xAH) {
                        C4990ab.m7417i("MicroMsg.PhoneFormater", "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", c5026a.xAF, c5026a.xAE, Integer.valueOf(c5026a.xAH), Integer.valueOf(c5026a.xAH));
                        str3 = c5026a.xAF;
                        AppMethodBeat.m2505o(52202);
                        return str3;
                    }
                }
            }
        } else {
            for (C5026a c5026a2 : xAC.xAD) {
                if (replace.startsWith(c5026a2.xAF)) {
                    length = replace.length() - c5026a2.xAF.length();
                    if (length >= c5026a2.xAG && length <= c5026a2.xAH && str2.equalsIgnoreCase(c5026a2.xAE)) {
                        C4990ab.m7417i("MicroMsg.PhoneFormater", "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", c5026a2.xAF, c5026a2.xAE, Integer.valueOf(c5026a2.xAH), Integer.valueOf(c5026a2.xAH));
                        str3 = c5026a2.xAF;
                        AppMethodBeat.m2505o(52202);
                        return str3;
                    }
                }
            }
        }
        AppMethodBeat.m2505o(52202);
        return null;
    }

    /* renamed from: Ps */
    public static String m7481Ps(String str) {
        AppMethodBeat.m2504i(52203);
        String hR = C5025av.m7484hR(str, null);
        AppMethodBeat.m2505o(52203);
        return hR;
    }

    public static String amM(String str) {
        AppMethodBeat.m2504i(52204);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(52204);
            return str;
        } else if (C5046bo.ant(str).booleanValue()) {
            C5025av c5025av = new C5025av();
            String str2 = "86";
            if (str.startsWith("+")) {
                str = str.replace("+", "");
                str2 = C5025av.m7484hR(str, null);
                if (str2 != null) {
                    str = str.substring(str2.length());
                }
            }
            str = C5025av.formatNumber(str2, str);
            AppMethodBeat.m2505o(52204);
            return str;
        } else {
            AppMethodBeat.m2505o(52204);
            return str;
        }
    }

    public static String amN(String str) {
        AppMethodBeat.m2504i(52205);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(52205);
            return str2;
        }
        str2 = str.replaceAll("[\\.\\-\\ ]", "").trim();
        AppMethodBeat.m2505o(52205);
        return str2;
    }

    public static String amO(String str) {
        AppMethodBeat.m2504i(52206);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(52206);
            return str2;
        }
        str2 = str.replace("+", "");
        AppMethodBeat.m2505o(52206);
        return str2;
    }

    public static String amP(String str) {
        AppMethodBeat.m2504i(52207);
        if (C5046bo.isNullOrNil(str)) {
            str = "";
            AppMethodBeat.m2505o(52207);
            return str;
        } else if (str.startsWith("+")) {
            AppMethodBeat.m2505o(52207);
            return str;
        } else {
            str = "+".concat(String.valueOf(str));
            AppMethodBeat.m2505o(52207);
            return str;
        }
    }

    /* renamed from: hS */
    public static String m7485hS(String str, String str2) {
        AppMethodBeat.m2504i(52208);
        String str3;
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            str3 = "";
            AppMethodBeat.m2505o(52208);
            return str3;
        }
        str3 = str + "（+" + str2 + "）";
        AppMethodBeat.m2505o(52208);
        return str3;
    }

    public static String formatNumber(String str, String str2) {
        AppMethodBeat.m2504i(52209);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(52209);
            return str2;
        }
        if (xAC == null) {
            xAC = new C5028aw();
        }
        for (C5026a c5026a : xAC.xAD) {
            if (!(c5026a.xAF == null || !str.trim().toLowerCase().equals(c5026a.xAF.trim().toLowerCase()) || c5026a.xAI == null)) {
                String amN = C5025av.amN(str2);
                if (amN == null || amN.length() <= c5026a.xAG) {
                    for (C5027b c5027b : c5026a.xAI) {
                        int i;
                        int i2;
                        char charAt;
                        StringBuffer stringBuffer;
                        int length;
                        if (C5046bo.isNullOrNil(c5027b.xAJ)) {
                            if (c5026a.xAI.size() > 1) {
                                StringBuffer stringBuffer2 = new StringBuffer();
                                stringBuffer2.append(amN);
                                int length2 = amN.length();
                                if (length2 <= C5025av.m7483ei(c5027b.xAL, c5026a.xAH)) {
                                    while (stringBuffer2.toString().length() < c5026a.xAH) {
                                        stringBuffer2.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                                    }
                                    amN = C5025av.m7482aA(c5027b.xAL, c5027b.xAK, stringBuffer2.toString());
                                    i = 0;
                                    for (i2 = 0; i2 < amN.length(); i2++) {
                                        charAt = amN.charAt(i2);
                                        if (i >= length2) {
                                            amN = amN.substring(0, i2);
                                        }
                                        if (!(charAt == ' ' || charAt == '-' || charAt == 12290)) {
                                            i++;
                                        }
                                    }
                                    AppMethodBeat.m2505o(52209);
                                    return amN;
                                }
                            } else {
                                stringBuffer = new StringBuffer();
                                stringBuffer.append(amN);
                                length = amN.length();
                                while (stringBuffer.toString().length() < c5026a.xAH) {
                                    stringBuffer.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                                }
                                String aA = C5025av.m7482aA(c5027b.xAL, c5027b.xAK, stringBuffer.toString());
                                i = 0;
                                for (int i3 = 0; i3 < aA.length(); i3++) {
                                    charAt = aA.charAt(i3);
                                    if (i >= length) {
                                        aA = aA.substring(0, i3);
                                    }
                                    if (!(charAt == ' ' || charAt == '-' || charAt == 12290)) {
                                        i++;
                                    }
                                }
                                AppMethodBeat.m2505o(52209);
                                return aA;
                            }
                        } else if (Pattern.compile(c5027b.xAJ).matcher(amN).lookingAt()) {
                            stringBuffer = new StringBuffer();
                            stringBuffer.append(amN);
                            length = amN.length();
                            while (stringBuffer.toString().length() < c5026a.xAH) {
                                stringBuffer.append(amN.charAt(length - 1));
                            }
                            amN = C5025av.m7482aA(c5027b.xAL, c5027b.xAK, stringBuffer.toString());
                            i = 0;
                            for (i2 = 0; i2 < amN.length(); i2++) {
                                charAt = amN.charAt(i2);
                                if (i >= length) {
                                    amN = amN.substring(0, i2);
                                }
                                if (!(charAt == ' ' || charAt == '-' || charAt == 12290)) {
                                    i++;
                                }
                            }
                            AppMethodBeat.m2505o(52209);
                            return amN;
                        }
                    }
                    continue;
                } else {
                    AppMethodBeat.m2505o(52209);
                    return amN;
                }
            }
        }
        AppMethodBeat.m2505o(52209);
        return str2;
    }

    /* renamed from: ei */
    private static int m7483ei(String str, int i) {
        AppMethodBeat.m2504i(52210);
        Pattern compile = Pattern.compile(str);
        CharSequence charSequence = "1";
        int i2 = 0;
        while (i2 < i && !compile.matcher(charSequence).find()) {
            charSequence = charSequence + "1";
            i2++;
        }
        i2++;
        AppMethodBeat.m2505o(52210);
        return i2;
    }

    /* renamed from: aA */
    private static String m7482aA(String str, String str2, String str3) {
        AppMethodBeat.m2504i(52211);
        Matcher matcher = Pattern.compile(str).matcher(str3);
        if (matcher.find()) {
            str3 = matcher.replaceAll(str2);
            AppMethodBeat.m2505o(52211);
            return str3;
        }
        AppMethodBeat.m2505o(52211);
        return str3;
    }
}
