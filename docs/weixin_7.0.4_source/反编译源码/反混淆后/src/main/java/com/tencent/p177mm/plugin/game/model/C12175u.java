package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.model.C28229n.C28231e;
import com.tencent.p177mm.plugin.game.model.C28229n.C28233i;
import com.tencent.p177mm.plugin.game.model.C28229n.C28234h;
import com.tencent.p177mm.plugin.game.model.C28229n.C28235g;
import com.tencent.p177mm.plugin.game.model.C28229n.C3244a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.game.model.u */
public final class C12175u {
    public static C12175u mXG;

    public static C12175u bEx() {
        AppMethodBeat.m2504i(111338);
        if (mXG == null) {
            mXG = new C12175u();
        }
        C12175u c12175u = mXG;
        AppMethodBeat.m2505o(111338);
        return c12175u;
    }

    /* renamed from: a */
    public static void m20105a(C28229n c28229n) {
        AppMethodBeat.m2504i(111339);
        if (C5046bo.isNullOrNil(c28229n.field_rawXML)) {
            C4990ab.m7412e("MicroMsg.GameNewMessageParser", "msg content is null");
            AppMethodBeat.m2505o(111339);
            return;
        }
        Map z = C5049br.m7595z(c28229n.field_rawXML, "sysmsg");
        if (z == null || z.size() == 0) {
            C4990ab.m7412e("MicroMsg.GameNewMessageParser", "Parse failed");
            AppMethodBeat.m2505o(111339);
        } else if ("gamecenter".equalsIgnoreCase((String) z.get(".sysmsg.$type"))) {
            C12175u.m20107b(z, c28229n);
            C12175u.m20112o(z, c28229n);
            C12175u.m20114q(z, c28229n);
            C12175u.m20108d(z, c28229n);
            C12175u.m20116s(z, c28229n);
            C12175u.m20110i(z, c28229n);
            C12175u.m20117t(z, c28229n);
            C12175u.m20106a(z, c28229n);
            C12175u.m20118u(z, c28229n);
            AppMethodBeat.m2505o(111339);
        } else {
            C4990ab.m7412e("MicroMsg.GameNewMessageParser", "Type not matched");
            AppMethodBeat.m2505o(111339);
        }
    }

    /* renamed from: b */
    private static void m20107b(Map<String, String> map, C28229n c28229n) {
        AppMethodBeat.m2504i(111340);
        c28229n.mWO = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.msg_center.$jump_id"), "");
        c28229n.mWP = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.msg_center.user_action_title"), "");
        c28229n.mWQ = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.msg_center.first_line_content"), "");
        c28229n.mWU.mXp = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.msg_center.second_line.second_line_content"), "");
        c28229n.mWU.mXj = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.msg_center.second_line.second_line_icon_url"), "");
        c28229n.mWU.mXk = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.msg_center.second_line.$jump_id"), "");
        c28229n.mWR = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.msg_center.content_pic"), "");
        c28229n.mWS = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.msg_center.content_pic.$jump_id"), "");
        C12175u.m20113p(map, c28229n);
        C12175u.m20109f(map, c28229n);
        C12175u.m20115r(map, c28229n);
        AppMethodBeat.m2505o(111340);
    }

    /* renamed from: o */
    private static void m20112o(Map<String, String> map, C28229n c28229n) {
        AppMethodBeat.m2504i(111341);
        String str = ".sysmsg.gamecenter.jump_info.jump";
        c28229n.mWu.clear();
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
                C28231e c28231e = new C28231e();
                c28231e.mXo = C5046bo.getInt((String) map.get(obj2 + ".jump_type"), 0);
                c28231e.lAF = C5046bo.m7532bc((String) map.get(obj2 + ".jump_url"), "");
                if (!C5046bo.isNullOrNil(str2)) {
                    c28229n.mWu.put(str2, c28231e);
                }
                i++;
            } else {
                AppMethodBeat.m2505o(111341);
                return;
            }
        }
    }

    /* renamed from: p */
    private static void m20113p(Map<String, String> map, C28229n c28229n) {
        AppMethodBeat.m2504i(111342);
        if (map.get(".sysmsg.gamecenter.msg_center.msg_sender") != null) {
            c28229n.mWT = new C28235g();
            c28229n.mWT.mXq = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_name"), "");
            c28229n.mWT.mXr = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.msg_center.msg_sender.sender_icon"), "");
            c28229n.mWT.mXs = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.msg_center.msg_sender.badge_icon"), "");
            c28229n.mWT.mXk = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.msg_center.msg_sender.$jump_id"), "");
        }
        AppMethodBeat.m2505o(111342);
    }

    /* renamed from: f */
    private static void m20109f(Map<String, String> map, C28229n c28229n) {
        AppMethodBeat.m2504i(111343);
        c28229n.mWp.clear();
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
                C28233i c28233i = new C28233i();
                c28233i.userName = C5046bo.m7532bc((String) map.get(obj2 + ".username"), "");
                c28233i.bCu = C5046bo.m7532bc((String) map.get(obj2 + ".nickname"), "");
                c28233i.mXu = C5046bo.m7532bc((String) map.get(obj2 + ".usericon"), "");
                c28233i.mXw = C5046bo.m7532bc((String) map.get(obj2 + ".badge_icon"), "");
                c28233i.mXx = C5046bo.m7532bc((String) map.get(obj2 + ".$jump_id"), "");
                c28229n.mWp.add(c28233i);
                i++;
            } else {
                AppMethodBeat.m2505o(111343);
                return;
            }
        }
    }

    /* renamed from: q */
    public static void m20114q(Map<String, String> map, C28229n c28229n) {
        AppMethodBeat.m2504i(111344);
        c28229n.mXb = C5046bo.getInt((String) map.get(".sysmsg.gamecenter.report.msg_subtype"), 0);
        c28229n.mXc = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.report.noticeid"), "");
        AppMethodBeat.m2505o(111344);
    }

    /* renamed from: d */
    private static void m20108d(Map<String, String> map, C28229n c28229n) {
        AppMethodBeat.m2504i(111345);
        c28229n.mWt.mXj = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.msg_bubble_info.bubble_icon_url"), "");
        c28229n.mWt.eeO = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.msg_bubble_info.bubble_desc"), "");
        c28229n.mWt.mXk = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.msg_bubble_info.$jump_id"), "");
        AppMethodBeat.m2505o(111345);
    }

    /* renamed from: r */
    private static void m20115r(Map<String, String> map, C28229n c28229n) {
        boolean z;
        AppMethodBeat.m2504i(111346);
        c28229n.mWV.mName = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.msg_center.source_info.source_name"), "");
        C28234h c28234h = c28229n.mWV;
        if (C5046bo.getInt((String) map.get(".sysmsg.gamecenter.msg_center.source_info.source_clickable"), 0) > 0) {
            z = true;
        } else {
            z = false;
        }
        c28234h.mXt = z;
        c28229n.mWV.mXk = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.msg_center.source_info.$jump_id"), "");
        AppMethodBeat.m2505o(111346);
    }

    /* renamed from: s */
    public static void m20116s(Map<String, String> map, C28229n c28229n) {
        boolean z = true;
        AppMethodBeat.m2504i(111347);
        c28229n.mWG.url = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.float_layer.open_url"), "");
        c28229n.mWG.mTC = C5046bo.getInt((String) map.get(".sysmsg.gamecenter.float_layer.full_screen"), 0) == 1;
        c28229n.mWG.orientation = C5046bo.getInt((String) map.get(".sysmsg.gamecenter.float_layer.orientation"), 0);
        C3244a c3244a = c28229n.mWG;
        if (C5046bo.getInt((String) map.get(".sysmsg.gamecenter.float_layer.is_transparent"), 0) != 1) {
            z = false;
        }
        c3244a.mXg = z;
        c28229n.mWG.mXh.clear();
        c28229n.mWG.mXh.addAll(C12175u.m20111o(".sysmsg.gamecenter.float_layer.load_with_wepkg.wepkg", (Map) map));
        AppMethodBeat.m2505o(111347);
    }

    /* renamed from: o */
    private static List<String> m20111o(String str, Map<String, String> map) {
        AppMethodBeat.m2504i(111348);
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
                if (!C5046bo.isNullOrNil(str2)) {
                    arrayList.add(str2);
                }
            } else {
                AppMethodBeat.m2505o(111348);
                return arrayList;
            }
        }
    }

    /* renamed from: i */
    private static void m20110i(Map<String, String> map, C28229n c28229n) {
        AppMethodBeat.m2504i(111349);
        c28229n.mWr.mXl = C5046bo.getInt((String) map.get(".sysmsg.gamecenter.entrance.entrance_red_dot_type"), 0);
        c28229n.mWr.mXj = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.entrance.entrance_icon_url"), "");
        c28229n.mWr.mText = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.entrance.entrance_text"), "");
        c28229n.mWr.mXm = C5046bo.getInt((String) map.get(".sysmsg.gamecenter.entrance.entrance_icon_width"), 64) / 2;
        c28229n.mWr.mXn = C5046bo.getInt((String) map.get(".sysmsg.gamecenter.entrance.entrance_icon_height"), 64) / 2;
        AppMethodBeat.m2505o(111349);
    }

    /* renamed from: t */
    private static void m20117t(Map<String, String> map, C28229n c28229n) {
        AppMethodBeat.m2504i(111350);
        c28229n.mWW.mXy = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.display_with_wepkg.$pkg_id"), "");
        c28229n.mWW.kgX = C5046bo.getInt((String) map.get(".sysmsg.gamecenter.display_with_wepkg"), 0);
        c28229n.mWW.mXz = C5046bo.getLong((String) map.get(".sysmsg.gamecenter.display_with_wepkg.$always_display_after_time"), 0);
        AppMethodBeat.m2505o(111350);
    }

    /* renamed from: a */
    private static void m20106a(Map<String, String> map, C28229n c28229n) {
        AppMethodBeat.m2504i(111351);
        c28229n.mWC = C5046bo.getInt((String) map.get(".sysmsg.gamecenter.wifi_flag"), 0);
        AppMethodBeat.m2505o(111351);
    }

    /* renamed from: u */
    public static void m20118u(Map<String, String> map, C28229n c28229n) {
        AppMethodBeat.m2504i(111352);
        c28229n.mWX.mXi = C5046bo.m7532bc((String) map.get(".sysmsg.gamecenter.banner.$banner_id"), "");
        c28229n.mWX.mXh.clear();
        c28229n.mWX.mXh.addAll(C12175u.m20111o(".sysmsg.gamecenter.banner.load_with_wepkg.wepkg", (Map) map));
        AppMethodBeat.m2505o(111352);
    }
}
