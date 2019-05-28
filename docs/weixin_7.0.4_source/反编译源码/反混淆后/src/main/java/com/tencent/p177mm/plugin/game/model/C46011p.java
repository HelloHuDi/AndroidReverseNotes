package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C9497vv;
import com.tencent.p177mm.plugin.game.model.C28229n.C28233i;
import com.tencent.p177mm.plugin.game.model.C28229n.C3244a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.game.model.p */
public final class C46011p {

    /* renamed from: com.tencent.mm.plugin.game.model.p$1 */
    public static class C210061 implements Runnable {
        final /* synthetic */ String mXE;
        final /* synthetic */ int mXF;

        public C210061(String str, int i) {
            this.mXE = str;
            this.mXF = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(111299);
            C4990ab.m7417i("MicroMsg.GameMessageParser", "MicroMsg.Wepkg message pkgid:%s, downloadTriggerType:%d", this.mXE, Integer.valueOf(this.mXF));
            if (!C5046bo.isNullOrNil(this.mXE)) {
                C9497vv c9497vv = new C9497vv();
                c9497vv.cSX.cuy = 1;
                c9497vv.cSX.cSY = this.mXE;
                c9497vv.cSX.cTb = this.mXF;
                C4879a.xxA.mo10055m(c9497vv);
                C7060h.pYm.mo8378a(858, 15, 1, false);
            }
            AppMethodBeat.m2505o(111299);
        }
    }

    /* renamed from: a */
    public static void m85489a(C28229n c28229n) {
        AppMethodBeat.m2504i(111300);
        if (C5046bo.isNullOrNil(c28229n.field_rawXML)) {
            C4990ab.m7412e("MicroMsg.GameMessageParser", "msg content is null");
            AppMethodBeat.m2505o(111300);
            return;
        }
        Map z = C5049br.m7595z(c28229n.field_rawXML, "sysmsg");
        if (z == null || z.size() == 0) {
            C4990ab.m7412e("MicroMsg.GameMessageParser", "Parse failed");
            AppMethodBeat.m2505o(111300);
        } else if ("gamecenter".equalsIgnoreCase((String) z.get(".sysmsg.$type"))) {
            C46011p.m85490a(z, c28229n);
            C46011p.m85491b(z, c28229n);
            C46011p.m85494e(z, c28229n);
            C46011p.m85495f(z, c28229n);
            C46011p.m85496g(z, c28229n);
            C46011p.m85497h(z, c28229n);
            C46011p.m85498i(z, c28229n);
            C46011p.m85500k(z, c28229n);
            C46011p.m85493d(z, c28229n);
            C46011p.m85503n(z, c28229n);
            C46011p.m85492c(z, c28229n);
            AppMethodBeat.m2505o(111300);
        } else {
            C4990ab.m7412e("MicroMsg.GameMessageParser", "Type not matched");
            AppMethodBeat.m2505o(111300);
        }
    }

    /* renamed from: I */
    public static String m85487I(Map<String, String> map) {
        AppMethodBeat.m2504i(111301);
        String bc = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.formatcontent"), "");
        AppMethodBeat.m2505o(111301);
        return bc;
    }

    /* renamed from: a */
    private static void m85490a(Map<String, String> map, C28229n c28229n) {
        AppMethodBeat.m2504i(111302);
        c28229n.mWC = C5046bo.getInt((String) map.get(".sysmsg.gamecenter.wifi_flag"), 0);
        AppMethodBeat.m2505o(111302);
    }

    /* renamed from: b */
    private static void m85491b(Map<String, String> map, C28229n c28229n) {
        AppMethodBeat.m2504i(111303);
        c28229n.kYQ = C46011p.m85487I(map);
        c28229n.mWh = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.url"), "");
        c28229n.mWv = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.msg_picture_url"), "");
        c28229n.mWi = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_url"), "");
        if (C5046bo.isNullOrNil(c28229n.mWi)) {
            c28229n.mWi = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.url"), "");
        }
        c28229n.mXa = C5046bo.getInt((String) map.get(".sysmsg.gamecenter.notify_type"), 0);
        AppMethodBeat.m2505o(111303);
    }

    /* renamed from: c */
    private static void m85492c(Map<String, String> map, C28229n c28229n) {
        AppMethodBeat.m2504i(111304);
        switch (c28229n.field_msgType) {
            case 2:
                C46011p.m85499j(map, c28229n);
                C4990ab.m7417i("MicroMsg.GameMessageParser", "Received a ShareMsg: %s", c28229n.field_appId);
                AppMethodBeat.m2505o(111304);
                return;
            case 4:
                AppMethodBeat.m2505o(111304);
                return;
            case 5:
                C46011p.m85501l(map, c28229n);
                AppMethodBeat.m2505o(111304);
                return;
            case 6:
                C46011p.m85502m(map, c28229n);
                AppMethodBeat.m2505o(111304);
                return;
            case 10:
            case 11:
                AppMethodBeat.m2505o(111304);
                return;
            default:
                C4990ab.m7412e("MicroMsg.GameMessageParser", "error gamecenter type: " + c28229n.field_msgType);
                AppMethodBeat.m2505o(111304);
                return;
        }
    }

    /* renamed from: d */
    private static void m85493d(Map<String, String> map, C28229n c28229n) {
        AppMethodBeat.m2504i(111305);
        c28229n.mWw = C5046bo.getInt((String) map.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_action"), 0);
        c28229n.mWt.mXj = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_icon_url"), "");
        c28229n.mWt.eeO = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_desc"), "");
        AppMethodBeat.m2505o(111305);
    }

    /* renamed from: e */
    private static void m85494e(Map<String, String> map, C28229n c28229n) {
        AppMethodBeat.m2504i(111306);
        c28229n.mAppName = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.appinfo.appname2"), "");
        if (C5046bo.isNullOrNil(c28229n.mAppName)) {
            c28229n.mAppName = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.appinfo.appname"), "");
        }
        if (c28229n.field_msgType == 6) {
            c28229n.mWn = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.appinfo.groupname"), "");
            c28229n.mWo = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.appinfo.groupurl"), "");
        } else {
            c28229n.mWn = c28229n.mAppName;
        }
        c28229n.mWj = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.appinfo.iconurl"), "");
        c28229n.mWk = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.appinfo.android_downloadurl"), "");
        c28229n.mWl = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.appinfo.android_apk_md5"), "");
        c28229n.mWm = C5046bo.getInt((String) map.get(".sysmsg.gamecenter.appinfo.android_apk_size"), 0);
        AppMethodBeat.m2505o(111306);
    }

    /* renamed from: f */
    private static void m85495f(Map<String, String> map, C28229n c28229n) {
        AppMethodBeat.m2504i(111307);
        c28229n.mWp.clear();
        String str = ".sysmsg.gamecenter.userinfo";
        int i = 0;
        while (true) {
            Object obj;
            if (i == 0) {
                obj = str;
            } else {
                String obj2 = str + i;
            }
            if (map.containsKey(obj2)) {
                C28233i c28233i = new C28233i();
                c28233i.userName = C5046bo.m7532bc((String) map.get(obj2 + ".username"), "");
                c28233i.bCu = C5046bo.m7532bc((String) map.get(obj2 + ".nickname"), "");
                c28233i.mXu = C5046bo.m7532bc((String) map.get(obj2 + ".usericon"), "");
                c28233i.mXw = C5046bo.m7532bc((String) map.get(obj2 + ".badge_icon"), "");
                c28233i.mXx = C5046bo.m7532bc((String) map.get(obj2 + ".$jump_id"), "");
                c28229n.mWp.add(c28233i);
                i++;
            } else {
                AppMethodBeat.m2505o(111307);
                return;
            }
        }
    }

    /* renamed from: g */
    private static void m85496g(Map<String, String> map, C28229n c28229n) {
        AppMethodBeat.m2504i(111308);
        c28229n.mXc = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.noticeid"), "");
        AppMethodBeat.m2505o(111308);
    }

    /* renamed from: J */
    public static long m85488J(Map<String, String> map) {
        AppMethodBeat.m2504i(111309);
        long j = C5046bo.getLong((String) map.get(".sysmsg.game_control_info.control_flag"), 0);
        AppMethodBeat.m2505o(111309);
        return j;
    }

    /* renamed from: h */
    private static void m85497h(Map<String, String> map, C28229n c28229n) {
        AppMethodBeat.m2504i(111310);
        c28229n.mWD = C46011p.m85488J(map);
        AppMethodBeat.m2505o(111310);
    }

    /* renamed from: i */
    private static void m85498i(Map<String, String> map, C28229n c28229n) {
        AppMethodBeat.m2504i(111311);
        c28229n.mWr.mXl = C5046bo.getInt((String) map.get(".sysmsg.gamecenter.badge_display_type"), 0);
        c28229n.mWr.mXj = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.showiconurl"), "");
        c28229n.mWr.mText = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.entrancetext"), "");
        AppMethodBeat.m2505o(111311);
    }

    /* renamed from: j */
    private static void m85499j(Map<String, String> map, C28229n c28229n) {
        AppMethodBeat.m2504i(111312);
        c28229n.mWx = C5046bo.getInt((String) map.get(".sysmsg.gameshare.share_message_info.share_msg_type"), 1);
        c28229n.mWy = C5046bo.getInt((String) map.get(".sysmsg.game_control_info.display_name_type"), 1);
        c28229n.mWz = C5046bo.m7532bc((String) map.get(".sysmsg.gameshare.share_message_info.share_msg_title"), "");
        c28229n.mWA = C5046bo.m7532bc((String) map.get(".sysmsg.gameshare.share_message_info.share_msg_content"), "");
        c28229n.mWB = C5046bo.m7532bc((String) map.get(".sysmsg.gameshare.share_message_info.media_url"), "");
        c28229n.mWv = C5046bo.m7532bc((String) map.get(".sysmsg.gameshare.share_message_info.thumb_url"), "");
        AppMethodBeat.m2505o(111312);
    }

    /* renamed from: k */
    public static void m85500k(Map<String, String> map, C28229n c28229n) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(111313);
        c28229n.mWG.url = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.floatlayer.open_url"), "");
        C3244a c3244a = c28229n.mWG;
        if (C5046bo.getInt((String) map.get(".sysmsg.gamecenter.floatlayer.full_screen"), 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        c3244a.mTC = z;
        c28229n.mWG.orientation = C5046bo.getInt((String) map.get(".sysmsg.gamecenter.floatlayer.orientation"), 0);
        c3244a = c28229n.mWG;
        if (C5046bo.getInt((String) map.get(".sysmsg.gamecenter.floatlayer.is_transparent"), 0) != 1) {
            z2 = false;
        }
        c3244a.mXg = z2;
        AppMethodBeat.m2505o(111313);
    }

    /* renamed from: l */
    private static void m85501l(Map<String, String> map, C28229n c28229n) {
        AppMethodBeat.m2504i(111314);
        c28229n.mWL = C5046bo.m7532bc((String) map.get(".sysmsg.gamepraise.praise_message_info.praise_content"), "");
        c28229n.mWM = C5046bo.m7532bc((String) map.get(".sysmsg.gamepraise.praise_message_info.praise_jumpurl"), "");
        c28229n.mWN = C5046bo.m7532bc((String) map.get(".sysmsg.gamepraise.praise_message_info.praise_iconurl"), "");
        AppMethodBeat.m2505o(111314);
    }

    /* renamed from: m */
    private static void m85502m(Map<String, String> map, C28229n c28229n) {
        AppMethodBeat.m2504i(111315);
        c28229n.mWH = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.topic.reply_content"), "");
        c28229n.mWI = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.topic.replied_content"), "");
        c28229n.mWK = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.topic.topic_title"), "");
        c28229n.mWJ = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.topic.topic_url"), "");
        AppMethodBeat.m2505o(111315);
    }

    /* renamed from: n */
    private static void m85503n(Map<String, String> map, C28229n c28229n) {
        AppMethodBeat.m2504i(111316);
        c28229n.mXd = C5046bo.getInt((String) map.get(".sysmsg.gamecenter.message_card.message_card_jump_type"), 0);
        c28229n.mXe = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.message_card.message_card_jump_url"), "");
        AppMethodBeat.m2505o(111316);
    }
}
