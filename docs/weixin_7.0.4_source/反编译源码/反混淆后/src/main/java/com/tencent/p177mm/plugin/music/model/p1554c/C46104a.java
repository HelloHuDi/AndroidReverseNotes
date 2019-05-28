package com.tencent.p177mm.plugin.music.model.p1554c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C5141c;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.music.model.c.a */
public final class C46104a {
    private static HashMap<Integer, Boolean> oMV = new HashMap();
    private static HashMap<Integer, Long> oMW = new HashMap();

    static {
        AppMethodBeat.m2504i(105003);
        oMV.put(Integer.valueOf(0), Boolean.FALSE);
        oMV.put(Integer.valueOf(1), Boolean.FALSE);
        oMV.put(Integer.valueOf(4), Boolean.FALSE);
        oMV.put(Integer.valueOf(5), Boolean.FALSE);
        oMV.put(Integer.valueOf(6), Boolean.FALSE);
        oMV.put(Integer.valueOf(7), Boolean.FALSE);
        oMV.put(Integer.valueOf(8), Boolean.FALSE);
        oMV.put(Integer.valueOf(9), Boolean.FALSE);
        oMW.put(Integer.valueOf(0), Long.valueOf(0));
        oMW.put(Integer.valueOf(1), Long.valueOf(0));
        oMW.put(Integer.valueOf(4), Long.valueOf(0));
        oMW.put(Integer.valueOf(5), Long.valueOf(0));
        oMW.put(Integer.valueOf(6), Long.valueOf(0));
        oMW.put(Integer.valueOf(7), Long.valueOf(0));
        oMW.put(Integer.valueOf(8), Long.valueOf(0));
        oMW.put(Integer.valueOf(9), Long.valueOf(0));
        AppMethodBeat.m2505o(105003);
    }

    /* renamed from: zF */
    public static boolean m86014zF(int i) {
        AppMethodBeat.m2504i(105000);
        long currentTimeMillis = System.currentTimeMillis();
        boolean booleanValue;
        if (currentTimeMillis - ((Long) oMW.get(Integer.valueOf(i))).longValue() < 10000) {
            booleanValue = ((Boolean) oMV.get(Integer.valueOf(i))).booleanValue();
            AppMethodBeat.m2505o(105000);
            return booleanValue;
        }
        oMW.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
        C5141c ll = C18624c.abi().mo17131ll("100283");
        if (ll.isValid()) {
            Map dru = ll.dru();
            if (dru == null) {
                C4990ab.m7412e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer args == null");
                booleanValue = C46104a.m86015zL(i);
                AppMethodBeat.m2505o(105000);
                return booleanValue;
            } else if (!dru.containsKey("support_player_flag")) {
                C4990ab.m7412e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer not contain the support_player_flag key");
                booleanValue = C46104a.m86015zL(i);
                AppMethodBeat.m2505o(105000);
                return booleanValue;
            } else if (TextUtils.isEmpty((CharSequence) dru.get("support_player_flag"))) {
                C4990ab.m7412e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer not contain the the value is empty");
                booleanValue = C46104a.m86015zL(i);
                AppMethodBeat.m2505o(105000);
                return booleanValue;
            } else {
                int intValue;
                try {
                    intValue = Integer.valueOf((String) dru.get("support_player_flag"), 16).intValue();
                } catch (NumberFormatException e) {
                    C4990ab.printErrStackTrace("MicroMsg.Music.MusicPlayerSwitcher", e, "supportQQMusicPlayer", new Object[0]);
                    intValue = 0;
                }
                C4990ab.m7417i("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer contain support_player_flag:%s", r0);
                currentTimeMillis = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_MUSIC_SUPPORT_PLAYER_FLAG_SEQUENCE_LONG_SYNC, Long.valueOf(0))).longValue();
                if (currentTimeMillis == 0) {
                    C4990ab.m7416i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is 0");
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_MUSIC_SUPPORT_PLAYER_FLAG_SEQUENCE_LONG_SYNC, Long.valueOf(ll.field_sequence));
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_MUSIC_PLAYER_SWITCH_FLAG_INT_SYNC, Integer.valueOf(intValue));
                    booleanValue = C46104a.m86013eI(i, intValue);
                } else if (currentTimeMillis == ll.field_sequence) {
                    C4990ab.m7416i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is equal, check flag from local switch flag");
                    booleanValue = C46104a.m86013eI(i, ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_MUSIC_PLAYER_SWITCH_FLAG_INT_SYNC, Integer.valueOf(intValue))).intValue());
                } else {
                    C4990ab.m7416i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is diff, update local data");
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_MUSIC_SUPPORT_PLAYER_FLAG_SEQUENCE_LONG_SYNC, Long.valueOf(ll.field_sequence));
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_MUSIC_PLAYER_SWITCH_FLAG_INT_SYNC, Integer.valueOf(intValue));
                    booleanValue = C46104a.m86013eI(i, intValue);
                }
                oMV.put(Integer.valueOf(i), Boolean.valueOf(booleanValue));
                AppMethodBeat.m2505o(105000);
                return booleanValue;
            }
        }
        C4990ab.m7412e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer item.isValid is false");
        booleanValue = C46104a.m86015zL(i);
        AppMethodBeat.m2505o(105000);
        return booleanValue;
    }

    /* renamed from: zL */
    private static boolean m86015zL(int i) {
        AppMethodBeat.m2504i(105001);
        boolean eI = C46104a.m86013eI(i, ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_MUSIC_PLAYER_SWITCH_FLAG_INT_SYNC, Integer.valueOf(0))).intValue());
        C4990ab.m7417i("MicroMsg.Music.MusicPlayerSwitcher", "checkLocalSupportPlayerFlag support_player_flag:%s", Integer.toHexString(r0));
        oMV.put(Integer.valueOf(i), Boolean.valueOf(eI));
        AppMethodBeat.m2505o(105001);
        return eI;
    }

    /* renamed from: eI */
    private static boolean m86013eI(int i, int i2) {
        boolean z = true;
        AppMethodBeat.m2504i(105002);
        if (i == 0 && (i2 & 1) > 0) {
            C4990ab.m7416i("MicroMsg.Music.MusicPlayerSwitcher", "support CHATTING_UI");
        } else if (i == 1 && (i2 & 2) > 0) {
            C4990ab.m7416i("MicroMsg.Music.MusicPlayerSwitcher", "support SNS_TIMELINE_UI");
        } else if (i == 4 && (i2 & 4) > 0) {
            C4990ab.m7416i("MicroMsg.Music.MusicPlayerSwitcher", "support SHAKE_MUSIC_UI");
        } else if (i == 5 && (i2 & 8) > 0) {
            C4990ab.m7416i("MicroMsg.Music.MusicPlayerSwitcher", "support PRODUCT_UI");
        } else if (i == 6 && (i2 & 16) > 0) {
            C4990ab.m7416i("MicroMsg.Music.MusicPlayerSwitcher", "support FAVORITE_UI");
        } else if (i == 7 && (i2 & 32) > 0) {
            C4990ab.m7416i("MicroMsg.Music.MusicPlayerSwitcher", "support WEBVIEW_UI");
        } else if (i == 8 && (i2 & 64) > 0) {
            C4990ab.m7416i("MicroMsg.Music.MusicPlayerSwitcher", "support SNS_USER_TIMELINE_UI");
        } else if (i != 9 || (i2 & 128) <= 0) {
            C4990ab.m7417i("MicroMsg.Music.MusicPlayerSwitcher", "QQMusicPlayer not support this scene %d", Integer.valueOf(i));
            z = false;
        } else {
            C4990ab.m7416i("MicroMsg.Music.MusicPlayerSwitcher", "support SEARCH_TIMELINE_UI");
        }
        AppMethodBeat.m2505o(105002);
        return z;
    }
}
