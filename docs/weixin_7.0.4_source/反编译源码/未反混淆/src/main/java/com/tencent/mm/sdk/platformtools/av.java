package com.tencent.mm.sdk.platformtools;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.aw.b;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class av {
    public static aw xAC = null;

    public static String hR(String str, String str2) {
        AppMethodBeat.i(52202);
        String replace = amN(str).replace("+", "");
        if (xAC == null) {
            xAC = new aw();
        }
        int length;
        String str3;
        if (bo.isNullOrNil(str2)) {
            for (a aVar : xAC.xAD) {
                if (replace.startsWith(aVar.xAF)) {
                    length = replace.length() - aVar.xAF.length();
                    if (length >= aVar.xAG && length <= aVar.xAH) {
                        ab.i("MicroMsg.PhoneFormater", "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", aVar.xAF, aVar.xAE, Integer.valueOf(aVar.xAH), Integer.valueOf(aVar.xAH));
                        str3 = aVar.xAF;
                        AppMethodBeat.o(52202);
                        return str3;
                    }
                }
            }
        } else {
            for (a aVar2 : xAC.xAD) {
                if (replace.startsWith(aVar2.xAF)) {
                    length = replace.length() - aVar2.xAF.length();
                    if (length >= aVar2.xAG && length <= aVar2.xAH && str2.equalsIgnoreCase(aVar2.xAE)) {
                        ab.i("MicroMsg.PhoneFormater", "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", aVar2.xAF, aVar2.xAE, Integer.valueOf(aVar2.xAH), Integer.valueOf(aVar2.xAH));
                        str3 = aVar2.xAF;
                        AppMethodBeat.o(52202);
                        return str3;
                    }
                }
            }
        }
        AppMethodBeat.o(52202);
        return null;
    }

    public static String Ps(String str) {
        AppMethodBeat.i(52203);
        String hR = hR(str, null);
        AppMethodBeat.o(52203);
        return hR;
    }

    public static String amM(String str) {
        AppMethodBeat.i(52204);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(52204);
            return str;
        } else if (bo.ant(str).booleanValue()) {
            av avVar = new av();
            String str2 = "86";
            if (str.startsWith("+")) {
                str = str.replace("+", "");
                str2 = hR(str, null);
                if (str2 != null) {
                    str = str.substring(str2.length());
                }
            }
            str = formatNumber(str2, str);
            AppMethodBeat.o(52204);
            return str;
        } else {
            AppMethodBeat.o(52204);
            return str;
        }
    }

    public static String amN(String str) {
        AppMethodBeat.i(52205);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(52205);
            return str2;
        }
        str2 = str.replaceAll("[\\.\\-\\ ]", "").trim();
        AppMethodBeat.o(52205);
        return str2;
    }

    public static String amO(String str) {
        AppMethodBeat.i(52206);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(52206);
            return str2;
        }
        str2 = str.replace("+", "");
        AppMethodBeat.o(52206);
        return str2;
    }

    public static String amP(String str) {
        AppMethodBeat.i(52207);
        if (bo.isNullOrNil(str)) {
            str = "";
            AppMethodBeat.o(52207);
            return str;
        } else if (str.startsWith("+")) {
            AppMethodBeat.o(52207);
            return str;
        } else {
            str = "+".concat(String.valueOf(str));
            AppMethodBeat.o(52207);
            return str;
        }
    }

    public static String hS(String str, String str2) {
        AppMethodBeat.i(52208);
        String str3;
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            str3 = "";
            AppMethodBeat.o(52208);
            return str3;
        }
        str3 = str + "（+" + str2 + "）";
        AppMethodBeat.o(52208);
        return str3;
    }

    public static String formatNumber(String str, String str2) {
        AppMethodBeat.i(52209);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            AppMethodBeat.o(52209);
            return str2;
        }
        if (xAC == null) {
            xAC = new aw();
        }
        for (a aVar : xAC.xAD) {
            if (!(aVar.xAF == null || !str.trim().toLowerCase().equals(aVar.xAF.trim().toLowerCase()) || aVar.xAI == null)) {
                String amN = amN(str2);
                if (amN == null || amN.length() <= aVar.xAG) {
                    for (b bVar : aVar.xAI) {
                        int i;
                        int i2;
                        char charAt;
                        StringBuffer stringBuffer;
                        int length;
                        if (bo.isNullOrNil(bVar.xAJ)) {
                            if (aVar.xAI.size() > 1) {
                                StringBuffer stringBuffer2 = new StringBuffer();
                                stringBuffer2.append(amN);
                                int length2 = amN.length();
                                if (length2 <= ei(bVar.xAL, aVar.xAH)) {
                                    while (stringBuffer2.toString().length() < aVar.xAH) {
                                        stringBuffer2.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                                    }
                                    amN = aA(bVar.xAL, bVar.xAK, stringBuffer2.toString());
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
                                    AppMethodBeat.o(52209);
                                    return amN;
                                }
                            } else {
                                stringBuffer = new StringBuffer();
                                stringBuffer.append(amN);
                                length = amN.length();
                                while (stringBuffer.toString().length() < aVar.xAH) {
                                    stringBuffer.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                                }
                                String aA = aA(bVar.xAL, bVar.xAK, stringBuffer.toString());
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
                                AppMethodBeat.o(52209);
                                return aA;
                            }
                        } else if (Pattern.compile(bVar.xAJ).matcher(amN).lookingAt()) {
                            stringBuffer = new StringBuffer();
                            stringBuffer.append(amN);
                            length = amN.length();
                            while (stringBuffer.toString().length() < aVar.xAH) {
                                stringBuffer.append(amN.charAt(length - 1));
                            }
                            amN = aA(bVar.xAL, bVar.xAK, stringBuffer.toString());
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
                            AppMethodBeat.o(52209);
                            return amN;
                        }
                    }
                    continue;
                } else {
                    AppMethodBeat.o(52209);
                    return amN;
                }
            }
        }
        AppMethodBeat.o(52209);
        return str2;
    }

    private static int ei(String str, int i) {
        AppMethodBeat.i(52210);
        Pattern compile = Pattern.compile(str);
        CharSequence charSequence = "1";
        int i2 = 0;
        while (i2 < i && !compile.matcher(charSequence).find()) {
            charSequence = charSequence + "1";
            i2++;
        }
        i2++;
        AppMethodBeat.o(52210);
        return i2;
    }

    private static String aA(String str, String str2, String str3) {
        AppMethodBeat.i(52211);
        Matcher matcher = Pattern.compile(str).matcher(str3);
        if (matcher.find()) {
            str3 = matcher.replaceAll(str2);
            AppMethodBeat.o(52211);
            return str3;
        }
        AppMethodBeat.o(52211);
        return str3;
    }
}
