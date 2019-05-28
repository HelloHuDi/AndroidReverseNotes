package com.tencent.mm.plugin.music.model.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.h;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.h.c;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import java.io.File;

public final class b {
    private static ae<String, String> oMD = new ae(20);
    private static ae<String, Long> oME = new ae(20);

    static {
        AppMethodBeat.i(104916);
        AppMethodBeat.o(104916);
    }

    public static void fq(String str, String str2) {
        AppMethodBeat.i(104910);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(104910);
            return;
        }
        oMD.put(str, str2);
        oME.put(str, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(104910);
    }

    public static boolean b(a aVar) {
        AppMethodBeat.i(104912);
        if (aVar == null || TextUtils.isEmpty(aVar.playUrl)) {
            AppMethodBeat.o(104912);
            return false;
        } else if (Tk(aVar.playUrl)) {
            Object obj;
            int obj2;
            if (c.zX(aVar.field_musicType)) {
                if (aVar == null || TextUtils.isEmpty(aVar.playUrl)) {
                    obj2 = null;
                } else {
                    h SQ = e.SQ(com.tencent.mm.plugin.music.h.b.Tu(aVar.playUrl));
                    if (SQ == null || SQ.fKw != 1) {
                        obj2 = null;
                    } else {
                        obj2 = 1;
                    }
                }
                if (obj2 == null || !com.tencent.mm.plugin.music.cache.h.Td(aVar.playUrl)) {
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
                if (obj2 != null) {
                    ab.i("MicroMsg.Music.MusicUrlParser", "qq music pieceFile cache is valid");
                    AppMethodBeat.o(104912);
                    return false;
                }
            }
            boolean isWifi = at.isWifi(ah.getContext());
            if (isWifi) {
                obj2 = aVar.field_wifiEndFlag == 1 ? 1 : null;
            } else if (aVar.field_endFlag == 1) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 == null || !new File(com.tencent.mm.plugin.music.h.b.aW(aVar.field_musicId, isWifi)).exists()) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                ab.i("MicroMsg.Music.MusicUrlParser", "music cache is valid");
                AppMethodBeat.o(104912);
                return false;
            }
            if (oMD.aj(aVar.playUrl)) {
                long j = 0;
                if (oME.aj(aVar.playUrl)) {
                    j = ((Long) oME.get(aVar.playUrl)).longValue();
                }
                if (System.currentTimeMillis() - j > 86400000) {
                    oMD.remove(aVar.playUrl);
                    oME.remove(aVar.playUrl);
                    ab.i("MicroMsg.Music.MusicUrlParser", "shake music url in cache is timeout");
                    AppMethodBeat.o(104912);
                    return true;
                }
                AppMethodBeat.o(104912);
                return false;
            }
            AppMethodBeat.o(104912);
            return true;
        } else {
            AppMethodBeat.o(104912);
            return false;
        }
    }

    private static boolean Tk(String str) {
        AppMethodBeat.i(104913);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(104913);
            return false;
        } else if (str.contains("wxshakemusic")) {
            AppMethodBeat.o(104913);
            return true;
        } else {
            AppMethodBeat.o(104913);
            return false;
        }
    }

    public static String Tl(String str) {
        AppMethodBeat.i(104914);
        if (Tk(str)) {
            int lastIndexOf = str.lastIndexOf("wxshakemusic");
            if (lastIndexOf > 1) {
                str = str.substring(0, lastIndexOf - 1);
                AppMethodBeat.o(104914);
                return str;
            }
            AppMethodBeat.o(104914);
            return str;
        }
        AppMethodBeat.o(104914);
        return str;
    }

    public static String SP(String str) {
        AppMethodBeat.i(104915);
        String Th = Th(str);
        if (!TextUtils.isEmpty(Th) && !Th.equalsIgnoreCase(str)) {
            ab.i("MicroMsg.Music.MusicUrlParser", "use temp shake music url to play:%s", Th);
            AppMethodBeat.o(104915);
            return Th;
        } else if (Tk(str)) {
            ab.i("MicroMsg.Music.MusicUrlParser", "play url :%s", Tl(Th));
            AppMethodBeat.o(104915);
            return Tl(Th);
        } else {
            Th = "";
            AppMethodBeat.o(104915);
            return Th;
        }
    }

    public static String Th(String str) {
        String str2;
        AppMethodBeat.i(104911);
        if (TextUtils.isEmpty(str) || !oMD.aj(str)) {
            str2 = null;
        } else {
            str2 = (String) oMD.get(str);
        }
        if (str2 == null) {
            AppMethodBeat.o(104911);
            return str;
        }
        AppMethodBeat.o(104911);
        return str2;
    }
}
