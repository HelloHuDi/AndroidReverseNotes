package com.tencent.luggage.g;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class h {
    public static String bO(String str) {
        AppMethodBeat.i(90909);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(90909);
            return str;
        }
        int indexOf = str.indexOf(63);
        if (indexOf < 0) {
            AppMethodBeat.o(90909);
            return str;
        }
        str = str.substring(0, indexOf);
        AppMethodBeat.o(90909);
        return str;
    }

    public static Map<String, String> bP(String str) {
        AppMethodBeat.i(90910);
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(90910);
            return hashMap;
        }
        int indexOf = str.indexOf(63);
        if (indexOf < 0) {
            AppMethodBeat.o(90910);
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
            AppMethodBeat.o(90910);
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
                AppMethodBeat.o(90910);
                return hashMap;
            }
        }
    }

    public static boolean t(String str, String str2) {
        AppMethodBeat.i(90911);
        if (str == null || str2 == null || str.length() < 0 || str2.length() < 0) {
            AppMethodBeat.o(90911);
            return false;
        } else if (str2.length() > str.length()) {
            AppMethodBeat.o(90911);
            return false;
        } else if (str2.equalsIgnoreCase(str.substring(0, str2.length()))) {
            AppMethodBeat.o(90911);
            return true;
        } else {
            AppMethodBeat.o(90911);
            return false;
        }
    }
}
