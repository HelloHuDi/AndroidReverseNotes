package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i {
    public Map<String, Object> puc;
    public String type;
    public String uIG;
    public JSONObject uIH;
    Map<String, Object> uII = new HashMap();
    public String uIJ;

    public static class a {
        public static String a(String str, Map<String, Object> map, boolean z, String str2) {
            AppMethodBeat.i(9810);
            String a = a("callback", str, map, null, z, str2);
            AppMethodBeat.o(9810);
            return a;
        }

        public static String a(String str, JSONObject jSONObject, boolean z, String str2) {
            AppMethodBeat.i(9811);
            String a = a("event", str, null, jSONObject, z, str2);
            AppMethodBeat.o(9811);
            return a;
        }

        public static String b(String str, Map<String, Object> map, boolean z, String str2) {
            AppMethodBeat.i(9812);
            String a = a("event", str, map, null, z, str2);
            AppMethodBeat.o(9812);
            return a;
        }

        private static String a(String str, String str2, Map<String, Object> map, JSONObject jSONObject, boolean z, String str3) {
            AppMethodBeat.i(9813);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("__msg_type", str);
                if (str.equals("callback")) {
                    jSONObject2.put("__callback_id", str2);
                } else if (str.equals("event")) {
                    jSONObject2.put("__event_id", str2);
                }
                if (jSONObject == null) {
                    jSONObject2.put("__params", ao(map));
                } else {
                    jSONObject2.put("__params", jSONObject);
                }
                String m;
                if (z) {
                    m = m(jSONObject2, str3);
                    AppMethodBeat.o(9813);
                    return m;
                }
                m = jSONObject2.toString();
                AppMethodBeat.o(9813);
                return m;
            } catch (Exception e) {
                ab.e("MicroMsg.MsgWrapper", "build fail, exception = " + e.getMessage());
                AppMethodBeat.o(9813);
                return null;
            }
        }

        private static String m(JSONObject jSONObject, String str) {
            AppMethodBeat.i(9814);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("__json_message", jSONObject);
                ab.i("MicroMsg.MsgWrapper", "js digest verification contentStr = ", jSONObject.toString().replaceAll("\\\\/", "/"));
                ab.i("MicroMsg.MsgWrapper", "js digest verification shaStr = ", n.getSHA1(r1 + str));
                jSONObject2.put("__sha_key", r1);
                String jSONObject3 = jSONObject2.toString();
                AppMethodBeat.o(9814);
                return jSONObject3;
            } catch (Exception e) {
                ab.e("MicroMsg.MsgWrapper", "build fail, exception = " + e.getMessage());
                AppMethodBeat.o(9814);
                return null;
            }
        }

        public static JSONObject ao(Map<String, Object> map) {
            AppMethodBeat.i(9815);
            if (map == null || map.size() == 0) {
                JSONObject jSONObject = new JSONObject();
                AppMethodBeat.o(9815);
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
                AppMethodBeat.o(9815);
                return jSONObject2;
            } catch (Exception e) {
                ab.e("MicroMsg.MsgWrapper", "convertMapToJSON fail, exception = " + e.getMessage());
                AppMethodBeat.o(9815);
                return null;
            }
        }

        private static i agB(String str) {
            AppMethodBeat.i(9816);
            if (str == null || str.length() == 0) {
                ab.e("MicroMsg.MsgWrapper", "fromString fail, src is null");
                AppMethodBeat.o(9816);
                return null;
            }
            i iVar = new i();
            try {
                JSONObject jSONObject = new JSONObject(str);
                iVar.type = jSONObject.getString("__msg_type");
                iVar.uIG = jSONObject.getString("__callback_id");
                iVar.uIJ = jSONObject.getString("func");
                iVar.puc = new HashMap();
                JSONObject jSONObject2 = jSONObject.getJSONObject("params");
                iVar.uIH = jSONObject2;
                if (jSONObject2 != null) {
                    Iterator keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String str2 = (String) keys.next();
                        String string = jSONObject2.getString(str2);
                        if (string == null) {
                            string = "";
                        }
                        if ("urls".equalsIgnoreCase(str2)) {
                            ab.v("MicroMsg.MsgWrapper", "key is JSONArray, %s", str2);
                            try {
                                JSONArray jSONArray = new JSONArray(string);
                                String[] strArr = new String[jSONArray.length()];
                                for (int i = 0; i < strArr.length; i++) {
                                    strArr[i] = jSONArray.getString(i);
                                }
                                iVar.puc.put(str2, strArr);
                            } catch (Exception e) {
                                ab.e("MicroMsg.MsgWrapper", "parse JSONArray fail, ex = %s", e.getMessage());
                            }
                        } else {
                            iVar.puc.put(str2, string);
                        }
                    }
                }
                AppMethodBeat.o(9816);
                return iVar;
            } catch (Exception e2) {
                ab.e("MicroMsg.MsgWrapper", "fromString fail, exception = " + e2.getMessage());
                AppMethodBeat.o(9816);
                return null;
            }
        }

        static List<i> i(String str, boolean z, String str2) {
            AppMethodBeat.i(9817);
            if (str == null || str.length() == 0) {
                ab.e("MicroMsg.MsgWrapper", "getMsgList fail, src is null");
                AppMethodBeat.o(9817);
                return null;
            }
            JSONArray jSONArray;
            if (z) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONArray jSONArray2 = jSONObject.getJSONArray("__json_message");
                    if (jSONObject.getString("__sha_key").equals(n.getSHA1(jSONArray2.toString().replaceAll("\\\\/", "/") + str2))) {
                        jSONArray = jSONArray2;
                    } else {
                        ab.e("MicroMsg.MsgWrapper", "fromString SHA1 verification failed, sha1Str = %s, calSha1Str = %s, jsonList = %s", jSONObject.getString("__sha_key"), n.getSHA1(jSONArray2.toString().replaceAll("\\\\/", "/") + str2), jSONArray2.toString().replaceAll("\\\\/", "/"));
                        h.pYm.a(894, 6, 1, false);
                        AppMethodBeat.o(9817);
                        return null;
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.MsgWrapper", "dealMsgQueue fail, exception = " + e.getMessage());
                    AppMethodBeat.o(9817);
                    return null;
                }
            }
            jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                AppMethodBeat.o(9817);
                return null;
            }
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < jSONArray.length(); i++) {
                linkedList.add(agB(jSONArray.getString(i)));
            }
            AppMethodBeat.o(9817);
            return linkedList;
        }
    }

    public i() {
        AppMethodBeat.i(9818);
        AppMethodBeat.o(9818);
    }

    public final Map<String, Object> dcO() {
        return this.uII;
    }

    public static Bundle aP(Map<String, Object> map) {
        AppMethodBeat.i(9819);
        if (map == null || map.size() == 0) {
            AppMethodBeat.o(9819);
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
        AppMethodBeat.o(9819);
        return bundle;
    }

    public static Map<String, Object> aq(Bundle bundle) {
        AppMethodBeat.i(9820);
        if (bundle == null) {
            AppMethodBeat.o(9820);
            return null;
        }
        Set<String> keySet = bundle.keySet();
        if (keySet == null) {
            AppMethodBeat.o(9820);
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : keySet) {
            hashMap.put(str, bundle.get(str));
        }
        AppMethodBeat.o(9820);
        return hashMap;
    }
}
