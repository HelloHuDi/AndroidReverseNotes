package com.google.android.gms.common.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class GmsVersionParser {
    public static final int UNKNOWN = -1;
    private static Pattern zzzy = null;

    private GmsVersionParser() {
    }

    public static int parseBuildMajorVersion(int i) {
        return i == -1 ? -1 : i / 100000;
    }

    public static long parseBuildNumber(String str) {
        long j = -1;
        AppMethodBeat.m2504i(90197);
        if (str == null) {
            AppMethodBeat.m2505o(90197);
        } else {
            Matcher matcher = zzdc().matcher(str);
            if (matcher.find()) {
                try {
                    j = Long.parseLong(matcher.group(2));
                    AppMethodBeat.m2505o(90197);
                } catch (NumberFormatException e) {
                }
            }
            AppMethodBeat.m2505o(90197);
        }
        return j;
    }

    public static int parseBuildType(String str) {
        AppMethodBeat.m2504i(90199);
        long parseVariantCode = parseVariantCode(str);
        if (parseVariantCode == -1) {
            AppMethodBeat.m2505o(90199);
            return -1;
        }
        int i = (int) (parseVariantCode / 10000);
        AppMethodBeat.m2505o(90199);
        return i;
    }

    public static int parseBuildVersion(int i) {
        return i == -1 ? -1 : i / 1000;
    }

    public static int parseScreenDensity(String str) {
        AppMethodBeat.m2504i(90201);
        long parseVariantCode = parseVariantCode(str);
        if (parseVariantCode == -1) {
            AppMethodBeat.m2505o(90201);
            return -1;
        }
        int i = (int) (parseVariantCode % 100);
        AppMethodBeat.m2505o(90201);
        return i;
    }

    public static int parseTargetArchitecture(String str) {
        AppMethodBeat.m2504i(90200);
        long parseVariantCode = parseVariantCode(str);
        if (parseVariantCode == -1) {
            AppMethodBeat.m2505o(90200);
            return -1;
        }
        int i = (int) ((parseVariantCode / 100) % 100);
        AppMethodBeat.m2505o(90200);
        return i;
    }

    public static long parseVariantCode(String str) {
        long j = -1;
        AppMethodBeat.m2504i(90198);
        if (str == null) {
            AppMethodBeat.m2505o(90198);
        } else {
            Matcher matcher = zzdc().matcher(str);
            if (matcher.find()) {
                try {
                    j = Long.parseLong(matcher.group(1));
                    AppMethodBeat.m2505o(90198);
                } catch (NumberFormatException e) {
                }
            }
            AppMethodBeat.m2505o(90198);
        }
        return j;
    }

    private static Pattern zzdc() {
        AppMethodBeat.m2504i(90196);
        if (zzzy == null) {
            zzzy = Pattern.compile("\\((?:eng-)?(\\d+)-(.+?)[-)$]");
        }
        Pattern pattern = zzzy;
        AppMethodBeat.m2505o(90196);
        return pattern;
    }
}
