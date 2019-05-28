package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class k {
    private static final HashSet<String> uzp;

    static final class a extends JSONObject {
        public a(Object obj) {
            AppMethodBeat.i(8202);
            if (obj instanceof String) {
                put("type", 1);
                put("val", obj);
                AppMethodBeat.o(8202);
            } else if (obj instanceof Integer) {
                put("type", 2);
                put("val", obj);
                AppMethodBeat.o(8202);
            } else if (obj instanceof Long) {
                put("type", 3);
                put("val", obj);
                AppMethodBeat.o(8202);
            } else if (obj instanceof Boolean) {
                put("type", 4);
                put("val", obj);
                AppMethodBeat.o(8202);
            } else {
                ab.w("MicroMsg.WebViewBagIntentLogic", "put not support type;class:%s", obj.getClass());
                put("type", 0);
                put("val", obj);
                AppMethodBeat.o(8202);
            }
        }

        static void a(Bundle bundle, String str, JSONObject jSONObject) {
            AppMethodBeat.i(8203);
            try {
                ab.i("MicroMsg.WebViewBagIntentLogic", "restoreToBundle key:%s type：%d", str, Integer.valueOf(jSONObject.getInt("type")));
                switch (jSONObject.getInt("type")) {
                    case 1:
                        bundle.putString(str, jSONObject.getString("val"));
                        AppMethodBeat.o(8203);
                        return;
                    case 2:
                        bundle.putInt(str, jSONObject.getInt("val"));
                        AppMethodBeat.o(8203);
                        return;
                    case 3:
                        bundle.putLong(str, jSONObject.getLong("val"));
                        AppMethodBeat.o(8203);
                        return;
                    case 4:
                        bundle.putBoolean(str, jSONObject.getBoolean("val"));
                        AppMethodBeat.o(8203);
                        return;
                    default:
                        ab.w("MicroMsg.WebViewBagIntentLogic", "not support type");
                        AppMethodBeat.o(8203);
                        return;
                }
            } catch (JSONException e) {
                ab.e("MicroMsg.WebViewBagIntentLogic", "restoreToBundle e:%s", e);
                AppMethodBeat.o(8203);
            }
            ab.e("MicroMsg.WebViewBagIntentLogic", "restoreToBundle e:%s", e);
            AppMethodBeat.o(8203);
        }
    }

    public static JSONObject ae(Bundle bundle) {
        AppMethodBeat.i(8204);
        JSONObject jSONObject = new JSONObject();
        if (bundle == null) {
            AppMethodBeat.o(8204);
            return jSONObject;
        }
        try {
            for (String str : bundle.keySet()) {
                jSONObject.put(str, new a(bundle.get(str)));
            }
        } catch (JSONException e) {
            ab.e("MicroMsg.WebViewBagIntentLogic", "save exp:%s", e);
        }
        AppMethodBeat.o(8204);
        return jSONObject;
    }

    public static void a(Intent intent, JSONObject jSONObject) {
        AppMethodBeat.i(8205);
        if (jSONObject == null) {
            AppMethodBeat.o(8205);
            return;
        }
        Iterator keys = jSONObject.keys();
        if (keys == null) {
            AppMethodBeat.o(8205);
            return;
        }
        Bundle bundle = new Bundle();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            try {
                a.a(bundle, str, jSONObject.getJSONObject(str));
            } catch (JSONException e) {
            }
        }
        intent.putExtras(bundle);
        AppMethodBeat.o(8205);
    }

    public static Bundle aC(Intent intent) {
        AppMethodBeat.i(8206);
        Bundle extras = intent.getExtras();
        Bundle bundle = new Bundle();
        if (extras == null) {
            AppMethodBeat.o(8206);
            return bundle;
        }
        for (String str : extras.keySet()) {
            if (uzp.contains(str)) {
                Object obj = extras.get(str);
                if (obj instanceof String) {
                    bundle.putString(str, (String) obj);
                } else if (obj instanceof Integer) {
                    bundle.putInt(str, ((Integer) obj).intValue());
                } else if (obj instanceof Long) {
                    bundle.putLong(str, ((Long) obj).longValue());
                } else if (obj instanceof Boolean) {
                    bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                } else {
                    ab.w("MicroMsg.WebViewBagIntentLogic", "put not support type; key:%s", str);
                }
            }
        }
        AppMethodBeat.o(8206);
        return bundle;
    }

    static {
        AppMethodBeat.i(8207);
        HashSet hashSet = new HashSet();
        uzp = hashSet;
        hashSet.add("title");
        uzp.add("webpageTitle");
        uzp.add("srcUsername");
        uzp.add("srcDisplayname");
        uzp.add("mode");
        uzp.add("KTemplateId");
        uzp.add("KPublisherId");
        AppMethodBeat.o(8207);
    }
}
