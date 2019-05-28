package com.tencent.luggage.p147g;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.luggage.g.h */
public final class C8874h {
    /* renamed from: bO */
    public static String m15847bO(String str) {
        AppMethodBeat.m2504i(90909);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(90909);
            return str;
        }
        int indexOf = str.indexOf(63);
        if (indexOf < 0) {
            AppMethodBeat.m2505o(90909);
            return str;
        }
        str = str.substring(0, indexOf);
        AppMethodBeat.m2505o(90909);
        return str;
    }

    /* renamed from: bP */
    public static Map<String, String> m15848bP(String str) {
        AppMethodBeat.m2504i(90910);
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(90910);
            return hashMap;
        }
        int indexOf = str.indexOf(63);
        if (indexOf < 0) {
            AppMethodBeat.m2505o(90910);
            return hashMap;
        }
        CharSequence substring;
        indexOf++;
        int lastIndexOf = str.lastIndexOf(38);
        int lastIndexOf2 = str.lastIndexOf(35);
        if (lastIndexOf2 < 0 || lastIndexOf2 <= lastIndexOf) {
            substring = str.substring(indexOf, str.length());
        } else {
            substring = str.substring(indexOf, lastIndexOf2);
        }
        if (TextUtils.isEmpty(substring)) {
            AppMethodBeat.m2505o(90910);
            return hashMap;
        }
        lastIndexOf = 0;
        int length = substring.length();
        while (true) {
            Object obj;
            int indexOf2 = substring.indexOf(38, lastIndexOf);
            lastIndexOf2 = indexOf2 != -1 ? indexOf2 : length;
            int indexOf3 = substring.indexOf(61, lastIndexOf);
            if (indexOf3 > lastIndexOf2 || indexOf3 == -1) {
                indexOf3 = lastIndexOf2;
            }
            String decode = Uri.decode(substring.substring(lastIndexOf, indexOf3));
            if (indexOf3 == lastIndexOf2) {
                obj = "";
            } else {
                obj = substring.substring(indexOf3 + 1, lastIndexOf2);
            }
            hashMap.put(decode, obj);
            if (indexOf2 != -1) {
                lastIndexOf = indexOf2 + 1;
            } else {
                AppMethodBeat.m2505o(90910);
                return hashMap;
            }
        }
    }

    /* renamed from: t */
    public static boolean m15849t(String str, String str2) {
        AppMethodBeat.m2504i(90911);
        if (str == null || str2 == null || str.length() < 0 || str2.length() < 0) {
            AppMethodBeat.m2505o(90911);
            return false;
        } else if (str2.length() > str.length()) {
            AppMethodBeat.m2505o(90911);
            return false;
        } else if (str2.equalsIgnoreCase(str.substring(0, str2.length()))) {
            AppMethodBeat.m2505o(90911);
            return true;
        } else {
            AppMethodBeat.m2505o(90911);
            return false;
        }
    }
}
