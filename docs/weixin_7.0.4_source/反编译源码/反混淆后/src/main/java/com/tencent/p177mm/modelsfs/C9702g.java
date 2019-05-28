package com.tencent.p177mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.EnumSet;

/* renamed from: com.tencent.mm.modelsfs.g */
final class C9702g {

    /* renamed from: com.tencent.mm.modelsfs.g$a */
    public enum C9701a {
        NOESCAPE,
        PATHNAME,
        PERIOD,
        LEADING_DIR,
        CASEFOLD;

        static {
            AppMethodBeat.m2505o(93207);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x008f A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static boolean m17277a(String str, int i, String str2, int i2, EnumSet<C9701a> enumSet) {
        AppMethodBeat.m2504i(93208);
        while (i < str.length()) {
            int i3 = i + 1;
            char charAt = str.charAt(i);
            switch (charAt) {
                case '*':
                    char charAt2;
                    i = i3;
                    while (i < str.length()) {
                        charAt2 = str.charAt(i);
                        if (charAt2 == '*') {
                            i++;
                            charAt = charAt2;
                        } else if (!C9702g.m17278a(str2, i2, enumSet)) {
                            AppMethodBeat.m2505o(93208);
                            return false;
                        } else if (i == str.length()) {
                            if (!enumSet.contains(C9701a.PATHNAME)) {
                                AppMethodBeat.m2505o(93208);
                                return true;
                            } else if (enumSet.contains(C9701a.LEADING_DIR) || str2.indexOf(47, i2) == -1) {
                                AppMethodBeat.m2505o(93208);
                                return true;
                            } else {
                                AppMethodBeat.m2505o(93208);
                                return false;
                            }
                        } else if (charAt2 == IOUtils.DIR_SEPARATOR_UNIX && enumSet.contains(C9701a.PATHNAME)) {
                            i2 = str2.indexOf(47, i2);
                            if (i2 == -1) {
                                AppMethodBeat.m2505o(93208);
                                return false;
                            }
                            continue;
                        } else {
                            while (i2 < str2.length()) {
                                EnumSet enumSet2;
                                if (enumSet2.contains(C9701a.PERIOD)) {
                                    enumSet2 = EnumSet.copyOf(enumSet2);
                                    enumSet2.remove(C9701a.PERIOD);
                                }
                                if (C9702g.m17277a(str, i, str2, i2, enumSet2)) {
                                    AppMethodBeat.m2505o(93208);
                                    return true;
                                } else if (str2.charAt(i2) == IOUtils.DIR_SEPARATOR_UNIX && enumSet2.contains(C9701a.PATHNAME)) {
                                    AppMethodBeat.m2505o(93208);
                                    return false;
                                } else {
                                    i2++;
                                }
                            }
                            AppMethodBeat.m2505o(93208);
                            return false;
                        }
                    }
                    charAt2 = charAt;
                    if (!C9702g.m17278a(str2, i2, enumSet2)) {
                    }
                    break;
                case '?':
                    if (i2 >= str2.length()) {
                        AppMethodBeat.m2505o(93208);
                        return false;
                    } else if (str2.charAt(i2) == IOUtils.DIR_SEPARATOR_UNIX && enumSet2.contains(C9701a.PATHNAME)) {
                        AppMethodBeat.m2505o(93208);
                        return false;
                    } else if (C9702g.m17278a(str2, i2, enumSet2)) {
                        AppMethodBeat.m2505o(93208);
                        return false;
                    } else {
                        i2++;
                        i = i3;
                        continue;
                    }
                case PlayerException.EXCEPTION_IN_PREPARE /*91*/:
                    if (i2 >= str2.length()) {
                        AppMethodBeat.m2505o(93208);
                        return false;
                    } else if (str2.charAt(i2) == IOUtils.DIR_SEPARATOR_UNIX && enumSet2.contains(C9701a.PATHNAME)) {
                        AppMethodBeat.m2505o(93208);
                        return false;
                    } else if (C9702g.m17278a(str2, i2, enumSet2)) {
                        AppMethodBeat.m2505o(93208);
                        return false;
                    } else {
                        i = C9702g.m17276a(str, i3, str2.charAt(i2), enumSet2);
                        if (i != -1) {
                            if (i == 0) {
                                AppMethodBeat.m2505o(93208);
                                return false;
                            }
                            i2++;
                            continue;
                        }
                    }
                    break;
                case '\\':
                    if (!enumSet2.contains(C9701a.NOESCAPE)) {
                        if (i3 < str.length()) {
                            i = i3 + 1;
                            charAt = str.charAt(i3);
                            break;
                        }
                        charAt = IOUtils.DIR_SEPARATOR_WINDOWS;
                        i = i3;
                        break;
                    }
            }
            i = i3;
            if (i2 >= str2.length()) {
                AppMethodBeat.m2505o(93208);
                return false;
            } else if (charAt == str2.charAt(i2) || (enumSet2.contains(C9701a.CASEFOLD) && Character.toLowerCase(charAt) == Character.toLowerCase(str2.charAt(i2)))) {
                i2++;
            } else {
                AppMethodBeat.m2505o(93208);
                return false;
            }
        }
        if (enumSet2.contains(C9701a.LEADING_DIR) && str2.charAt(i2) == IOUtils.DIR_SEPARATOR_UNIX) {
            AppMethodBeat.m2505o(93208);
            return true;
        } else if (i2 == str2.length()) {
            AppMethodBeat.m2505o(93208);
            return true;
        } else {
            AppMethodBeat.m2505o(93208);
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m17278a(String str, int i, EnumSet<C9701a> enumSet) {
        AppMethodBeat.m2504i(93209);
        if (i > str.length() - 1) {
            AppMethodBeat.m2505o(93209);
            return false;
        } else if ((i == 0 || (enumSet.contains(C9701a.PATHNAME) && str.charAt(i - 1) == IOUtils.DIR_SEPARATOR_UNIX)) && str.charAt(i) == '.' && enumSet.contains(C9701a.PERIOD)) {
            AppMethodBeat.m2505o(93209);
            return true;
        } else {
            AppMethodBeat.m2505o(93209);
            return false;
        }
    }

    /* renamed from: a */
    private static int m17276a(String str, int i, char c, EnumSet<C9701a> enumSet) {
        AppMethodBeat.m2504i(93210);
        if (i >= str.length()) {
            AppMethodBeat.m2505o(93210);
            return -1;
        }
        char charAt = str.charAt(i);
        int i2 = (charAt == '!' || charAt == '^') ? 1 : 0;
        if (i2 != 0) {
            i++;
        }
        if (enumSet.contains(C9701a.CASEFOLD)) {
            c = Character.toLowerCase(c);
        }
        int i3 = 0;
        while (i < str.length()) {
            int i4 = i + 1;
            char charAt2 = str.charAt(i);
            if (charAt2 != ']') {
                if (charAt2 != IOUtils.DIR_SEPARATOR_WINDOWS || enumSet.contains(C9701a.NOESCAPE)) {
                    i = i4;
                } else {
                    i = i4 + 1;
                    charAt2 = str.charAt(i4);
                }
                if (charAt2 == IOUtils.DIR_SEPARATOR_UNIX && enumSet.contains(C9701a.PATHNAME)) {
                    AppMethodBeat.m2505o(93210);
                    return 0;
                }
                if (enumSet.contains(C9701a.CASEFOLD)) {
                    charAt2 = Character.toLowerCase(charAt2);
                }
                if (str.charAt(i) == '-' && i + 1 < str.length()) {
                    char charAt3 = str.charAt(i + 1);
                    if (charAt3 != ']') {
                        i4 = i + 2;
                        if (charAt3 != IOUtils.DIR_SEPARATOR_WINDOWS || enumSet.contains(C9701a.NOESCAPE)) {
                            i = i4;
                        } else if (i4 >= str.length()) {
                            AppMethodBeat.m2505o(93210);
                            return -1;
                        } else {
                            i = i4 + 1;
                            charAt2 = str.charAt(i4);
                        }
                        char toLowerCase;
                        if (enumSet.contains(C9701a.CASEFOLD)) {
                            toLowerCase = Character.toLowerCase(charAt3);
                        } else {
                            toLowerCase = charAt3;
                        }
                        if (charAt2 <= c && c <= toLowerCase) {
                            i3 = 1;
                        }
                    }
                }
                if (charAt2 == c) {
                    i3 = 1;
                }
            } else if (i3 == i2) {
                AppMethodBeat.m2505o(93210);
                return 0;
            } else {
                AppMethodBeat.m2505o(93210);
                return i4;
            }
        }
        AppMethodBeat.m2505o(93210);
        return -1;
    }
}
