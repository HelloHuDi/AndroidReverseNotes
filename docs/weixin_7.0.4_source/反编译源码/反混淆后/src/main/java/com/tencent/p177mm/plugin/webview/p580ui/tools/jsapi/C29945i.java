package com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C45137n;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.i */
public final class C29945i {
    public Map<String, Object> puc;
    public String type;
    public String uIG;
    public JSONObject uIH;
    Map<String, Object> uII = new HashMap();
    public String uIJ;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.i$a */
    public static class C23124a {
        /* renamed from: a */
        public static String m35497a(String str, Map<String, Object> map, boolean z, String str2) {
            AppMethodBeat.m2504i(9810);
            String a = C23124a.m35496a("callback", str, map, null, z, str2);
            AppMethodBeat.m2505o(9810);
            return a;
        }

        /* renamed from: a */
        public static String m35498a(String str, JSONObject jSONObject, boolean z, String str2) {
            AppMethodBeat.m2504i(9811);
            String a = C23124a.m35496a("event", str, null, jSONObject, z, str2);
            AppMethodBeat.m2505o(9811);
            return a;
        }

        /* renamed from: b */
        public static String m35500b(String str, Map<String, Object> map, boolean z, String str2) {
            AppMethodBeat.m2504i(9812);
            String a = C23124a.m35496a("event", str, map, null, z, str2);
            AppMethodBeat.m2505o(9812);
            return a;
        }

        /* renamed from: a */
        private static String m35496a(String str, String str2, Map<String, Object> map, JSONObject jSONObject, boolean z, String str3) {
            AppMethodBeat.m2504i(9813);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("__msg_type", str);
                if (str.equals("callback")) {
                    jSONObject2.put("__callback_id", str2);
                } else if (str.equals("event")) {
                    jSONObject2.put("__event_id", str2);
                }
                if (jSONObject == null) {
                    jSONObject2.put("__params", C23124a.m35499ao(map));
                } else {
                    jSONObject2.put("__params", jSONObject);
                }
                String m;
                if (z) {
                    m = C23124a.m35502m(jSONObject2, str3);
                    AppMethodBeat.m2505o(9813);
                    return m;
                }
                m = jSONObject2.toString();
                AppMethodBeat.m2505o(9813);
                return m;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.MsgWrapper", "build fail, exception = " + e.getMessage());
                AppMethodBeat.m2505o(9813);
                return null;
            }
        }

        /* renamed from: m */
        private static String m35502m(JSONObject jSONObject, String str) {
            AppMethodBeat.m2504i(9814);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("__json_message", jSONObject);
                C4990ab.m7417i("MicroMsg.MsgWrapper", "js digest verification contentStr = ", jSONObject.toString().replaceAll("\\\\/", "/"));
                C4990ab.m7417i("MicroMsg.MsgWrapper", "js digest verification shaStr = ", C45137n.getSHA1(r1 + str));
                jSONObject2.put("__sha_key", r1);
                String jSONObject3 = jSONObject2.toString();
                AppMethodBeat.m2505o(9814);
                return jSONObject3;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.MsgWrapper", "build fail, exception = " + e.getMessage());
                AppMethodBeat.m2505o(9814);
                return null;
            }
        }

        /* renamed from: ao */
        public static JSONObject m35499ao(Map<String, Object> map) {
            AppMethodBeat.m2504i(9815);
            if (map == null || map.size() == 0) {
                JSONObject jSONObject = new JSONObject();
                AppMethodBeat.m2505o(9815);
                return jSONObject;
            }
            try {
                String str = (String) map.get("jsapi_callback_json_special_key");
                JSONObject jSONObject2 = new JSONObject();
                for (String str2 : map.keySet()) {
                    if (!(str2 == null || str2.equals("jsapi_callback_json_special_key"))) {
                        if (str == null || !str2.equals(str)) {
                            jSONObject2.put(str2, map.get(str2));
                        } else {
                            jSONObject2.put(str, new JSONArray((String) map.get(str)));
                        }
                    }
                }
                AppMethodBeat.m2505o(9815);
                return jSONObject2;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.MsgWrapper", "convertMapToJSON fail, exception = " + e.getMessage());
                AppMethodBeat.m2505o(9815);
                return null;
            }
        }

        private static C29945i agB(String str) {
            AppMethodBeat.m2504i(9816);
            if (str == null || str.length() == 0) {
                C4990ab.m7412e("MicroMsg.MsgWrapper", "fromString fail, src is null");
                AppMethodBeat.m2505o(9816);
                return null;
            }
            C29945i c29945i = new C29945i();
            try {
                JSONObject jSONObject = new JSONObject(str);
                c29945i.type = jSONObject.getString("__msg_type");
                c29945i.uIG = jSONObject.getString("__callback_id");
                c29945i.uIJ = jSONObject.getString("func");
                c29945i.puc = new HashMap();
                JSONObject jSONObject2 = jSONObject.getJSONObject("params");
                c29945i.uIH = jSONObject2;
                if (jSONObject2 != null) {
                    Iterator keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String str2 = (String) keys.next();
                        String string = jSONObject2.getString(str2);
                        if (string == null) {
                            string = "";
                        }
                        if ("urls".equalsIgnoreCase(str2)) {
                            C4990ab.m7419v("MicroMsg.MsgWrapper", "key is JSONArray, %s", str2);
                            try {
                                JSONArray jSONArray = new JSONArray(string);
                                String[] strArr = new String[jSONArray.length()];
                                for (int i = 0; i < strArr.length; i++) {
                                    strArr[i] = jSONArray.getString(i);
                                }
                                c29945i.puc.put(str2, strArr);
                            } catch (Exception e) {
                                C4990ab.m7413e("MicroMsg.MsgWrapper", "parse JSONArray fail, ex = %s", e.getMessage());
                            }
                        } else {
                            c29945i.puc.put(str2, string);
                        }
                    }
                }
                AppMethodBeat.m2505o(9816);
                return c29945i;
            } catch (Exception e2) {
                C4990ab.m7412e("MicroMsg.MsgWrapper", "fromString fail, exception = " + e2.getMessage());
                AppMethodBeat.m2505o(9816);
                return null;
            }
        }

        /* renamed from: i */
        static List<C29945i> m35501i(String str, boolean z, String str2) {
            AppMethodBeat.m2504i(9817);
            if (str == null || str.length() == 0) {
                C4990ab.m7412e("MicroMsg.MsgWrapper", "getMsgList fail, src is null");
                AppMethodBeat.m2505o(9817);
                return null;
            }
            JSONArray jSONArray;
            if (z) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONArray jSONArray2 = jSONObject.getJSONArray("__json_message");
                    if (jSONObject.getString("__sha_key").equals(C45137n.getSHA1(jSONArray2.toString().replaceAll("\\\\/", "/") + str2))) {
                        jSONArray = jSONArray2;
                    } else {
                        C4990ab.m7413e("MicroMsg.MsgWrapper", "fromString SHA1 verification failed, sha1Str = %s, calSha1Str = %s, jsonList = %s", jSONObject.getString("__sha_key"), C45137n.getSHA1(jSONArray2.toString().replaceAll("\\\\/", "/") + str2), jSONArray2.toString().replaceAll("\\\\/", "/"));
                        C7060h.pYm.mo8378a(894, 6, 1, false);
                        AppMethodBeat.m2505o(9817);
                        return null;
                    }
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.MsgWrapper", "dealMsgQueue fail, exception = " + e.getMessage());
                    AppMethodBeat.m2505o(9817);
                    return null;
                }
            }
            jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                AppMethodBeat.m2505o(9817);
                return null;
            }
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < jSONArray.length(); i++) {
                linkedList.add(C23124a.agB(jSONArray.getString(i)));
            }
            AppMethodBeat.m2505o(9817);
            return linkedList;
        }
    }

    public C29945i() {
        AppMethodBeat.m2504i(9818);
        AppMethodBeat.m2505o(9818);
    }

    public final Map<String, Object> dcO() {
        return this.uII;
    }

    /* renamed from: aP */
    public static Bundle m47402aP(Map<String, Object> map) {
        AppMethodBeat.m2504i(9819);
        if (map == null || map.size() == 0) {
            AppMethodBeat.m2505o(9819);
            return null;
        }
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof String[]) {
                bundle.putStringArray(str, (String[]) obj);
            } else if (obj instanceof Bundle) {
                bundle.putBundle(str, (Bundle) obj);
            } else {
                bundle.putString(str, String.valueOf(obj));
            }
        }
        AppMethodBeat.m2505o(9819);
        return bundle;
    }

    /* renamed from: aq */
    public static Map<String, Object> m47403aq(Bundle bundle) {
        AppMethodBeat.m2504i(9820);
        if (bundle == null) {
            AppMethodBeat.m2505o(9820);
            return null;
        }
        Set<String> keySet = bundle.keySet();
        if (keySet == null) {
            AppMethodBeat.m2505o(9820);
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : keySet) {
            hashMap.put(str, bundle.get(str));
        }
        AppMethodBeat.m2505o(9820);
        return hashMap;
    }
}
