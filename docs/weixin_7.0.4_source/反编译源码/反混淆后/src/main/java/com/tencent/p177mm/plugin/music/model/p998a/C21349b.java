package com.tencent.p177mm.plugin.music.model.p998a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p198aw.C9060h;
import com.tencent.p177mm.plugin.music.cache.C39432e;
import com.tencent.p177mm.plugin.music.cache.C43322h;
import com.tencent.p177mm.plugin.music.model.p1000e.C28575a;
import com.tencent.p177mm.plugin.music.p997h.C12673b;
import com.tencent.p177mm.plugin.music.p997h.C34585c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4993ae;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.music.model.a.b */
public final class C21349b {
    private static C4993ae<String, String> oMD = new C4993ae(20);
    private static C4993ae<String, Long> oME = new C4993ae(20);

    static {
        AppMethodBeat.m2504i(104916);
        AppMethodBeat.m2505o(104916);
    }

    /* renamed from: fq */
    public static void m32750fq(String str, String str2) {
        AppMethodBeat.m2504i(104910);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.m2505o(104910);
            return;
        }
        oMD.put(str, str2);
        oME.put(str, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.m2505o(104910);
    }

    /* renamed from: b */
    public static boolean m32749b(C28575a c28575a) {
        AppMethodBeat.m2504i(104912);
        if (c28575a == null || TextUtils.isEmpty(c28575a.playUrl)) {
            AppMethodBeat.m2505o(104912);
            return false;
        } else if (C21349b.m32747Tk(c28575a.playUrl)) {
            Object obj;
            int obj2;
            if (C34585c.m56720zX(c28575a.field_musicType)) {
                if (c28575a == null || TextUtils.isEmpty(c28575a.playUrl)) {
                    obj2 = null;
                } else {
                    C9060h SQ = C39432e.m67338SQ(C12673b.m20671Tu(c28575a.playUrl));
                    if (SQ == null || SQ.fKw != 1) {
                        obj2 = null;
                    } else {
                        obj2 = 1;
                    }
                }
                if (obj2 == null || !C43322h.m77264Td(c28575a.playUrl)) {
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
                if (obj2 != null) {
                    C4990ab.m7416i("MicroMsg.Music.MusicUrlParser", "qq music pieceFile cache is valid");
                    AppMethodBeat.m2505o(104912);
                    return false;
                }
            }
            boolean isWifi = C5023at.isWifi(C4996ah.getContext());
            if (isWifi) {
                obj2 = c28575a.field_wifiEndFlag == 1 ? 1 : null;
            } else if (c28575a.field_endFlag == 1) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 == null || !new File(C12673b.m20673aW(c28575a.field_musicId, isWifi)).exists()) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                C4990ab.m7416i("MicroMsg.Music.MusicUrlParser", "music cache is valid");
                AppMethodBeat.m2505o(104912);
                return false;
            }
            if (oMD.mo10274aj(c28575a.playUrl)) {
                long j = 0;
                if (oME.mo10274aj(c28575a.playUrl)) {
                    j = ((Long) oME.get(c28575a.playUrl)).longValue();
                }
                if (System.currentTimeMillis() - j > 86400000) {
                    oMD.remove(c28575a.playUrl);
                    oME.remove(c28575a.playUrl);
                    C4990ab.m7416i("MicroMsg.Music.MusicUrlParser", "shake music url in cache is timeout");
                    AppMethodBeat.m2505o(104912);
                    return true;
                }
                AppMethodBeat.m2505o(104912);
                return false;
            }
            AppMethodBeat.m2505o(104912);
            return true;
        } else {
            AppMethodBeat.m2505o(104912);
            return false;
        }
    }

    /* renamed from: Tk */
    private static boolean m32747Tk(String str) {
        AppMethodBeat.m2504i(104913);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(104913);
            return false;
        } else if (str.contains("wxshakemusic")) {
            AppMethodBeat.m2505o(104913);
            return true;
        } else {
            AppMethodBeat.m2505o(104913);
            return false;
        }
    }

    /* renamed from: Tl */
    public static String m32748Tl(String str) {
        AppMethodBeat.m2504i(104914);
        if (C21349b.m32747Tk(str)) {
            int lastIndexOf = str.lastIndexOf("wxshakemusic");
            if (lastIndexOf > 1) {
                str = str.substring(0, lastIndexOf - 1);
                AppMethodBeat.m2505o(104914);
                return str;
            }
            AppMethodBeat.m2505o(104914);
            return str;
        }
        AppMethodBeat.m2505o(104914);
        return str;
    }

    /* renamed from: SP */
    public static String m32745SP(String str) {
        AppMethodBeat.m2504i(104915);
        String Th = C21349b.m32746Th(str);
        if (!TextUtils.isEmpty(Th) && !Th.equalsIgnoreCase(str)) {
            C4990ab.m7417i("MicroMsg.Music.MusicUrlParser", "use temp shake music url to play:%s", Th);
            AppMethodBeat.m2505o(104915);
            return Th;
        } else if (C21349b.m32747Tk(str)) {
            C4990ab.m7417i("MicroMsg.Music.MusicUrlParser", "play url :%s", C21349b.m32748Tl(Th));
            AppMethodBeat.m2505o(104915);
            return C21349b.m32748Tl(Th);
        } else {
            Th = "";
            AppMethodBeat.m2505o(104915);
            return Th;
        }
    }

    /* renamed from: Th */
    public static String m32746Th(String str) {
        String str2;
        AppMethodBeat.m2504i(104911);
        if (TextUtils.isEmpty(str) || !oMD.mo10274aj(str)) {
            str2 = null;
        } else {
            str2 = (String) oMD.get(str);
        }
        if (str2 == null) {
            AppMethodBeat.m2505o(104911);
            return str;
        }
        AppMethodBeat.m2505o(104911);
        return str2;
    }
}
