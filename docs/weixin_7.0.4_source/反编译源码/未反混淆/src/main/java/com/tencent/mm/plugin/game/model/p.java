package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vv;
import com.tencent.mm.plugin.game.model.n.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class p {

    /* renamed from: com.tencent.mm.plugin.game.model.p$1 */
    public static class AnonymousClass1 implements Runnable {
        final /* synthetic */ String mXE;
        final /* synthetic */ int mXF;

        public AnonymousClass1(String str, int i) {
            this.mXE = str;
            this.mXF = i;
        }

        public final void run() {
            AppMethodBeat.i(111299);
            ab.i("MicroMsg.GameMessageParser", "MicroMsg.Wepkg message pkgid:%s, downloadTriggerType:%d", this.mXE, Integer.valueOf(this.mXF));
            if (!bo.isNullOrNil(this.mXE)) {
                vv vvVar = new vv();
                vvVar.cSX.cuy = 1;
                vvVar.cSX.cSY = this.mXE;
                vvVar.cSX.cTb = this.mXF;
                a.xxA.m(vvVar);
                h.pYm.a(858, 15, 1, false);
            }
            AppMethodBeat.o(111299);
        }
    }

    public static void a(n nVar) {
        AppMethodBeat.i(111300);
        if (bo.isNullOrNil(nVar.field_rawXML)) {
            ab.e("MicroMsg.GameMessageParser", "msg content is null");
            AppMethodBeat.o(111300);
            return;
        }
        Map z = br.z(nVar.field_rawXML, "sysmsg");
        if (z == null || z.size() == 0) {
            ab.e("MicroMsg.GameMessageParser", "Parse failed");
            AppMethodBeat.o(111300);
        } else if ("gamecenter".equalsIgnoreCase((String) z.get(".sysmsg.$type"))) {
            a(z, nVar);
            b(z, nVar);
            e(z, nVar);
            f(z, nVar);
            g(z, nVar);
            h(z, nVar);
            i(z, nVar);
            k(z, nVar);
            d(z, nVar);
            n(z, nVar);
            c(z, nVar);
            AppMethodBeat.o(111300);
        } else {
            ab.e("MicroMsg.GameMessageParser", "Type not matched");
            AppMethodBeat.o(111300);
        }
    }

    public static String I(Map<String, String> map) {
        AppMethodBeat.i(111301);
        String bc = bo.bc((String) map.get(".sysmsg.gamecenter.formatcontent"), "");
        AppMethodBeat.o(111301);
        return bc;
    }

    private static void a(Map<String, String> map, n nVar) {
        AppMethodBeat.i(111302);
        nVar.mWC = bo.getInt((String) map.get(".sysmsg.gamecenter.wifi_flag"), 0);
        AppMethodBeat.o(111302);
    }

    private static void b(Map<String, String> map, n nVar) {
        AppMethodBeat.i(111303);
        nVar.kYQ = I(map);
        nVar.mWh = bo.bc((String) map.get(".sysmsg.gamecenter.url"), "");
        nVar.mWv = bo.bc((String) map.get(".sysmsg.gamecenter.msg_picture_url"), "");
        nVar.mWi = bo.bc((String) map.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_url"), "");
        if (bo.isNullOrNil(nVar.mWi)) {
            nVar.mWi = bo.bc((String) map.get(".sysmsg.gamecenter.url"), "");
        }
        nVar.mXa = bo.getInt((String) map.get(".sysmsg.gamecenter.notify_type"), 0);
        AppMethodBeat.o(111303);
    }

    private static void c(Map<String, String> map, n nVar) {
        AppMethodBeat.i(111304);
        switch (nVar.field_msgType) {
            case 2:
                j(map, nVar);
                ab.i("MicroMsg.GameMessageParser", "Received a ShareMsg: %s", nVar.field_appId);
                AppMethodBeat.o(111304);
                return;
            case 4:
                AppMethodBeat.o(111304);
                return;
            case 5:
                l(map, nVar);
                AppMethodBeat.o(111304);
                return;
            case 6:
                m(map, nVar);
                AppMethodBeat.o(111304);
                return;
            case 10:
            case 11:
                AppMethodBeat.o(111304);
                return;
            default:
                ab.e("MicroMsg.GameMessageParser", "error gamecenter type: " + nVar.field_msgType);
                AppMethodBeat.o(111304);
                return;
        }
    }

    private static void d(Map<String, String> map, n nVar) {
        AppMethodBeat.i(111305);
        nVar.mWw = bo.getInt((String) map.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_action"), 0);
        nVar.mWt.mXj = bo.bc((String) map.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_icon_url"), "");
        nVar.mWt.eeO = bo.bc((String) map.get(".sysmsg.gamecenter.message_bubble_info.message_bubble_desc"), "");
        AppMethodBeat.o(111305);
    }

    private static void e(Map<String, String> map, n nVar) {
        AppMethodBeat.i(111306);
        nVar.mAppName = bo.bc((String) map.get(".sysmsg.gamecenter.appinfo.appname2"), "");
        if (bo.isNullOrNil(nVar.mAppName)) {
            nVar.mAppName = bo.bc((String) map.get(".sysmsg.gamecenter.appinfo.appname"), "");
        }
        if (nVar.field_msgType == 6) {
            nVar.mWn = bo.bc((String) map.get(".sysmsg.gamecenter.appinfo.groupname"), "");
            nVar.mWo = bo.bc((String) map.get(".sysmsg.gamecenter.appinfo.groupurl"), "");
        } else {
            nVar.mWn = nVar.mAppName;
        }
        nVar.mWj = bo.bc((String) map.get(".sysmsg.gamecenter.appinfo.iconurl"), "");
        nVar.mWk = bo.bc((String) map.get(".sysmsg.gamecenter.appinfo.android_downloadurl"), "");
        nVar.mWl = bo.bc((String) map.get(".sysmsg.gamecenter.appinfo.android_apk_md5"), "");
        nVar.mWm = bo.getInt((String) map.get(".sysmsg.gamecenter.appinfo.android_apk_size"), 0);
        AppMethodBeat.o(111306);
    }

    private static void f(Map<String, String> map, n nVar) {
        AppMethodBeat.i(111307);
        nVar.mWp.clear();
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
                i iVar = new i();
                iVar.userName = bo.bc((String) map.get(obj2 + ".username"), "");
                iVar.bCu = bo.bc((String) map.get(obj2 + ".nickname"), "");
                iVar.mXu = bo.bc((String) map.get(obj2 + ".usericon"), "");
                iVar.mXw = bo.bc((String) map.get(obj2 + ".badge_icon"), "");
                iVar.mXx = bo.bc((String) map.get(obj2 + ".$jump_id"), "");
                nVar.mWp.add(iVar);
                i++;
            } else {
                AppMethodBeat.o(111307);
                return;
            }
        }
    }

    private static void g(Map<String, String> map, n nVar) {
        AppMethodBeat.i(111308);
        nVar.mXc = bo.bc((String) map.get(".sysmsg.gamecenter.noticeid"), "");
        AppMethodBeat.o(111308);
    }

    public static long J(Map<String, String> map) {
        AppMethodBeat.i(111309);
        long j = bo.getLong((String) map.get(".sysmsg.game_control_info.control_flag"), 0);
        AppMethodBeat.o(111309);
        return j;
    }

    private static void h(Map<String, String> map, n nVar) {
        AppMethodBeat.i(111310);
        nVar.mWD = J(map);
        AppMethodBeat.o(111310);
    }

    private static void i(Map<String, String> map, n nVar) {
        AppMethodBeat.i(111311);
        nVar.mWr.mXl = bo.getInt((String) map.get(".sysmsg.gamecenter.badge_display_type"), 0);
        nVar.mWr.mXj = bo.bc((String) map.get(".sysmsg.gamecenter.showiconurl"), "");
        nVar.mWr.mText = bo.bc((String) map.get(".sysmsg.gamecenter.entrancetext"), "");
        AppMethodBeat.o(111311);
    }

    private static void j(Map<String, String> map, n nVar) {
        AppMethodBeat.i(111312);
        nVar.mWx = bo.getInt((String) map.get(".sysmsg.gameshare.share_message_info.share_msg_type"), 1);
        nVar.mWy = bo.getInt((String) map.get(".sysmsg.game_control_info.display_name_type"), 1);
        nVar.mWz = bo.bc((String) map.get(".sysmsg.gameshare.share_message_info.share_msg_title"), "");
        nVar.mWA = bo.bc((String) map.get(".sysmsg.gameshare.share_message_info.share_msg_content"), "");
        nVar.mWB = bo.bc((String) map.get(".sysmsg.gameshare.share_message_info.media_url"), "");
        nVar.mWv = bo.bc((String) map.get(".sysmsg.gameshare.share_message_info.thumb_url"), "");
        AppMethodBeat.o(111312);
    }

    public static void k(Map<String, String> map, n nVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(111313);
        nVar.mWG.url = bo.bc((String) map.get(".sysmsg.gamecenter.floatlayer.open_url"), "");
        n.a aVar = nVar.mWG;
        if (bo.getInt((String) map.get(".sysmsg.gamecenter.floatlayer.full_screen"), 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        aVar.mTC = z;
        nVar.mWG.orientation = bo.getInt((String) map.get(".sysmsg.gamecenter.floatlayer.orientation"), 0);
        aVar = nVar.mWG;
        if (bo.getInt((String) map.get(".sysmsg.gamecenter.floatlayer.is_transparent"), 0) != 1) {
            z2 = false;
        }
        aVar.mXg = z2;
        AppMethodBeat.o(111313);
    }

    private static void l(Map<String, String> map, n nVar) {
        AppMethodBeat.i(111314);
        nVar.mWL = bo.bc((String) map.get(".sysmsg.gamepraise.praise_message_info.praise_content"), "");
        nVar.mWM = bo.bc((String) map.get(".sysmsg.gamepraise.praise_message_info.praise_jumpurl"), "");
        nVar.mWN = bo.bc((String) map.get(".sysmsg.gamepraise.praise_message_info.praise_iconurl"), "");
        AppMethodBeat.o(111314);
    }

    private static void m(Map<String, String> map, n nVar) {
        AppMethodBeat.i(111315);
        nVar.mWH = bo.bc((String) map.get(".sysmsg.gamecenter.topic.reply_content"), "");
        nVar.mWI = bo.bc((String) map.get(".sysmsg.gamecenter.topic.replied_content"), "");
        nVar.mWK = bo.bc((String) map.get(".sysmsg.gamecenter.topic.topic_title"), "");
        nVar.mWJ = bo.bc((String) map.get(".sysmsg.gamecenter.topic.topic_url"), "");
        AppMethodBeat.o(111315);
    }

    private static void n(Map<String, String> map, n nVar) {
        AppMethodBeat.i(111316);
        nVar.mXd = bo.getInt((String) map.get(".sysmsg.gamecenter.message_card.message_card_jump_type"), 0);
        nVar.mXe = bo.bc((String) map.get(".sysmsg.gamecenter.message_card.message_card_jump_url"), "");
        AppMethodBeat.o(111316);
    }
}
