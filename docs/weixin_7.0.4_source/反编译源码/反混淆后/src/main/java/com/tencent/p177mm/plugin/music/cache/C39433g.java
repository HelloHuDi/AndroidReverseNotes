package com.tencent.p177mm.plugin.music.cache;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.plugin.music.p463f.p1616c.C43329b;
import com.tencent.p177mm.plugin.music.p997h.C12673b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4993ae;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.music.cache.g */
public final class C39433g {
    private static C4993ae<String, String> oLe = new C4993ae(20);
    private static C4993ae<String, Boolean> oLf = new C4993ae(20);
    private static C4993ae<String, Integer> oLg = new C4993ae(20);
    private static C4993ae<String, Integer> oLh = new C4993ae(20);
    private static C4993ae<String, Long> oLi = new C4993ae(20);
    private static C4993ae<String, String> oLj = new C4993ae(20);
    private static String oLk = null;
    private static int oLl = 0;

    static {
        AppMethodBeat.m2504i(137444);
        AppMethodBeat.m2505o(137444);
    }

    /* renamed from: SV */
    public static void m67344SV(String str) {
        AppMethodBeat.m2504i(137426);
        if (TextUtils.isEmpty(C39433g.m67345SW(str))) {
            CharSequence SR;
            if (C39432e.bTG()) {
                SR = ((C21343c) C43329b.m77295ar(C21343c.class)).mo36786SR(str);
            } else {
                C4990ab.m7412e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
                SR = "";
            }
            if (!TextUtils.isEmpty(SR)) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(SR);
                new C46095f(arrayList).bTy();
                if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(SR))) {
                    oLe.put(str, SR);
                }
            }
            AppMethodBeat.m2505o(137426);
            return;
        }
        AppMethodBeat.m2505o(137426);
    }

    public static String getAccPath() {
        AppMethodBeat.m2504i(137427);
        String str;
        if (oLk != null) {
            str = oLk;
            AppMethodBeat.m2505o(137427);
            return str;
        }
        str = C39432e.getAccPath();
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7417i("MicroMsg.Music.PieceCacheHelper", "retAccPath:%s is invalid", str);
            str = C1761b.eSn;
            AppMethodBeat.m2505o(137427);
            return str;
        }
        C4990ab.m7417i("MicroMsg.Music.PieceCacheHelper", "getAccPath retAccPath:%s", str);
        oLk = str;
        AppMethodBeat.m2505o(137427);
        return str;
    }

    public static int bTA() {
        AppMethodBeat.m2504i(137428);
        int i;
        if (oLl != 0) {
            i = oLl;
            AppMethodBeat.m2505o(137428);
            return i;
        }
        if (C39432e.bTG()) {
            i = ((C21343c) C43329b.m77295ar(C21343c.class)).bTA();
        } else {
            C4990ab.m7412e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
            i = 3;
        }
        oLl = i;
        C4990ab.m7417i("MicroMsg.Music.PieceCacheHelper", "sRemovePlayingAudioPlayerGroupCount:%d", Integer.valueOf(oLl));
        if (oLl == 0) {
            oLl = 3;
        }
        i = oLl;
        AppMethodBeat.m2505o(137428);
        return i;
    }

    /* renamed from: SW */
    public static String m67345SW(String str) {
        AppMethodBeat.m2504i(137429);
        String str2;
        if (oLe.mo10274aj(str)) {
            str2 = (String) oLe.get(str);
            AppMethodBeat.m2505o(137429);
            return str2;
        }
        str2 = "";
        AppMethodBeat.m2505o(137429);
        return str2;
    }

    /* renamed from: aV */
    public static void m67352aV(String str, boolean z) {
        AppMethodBeat.m2504i(137430);
        if (!TextUtils.isEmpty(str)) {
            oLf.put(str, Boolean.valueOf(z));
        }
        AppMethodBeat.m2505o(137430);
    }

    /* renamed from: SX */
    public static boolean m67346SX(String str) {
        AppMethodBeat.m2504i(137431);
        if (oLf.mo10274aj(str)) {
            boolean booleanValue = ((Boolean) oLf.get(str)).booleanValue();
            AppMethodBeat.m2505o(137431);
            return booleanValue;
        }
        AppMethodBeat.m2505o(137431);
        return false;
    }

    /* renamed from: r */
    public static void m67358r(String str, Map<String, String> map) {
        AppMethodBeat.m2504i(137432);
        if (map != null && C39433g.m67346SX(str)) {
            map.put("Cookie", "qqmusic_fromtag=97;qqmusic_uin=1234567;qqmusic_key=;");
            map.put("referer", "stream12.qqmusic.qq.com");
        }
        AppMethodBeat.m2505o(137432);
    }

    /* renamed from: fo */
    public static void m67357fo(String str, String str2) {
        AppMethodBeat.m2504i(137433);
        String SW = C39433g.m67345SW(str);
        if (TextUtils.isEmpty(SW)) {
            C4990ab.m7412e("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType musicId is empty!");
            AppMethodBeat.m2505o(137433);
        } else if (TextUtils.isEmpty(C39433g.m67348SZ(str))) {
            C4990ab.m7417i("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType url:%s mimeType:%s", str, str2);
            if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
                oLj.put(str, str2);
            }
            if (C39432e.bTG()) {
                ((C21343c) C43329b.m77295ar(C21343c.class)).mo36797fm(SW, str2);
                AppMethodBeat.m2505o(137433);
                return;
            }
            C4990ab.m7412e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
            AppMethodBeat.m2505o(137433);
        } else {
            AppMethodBeat.m2505o(137433);
        }
    }

    /* renamed from: SY */
    public static String m67347SY(String str) {
        AppMethodBeat.m2504i(137434);
        String SW = C39433g.m67345SW(str);
        if (TextUtils.isEmpty(SW)) {
            C4990ab.m7412e("MicroMsg.Music.PieceCacheHelper", "getMusicMIMEType musicId is empty!");
            AppMethodBeat.m2505o(137434);
            return null;
        } else if (C39432e.bTG()) {
            String ST = ((C21343c) C43329b.m77295ar(C21343c.class)).mo36788ST(SW);
            AppMethodBeat.m2505o(137434);
            return ST;
        } else {
            C4990ab.m7412e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
            AppMethodBeat.m2505o(137434);
            return null;
        }
    }

    /* renamed from: SZ */
    public static String m67348SZ(String str) {
        AppMethodBeat.m2504i(137435);
        if (oLj.mo10274aj(str)) {
            String str2 = (String) oLj.get(str);
            AppMethodBeat.m2505o(137435);
            return str2;
        }
        AppMethodBeat.m2505o(137435);
        return null;
    }

    /* renamed from: Ta */
    public static long m67349Ta(String str) {
        AppMethodBeat.m2504i(137436);
        if (oLi.mo10274aj(str)) {
            long longValue = ((Long) oLi.get(str)).longValue();
            AppMethodBeat.m2505o(137436);
            return longValue;
        }
        AppMethodBeat.m2505o(137436);
        return -1;
    }

    /* renamed from: ah */
    public static void m67353ah(String str, long j) {
        AppMethodBeat.m2504i(137437);
        if (j > 0) {
            oLi.put(str, Long.valueOf(j));
        }
        AppMethodBeat.m2505o(137437);
    }

    /* renamed from: ek */
    public static long m67356ek(String str) {
        AppMethodBeat.m2504i(137438);
        long ek = C43322h.m77266ek(str);
        AppMethodBeat.m2505o(137438);
        return ek;
    }

    /* renamed from: cI */
    public static void m67354cI(String str, int i) {
        AppMethodBeat.m2504i(137440);
        if (str != null) {
            oLg.put(str, Integer.valueOf(i));
        }
        AppMethodBeat.m2505o(137440);
    }

    /* renamed from: Tb */
    public static int m67350Tb(String str) {
        AppMethodBeat.m2504i(137441);
        if (str == null || !oLg.mo10274aj(str)) {
            AppMethodBeat.m2505o(137441);
            return 0;
        }
        int intValue = ((Integer) oLg.get(str)).intValue();
        AppMethodBeat.m2505o(137441);
        return intValue;
    }

    /* renamed from: cJ */
    public static void m67355cJ(String str, int i) {
        AppMethodBeat.m2504i(137442);
        if (str != null) {
            oLh.put(str, Integer.valueOf(i));
        }
        AppMethodBeat.m2505o(137442);
    }

    /* renamed from: Tc */
    public static int m67351Tc(String str) {
        AppMethodBeat.m2504i(137443);
        if (str == null || !oLh.mo10274aj(str)) {
            AppMethodBeat.m2505o(137443);
            return 0;
        }
        int intValue = ((Integer) oLh.get(str)).intValue();
        AppMethodBeat.m2505o(137443);
        return intValue;
    }

    /* renamed from: HS */
    public static void m67343HS(String str) {
        AppMethodBeat.m2504i(137439);
        Logger.m71025i("MicroMsg.Music.PieceFileCache", "deleteFileByUrl");
        C43322h.m77263HS(C12673b.m20672Tv(str));
        AppMethodBeat.m2505o(137439);
    }
}
