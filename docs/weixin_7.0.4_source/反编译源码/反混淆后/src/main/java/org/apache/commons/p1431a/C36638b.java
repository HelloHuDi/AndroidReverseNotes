package org.apache.commons.p1431a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;

/* renamed from: org.apache.commons.a.b */
public final class C36638b {
    public static final String BWv = Character.toString('.');
    private static final char BWw;
    private static final char BWx;

    static {
        Object obj;
        AppMethodBeat.m2504i(136499);
        char c = File.separatorChar;
        BWw = c;
        if (c == IOUtils.DIR_SEPARATOR_WINDOWS) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            BWx = IOUtils.DIR_SEPARATOR_UNIX;
            AppMethodBeat.m2505o(136499);
            return;
        }
        BWx = IOUtils.DIR_SEPARATOR_WINDOWS;
        AppMethodBeat.m2505o(136499);
    }

    private static boolean isSeparator(char c) {
        return c == IOUtils.DIR_SEPARATOR_UNIX || c == IOUtils.DIR_SEPARATOR_WINDOWS;
    }

    private static String normalize(String str) {
        AppMethodBeat.m2504i(136492);
        char c = BWw;
        if (str == null) {
            AppMethodBeat.m2505o(136492);
            return null;
        }
        C36638b.awI(str);
        int length = str.length();
        if (length == 0) {
            AppMethodBeat.m2505o(136492);
            return str;
        }
        int awG = C36638b.awG(str);
        if (awG < 0) {
            AppMethodBeat.m2505o(136492);
            return null;
        }
        int i;
        int i2;
        char[] cArr = new char[(length + 2)];
        str.getChars(0, str.length(), cArr, 0);
        char c2 = c == BWw ? BWx : BWw;
        for (i = 0; i < cArr.length; i++) {
            if (cArr[i] == c2) {
                cArr[i] = c;
            }
        }
        if (cArr[length - 1] != c) {
            i = length + 1;
            cArr[length] = c;
            i2 = 0;
        } else {
            i2 = 1;
            i = length;
        }
        length = awG + 1;
        while (length < i) {
            if (cArr[length] == c && cArr[length - 1] == c) {
                System.arraycopy(cArr, length, cArr, length - 1, i - length);
                i--;
                length--;
            }
            length++;
        }
        length = awG + 1;
        while (length < i) {
            if (cArr[length] == c && cArr[length - 1] == '.' && (length == awG + 1 || cArr[length - 2] == c)) {
                if (length == i - 1) {
                    i2 = 1;
                }
                System.arraycopy(cArr, length + 1, cArr, length - 1, i - length);
                i -= 2;
                length--;
            }
            length++;
        }
        length = awG + 2;
        while (length < i) {
            if (cArr[length] == c && cArr[length - 1] == '.' && cArr[length - 2] == '.' && (length == awG + 2 || cArr[length - 3] == c)) {
                if (length == awG + 2) {
                    AppMethodBeat.m2505o(136492);
                    return null;
                }
                if (length == i - 1) {
                    i2 = 1;
                }
                for (int i3 = length - 4; i3 >= awG; i3--) {
                    if (cArr[i3] == c) {
                        System.arraycopy(cArr, length + 1, cArr, i3 + 1, i - length);
                        i -= length - i3;
                        length = i3 + 1;
                        break;
                    }
                }
                System.arraycopy(cArr, length + 1, cArr, awG, i - length);
                i -= (length + 1) - awG;
                length = awG + 1;
            }
            length++;
        }
        if (i <= 0) {
            str = "";
            AppMethodBeat.m2505o(136492);
            return str;
        } else if (i <= awG) {
            str = new String(cArr, 0, i);
            AppMethodBeat.m2505o(136492);
            return str;
        } else if (i2 != 0) {
            str = new String(cArr, 0, i);
            AppMethodBeat.m2505o(136492);
            return str;
        } else {
            str = new String(cArr, 0, i - 1);
            AppMethodBeat.m2505o(136492);
            return str;
        }
    }

    /* renamed from: jj */
    public static String m60739jj(String str, String str2) {
        AppMethodBeat.m2504i(136493);
        int awG = C36638b.awG(str2);
        String normalize;
        if (awG < 0) {
            AppMethodBeat.m2505o(136493);
            return null;
        } else if (awG > 0) {
            normalize = C36638b.normalize(str2);
            AppMethodBeat.m2505o(136493);
            return normalize;
        } else if (str == null) {
            AppMethodBeat.m2505o(136493);
            return null;
        } else {
            int length = str.length();
            if (length == 0) {
                normalize = C36638b.normalize(str2);
                AppMethodBeat.m2505o(136493);
                return normalize;
            } else if (C36638b.isSeparator(str.charAt(length - 1))) {
                normalize = C36638b.normalize(str + str2);
                AppMethodBeat.m2505o(136493);
                return normalize;
            } else {
                normalize = C36638b.normalize(str + IOUtils.DIR_SEPARATOR_UNIX + str2);
                AppMethodBeat.m2505o(136493);
                return normalize;
            }
        }
    }

    private static int awG(String str) {
        AppMethodBeat.m2504i(136494);
        if (str == null) {
            AppMethodBeat.m2505o(136494);
            return -1;
        }
        int length = str.length();
        if (length == 0) {
            AppMethodBeat.m2505o(136494);
            return 0;
        }
        char charAt = str.charAt(0);
        int indexOf;
        int indexOf2;
        if (charAt == ':') {
            AppMethodBeat.m2505o(136494);
            return -1;
        } else if (length == 1) {
            if (charAt == '~') {
                AppMethodBeat.m2505o(136494);
                return 2;
            } else if (C36638b.isSeparator(charAt)) {
                AppMethodBeat.m2505o(136494);
                return 1;
            } else {
                AppMethodBeat.m2505o(136494);
                return 0;
            }
        } else if (charAt == '~') {
            indexOf = str.indexOf(47, 1);
            indexOf2 = str.indexOf(92, 1);
            if (indexOf == -1 && indexOf2 == -1) {
                indexOf2 = length + 1;
                AppMethodBeat.m2505o(136494);
                return indexOf2;
            }
            if (indexOf == -1) {
                indexOf = indexOf2;
            }
            if (indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            indexOf2 = Math.min(indexOf, indexOf2) + 1;
            AppMethodBeat.m2505o(136494);
            return indexOf2;
        } else {
            char charAt2 = str.charAt(1);
            if (charAt2 == ':') {
                char toUpperCase = Character.toUpperCase(charAt);
                if (toUpperCase < 'A' || toUpperCase > 'Z') {
                    if (toUpperCase == IOUtils.DIR_SEPARATOR_UNIX) {
                        AppMethodBeat.m2505o(136494);
                        return 1;
                    }
                    AppMethodBeat.m2505o(136494);
                    return -1;
                } else if (length == 2 || !C36638b.isSeparator(str.charAt(2))) {
                    AppMethodBeat.m2505o(136494);
                    return 2;
                } else {
                    AppMethodBeat.m2505o(136494);
                    return 3;
                }
            } else if (C36638b.isSeparator(charAt) && C36638b.isSeparator(charAt2)) {
                int indexOf3 = str.indexOf(47, 2);
                indexOf2 = str.indexOf(92, 2);
                if ((indexOf3 == -1 && indexOf2 == -1) || indexOf3 == 2 || indexOf2 == 2) {
                    AppMethodBeat.m2505o(136494);
                    return -1;
                }
                if (indexOf3 == -1) {
                    indexOf = indexOf2;
                } else {
                    indexOf = indexOf3;
                }
                if (indexOf2 == -1) {
                    indexOf2 = indexOf;
                }
                indexOf2 = Math.min(indexOf, indexOf2) + 1;
                AppMethodBeat.m2505o(136494);
                return indexOf2;
            } else if (C36638b.isSeparator(charAt)) {
                AppMethodBeat.m2505o(136494);
                return 1;
            } else {
                AppMethodBeat.m2505o(136494);
                return 0;
            }
        }
    }

    private static int awH(String str) {
        AppMethodBeat.m2504i(136495);
        if (str == null) {
            AppMethodBeat.m2505o(136495);
            return -1;
        }
        int max = Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
        AppMethodBeat.m2505o(136495);
        return max;
    }

    public static String getName(String str) {
        AppMethodBeat.m2504i(136496);
        if (str == null) {
            AppMethodBeat.m2505o(136496);
            return null;
        }
        C36638b.awI(str);
        String substring = str.substring(C36638b.awH(str) + 1);
        AppMethodBeat.m2505o(136496);
        return substring;
    }

    private static void awI(String str) {
        AppMethodBeat.m2504i(136497);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Null byte present in file/path name. There are no known legitimate use cases for such data, but several injection attacks may use it");
                AppMethodBeat.m2505o(136497);
                throw illegalArgumentException;
            }
        }
        AppMethodBeat.m2505o(136497);
    }

    public static String awJ(String str) {
        AppMethodBeat.m2504i(136498);
        if (str == null) {
            AppMethodBeat.m2505o(136498);
            return null;
        }
        int i;
        if (str == null) {
            i = -1;
        } else {
            i = str.lastIndexOf(46);
            if (C36638b.awH(str) > i) {
                i = -1;
            }
        }
        String str2;
        if (i == -1) {
            str2 = "";
            AppMethodBeat.m2505o(136498);
            return str2;
        }
        str2 = str.substring(i + 1);
        AppMethodBeat.m2505o(136498);
        return str2;
    }
}
