package com.google.android.exoplayer2.p111i;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.google.android.exoplayer2.i.u */
public final class C25544u {
    /* renamed from: m */
    public static Uri m40382m(String str, String str2) {
        AppMethodBeat.m2504i(95948);
        Uri parse = Uri.parse(C25544u.m40383n(str, str2));
        AppMethodBeat.m2505o(95948);
        return parse;
    }

    /* renamed from: n */
    private static String m40383n(String str, String str2) {
        AppMethodBeat.m2504i(95949);
        StringBuilder stringBuilder = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] aN = C25544u.m40381aN(str2);
        String stringBuilder2;
        if (aN[0] != -1) {
            stringBuilder.append(str2);
            C25544u.m40380a(stringBuilder, aN[1], aN[2]);
            stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(95949);
            return stringBuilder2;
        }
        int[] aN2 = C25544u.m40381aN(str);
        int i;
        if (aN[3] == 0) {
            stringBuilder2 = stringBuilder.append(str, 0, aN2[3]).append(str2).toString();
            AppMethodBeat.m2505o(95949);
            return stringBuilder2;
        } else if (aN[2] == 0) {
            stringBuilder2 = stringBuilder.append(str, 0, aN2[2]).append(str2).toString();
            AppMethodBeat.m2505o(95949);
            return stringBuilder2;
        } else if (aN[1] != 0) {
            i = aN2[0] + 1;
            stringBuilder.append(str, 0, i).append(str2);
            stringBuilder2 = C25544u.m40380a(stringBuilder, aN[1] + i, i + aN[2]);
            AppMethodBeat.m2505o(95949);
            return stringBuilder2;
        } else if (str2.charAt(aN[1]) == IOUtils.DIR_SEPARATOR_UNIX) {
            stringBuilder.append(str, 0, aN2[1]).append(str2);
            stringBuilder2 = C25544u.m40380a(stringBuilder, aN2[1], aN[2] + aN2[1]);
            AppMethodBeat.m2505o(95949);
            return stringBuilder2;
        } else if (aN2[0] + 2 >= aN2[1] || aN2[1] != aN2[2]) {
            i = str.lastIndexOf(47, aN2[2] - 1);
            i = i == -1 ? aN2[1] : i + 1;
            stringBuilder.append(str, 0, i).append(str2);
            stringBuilder2 = C25544u.m40380a(stringBuilder, aN2[1], i + aN[2]);
            AppMethodBeat.m2505o(95949);
            return stringBuilder2;
        } else {
            stringBuilder.append(str, 0, aN2[1]).append(IOUtils.DIR_SEPARATOR_UNIX).append(str2);
            stringBuilder2 = C25544u.m40380a(stringBuilder, aN2[1], (aN[2] + aN2[1]) + 1);
            AppMethodBeat.m2505o(95949);
            return stringBuilder2;
        }
    }

    /* renamed from: a */
    private static String m40380a(StringBuilder stringBuilder, int i, int i2) {
        AppMethodBeat.m2504i(95950);
        String stringBuilder2;
        if (i >= i2) {
            stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(95950);
            return stringBuilder2;
        }
        if (stringBuilder.charAt(i) == IOUtils.DIR_SEPARATOR_UNIX) {
            i++;
        }
        int i3 = i;
        int i4 = i;
        while (i3 <= i2) {
            int i5;
            if (i3 == i2) {
                i5 = i3;
            } else if (stringBuilder.charAt(i3) == IOUtils.DIR_SEPARATOR_UNIX) {
                i5 = i3 + 1;
            } else {
                i3++;
            }
            int lastIndexOf;
            if (i3 == i4 + 1 && stringBuilder.charAt(i4) == '.') {
                stringBuilder.delete(i4, i5);
                i2 -= i5 - i4;
                i3 = i4;
            } else if (i3 == i4 + 2 && stringBuilder.charAt(i4) == '.' && stringBuilder.charAt(i4 + 1) == '.') {
                lastIndexOf = stringBuilder.lastIndexOf("/", i4 - 2) + 1;
                i3 = lastIndexOf > i ? lastIndexOf : i;
                stringBuilder.delete(i3, i5);
                i2 -= i5 - i3;
                i3 = lastIndexOf;
                i4 = lastIndexOf;
            } else {
                lastIndexOf = i3 + 1;
                i3 = lastIndexOf;
                i4 = lastIndexOf;
            }
        }
        stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(95950);
        return stringBuilder2;
    }

    /* renamed from: aN */
    private static int[] m40381aN(String str) {
        AppMethodBeat.m2504i(95951);
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            AppMethodBeat.m2505o(95951);
            return iArr;
        }
        int length = str.length();
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            length = indexOf;
        }
        indexOf = str.indexOf(63);
        if (indexOf == -1 || indexOf > length) {
            indexOf = length;
        }
        int indexOf2 = str.indexOf(47);
        if (indexOf2 == -1 || indexOf2 > indexOf) {
            indexOf2 = indexOf;
        }
        int indexOf3 = str.indexOf(58);
        if (indexOf3 > indexOf2) {
            indexOf3 = -1;
        }
        indexOf2 = (indexOf3 + 2 < indexOf && str.charAt(indexOf3 + 1) == IOUtils.DIR_SEPARATOR_UNIX && str.charAt(indexOf3 + 2) == IOUtils.DIR_SEPARATOR_UNIX) ? 1 : 0;
        if (indexOf2 != 0) {
            indexOf2 = str.indexOf(47, indexOf3 + 3);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                indexOf2 = indexOf;
            }
        } else {
            indexOf2 = indexOf3 + 1;
        }
        iArr[0] = indexOf3;
        iArr[1] = indexOf2;
        iArr[2] = indexOf;
        iArr[3] = length;
        AppMethodBeat.m2505o(95951);
        return iArr;
    }
}
