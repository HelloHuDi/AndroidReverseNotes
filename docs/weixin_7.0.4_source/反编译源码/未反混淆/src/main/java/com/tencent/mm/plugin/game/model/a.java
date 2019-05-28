package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.c;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private static String TAG = "MicroMsg.GameABTestStrategy";

    public static class a {
        public int bJt = 0;
        public String url = "";
    }

    public static a bDL() {
        AppMethodBeat.i(111184);
        a aVar = new a();
        c ll = com.tencent.mm.model.c.c.abi().ll("100001");
        if (ll.isValid()) {
            Map dru = ll.dru();
            aVar.bJt = bo.getInt((String) dru.get("game_homepage_jump"), 0);
            String str = (String) dru.get("game_homepage_url");
            if (str == null) {
                str = "";
            }
            aVar.url = str;
            a(ll, 901, aVar.url, aVar.bJt);
            ab.i(TAG, "getIndexABTestInfo success, layerId = %s, expId = %s, flag = %d, url = %s", ll.field_layerId, ll.field_expId, Integer.valueOf(aVar.bJt), aVar.url);
            AppMethodBeat.o(111184);
            return aVar;
        }
        ab.e(TAG, "getIndexABTestInfo is timeout,startTime: %d, endTime: %d", Long.valueOf(ll.field_startTime), Long.valueOf(ll.field_endTime));
        AppMethodBeat.o(111184);
        return aVar;
    }

    public static a cm(String str, int i) {
        AppMethodBeat.i(111185);
        a aVar = new a();
        if (bo.isNullOrNil(str)) {
            ab.e(TAG, "appid is null");
            AppMethodBeat.o(111185);
            return aVar;
        }
        c ll = com.tencent.mm.model.c.c.abi().ll("100002");
        if (ll.isValid()) {
            ab.i(TAG, "getDetailABTestInfo success, layerId = %s", ll.field_layerId);
            Map dru = ll.dru();
            aVar.bJt = bo.getInt((String) dru.get("game_detail_jump"), 0);
            String str2 = (String) dru.get("game_detail_url");
            aVar.url = str2 == null ? "" : str2 + str;
            a(ll, i, aVar.url, aVar.bJt);
            AppMethodBeat.o(111185);
            return aVar;
        }
        ab.e(TAG, "getDetailABTestInfo is timeout,startTime: %d, endTime: %d", Long.valueOf(ll.field_startTime), Long.valueOf(ll.field_endTime));
        AppMethodBeat.o(111185);
        return aVar;
    }

    public static a bDM() {
        AppMethodBeat.i(111186);
        a aVar = new a();
        c ll = com.tencent.mm.model.c.c.abi().ll("100003");
        if (ll.isValid()) {
            ab.i(TAG, "getLibraryABTestInfo success, layerId = %s", ll.field_layerId);
            Map dru = ll.dru();
            aVar.bJt = bo.getInt((String) dru.get("game_library_jump"), 0);
            String str = (String) dru.get("game_library_url");
            if (str == null) {
                str = "";
            }
            aVar.url = str;
            a(ll, 1005, aVar.url, aVar.bJt);
            AppMethodBeat.o(111186);
            return aVar;
        }
        ab.e(TAG, "getLibraryABTestInfo is timeout,startTime: %d, endTime: %d", Long.valueOf(ll.field_startTime), Long.valueOf(ll.field_endTime));
        AppMethodBeat.o(111186);
        return aVar;
    }

    public static a bDN() {
        AppMethodBeat.i(111187);
        a aVar = new a();
        c ll = com.tencent.mm.model.c.c.abi().ll("100022");
        if (ll.isValid()) {
            Map dru = ll.dru();
            aVar.bJt = bo.getInt((String) dru.get("game_message_jump"), 0);
            String str = (String) dru.get("game_message_url");
            if (str == null) {
                str = "";
            }
            aVar.url = str;
            a(ll, 1001, aVar.url, aVar.bJt);
            AppMethodBeat.o(111187);
            return aVar;
        }
        AppMethodBeat.o(111187);
        return aVar;
    }

    private static void a(c cVar, int i, String str, int i2) {
        AppMethodBeat.i(111188);
        if (cVar == null) {
            ab.i(TAG, "ABTestItem is null");
            AppMethodBeat.o(111188);
            return;
        }
        String str2 = "";
        try {
            JSONObject jSONObject = new JSONObject();
            if (!bo.isNullOrNil(str)) {
                jSONObject.put("url", str);
            }
            jSONObject.put("jumpType", i2);
            str2 = q.encode(jSONObject.toString(), "UTF-8");
        } catch (UnsupportedEncodingException | JSONException e) {
        }
        ab.i(TAG, "reportABTest : " + cVar.field_layerId + " , " + cVar.field_business + " , " + cVar.field_expId + " , " + cVar.field_sequence + " , " + cVar.field_prioritylevel + " , " + cVar.field_startTime + " , " + cVar.field_endTime + " , " + i + " , " + str2);
        h.pYm.e(14841, cVar.field_layerId, cVar.field_business, cVar.field_expId, Long.valueOf(cVar.field_sequence), Integer.valueOf(cVar.field_prioritylevel), Long.valueOf(cVar.field_startTime), Long.valueOf(cVar.field_endTime), Integer.valueOf(i), str2);
        AppMethodBeat.o(111188);
    }
}
