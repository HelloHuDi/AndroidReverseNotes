package org.apache.commons.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.File;

public final class b {
    public static final String BWv = Character.toString('.');
    private static final char BWw;
    private static final char BWx;

    static {
        Object obj;
        AppMethodBeat.i(136499);
        char c = File.separatorChar;
        BWw = c;
        if (c == IOUtils.DIR_SEPARATOR_WINDOWS) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            BWx = IOUtils.DIR_SEPARATOR_UNIX;
            AppMethodBeat.o(136499);
            return;
        }
        BWx = IOUtils.DIR_SEPARATOR_WINDOWS;
        AppMethodBeat.o(136499);
    }

    private static boolean isSeparator(char c) {
        return c == IOUtils.DIR_SEPARATOR_UNIX || c == IOUtils.DIR_SEPARATOR_WINDOWS;
    }

    private static String normalize(String str) {
        AppMethodBeat.i(136492);
        char c = BWw;
        if (str == null) {
            AppMethodBeat.o(136492);
            return null;
        }
        awI(str);
        int length = str.length();
        if (length == 0) {
            AppMethodBeat.o(136492);
            return str;
        }
        int awG = awG(str);
        if (awG < 0) {
            AppMethodBeat.o(136492);
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
                    AppMethodBeat.o(136492);
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
            AppMethodBeat.o(136492);
            return str;
        } else if (i <= awG) {
            str = new String(cArr, 0, i);
            AppMethodBeat.o(136492);
            return str;
        } else if (i2 != 0) {
            str = new String(cArr, 0, i);
            AppMethodBeat.o(136492);
            return str;
        } else {
            str = new String(cArr, 0, i - 1);
            AppMethodBeat.o(136492);
            return str;
        }
    }

    public static String jj(String str, String str2) {
        AppMethodBeat.i(136493);
        int awG = awG(str2);
        String normalize;
        if (awG < 0) {
            AppMethodBeat.o(136493);
            return null;
        } else if (awG > 0) {
            normalize = normalize(str2);
            AppMethodBeat.o(136493);
            return normalize;
        } else if (str == null) {
            AppMethodBeat.o(136493);
            return null;
        } else {
            int length = str.length();
            if (length == 0) {
                normalize = normalize(str2);
                AppMethodBeat.o(136493);
                return normalize;
            } else if (isSeparator(str.charAt(length - 1))) {
                normalize = normalize(str + str2);
                AppMethodBeat.o(136493);
                return normalize;
            } else {
                normalize = normalize(str + IOUtils.DIR_SEPARATOR_UNIX + str2);
                AppMethodBeat.o(136493);
                return normalize;
            }
        }
    }

    private static int awG(String str) {
        AppMethodBeat.i(136494);
        if (str == null) {
            AppMethodBeat.o(136494);
            return -1;
        }
        int length = str.length();
        if (length == 0) {
            AppMethodBeat.o(136494);
            return 0;
        }
        char charAt = str.charAt(0);
        int indexOf;
        int indexOf2;
        if (charAt == ':') {
            AppMethodBeat.o(136494);
            return -1;
        } else if (length == 1) {
            if (charAt == '~') {
                AppMethodBeat.o(136494);
                return 2;
            } else if (isSeparator(charAt)) {
                AppMethodBeat.o(136494);
                return 1;
            } else {
                AppMethodBeat.o(136494);
                return 0;
            }
        } else if (charAt == '~') {
            indexOf = str.indexOf(47, 1);
            indexOf2 = str.indexOf(92, 1);
            if (indexOf == -1 && indexOf2 == -1) {
                indexOf2 = length + 1;
                AppMethodBeat.o(136494);
                return indexOf2;
            }
            if (indexOf == -1) {
                indexOf = indexOf2;
            }
            if (indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            indexOf2 = Math.min(indexOf, indexOf2) + 1;
            AppMethodBeat.o(136494);
            return indexOf2;
        } else {
            char charAt2 = str.charAt(1);
            if (charAt2 == ':') {
                char toUpperCase = Character.toUpperCase(charAt);
                if (toUpperCase < 'A' || toUpperCase > 'Z') {
                    if (toUpperCase == IOUtils.DIR_SEPARATOR_UNIX) {
                        AppMethodBeat.o(136494);
                        return 1;
                    }
                    AppMethodBeat.o(136494);
                    return -1;
                } else if (length == 2 || !isSeparator(str.charAt(2))) {
                    AppMethodBeat.o(136494);
                    return 2;
                } else {
                    AppMethodBeat.o(136494);
                    return 3;
                }
            } else if (isSeparator(charAt) && isSeparator(charAt2)) {
                int indexOf3 = str.indexOf(47, 2);
                indexOf2 = str.indexOf(92, 2);
                if ((indexOf3 == -1 && indexOf2 == -1) || indexOf3 == 2 || indexOf2 == 2) {
                    AppMethodBeat.o(136494);
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
                AppMethodBeat.o(136494);
                return indexOf2;
            } else if (isSeparator(charAt)) {
                AppMethodBeat.o(136494);
                return 1;
            } else {
                AppMethodBeat.o(136494);
                return 0;
            }
        }
    }

    private static int awH(String str) {
        AppMethodBeat.i(136495);
        if (str == null) {
            AppMethodBeat.o(136495);
            return -1;
        }
        int max = Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
        AppMethodBeat.o(136495);
        return max;
    }

    public static String getName(String str) {
        AppMethodBeat.i(136496);
        if (str == null) {
            AppMethodBeat.o(136496);
            return null;
        }
        awI(str);
        String substring = str.substring(awH(str) + 1);
        AppMethodBeat.o(136496);
        return substring;
    }

    private static void awI(String str) {
        AppMethodBeat.i(136497);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Null byte present in file/path name. There are no known legitimate use cases for such data, but several injection attacks may use it");
                AppMethodBeat.o(136497);
                throw illegalArgumentException;
            }
        }
        AppMethodBeat.o(136497);
    }

    public static String awJ(String str) {
        AppMethodBeat.i(136498);
        if (str == null) {
            AppMethodBeat.o(136498);
            return null;
        }
        int i;
        if (str == null) {
            i = -1;
        } else {
            i = str.lastIndexOf(46);
            if (awH(str) > i) {
                i = -1;
            }
        }
        String str2;
        if (i == -1) {
            str2 = "";
            AppMethodBeat.o(136498);
            return str2;
        }
        str2 = str.substring(i + 1);
        AppMethodBeat.o(136498);
        return str2;
    }
}
