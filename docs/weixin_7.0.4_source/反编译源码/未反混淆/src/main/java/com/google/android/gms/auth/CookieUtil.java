package com.google.android.gms.auth;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CookieUtil {
    private CookieUtil() {
    }

    public static String getCookieUrl(String str, Boolean bool) {
        AppMethodBeat.i(76936);
        Preconditions.checkNotEmpty(str);
        Object obj = zzd(bool) ? "https" : "http";
        String stringBuilder = new StringBuilder((String.valueOf(obj).length() + 3) + String.valueOf(str).length()).append(obj).append("://").append(str).toString();
        AppMethodBeat.o(76936);
        return stringBuilder;
    }

    public static String getCookieValue(String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, Long l) {
        AppMethodBeat.i(76937);
        StringBuilder append = new StringBuilder(str).append('=');
        if (!TextUtils.isEmpty(str2)) {
            append.append(str2);
        }
        if (zzd(bool)) {
            append.append(";HttpOnly");
        }
        if (zzd(bool2)) {
            append.append(";Secure");
        }
        if (!TextUtils.isEmpty(str3)) {
            append.append(";Domain=").append(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            append.append(";Path=").append(str4);
        }
        if (l != null && l.longValue() > 0) {
            append.append(";Max-Age=").append(l);
        }
        String stringBuilder = append.toString();
        AppMethodBeat.o(76937);
        return stringBuilder;
    }

    private static boolean zzd(Boolean bool) {
        AppMethodBeat.i(76935);
        if (bool == null || !bool.booleanValue()) {
            AppMethodBeat.o(76935);
            return false;
        }
        AppMethodBeat.o(76935);
        return true;
    }
}
