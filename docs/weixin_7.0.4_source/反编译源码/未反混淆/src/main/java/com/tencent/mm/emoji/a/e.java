package com.tencent.mm.emoji.a;

import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;

public final class e {
    private static boolean ezc = false;
    private static boolean ezd = false;
    private static boolean eze = false;
    private static boolean ezf = false;
    private static boolean ezg = false;
    private static boolean ezh = false;

    public static boolean OJ() {
        AppMethodBeat.i(62250);
        if ((g.Nu().getInt("EmotionRewardOption", 0) & 1) == 1) {
            AppMethodBeat.o(62250);
            return false;
        }
        AppMethodBeat.o(62250);
        return true;
    }

    public static boolean OK() {
        AppMethodBeat.i(62251);
        if ((g.Nu().getInt("EmotionRewardOption", 0) & 2) == 2) {
            AppMethodBeat.o(62251);
            return false;
        }
        AppMethodBeat.o(62251);
        return true;
    }

    public static boolean OL() {
        AppMethodBeat.i(62252);
        if ((g.Nu().getInt("EmotionRewardOption", 0) & 4) == 4) {
            AppMethodBeat.o(62252);
            return true;
        }
        AppMethodBeat.o(62252);
        return false;
    }

    public static int OM() {
        AppMethodBeat.i(62253);
        int i = bo.getInt(g.Nu().getValue("CustomEmojiMaxSize"), 300);
        AppMethodBeat.o(62253);
        return i;
    }

    public static int ON() {
        AppMethodBeat.i(62254);
        int i = bo.getInt(g.Nu().getValue("CustomEmojiMaxSize"), 300);
        AppMethodBeat.o(62254);
        return i;
    }

    public static String OO() {
        AppMethodBeat.i(62255);
        String value = g.Nu().getValue("C2CEmojiNotAutoDownloadTimeRange");
        AppMethodBeat.o(62255);
        return value;
    }

    public static String OP() {
        AppMethodBeat.i(62256);
        String value = g.Nu().getValue("EmotionPanelConfigName");
        AppMethodBeat.o(62256);
        return value;
    }

    public static boolean OQ() {
        AppMethodBeat.i(62257);
        if (!ezc) {
            int i = g.Nu().getInt("EnableEmoticonExternUrl", 0);
            int errorCode = MMWXGFJNI.getErrorCode();
            if ((i & 1) != 1) {
                ezf = false;
            } else if (OX() || OY()) {
                ezf = false;
            } else {
                ezf = true;
            }
            if (errorCode < 0) {
                ezf = false;
                switch (errorCode) {
                    case -906:
                        h.pYm.a(711, 10, 1, false);
                        break;
                    case -905:
                        h.pYm.a(711, 9, 1, false);
                        break;
                    case -904:
                        h.pYm.a(711, 8, 1, false);
                        break;
                    case -903:
                        h.pYm.a(711, 7, 1, false);
                        break;
                    case -902:
                        h.pYm.a(711, 6, 1, false);
                        break;
                    case -901:
                        h.pYm.a(711, 5, 1, false);
                        break;
                }
            }
            ezc = true;
            ab.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDownload:%b", Boolean.valueOf(ezf));
        }
        boolean z = ezf;
        AppMethodBeat.o(62257);
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean OR() {
        AppMethodBeat.i(62258);
        if (!ezd) {
            int i = g.Nu().getInt("EnableEmoticonExternUrl", 0);
            int errorCode = MMWXGFJNI.getErrorCode();
            if ((i & 2) == 2) {
                if (OX() || OY()) {
                    h.pYm.a(711, 0, 1, false);
                } else {
                    ezg = true;
                    h.pYm.a(711, 1, 1, false);
                    if (errorCode < 0) {
                        ezg = false;
                    }
                    ezd = true;
                    ab.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDecode:%b", Boolean.valueOf(ezg));
                }
            }
            ezg = false;
            if (errorCode < 0) {
            }
            ezd = true;
            ab.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDecode:%b", Boolean.valueOf(ezg));
        }
        boolean z = ezg;
        AppMethodBeat.o(62258);
        return z;
    }

    public static boolean OS() {
        AppMethodBeat.i(62259);
        if (!eze) {
            if ((g.Nu().getInt("EnableEmoticonExternUrl", 0) & 4) == 4) {
                ezh = true;
            } else {
                ezh = false;
            }
            eze = true;
        }
        ab.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcUpload:%b", Boolean.valueOf(ezh));
        boolean z = ezh;
        AppMethodBeat.o(62259);
        return z;
    }

    public static boolean OT() {
        AppMethodBeat.i(62260);
        if ((g.Nu().getInt("ShowEmoticonCameraEntrance", 3) & 1) > 0) {
            AppMethodBeat.o(62260);
            return true;
        }
        AppMethodBeat.o(62260);
        return false;
    }

    public static boolean OU() {
        AppMethodBeat.i(62261);
        if ((g.Nu().getInt("ShowEmoticonCameraEntrance", 3) & 2) > 0) {
            AppMethodBeat.o(62261);
            return true;
        }
        AppMethodBeat.o(62261);
        return false;
    }

    public static boolean isSpringFestivalEnable() {
        AppMethodBeat.i(62262);
        ((a) com.tencent.mm.kernel.g.K(a.class)).a(a.a.clicfg_emoji_spring_festival, 0);
        g.Nu().getInt("EmotionSpringFestivalPendantSwitch", 0);
        AppMethodBeat.o(62262);
        return false;
    }

    public static boolean OV() {
        AppMethodBeat.i(62263);
        if (com.tencent.mm.kernel.g.RP().Ry().getInt(ac.a.USERINFO_EMOJI_SPRING_FESTIVAL_CROP_TYPE_INT, 1) == 0) {
            AppMethodBeat.o(62263);
            return true;
        }
        AppMethodBeat.o(62263);
        return false;
    }

    public static boolean OW() {
        AppMethodBeat.i(62264);
        if (g.Nu().getInt("ForbiddenEmotionSpringFestivalMsgTail", 0) > 0) {
            AppMethodBeat.o(62264);
            return false;
        }
        AppMethodBeat.o(62264);
        return true;
    }

    private static boolean OX() {
        boolean z = true;
        AppMethodBeat.i(62265);
        try {
            ah.getContext().getPackageManager().getPackageInfo("com.google.android.wearable.app.cn", 1);
        } catch (NameNotFoundException e) {
            z = false;
        }
        AppMethodBeat.o(62265);
        return z;
    }

    private static boolean OY() {
        boolean z = true;
        AppMethodBeat.i(62266);
        try {
            ah.getContext().getPackageManager().getPackageInfo("com.google.android.wearable.app", 1);
        } catch (NameNotFoundException e) {
            z = false;
        }
        AppMethodBeat.o(62266);
        return z;
    }
}
