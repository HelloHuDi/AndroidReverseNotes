package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.n.a;
import com.tencent.mm.plugin.game.model.n.e;
import com.tencent.mm.plugin.game.model.n.g;
import com.tencent.mm.plugin.game.model.n.h;
import com.tencent.mm.plugin.game.model.n.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class u {
    public static u mXG;

    public static u bEx() {
        AppMethodBeat.i(111338);
        if (mXG == null) {
            mXG = new u();
        }
        u uVar = mXG;
        AppMethodBeat.o(111338);
        return uVar;
    }

    public static void a(n nVar) {
        AppMethodBeat.i(111339);
        if (bo.isNullOrNil(nVar.field_rawXML)) {
            ab.e("MicroMsg.GameNewMessageParser", "msg content is null");
            AppMethodBeat.o(111339);
            return;
        }
        Map z = br.z(nVar.field_rawXML, "sysmsg");
        if (z == null || z.size() == 0) {
            ab.e("MicroMsg.GameNewMessageParser", "Parse failed");
            AppMethodBeat.o(111339);
        } else if ("gamecenter".equalsIgnoreCase((String) z.get(".sysmsg.$type"))) {
            b(z, nVar);
            o(z, nVar);
            q(z, nVar);
            d(z, nVar);
            s(z, nVar);
            i(z, nVar);
            t(z, nVar);
            a(z, nVar);
            u(z, nVar);
            AppMethodBeat.o(111339);
        } else {
            ab.e("MicroMsg.GameNewMessageParser", "Type not matched");
            AppMethodBeat.o(111339);
        }
    }

    private static void b(Map<String, String> map, n nVar) {
        AppMethodBeat.i(111340);
        nVar.mWO = bo.bc((String) map.get(".sysmsg.gamecenter.msg_center.$jump_id"), "");
        nVar.mWP = bo.bc((String) map.get(".sysmsg.gamecenter.msg_center.user_action_title"), "");
        nVar.mWQ = bo.bc((String) map.get(".sysmsg.gamecenter.msg_center.first_line_content"), "");
        nVar.mWU.mXp = bo.bc((String) map.get(".sysmsg.gamecenter.msg_center.second_line.second_line_content"), "");
        nVar.mWU.mXj = bo.bc((String) map.get(".sysmsg.gamecenter.msg_center.second_line.second_line_icon_url"), "");
        nVar.mWU.mXk = bo.bc((String) map.get(".sysmsg.gamecenter.msg_center.second_line.$jump_id"), "");
        nVar.mWR = bo.bc((String) map.get(".sysmsg.gamecenter.msg_center.content_pic"), "");
        nVar.mWS = bo.bc((String) map.get(".sysmsg.gamecenter.msg_center.content_pic.$jump_id"), "");
        p(map, nVar);
        f(map, nVar);
        r(map, nVar);
        AppMethodBeat.o(111340);
    }

    private static void o(Map<String, String> map, n nVar) {
        AppMethodBeat.i(111341);
        String str = ".sysmsg.gamecenter.jump_info.jump";
        nVar.mWu.clear();
        int i = 0;
        while (true) {
            Object obj;
            if (i == 0) {
                obj = str;
            } else {
                String obj2 = str + i;
            }
            if (map.containsKey(obj2)) {
                String str2 = (String) map.get(obj2 + ".$id");
                e eVar = new e();
                eVar.mXo = bo.getInt((String) map.get(obj2 + ".jump_type"), 0);
                eVar.lAF = bo.bc((String) map.get(obj2 + ".jump_url"), "");
                if (!bo.isNullOrNil(str2)) {
                    nVar.mWu.put(str2, eVar);
                }
                i++;
            } else {
                AppMethodBeat.o(111341);
                return;
            }
        }
    }

    private static void p(Map<String, String> map, n nVar) {
        AppMethodBeat.i(111342);
        if (map.get(".sysmsg.gamecenter.msg_center.msg_sender") != null) {
            nVar.mWT = new g();
            nVar.mWT.mXq = bo.bc((String) map.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_name"), "");
            nVar.mWT.mXr = bo.bc((String) map.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_icon"), "");
            nVar.mWT.mXs = bo.bc((String) map.get(".sysmsg.gamecenter.msg_center.msg_sender.badge_icon"), "");
            nVar.mWT.mXk = bo.bc((String) map.get(".sysmsg.gamecenter.msg_center.msg_sender.$jump_id"), "");
        }
        AppMethodBeat.o(111342);
    }

    private static void f(Map<String, String> map, n nVar) {
        AppMethodBeat.i(111343);
        nVar.mWp.clear();
        String str = ".sysmsg.gamecenter.msg_center.userinfo";
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
                AppMethodBeat.o(111343);
                return;
            }
        }
    }

    public static void q(Map<String, String> map, n nVar) {
        AppMethodBeat.i(111344);
        nVar.mXb = bo.getInt((String) map.get(".sysmsg.gamecenter.report.msg_subtype"), 0);
        nVar.mXc = bo.bc((String) map.get(".sysmsg.gamecenter.report.noticeid"), "");
        AppMethodBeat.o(111344);
    }

    private static void d(Map<String, String> map, n nVar) {
        AppMethodBeat.i(111345);
        nVar.mWt.mXj = bo.bc((String) map.get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url"), "");
        nVar.mWt.eeO = bo.bc((String) map.get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc"), "");
        nVar.mWt.mXk = bo.bc((String) map.get(".sysmsg.gamecenter.msg_bubble_info.$jump_id"), "");
        AppMethodBeat.o(111345);
    }

    private static void r(Map<String, String> map, n nVar) {
        boolean z;
        AppMethodBeat.i(111346);
        nVar.mWV.mName = bo.bc((String) map.get(".sysmsg.gamecenter.msg_center.source_info.source_name"), "");
        h hVar = nVar.mWV;
        if (bo.getInt((String) map.get(".sysmsg.gamecenter.msg_center.source_info.source_clickable"), 0) > 0) {
            z = true;
        } else {
            z = false;
        }
        hVar.mXt = z;
        nVar.mWV.mXk = bo.bc((String) map.get(".sysmsg.gamecenter.msg_center.source_info.$jump_id"), "");
        AppMethodBeat.o(111346);
    }

    public static void s(Map<String, String> map, n nVar) {
        boolean z = true;
        AppMethodBeat.i(111347);
        nVar.mWG.url = bo.bc((String) map.get(".sysmsg.gamecenter.float_layer.open_url"), "");
        nVar.mWG.mTC = bo.getInt((String) map.get(".sysmsg.gamecenter.float_layer.full_screen"), 0) == 1;
        nVar.mWG.orientation = bo.getInt((String) map.get(".sysmsg.gamecenter.float_layer.orientation"), 0);
        a aVar = nVar.mWG;
        if (bo.getInt((String) map.get(".sysmsg.gamecenter.float_layer.is_transparent"), 0) != 1) {
            z = false;
        }
        aVar.mXg = z;
        nVar.mWG.mXh.clear();
        nVar.mWG.mXh.addAll(o(".sysmsg.gamecenter.float_layer.load_with_wepkg.wepkg", (Map) map));
        AppMethodBeat.o(111347);
    }

    private static List<String> o(String str, Map<String, String> map) {
        AppMethodBeat.i(111348);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            Object obj;
            if (i == 0) {
                obj = str;
            } else {
                obj = str + i;
            }
            if (map.containsKey(obj)) {
                i++;
                String str2 = (String) map.get(obj + ".$pkg_id");
                if (!bo.isNullOrNil(str2)) {
                    arrayList.add(str2);
                }
            } else {
                AppMethodBeat.o(111348);
                return arrayList;
            }
        }
    }

    private static void i(Map<String, String> map, n nVar) {
        AppMethodBeat.i(111349);
        nVar.mWr.mXl = bo.getInt((String) map.get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0);
        nVar.mWr.mXj = bo.bc((String) map.get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
        nVar.mWr.mText = bo.bc((String) map.get(".sysmsg.gamecenter.entrance.entrance_text"), "");
        nVar.mWr.mXm = bo.getInt((String) map.get(".sysmsg.gamecenter.entrance.entrance_icon_width"), 64) / 2;
        nVar.mWr.mXn = bo.getInt((String) map.get(".sysmsg.gamecenter.entrance.entrance_icon_height"), 64) / 2;
        AppMethodBeat.o(111349);
    }

    private static void t(Map<String, String> map, n nVar) {
        AppMethodBeat.i(111350);
        nVar.mWW.mXy = bo.bc((String) map.get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
        nVar.mWW.kgX = bo.getInt((String) map.get(".sysmsg.gamecenter.display_with_wepkg"), 0);
        nVar.mWW.mXz = bo.getLong((String) map.get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0);
        AppMethodBeat.o(111350);
    }

    private static void a(Map<String, String> map, n nVar) {
        AppMethodBeat.i(111351);
        nVar.mWC = bo.getInt((String) map.get(".sysmsg.gamecenter.wifi_flag"), 0);
        AppMethodBeat.o(111351);
    }

    public static void u(Map<String, String> map, n nVar) {
        AppMethodBeat.i(111352);
        nVar.mWX.mXi = bo.bc((String) map.get(".sysmsg.gamecenter.banner.$banner_id"), "");
        nVar.mWX.mXh.clear();
        nVar.mWX.mXh.addAll(o(".sysmsg.gamecenter.banner.load_with_wepkg.wepkg", (Map) map));
        AppMethodBeat.o(111352);
    }
}
