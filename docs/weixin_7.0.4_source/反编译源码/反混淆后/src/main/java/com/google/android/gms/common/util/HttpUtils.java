package com.google.android.gms.common.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HttpUtils {
    private static final Pattern zzaab = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    private static final Pattern zzaac = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    private static final Pattern zzaad = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    static {
        AppMethodBeat.m2504i(90217);
        AppMethodBeat.m2505o(90217);
    }

    private HttpUtils() {
    }

    private static String decode(String str, String str2) {
        AppMethodBeat.m2504i(90212);
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            String decode = URLDecoder.decode(str, str2);
            AppMethodBeat.m2505o(90212);
            return decode;
        } catch (UnsupportedEncodingException e) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(e);
            AppMethodBeat.m2505o(90212);
            throw illegalArgumentException;
        }
    }

    public static boolean isIPv4Address(String str) {
        AppMethodBeat.m2504i(90213);
        boolean matches = zzaab.matcher(str).matches();
        AppMethodBeat.m2505o(90213);
        return matches;
    }

    public static boolean isIPv6Address(String str) {
        AppMethodBeat.m2504i(90216);
        if (isIPv6StdAddress(str) || isIPv6HexCompressedAddress(str)) {
            AppMethodBeat.m2505o(90216);
            return true;
        }
        AppMethodBeat.m2505o(90216);
        return false;
    }

    public static boolean isIPv6HexCompressedAddress(String str) {
        AppMethodBeat.m2504i(90215);
        boolean matches = zzaad.matcher(str).matches();
        AppMethodBeat.m2505o(90215);
        return matches;
    }

    public static boolean isIPv6StdAddress(String str) {
        AppMethodBeat.m2504i(90214);
        boolean matches = zzaac.matcher(str).matches();
        AppMethodBeat.m2505o(90214);
        return matches;
    }

    public static Map<String, String> parse(URI uri, String str) {
        AppMethodBeat.m2504i(90211);
        Map<String, String> emptyMap = Collections.emptyMap();
        String rawQuery = uri.getRawQuery();
        if (rawQuery != null && rawQuery.length() > 0) {
            HashMap hashMap = new HashMap();
            Scanner scanner = new Scanner(rawQuery);
            scanner.useDelimiter("&");
            while (scanner.hasNext()) {
                String[] split = scanner.next().split("=");
                if (split.length == 0 || split.length > 2) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("bad parameter");
                    AppMethodBeat.m2505o(90211);
                    throw illegalArgumentException;
                }
                String decode = decode(split[0], str);
                Object obj = null;
                if (split.length == 2) {
                    obj = decode(split[1], str);
                }
                hashMap.put(decode, obj);
            }
            emptyMap = hashMap;
        }
        AppMethodBeat.m2505o(90211);
        return emptyMap;
    }
}
