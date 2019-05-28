package com.facebook.internal;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class BundleJSONConverter {
    private static final Map<Class<?>, Setter> SETTERS;

    public interface Setter {
        void setOnBundle(Bundle bundle, String str, Object obj);

        void setOnJSON(JSONObject jSONObject, String str, Object obj);
    }

    /* renamed from: com.facebook.internal.BundleJSONConverter$6 */
    static class C165106 implements Setter {
        C165106() {
        }

        public final void setOnBundle(Bundle bundle, String str, Object obj) {
            AppMethodBeat.m2504i(72260);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unexpected type from JSON");
            AppMethodBeat.m2505o(72260);
            throw illegalArgumentException;
        }

        public final void setOnJSON(JSONObject jSONObject, String str, Object obj) {
            AppMethodBeat.m2504i(72261);
            JSONArray jSONArray = new JSONArray();
            for (Object put : (String[]) obj) {
                jSONArray.put(put);
            }
            jSONObject.put(str, jSONArray);
            AppMethodBeat.m2505o(72261);
        }
    }

    /* renamed from: com.facebook.internal.BundleJSONConverter$7 */
    static class C165117 implements Setter {
        C165117() {
        }

        public final void setOnBundle(Bundle bundle, String str, Object obj) {
            AppMethodBeat.m2504i(72262);
            JSONArray jSONArray = (JSONArray) obj;
            ArrayList arrayList = new ArrayList();
            if (jSONArray.length() == 0) {
                bundle.putStringArrayList(str, arrayList);
                AppMethodBeat.m2505o(72262);
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < jSONArray.length()) {
                    Object obj2 = jSONArray.get(i2);
                    if (obj2 instanceof String) {
                        arrayList.add((String) obj2);
                        i = i2 + 1;
                    } else {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unexpected type in an array: " + obj2.getClass());
                        AppMethodBeat.m2505o(72262);
                        throw illegalArgumentException;
                    }
                }
                bundle.putStringArrayList(str, arrayList);
                AppMethodBeat.m2505o(72262);
                return;
            }
        }

        public final void setOnJSON(JSONObject jSONObject, String str, Object obj) {
            AppMethodBeat.m2504i(72263);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("JSONArray's are not supported in bundles.");
            AppMethodBeat.m2505o(72263);
            throw illegalArgumentException;
        }
    }

    /* renamed from: com.facebook.internal.BundleJSONConverter$1 */
    static class C254871 implements Setter {
        C254871() {
        }

        public final void setOnBundle(Bundle bundle, String str, Object obj) {
            AppMethodBeat.m2504i(72250);
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            AppMethodBeat.m2505o(72250);
        }

        public final void setOnJSON(JSONObject jSONObject, String str, Object obj) {
            AppMethodBeat.m2504i(72251);
            jSONObject.put(str, obj);
            AppMethodBeat.m2505o(72251);
        }
    }

    /* renamed from: com.facebook.internal.BundleJSONConverter$2 */
    static class C372152 implements Setter {
        C372152() {
        }

        public final void setOnBundle(Bundle bundle, String str, Object obj) {
            AppMethodBeat.m2504i(72252);
            bundle.putInt(str, ((Integer) obj).intValue());
            AppMethodBeat.m2505o(72252);
        }

        public final void setOnJSON(JSONObject jSONObject, String str, Object obj) {
            AppMethodBeat.m2504i(72253);
            jSONObject.put(str, obj);
            AppMethodBeat.m2505o(72253);
        }
    }

    /* renamed from: com.facebook.internal.BundleJSONConverter$4 */
    static class C372164 implements Setter {
        C372164() {
        }

        public final void setOnBundle(Bundle bundle, String str, Object obj) {
            AppMethodBeat.m2504i(72256);
            bundle.putDouble(str, ((Double) obj).doubleValue());
            AppMethodBeat.m2505o(72256);
        }

        public final void setOnJSON(JSONObject jSONObject, String str, Object obj) {
            AppMethodBeat.m2504i(72257);
            jSONObject.put(str, obj);
            AppMethodBeat.m2505o(72257);
        }
    }

    /* renamed from: com.facebook.internal.BundleJSONConverter$3 */
    static class C415793 implements Setter {
        C415793() {
        }

        public final void setOnBundle(Bundle bundle, String str, Object obj) {
            AppMethodBeat.m2504i(72254);
            bundle.putLong(str, ((Long) obj).longValue());
            AppMethodBeat.m2505o(72254);
        }

        public final void setOnJSON(JSONObject jSONObject, String str, Object obj) {
            AppMethodBeat.m2504i(72255);
            jSONObject.put(str, obj);
            AppMethodBeat.m2505o(72255);
        }
    }

    /* renamed from: com.facebook.internal.BundleJSONConverter$5 */
    static class C415805 implements Setter {
        C415805() {
        }

        public final void setOnBundle(Bundle bundle, String str, Object obj) {
            AppMethodBeat.m2504i(72258);
            bundle.putString(str, (String) obj);
            AppMethodBeat.m2505o(72258);
        }

        public final void setOnJSON(JSONObject jSONObject, String str, Object obj) {
            AppMethodBeat.m2504i(72259);
            jSONObject.put(str, obj);
            AppMethodBeat.m2505o(72259);
        }
    }

    static {
        AppMethodBeat.m2504i(72266);
        HashMap hashMap = new HashMap();
        SETTERS = hashMap;
        hashMap.put(Boolean.class, new C254871());
        SETTERS.put(Integer.class, new C372152());
        SETTERS.put(Long.class, new C415793());
        SETTERS.put(Double.class, new C372164());
        SETTERS.put(String.class, new C415805());
        SETTERS.put(String[].class, new C165106());
        SETTERS.put(JSONArray.class, new C165117());
        AppMethodBeat.m2505o(72266);
    }

    public static JSONObject convertToJSON(Bundle bundle) {
        AppMethodBeat.m2504i(72264);
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                if (obj instanceof List) {
                    JSONArray jSONArray = new JSONArray();
                    for (String put : (List) obj) {
                        jSONArray.put(put);
                    }
                    jSONObject.put(str, jSONArray);
                } else if (obj instanceof Bundle) {
                    jSONObject.put(str, convertToJSON((Bundle) obj));
                } else {
                    Setter setter = (Setter) SETTERS.get(obj.getClass());
                    if (setter == null) {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported type: " + obj.getClass());
                        AppMethodBeat.m2505o(72264);
                        throw illegalArgumentException;
                    }
                    setter.setOnJSON(jSONObject, str, obj);
                }
            }
        }
        AppMethodBeat.m2505o(72264);
        return jSONObject;
    }

    public static Bundle convertToBundle(JSONObject jSONObject) {
        AppMethodBeat.m2504i(72265);
        Bundle bundle = new Bundle();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = jSONObject.get(str);
            if (!(obj == null || obj == JSONObject.NULL)) {
                if (obj instanceof JSONObject) {
                    bundle.putBundle(str, convertToBundle((JSONObject) obj));
                } else {
                    Setter setter = (Setter) SETTERS.get(obj.getClass());
                    if (setter == null) {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported type: " + obj.getClass());
                        AppMethodBeat.m2505o(72265);
                        throw illegalArgumentException;
                    }
                    setter.setOnBundle(bundle, str, obj);
                }
            }
        }
        AppMethodBeat.m2505o(72265);
        return bundle;
    }
}
