package com.tencent.mm.vfs;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Parcel;
import com.tencent.e.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class j {
    private static final Pattern zZL = Pattern.compile("\\$\\{([A-Za-z0-9_]+)\\}");

    static class a extends RuntimeException {
        a(Class<?> cls, int i) {
            super("Version mismatch when unmarhelling " + cls.getName() + " (1 expected, " + i + " got");
            AppMethodBeat.i(54669);
            AppMethodBeat.o(54669);
        }
    }

    static {
        AppMethodBeat.i(54676);
        AppMethodBeat.o(54676);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static Uri parseUri(String str) {
        AppMethodBeat.i(54670);
        Builder builder = new Builder();
        int indexOf = str.indexOf(58);
        if (indexOf < 0) {
            builder.path(str);
        } else {
            builder.scheme(str.substring(0, indexOf));
            int length = str.length();
            if (length > indexOf + 2 && str.charAt(indexOf + 1) == IOUtils.DIR_SEPARATOR_UNIX && str.charAt(indexOf + 2) == IOUtils.DIR_SEPARATOR_UNIX) {
                int i = indexOf + 3;
                while (i < length) {
                    switch (str.charAt(i)) {
                        case '#':
                        case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                        case '?':
                            break;
                        default:
                            i++;
                    }
                    builder.authority(str.substring(indexOf + 3, i));
                    if (i < length) {
                        builder.path(str.substring(i + 1));
                    }
                }
                builder.authority(str.substring(indexOf + 3, i));
                if (i < length) {
                }
            } else {
                builder.path(str.substring(indexOf + 1));
            }
        }
        Uri build = builder.build();
        AppMethodBeat.o(54670);
        return build;
    }

    public static String w(Uri uri) {
        AppMethodBeat.i(54671);
        StringBuilder stringBuilder = new StringBuilder();
        String scheme = uri.getScheme();
        if (!(scheme == null || scheme.isEmpty())) {
            stringBuilder.append(scheme).append(':');
        }
        scheme = uri.getAuthority();
        if (!(scheme == null || scheme.isEmpty())) {
            stringBuilder.append("//").append(scheme);
        }
        scheme = uri.getPath();
        if (scheme != null) {
            stringBuilder.append(scheme);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(54671);
        return stringBuilder2;
    }

    static String H(String str, Map<String, String> map) {
        AppMethodBeat.i(54672);
        Matcher matcher = zZL.matcher(str);
        if (matcher.find()) {
            StringBuilder stringBuilder = new StringBuilder(str.length());
            int i = 0;
            while (true) {
                int i2 = i;
                String group = matcher.group(1);
                String str2 = (String) map.get(group);
                if (str2 == null) {
                    b.d("VFS.Utils", "Macro resolve: " + str + " cannot resolve ${" + group + "}.");
                    AppMethodBeat.o(54672);
                    return null;
                }
                stringBuilder.append(str.substring(i2, matcher.start())).append(str2);
                i = matcher.end();
                if (!matcher.find()) {
                    str2 = stringBuilder.append(str.substring(i)).toString();
                    b.d("VFS.Utils", "Macro resolve: " + str + " => " + str2);
                    AppMethodBeat.o(54672);
                    return str2;
                }
            }
        } else {
            b.d("VFS.Utils", "Macro resolve: " + str + " contains no macros.");
            AppMethodBeat.o(54672);
            return str;
        }
    }

    static String k(String str, boolean z, boolean z2) {
        int i = 1;
        AppMethodBeat.i(54673);
        if (str.isEmpty()) {
            AppMethodBeat.o(54673);
            return str;
        }
        int i2 = str.startsWith("/") ? 1 : 0;
        if (str.endsWith("/") && str.length() > 1) {
            str = str.substring(0, str.length() - 1);
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str.substring(i2), "/");
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (z && "..".equals(nextToken)) {
                if (arrayList.isEmpty()) {
                    AppMethodBeat.o(54673);
                    return null;
                }
                arrayList.remove(arrayList.size() - 1);
                i = 0;
            } else if ((z && ".".equals(nextToken)) || "".equals(nextToken)) {
                i = 0;
            } else {
                arrayList.add(nextToken);
            }
        }
        if (i == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            if (!z2 && i2 > 0) {
                stringBuilder.append(IOUtils.DIR_SEPARATOR_UNIX);
            }
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                stringBuilder.append(it.next());
                while (it.hasNext()) {
                    stringBuilder.append(IOUtils.DIR_SEPARATOR_UNIX);
                    stringBuilder.append(it.next());
                }
            }
            str = stringBuilder.toString();
            AppMethodBeat.o(54673);
            return str;
        } else if (z2) {
            str = str.substring(i2);
            AppMethodBeat.o(54673);
            return str;
        } else {
            AppMethodBeat.o(54673);
            return str;
        }
    }

    static String ath(String str) {
        AppMethodBeat.i(54674);
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf <= 0) {
            AppMethodBeat.o(54674);
            return null;
        }
        String substring = str.substring(0, lastIndexOf);
        AppMethodBeat.o(54674);
        return substring;
    }

    public static void a(Parcel parcel, Class<? extends FileSystem> cls) {
        AppMethodBeat.i(54675);
        int readInt = parcel.readInt();
        if (readInt != 1) {
            a aVar = new a(cls, readInt);
            AppMethodBeat.o(54675);
            throw aVar;
        }
        AppMethodBeat.o(54675);
    }
}
