package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5141c;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.model.a */
public final class C39211a {
    private static String TAG = "MicroMsg.GameABTestStrategy";

    /* renamed from: com.tencent.mm.plugin.game.model.a$a */
    public static class C3243a {
        public int bJt = 0;
        public String url = "";
    }

    public static C3243a bDL() {
        AppMethodBeat.m2504i(111184);
        C3243a c3243a = new C3243a();
        C5141c ll = C18624c.abi().mo17131ll("100001");
        if (ll.isValid()) {
            Map dru = ll.dru();
            c3243a.bJt = C5046bo.getInt((String) dru.get("game_homepage_jump"), 0);
            String str = (String) dru.get("game_homepage_url");
            if (str == null) {
                str = "";
            }
            c3243a.url = str;
            C39211a.m66813a(ll, 901, c3243a.url, c3243a.bJt);
            C4990ab.m7417i(TAG, "getIndexABTestInfo success, layerId = %s, expId = %s, flag = %d, url = %s", ll.field_layerId, ll.field_expId, Integer.valueOf(c3243a.bJt), c3243a.url);
            AppMethodBeat.m2505o(111184);
            return c3243a;
        }
        C4990ab.m7413e(TAG, "getIndexABTestInfo is timeout,startTime: %d, endTime: %d", Long.valueOf(ll.field_startTime), Long.valueOf(ll.field_endTime));
        AppMethodBeat.m2505o(111184);
        return c3243a;
    }

    /* renamed from: cm */
    public static C3243a m66814cm(String str, int i) {
        AppMethodBeat.m2504i(111185);
        C3243a c3243a = new C3243a();
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e(TAG, "appid is null");
            AppMethodBeat.m2505o(111185);
            return c3243a;
        }
        C5141c ll = C18624c.abi().mo17131ll("100002");
        if (ll.isValid()) {
            C4990ab.m7417i(TAG, "getDetailABTestInfo success, layerId = %s", ll.field_layerId);
            Map dru = ll.dru();
            c3243a.bJt = C5046bo.getInt((String) dru.get("game_detail_jump"), 0);
            String str2 = (String) dru.get("game_detail_url");
            c3243a.url = str2 == null ? "" : str2 + str;
            C39211a.m66813a(ll, i, c3243a.url, c3243a.bJt);
            AppMethodBeat.m2505o(111185);
            return c3243a;
        }
        C4990ab.m7413e(TAG, "getDetailABTestInfo is timeout,startTime: %d, endTime: %d", Long.valueOf(ll.field_startTime), Long.valueOf(ll.field_endTime));
        AppMethodBeat.m2505o(111185);
        return c3243a;
    }

    public static C3243a bDM() {
        AppMethodBeat.m2504i(111186);
        C3243a c3243a = new C3243a();
        C5141c ll = C18624c.abi().mo17131ll("100003");
        if (ll.isValid()) {
            C4990ab.m7417i(TAG, "getLibraryABTestInfo success, layerId = %s", ll.field_layerId);
            Map dru = ll.dru();
            c3243a.bJt = C5046bo.getInt((String) dru.get("game_library_jump"), 0);
            String str = (String) dru.get("game_library_url");
            if (str == null) {
                str = "";
            }
            c3243a.url = str;
            C39211a.m66813a(ll, 1005, c3243a.url, c3243a.bJt);
            AppMethodBeat.m2505o(111186);
            return c3243a;
        }
        C4990ab.m7413e(TAG, "getLibraryABTestInfo is timeout,startTime: %d, endTime: %d", Long.valueOf(ll.field_startTime), Long.valueOf(ll.field_endTime));
        AppMethodBeat.m2505o(111186);
        return c3243a;
    }

    public static C3243a bDN() {
        AppMethodBeat.m2504i(111187);
        C3243a c3243a = new C3243a();
        C5141c ll = C18624c.abi().mo17131ll("100022");
        if (ll.isValid()) {
            Map dru = ll.dru();
            c3243a.bJt = C5046bo.getInt((String) dru.get("game_message_jump"), 0);
            String str = (String) dru.get("game_message_url");
            if (str == null) {
                str = "";
            }
            c3243a.url = str;
            C39211a.m66813a(ll, 1001, c3243a.url, c3243a.bJt);
            AppMethodBeat.m2505o(111187);
            return c3243a;
        }
        AppMethodBeat.m2505o(111187);
        return c3243a;
    }

    /* renamed from: a */
    private static void m66813a(C5141c c5141c, int i, String str, int i2) {
        AppMethodBeat.m2504i(111188);
        if (c5141c == null) {
            C4990ab.m7416i(TAG, "ABTestItem is null");
            AppMethodBeat.m2505o(111188);
            return;
        }
        String str2 = "";
        try {
            JSONObject jSONObject = new JSONObject();
            if (!C5046bo.isNullOrNil(str)) {
                jSONObject.put("url", str);
            }
            jSONObject.put("jumpType", i2);
            str2 = C18178q.encode(jSONObject.toString(), "UTF-8");
        } catch (UnsupportedEncodingException | JSONException e) {
        }
        C4990ab.m7416i(TAG, "reportABTest : " + c5141c.field_layerId + " , " + c5141c.field_business + " , " + c5141c.field_expId + " , " + c5141c.field_sequence + " , " + c5141c.field_prioritylevel + " , " + c5141c.field_startTime + " , " + c5141c.field_endTime + " , " + i + " , " + str2);
        C7060h.pYm.mo8381e(14841, c5141c.field_layerId, c5141c.field_business, c5141c.field_expId, Long.valueOf(c5141c.field_sequence), Integer.valueOf(c5141c.field_prioritylevel), Long.valueOf(c5141c.field_startTime), Long.valueOf(c5141c.field_endTime), Integer.valueOf(i), str2);
        AppMethodBeat.m2505o(111188);
    }
}
