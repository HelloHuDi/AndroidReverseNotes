package com.tencent.p177mm.emoji.p227a;

import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.gif.MMWXGFJNI;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.emoji.a.e */
public final class C26072e {
    private static boolean ezc = false;
    private static boolean ezd = false;
    private static boolean eze = false;
    private static boolean ezf = false;
    private static boolean ezg = false;
    private static boolean ezh = false;

    /* renamed from: OJ */
    public static boolean m41615OJ() {
        AppMethodBeat.m2504i(62250);
        if ((C26373g.m41964Nu().getInt("EmotionRewardOption", 0) & 1) == 1) {
            AppMethodBeat.m2505o(62250);
            return false;
        }
        AppMethodBeat.m2505o(62250);
        return true;
    }

    /* renamed from: OK */
    public static boolean m41616OK() {
        AppMethodBeat.m2504i(62251);
        if ((C26373g.m41964Nu().getInt("EmotionRewardOption", 0) & 2) == 2) {
            AppMethodBeat.m2505o(62251);
            return false;
        }
        AppMethodBeat.m2505o(62251);
        return true;
    }

    /* renamed from: OL */
    public static boolean m41617OL() {
        AppMethodBeat.m2504i(62252);
        if ((C26373g.m41964Nu().getInt("EmotionRewardOption", 0) & 4) == 4) {
            AppMethodBeat.m2505o(62252);
            return true;
        }
        AppMethodBeat.m2505o(62252);
        return false;
    }

    /* renamed from: OM */
    public static int m41618OM() {
        AppMethodBeat.m2504i(62253);
        int i = C5046bo.getInt(C26373g.m41964Nu().getValue("CustomEmojiMaxSize"), 300);
        AppMethodBeat.m2505o(62253);
        return i;
    }

    /* renamed from: ON */
    public static int m41619ON() {
        AppMethodBeat.m2504i(62254);
        int i = C5046bo.getInt(C26373g.m41964Nu().getValue("CustomEmojiMaxSize"), 300);
        AppMethodBeat.m2505o(62254);
        return i;
    }

    /* renamed from: OO */
    public static String m41620OO() {
        AppMethodBeat.m2504i(62255);
        String value = C26373g.m41964Nu().getValue("C2CEmojiNotAutoDownloadTimeRange");
        AppMethodBeat.m2505o(62255);
        return value;
    }

    /* renamed from: OP */
    public static String m41621OP() {
        AppMethodBeat.m2504i(62256);
        String value = C26373g.m41964Nu().getValue("EmotionPanelConfigName");
        AppMethodBeat.m2505o(62256);
        return value;
    }

    /* renamed from: OQ */
    public static boolean m41622OQ() {
        AppMethodBeat.m2504i(62257);
        if (!ezc) {
            int i = C26373g.m41964Nu().getInt("EnableEmoticonExternUrl", 0);
            int errorCode = MMWXGFJNI.getErrorCode();
            if ((i & 1) != 1) {
                ezf = false;
            } else if (C26072e.m41629OX() || C26072e.m41630OY()) {
                ezf = false;
            } else {
                ezf = true;
            }
            if (errorCode < 0) {
                ezf = false;
                switch (errorCode) {
                    case -906:
                        C7060h.pYm.mo8378a(711, 10, 1, false);
                        break;
                    case -905:
                        C7060h.pYm.mo8378a(711, 9, 1, false);
                        break;
                    case -904:
                        C7060h.pYm.mo8378a(711, 8, 1, false);
                        break;
                    case -903:
                        C7060h.pYm.mo8378a(711, 7, 1, false);
                        break;
                    case -902:
                        C7060h.pYm.mo8378a(711, 6, 1, false);
                        break;
                    case -901:
                        C7060h.pYm.mo8378a(711, 5, 1, false);
                        break;
                }
            }
            ezc = true;
            C4990ab.m7417i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDownload:%b", Boolean.valueOf(ezf));
        }
        boolean z = ezf;
        AppMethodBeat.m2505o(62257);
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: OR */
    public static boolean m41623OR() {
        AppMethodBeat.m2504i(62258);
        if (!ezd) {
            int i = C26373g.m41964Nu().getInt("EnableEmoticonExternUrl", 0);
            int errorCode = MMWXGFJNI.getErrorCode();
            if ((i & 2) == 2) {
                if (C26072e.m41629OX() || C26072e.m41630OY()) {
                    C7060h.pYm.mo8378a(711, 0, 1, false);
                } else {
                    ezg = true;
                    C7060h.pYm.mo8378a(711, 1, 1, false);
                    if (errorCode < 0) {
                        ezg = false;
                    }
                    ezd = true;
                    C4990ab.m7417i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDecode:%b", Boolean.valueOf(ezg));
                }
            }
            ezg = false;
            if (errorCode < 0) {
            }
            ezd = true;
            C4990ab.m7417i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDecode:%b", Boolean.valueOf(ezg));
        }
        boolean z = ezg;
        AppMethodBeat.m2505o(62258);
        return z;
    }

    /* renamed from: OS */
    public static boolean m41624OS() {
        AppMethodBeat.m2504i(62259);
        if (!eze) {
            if ((C26373g.m41964Nu().getInt("EnableEmoticonExternUrl", 0) & 4) == 4) {
                ezh = true;
            } else {
                ezh = false;
            }
            eze = true;
        }
        C4990ab.m7417i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcUpload:%b", Boolean.valueOf(ezh));
        boolean z = ezh;
        AppMethodBeat.m2505o(62259);
        return z;
    }

    /* renamed from: OT */
    public static boolean m41625OT() {
        AppMethodBeat.m2504i(62260);
        if ((C26373g.m41964Nu().getInt("ShowEmoticonCameraEntrance", 3) & 1) > 0) {
            AppMethodBeat.m2505o(62260);
            return true;
        }
        AppMethodBeat.m2505o(62260);
        return false;
    }

    /* renamed from: OU */
    public static boolean m41626OU() {
        AppMethodBeat.m2504i(62261);
        if ((C26373g.m41964Nu().getInt("ShowEmoticonCameraEntrance", 3) & 2) > 0) {
            AppMethodBeat.m2505o(62261);
            return true;
        }
        AppMethodBeat.m2505o(62261);
        return false;
    }

    public static boolean isSpringFestivalEnable() {
        AppMethodBeat.m2504i(62262);
        ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_emoji_spring_festival, 0);
        C26373g.m41964Nu().getInt("EmotionSpringFestivalPendantSwitch", 0);
        AppMethodBeat.m2505o(62262);
        return false;
    }

    /* renamed from: OV */
    public static boolean m41627OV() {
        AppMethodBeat.m2504i(62263);
        if (C1720g.m3536RP().mo5239Ry().getInt(C5127a.USERINFO_EMOJI_SPRING_FESTIVAL_CROP_TYPE_INT, 1) == 0) {
            AppMethodBeat.m2505o(62263);
            return true;
        }
        AppMethodBeat.m2505o(62263);
        return false;
    }

    /* renamed from: OW */
    public static boolean m41628OW() {
        AppMethodBeat.m2504i(62264);
        if (C26373g.m41964Nu().getInt("ForbiddenEmotionSpringFestivalMsgTail", 0) > 0) {
            AppMethodBeat.m2505o(62264);
            return false;
        }
        AppMethodBeat.m2505o(62264);
        return true;
    }

    /* renamed from: OX */
    private static boolean m41629OX() {
        boolean z = true;
        AppMethodBeat.m2504i(62265);
        try {
            C4996ah.getContext().getPackageManager().getPackageInfo("com.google.android.wearable.app.cn", 1);
        } catch (NameNotFoundException e) {
            z = false;
        }
        AppMethodBeat.m2505o(62265);
        return z;
    }

    /* renamed from: OY */
    private static boolean m41630OY() {
        boolean z = true;
        AppMethodBeat.m2504i(62266);
        try {
            C4996ah.getContext().getPackageManager().getPackageInfo("com.google.android.wearable.app", 1);
        } catch (NameNotFoundException e) {
            z = false;
        }
        AppMethodBeat.m2505o(62266);
        return z;
    }
}
