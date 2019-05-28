package com.tencent.p177mm.plugin.music.p997h;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.pointers.PBool;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.music.h.e */
public final class C46101e {
    private static final Pattern hnu = Pattern.compile("songid=([0-9]+)");
    private static final String[] oPr = new String[]{"#", "?", "&"};
    private static String oPs = null;
    private static String oPt = null;

    /* renamed from: Tw */
    public static boolean m86001Tw(String str) {
        AppMethodBeat.m2504i(137700);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(137700);
            return false;
        }
        boolean contains;
        Uri parse = Uri.parse(str);
        String str2 = "";
        if (parse != null) {
            str2 = parse.getHost();
        }
        if (str2 != null) {
            contains = parse.getHost().contains(".qq.com");
            C4990ab.m7421w("MicroMsg.Music.MusicUrlUtil", "url %s match ? %B", str, Boolean.valueOf(contains));
        } else {
            C4990ab.m7416i("MicroMsg.Music.MusicUrlUtil", "host is null, url is not match .qq.com");
            contains = false;
        }
        AppMethodBeat.m2505o(137700);
        return contains;
    }

    /* renamed from: eE */
    public static String m86007eE(Context context) {
        AppMethodBeat.m2504i(137701);
        String str = "";
        String packageName = C4996ah.getPackageName();
        if (packageName == null) {
            AppMethodBeat.m2505o(137701);
        } else {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
                if (packageInfo != null) {
                    str = (str + packageInfo.versionName) + packageInfo.versionCode;
                }
            } catch (NameNotFoundException e) {
                C4990ab.printErrStackTrace("MicroMsg.Music.MusicUrlUtil", e, "", new Object[0]);
            }
            AppMethodBeat.m2505o(137701);
        }
        return str;
    }

    /* renamed from: a */
    public static String m86005a(String str, String str2, boolean z, PBool pBool) {
        String str3;
        AppMethodBeat.m2504i(137702);
        if (z || C5046bo.isNullOrNil(str2)) {
            str3 = str;
        } else {
            str3 = str2;
        }
        if (C5046bo.isNullOrNil(str3)) {
            AppMethodBeat.m2505o(137702);
            return str3;
        }
        PString pString = new PString();
        C4990ab.m7417i("MicroMsg.Music.MusicUrlUtil", "url[%s], lowBandUrl[%s], isWifi[%B]", str, str2, Boolean.valueOf(z));
        String Tx = C46101e.m86002Tx(str3);
        if (Tx != null) {
            if (C46101e.m86006a(Tx, z, pString)) {
                pBool.value = z;
            }
        } else if (str3.contains("wechat_music_url=")) {
            C46101e.m86006a(str3.substring(str3.indexOf("wechat_music_url=") + 17), z, pString);
        } else {
            pString.value = str3;
        }
        str3 = pString.value;
        AppMethodBeat.m2505o(137702);
        return str3;
    }

    static {
        AppMethodBeat.m2504i(137709);
        AppMethodBeat.m2505o(137709);
    }

    /* renamed from: Tx */
    private static String m86002Tx(String str) {
        AppMethodBeat.m2504i(137703);
        String substring;
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(137703);
            return null;
        } else if (oPs == null || !str.equals(oPs)) {
            int indexOf;
            String str2 = "";
            String str3 = null;
            for (String str22 : oPr) {
                str22 = str22 + "p=";
                if (str.contains(str22)) {
                    str3 = str;
                }
                if (str3 != null) {
                    break;
                }
            }
            if (str3 == null) {
                AppMethodBeat.m2505o(137703);
                return null;
            }
            indexOf = str3.indexOf(str22);
            if (indexOf < 0) {
                C4990ab.m7421w("MicroMsg.Music.MusicUrlUtil", "pIndex is %d, return", Integer.valueOf(indexOf));
                AppMethodBeat.m2505o(137703);
                return null;
            }
            substring = str3.substring(str22.length() + indexOf);
            for (String indexOf2 : oPr) {
                int indexOf3 = substring.indexOf(indexOf2);
                if (indexOf3 > 0) {
                    substring = substring.substring(0, indexOf3);
                }
            }
            if (substring != null) {
                oPs = str;
                oPt = substring;
            }
            AppMethodBeat.m2505o(137703);
            return substring;
        } else {
            substring = oPt;
            AppMethodBeat.m2505o(137703);
            return substring;
        }
    }

    /* renamed from: a */
    private static boolean m86006a(String str, boolean z, PString pString) {
        AppMethodBeat.m2504i(137704);
        String str2 = new String(C46101e.m86003Ty(str));
        int indexOf = str2.indexOf("{");
        if (indexOf != -1) {
            str2 = str2.substring(indexOf);
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String string = jSONObject.getString("song_WapLiveURL");
            str2 = jSONObject.getString("song_WifiURL");
            C4990ab.m7410d("MicroMsg.Music.MusicUrlUtil", "waplive: " + string + "  wifi:" + str2);
            if (!z) {
                str2 = string;
            }
            pString.value = str2;
            AppMethodBeat.m2505o(137704);
            return true;
        } catch (Exception e) {
            pString.value = str;
            C4990ab.printErrStackTrace("MicroMsg.Music.MusicUrlUtil", e, "decodeJson", new Object[0]);
            AppMethodBeat.m2505o(137704);
            return false;
        }
    }

    /* renamed from: Ty */
    private static byte[] m86003Ty(String str) {
        AppMethodBeat.m2504i(137705);
        byte[] bArr = new byte[((str.length() / 2) + (str.length() % 2))];
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            try {
                int w;
                int i3 = i + 1;
                int w2 = C46101e.m86008w(str.charAt(i));
                if (i3 < str.length()) {
                    i = i3 + 1;
                    w = C46101e.m86008w(str.charAt(i3));
                } else {
                    w = 0;
                    i = i3;
                }
                i3 = i2 + 1;
                bArr[i2] = (byte) (w | (w2 << 4));
                i2 = i3;
            } catch (Exception e) {
                AppMethodBeat.m2505o(137705);
                return null;
            }
        }
        AppMethodBeat.m2505o(137705);
        return bArr;
    }

    /* renamed from: Tz */
    private static int m86004Tz(String str) {
        int i = 0;
        AppMethodBeat.m2504i(137706);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(137706);
        } else {
            Matcher matcher = hnu.matcher(str);
            if (matcher.find()) {
                try {
                    i = Integer.valueOf(matcher.group(1)).intValue();
                    AppMethodBeat.m2505o(137706);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.Music.MusicUrlUtil", e, "getSongId", new Object[i]);
                    AppMethodBeat.m2505o(137706);
                }
            } else {
                AppMethodBeat.m2505o(137706);
            }
        }
        return i;
    }

    /* renamed from: w */
    private static int m86008w(char c) {
        if (c >= '1' && c <= '9') {
            return c - 48;
        }
        if (c < 'A' || c > 'F') {
            return 0;
        }
        return (c - 65) + 10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0015  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: N */
    private static String m85999N(C9058e c9058e) {
        String str;
        AppMethodBeat.m2504i(137707);
        if (c9058e != null) {
            if (!C5046bo.isNullOrNil(c9058e.fKa)) {
                str = c9058e.fKa;
            } else if (!C5046bo.isNullOrNil(c9058e.fKc)) {
                str = c9058e.fKc;
            } else if (!C5046bo.isNullOrNil(c9058e.fKb)) {
                str = c9058e.fKb;
            }
            if (str != null) {
                AppMethodBeat.m2505o(137707);
                return null;
            }
            String Tx = C46101e.m86002Tx(c9058e.fKa);
            if (Tx != null) {
                AppMethodBeat.m2505o(137707);
                return Tx;
            }
            Tx = C46101e.m86002Tx(c9058e.fKc);
            if (Tx != null) {
                AppMethodBeat.m2505o(137707);
                return Tx;
            }
            Tx = C46101e.m86002Tx(c9058e.fKb);
            AppMethodBeat.m2505o(137707);
            return Tx;
        }
        str = null;
        if (str != null) {
        }
    }

    /* renamed from: O */
    public static C9058e m86000O(C9058e c9058e) {
        AppMethodBeat.m2504i(137708);
        if (c9058e != null) {
            c9058e.fKj = C46101e.m86004Tz(c9058e.fKa);
            if (c9058e.fKj <= 0) {
                c9058e.fKj = C46101e.m86004Tz(c9058e.fKc);
                if (c9058e.fKj <= 0) {
                    c9058e.fKj = C46101e.m86004Tz(c9058e.fKb);
                }
            }
        }
        if (c9058e == null || C46101e.m85999N(c9058e) == null) {
            AppMethodBeat.m2505o(137708);
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            String N = C46101e.m85999N(c9058e);
            if (N == null) {
                AppMethodBeat.m2505o(137708);
            } else {
                C4990ab.m7411d("MicroMsg.Music.MusicUrlUtil", "bcdUrl: %s", N);
                String str = new String(C46101e.m86003Ty(N));
                int indexOf = str.indexOf("{");
                if (indexOf != -1) {
                    str = str.substring(indexOf);
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    c9058e.fKj = jSONObject.optInt("song_ID");
                    if (C5046bo.isNullOrNil(c9058e.fJW)) {
                        c9058e.fJW = jSONObject.optString("song_Name");
                    }
                    if (C5046bo.isNullOrNil(c9058e.fKb)) {
                        c9058e.fKb = jSONObject.optString("song_WapLiveURL");
                    }
                    if (C5046bo.isNullOrNil(c9058e.fKa)) {
                        c9058e.fKa = jSONObject.optString("song_WifiURL");
                    }
                    if (C5046bo.isNullOrNil(c9058e.fJY)) {
                        c9058e.fJY = jSONObject.optString("song_Album");
                    }
                    if (C5046bo.isNullOrNil(c9058e.fJX)) {
                        c9058e.fJX = jSONObject.optString("song_Singer");
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.Music.MusicUrlUtil", e, "", new Object[0]);
                }
                if (c9058e.fKj == 0) {
                    c9058e.fKj = C46101e.m86004Tz(oPs);
                }
                C4990ab.m7417i("MicroMsg.Music.MusicUrlUtil", "parseBCDForMusicWrapper %s: expend: %d %d", c9058e.fJU, Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(c9058e.fKj));
                AppMethodBeat.m2505o(137708);
            }
        }
        return c9058e;
    }
}
