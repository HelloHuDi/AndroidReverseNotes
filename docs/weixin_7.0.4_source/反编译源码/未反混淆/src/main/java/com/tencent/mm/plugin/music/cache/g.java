package com.tencent.mm.plugin.music.cache;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.ArrayList;
import java.util.Map;

public final class g {
    private static ae<String, String> oLe = new ae(20);
    private static ae<String, Boolean> oLf = new ae(20);
    private static ae<String, Integer> oLg = new ae(20);
    private static ae<String, Integer> oLh = new ae(20);
    private static ae<String, Long> oLi = new ae(20);
    private static ae<String, String> oLj = new ae(20);
    private static String oLk = null;
    private static int oLl = 0;

    static {
        AppMethodBeat.i(137444);
        AppMethodBeat.o(137444);
    }

    public static void SV(String str) {
        AppMethodBeat.i(137426);
        if (TextUtils.isEmpty(SW(str))) {
            CharSequence SR;
            if (e.bTG()) {
                SR = ((c) b.ar(c.class)).SR(str);
            } else {
                ab.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
                SR = "";
            }
            if (!TextUtils.isEmpty(SR)) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(SR);
                new f(arrayList).bTy();
                if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(SR))) {
                    oLe.put(str, SR);
                }
            }
            AppMethodBeat.o(137426);
            return;
        }
        AppMethodBeat.o(137426);
    }

    public static String getAccPath() {
        AppMethodBeat.i(137427);
        String str;
        if (oLk != null) {
            str = oLk;
            AppMethodBeat.o(137427);
            return str;
        }
        str = e.getAccPath();
        if (TextUtils.isEmpty(str)) {
            ab.i("MicroMsg.Music.PieceCacheHelper", "retAccPath:%s is invalid", str);
            str = com.tencent.mm.loader.j.b.eSn;
            AppMethodBeat.o(137427);
            return str;
        }
        ab.i("MicroMsg.Music.PieceCacheHelper", "getAccPath retAccPath:%s", str);
        oLk = str;
        AppMethodBeat.o(137427);
        return str;
    }

    public static int bTA() {
        AppMethodBeat.i(137428);
        int i;
        if (oLl != 0) {
            i = oLl;
            AppMethodBeat.o(137428);
            return i;
        }
        if (e.bTG()) {
            i = ((c) b.ar(c.class)).bTA();
        } else {
            ab.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
            i = 3;
        }
        oLl = i;
        ab.i("MicroMsg.Music.PieceCacheHelper", "sRemovePlayingAudioPlayerGroupCount:%d", Integer.valueOf(oLl));
        if (oLl == 0) {
            oLl = 3;
        }
        i = oLl;
        AppMethodBeat.o(137428);
        return i;
    }

    public static String SW(String str) {
        AppMethodBeat.i(137429);
        String str2;
        if (oLe.aj(str)) {
            str2 = (String) oLe.get(str);
            AppMethodBeat.o(137429);
            return str2;
        }
        str2 = "";
        AppMethodBeat.o(137429);
        return str2;
    }

    public static void aV(String str, boolean z) {
        AppMethodBeat.i(137430);
        if (!TextUtils.isEmpty(str)) {
            oLf.put(str, Boolean.valueOf(z));
        }
        AppMethodBeat.o(137430);
    }

    public static boolean SX(String str) {
        AppMethodBeat.i(137431);
        if (oLf.aj(str)) {
            boolean booleanValue = ((Boolean) oLf.get(str)).booleanValue();
            AppMethodBeat.o(137431);
            return booleanValue;
        }
        AppMethodBeat.o(137431);
        return false;
    }

    public static void r(String str, Map<String, String> map) {
        AppMethodBeat.i(137432);
        if (map != null && SX(str)) {
            map.put("Cookie", "qqmusic_fromtag=97;qqmusic_uin=1234567;qqmusic_key=;");
            map.put("referer", "stream12.qqmusic.qq.com");
        }
        AppMethodBeat.o(137432);
    }

    public static void fo(String str, String str2) {
        AppMethodBeat.i(137433);
        String SW = SW(str);
        if (TextUtils.isEmpty(SW)) {
            ab.e("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType musicId is empty!");
            AppMethodBeat.o(137433);
        } else if (TextUtils.isEmpty(SZ(str))) {
            ab.i("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType url:%s mimeType:%s", str, str2);
            if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
                oLj.put(str, str2);
            }
            if (e.bTG()) {
                ((c) b.ar(c.class)).fm(SW, str2);
                AppMethodBeat.o(137433);
                return;
            }
            ab.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
            AppMethodBeat.o(137433);
        } else {
            AppMethodBeat.o(137433);
        }
    }

    public static String SY(String str) {
        AppMethodBeat.i(137434);
        String SW = SW(str);
        if (TextUtils.isEmpty(SW)) {
            ab.e("MicroMsg.Music.PieceCacheHelper", "getMusicMIMEType musicId is empty!");
            AppMethodBeat.o(137434);
            return null;
        } else if (e.bTG()) {
            String ST = ((c) b.ar(c.class)).ST(SW);
            AppMethodBeat.o(137434);
            return ST;
        } else {
            ab.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
            AppMethodBeat.o(137434);
            return null;
        }
    }

    public static String SZ(String str) {
        AppMethodBeat.i(137435);
        if (oLj.aj(str)) {
            String str2 = (String) oLj.get(str);
            AppMethodBeat.o(137435);
            return str2;
        }
        AppMethodBeat.o(137435);
        return null;
    }

    public static long Ta(String str) {
        AppMethodBeat.i(137436);
        if (oLi.aj(str)) {
            long longValue = ((Long) oLi.get(str)).longValue();
            AppMethodBeat.o(137436);
            return longValue;
        }
        AppMethodBeat.o(137436);
        return -1;
    }

    public static void ah(String str, long j) {
        AppMethodBeat.i(137437);
        if (j > 0) {
            oLi.put(str, Long.valueOf(j));
        }
        AppMethodBeat.o(137437);
    }

    public static long ek(String str) {
        AppMethodBeat.i(137438);
        long ek = h.ek(str);
        AppMethodBeat.o(137438);
        return ek;
    }

    public static void cI(String str, int i) {
        AppMethodBeat.i(137440);
        if (str != null) {
            oLg.put(str, Integer.valueOf(i));
        }
        AppMethodBeat.o(137440);
    }

    public static int Tb(String str) {
        AppMethodBeat.i(137441);
        if (str == null || !oLg.aj(str)) {
            AppMethodBeat.o(137441);
            return 0;
        }
        int intValue = ((Integer) oLg.get(str)).intValue();
        AppMethodBeat.o(137441);
        return intValue;
    }

    public static void cJ(String str, int i) {
        AppMethodBeat.i(137442);
        if (str != null) {
            oLh.put(str, Integer.valueOf(i));
        }
        AppMethodBeat.o(137442);
    }

    public static int Tc(String str) {
        AppMethodBeat.i(137443);
        if (str == null || !oLh.aj(str)) {
            AppMethodBeat.o(137443);
            return 0;
        }
        int intValue = ((Integer) oLh.get(str)).intValue();
        AppMethodBeat.o(137443);
        return intValue;
    }

    public static void HS(String str) {
        AppMethodBeat.i(137439);
        Logger.i("MicroMsg.Music.PieceFileCache", "deleteFileByUrl");
        h.HS(com.tencent.mm.plugin.music.h.b.Tv(str));
        AppMethodBeat.o(137439);
    }
}
