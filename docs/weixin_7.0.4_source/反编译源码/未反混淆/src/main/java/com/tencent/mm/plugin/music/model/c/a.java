package com.tencent.mm.plugin.music.model.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.c;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static HashMap<Integer, Boolean> oMV = new HashMap();
    private static HashMap<Integer, Long> oMW = new HashMap();

    static {
        AppMethodBeat.i(105003);
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
        AppMethodBeat.o(105003);
    }

    public static boolean zF(int i) {
        AppMethodBeat.i(105000);
        long currentTimeMillis = System.currentTimeMillis();
        boolean booleanValue;
        if (currentTimeMillis - ((Long) oMW.get(Integer.valueOf(i))).longValue() < 10000) {
            booleanValue = ((Boolean) oMV.get(Integer.valueOf(i))).booleanValue();
            AppMethodBeat.o(105000);
            return booleanValue;
        }
        oMW.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
        c ll = com.tencent.mm.model.c.c.abi().ll("100283");
        if (ll.isValid()) {
            Map dru = ll.dru();
            if (dru == null) {
                ab.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer args == null");
                booleanValue = zL(i);
                AppMethodBeat.o(105000);
                return booleanValue;
            } else if (!dru.containsKey("support_player_flag")) {
                ab.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer not contain the support_player_flag key");
                booleanValue = zL(i);
                AppMethodBeat.o(105000);
                return booleanValue;
            } else if (TextUtils.isEmpty((CharSequence) dru.get("support_player_flag"))) {
                ab.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer not contain the the value is empty");
                booleanValue = zL(i);
                AppMethodBeat.o(105000);
                return booleanValue;
            } else {
                int intValue;
                try {
                    intValue = Integer.valueOf((String) dru.get("support_player_flag"), 16).intValue();
                } catch (NumberFormatException e) {
                    ab.printErrStackTrace("MicroMsg.Music.MusicPlayerSwitcher", e, "supportQQMusicPlayer", new Object[0]);
                    intValue = 0;
                }
                ab.i("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer contain support_player_flag:%s", r0);
                currentTimeMillis = ((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_MUSIC_SUPPORT_PLAYER_FLAG_SEQUENCE_LONG_SYNC, Long.valueOf(0))).longValue();
                if (currentTimeMillis == 0) {
                    ab.i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is 0");
                    g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_MUSIC_SUPPORT_PLAYER_FLAG_SEQUENCE_LONG_SYNC, Long.valueOf(ll.field_sequence));
                    g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_MUSIC_PLAYER_SWITCH_FLAG_INT_SYNC, Integer.valueOf(intValue));
                    booleanValue = eI(i, intValue);
                } else if (currentTimeMillis == ll.field_sequence) {
                    ab.i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is equal, check flag from local switch flag");
                    booleanValue = eI(i, ((Integer) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_MUSIC_PLAYER_SWITCH_FLAG_INT_SYNC, Integer.valueOf(intValue))).intValue());
                } else {
                    ab.i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is diff, update local data");
                    g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_MUSIC_SUPPORT_PLAYER_FLAG_SEQUENCE_LONG_SYNC, Long.valueOf(ll.field_sequence));
                    g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_MUSIC_PLAYER_SWITCH_FLAG_INT_SYNC, Integer.valueOf(intValue));
                    booleanValue = eI(i, intValue);
                }
                oMV.put(Integer.valueOf(i), Boolean.valueOf(booleanValue));
                AppMethodBeat.o(105000);
                return booleanValue;
            }
        }
        ab.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer item.isValid is false");
        booleanValue = zL(i);
        AppMethodBeat.o(105000);
        return booleanValue;
    }

    private static boolean zL(int i) {
        AppMethodBeat.i(105001);
        boolean eI = eI(i, ((Integer) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_MUSIC_PLAYER_SWITCH_FLAG_INT_SYNC, Integer.valueOf(0))).intValue());
        ab.i("MicroMsg.Music.MusicPlayerSwitcher", "checkLocalSupportPlayerFlag support_player_flag:%s", Integer.toHexString(r0));
        oMV.put(Integer.valueOf(i), Boolean.valueOf(eI));
        AppMethodBeat.o(105001);
        return eI;
    }

    private static boolean eI(int i, int i2) {
        boolean z = true;
        AppMethodBeat.i(105002);
        if (i == 0 && (i2 & 1) > 0) {
            ab.i("MicroMsg.Music.MusicPlayerSwitcher", "support CHATTING_UI");
        } else if (i == 1 && (i2 & 2) > 0) {
            ab.i("MicroMsg.Music.MusicPlayerSwitcher", "support SNS_TIMELINE_UI");
        } else if (i == 4 && (i2 & 4) > 0) {
            ab.i("MicroMsg.Music.MusicPlayerSwitcher", "support SHAKE_MUSIC_UI");
        } else if (i == 5 && (i2 & 8) > 0) {
            ab.i("MicroMsg.Music.MusicPlayerSwitcher", "support PRODUCT_UI");
        } else if (i == 6 && (i2 & 16) > 0) {
            ab.i("MicroMsg.Music.MusicPlayerSwitcher", "support FAVORITE_UI");
        } else if (i == 7 && (i2 & 32) > 0) {
            ab.i("MicroMsg.Music.MusicPlayerSwitcher", "support WEBVIEW_UI");
        } else if (i == 8 && (i2 & 64) > 0) {
            ab.i("MicroMsg.Music.MusicPlayerSwitcher", "support SNS_USER_TIMELINE_UI");
        } else if (i != 9 || (i2 & 128) <= 0) {
            ab.i("MicroMsg.Music.MusicPlayerSwitcher", "QQMusicPlayer not support this scene %d", Integer.valueOf(i));
            z = false;
        } else {
            ab.i("MicroMsg.Music.MusicPlayerSwitcher", "support SEARCH_TIMELINE_UI");
        }
        AppMethodBeat.o(105002);
        return z;
    }
}
