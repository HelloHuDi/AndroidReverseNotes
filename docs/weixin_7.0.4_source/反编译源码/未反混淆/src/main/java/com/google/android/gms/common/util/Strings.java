package com.google.android.gms.common.util;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@VisibleForTesting
public class Strings {
    private static final Pattern zzaak = Pattern.compile("\\$\\{(.*?)\\}");

    static {
        AppMethodBeat.i(90274);
        AppMethodBeat.o(90274);
    }

    private Strings() {
    }

    public static String capitalize(String str) {
        AppMethodBeat.i(90271);
        if (str.length() == 0) {
            AppMethodBeat.o(90271);
            return str;
        }
        char charAt = str.charAt(0);
        char toUpperCase = Character.toUpperCase(charAt);
        if (charAt == toUpperCase) {
            AppMethodBeat.o(90271);
            return str;
        }
        String substring = str.substring(1);
        str = new StringBuilder(String.valueOf(substring).length() + 1).append(toUpperCase).append(substring).toString();
        AppMethodBeat.o(90271);
        return str;
    }

    public static String emptyToNull(String str) {
        AppMethodBeat.i(90270);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(90270);
            return null;
        }
        AppMethodBeat.o(90270);
        return str;
    }

    public static String format(String str, Bundle bundle) {
        AppMethodBeat.i(90269);
        Matcher matcher = zzaak.matcher(str);
        if (matcher.find()) {
            StringBuffer stringBuffer = new StringBuffer();
            do {
                String group = matcher.group(1);
                Object obj = bundle.get(group);
                if (obj != null) {
                    matcher.appendReplacement(stringBuffer, obj.toString());
                } else if (bundle.containsKey(group)) {
                    matcher.appendReplacement(stringBuffer, BuildConfig.COMMAND);
                } else {
                    matcher.appendReplacement(stringBuffer, "");
                }
            } while (matcher.find());
            matcher.appendTail(stringBuffer);
            str = stringBuffer.toString();
            AppMethodBeat.o(90269);
            return str;
        }
        AppMethodBeat.o(90269);
        return str;
    }

    public static boolean isEmptyOrWhitespace(String str) {
        AppMethodBeat.i(90272);
        if (str == null || str.trim().isEmpty()) {
            AppMethodBeat.o(90272);
            return true;
        }
        AppMethodBeat.o(90272);
        return false;
    }

    public static String nullToEmpty(String str) {
        return str == null ? "" : str;
    }

    public static String padEnd(String str, int i, char c) {
        AppMethodBeat.i(90273);
        Preconditions.checkNotNull(str);
        if (str.length() >= i) {
            AppMethodBeat.o(90273);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(i);
        stringBuilder.append(str);
        for (int length = str.length(); length < i; length++) {
            stringBuilder.append(c);
        }
        str = stringBuilder.toString();
        AppMethodBeat.o(90273);
        return str;
    }
}
