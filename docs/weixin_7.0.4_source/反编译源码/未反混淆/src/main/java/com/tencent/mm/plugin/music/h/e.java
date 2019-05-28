package com.tencent.mm.plugin.music.h;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class e {
    private static final Pattern hnu = Pattern.compile("songid=([0-9]+)");
    private static final String[] oPr = new String[]{"#", "?", "&"};
    private static String oPs = null;
    private static String oPt = null;

    public static boolean Tw(String str) {
        AppMethodBeat.i(137700);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(137700);
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
            ab.w("MicroMsg.Music.MusicUrlUtil", "url %s match ? %B", str, Boolean.valueOf(contains));
        } else {
            ab.i("MicroMsg.Music.MusicUrlUtil", "host is null, url is not match .qq.com");
            contains = false;
        }
        AppMethodBeat.o(137700);
        return contains;
    }

    public static String eE(Context context) {
        AppMethodBeat.i(137701);
        String str = "";
        String packageName = ah.getPackageName();
        if (packageName == null) {
            AppMethodBeat.o(137701);
        } else {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
                if (packageInfo != null) {
                    str = (str + packageInfo.versionName) + packageInfo.versionCode;
                }
            } catch (NameNotFoundException e) {
                ab.printErrStackTrace("MicroMsg.Music.MusicUrlUtil", e, "", new Object[0]);
            }
            AppMethodBeat.o(137701);
        }
        return str;
    }

    public static String a(String str, String str2, boolean z, PBool pBool) {
        String str3;
        AppMethodBeat.i(137702);
        if (z || bo.isNullOrNil(str2)) {
            str3 = str;
        } else {
            str3 = str2;
        }
        if (bo.isNullOrNil(str3)) {
            AppMethodBeat.o(137702);
            return str3;
        }
        PString pString = new PString();
        ab.i("MicroMsg.Music.MusicUrlUtil", "url[%s], lowBandUrl[%s], isWifi[%B]", str, str2, Boolean.valueOf(z));
        String Tx = Tx(str3);
        if (Tx != null) {
            if (a(Tx, z, pString)) {
                pBool.value = z;
            }
        } else if (str3.contains("wechat_music_url=")) {
            a(str3.substring(str3.indexOf("wechat_music_url=") + 17), z, pString);
        } else {
            pString.value = str3;
        }
        str3 = pString.value;
        AppMethodBeat.o(137702);
        return str3;
    }

    static {
        AppMethodBeat.i(137709);
        AppMethodBeat.o(137709);
    }

    private static String Tx(String str) {
        AppMethodBeat.i(137703);
        String substring;
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(137703);
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
                AppMethodBeat.o(137703);
                return null;
            }
            indexOf = str3.indexOf(str22);
            if (indexOf < 0) {
                ab.w("MicroMsg.Music.MusicUrlUtil", "pIndex is %d, return", Integer.valueOf(indexOf));
                AppMethodBeat.o(137703);
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
            AppMethodBeat.o(137703);
            return substring;
        } else {
            substring = oPt;
            AppMethodBeat.o(137703);
            return substring;
        }
    }

    private static boolean a(String str, boolean z, PString pString) {
        AppMethodBeat.i(137704);
        String str2 = new String(Ty(str));
        int indexOf = str2.indexOf("{");
        if (indexOf != -1) {
            str2 = str2.substring(indexOf);
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String string = jSONObject.getString("song_WapLiveURL");
            str2 = jSONObject.getString("song_WifiURL");
            ab.d("MicroMsg.Music.MusicUrlUtil", "waplive: " + string + "  wifi:" + str2);
            if (!z) {
                str2 = string;
            }
            pString.value = str2;
            AppMethodBeat.o(137704);
            return true;
        } catch (Exception e) {
            pString.value = str;
            ab.printErrStackTrace("MicroMsg.Music.MusicUrlUtil", e, "decodeJson", new Object[0]);
            AppMethodBeat.o(137704);
            return false;
        }
    }

    private static byte[] Ty(String str) {
        AppMethodBeat.i(137705);
        byte[] bArr = new byte[((str.length() / 2) + (str.length() % 2))];
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            try {
                int w;
                int i3 = i + 1;
                int w2 = w(str.charAt(i));
                if (i3 < str.length()) {
                    i = i3 + 1;
                    w = w(str.charAt(i3));
                } else {
                    w = 0;
                    i = i3;
                }
                i3 = i2 + 1;
                bArr[i2] = (byte) (w | (w2 << 4));
                i2 = i3;
            } catch (Exception e) {
                AppMethodBeat.o(137705);
                return null;
            }
        }
        AppMethodBeat.o(137705);
        return bArr;
    }

    private static int Tz(String str) {
        int i = 0;
        AppMethodBeat.i(137706);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(137706);
        } else {
            Matcher matcher = hnu.matcher(str);
            if (matcher.find()) {
                try {
                    i = Integer.valueOf(matcher.group(1)).intValue();
                    AppMethodBeat.o(137706);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.Music.MusicUrlUtil", e, "getSongId", new Object[i]);
                    AppMethodBeat.o(137706);
                }
            } else {
                AppMethodBeat.o(137706);
            }
        }
        return i;
    }

    private static int w(char c) {
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
    private static String N(com.tencent.mm.aw.e eVar) {
        String str;
        AppMethodBeat.i(137707);
        if (eVar != null) {
            if (!bo.isNullOrNil(eVar.fKa)) {
                str = eVar.fKa;
            } else if (!bo.isNullOrNil(eVar.fKc)) {
                str = eVar.fKc;
            } else if (!bo.isNullOrNil(eVar.fKb)) {
                str = eVar.fKb;
            }
            if (str != null) {
                AppMethodBeat.o(137707);
                return null;
            }
            String Tx = Tx(eVar.fKa);
            if (Tx != null) {
                AppMethodBeat.o(137707);
                return Tx;
            }
            Tx = Tx(eVar.fKc);
            if (Tx != null) {
                AppMethodBeat.o(137707);
                return Tx;
            }
            Tx = Tx(eVar.fKb);
            AppMethodBeat.o(137707);
            return Tx;
        }
        str = null;
        if (str != null) {
        }
    }

    public static com.tencent.mm.aw.e O(com.tencent.mm.aw.e eVar) {
        AppMethodBeat.i(137708);
        if (eVar != null) {
            eVar.fKj = Tz(eVar.fKa);
            if (eVar.fKj <= 0) {
                eVar.fKj = Tz(eVar.fKc);
                if (eVar.fKj <= 0) {
                    eVar.fKj = Tz(eVar.fKb);
                }
            }
        }
        if (eVar == null || N(eVar) == null) {
            AppMethodBeat.o(137708);
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            String N = N(eVar);
            if (N == null) {
                AppMethodBeat.o(137708);
            } else {
                ab.d("MicroMsg.Music.MusicUrlUtil", "bcdUrl: %s", N);
                String str = new String(Ty(N));
                int indexOf = str.indexOf("{");
                if (indexOf != -1) {
                    str = str.substring(indexOf);
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    eVar.fKj = jSONObject.optInt("song_ID");
                    if (bo.isNullOrNil(eVar.fJW)) {
                        eVar.fJW = jSONObject.optString("song_Name");
                    }
                    if (bo.isNullOrNil(eVar.fKb)) {
                        eVar.fKb = jSONObject.optString("song_WapLiveURL");
                    }
                    if (bo.isNullOrNil(eVar.fKa)) {
                        eVar.fKa = jSONObject.optString("song_WifiURL");
                    }
                    if (bo.isNullOrNil(eVar.fJY)) {
                        eVar.fJY = jSONObject.optString("song_Album");
                    }
                    if (bo.isNullOrNil(eVar.fJX)) {
                        eVar.fJX = jSONObject.optString("song_Singer");
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.Music.MusicUrlUtil", e, "", new Object[0]);
                }
                if (eVar.fKj == 0) {
                    eVar.fKj = Tz(oPs);
                }
                ab.i("MicroMsg.Music.MusicUrlUtil", "parseBCDForMusicWrapper %s: expend: %d %d", eVar.fJU, Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(eVar.fKj));
                AppMethodBeat.o(137708);
            }
        }
        return eVar;
    }
}
