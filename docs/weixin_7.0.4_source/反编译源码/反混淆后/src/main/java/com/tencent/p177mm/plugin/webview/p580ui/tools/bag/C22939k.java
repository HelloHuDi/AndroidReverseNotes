package com.tencent.p177mm.plugin.webview.p580ui.tools.bag;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.k */
public final class C22939k {
    private static final HashSet<String> uzp;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.k$a */
    static final class C22940a extends JSONObject {
        public C22940a(Object obj) {
            AppMethodBeat.m2504i(8202);
            if (obj instanceof String) {
                put("type", 1);
                put("val", obj);
                AppMethodBeat.m2505o(8202);
            } else if (obj instanceof Integer) {
                put("type", 2);
                put("val", obj);
                AppMethodBeat.m2505o(8202);
            } else if (obj instanceof Long) {
                put("type", 3);
                put("val", obj);
                AppMethodBeat.m2505o(8202);
            } else if (obj instanceof Boolean) {
                put("type", 4);
                put("val", obj);
                AppMethodBeat.m2505o(8202);
            } else {
                C4990ab.m7421w("MicroMsg.WebViewBagIntentLogic", "put not support type;class:%s", obj.getClass());
                put("type", 0);
                put("val", obj);
                AppMethodBeat.m2505o(8202);
            }
        }

        /* renamed from: a */
        static void m34819a(Bundle bundle, String str, JSONObject jSONObject) {
            AppMethodBeat.m2504i(8203);
            try {
                C4990ab.m7417i("MicroMsg.WebViewBagIntentLogic", "restoreToBundle key:%s type：%d", str, Integer.valueOf(jSONObject.getInt("type")));
                switch (jSONObject.getInt("type")) {
                    case 1:
                        bundle.putString(str, jSONObject.getString("val"));
                        AppMethodBeat.m2505o(8203);
                        return;
                    case 2:
                        bundle.putInt(str, jSONObject.getInt("val"));
                        AppMethodBeat.m2505o(8203);
                        return;
                    case 3:
                        bundle.putLong(str, jSONObject.getLong("val"));
                        AppMethodBeat.m2505o(8203);
                        return;
                    case 4:
                        bundle.putBoolean(str, jSONObject.getBoolean("val"));
                        AppMethodBeat.m2505o(8203);
                        return;
                    default:
                        C4990ab.m7420w("MicroMsg.WebViewBagIntentLogic", "not support type");
                        AppMethodBeat.m2505o(8203);
                        return;
                }
            } catch (JSONException e) {
                C4990ab.m7413e("MicroMsg.WebViewBagIntentLogic", "restoreToBundle e:%s", e);
                AppMethodBeat.m2505o(8203);
            }
            C4990ab.m7413e("MicroMsg.WebViewBagIntentLogic", "restoreToBundle e:%s", e);
            AppMethodBeat.m2505o(8203);
        }
    }

    /* renamed from: ae */
    public static JSONObject m34818ae(Bundle bundle) {
        AppMethodBeat.m2504i(8204);
        JSONObject jSONObject = new JSONObject();
        if (bundle == null) {
            AppMethodBeat.m2505o(8204);
            return jSONObject;
        }
        try {
            for (String str : bundle.keySet()) {
                jSONObject.put(str, new C22940a(bundle.get(str)));
            }
        } catch (JSONException e) {
            C4990ab.m7413e("MicroMsg.WebViewBagIntentLogic", "save exp:%s", e);
        }
        AppMethodBeat.m2505o(8204);
        return jSONObject;
    }

    /* renamed from: a */
    public static void m34816a(Intent intent, JSONObject jSONObject) {
        AppMethodBeat.m2504i(8205);
        if (jSONObject == null) {
            AppMethodBeat.m2505o(8205);
            return;
        }
        Iterator keys = jSONObject.keys();
        if (keys == null) {
            AppMethodBeat.m2505o(8205);
            return;
        }
        Bundle bundle = new Bundle();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            try {
                C22940a.m34819a(bundle, str, jSONObject.getJSONObject(str));
            } catch (JSONException e) {
            }
        }
        intent.putExtras(bundle);
        AppMethodBeat.m2505o(8205);
    }

    /* renamed from: aC */
    public static Bundle m34817aC(Intent intent) {
        AppMethodBeat.m2504i(8206);
        Bundle extras = intent.getExtras();
        Bundle bundle = new Bundle();
        if (extras == null) {
            AppMethodBeat.m2505o(8206);
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
                    C4990ab.m7421w("MicroMsg.WebViewBagIntentLogic", "put not support type; key:%s", str);
                }
            }
        }
        AppMethodBeat.m2505o(8206);
        return bundle;
    }

    static {
        AppMethodBeat.m2504i(8207);
        HashSet hashSet = new HashSet();
        uzp = hashSet;
        hashSet.add("title");
        uzp.add("webpageTitle");
        uzp.add("srcUsername");
        uzp.add("srcDisplayname");
        uzp.add("mode");
        uzp.add("KTemplateId");
        uzp.add("KPublisherId");
        AppMethodBeat.m2505o(8207);
    }
}
