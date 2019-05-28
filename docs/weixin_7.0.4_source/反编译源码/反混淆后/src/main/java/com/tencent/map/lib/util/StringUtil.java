package com.tencent.map.lib.util;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class StringUtil {
    /* renamed from: a */
    private static SimpleDateFormat f4312a = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

    static {
        AppMethodBeat.m2504i(98227);
        AppMethodBeat.m2505o(98227);
    }

    public static boolean isEmpty(String str) {
        AppMethodBeat.m2504i(98213);
        if (str == null || str.trim().length() == 0) {
            AppMethodBeat.m2505o(98213);
            return true;
        }
        AppMethodBeat.m2505o(98213);
        return false;
    }

    public static boolean isMatched(String str, String str2) {
        AppMethodBeat.m2504i(98214);
        if (str2 == null || str == null) {
            AppMethodBeat.m2505o(98214);
            return false;
        } else if (str2.indexOf(str) == 0) {
            AppMethodBeat.m2505o(98214);
            return true;
        } else {
            AppMethodBeat.m2505o(98214);
            return false;
        }
    }

    public static boolean isContains(String str, String str2) {
        AppMethodBeat.m2504i(98215);
        if (str2 == null || str == null) {
            AppMethodBeat.m2505o(98215);
            return false;
        }
        boolean contains = str2.contains(str);
        AppMethodBeat.m2505o(98215);
        return contains;
    }

    public static CharSequence buildMulColorText(String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(98216);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(strArr[i]);
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(iArr[i]), 0, spannableStringBuilder2.length(), 33);
            spannableStringBuilder.append(spannableStringBuilder2);
        }
        AppMethodBeat.m2505o(98216);
        return spannableStringBuilder;
    }

    public static String toUTF8(String str) {
        AppMethodBeat.m2504i(98217);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.m2505o(98217);
            return str2;
        }
        try {
            str2 = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
            AppMethodBeat.m2505o(98217);
            return str2;
        } catch (Exception e) {
            str2 = "";
            AppMethodBeat.m2505o(98217);
            return str2;
        }
    }

    public static String fromUTF8(String str) {
        AppMethodBeat.m2504i(98218);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.m2505o(98218);
            return str2;
        }
        try {
            str2 = URLDecoder.decode(str, ProtocolPackage.ServerEncoding);
            AppMethodBeat.m2505o(98218);
            return str2;
        } catch (Exception e) {
            str2 = "";
            AppMethodBeat.m2505o(98218);
            return str2;
        }
    }

    public static String toGBK(String str) {
        AppMethodBeat.m2504i(98219);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.m2505o(98219);
            return str2;
        }
        try {
            str2 = URLEncoder.encode(str, "gbk");
            AppMethodBeat.m2505o(98219);
            return str2;
        } catch (UnsupportedEncodingException e) {
            str2 = "";
            AppMethodBeat.m2505o(98219);
            return str2;
        }
    }

    public static String bytesToHexString(byte[] bArr) {
        AppMethodBeat.m2504i(98220);
        if (bArr == null || bArr.length <= 0) {
            AppMethodBeat.m2505o(98220);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(256);
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(toHexString);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(98220);
        return stringBuilder2;
    }

    public static boolean isWordLikeMyLocation(String str) {
        AppMethodBeat.m2504i(98221);
        if (isEmpty(str)) {
            AppMethodBeat.m2505o(98221);
            return false;
        } else if (str.equals("我的位置") || str.equals("当前位置") || str.equals("我在哪") || str.equals("我在哪儿") || str.equals("我在的位置") || str.equals("我的位置在哪") || str.equals("我的位置在哪儿")) {
            AppMethodBeat.m2505o(98221);
            return true;
        } else {
            AppMethodBeat.m2505o(98221);
            return false;
        }
    }

    public static boolean isNumber(String str) {
        AppMethodBeat.m2504i(98222);
        try {
            boolean matches = Pattern.compile("[0-9]*").matcher(str).matches();
            AppMethodBeat.m2505o(98222);
            return matches;
        } catch (Exception e) {
            AppMethodBeat.m2505o(98222);
            return false;
        }
    }

    public static int compareVersion(String str, String str2) {
        AppMethodBeat.m2504i(98223);
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int i = 0;
        while (true) {
            int i2;
            if (i < (split.length > split2.length ? split2.length : split.length)) {
                int intValue = Integer.valueOf(split[i]).intValue();
                int intValue2 = Integer.valueOf(split2[i]).intValue();
                if (intValue - intValue2 != 0) {
                    i2 = intValue - intValue2;
                    AppMethodBeat.m2505o(98223);
                    return i2;
                }
                i++;
            } else if (split.length != split2.length) {
                i2 = split.length - split2.length;
                AppMethodBeat.m2505o(98223);
                return i2;
            } else {
                AppMethodBeat.m2505o(98223);
                return 0;
            }
        }
    }

    public static String toDateFormat(long j) {
        AppMethodBeat.m2504i(98224);
        String format = f4312a.format(Long.valueOf(j));
        AppMethodBeat.m2505o(98224);
        return format;
    }

    public static boolean isEqual(String str, String str2) {
        AppMethodBeat.m2504i(98225);
        boolean equals;
        if (str == str2) {
            AppMethodBeat.m2505o(98225);
            return true;
        } else if (str != null) {
            equals = str.equals(str2);
            AppMethodBeat.m2505o(98225);
            return equals;
        } else if (str2 != null) {
            equals = str2.equals(str);
            AppMethodBeat.m2505o(98225);
            return equals;
        } else {
            AppMethodBeat.m2505o(98225);
            return false;
        }
    }

    public static String removeSuffix(String str) {
        AppMethodBeat.m2504i(98226);
        if (isEmpty(str)) {
            AppMethodBeat.m2505o(98226);
            return str;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf > 0) {
            str = str.substring(0, lastIndexOf);
            AppMethodBeat.m2505o(98226);
            return str;
        }
        AppMethodBeat.m2505o(98226);
        return str;
    }
}
